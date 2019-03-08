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

    private String s5c810fb89d72722fdcecef65;
    private String s5c81149d9d72722fdcecef66;
    private String s5c8114c49d72722fdcecef67;
    private String s5c8114cc9d72722fdcecef68;
    private String s5c8114cc9d72722fdcecef69;
    private String s5c8114cd9d72722fdcecef6a;

    public CreateLight(String question, String answerKey, String questionKey, String keyWhy) {
        this.question = question;
        this.answerKey = answerKey;
        this.questionKey = questionKey;
        this.keyWhy = keyWhy;
    }

}
