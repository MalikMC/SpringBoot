package com.machun.springbootmybatisannotation.mapper.salve;

import com.machun.springbootmybatisannotation.entity.QueryVO;
import com.machun.springbootmybatisannotation.entity.User;
import com.machun.springbootmybatisannotation.entity.UserQueryPO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * @author machun1
 */


public interface UserDaoSalve {

    /**
     * 登录（直接使用注解指定传入参数名称）
     * @param userName
     * @param password
     * @return
     */
    public User login(@Param("userName") String userName, @Param("password") String password);

    /**
     * 根据表名查询用户信息（直接使用注解指定传入参数名称）
     * @param tableName
     * @return
     */
    public List<User> queryUserByTableName(@Param("tableName") String tableName);

    /**
     * 根据Id查询用户信息
     * @param id
     * @return
     */
    public User queryUserById(String id);

    /**
     * 根据Id查询用户信息
     * @param vo
     * @return
     */
    public List<User> queryUserByIds(QueryVO vo);



    /**
     * 查询所有用户信息
     * @return
     */
    @Select("SELECT * FROM user")
    public List<User> queryUserAll();

    /**
     * 查询所有用户信息
     * @param userQueryPO 用户查询过滤条件
     * @return
     */
    @Select("SELECT * FROM user where username=#{username}")
    public List<User> queryUserList(UserQueryPO userQueryPO);

    /**
     * 总记录
     * @param userQueryPO
     * @return
     */
    int getCount(UserQueryPO userQueryPO);

    /**
     * 新增用户信息
     * @param user
     */
    public void insertUser(User user);

    /**
     * 根据id更新用户信息
     * @param user
     */
    public void updateUser(User user);

    /**
     * 根据id删除用户信息
     * @param id
     */
    public void deleteUserById(String id);

}
