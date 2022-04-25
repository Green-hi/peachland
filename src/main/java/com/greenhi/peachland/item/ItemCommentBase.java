package com.greenhi.peachland.item;

import lombok.Data;

import java.util.Date;

@Data
public class ItemCommentBase {

    private Integer id;

    private Integer uid;

    private String userName;

    private Integer dynamicId;

    private String commentContent;

    private Date createTime;

}
