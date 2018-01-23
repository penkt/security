package com.pengkey.security.dao;

import com.pengkey.security.domain.UserLogin;
import com.pengkey.security.domain.UserLoginExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface UserLoginMapper {
    @SelectProvider(type=UserLoginSqlProvider.class, method="countByExample")
    int countByExample(UserLoginExample example);

    @DeleteProvider(type=UserLoginSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserLoginExample example);

    @Delete({
        "delete from user_login",
        "where user_id = #{userId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String userId);

    @Insert({
        "insert into user_login (user_id, id, ",
        "user_name, user_password, ",
        "status)",
        "values (#{userId,jdbcType=VARCHAR}, #{id,jdbcType=INTEGER}, ",
        "#{userName,jdbcType=VARCHAR}, #{userPassword,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=INTEGER})"
    })
    int insert(UserLogin record);

    @InsertProvider(type=UserLoginSqlProvider.class, method="insertSelective")
    int insertSelective(UserLogin record);

    @SelectProvider(type=UserLoginSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_password", property="userPassword", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    List<UserLogin> selectByExample(UserLoginExample example);

    @Select({
        "select",
        "user_id, id, user_name, user_password, status",
        "from user_login",
        "where user_id = #{userId,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_password", property="userPassword", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    UserLogin selectByPrimaryKey(String userId);

    @UpdateProvider(type=UserLoginSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") UserLogin record, @Param("example") UserLoginExample example);

    @UpdateProvider(type=UserLoginSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") UserLogin record, @Param("example") UserLoginExample example);

    @UpdateProvider(type=UserLoginSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserLogin record);

    @Update({
        "update user_login",
        "set id = #{id,jdbcType=INTEGER},",
          "user_name = #{userName,jdbcType=VARCHAR},",
          "user_password = #{userPassword,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER}",
        "where user_id = #{userId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(UserLogin record);
}