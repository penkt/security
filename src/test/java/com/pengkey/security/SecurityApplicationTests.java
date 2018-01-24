package com.pengkey.security;

import com.pengkey.security.compent.IdGenerator;
import com.pengkey.security.dao.UserMapper;
import com.pengkey.security.domain.JpaUser;
import com.pengkey.security.domain.User;
import com.pengkey.security.domain.UserExample;
import com.pengkey.security.jpa.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.pengkey.security.dao")
public class SecurityApplicationTests {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Autowired
	private IdGenerator idGenerator;
	@Autowired
	private UserMapper userMapper;

	@Test
	public void contextLoads() {
		//新增测试数据
		userRepository.save(new JpaUser("aaa",10,(byte)0));
		userRepository.save(new JpaUser("bbb",11,(byte)0));
		userRepository.save(new JpaUser("ccc",30,(byte)0));
		userRepository.save(new JpaUser("ddd",80,(byte)0));
		userRepository.save(new JpaUser("eee",63,(byte)0));
		userRepository.save(new JpaUser("fff",22,(byte)0));
		userRepository.save(new JpaUser("ggg",36,(byte)0));
		userRepository.save(new JpaUser("hhh",75,(byte)0));
		userRepository.save(new JpaUser("iii",34,(byte)0));
		userRepository.save(new JpaUser("jjj",23,(byte)0));
		userRepository.save(new JpaUser("kkk",41,(byte)0));
		userRepository.save(new JpaUser("lll",48,(byte)0));
		userRepository.save(new JpaUser("mmm",53,(byte)0));
		userRepository.save(new JpaUser("nnn",57,(byte)0));

	/*	List<JpaUser>userList= userRepository.findAll();
		User user=new User();
		user.setId(1222L);
		Example<JpaUser>example=Example.of(new JpaUser("aaa",10,(byte)0));
		JpaUser user1=userRepository.findOne(example);
		System.out.println(user.toString());
		PageRequest pageRequest=new PageRequest(1,5);
		Page<JpaUser> userPage=userRepository.findAll(pageRequest);
		System.out.println(userPage.getContent().toString());*/

	}
	@Test
	public void testRedis(){
		//保存字符串
		stringRedisTemplate.opsForValue().set("sex","123");

	}
	@Test
	public void testMybatis(){
		User user=new User();
		user.setId(idGenerator.nextId());
		user.setAge(12);
		user.setName("新增测试1");
		userMapper.insertSelective(user);
		UserExample example=new UserExample();
		UserExample.Criteria criteria=example.createCriteria();
		criteria.andNameLike("新增测试");
		List<User> userList=userMapper.selectByExample(example);
		System.out.println(userList.toString());

	}

}
