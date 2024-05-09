
package com.ohmycar.domain;

import lombok.Data;

@Data
public class Odometer {
    private String date;
    private Integer unit;
    private Double value;
    private String timestamp;
}
