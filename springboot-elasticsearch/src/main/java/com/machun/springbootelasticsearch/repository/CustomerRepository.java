package com.machun.springbootelasticsearch.repository;

import com.machun.springbootelasticsearch.entity.Customer;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


import java.util.List;

/**
 * @Description:
 * @Author: machun
 * @CreateDate: 2020/4/5 16:57
 * @UpdateDate: 2020/4/5 16:57
 * @menu
 */
public interface CustomerRepository extends ElasticsearchRepository<Customer, String> {
    public List<Customer> findByAddress(String address);
    public Customer findByUserName(String userName);
    public int  deleteByUserName(String userName);
}
