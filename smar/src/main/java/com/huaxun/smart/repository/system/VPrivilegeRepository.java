
package com.huaxun.smart.repository.system;


import com.huaxun.smart.entity.system.VPrivilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 资源表
 *
 * @desc 自动生成代码
 */

public interface VPrivilegeRepository extends JpaRepository<VPrivilege,Integer>, JpaSpecificationExecutor<VPrivilege> {
 @Query("select v from VPrivilege v where v.resourceId=?1")
    public List<VPrivilege> queryPrivilegeByResourceId(Integer resourceId);
}