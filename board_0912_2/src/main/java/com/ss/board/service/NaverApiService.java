package com.ss.board.service;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

            List<String> crawlingResults = getCrawling();

            // 크롤링으로 문장 가져오기
            // 결과가 null이 아닌지, 그리고 리스트의 크기가 2 이상인지 확인
            if (crawlingResults != null && crawlingResults.size() >= 2) {
                String title = crawlingResults.get(0); // 첫 번째 요소, 제목
                String content = crawlingResults.get(1); // 두 번째 요소, 내용

                // 제목과 내용을 출력 혹은 처리
                System.out.println("Title: " + title);
                System.out.println("Content: " + content);


            // 요청 header
            HttpHeaders headers = new HttpHeaders();

            headers.set("X-NCP-APIGW-API-KEY-ID", clientId);
            headers.set("X-NCP-APIGW-API-KEY", clientSecret);
            headers.set("Content-Type", "application/json");

            // 요청 body
            Map<String, Object> document = new HashMap<String, Object>();
            document.put("title", title);
            document.put("content", content);

            // option object
            Map<String, Object> option = new HashMap<String, Object>();
            option.put("language","ko");
            option.put("model","news");
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

            } else {
                System.out.println("크롤링 결과가 없거나 예상한 데이터를 찾지 못했습니다.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return summary;
    }

    // 크롤링
    public List<String> getCrawling() {
        String titleText = "";
        String contentText = "";

        List<String> crawlingList = new ArrayList<>();
        try {
            String url = "https://m.entertain.naver.com/article/311/0001770953";

            // json 사이트 문서 가져오기
            Document doc = Jsoup.connect(url).get();

            // 원하는 요소 선택하기
            Element title = doc.select("h2.NewsEndMain_article_title__kqEzS").first();
            Element content = doc.select("article#comp_news_article").first();
            System.out.println("크롤링 title : " + title);
            System.out.println("크롤링 content : " + content);

            titleText = title.text();
            contentText = content.text();
            System.out.println("titleText : " + titleText);
            System.out.println("contentText : " + contentText);

            crawlingList.add(titleText);
            crawlingList.add(contentText);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return crawlingList;
    }

}
