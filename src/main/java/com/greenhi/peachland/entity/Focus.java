package com.greenhi.peachland.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author greenhi
 * @since 2022-03-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Focus implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "uid")
    private Integer uid;

    @TableId(value = "fid")
    private Integer fid;


}
