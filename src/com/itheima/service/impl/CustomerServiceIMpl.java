package com.itheima.service.impl;

import java.util.List;

import cn.itcast.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.mapper.CustomerMapper;
import com.itheima.pojo.Customer;
import com.itheima.service.CustomerService;
import com.itheima.vo.QueryVo;

@Service
public class CustomerServiceIMpl implements CustomerService {
	
	@Autowired
	private CustomerMapper  customerMapper;
	
	
	@Override
	public Page<Customer> findCustomerByPage(QueryVo vo) {
		//计算查询的起始页
		int startNum  = (vo.getPage()-1) * vo.getPageSize();
		vo.setStartNum(startNum);
		
		//查询总记录
		List<Customer> list = customerMapper.findCustomerByPage(vo);
		//查询满足条件的总记录数
		int total = customerMapper.findCustomerByPageCount(vo) ;
		
		//创建分页包装类对象
		Page<Customer> page = new Page<Customer>();
		//设置分页信息
		page.setPage(vo.getPage());
		page.setRows(list);
		page.setSize(vo.getPageSize());
		page.setTotal(total);
		return page;
	}


	@Override
	public Customer findCustomerById(Long custId) {
		return customerMapper.selectByPrimaryKey(custId);
	}


	@Override
	public void updateCustomer(Customer customer) {
		customerMapper.updateByPrimaryKey(customer);
	}

	
	/**
	 * 删除客户
	 */
	@Override
	public void deleteCustomerById(Long custId) {
		customerMapper.deleteByPrimaryKey(custId);
	}

	
	
	

}
