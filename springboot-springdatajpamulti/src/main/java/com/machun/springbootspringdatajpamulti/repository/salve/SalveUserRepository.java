package com.machun.springbootspringdatajpamulti.repository.salve;

import com.machun.springbootspringdatajpamulti.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description:
 * @Author: machun
 * @CreateDate: 2020/4/1 13:59
 * @UpdateDate: 2020/4/1 13:59
 * @menu
 */
public interface SalveUserRepository extends JpaRepository<User,String> {
}
