package com.ohmycar.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.ohmycar.domain.ConsumableVO;
import com.ohmycar.mapper.ConsumableMapper;

@Service
public class ConsumableServiceImpl implements ConsumableService {

    private final ConsumableMapper consumableMapper;

    public ConsumableServiceImpl(ConsumableMapper consumableMapper) {
        this.consumableMapper = consumableMapper;
    }

    @Override
    public ConsumableVO read(String carId) {
        return consumableMapper.select(carId);
    }

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

    @Override
    public void modify(ConsumableVO vo) {
        consumableMapper.update(vo);
    }

    @Override
    public void delete(String carId) {
        consumableMapper.delete(carId);
    }

}
