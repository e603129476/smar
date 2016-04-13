package com.huaxun.smart.service.system.impl;

import com.huaxun.smart.entity.system.SysLog;
import com.huaxun.smart.repository.system.SysLogRepository;
import com.huaxun.smart.service.system.SysLogService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("sysLogService")
public class SysLogServiceImpl implements SysLogService {

    @Resource
    private SysLogRepository sysLogRepository;

    @Override
    public SysLog add(SysLog entity) {
        return sysLogRepository.save(entity);
    }

    @Override
    public SysLog save(SysLog entity) {
        return sysLogRepository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        sysLogRepository.delete(id);
    }

    @Override
    public SysLog update(SysLog entity) {
        return sysLogRepository.save(entity);
    }

    @Override
    public SysLog findOne(Integer id) {
        return sysLogRepository.findOne(id);
    }

    @Override
    public List<SysLog> queryAll() {
        return sysLogRepository.findAll();
    }

    @Override
    public Page<SysLog> queryAll(Pageable page) {
        return sysLogRepository.findAll(page);
    }
}
