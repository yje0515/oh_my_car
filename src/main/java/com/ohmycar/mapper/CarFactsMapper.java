package com.ohmycar.mapper;

import java.util.List;

import com.ohmycar.domain.CarFactsVO;

public interface CarFactsMapper {
    public void insert(CarFactsVO vo);

    public void update(CarFactsVO vo);

    public CarFactsVO selectOne(int factId);

    public void delete(int factId);

    public List<CarFactsVO> selectAll();

    public int getCount();
}
