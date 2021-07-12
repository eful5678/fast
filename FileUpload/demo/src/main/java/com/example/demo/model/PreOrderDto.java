package com.example.demo.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PreOrderDto {

    @Getter
    @Setter
    public static class listParam{
        private String memberKey;
    }

    @Getter
    @Setter
    public static class userInfo {
        private String sapBusinessKey;
        public userInfo(){
            this.sapBusinessKey = "daf";
        }
    }

    public carCartInfo(CarCart carCart, carStock carStock){
        super(carCart, carStock);
    }
    @Getter
    @Setter
    public static class carCartList{

        PreOrderDto.userInfo userInfo;

        List<PreOrderDto.carCartInfo> list = new ArrayList<>();
    }
}
