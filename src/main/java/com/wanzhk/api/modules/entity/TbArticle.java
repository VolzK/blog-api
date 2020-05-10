package com.wanzhk.api.modules.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 文章实体类
 *
 * @author Wanzhk
 * <p>
 * 2020-05-08
 */
@Data
@TableName("tb_article")
public class TbArticle implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 标题
     */
    private String title;

    /**
     * 摘要
     */
    private String summary;

    /**
     * 点击量
     */
    private Integer pageViews;

    /**
     *
     */
    // private Integer status;

    /**
     * 发布时间
     */
    private Date createTime;

    public TbArticle() {
    }
}
