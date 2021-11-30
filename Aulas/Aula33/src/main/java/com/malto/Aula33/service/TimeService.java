package com.malto.Aula33.service;

import com.malto.Aula33.model.Time;
import com.malto.Aula33.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeService {

    @Autowired
    private TimeRepository timeRepository;

    public Time createTime(Time time){
        return timeRepository.save(time);
    }

}
