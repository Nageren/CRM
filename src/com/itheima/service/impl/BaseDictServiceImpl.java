package com.itheima.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.mapper.BaseDictMapper;
import com.itheima.pojo.BaseDict;
import com.itheima.pojo.BaseDictExample;
import com.itheima.pojo.BaseDictExample.Criteria;
import com.itheima.service.BaseDictService;

@Service
public class BaseDictServiceImpl implements BaseDictService {
	
	@Autowired
	private BaseDictMapper  baseDictMapper;
	
	@Override
	public List<BaseDict> findBaseDictWithTypeCode(String typeCode) {
		//使用example对象来查询
		BaseDictExample example = new  BaseDictExample();
		//创建Criteria对象
		Criteria createCriteria = example.createCriteria();
		//设置查询参数
		createCriteria.andDictTypeCodeEqualTo(typeCode);
		//使用example对象执行查询
		List<BaseDict> list = baseDictMapper.selectByExample(example);
		
		return	list;
	}

}
