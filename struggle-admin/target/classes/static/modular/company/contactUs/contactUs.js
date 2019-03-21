/**
 * 留言处理管理初始化
 */
var ContactUs = {
    id: "ContactUsTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
ContactUs.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '主键', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '姓名', field: 'name', visible: true, align: 'center', valign: 'middle'},
            {title: '电话', field: 'tel', visible: true, align: 'center', valign: 'middle'},
            {title: '邮箱', field: 'email', visible: true, align: 'center', valign: 'middle'},
            {title: '留言内容', field: 'message', visible: true, align: 'center', valign: 'middle'},
            {title: '状态', field: 'stateName', visible: true, align: 'center', valign: 'middle'},
            {title: '备注', field: 'remark', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'createTime', visible: true, align: 'center', valign: 'middle'},
            {title: '修改时间', field: 'updateTime', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
ContactUs.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        ContactUs.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加留言处理
 */
ContactUs.openAddContactUs = function () {
    var index = layer.open({
        type: 2,
        title: '添加留言处理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/contactUs/contactUs_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看留言处理详情
 */
ContactUs.openContactUsDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '留言处理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/contactUs/contactUs_update/' + ContactUs.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除留言处理
 */
ContactUs.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/contactUs/delete", function (data) {
            Feng.success("删除成功!");
            ContactUs.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("contactUsId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询留言处理列表
 */
ContactUs.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    ContactUs.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = ContactUs.initColumn();
    var table = new BSTable(ContactUs.id, "/contactUs/list", defaultColunms);
    table.setPaginationType("client");
    ContactUs.table = table.init();
});
