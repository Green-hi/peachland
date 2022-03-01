package com.greenhi.peachland.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value="UserFocus对象", description="")
public class UserFocus implements Serializable {

    private static final long serialVersionUID=1L;

    private String userId;

    @TableId(value = "focus_id", type = IdType.ASSIGN_ID)
    private String focusId;


}
