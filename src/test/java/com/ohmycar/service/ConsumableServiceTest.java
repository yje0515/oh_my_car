package com.ohmycar.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import javax.annotation.processing.Generated;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ohmycar.domain.ConsumableVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ConsumableServiceTest {
    @Autowired
    private ConsumableService service;

    @Test
    public void testcreate() throws Exception {
        ConsumableVO vo = new ConsumableVO();
        vo.setCarId("6d97337b-eb53-467b-baf4-7faec6d7065e");
        vo.setEngineOil("0");
        vo.setAirConFilter("0");
        vo.setBreakOil("0");
        vo.setBreakPad("0");
        vo.setWiper("2023-04-03");
        vo.setTire("0");
        vo.setCoolingWater("0");
        vo.setTransmissionOil("0");
        vo.setPowerSteeringOil("2023-04-03");
        vo.setSparkPlug("2023-04-03");
        vo.setFluidClutch("0");
        vo.setBattery("2023-04-03");
        // String accessToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJ1aWQiOiI2NjRkYWZjZC05NmVhLTRhZjctOGI0MC1iYTYyNzgwNzI4ODciLCJpc3MiOiJibHVlbGluayIsInBpZCI6IjYyYTk3NmZhYmI4YjVkZTg5YzYzYjhmYiIsImV4cCI6NDEwMjMyNjAwMCwibGF0IjoxNzE0NTI1NzAzLCJzaWQiOiI0MDBiMzIzMS0zMGRiLTQyZjUtYWI1Mi05ZDY5YjM1YTE4NGQifQ.jQs641tZ9W9eidkTaGBygdRBvygWcojsFzxj92Z1493J8BAHgjMGpx1r6dWWMACBYLM7reROl59wDoaBlw8vqRKUU-Q1lmettmtBDKNsyjJya9Dwbht1vLMqds-eG6oFyY1SW5Ri6GQZ1F69UL0qJQpmiDksu1iSVEtVpzm3mLSzQpELuRJH1RsxWjBIWEgXopZIczQiLtjQDgY2Dkmq7VuT1hGPLAoQHeoihxxQo_bbLLEB1WQT1lY5nx6XwRfG7I6y0MF2gGOBNJrJNZy2BFXQvLm8ZWDVjrqNb4LVS1Vjh3DRXminBKDBDAz0Hyz7xfT4sFvouD2IdJmNQiUxrQ";
        // StringBuilder sb;
        // String responseData = "";

        // String token = "Bearer " + accessToken;
        // String carID = vo.getCarId();
        // String contentType = "application/json";
        // log.info(accessToken);
        // log.info(carID);
        // try {
        //     String apiURL = "https://dev.kr-ccapi.hyundai.com/api/v1/car/status/" + carID + "/odometer";
        //     URL url = new URL(apiURL);

        //     HttpURLConnection con = (HttpURLConnection) url.openConnection();
        //     con.setRequestMethod("GET");

        //     // Set Header Info
        //     con.setRequestProperty("Authorization", token);
        //     con.setRequestProperty("Content-Type", contentType);

        //     int responseCode = con.getResponseCode();
        //     BufferedReader br;
        //     if (responseCode == HttpURLConnection.HTTP_OK) {
        //         br = new BufferedReader(new InputStreamReader(con.getInputStream())); // 정상호출
        //         log.info("success");
        //     } else {
        //         br = new BufferedReader(new InputStreamReader(con.getErrorStream())); // 에러발생
        //         log.info("error");
        //     }

        //     sb = new StringBuilder();
        //     while ((responseData = br.readLine()) != null) {
        //         sb.append(responseData);
        //     }
        //     br.close();

        //     log.info(sb.toString());

        // } catch (Exception e) {
        //     log.error(e);
        // }

        log.info(vo);
        service.create(vo);
    }

    @Generated("jsonschema2pojo")
    public class Example {

        @SerializedName("msgId")
        @Expose
        private String msgId;
        @SerializedName("odometers")
        @Expose
        private List<Odometer> odometers;

        /**
         * No args constructor for use in serialization
         *
         */
        public Example() {
        }

        /**
         *
         * @param msgId
         * @param odometers
         */
        public Example(String msgId, List<Odometer> odometers) {
            super();
            this.msgId = msgId;
            this.odometers = odometers;
        }

        public String getMsgId() {
            return msgId;
        }

        public void setMsgId(String msgId) {
            this.msgId = msgId;
        }

        public List<Odometer> getOdometers() {
            return odometers;
        }

        public void setOdometers(List<Odometer> odometers) {
            this.odometers = odometers;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(Example.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
                    .append('[');
            sb.append("msgId");
            sb.append('=');
            sb.append(((this.msgId == null) ? "<null>" : this.msgId));
            sb.append(',');
            sb.append("odometers");
            sb.append('=');
            sb.append(((this.odometers == null) ? "<null>" : this.odometers));
            sb.append(',');
            if (sb.charAt((sb.length() - 1)) == ',') {
                sb.setCharAt((sb.length() - 1), ']');
            } else {
                sb.append(']');
            }
            return sb.toString();
        }
    }

    @Generated("jsonschema2pojo")
    public class Odometer {

        @SerializedName("date")
        @Expose
        private String date;
        @SerializedName("unit")
        @Expose
        private Integer unit;
        @SerializedName("value")
        @Expose
        private Double value;
        @SerializedName("timestamp")
        @Expose
        private String timestamp;

        /**
         * No args constructor for use in serialization
         *
         */
        public Odometer() {
        }

        /**
         *
         * @param date
         * @param unit
         * @param value
         * @param timestamp
         */
        public Odometer(String date, Integer unit, Double value, String timestamp) {
            super();
            this.date = date;
            this.unit = unit;
            this.value = value;
            this.timestamp = timestamp;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public Integer getUnit() {
            return unit;
        }

        public void setUnit(Integer unit) {
            this.unit = unit;
        }

        public Double getValue() {
            return value;
        }

        public void setValue(Double value) {
            this.value = value;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(Odometer.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
                    .append('[');
            sb.append("date");
            sb.append('=');
            sb.append(((this.date == null) ? "<null>" : this.date));
            sb.append(',');
            sb.append("unit");
            sb.append('=');
            sb.append(((this.unit == null) ? "<null>" : this.unit));
            sb.append(',');
            sb.append("value");
            sb.append('=');
            sb.append(((this.value == null) ? "<null>" : this.value));
            sb.append(',');
            sb.append("timestamp");
            sb.append('=');
            sb.append(((this.timestamp == null) ? "<null>" : this.timestamp));
            sb.append(',');
            if (sb.charAt((sb.length() - 1)) == ',') {
                sb.setCharAt((sb.length() - 1), ']');
            } else {
                sb.append(']');
            }
            return sb.toString();
        }
    }

    @Test
    public void test() {
        String jsonStr = "{\"msgId\": \"68cebe5d-6bba-40cd-a872-da871f4f786d\",\"odometers\": [{\"date\": \"20240501\",\"unit\": 1,\"value\": 120144.7,\"timestamp\": \"20211102112408\"}]}";
        // Gson 객체 생성
        Gson gson = new Gson();
        // Json 문자열 -> class
        Example ex = gson.fromJson(jsonStr, Example.class);
        log.info(ex);
    }
}
