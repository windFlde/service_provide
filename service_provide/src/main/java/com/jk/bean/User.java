package com.jk.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {

    Integer id;
    String loginacct;
    String userpswd;
    String remempwd;
    String username;
    String email;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date createtime;
    Integer status=1;
    String phone;
    String img;
    Integer count;
    Integer num;
    Integer vip;
    Integer balance;

    Integer userid;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    Date starttime;  //开通时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")

    Date endtime;    //到期时间
    Integer fasong = 0;
    Integer xufei ;
    Integer stop;
}


