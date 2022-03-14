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
public class Poetry implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String poetryContent;

    private String poetryTransform;

    private String poetryNotes;

    private String poetryAppreciation;

    private String creativeBackground;

    private String authorIntroduction;

    private String englishTranslation;

    private String frenchTranslation;

    private String russianTranslation;

    private String japaneseTranslation;

    private String koreanTranslation;


}
