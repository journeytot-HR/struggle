package com.stylefeng.guns.modular.system.vo;

import com.stylefeng.guns.modular.system.model.ContactUs;

public class ContactUsVo {
	private Long id;
	
	/**
     * 状态
     */
    private Integer state;
    /**
     * 备注
     */
    private String remark;
    
    
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

}
