package com.ss.backend.google;

import com.ss.backend.dto.GoogleDTO;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@Slf4j
public class GoogleService {

    // properties파일의 구글 값들을 가져오기
    @Value("${google.client.id}")
    private String GOOGLE_CLIENT_ID;

    @Value("${google.client.secret}")
    private String GOOGLE_CLIENT_SECRET;

    @Value("${google.redirect.uri}")
    private String GOOGLE_REDIRECT_URL;

    private final static String GOOGLE_TOKEN_URI = "https://oauth2.googleapis.com/token";
    private final static String GOOGLE_USERINFO_URI = "https://www.googleapis.com/oauth2/v3/userinfo";

    private final RestTemplate rest = new RestTemplate();

    private final static String GOOGLE_AUTH_URI = "https://accounts.google.com/o/oauth2/auth";

    // UriComponentsBuilder : 스프링 프레임워크가 URL 쉽게 만들 수 있도록 제공
    public String getGoogleLogin() {

        return UriComponentsBuilder.fromHttpUrl(GOOGLE_AUTH_URI)
                .queryParam("client_id", GOOGLE_CLIENT_ID)
                .queryParam("redirect_uri", GOOGLE_REDIRECT_URL)
                .queryParam("response_type", "code")
                .queryParam("scope", "https://www.googleapis.com/auth/userinfo.profile https://www.googleapis.com/auth/userinfo.email")
                .build().toString();
    }

    // 구글에서 데이터(인가코드)를 받아서 고객 정보를 다시 한번 요청하기
    public void getGoogleInfo(String code) {
        log.info("getGoogleInfo");

        try {
            // 1. token 요청
            // - MultiValueMap : Map 차이는 하나의 키에 여러 개의 값을 허용할 수 있음.
            // Map은 하나의 key에 하나의 value만 연결할 수있는 자료구조!
            // http요청 파라미터,헤더 저장할 때

            // Map<String,String> map = new HashMap<String, String>();
            // map.put("key", "value1");
            // map.put("key", "value2");

            // MultiValueMap map2 = new LinkedMultiValueMap<K, V>();
            // map2.put("key", "value1");
            // map2.put("key", "value2"); {key=[value1,value2]}

            HttpEntity<MultiValueMap<String, String>> requestEntity = getGoogleRequestForToken(code);

            // 2. 전송
            ResponseEntity<String> resp = rest.exchange(GOOGLE_TOKEN_URI, HttpMethod.POST, requestEntity,
                    String.class);

            // 3. 응답 데이터에서 토근 꺼내기
            String accessToken = exaccessToken(resp.getBody());

            // 4. 사용자 정보 접근하기
            GoogleDTO dto = getUserInfoWithToken(accessToken);
            log.info("getGoogleInfo: dto: " + dto);

        } catch (Exception e) {
            e.printStackTrace();
        }

        log.info("실행 결과 : {}", code);
    }

    private GoogleDTO getUserInfoWithToken(String accessToken) throws ParseException{

        // 헤더 생성
        HttpHeaders headers = createHeadersToken(accessToken);

        // 사용자 정보 요청
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(headers);

        ResponseEntity<String> resp = rest.exchange(GOOGLE_USERINFO_URI, HttpMethod.POST, entity, String.class);

        // 파싱
        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject) parser.parse(resp.getBody());

        String id = String.valueOf(obj.get("sub"));
        String email = String.valueOf(obj.get("email"));
        String name = String.valueOf(obj.get("name"));
        String picture = String.valueOf(obj.get("picture"));

        return GoogleDTO.builder()
                .id(id)
                .email(email)
                .name(name)
                .build();
    }

    private HttpHeaders createHeadersToken(String accessToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + accessToken);
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        return headers;
    }

    private String exaccessToken(String body) throws ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(body);
        return (String) jsonObject.get("access_token");

    }

    private HttpEntity<MultiValueMap<String, String>> getGoogleRequestForToken(String code) {
        log.info("getGoogleRequestForToken()");

        HttpHeaders headers = getHeaders();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();

        params.add("client_id", GOOGLE_CLIENT_ID);
        params.add("client_secret", GOOGLE_CLIENT_SECRET);
        params.add("redirect_uri", GOOGLE_REDIRECT_URL);
        params.add("code", code);
        params.add("grant_type", "authorization_code");

        return new HttpEntity<>(params, headers);
    }

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();

        headers.add("content-type", "application/x-www-form-urlencoded");
        return headers;
    }
}
