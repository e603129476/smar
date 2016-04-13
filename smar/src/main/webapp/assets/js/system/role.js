/**
 * Created by lingking on 2015/12/09.
 * 用户管理的javascript
 */
var basePath = $("#basePath").val();
var tab_roleList;
var roles = new Array();
var row;
function  privilegeInit()
{
    $.ajax({
        async: false,
        type: "GET",
        url: basePath + "/role/getPrivilege",
        success: function (data) {
            var setting = {
               check:{
                   enable:true
               },
                data: {
                    key: {
                        name: "title"
                    },
                    simpleData: {
                        enable: true,
                        idKey: "id",
                        pIdKey: "parentId",
                        rootPid: null
                    },
                    view: {
                        showIcon: true,
                        showLine: true
                    }
                }
            };

            var resources = $.makeArray(data);

            $.fn.zTree.init($("#tr_privilege"), setting, resources)
        },
        error: function () {
            //alert("页面加载失败，无法加载资源数据!");
        }
    })
}
function pageInit() {
    $.ajax({
        async: false,
        type: "GET",
        url: basePath + "/role/getRoles",
        success: function (data) {
            var result = $.makeArray(data);
            roles = $.makeArray(data);
            tab_roleList = $('#tab_roleList').DataTable({
                data: roles,
                paging: true,
                pagingType: "full_numbers",
                //pageLength: 20,
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
                processing: true,
                columns: [
                    {data: "id"},
                    {data: "name"},
                    {data: "description"},
                    {data: null}
                ],
                columnDefs: [
                    {
                        targets: 3,//操作列
                        width: "13%",
                        orderable: false,
                        render: function (data, type, row) {
                            var html = '<td><a  name="btn_allocate" roleid="' + row.id + '">分配权限</a><a  style="margin-left: 10px;" name="btn_edit" roleid="' + row.id + '" href="javascript:;">编辑</a><a style="margin-left: 10px;" name="btn_delete" roleid="' + row.id + '">删除</a></td>';
                            return html;
                        }
                    }
                ]
            })
            ;

        },
        error: function () {
            //alert("页面加载失败，无法加载角色数据!");
        }


    });

    tab_roleList.page.len( document.body.scrollHeight /60 ).draw(false);
}

