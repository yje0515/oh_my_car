package com.ohmycar.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.ohmycar.domain.ConsumableVO;
import com.ohmycar.mapper.ConsumableMapper;

/**
 * consumable service interface 를 상속 받아 구현하는 구현체
 */
@Service
public class ConsumableServiceImpl implements ConsumableService {

    private final ConsumableMapper consumableMapper;

    /**
     * 생성자
     * @param consumableMapper
     */
    public ConsumableServiceImpl(ConsumableMapper consumableMapper) {
        this.consumableMapper = consumableMapper;
    }

    /**
     * 읽기
     */
    @Override
    public ConsumableVO read(String carId) {
        return consumableMapper.select(carId);
    }

    /**
     * DB 에 없는 consumableVO 를 넣는 생성 함수
     * 하지만 사용자가 기억에 없어 아무런 입력을 하지 않을 경우도 존재 함으로
     * null check 를 해줘 null 이면 현재 날짜 혹은 현재 주행거리를 넣는다.
     */
    @Override
    public void create(ConsumableVO vo, String accDist) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String nowDate = sdf.format(new Date());
        if (vo.getAirConFilter() == null) {
            vo.setAirConFilter(accDist);
        }
        if (vo.getBattery() == null) {
            vo.setBattery(nowDate);
        }
        if (vo.getBreakOil() == null) {
            vo.setBreakOil(accDist);
        }
        if (vo.getBreakPad() == null) {
            vo.setBreakPad(accDist);
        }
        if (vo.getCoolingWater() == null) {
            vo.setCoolingWater(accDist);
        }
        if (vo.getEngineOil() == null) {
            vo.setEngineOil(accDist);
        }
        if (vo.getFluidClutch() == null) {
            vo.setFluidClutch(nowDate);
        }
        if (vo.getPowerSteeringOil() == null) {
            vo.setPowerSteeringOil(nowDate);
        }
        if (vo.getSparkPlug() == null) {
            vo.setSparkPlug(accDist);
        }
        if (vo.getTire() == null) {
            vo.setTire(accDist);
        }
        if (vo.getTransmissionOil() == null) {
            vo.setTransmissionOil(accDist);
        }
        if (vo.getWiper() == null) {
            vo.setWiper(nowDate);
        }
        consumableMapper.insert(vo);
    }

    /**
     * 업데이트 함수
     */
    @Override
    public void modify(ConsumableVO vo) {
        consumableMapper.update(vo);
    }

    /**
     * 삭제 함수
     */
    @Override
    public void delete(String carId) {
        consumableMapper.delete(carId);
    }

}
