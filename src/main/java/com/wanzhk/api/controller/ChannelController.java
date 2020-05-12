package com.wanzhk.api.controller;

import com.wanzhk.api.base.AjaxResult;
import com.wanzhk.api.modules.entity.TbChannel;
import com.wanzhk.api.service.ChannelService;
import io.swagger.annotations.Api;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Objects;

/**
 * 菜单
 *
 * @author Wanzhk
 * <p>
 * 2020-05-08
 */
@Api(tags = "菜单接口")
@RestController
@RequestMapping("/channel")
public class ChannelController extends BaseController {

    @Resource
    private ChannelService channelService;

    /**
     * 列表
     *
     * @return 列表集合
     */
    @GetMapping("/list")
    public AjaxResult getChannelList(String title) {
        return AjaxResult.success("ok", channelService.getChannelList(title));
    }

    /**
     * 获取
     *
     * @param id 主键
     * @return 对象
     */
    @GetMapping("/{id}")
    public AjaxResult getChannelById(@PathVariable String id) {
        return AjaxResult.success("ok", channelService.getChannelById(id));
    }

    /**
     * 更新
     *
     * @param channel 对象
     * @return
     */
    @PostMapping("/update")
    public AjaxResult updateChannel(@Valid @RequestBody TbChannel channel, BindingResult result) {
        if (result.hasErrors()) {
            return AjaxResult.error(Objects.requireNonNull(result.getFieldError()).getDefaultMessage());
        }
        if (channelService.updateById(channel)) {
            return AjaxResult.success("ok");
        }
        return AjaxResult.error("修改失败");
    }

    /**
     * 删除
     *
     * @param id 主键
     * @return
     */
    @GetMapping("/delete/{id}")
    public AjaxResult deleteChannel(@PathVariable String id) {
        if (channelService.deleteById(id)) {
            return AjaxResult.success("ok");
        }
        return AjaxResult.error("删除失败");
    }

    /**
     * 添加菜单
     *
     * @param channel 对象
     * @return
     */
    @PostMapping("/create")
    public AjaxResult createChannel(@Valid @RequestBody TbChannel channel, BindingResult result) {
        if (result.hasErrors()) {
            return AjaxResult.error(Objects.requireNonNull(result.getFieldError()).getDefaultMessage());
        }
        if (channelService.createChannel(channel)) {
            return AjaxResult.success("添加成功");
        }
        return AjaxResult.error("添加失败");
    }
}
