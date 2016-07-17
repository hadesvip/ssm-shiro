package com.dao;

import com.bean.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by wangyong on 2016/7/4.
 */
@Repository
public interface UserMapper {

    //    @Select("select user_id,user_name,user_password,locked from user")
    User getUser(Map<String, Object> map);

    int insertUser(User user);

}
