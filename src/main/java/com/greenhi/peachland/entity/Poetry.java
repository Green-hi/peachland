package com.greenhi.peachland.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
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
@ApiModel(value="Poetry对象", description="")
public class Poetry implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "poetry_id", type = IdType.ASSIGN_ID)
    private String poetryId;

    private String poetryContent;

    private String poetryTransform;

    private String poetryNotes;

    private String poetryAppreciation;

    private String creativeBackground;

    private String authorIntroduction;

    @TableField("English_translation")
    private String englishTranslation;

    @TableField("French_translation")
    private String frenchTranslation;

    @TableField("Russian_translation")
    private String russianTranslation;

    @TableField("Japanese_translation")
    private String japaneseTranslation;

    @TableField("Korean translation")
    private String Korean translation;


}
