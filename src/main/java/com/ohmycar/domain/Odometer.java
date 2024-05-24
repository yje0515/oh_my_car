
package com.ohmycar.domain;

import lombok.Data;

/**
 * 누적 주행거리 API 를 요청 했을때 오는
 * 누적 주행거리가 담긴 Data 객체
 */
@Data
public class Odometer {
    /**
     * 조회 일자(YYYYMMDD) 현재다.
     */
    private String date;
    /**
     * 단위 (0: feet, 1: km, 2: meter, 3: miles)
     */
    private Integer unit;
    /**
     * 
     * 누적 주행 거리 수치 (소수점 절사)
     */
    private Double value;
    /**
     * 차량 전송 시간(YYYYMMDDHHmmSS)
     */
    private String timestamp;
}
