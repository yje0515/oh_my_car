
package com.ohmycar.domain;

import java.util.List;
import lombok.Data;

/**
 * 누적 주행거리를 구할 때 json 데이터를 클래스로 변환할 클래스
 */
@Data
public class ConsumableOdometer {
    /**
     * 오류 혹은 확인 메세지가 담긴 String
     */
    private String msgId;
    /**
     * 차량 데이터(누적주행거리 등) 가 담긴 배열 (왜 배열로 주어지는지는 모르겠다.)
     */
    private List<Odometer> odometers;
}
