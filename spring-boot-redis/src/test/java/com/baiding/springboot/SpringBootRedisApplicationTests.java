package com.baiding.springboot;

import com.baiding.springboot.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRedisApplicationTests {

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate<String, Object> redisTemplate;

	@Test
	public void contextLoads() {
        stringRedisTemplate.opsForValue().append("append","asss");
        String append = stringRedisTemplate.opsForValue().get("append");
        System.out.println(append);
    }

    /**
     * 测试redisTemplate中String类型的读写 opsForValue
     */
    @Test
    public void test01(){
        ValueOperations<String,Object> vo = redisTemplate.opsForValue();
        vo.set("redis","redisTemplate");
        Object name = vo.get("redis");
        System.out.println(name);
        Student student = new Student(101, "zhangsan", "male");
        vo.set("student:"+student.getId(),student);
        System.out.println(vo.get("student:"+student.getId()));

    }

    /**
     * 测试redisTemplate中String类型的读写 opsForValue
     */
    @Test
    public void test02(){
        ValueOperations<String,Object> vo = redisTemplate.opsForValue();
        List<Student> list=new ArrayList<>();
        list.add(new Student(102,"lisi","male"));
        list.add(new Student(103,"wangwu","male"));
        list.add(new Student(104,"zhaoliu","male"));

        vo.set("list_string",list);
        List<Student> list_string = (List<Student>) vo.get("list_string");
        System.out.println(list_string.toString());

    }

    /**
     * 测试redisTemplate中List类型的读写 opsForList
     */
    @Test
    public void test03(){
        ListOperations<String,Object> vo = redisTemplate.opsForList();
        vo.leftPush("list01","aaa");
        // 在 aaa 这个值前插入 bbb
        vo.leftPush("list01","aaa","bbb");
        vo.leftPush("list01","ccc");

        for(int i=0;i<10;i++){
            vo.rightPush("list02","right"+i);
        }
        Long size = vo.size("list02");
        for(int i=1;i<size;i++){
            // 留一个值在list02中，全取出来的话这个key就会删除
            System.out.println(vo.rightPop("list02"));
        }
    }

    /**
     * 测试redisTemplate中Hash类型的读写 opsForHash
     */
    @Test
    public void test04(){
        HashOperations<String, Object, Object> vo = redisTemplate.opsForHash();
        // key:整个hash表的key,  hashKey:hash表中字段的key, value:hash表中字段的value
        for(int i=0;i<10;i++){
            vo.put("hash01","field"+i,"value"+i);
        }
        //获得hash的所有值
        List<Object> hash01 = vo.values("hash01");
        System.out.println(hash01.toString());
        //获得hash的某个hashKey的值
        System.out.println(vo.get("hash01","field0"));
        //获得hash全部的key和value
        Map<Object, Object> entries = vo.entries("hash01");
        System.out.println(entries.toString());
    }
}
