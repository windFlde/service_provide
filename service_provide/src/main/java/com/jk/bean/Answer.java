package com.jk.bean;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "t_answer")
public class Answer {

    private Integer id;

    private String title;

    private String content;

    private Integer userId;


}
