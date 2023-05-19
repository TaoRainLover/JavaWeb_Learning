package com.zt.mapper;

import com.zt.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

// 在运行时，会自|动生成该接口的实现类对象（代理对象），并且将该对象交给IOC容器管理
@Mapper
public interface UserMapper {
    // 查询全部的用户信息
    @Select("select * from user")
    public List<User> list();
}
