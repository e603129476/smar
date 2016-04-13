
package com.huaxun.smart.repository.system;


import com.huaxun.smart.entity.system.VUserPrivilege;
import com.huaxun.smart.entity.system.VUserPrivilegePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 资源表
 *
 * @desc 自动生成代码
 */

public interface VUserPrivilegeRepository extends JpaRepository<VUserPrivilege,VUserPrivilegePK>, JpaSpecificationExecutor<VUserPrivilege> {
 @Query(value = "select * from v_user_privilege v where v.userId=?1",nativeQuery = true)
    public List<VUserPrivilege> queryPrivilegeByUserId(Integer userId);
    @Query(value = "select * from v_user_privilege v where v.userId=?1 and parentId=?2",nativeQuery = true)
    public List<VUserPrivilege> queryPrivilegeByUserIdAndResource(Integer userId, Integer parentId);

}