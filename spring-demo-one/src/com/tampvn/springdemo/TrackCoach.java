package com.tampvn.springdemo;

public class TrackCoach implements Coach{


    //define a private field for the dependency
    private FortuneService fortuneService;
    
    @Override
    public String getDailyWorkOut() {
        return "OK bạn là nhất";
    }

    @Override
    public String getDailyFortune() {
        return null;
    }
}
