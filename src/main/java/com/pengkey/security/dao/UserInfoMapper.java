package com.pengkey.security.dao;

import com.pengkey.security.domain.UserInfo;
import com.pengkey.security.domain.UserInfoExample;
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

public interface UserInfoMapper {
    @SelectProvider(type=UserInfoSqlProvider.class, method="countByExample")
    int countByExample(UserInfoExample example);

    @DeleteProvider(type=UserInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserInfoExample example);

    @Delete({
        "delete from user_info",
        "where user_id = #{userId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String userId);

    @Insert({
        "insert into user_info (user_id, user_name, ",
        "user_mobile, user_sex, ",
        "user_age, user_adress)",
        "values (#{userId,jdbcType=VARCHAR}, #{userName,jdbcType=VARCHAR}, ",
        "#{userMobile,jdbcType=VARCHAR}, #{userSex,jdbcType=INTEGER}, ",
        "#{userAge,jdbcType=INTEGER}, #{userAdress,jdbcType=VARCHAR})"
    })
    int insert(UserInfo record);

    @InsertProvider(type=UserInfoSqlProvider.class, method="insertSelective")
    int insertSelective(UserInfo record);

    @SelectProvider(type=UserInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_mobile", property="userMobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_sex", property="userSex", jdbcType=JdbcType.INTEGER),
        @Result(column="user_age", property="userAge", jdbcType=JdbcType.INTEGER),
        @Result(column="user_adress", property="userAdress", jdbcType=JdbcType.VARCHAR)
    })
    List<UserInfo> selectByExample(UserInfoExample example);

    @Select({
        "select",
        "user_id, user_name, user_mobile, user_sex, user_age, user_adress",
        "from user_info",
        "where user_id = #{userId,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_mobile", property="userMobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_sex", property="userSex", jdbcType=JdbcType.INTEGER),
        @Result(column="user_age", property="userAge", jdbcType=JdbcType.INTEGER),
        @Result(column="user_adress", property="userAdress", jdbcType=JdbcType.VARCHAR)
    })
    UserInfo selectByPrimaryKey(String userId);

    @UpdateProvider(type=UserInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    @UpdateProvider(type=UserInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    @UpdateProvider(type=UserInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserInfo record);

    @Update({
        "update user_info",
        "set user_name = #{userName,jdbcType=VARCHAR},",
          "user_mobile = #{userMobile,jdbcType=VARCHAR},",
          "user_sex = #{userSex,jdbcType=INTEGER},",
          "user_age = #{userAge,jdbcType=INTEGER},",
          "user_adress = #{userAdress,jdbcType=VARCHAR}",
        "where user_id = #{userId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(UserInfo record);
}