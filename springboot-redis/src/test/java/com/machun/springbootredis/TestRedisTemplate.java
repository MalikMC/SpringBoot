package com.machun.springbootredis;


import com.machun.springbootredis.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;


/**
 * @Description:
 * @Author: machun
 * @CreateDate: 2020/4/1 20:23
 * @UpdateDate: 2020/4/1 20:23
 * @menu
 */


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedisTemplate {

    @Autowired
    private RedisTemplate redisTemplate;


    @Test
    public void testString()  {
        redisTemplate.opsForValue().set("firstKey", "Hello Redis 22222!");
       System.out.println(redisTemplate.opsForValue().get("firstKey"));
        Assert.assertEquals("hello redis !", redisTemplate.opsForValue().get("firstKey"));

    }

    @Test
    public void testExpire() throws InterruptedException {
        User user=new User("Ma Chun", "男", 32, new Date());
        redisTemplate.opsForValue().set("expire", user,100, TimeUnit.MILLISECONDS);
        System.out.println(redisTemplate.opsForValue().get("expire"));
       User vo=(User)redisTemplate.opsForValue().get("expire");
        System.out.println(vo.getUserName());
        Thread.sleep(1000);
        boolean exists=redisTemplate.hasKey("expire");
        if(exists){
            System.out.println("exists is true");
        }else{
            System.out.println("exists is false");
        }
    }


    @Test
    public void voidtestObj(){
        User user=new User("Li Ming", "男", 32, new Date());
        ValueOperations<String, User> operations=redisTemplate.opsForValue();
        operations.set("liming", user);
        User u=operations.get("liming");
        System.out.println("user: "+u.getUserName());
    }

    @Test
    public void testHash() {
        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
        hash.put("hash","name","wang qiang");
        String value=(String) hash.get("hash","name");
        System.out.println("hash value :"+value);
    }


    @Test
    public void testList() {
        ListOperations<String, String> list = redisTemplate.opsForList();
        list.leftPush("list","My");
        list.leftPush("list","name");
        list.leftPush("list","is");
        list.leftPush("list","Chun");
        list.leftPush("list","Chun");
        list.leftPush("list","Chun");
        //弹出最左边元素
        String value=(String)list.leftPop("list");
        System.out.println("list last value :"+value.toString());

        System.out.println(list.range("list",0,-1));
    }


    @Test
    public void testSet() {
        String key="set";
        SetOperations<String, String> set = redisTemplate.opsForSet();
        set.add(key,"it");
        set.add(key,"you");
        set.add(key,"you");
        set.add(key,"know");
        Set<String> values=set.members(key);
        for (String v:values){
            System.out.println("set value :"+v);
        }

    }


    @Test
    public  void  testSetDiff(){

        SetOperations<String, String> set = redisTemplate.opsForSet();
        String key1="setMore1";
        String key2="setMore2";
        set.add(key1,"it");
        set.add(key1,"you");
        set.add(key1,"you");
        set.add(key1,"know");
        set.add(key2,"xx");
        set.add(key2,"know");
        Set<String> diffs=set.difference(key1,key2);
        for (String v:diffs){
            System.out.println("diffs set value :"+v);
        }

    }

    @Test
    public void testUnion(){

        SetOperations<String, String> set = redisTemplate.opsForSet();
        String key3="setMore3";
        String key4="setMore4";
        set.add(key3,"it");
        set.add(key3,"you");
        set.add(key3,"xx");
        set.add(key4,"aa");
        set.add(key4,"bb");
        set.add(key4,"you");
        set.add(key4,"know");
        Set<String> unions=set.union(key3,key4);
        for (String v:unions){
            System.out.println("unions value :"+v);
        }

    }

    @Test
    public void testZset(){
        String key="zset";
        redisTemplate.delete(key);
        ZSetOperations<String, String> zset = redisTemplate.opsForZSet();
        zset.add(key,"it",1);
        zset.add(key,"you",6);
        zset.add(key,"know",4);
        zset.add(key,"neo",3);

        Set<String> zsets=zset.range(key,0,-1);
        for (String v:zsets){
            System.out.println("zset value :"+v);
        }

        Set<String> zsetB=zset.rangeByScore(key,0,key.length()+1);
        for (String v:zsetB){
            System.out.println("zsetB value :"+v);
        }
    }






}



