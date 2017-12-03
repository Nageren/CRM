package com.itheima.service;

import java.util.List;

import com.itheima.pojo.BaseDict;

public interface BaseDictService {
	/**
	 * 需求:根据类别码查询信息
	 * 参数:String  typecode 
	 * 返回值:List<BaseDict>
	 */
	public List<BaseDict> findBaseDictWithTypeCode(String typeCode);
}
