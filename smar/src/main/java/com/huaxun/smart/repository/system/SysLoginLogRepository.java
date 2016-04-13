package com.huaxun.smart.repository.system;

import com.huaxun.smart.entity.system.SysLoginLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 系统角色表
 * 
 * @desc 自动生成代码
 * @date 2015/10/22
 */

public interface SysLoginLogRepository extends JpaRepository<SysLoginLog, Integer>,
		JpaSpecificationExecutor<SysLoginLog> {
}