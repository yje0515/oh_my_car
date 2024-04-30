package com.ohmycar.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.ohmycar.domain.ConsumableVO;

public interface ConsumableMapper {
    public void insert(ConsumableVO vo);

    public void update(ConsumableVO vo);

    public void delete(String carId);

    public ConsumableVO select(String carId);

    public List<ConsumableVO> selectAll();

    @Select("SELECT sysdate FROM dual")
    public String selectSysdate();
}
