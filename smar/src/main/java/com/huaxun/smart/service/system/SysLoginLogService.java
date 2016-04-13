package com.huaxun.smart.service.system;

import com.huaxun.smart.entity.system.SysLoginLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SysLoginLogService {
    public SysLoginLog add(SysLoginLog entity);
    public SysLoginLog save(SysLoginLog entity);
    public void delete(Integer id);
    public SysLoginLog update(SysLoginLog entity);
    public SysLoginLog findOne(Integer id);
    public List<SysLoginLog> queryAll();
    public Page<SysLoginLog> queryAll(Pageable page);

}
