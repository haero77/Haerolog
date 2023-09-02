package com.haerolog.api.request;

import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
public class PostCreate {

    public String title;
    public String content;

    public PostCreate() {
    }

}
