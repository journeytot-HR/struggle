/**
 * 初始化留言处理详情对话框
 */
var ContactUsInfoDlg = {
    contactUsInfoData : {}
};

/**
 * 清除数据
 */
ContactUsInfoDlg.clearData = function() {
    this.contactUsInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ContactUsInfoDlg.set = function(key, val) {
    this.contactUsInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ContactUsInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
ContactUsInfoDlg.close = function() {
    parent.layer.close(window.parent.ContactUs.layerIndex);
}

/**
 * 收集数据
 */
ContactUsInfoDlg.collectData = function() {
    this
    .set('id')
    .set('name')
    .set('tel')
    .set('email')
    .set('message')
    .set('state')
    .set('remark')
    .set('createTime')
    .set('updateTime');
}

/**
 * 提交添加
 */
ContactUsInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/contactUs/add", function(data){
        Feng.success("添加成功!");
        window.parent.ContactUs.table.refresh();
        ContactUsInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.contactUsInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
ContactUsInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/contactUs/update", function(data){
        Feng.success("修改成功!");
        window.parent.ContactUs.table.refresh();
        ContactUsInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.contactUsInfoData);
    ajax.start();
}

$(function() {

});
