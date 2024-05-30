package com.ohmycar.domain;

import lombok.Data;

@Data
public class CarFactsVO {
    private int factId;
    private String factText;

    @Override
    public int hashCode() {
        return factText.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        } else {
            CarFactsVO other = (CarFactsVO) obj;
            return this.factText.equals(other.factText);
        }

    }
}
