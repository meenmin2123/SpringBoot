package com.ss.board.service;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

import java.util.HashMap;
import java.util.Map;

@Service
public class NaverApiService {

    @Value("${naver.client.id}")
    private String clientId;

    @Value("${naver.client.secret}")
    private String clientSecret;

    private RestTemplate rest;

    public String getSummary() {
        String summary = null;

        // url
        String urlApi = "https://naveropenapi.apigw.ntruss.com/text-summary/v1/summarize";
        try {
            rest = new RestTemplate();

            // 요청 header
            HttpHeaders headers = new HttpHeaders();

            headers.set("X-NCP-APIGW-API-KEY-ID", clientId);
            headers.set("X-NCP-APIGW-API-KEY", clientSecret);
            headers.set("Content-Type", "application/json");

            // 요청 body
            Map<String, Object> document = new HashMap<String, Object>();
            document.put("title", "'하루 2000억' 판 커지는 간편송금 시장");
            document.put("content", "간편송금 이용금액이 하루 평균 2000억원을 넘어섰다. 한국은행이 17일 발표한 '2019년 상반기중 전자지급서비스 이용 현황'에 따르면 올해 상반기 간편송금서비스 이용금액(일평균)은 지난해 하반기 대비 60.7% 증가한 2005억원으로 집계됐다. 같은 기간 이용건수(일평균)는 34.8% 늘어난 218만건이었다. 간편 송금 시장에는 선불전자지급서비스를 제공하는 전자금융업자와 금융기관 등이 참여하고 있다. 이용금액은 전자금융업자가 하루평균 1879억원, 금융기관이 126억원이었다. 한은은 카카오페이, 토스 등 간편송금 서비스를 제공하는 업체 간 경쟁이 심화되면서 이용규모가 크게 확대됐다고 분석했다. 국회 정무위원회 소속 바른미래당 유의동 의원에 따르면 카카오페이, 토스 등 선불전자지급서비스 제공업체는 지난해 마케팅 비용으로 1000억원 이상을 지출했다. 마케팅 비용 지출규모는 카카오페이가 491억원, 비바리퍼블리카(토스)가 134억원 등 순으로 많았다.");

            // option object
            Map<String, Object> option = new HashMap<String, Object>();
            option.put("language","ko");
            option.put("model","general");
            option.put("tone",2);
            option.put("summaryCount",3);

            // 위에서 설정한 두 내용을 합치기
            Map<String, Object> requestBody = new HashMap<String, Object>();
            requestBody.put("document",document);
            requestBody.put("option",option);

            // header + body
            HttpEntity<Map<String, Object>> request = new HttpEntity<Map<String, Object>>(requestBody, headers);

            // 전송해서 응답받기
            ResponseEntity<String> resp =  rest.exchange(urlApi, HttpMethod.POST, request, String.class);
            System.out.println("응답 : " + resp.getBody());

            // 파싱
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(resp.getBody());

            // "summary" 키워드 추출
            summary = (String) jsonObject.get("summary");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return summary;
    }

}
