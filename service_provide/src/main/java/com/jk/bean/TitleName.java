package com.jk.bean;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "t_titleName")
public class TitleName {

    private String id;
    private String titleContent;

    public TitleName(String titleContent) {
        this.titleContent = titleContent;
    }


}
