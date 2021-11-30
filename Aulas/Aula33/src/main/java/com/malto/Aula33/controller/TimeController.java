package com.malto.Aula33.controller;

import com.malto.Aula33.model.Time;
import com.malto.Aula33.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/time")
public class TimeController {

    @Autowired
    private TimeService timeService;

    @PostMapping
    public Time postTime(@RequestBody Time time){
        return timeService.createTime(time);
    }

}
