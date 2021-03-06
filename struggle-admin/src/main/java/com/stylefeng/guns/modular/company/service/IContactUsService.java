package com.stylefeng.guns.modular.company.service;

import com.stylefeng.guns.modular.system.model.ContactUs;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 首页联系我们 服务类
 * </p>
 *
 * @author hr123
 * @since 2019-03-14
 */
public interface IContactUsService extends IService<ContactUs> {

	List<Map<String, Object>> selectContactUs(String condition);

}
