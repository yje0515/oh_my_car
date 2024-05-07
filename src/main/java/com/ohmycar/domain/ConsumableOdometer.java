
package com.ohmycar.domain;

import java.util.List;
import lombok.Data;

@Data
public class ConsumableOdometer {

    private String msgId;
    private List<Odometer> odometers;
}
