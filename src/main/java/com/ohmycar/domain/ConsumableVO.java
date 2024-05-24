package com.ohmycar.domain;

import lombok.Data;

/**
 * 부품의 교체한 시기가 담긴 클래스
 */
@Data
public class ConsumableVO {

    /**
     * 차량 고유 번호
     */
    private String carId;
    /**
     * 엔진 오일의 교체 한 누적 주행거리
     */
    private String engineOil;
    /**
     * 브레이크 오일의 교체 한 누적 주행거리
     */
    private String breakOil;
    /**
     * 브레이크 패드의 교체 한 누적 주행거리
     */
    private String breakPad;
    /**
     * 와이퍼의 교체한 시기
     */
    private String wiper;
    /**
     * 타이어의 교체 한 누적 주행거리
     */
    private String tire;
    /**
     * 에어컨 필터 교체 한 누적 주행거리
     */
    private String airConFilter;
    /**
     * 스파크 플러그의 교체 한 누적 주행거리
     */
    private String sparkPlug;
    /**
     * 배터리의 교체한 시기
     */
    private String battery;
    /**
     * 냉각수의 교체한 시기
     */
    private String coolingWater;
    /**
     * 트랜스미션 오일의 교체 한 누적 주행거리
     */
    private String transmissionOil;
    /**
     * 파워 스티어링 오일의 교체한 시기
     */
    private String powerSteeringOil;
    /**
     * 유체 클러치의 교체한 시기
     */
    private String fluidClutch;
}
