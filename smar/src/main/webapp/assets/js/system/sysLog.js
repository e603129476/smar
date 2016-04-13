$(document).ready(function () {
    var basePath = $("#basePath").val();
    var columns = [
        {data: "id"},
        {data: "account"},
        {data: "module"},
        {data: "methods"},
        {data: "description"},
        {data: "actionTime"},
        {data: "userIp"}

    ];

    var tab_sysLogin = $('#tab_sysLog').DataTable({
        paging: true,
        serverSide: true,
        autoWidth: false,
        sAjaxSource: basePath + "/log/getSysLogByPage",
        iDisplayLength: 10,
        fnServerData: function (sSource, aoData, fnCallback) {
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
        columns: columns
    })
});

