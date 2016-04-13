/**
 * Created by lingking on 2015/12/09.
 * 用户管理的javascript
 */
var basePath = $("#basePath").val();
var tab_userList;
var users = new Array();
function pageInit() {
    $.ajax({
        async: false,
        type: "GET",
        url: basePath + "/user/getUsers",
        success: function (data) {
            var result = $.makeArray(data);
            users = $.makeArray(data);
            tab_userList = $('#tab_userList').DataTable({
                data: users,
                paging: true,
                pagingType: "full_numbers",
                pageLength: 10,
                "language": {
                    "paginate": {
                        "last": "末页",
                        "first": "首页",
                        "previous": "上一页",
                        "next": "下一页"

                    },
                    "emptyTable": "没有用户信息",
                    "info": "第 _PAGE_ 共 _PAGES_ 页 - 共 _MAX_ 条记录",
                    "infoEmpty": "",
                    "search": "筛选：",
                    "infoFiltered": ""
                },
                searching: true,
                ordering: true,
                lengthChange: false,
                processing: true,
                columns: [
                    {data: "id"},
                    {data: "account"},
                    {data: "name"},
                    {data: null},//部门
                    {data: "email"},
                    {data: "workphone"},
                    {data: "mobilephone"},
                    {data: "sex"},
                    {data: "workphone"},//短号
                    {data: "utype"},
                    {data: "status"},
                    {data: "fax"},
                    {data: null},//家庭电话
                    {data: "createtime"},
                    {data: null}
                ],
                columnDefs: [
                    {
                        targets: 0,//编号
                        width: "5%",
                        visible: false
                    },
                    {
                        targets: 1,//账号
                        width: "10%"
                    },
                    {
                        targets: 2,//姓名
                        width: "10%"
                    },
                    {
                        targets: 3,//部门
                        width: "10%"
                    },
                    {
                        targets: 4,//邮箱
                        width: "10%"
                    },
                    {
                        targets: 5,//工作电话
                        width: "10%"
                    },
                    {
                        targets: 6,//手机
                        width: "10%",
                    },
                    {
                        targets: 7,//性别
                        width: "3%"
                    },
                    {
                        targets: 8,//短号
                        width: "8%",
                        visible:false
                    },
                    {
                        targets: 9,//类型
                        width: "5%"
                    },
                    {
                        targets: 10,//状态
                        width: "5%"
                    },
                    {
                        targets: 11,//传真
                        width: "10%",
                        visible: false
                    },
                    {
                        targets: 12,//家庭电话
                        width: "7%",
                        visible: false
                    },
                    {
                        targets: 13,//创建时间
                        width: "7%",
                        visible: false
                    },
                    {
                        targets: 14,//操作列
                        width: "13%",
                        orderable: false,
                        render: function (data, type, row) {
                            var html = '<td><button type="button" class="btn btn-warning btn-xs" name="btn_edit" userid="' + row.id + '" href="javascript:;">修改</button><button type="button" class="btn btn-danger btn-xs" name="btn_delete" userid="' + row.id + '">删除</button><button type="button" class="btn btn-info btn-xs" name="btn_allocate" userid="' + row.id + '">分配角色</button></td>';
                            return html;
                        }
                    }
                ]
            })
            ;

        },
        error: function () {
            alert("页面加载失败，无法加载用户数据!");
        }


    });
}
$(document).ready(function () {
    //初始化页面，加载用户数据
    pageInit();

    //高级搜索弹出按钮
    $('#btn_search').on('click', function () {
        $('#modalFileSearch').modal('show');
    });
    //上传文件弹出窗口
    $('#btn_upload').on('click', function () {
        $('#modalFileUpload').modal('show');
    });
    //上传文件组件初始化
    $("#uploader").plupload({
        runtimes: 'html5,flash,html4',
        url: basePath + "/file/upload",
        dragdrop: true,
        // Views to activate
        views: {
            list: true,
            thumbs: true, // Show thumbs
            active: 'thumbs'
        },
        // Flash settings
        flash_swf_url: basePath + "js/lib/plupload/Moxie.swf",
        // Silverlight settings
        silverlight_xap_url: basePath + "js/lib/plupload/Moxie.xap",
        init: {
            FilesAdded: function (up, files) {
                //for (var i in files) {
                //    console.log(files[i].id + ":" + files[i].name);
                //}
            },
            FileUploaded: function (up, file, response) {
                var files = eval(response.response);
                for (var i = 0; i < files.length; i++) {
                    tab_userList.row.add(files[i]).draw();
                }

            },
            UploadComplete: function (up, files) {
                //up.refresh();
                //for (var i in files) {
                //    console.log(files[i].id + ":" + files[i].name);
                //    up.removeFile(files[i]);
                //}
                $('#modalFileUpload').modal('hide');
            }
        }
    });
    //删除用户
    $('#tab_userList tbody').on('click', 'button[name="btn_delete"]', function (e) {
        //e.preventDefault();

        if (confirm("确定删除该用户吗 ?") == false) {
            return;
        }
        tab_userList.row($(this).parent().parent("tr")).remove().draw();
        var userid = $(this).attr('userid');
        $.ajax({
            async: false,
            type: "POST",
            url: basePath + "/user/deleteUser",
            dataType: "json",
            data: {userid: userid},
            success: function (data) {
                alert("用户删除成功！");
            },
            error: function () {
                alert("用户无法删除，删除失败！");
            }
        });
    });
    //下载文件
    $('#tab_userList tbody').on('click', 'button[name="btn_download"]', function () {
        var uuid = $(this).attr('uuid');
        window.location.href = basePath + "/file/download/" + uuid;
    });
    //查看文件操作日志
    $('#tab_userList tbody').on('click', 'button[name="btn_view"]', function () {
        var uuid = $(this).attr('uuid');
        $.ajax({
            async: false,
            type: "GET",
            url: basePath + "/file/queryLog/" + uuid,
            dataType: "json",
            data: {uuid: uuid},
            success: function (data) {
                tab_logs.clear().draw();
                $.each($.makeArray(data), function (index, item) {
                    tab_logs.row.add(item).draw();
                });
                $('#modalFileLog').modal('show');
            },
            error: function () {
                alert("数据库连接失败！");
            }
        });
    });
    //搜索按钮事件
    $('#btn_query').on('click', function () {
        var fileName = $("#i_fileName").val();
        var publisher = $("#i_publisher").val();
        var start = $("#i_start").val();
        var end = $("#i_end").val();
        $.ajax({
            async: false,
            type: "GET",
            url: basePath + "/file/queryByCondition/",
            dataType: "json",
            data: {fileName: fileName, publisher: publisher, start: start, end: end},
            success: function (data) {
                tab_userList.clear().draw();
                $.each($.makeArray(data), function (index, item) {
                    tab_userList.row.add(item).draw();
                });
            },
            error: function () {
                alert("数据库连接失败！");
            }
        });
    });
});