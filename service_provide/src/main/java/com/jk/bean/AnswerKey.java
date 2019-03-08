package com.jk.bean;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection="t_answerKey")
public class AnswerKey {

    String id;
    String answer;
    String answerKey;

}
