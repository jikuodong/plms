package com.jikuodong.plms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.jikuodong.plms.po.Laboratory;
import com.jikuodong.plms.mapper.LaboratoryMapper;
import com.jikuodong.plms.service.LaboratoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jdk.nashorn.internal.runtime.Property;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 站点实验室 服务实现类
 * </p>
 *
 * @author jikuodong
 * @since 2019-03-07
 */
@Service("")
public class LaboratoryServiceImpl implements LaboratoryService {

    @Override
    public boolean addLab(String id, String LabName, String LabPhone) {
        QueryWrapper<Laboratory> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("LAB_NAME", "测试");
        Laboratory laboratory = new Laboratory();
        laboratory = laboratory.selectOne(queryWrapper);
        laboratory.setId(id);
        laboratory.setLabName(LabName);
        laboratory.setLabPhone(LabPhone);
        laboratory.insert();
        return true;
    }
}
