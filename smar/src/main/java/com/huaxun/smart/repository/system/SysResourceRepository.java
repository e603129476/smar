
package com.huaxun.smart.repository.system;


import com.huaxun.smart.entity.system.SysResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 资源表
 *
 * @desc 自动生成代码
 */

public interface SysResourceRepository extends JpaRepository<SysResource,Integer>, JpaSpecificationExecutor<SysResource> {

}