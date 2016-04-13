package com.huaxun.smart.service.system;

import com.huaxun.smart.entity.system.SysLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SysLogService {

    public SysLog add(SysLog entity);
    public SysLog save(SysLog entity);
    public void delete(Integer id);
    public SysLog update(SysLog entity);
    public SysLog findOne(Integer id);
    public List<SysLog> queryAll();
    public Page<SysLog> queryAll(Pageable page);

}
