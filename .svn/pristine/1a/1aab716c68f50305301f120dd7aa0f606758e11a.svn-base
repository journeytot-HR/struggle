package com.stylefeng.guns.modular.company.service.impl;

import com.stylefeng.guns.modular.system.model.ContactUs;
import com.stylefeng.guns.modular.system.dao.ContactUsMapper;
import com.stylefeng.guns.modular.company.service.IContactUsService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 首页联系我们 服务实现类
 * </p>
 *
 * @author hr123
 * @since 2019-03-14
 */
@Service
public class ContactUsServiceImpl extends ServiceImpl<ContactUsMapper, ContactUs> implements IContactUsService {

	@Override
	public List<Map<String, Object>> selectContactUs(String condition) {
		return this.baseMapper.selectContactUs(condition);
	}

}
