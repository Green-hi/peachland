package com.greenhi.peachland.mapper;

import com.greenhi.peachland.entity.Poetry;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.greenhi.peachland.item.ItemPoetryBase;
import com.greenhi.peachland.item.ItemPoetryTrans;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author greenhi
 * @since 2022-03-01
 */
public interface PoetryMapper extends BaseMapper<Poetry> {

    ItemPoetryBase selectByTitleBase(String title) throws Exception;

    List<String> selectTitleByAuthor(String author) throws Exception;

    List<String> selectTitleByTheme(String theme) throws Exception;

    List<String> selectTitleByDiff(String diff) throws Exception;

    List<String> selectTitleByDynasty(String dynasty) throws Exception;

    ItemPoetryTrans getTransByTitle(String title) throws Exception;

}
