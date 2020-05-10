package com.wanzhk.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wanzhk.api.mapper.ChannelMapper;
import com.wanzhk.api.modules.entity.TbChannel;
import com.wanzhk.api.service.ChannelService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 菜单接口实现类
 *
 * @author Wanzhk
 * <p>
 * 2020-05-08
 */
@Service
public class ChannelServiceImpl extends ServiceImpl<ChannelMapper, TbChannel> implements ChannelService {
    @Override
    public List<TbChannel> getChannelList(String title) {
        QueryWrapper<TbChannel> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("weight");
        if (StringUtils.isNotBlank(title)) {
            queryWrapper.like("name", title);
        }
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public TbChannel getChannelById(String id) {
        return baseMapper.selectById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateById(TbChannel entity) {
        int update = baseMapper.updateById(entity);
        return 1 == update;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteById(String id) {
        int delete = baseMapper.deleteById(id);
        return 1 == delete;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean createChannel(TbChannel channel) {
        int insert = baseMapper.insert(channel);
        return 1 == insert;
    }


}
