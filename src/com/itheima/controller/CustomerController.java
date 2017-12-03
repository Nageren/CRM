package com.itheima.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itheima.pojo.BaseDict;
import com.itheima.pojo.Customer;
import com.itheima.service.BaseDictService;
import com.itheima.service.CustomerService;
import com.itheima.vo.QueryVo;

import cn.itcast.utils.Page;

@Controller
public class CustomerController {
	
	@Autowired
	private BaseDictService BaseDictService;
	
	//注入资源文件中的类别码
	//客户来源
	@Value("${CUST_SOURCE_CODE}")
	private String CUST_SOURCE_CODE;
	//客户行业
	@Value("${CUST_INDUSTRY_CODE}")
	private String CUST_INDUSTRY_CODE;
	//客户级别
	@Value("${CUST_LEVEL_CODE}")
	private String CUST_LEVEL_CODE;
	
	
	//注入客户服务
	@Autowired
	private CustomerService customerService;
	
	
	/**
	 * 需求:	加载客户列表页面
	 * 业务需求:加载客户列表页面之前:
	 * 	需要初始化客户来源下拉列表信息,客户行业下拉列表信息,客户级别下拉列表信息
	 */
	@RequestMapping(value="list")
	public String showCustomerList(Model model,QueryVo vo){
		//1.需要初始化客户来源下拉列表信息   客户来源类别码002
		List<BaseDict> fromList = BaseDictService.findBaseDictWithTypeCode(CUST_SOURCE_CODE);
		model.addAttribute("fromType", fromList);
		//2.客户行业下拉列表信息  客户来源类别码001
		List<BaseDict> industryList = BaseDictService.findBaseDictWithTypeCode(CUST_INDUSTRY_CODE);
		model.addAttribute("industryType", industryList);
		//3.客户级别下拉列表信息  客户来源类别码006
		List<BaseDict> levelList = BaseDictService.findBaseDictWithTypeCode(CUST_LEVEL_CODE);
		model.addAttribute("levelType", levelList);
		//4.初始化客户列表
		Page<Customer> page = customerService.findCustomerByPage(vo);
		model.addAttribute("page", page);
		
		//5.回显查询条件
		model.addAttribute("custName", vo.getCustName());
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());
		
		return "list";
	}
	
	/**
	 * 根据id查询信息
	 * @param id
	 * @return
	 */
	@RequestMapping("customer/edit")
	@ResponseBody
	public Customer findCustomerById(Long id){
		Customer customer = customerService.findCustomerById(id);
		return customer;
	}
	
	
	/**
	 * 更新
	 */
	@RequestMapping("customer/update")
	@ResponseBody
	public String updateCustomer(Customer customer){
		customerService.updateCustomer(customer);
		return "ok";
	}
	
	
	/**
	 * 删除
	 */
	@RequestMapping("customer/delete")
	@ResponseBody
	public String deleteCustomerById(Long id){
		customerService.deleteCustomerById(id);
		return "ok";
	}
}
