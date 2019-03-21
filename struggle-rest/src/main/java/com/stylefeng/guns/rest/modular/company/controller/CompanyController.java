package com.stylefeng.guns.rest.modular.company.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.base.tips.SuccessTip;
import com.stylefeng.guns.rest.common.persistence.model.ContactUs;
import com.stylefeng.guns.rest.modular.company.service.IContactUsService;

import io.swagger.annotations.ApiOperation;
@Controller
@RequestMapping("/company")
public class CompanyController extends BaseController {
	
	@Autowired
    private IContactUsService contactUsService;

	@ApiOperation(value="首页联系我们", notes="首页联系我们")
    @RequestMapping(value="/saveContactUs",method = RequestMethod.POST)
    public ResponseEntity<SuccessTip> hello(@RequestBody ContactUs contactUs) {
    	if (contactUs != null) {
    		contactUs.setCreateTime(new Date());
    		contactUs.setState(1);
    		contactUs.setUpdateTime(new Date());
    		contactUsService.insert(contactUs);
		}
        return ResponseEntity.ok(SUCCESS_TIP);
    }
}
