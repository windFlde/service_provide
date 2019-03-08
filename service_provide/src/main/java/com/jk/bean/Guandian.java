package com.jk.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Guandian {
    Integer id;
    String gd_title;
    String gd_img;
    Integer gd_browse;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date gd_createtime;
    String gd_mp3;
    String gd_content;
    String gd_detailed;
    Integer gd_zeid;


    String dt_name;
    String dt_zc;
    String dt_addr;
    String dt_img;
    String dt_jj;
    String dt_modle;
    Integer dt_level;
    Integer dt_qw;
}
