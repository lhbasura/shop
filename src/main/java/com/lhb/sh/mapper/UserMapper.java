package com.lhb.sh.mapper;

import com.lhb.sh.model.User;import org.apache.ibatis.annotations.Param;import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);


    User findOneByUsername(@Param("username")String username);

    List<User> selectAll();






}