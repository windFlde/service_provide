package com.jk.bean;

import lombok.Data;

import java.util.List;

@Data
public class QueryParam {

    String phone_no;// 发送验证码的手机号

    String verify_code;// 用户输入的验证码

    String requestUrl; //前台传过来的url

    List<CreateLight>cl;

    Integer goodsId;

    Integer userId;

    String htmlUrl;
}
