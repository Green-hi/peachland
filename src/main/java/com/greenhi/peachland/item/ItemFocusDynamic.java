package com.greenhi.peachland.item;

import lombok.Data;

import java.util.Date;

@Data
public class ItemFocusDynamic {

    private Integer id;

    private Integer uid;

    private String userName;

    private String dynamicContent;

    private String image;

    private Integer loveNumber;

    private Integer commentNumber;

    private Date createTime;

}
