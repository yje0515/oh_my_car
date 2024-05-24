package com.ohmycar.service;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.ohmycar.domain.CarFactsVO;
import com.ohmycar.mapper.CarFactsMapper;

@Service
public class CarFactsServiceImpl implements CarFactsService {

    private final CarFactsMapper mapper;
    private Random random = new Random();

    public CarFactsServiceImpl(CarFactsMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void create(CarFactsVO vo) {
        mapper.insert(vo);
    }

    @Override
    public void delete(int factId) {
        mapper.delete(factId);
    }

    @Override
    public void modify(CarFactsVO vo) {
        mapper.update(vo);
    }

    @Override
    public String read() {
        int max = mapper.getCount();
        int rn = random.nextInt(max) + 1;
        return mapper.selectOne(rn);
    }

    @Override
    public List<CarFactsVO> getAll() {
        return mapper.selectAll();
    }

}