$(document).ready(function () {
    //初始化页面，加载角色数据
    pageInit();

//新增弹出按钮
    $('#btn_add').on('click', function () {
        var addHtml= '<form>'
            +'<div style="text-align: center;margin-top: 10px;"><span style="color:red">*</span><label>角色名称：</label>'
            +'<input type="text" style="width: 250px" id="i_name"></div>'
            +'<div style="text-align: center;margin-top: 10px;"><label >&nbsp;角色说明：</label>'
            +'<textarea style="width: 250px" id="tt_desc"></textarea></div>'
            //+'<div style="padding: 5px 0px"><label >角色等级：</label>'
            //+'<input id="i_rank" style="width: 250px"/></div>'
            +'</form>';
        var win_add=layer.open({
            title:"新增角色",
            area:['350px','200px'],
            btn:['保存','取消'],
            type:1,
            content:addHtml,
            success:function(layero, index){
            },
            yes: function(index, layero){
                var role={name:$.trim($("#i_name").val()),description:$("#tt_desc").val()};
                //role.name=$("#i_name").val().trim();
                //role.description=$("#tt_desc").val();

                if(role.name==""||role.name==undefined||role.name==null)
                {
                    layer.tips('角色名称不能为空，请输入！', "#i_name");
                    return;
                }
                $.ajax({
                    async: false,
                    type: "GET",
                    url: basePath + "/role/createRole",
                    dataType: "json",
                    data: {role:JSON.stringify(role)},
                    success: function (data) {
                        layer.msg("新增角色成功！",{skin:"layer-ext-moon"});
                        var result=eval(data);
                        tab_roleList.row.add(result).draw();
                        layer.close(index);
                    },
                    error: function () {
                        layer.msg("新增角色失败！",{skin:"layer-ext-moon"});
                    }
                });
            }
        })
    });

    //删除角色
    $('#tab_roleList tbody').on('click', 'a[name="btn_delete"]', function (e) {
        var that=this;
        layer.confirm('确定删除该角色吗 ?', { title:'提示'}, function(index){
            layer.close(index);
            var roleId = $(that).attr('roleid');
            $.ajax({
                async: false,
                type: "POST",
                url: basePath + "/role/deleteRole",
                dataType: "json",
                data: {roleId: roleId},
                success: function (data) {
                    layer.msg(data.message,{skin:"layer-ext-moon"})
                    tab_roleList.row($(that).parent().parent("tr")).remove().draw();
                },
                error: function () {
                    layer.msg("角色删除失败！",{skin:"layer-ext-moon"})
                }
            });
        });
    });
    //修改按钮
    $('#tab_roleList tbody').on('click', 'a[name="btn_edit"]', function () {
        row=$(this).parent().parent("tr");

        var editHtml= '<form>'
            +'<div style="padding: 5px 0px;text-align: center;"><label >&nbsp;&nbsp;角色编号：</label>'
            +'<input type="text" id="i_id1" style="width: 250px" readonly></div>'
            +'<div style="padding: 5px 0px;text-align: center;"><span style="color:red">*</span><label>角色名称：</label>'
            +'<input type="text" style="width: 250px" id="i_name1"></div>'
            +'<div style="padding: 5px 0px;text-align: center;"><label >&nbsp;&nbsp;角色说明：</label>'
            +'<textarea style="width: 250px;height: 150px;" id="tt_desc1"></textarea></div>'
            +'<div style="padding: 5px 0px;text-align: center;" hidden><label >角色等级：</label>'
            +'<input id="i_rank1" style="width: 250px"/></div>'
            +'</form>';
        var win_edit=layer.open({
            title:"编辑角色",
            area:['350px','350px'],
            btn:['保存','取消'],
            type:1,
            content:editHtml,
            success:function(layero, index){
                var data=tab_roleList.row(row).data();
                $("#i_id1").val(data.id);
                $("#i_name1").val(data.name);
                $("#tt_desc1").val(data.description);
                $("#i_rank1").val(data.rank);
            },
            yes: function(index, layero){
                var role=new Object;
                role.id=$("#i_id1").val();
                role.name=$("#i_name1").val();
                role.description=$("#tt_desc1").val();
                //role.rank=$("#i_rank1").val();

                if(role.name==""||role.name==undefined||role.name==null)
                {
                    layer.tips('角色名称不能为空，请输入！', "#i_name1");
                    return;
                }
                $.ajax({
                    async: false,
                    type: "GET",
                    url: basePath + "/role/updateRole",
                    dataType: "json",
                    data: {role:JSON.stringify(role)},
                    success: function (data) {
                        layer.msg("角色编辑成功！",{skin:"layer-ext-moon"});
                        tab_roleList.row(row).data(role).draw();
                        layer.close(index);
                    },
                    error: function () {
                        layer.msg("角色保存失败!",{skin:"layer-ext-moon"});
                    }
                });
            }
        })
    });

    //分配权限按钮
    $('#tab_roleList tbody').on('click', 'a[name="btn_allocate"]', function () {
        row=$(this).parent().parent("tr");
        var rowData=tab_roleList.row(row).data();

        var roleId=rowData.id;

        var privilegeHtml= '<div class="zTreeDemoBackground left">'
            +'<ul id="tr_privilege" class="ztree"></ul>'
            +'</div>';
        var win_edit=layer.open({
            title:"分配权限",
            area:['300px','350px'],
            btn:['保存','取消'],
            type:1,
            content:privilegeHtml,
            success:function(layero, index){
                //初始化权限树
                privilegeInit();

                var treeObj = $.fn.zTree.getZTreeObj("tr_privilege");
                treeObj.checkAllNodes(false);
                $.ajax({
                        async: false,
                        type: "GET",
                        url: basePath + "/role/getPrivilegeByRole",
                        dataType:"json",
                        data:{roleId:roleId},
                        success: function (data) {
                            var nodes=treeObj.transformToArray(treeObj.getNodes());
                            $.each($.makeArray(data),function(index,item){
                                $.each(nodes,function(index1,item1){
                                    if(item.privilegeid==item1.privilegeId)
                                    {
                                        treeObj.checkNode(item1,true,true);
                                    }
                                })
                            })
                            var root = treeObj.getNodesByParam("level", "0", null);
                            treeObj.expandNode(root[0]);
                        },
                        error: function () {
                            //alert("页面加载失败，无法加载资源数据!");
                        }
                })
            },
            yes: function(index, layero){
                var treeObj = $.fn.zTree.getZTreeObj("tr_privilege");
                var nodes = treeObj.getCheckedNodes(true);
                if(nodes.length<1)
                {
                    layer.msg("请至少选择一个父资源后再新增！",{skin:"layer-ext-moon"});
                }
                else
                {
                    var privileges=new Array();
                    for(var i=0;i<nodes.length;i++)
                    {
                        if(nodes[i].isLeaf==true)
                        {
                            privileges.push({privilegeId:nodes[i].privilegeId});
                        }
                    }

                    var param={
                        roleId:roleId,
                        privileges:JSON.stringify(privileges)
                    }
                    $.ajax({
                        async: false,
                        type: "POST",
                        dataType:"json",
                        url: basePath + "/role/allocatePrivilege",
                        data:param,
                        success: function (data) {
                            layer.msg("权限分配成功！",{skin:"layer-ext-moon"});
                        },
                        error: function () {
                            layer.msg("权限分配失败！",{skin:"layer-ext-moon"});
                        }
                    });
                }
            }
        });
    });

    //保存角色权限
    $('#btn_save_privilege').on('click', function () {

    });
});