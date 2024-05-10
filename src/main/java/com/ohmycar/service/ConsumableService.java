package com.ohmycar.service;

import com.ohmycar.domain.ConsumableVO;

/**
 * 부품 교체 주기 mapper 와 상호작용 하기 위한 service 클래스
 */
public interface ConsumableService {
    public ConsumableVO read(String carId);

    public void create(ConsumableVO vo, String accDist);

    public void modify(ConsumableVO vo);

    public void delete(String carId);
}
