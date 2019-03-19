package com.jk.bean;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "t_createLight")
public class CreateLight {

    private String id;
    private String question;
    private String answerKey;
    private String questionKey;
    private String keyWhy;

    private String s5c90590a9d727208e4036a1c;
    private String s5c90595e9d727208e4036a1d;
    private String s5c9059979d727208e4036a1e;
    private String s5c9059af9d727208e4036a1f;
    private String s5c9059b49d727208e4036a20;
    private String s5c9059c29d727208e4036a21;

    public CreateLight(String question, String answerKey, String questionKey, String keyWhy) {
        this.question = question;
        this.answerKey = answerKey;
        this.questionKey = questionKey;
        this.keyWhy = keyWhy;
    }

}
