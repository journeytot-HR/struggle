package com.stylefeng.guns.modular.company.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.common.constant.factory.ConstantFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import com.stylefeng.guns.core.support.BeanKit;
import com.stylefeng.guns.core.util.ToolUtil;

import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.ContactUs;
import com.stylefeng.guns.modular.system.vo.ContactUsVo;
import com.stylefeng.guns.modular.system.warpper.ContactUsWarpper;
import com.stylefeng.guns.modular.system.warpper.UserWarpper;

import io.swagger.annotations.ApiOperation;

import com.stylefeng.guns.modular.company.service.IContactUsService;

/**
 * 留言处理控制器
 *
 * @author fengshuonan
 * @Date 2019-03-14 16:23:11
 */
@Controller
@RequestMapping("/contactUs")
public class ContactUsController extends BaseController {

    private String PREFIX = "/company/contactUs/";

    @Autowired
    private IContactUsService contactUsService;

    /**
     * 跳转到留言处理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "contactUs.html";
    }

    /**
     * 跳转到添加留言处理
     */
    @RequestMapping("/contactUs_add")
    public String contactUsAdd() {
        return PREFIX + "contactUs_add.html";
    }

    /**
     * 跳转到修改留言处理
     */
    @RequestMapping("/contactUs_update/{contactUsId}")
    public String contactUsUpdate(@PathVariable Integer contactUsId, Model model) {
        ContactUs contactUs = contactUsService.selectById(contactUsId);
        model.addAttribute("item",contactUs);
        LogObjectHolder.me().set(contactUs);
        return PREFIX + "contactUs_edit.html";
    }

    /**
     * 获取留言处理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
		List<Map<String, Object>> selectList = contactUsService.selectContactUs(condition);
		return new ContactUsWarpper(selectList).warp();
    }

    /**
     * 新增留言处理
     */
    @ApiOperation("新增留言")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Object add(ContactUs contactUs) {
        contactUsService.insert(contactUs);
        return SUCCESS_TIP;
    }

    /**
     * 删除留言处理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer contactUsId) {
        contactUsService.deleteById(contactUsId);
        return SUCCESS_TIP;
    }

    /**
     * 修改留言处理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(ContactUsVo contactUs) {
    	ContactUs cs = new ContactUs();
    	cs.setId(contactUs.getId());
    	cs.setState(contactUs.getState());
    	cs.setRemark(contactUs.getRemark());
    	cs.setUpdateTime(new Date());
        contactUsService.updateById(cs);
        return SUCCESS_TIP;
    }

    /**
     * 留言处理详情
     */
    @RequestMapping(value = "/detail/{contactUsId}")
    @ResponseBody
    public Object detail(@PathVariable("contactUsId") Integer contactUsId) {
        return contactUsService.selectById(contactUsId);
    }
}
