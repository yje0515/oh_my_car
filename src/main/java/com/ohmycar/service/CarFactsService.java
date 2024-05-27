package com.ohmycar.service;

import java.util.List;

import com.ohmycar.domain.CarFactsVO;

public interface CarFactsService {
    public void create(CarFactsVO vo);

    public String read();

    public void modify(CarFactsVO vo);

    public void delete(int factId);

    public List<CarFactsVO> getAll();
    
    public List<CarFactsVO> getRandom();
}
