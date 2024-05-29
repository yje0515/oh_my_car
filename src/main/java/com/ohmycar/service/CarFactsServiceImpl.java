package com.ohmycar.service;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ohmycar.domain.CarFactsVO;
import com.ohmycar.mapper.CarFactsMapper;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
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
        String text = mapper.selectOne(rn);
        log.info(text);
        return text;
    }

    @Override
    public List<CarFactsVO> getAll() {
        return mapper.selectAll();
    }

    // 간단상식리스트 중 랜덤 10개를 반환
    @Override
    public List<CarFactsVO> getRandom() {
        List<CarFactsVO> allCarFacts = mapper.selectAll();
        Collections.shuffle(allCarFacts);
        return allCarFacts.stream().limit(5).collect(Collectors.toList());
    }

}
