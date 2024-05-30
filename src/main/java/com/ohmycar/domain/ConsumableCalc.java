package com.ohmycar.domain;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 부품 교체 시기 에 관한 계산을 하는 클래스
 */
public class ConsumableCalc {

    public ConsumableCalc() {
        super();
    }

    /**
     * json 데이터를 읽어 교체시기를 계산 하는 함수
     * 
     * @param before 교체한 시기 혹은 거리
     * @param cycle  교체 주기
     * @param op     교체 주기가 날짜 형식인지 거리 형식인지 알기 위해 적어두는 operator
     * @return 교체 시기 혹은 거리가 담긴 String
     */
    private String calcChangeDay(String before, String cycle, char op) {
        if (op == 'y') {
            int next = (int) (Double.parseDouble(cycle) * 12);
            LocalDate date = LocalDate.parse(before, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            date = date.plusMonths(next);
            return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } else if (op == 'k') {
            double beforeNum = Double.parseDouble(before);
            double cycleNum = Double.parseDouble(cycle);
            double next = beforeNum + cycleNum;
            return String.valueOf(next);
        } else {
            return "unknown";
        }
    }

    /**
     * consumableVO 에 담긴 교체한 시기 혹은 거리에 json 데이터를 읽어와
     * calcChangeDay 함수로 교체 시기 혹은 거리 를 담아 반환 하는 함수
     * 
     * @param next 교체한 시기가 담긴 consumableVO
     * @return 교체 시기가 담긴 consumableVO
     * @throws IOException json 데이터를 읽어올 때 발생하는 예외 json 데이터의 형식이 다르면 뜬다.
     */
    public ConsumableVO getNextConsumableVO(ConsumableVO prev) throws IOException {
        InputStream input = new FileInputStream(
                "c:/SpringWorkSpace/oh_my_car/src/main/webapp/resources/json/consumableCycle.json");
        ObjectMapper objectMapper = new ObjectMapper();
        ConsumableCycle consumableCycle = objectMapper.readValue(input, ConsumableCycle.class);
        ConsumableVO next = new ConsumableVO();

        String st = consumableCycle.getAirConFilter();
        next.setAirConFilter(
                calcChangeDay(prev.getAirConFilter(), st.substring(0, st.length() - 1), st.charAt(st.length() - 1)));
        st = consumableCycle.getBattery();
        next.setBattery(
                calcChangeDay(prev.getBattery(), st.substring(0, st.length() - 1), st.charAt(st.length() - 1)));
        st = consumableCycle.getBreakOil();
        next.setBreakOil(
                calcChangeDay(prev.getBreakOil(), st.substring(0, st.length() - 1), st.charAt(st.length() - 1)));
        st = consumableCycle.getBreakPad();
        next.setBreakPad(
                calcChangeDay(prev.getBreakPad(), st.substring(0, st.length() - 1), st.charAt(st.length() - 1)));
        st = consumableCycle.getCoolingWater();
        next.setCoolingWater(
                calcChangeDay(prev.getCoolingWater(), st.substring(0, st.length() - 1), st.charAt(st.length() - 1)));
        st = consumableCycle.getEngineOil();
        next.setEngineOil(
                calcChangeDay(prev.getEngineOil(), st.substring(0, st.length() - 1), st.charAt(st.length() - 1)));
        st = consumableCycle.getFluidClutch();
        next.setFluidClutch(
                calcChangeDay(prev.getFluidClutch(), st.substring(0, st.length() - 1), st.charAt(st.length() - 1)));
        st = consumableCycle.getPowerSteeringOil();
        next.setPowerSteeringOil(
                calcChangeDay(prev.getPowerSteeringOil(), st.substring(0, st.length() - 1),
                        st.charAt(st.length() - 1)));
        st = consumableCycle.getSparkPlug();
        next.setSparkPlug(
                calcChangeDay(prev.getSparkPlug(), st.substring(0, st.length() - 1), st.charAt(st.length() - 1)));
        st = consumableCycle.getTire();
        next.setTire(
                calcChangeDay(prev.getTire(), st.substring(0, st.length() - 1), st.charAt(st.length() - 1)));
        st = consumableCycle.getTransmissionOil();
        next.setTransmissionOil(
                calcChangeDay(prev.getTransmissionOil(), st.substring(0, st.length() - 1), st.charAt(st.length() - 1)));
        st = consumableCycle.getWiper();
        next.setWiper(
                calcChangeDay(prev.getWiper(), st.substring(0, st.length() - 1), st.charAt(st.length() - 1)));
        return next;

    }

    /**
     * 현재 주행거리를 반환 하는 함수
     * 
     * @return 현재 누적 주행 거리
     */
    public String getAccDist(String token, String carID) {
        StringBuilder sb = new StringBuilder();
        String responseData = "";

        String contentType = "application/json";
        try {
            String apiURL = "https://dev.kr-ccapi.hyundai.com/api/v1/car/status/" + carID + "/odometer";
            URL url = new URL(apiURL);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            // Set Header Info
            con.setRequestProperty("Authorization", token);
            con.setRequestProperty("Content-Type", contentType);

            int responseCode = con.getResponseCode();
            BufferedReader br;
            if (responseCode == HttpURLConnection.HTTP_OK) {
                br = new BufferedReader(new InputStreamReader(con.getInputStream())); // 정상호출
            } else {
                br = new BufferedReader(new InputStreamReader(con.getErrorStream())); // 에러발생
            }

            sb = new StringBuilder();
            while ((responseData = br.readLine()) != null) {
                sb.append(responseData);
            }
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        ObjectMapper mapper = new ObjectMapper();
        ConsumableOdometer conOdo = new ConsumableOdometer();
        try {
            conOdo = mapper.readValue(sb.toString(), ConsumableOdometer.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        double accDist = conOdo.getOdometers().get(0).getValue();

        return Double.toString(accDist);
    }

    public String getAccessToken(String code) throws IOException {

        String requestBody = "grant_type=authorization_code&code=" + code + "&redirect_uri=" + "http://localhost:8282";
        String tokenResponse = tokenAPICall(requestBody);

        ObjectMapper accessTokenObjectMapper = new ObjectMapper();
        JsonNode tokenRoot = accessTokenObjectMapper.readTree(tokenResponse);
        return tokenRoot.path("access_token").asText();
    }

    public String tokenAPICall(String requestBody) {

        StringBuilder sb = new StringBuilder();
        String responseData = "";

        String apiURL = "https://prd.kr-ccapi.hyundai.com/api/v1/user/oauth2/token";

        String token = "Basic "
                + Base64.getEncoder().encodeToString(("t400b3231-30db-42f5-ab52-9d69b35a184d" + ":"
                        + "NeeIVzC6EIl8m8p3Kh65CWP4C8cZYQhvW9zlBrZZzfolh2Ox").getBytes());
        String contentType = "application/x-www-form-urlencoded";

        try {
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");

            // Set Header Info
            con.setRequestProperty("Authorization", token);
            con.setRequestProperty("Content-Type", contentType);

            // Body data 전송
            con.setDoOutput(true);
            DataOutputStream output = new DataOutputStream(con.getOutputStream());
            output.writeBytes(requestBody);
            output.flush();
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if (responseCode == HttpURLConnection.HTTP_OK) {
                br = new BufferedReader(new InputStreamReader(con.getInputStream())); // 정상호출
            } else {
                br = new BufferedReader(new InputStreamReader(con.getErrorStream())); // 에러발생
            }

            sb = new StringBuilder();
            while ((responseData = br.readLine()) != null) {
                sb.append(responseData);
            }
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}
