
package com.ohmycar.domain;

import lombok.Data;

/**
 * 부품 교체 주기 json 데이터를 클래스로 변환할 클래스
 */
@Data
public class ConsumableCycle {

    /**
     * 엔진 오일의 교체주기
     * 누적 주행 거리
     */
    private String engineOil;
    /**
     * 브레이크 오일의 교체주기
     * 누적 주행거리
     */
    private String breakOil;
    /**
     * 브레이크 패드의 교체주기
     * 누적 주행거리
     */
    private String breakPad;
    /**
     * 와이퍼의 교체주기
     * 날짜
     */
    private String wiper;
    /**
     * 타이어의 교체주기
     * 누적 주행거리
     */
    private String tire;
    /**
     * 에어컨 필터 교체주기
     * 누적 주행거리
     */
    private String airConFilter;
    /**
     * 스파크 플러그의 교체주기
     * 누적 주행거리
     */
    private String sparkPlug;
    /**
     * 배터리의 교체주기
     * 날짜
     */
    private String battery;
    /**
     * 냉각수의 교체주기
     * 정확한 자료 없음
     */
    private String coolingWater;
    /**
     * 트랜스미션 오일의 교체주기
     * 누적 주행거리
     */
    private String transmissionOil;
    /**
     * 파워 스티어링 오일의 교체주기
     * 날짜
     */
    private String powerSteeringOil;
    /**
     * 유체 클러치의 교체주기
     * 날짜
     */
    private String fluidClutch;
}