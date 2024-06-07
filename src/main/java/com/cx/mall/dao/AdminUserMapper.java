package com.cx.mall.dao;

import com.cx.mall.entity.AdminUser;
import org.apache.ibatis.annotations.Param;

/**
 * @author
 * @date 
 */
public interface AdminUserMapper {

    AdminUser login(@Param("userName") String userName, @Param("password") String password);

    int insert(AdminUser record);

    int insertSelective(AdminUser record);

    AdminUser selectByPrimaryKey(Integer adminUserId);

    int updateByPrimaryKeySelective(AdminUser record);

    int updateByPrimaryKey(AdminUser record);
}
