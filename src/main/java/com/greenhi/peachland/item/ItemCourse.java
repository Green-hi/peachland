package com.greenhi.peachland.item;

import lombok.Data;

import java.util.Date;

@Data
public class ItemCourse {

    private Integer id;

    private String tag;

    private String title;

    private String intro;

    private String author;

    private Integer authorId;

    private Date createTime;

}
