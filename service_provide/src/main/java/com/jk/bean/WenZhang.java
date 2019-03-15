package com.jk.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class WenZhang {

    Integer id;
    String title;
    String name;
    String img;
    String music;
    String content;
    Integer browse;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date creaTime;
    Integer zeid;
    Integer sites;

}
