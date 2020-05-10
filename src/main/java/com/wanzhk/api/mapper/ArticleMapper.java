package com.wanzhk.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wanzhk.api.modules.entity.TbArticle;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文章DAO
 *
 * @author Wanzhk
 * <p>
 * 2020-05-08
 */
@Mapper
public interface ArticleMapper extends BaseMapper<TbArticle> {

}
