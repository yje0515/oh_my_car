package com.ohmycar.domain;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConsumableCalc {

    public ConsumableCalc() {
        super();
    }

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

    public ConsumableVO getNextConsumableVO(ConsumableVO next) throws IOException {
        InputStream input = new FileInputStream(
                "c:/SpringWorkSpace/oh_my_car/src/main/webapp/resources/json/consumableCycle.json");
        ObjectMapper objectMapper = new ObjectMapper();
        ConsumableCycle consumableCycle = objectMapper.readValue(input, ConsumableCycle.class);

        String st = consumableCycle.getAirConFilter();
        next.setAirConFilter(
                calcChangeDay(next.getAirConFilter(), st.substring(0, st.length() - 1), st.charAt(st.length() - 1)));
        st = consumableCycle.getBattery();
        next.setBattery(
                calcChangeDay(next.getBattery(), st.substring(0, st.length() - 1), st.charAt(st.length() - 1)));
        st = consumableCycle.getBreakOil();
        next.setBreakOil(
                calcChangeDay(next.getBreakOil(), st.substring(0, st.length() - 1), st.charAt(st.length() - 1)));
        st = consumableCycle.getBreakPad();
        next.setBreakPad(
                calcChangeDay(next.getBreakPad(), st.substring(0, st.length() - 1), st.charAt(st.length() - 1)));
        st = consumableCycle.getCoolingWater();
        next.setCoolingWater(
                calcChangeDay(next.getCoolingWater(), st.substring(0, st.length() - 1), st.charAt(st.length() - 1)));
        st = consumableCycle.getEngineOil();
        next.setEngineOil(
                calcChangeDay(next.getEngineOil(), st.substring(0, st.length() - 1), st.charAt(st.length() - 1)));
        st = consumableCycle.getFluidClutch();
        next.setFluidClutch(
                calcChangeDay(next.getFluidClutch(), st.substring(0, st.length() - 1), st.charAt(st.length() - 1)));
        st = consumableCycle.getPowerSteeringOil();
        next.setPowerSteeringOil(
                calcChangeDay(next.getPowerSteeringOil(), st.substring(0, st.length() - 1),
                        st.charAt(st.length() - 1)));
        st = consumableCycle.getSparkPlug();
        next.setSparkPlug(
                calcChangeDay(next.getSparkPlug(), st.substring(0, st.length() - 1), st.charAt(st.length() - 1)));
        st = consumableCycle.getTire();
        next.setTire(
                calcChangeDay(next.getTire(), st.substring(0, st.length() - 1), st.charAt(st.length() - 1)));
        st = consumableCycle.getTransmissionOil();
        next.setTransmissionOil(
                calcChangeDay(next.getTransmissionOil(), st.substring(0, st.length() - 1), st.charAt(st.length() - 1)));
        st = consumableCycle.getWiper();
        next.setWiper(
                calcChangeDay(next.getWiper(), st.substring(0, st.length() - 1), st.charAt(st.length() - 1)));
        return next;

    }

    public String getAccDist() {
        StringBuilder sb = new StringBuilder();
        String responseData = "";

        String token = "Bearer "
                + "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJ1aWQiOiI2NjRkYWZjZC05NmVhLTRhZjctOGI0MC1iYTYyNzgwNzI4ODciLCJpc3MiOiJibHVlbGluayIsInBpZCI6IjYyYTk3NmZhYmI4YjVkZTg5YzYzYjhmYiIsImV4cCI6NDEwMjMyNjAwMCwibGF0IjoxNzE1MTI4NDkzLCJzaWQiOiI0MDBiMzIzMS0zMGRiLTQyZjUtYWI1Mi05ZDY5YjM1YTE4NGQifQ.pZuBsie3in_l-TqVBtFPlXWgvQHbbF62yVPRfZvaJ0CCthBAlgp0Au4yxIt9ETE1S5O86EVi2y7VnkWstig-zo3pNW4BT22snQ-GshmSJ_NfOf_s5ollcqjNdqKNVmF588xP9pdWKnBB3hb_YLZLFGhUDjGaOI684mq4CCZ7V_vggTlaaXZZ6ycNvk58WhT5cpKccfHa6KkTFJhFwOJiKaG-z6snhPO33RIuNxwtrC7AikVu4B71guIJmBHcZ31HPjqVcAZwU2AR3eLNCk7XHdFFZR2gQUpGvaw81ECd1F48LSnvAY60MrsyH-nnO_sxNI8sakqGuMoSv8_Le_J5Qw";
        String carID = "6d97337b-eb53-467b-baf4-7faec6d7065e";
        String contentType = "application/json";
        try {
            String apiURL = "https://dev.kr-ccapi.hyundai.com/api_sample/v1/car/status/" + carID + "/odometer";
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
}
