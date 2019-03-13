package com.jk.bean;

import lombok.Data;

@Data
public class General {

    private Integer id;
    private String video_name;
    private String video_img;
    private String manual_name;
    private String mannul_img;
    /*对应医生ID*/
    private Integer video_docutoId;

    /*观看人数*/
    private  Integer numbers;

    /*医生字段*/
    String dt_name;
    String dt_addr;
    String dt_zc;
    String dt_img;
    String dt_jj;

    /*t_master字段*/
    String kenr;
}
