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
public class User implements Serializable {

    private static final long serialVersionUID=1L;

    private String user;

    private String userImage;

    @TableId(value = "user_id", type = IdType.ASSIGN_ID)
    private String userId;

    private String password;

    private String occupation;

    private String sex;

    private String briefIntroduction;

    private String love;

    private String funs;

    private String focus;

}
