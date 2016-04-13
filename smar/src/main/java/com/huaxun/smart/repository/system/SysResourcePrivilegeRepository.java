
package com.huaxun.smart.repository.system;


import com.huaxun.smart.entity.system.SysResourcePrivilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 资源表
 *
 * @desc 自动生成代码
 */

public interface SysResourcePrivilegeRepository extends JpaRepository<SysResourcePrivilege,Integer>, JpaSpecificationExecutor<SysResourcePrivilege> {
    @Query(value = "delete from sys_resource_privilege  where  resourceid=?1",nativeQuery = true)
    @Modifying
    @Transactional
    public void deleteByResourceId(Integer id);

    @Query("select p from SysResourcePrivilege p where p.resourceId=?1")
    public List<SysResourcePrivilege> queryByResourceId(Integer resourceid);
}