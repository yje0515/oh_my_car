package com.ohmycar.service;

import com.ohmycar.domain.ConsumableVO;

public interface ConsumableService {
    public ConsumableVO read(String carId);

    public void create(ConsumableVO vo);

    public void modify(ConsumableVO vo);

    public void delete(String carId);
}
