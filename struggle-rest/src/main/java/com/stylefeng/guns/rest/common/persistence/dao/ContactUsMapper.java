package com.stylefeng.guns.rest.common.persistence.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.rest.common.persistence.model.ContactUs;

/**
 * <p>
 * 首页联系我们 Mapper 接口
 * </p>
 *
 * @author hr123
 * @since 2019-03-14
 */
public interface ContactUsMapper extends BaseMapper<ContactUs> {

	List<Map<String, Object>> selectContactUs(@Param("state")String state);
	
}
