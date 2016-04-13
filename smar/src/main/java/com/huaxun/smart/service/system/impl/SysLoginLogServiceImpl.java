package com.huaxun.smart.service.system.impl;

import com.huaxun.smart.entity.system.SysLog;
import com.huaxun.smart.entity.system.SysLoginLog;
import com.huaxun.smart.repository.system.SysLogRepository;
import com.huaxun.smart.repository.system.SysLoginLogRepository;
import com.huaxun.smart.service.system.SysLogService;
import com.huaxun.smart.service.system.SysLoginLogService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("sysLoginLogService")
public class SysLoginLogServiceImpl implements SysLoginLogService {

    @Resource
    private SysLoginLogRepository sysLoginLogRepository;

    @Override
    public SysLoginLog add(SysLoginLog entity) {
        return sysLoginLogRepository.save(entity);
    }

    @Override
    public SysLoginLog save(SysLoginLog entity) {
        return sysLoginLogRepository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        sysLoginLogRepository.delete(id);
    }

    @Override
    public SysLoginLog update(SysLoginLog entity) {
        return sysLoginLogRepository.save(entity);
    }

    @Override
    public SysLoginLog findOne(Integer id) {
        return sysLoginLogRepository.findOne(id);
    }

    @Override
    public List<SysLoginLog> queryAll() {
        return sysLoginLogRepository.findAll();
    }

    @Override
    public Page<SysLoginLog> queryAll(Pageable page) {
        return sysLoginLogRepository.findAll(page);
    }
}
