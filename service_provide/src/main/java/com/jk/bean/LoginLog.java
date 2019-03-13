package com.jk.bean;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "t_loginLog")
public class LoginLog {
    private String id;
    private String phone;
    private String logName;
    private Date createTime;

    public LoginLog(String phone, String logName, Date createTime) {
        this.phone = phone;
        this.logName = logName;
        this.createTime = createTime;
    }
}
