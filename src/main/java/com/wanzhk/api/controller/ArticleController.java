package com.wanzhk.api.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wanzhk.api.base.AjaxResult;
import com.wanzhk.api.modules.entity.TbArticle;
import com.wanzhk.api.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Date;
import java.util.Objects;

/**
 * 文章
 *
 * @author Wanzhk
 * <p>
 * 2020-05-08
 */
@Api(tags = "文章接口")
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;


    /**
     * 分页查询列表
     *
     * @param page  页码
     * @param limit 数据
     * @return
     */
    @GetMapping("/list")
    @ApiOperation(value = "分页获取文章列表")
    public AjaxResult getArticleList(@ApiParam(value = "页码", name = "page")
                                     @RequestParam(defaultValue = "1", required = false) int page,
                                     @ApiParam(value = "每页数据", name = "size")
                                     @RequestParam(defaultValue = "10", required = false) int limit) {
        IPage<TbArticle> pageInfo = articleService.getArticleList(page, limit);

        return AjaxResult.success("ok", pageInfo);
    }

    /**
     * 获取文章
     *
     * @param id 文章ID
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "通过ID获取文章内容")
    public AjaxResult getArticleById(@ApiParam(value = "文章ID", name = "id") @PathVariable String id) {
        TbArticle article = articleService.getById(id);
        return AjaxResult.success("ok", article);
    }

    /**
     * 删除文章
     *
     * @param id 文章ID
     * @return
     */
    @GetMapping("/delete/{id}")
    @ApiOperation(value = "删除文章")
    public AjaxResult deleteArticleById(@ApiParam(value = "文章ID", name = "id") @PathVariable String id) {
        if (StringUtils.isBlank(id)) {
            return AjaxResult.error("ID不能为空");
        }
        if (articleService.removeById(id)) {
            return AjaxResult.success("ok");
        }
        return AjaxResult.error("删除失败");
    }

    /**
     * 保存
     *
     * @param article
     * @return
     */
    @PostMapping("/save")
    @ApiOperation(value = "保存文章")
    public AjaxResult saveArticle(@ApiParam(value = "文章对象", name = "article") @Valid @RequestBody TbArticle article,
                                  BindingResult result) {
        if (result.hasErrors()) {
            return AjaxResult.error(Objects.requireNonNull(result.getFieldError()).getDefaultMessage());
        }
        boolean save = articleService.save(article);
        if (save) {
            return AjaxResult.success("ok");
        }
        return AjaxResult.error("保存失败");
    }

    /**
     * 修改文章
     *
     * @param article
     * @return
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改文章")
    public AjaxResult updateArticle(@ApiParam(value = "文章对象", name = "article") @Valid @RequestBody TbArticle article,
                                    BindingResult result) {
        if (result.hasErrors()) {
            return AjaxResult.error(Objects.requireNonNull(result.getFieldError().getDefaultMessage()));
        }
        article.setUpdateTime(new Date());
        boolean b = articleService.updateById(article);
        if (b) {
            return AjaxResult.success("ok");
        }
        return AjaxResult.error("修改失败");
    }

}
