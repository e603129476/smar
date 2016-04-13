/**
 * Created by lingking on 2015/12/09.
 * 用户管理的javascript
 */
var basePath = $("#basePath").val();
var tab_userList;
var row;


var columns = [
    {data: "id"},
    {data: "username"},
    {data: "account"},
    {data: "status"},
    {data: "description"},
    {data: "createTime"},
    {data: null}
];
var columnDefs = [
    {
        targets: 3,//状态
        orderable: true,
        render: function (data, type, row) {
            if (data == "2")
                return "正常";
            else if (data == "1")
                return "禁用";
            else
                return "正常";
        }
    },
    {
        targets: 6,//操作列
        width: "10%",
        orderable: false,
        render: function (data, type, row) {
            var html = '<td><div class="visible-md visible-lg hidden-sm hidden-xs action-buttons">' +
                '<a name="a_allocate" class="blue" href="#"><i class="icon-archive bigger-130" data-toggle="tooltip" title="用户授权"></i></a>' +
                '<a name="a_edit" class="green" href="#"><i class="icon-pencil bigger-130" data-toggle="tooltip" title="编辑用户"></i> </a>' +
                '<a name="a_delete" class="red" href="#"> <i  class="icon-trash bigger-130" data-toggle="tooltip" title="删除用户"></i></a></div></td>';
            return html;
        }
    }
]
function initPerson() {
    //if(tab_userList!=null||tab_userList!=undefined){
    //    tab_userList.destroy();
    //}
    //初始化页面，加载用户数据
    tab_userList = $('#tab_userList').DataTable({
        paging: true,
        serverSide: true,
        autoWidth: false,
        dom: '<"toolbar">tip',
        sAjaxSource: basePath + "/user/getUsersByConditionAndPage",
        iDisplayLength: 10,
        fnServerData: function (sSource, aoData, fnCallback) {
            aoData.push({"name": "condition", "value": $("#i_condition").val()});
            $.ajax({
                type: "get",
                url: sSource,
                dataType: "json",
                data: aoData, //以json格式传递
                success: function (resp) {
                    fnCallback(resp);
                }
            });
        },
        pagingType: "full_numbers",
        //pageLength: 20,
        "language": {
            "paginate": {
                "last": "末页",
                "first": "首页",
                "previous": "上一页",
                "next": "下一页"

            },
            "emptyTable": "无数据",
            "info": "第 _PAGE_ 页 共 _PAGES_ 页 - 共 _MAX_ 条记录",
            "infoEmpty": "",
            "search": "筛选：",
            "infoFiltered": ""
        },
        searching: false,
        ordering: true,
        lengthChange: false,
        //processing: true,
        columns: columns,
        columnDefs: columnDefs
    })
    ;
    //tab_userList.page.len( document.body.scrollHeight /60 ).draw(false);
}
$(document).ready(function () {
    var tab_selector = '#tab_userList tbody';
    initPerson();
    //分配角色按钮
    $(tab_selector).on('click', 'a[name="a_allocate"]', function () {
        row = tab_userList.row($(this).parent().parent("tr"));
        userId = $(this).attr("userid");

        var roleHtml = '<table style="width: 530px;" class="ui-data-grid" id="tab_roleList">'
            + '<thead>'
            + '<tr>'
            + '<th style="text-align: center;"><input  type="checkbox" id="all" ></th>'
            + '<th hidden>角色编号</th>'
            + '<th style="text-align: center">角色名称</th>'
            + '<th style="text-align: center">角色描述</th>'
            + '<th>bank</th>'
            + '<th></th>'
            + '</tr>'
            + '</thead>'
            + '<tbody style="text-align: center;">'
            + '</tbody>'
            + '</table>';
        var win_role = layer.open({
            title: "分配用户角色",
            area: ['550px', '400px'],
            btn: ['保存', '取消'],
            type: 1,
            content: roleHtml,
            success: function (layero, index) {
                $.ajax({
                    async: false,
                    type: "GET",
                    url: basePath + "/sys/user/getRoles",
                    dataType: "json",
                    data: {userId: userId},
                    success: function (data) {
                        userRoles = $.makeArray(data);
                        //for(var i=0;i<userRoles.length;i++)
                        //{
                        //    $("input[roleid='"+userRoles[i].roleid+"']").attr("checked",true);
                        //}
                    },
                    error: function () {
                        alert("数据库连接失败！");
                    }
                });
                var tab_roleList = $('#tab_roleList').DataTable({
                    //ajax:{
                    //    url: basePath +  "/role/getRolesByPage",
                    //    dataSrc:function ( json ) {
                    //        return json;
                    //    }
                    //},
                    paging: true,
                    bServerSide: true,
                    sAjaxSource: basePath + "/role/getRolesByPage",
                    fnServerData: function (sSource, aoData, fnCallback) {
                        $.ajax({
                            type: "get",
                            url: sSource,
                            dataType: "json",
                            data: aoData, //以json格式传递
                            success: function (resp) {
                                var result = eval(resp);
                                for (var i = 0; i < userRoles.length; i++) {
                                    //$("input[roleid='"+userRoles[i].roleid+"']").attr("checked",true);
                                    for (var j = 0; j < result.aaData.length; j++) {
                                        if (userRoles[i].roleid == result.aaData[j].id)
                                            result.aaData[j].isChecked = true;
                                    }
                                }


                                fnCallback(result);
                            }
                        });
                    },
                    iDisplayLength: 20,
                    pagingType: "full_numbers",
                    //pageLength: 10,
                    "language": {
                        "paginate": {
                            "last": "末页",
                            "first": "首页",
                            "previous": "上一页",
                            "next": "下一页"

                        },
                        "emptyTable": "没有角色信息",
                        "info": "第 _PAGE_ 页 共 _PAGES_ 页 - 共 _MAX_ 条记录",
                        "infoEmpty": "",
                        "search": "筛选：",
                        "infoFiltered": ""
                    },
                    searching: false,
                    ordering: false,
                    lengthChange: false,
                    //processing: true,
                    columns: [
                        {data: null},
                        {data: "id"},
                        {data: "name"},
                        {data: "description"},
                        {data: "rank"},
                        {data: null}
                    ],
                    columnDefs: [
                        {
                            render: function (data, type, row) {
                                if (data.isChecked)
                                    return "<input type='checkbox' name='check_row' roleId='" + row.id + "' checked='" + "'checked'>";
                                else
                                    return "<input type='checkbox' name='check_row' roleId='" + row.id + "'>";
                            },
                            targets: 0,//复选框
                            //width: "3%",
                            orderable: false,
                            visible: true,
                            className: "ui-check"
                        },
                        {
                            targets: 1,//编号
                            visible: false
                        },
                        {
                            targets: 2,//角色名称
                            className: "ui-name"
                            //width: "25%"
                        },
                        {
                            targets: 3,
                            className: "ui-desc"//角色描述
                            //width: "82%"
                        },
                        {
                            targets: 4,//bank
                            visible: false
                        },
                        {
                            targets: 5,//操作列
                            orderable: false,
                            visible: false,
                            render: function (data, type, row) {
                                var html = "";
                                //var html = '<td><button type="button" class="btn btn-warning btn-xs" name="btn_edit" roleid="' + row.id + '" href="javascript:;">查看权限</button></td>';
                                return html;
                            }
                        }
                    ]
                });

                $("#all").on('click', function () {
                    $("input[name='check_row']").each(function () {
                        this.checked = $("#all")[0].checked;
                    });
                });

                $("#tab_roleList").removeClass("dataTable");

            },
            yes: function (index, layero) {
                //角色保存
                var roles = [];
                $("input[name='check_row']").each(function () {
                    if (this.checked) {
                        var roleId = $(this).attr("roleid");
                        roles.push({roleId: roleId});
                    }

                });
                var data = {
                    userId: userId,
                    roles: JSON.stringify(roles)
                }
                $.ajax({
                    async: false,
                    type: "POST",
                    url: basePath + "/sys/user/allocateRole",
                    dataType: "json",
                    data: data,
                    success: function (data) {
                        layer.close(win_role);
                        layer.msg("保存成功！", {skin: "layer-ext-moon"});
                    },
                    error: function () {
                        layer.msg("保存失败！");
                    }
                });
            }
        })


    });
    //删除用户
    $(tab_selector).on('click', 'a[name="a_delete"]', function (e) {
        var rowIndex = $(this).parent().parent().parent("tr");
        var rowData = tab_userList.row(rowIndex).data();
        var userId = rowData.id;
        layer.confirm('确定删除该用户吗 ?', {title: '提示'}, function (index) {
            $.ajax({
                async: false,
                type: "POST",
                url: basePath + "/user/deleteUser",
                dataType: "json",
                data: {userId: userId},
                success: function (data) {
                    layer.msg(data.message, {skin: "layer-ext-moon"})
                    tab_userList.row(rowIndex).remove().draw();
                },
                error: function () {
                    layer.msg("删除失败！", {skin: "layer-ext-moon"})
                }
            });
            layer.close(index);
        });
    });
    //编辑用户
    $(tab_selector).on('click', 'a[name="a_edit"]', function (e) {
        var rowIndex = $(this).parent().parent().parent("tr");
        var rowData = tab_userList.row(rowIndex).data();
       $("#i_id").val(rowData.id);
        $("#i_userName").val(rowData.username);
       $("#i_account").val(rowData.account);
        $("#s_disable").val(rowData.status);
        $("#tt_desc").val(rowData.description);
        $("#modal_user").modal("show");
    });
    //新增用户按钮
    $('#btn_user_add').on('click', function () {
        $("#i_id").val("");
        $("#i_userName").val("");
        $("#i_account").val("");
        $("#s_disable").val("");
        $("#tt_desc").val("");
        $("#modal_user").modal("show");
        $("#modal_user").modal("show");
    });
    //新增用户按钮
    $('#btn_user_save').on('click', function () {
        var newUser = {
            id: $("#i_id").val(),
            userName: $("#i_userName").val(),
            account: $("#i_account").val(),
            status: $("#s_disable").val(),
            description: $("#tt_desc").val()
        };
        $.ajax({
            async: false,
            type: "POST",
            url: basePath + "/user/saveUser",
            dataType: "json",
            data: newUser,
            success: function (data) {
                $("#modal_user").modal("hide");
                layer.msg(data.msg, {skin: "layer-ext-moon"})
                tab_userList.row.add(eval(data.data)).draw();

            },
            error: function () {
                layer.msg("操作失败！", {skin: "layer-ext-moon"})
            }
        });
    });

    //搜索按钮事件
    $('#btn_user_search').on('click', function () {
        tab_userList.ajax.reload();
    });
});

$(document).keypress(function (e) {
    // 回车键事件
    if (e.which == 13) {
        tab_userList.ajax.reload();
    }
});