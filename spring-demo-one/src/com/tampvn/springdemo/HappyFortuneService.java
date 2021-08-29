package com.tampvn.springdemo;

public class HappyFortuneService implements FortuneService {
    public HappyFortuneService(HappyFortuneService happyFortuneService) {
    }

    @Override
    public String getFortune(){
        return "Today is your lucky day";
    }
}
