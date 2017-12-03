package com.itheima.mapper;

import com.itheima.pojo.Customer;
import com.itheima.pojo.CustomerExample;
import com.itheima.vo.QueryVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerMapper {
    int countByExample(CustomerExample example);

    int deleteByExample(CustomerExample example);

    int deleteByPrimaryKey(Long custId);

    int insert(Customer record);

    int insertSelective(Customer record);

    List<Customer> selectByExample(CustomerExample example);

    Customer selectByPrimaryKey(Long custId);

    int updateByExampleSelective(@Param("record") Customer record, @Param("example") CustomerExample example);

    int updateByExample(@Param("record") Customer record, @Param("example") CustomerExample example);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);
    
    //根据条件分页查询
    List<Customer> findCustomerByPage(QueryVo vo);

	int findCustomerByPageCount(QueryVo vo);
}