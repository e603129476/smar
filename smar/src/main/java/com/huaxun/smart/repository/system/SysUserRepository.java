
package com.huaxun.smart.repository.system;

import com.huaxun.smart.entity.system.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 用户表
 *
 * @desc 自动生成代码
 * @date 2015/10/22
 */
public interface SysUserRepository extends JpaRepository<SysUser, Integer>, JpaSpecificationExecutor<SysUser> {
    @Query("select u from SysUser u where u.username like %?1% or u.account like %?1% ")
    List<SysUser> findByCondition(String condition);

    @Query("select u from SysUser u where u.account = ?1 ")
    SysUser findByAccount(String account);

    @Query(value="select * from sys_user u "
            +" where u.username like %?1% or u.account like %?1%"
            + "  LIMIT ?2,?3",nativeQuery = true)
    List<SysUser> getAllUserByConditionAndPage(String condition,Integer pageBegin, Integer pageEnd);
}

