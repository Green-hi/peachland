package com.greenhi.peachland.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author greenhi
 * @since 2022-03-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Dynamic implements Serializable {

    private static final long serialVersionUID=1L;

    private String userId;

    @TableId(value = "dynamic_id", type = IdType.ASSIGN_ID)
    private String dynamicId;

    private String dynamicContent;

    private String time;

    private String image;

    private Integer loveNumber;

    private Integer conmentNumber;


}
