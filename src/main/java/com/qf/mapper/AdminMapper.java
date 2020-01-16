package com.qf.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.qf.pojo.Adminer;

/**
*@author:老姚
*@date 2018年1月11日
*备注：
*/

public interface AdminMapper {

	@Select(value = { "select * from tb_adminer where username=#{username} and password=#{password}"})
	@Results(id="r",value={
			@Result(id=true,column="id",property="id"),
			@Result(column="username",property="username"),
			@Result(column="password",property="password")
	})
	Adminer selectByNamePass(@Param(value = "username") String username, @Param(value = "password") String password);
}
