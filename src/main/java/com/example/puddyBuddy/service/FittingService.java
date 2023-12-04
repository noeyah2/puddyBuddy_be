package com.example.puddyBuddy.service;

import com.example.puddyBuddy.dto.Fitting.FittingRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



@Service
@RequiredArgsConstructor
public class FittingService {

    public FittingRes makeFittingImg(String imgUrl, String clothesId) throws IOException, ParseException {
        FittingRes fittingRes = new FittingRes();
        imgUrl = sendGetRequest(imgUrl, clothesId);
        fittingRes.setImgUrl(imgUrl);
        return fittingRes;
    }

    private static String sendGetRequest(String imageUrl, String clothesId) throws IOException, ParseException {
        String url = "http://localhost:5000/fitting";  // Flask 애플리케이션의 엔드포인트 URL

        // URL 및 파라미터 설정
        String params = "image_url=" + URLEncoder.encode(imageUrl, "UTF-8") + "&clothes_id=" + URLEncoder.encode(clothesId, "UTF-8");
        URL endpoint = new URL(url + "?" + params);

        // HTTP 연결 설정
        HttpURLConnection connection = (HttpURLConnection) endpoint.openConnection();
        connection.setRequestMethod("GET");

        // 응답 읽기
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        // JSON 파싱
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(response.toString());
        String imgURL = (String) jsonObject.get("img_url");

        // 연결 닫기
        connection.disconnect();
        return imgURL;
    }
}
