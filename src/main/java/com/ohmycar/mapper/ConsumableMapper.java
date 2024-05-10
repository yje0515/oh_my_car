package com.ohmycar.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.ohmycar.domain.ConsumableVO;

/**
 * 부품 교체 시기를 DB 와 상호작용 하는 클래스
 */
public interface ConsumableMapper {
    public void insert(ConsumableVO vo);

    public void update(ConsumableVO vo);

    public void delete(String carId);

    public ConsumableVO select(String carId);

    public List<ConsumableVO> selectAll();

    @Select("SELECT sysdate FROM dual")
    public String selectSysdate();
}
