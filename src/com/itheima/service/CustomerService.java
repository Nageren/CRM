package com.itheima.service;

import com.itheima.pojo.Customer;
import com.itheima.vo.QueryVo;
import cn.itcast.utils.Page;

public interface CustomerService {
	//根据条件分页查询  
	public  Page<Customer>   findCustomerByPage(QueryVo vo);
	
	/**
	 * 根据id查询客户信息
	 * @param :Long custId
	 * @return:Customer
	 */
	public  Customer  findCustomerById(Long custId);
	
	/**
	 * 需求:更新客户
	 * @return
	 */
	public void updateCustomer(Customer customer);
	
	
	/**
	 * 删除客户
	 */
	public void deleteCustomerById(Long custId);
}
