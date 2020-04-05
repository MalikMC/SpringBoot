package com.machun.springbootspringdatajpamulti.repository;

import com.machun.springbootspringdatajpamulti.entity.User;
import com.machun.springbootspringdatajpamulti.repository.master.MaserUserRepository;
import com.machun.springbootspringdatajpamulti.repository.salve.SalveUserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.util.Date;

/**
 * @Description:
 * @Author: machun
 * @CreateDate: 2020/4/1 14:45
 * @UpdateDate: 2020/4/1 14:45
 * @menu
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Resource
    private MaserUserRepository maserUserRepository;
    @Resource
    private SalveUserRepository salveUserRepository;



    @Test
    public void testSave() throws Exception {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

        User user =new User();
        user.setUserName("MaChun");
        user.setNickName("Chun");
        user.setEmail("23434334@qq.com");
        user.setPassWord("P1252453453");
        user.setRegTime(formattedDate);
        maserUserRepository.save(user);

        User userSalve =new User();
        userSalve.setUserName("LiMing");
        userSalve.setNickName("Ming");
        userSalve.setEmail("63434334@qq.com");
        userSalve.setPassWord("P12524532453");
        userSalve.setRegTime(formattedDate);
        salveUserRepository.save(userSalve);

        System.out.println("主库");
        System.out.println(maserUserRepository.findAll());

        System.out.println("从库");
        System.out.println(salveUserRepository.findAll());
    }



}