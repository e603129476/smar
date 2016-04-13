/**
 * Created by lingking on 2015/12/09.
 * 资源管理的javascript
 */
var basePath = $("#basePath").val();
function pageInit() {
    $.ajax({
        async: false,
        type: "GET",
        url: basePath + "/resource/getResources",
        success: function (data) {
            var setting={
                data:{
                    key:{
                        name:"resourceName"
                    },
                    simpleData:{
                        enable:true,
                        idKey:"id",
                        pIdKey:"parentId",
                        rootPid:null
                    },
                    view:{
                        showIcon:true,
                        showLine:true
                    }
                }
            };

            var resources = $.makeArray(data);

            $.fn.zTree.init($("#tr_resource"),setting,resources);
            var treeObj= $.fn.zTree.getZTreeObj("tr_resource");
            treeObj.expandAll(true);
            //treeObj.expandNode(resources[0], true, true, true);
        },
        error: function () {
            //alert("页面加载失败，无法加载资源数据!");
        }


    });
}
function saveResource(resource,flag){
    var url="";
    if(flag==0)
    {
        url=basePath + "/resource/createResource";
        if(resource.resourceName==""||resource.resourceName==undefined||resource.resourceName==null)
        {
            layer.tips('资源名称不能为空，请输入！', "#i_name");
            return;
        }
        if(resource.resourceCode==""||resource.resourceCode==undefined||resource.resourceCode==null)
        {
            layer.tips('资源编码不能为空，请输入！', "#i_code");
            return;
        }
    }
    else
    {
        url=basePath + "/resource/updateResource";

        if(resource.resourceName==""||resource.resourceName==undefined||resource.resourceName==null)
        {
            layer.tips('资源名称不能为空，请输入！', "#i_name1");
            return;
        }
        if(resource.resourceCode==""||resource.resourceCode==undefined||resource.resourceCode==null)
        {
            layer.tips('资源编码不能为空，请输入！', "#i_code1");
            return;
        }
    }
    $.ajax({
        async: false,
        type: "POST",
        url: url,
        dataType: "json",
        data: {resource:JSON.stringify(resource)},
        //data:{id:resource.id,resourceCode:resource.resourceCode,resourceName:resource.resourceName,
        //    resourceType:resource.resourceType,parentId:resource.parentId,desc:resource.desc},
        success: function (data) {
            layer.msg(data.message,{skin: 'layer-ext-moon'});
            if(flag==0)
                $('#modal_resource_add').modal('hide');
            else
                $('#modal_resource_edit').modal('hide');
        },
        error: function () {
            //alert("页面加载失败，无法加载资源数据!");
        }
    });
}
$(document).ready(function () {
    //初始化页面，加载用户数据
    pageInit();
    //初始化复选框
    $("input[type='checkbox']").iCheck({
        checkboxClass: 'icheckbox_square-blue',
        radioClass: 'iradio_square-blue',
        increaseArea: '20%'
    });
    //新增弹出按钮
    $('#btn_add').on('click', function () {

        $("#i_name").val("");
        $("#i_code").val("");
        $("#s_type").val("");
        $("#tt_desc").val("");
        var treeObj = $.fn.zTree.getZTreeObj("tr_resource");
        var nodes = treeObj.getSelectedNodes();
        if(nodes.length<1)
        {
            layer.msg("请至少选择一个父资源后再新增！",{skin: 'layer-ext-moon'});
        }
        else
        {
            $('#modal_resource_add').modal('show');
        }
    });

    //编辑按钮
    $('#btn_edit').on('click', function () {
        var treeObj = $.fn.zTree.getZTreeObj("tr_resource");
        var nodes = treeObj.getSelectedNodes();
        if(nodes.length<1)
        {
            layer.msg("请至少选择一个父资源后再编辑！",{skin: 'layer-ext-moon'});
        }
        else
        {
            $("#i_id1").val(nodes[0].id);
            $("#i_name1").val(nodes[0].resourceName);
            $("#i_code1").val(nodes[0].resourceCode);
            $("#s_type1").val(nodes[0].resourceType);
            $("#i_parent1").val(nodes[0].parentId);
            $("#tt_desc1").val(nodes[0].description);
            $('#modal_resource_edit').modal('show');
        }
    });

    //新增保存按钮
    $('#btn_save').on('click', function () {
        var treeObj = $.fn.zTree.getZTreeObj("tr_resource");
        var nodes = treeObj.getSelectedNodes();

        var resource=new Object;
        resource.resourceName=$("#i_name").val();
        resource.resourceCode=$("#i_code").val();
        resource.resourceType=$("#s_type").val();
        resource.parentId=nodes[0].id;
        resource.description=$("#tt_desc").val();
        saveResource(resource,0);

        pageInit();

    });
 //编辑保存按钮
    $('#btn_save1').on('click', function () {
        var resource=new Object;
        resource.id=$("#i_id1").val();
        resource.resourceName=$("#i_name1").val();
        resource.resourceCode=$("#i_code1").val();
        resource.resourceType=$("#s_type1").val();
        resource.parentId=$("#i_parent1").val();
        resource.description=$("#tt_desc1").val();

        saveResource(resource,1);


        var treeObj = $.fn.zTree.getZTreeObj("tr_resource");
        var nodes = treeObj.getSelectedNodes();
        nodes[0].name= resource.resourceName;
        nodes[0].resourceName= resource.resourceName;
        treeObj.updateNode(nodes[0]);

    });
    //删除按钮
    $('#btn_delete').on('click', function () {
        var treeObj = $.fn.zTree.getZTreeObj("tr_resource");
        var nodes = treeObj.getSelectedNodes();

        if(nodes.length<1)
        {
            layer.msg("请选择要删除的资源！",{skin: 'layer-ext-moon'});
        }
        else
        {
            layer.confirm('是否真的要删除该资源?', {
                btn: ['确定','取消'] //按钮
            }, function(index){
                var id=nodes[0].id;
                $.ajax({
                    async: false,
                    type: "GET",
                    url: basePath + "/resource/deleteResource",
                    dataType:"json",
                    data:{id:id},
                    success: function (data) {
                        layer.msg(data.message,{skin: 'layer-ext-moon'});
                        treeObj.removeNode(nodes[0]);
                    },
                    error: function () {
                        //alert("删除失败！!");
                    }

                });
            }, function(index){
               layer.close(index);
            });
        }
    })
    //权限定义按钮
    $('#btn_privilege').on('click', function () {
        var treeObj = $.fn.zTree.getZTreeObj("tr_resource");
        var nodes = treeObj.getSelectedNodes();

        if(nodes.length<1)
        {
            layer.msg("请选择资源！",{skin: 'layer-ext-moon'});
        }
        else
        {
            $("input[type='checkbox']").each(function(){
                $("input[type='checkbox']").iCheck('uncheck');
            });

            var resourceId=nodes[0].id;
            $.ajax({
                async:false,
                type:"POST",
                dataType:"json",
                url: basePath + "/resource/getPrivilege",
                data:{resourceId:resourceId},
                success:function(data){
                    var checkButtons=$("input[type='checkbox']");
                    var keys=eval(data);
                    $.each(keys,function(index,item){
                        for(var i=0;i<checkButtons.length;i++)
                        {var val=$(checkButtons[i]).attr("value");
                            if($(checkButtons[i]).attr("value")==item["actionId"])
                            {
                                $(checkButtons[i]).iCheck('check');
                                break;
                            }
                        }
                        //$("input[type='checkbox']").each(function(){
                        //    var val=$(this).attr("value");
                        //    if($(this).attr("value")==item["actionId"])
                        //    {
                        //        $(this).attr("checked",true);
                        //        var val2=item["actionId"];
                        //    }
                        //});
                    });
                },
                error:function(){
                }
            })
        }
        $('#modal_resource_privilege').modal('show');
    });
    //保存权限定义
    $('#btn_privilege_save').on('click', function () {
        var treeObj = $.fn.zTree.getZTreeObj("tr_resource");
        var nodes = treeObj.getSelectedNodes();

        if(nodes.length<1)
        {
            layer.msg("请选择至少一个权限！",{skin: 'layer-ext-moon'});
        }
        else
        {
            var resourceId=nodes[0].id;
            var privileges=new Array();

            $("input[type='checkbox']:checked").each(function(){
                    privileges.push({privilegeId:$(this).attr("value")});
            });

            var data={
                resourceId:resourceId,
                privileges:JSON.stringify(privileges)
            };
            $.ajax({
                async:false,
                type:"POST",
                dataType:"json",
                url: basePath + "/resource/definePrivilege",
                data:data,
                success:function(data){
                    layer.msg(data.message,{skin: 'layer-ext-moon'});
                    $('#modal_resource_privilege').modal('hide');
                },
                error:function(){
                }
            })
        }
    });

});