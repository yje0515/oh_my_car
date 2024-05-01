package com.ohmycar.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ohmycar.domain.ConsumableVO;
import com.ohmycar.mapper.ConsumableMapper;

import lombok.extern.log4j.Log4j;

@Log4j
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
    public void create(ConsumableVO vo) {
        if (vo.getAirConFilter() == null) {
        vo.setAirConFilter("");
        }
    }

    @Override
    public void modify(ConsumableVO vo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modify'");
    }

    @Override
    public void delete(String carId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
