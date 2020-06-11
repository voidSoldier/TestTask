<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css" type="text/css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>

    <script type='text/javascript'>
        $(document).ready(function () {
            $('#securityList').DataTable({
                pageLength: 16,
                ajax: {
                    url: '/testtask/securities/full',
                    dataSrc: ''
                },
                columns: [
                    {
                        title: 'Secid',
                        data: 'secid'
                    },
                    {
                        title: 'ShortName',
                        data: 'shortName'
                    },
                    {
                        title: 'RegNumber',
                        data: 'regNumber'
                    },
                    {
                        title: 'Name',
                        data: 'name'
                    },
                    {
                        title: 'Isin',
                        data: 'isin'
                    },
                    {
                        title: 'IsTraded',
                        data: 'isTraded'
                    },
                    {
                        title: 'EmitentId',
                        data: 'emitentId'
                    },
                    {
                        title: 'EmitentTitle',
                        data: 'emitentTitle'
                    },
                    {
                        title: 'EmitentInn',
                        data: 'emitentInn'
                    },
                    {
                        title: 'EmitentOkpo',
                        data: 'emitentOkpo'
                    },
                    {
                        title: 'GosReg',
                        data: 'gosReg'
                    },
                    {
                        title: 'Type',
                        data: 'type'
                    },
                    {
                        title: 'Group',
                        data: 'group'
                    },
                    {
                        title: 'PrimaryBoardId',
                        data: 'primaryBoardId'
                    },
                    {
                        title: 'MarketPriceBoardId',
                        data: 'marketPriceBoardId'
                    },
                    {
                        "render": renderDeleteBtn,
                        "defaultContent": "",
                        "orderable": false
                    },
                    {
                        "sTitle": "Edit",
                        "mData": "id",
                        "render": function (mData, type, row, meta) {
                            return '<button onClick="getDetails(' + mData + ')">Edit</button>'
                        },
                        "defaultContent": "",
                        "orderable": false
                    },
                    {
                        "sTitle": "Delete",
                        "mData": "id",
                        "render": function (mData, type, row, meta) {
                            return '<button onClick="getDetails(' + mData + ')">Delete</button>'
                        },
                        "defaultContent": "",
                        "orderable": false
                    }
                ]
            });
            // updateTable: updateFilteredTable
        });
    </script>

    <title>Title</title>
</head>
<body>
<h2>Manage security records</h2>
<table id="securityList" class="display" style="width:100%"></table>
<br><br><br><br><br>
<jsp:useBean id="sec" class="com.javajunior.testtask.model.Security" scope="request"/>
<h3>Add or update security record</h3>
<form id="saveSec" method="post" action="${pageContext.request.contextPath}/securities">
    <label for="secid">secid</label><br>
    <input type="text" value="${sec.secid}" id="secid" name="secid" required><br><br>
    <label for="shortName">shortName</label><br>
    <input type="text" value="${sec.shortName}" id="shortName" name="shortName" required><br><br>
    <label for="regNumber">regNumber</label><br>
    <input type="text" value="${sec.regNumber}" id='regNumber' name="regNumber" required><br><br>
    <label for="name">name</label><br>
    <input type="text" value="${sec.name}" id='name' name="name" required><br><br>
    <label for="isin">isin</label><br>
    <input type="text" value="${sec.isin}" id='isin' name="isin" required><br><br>
    <label for="isTraded">isTraded</label><br>
    <input type="number" value="${sec.isTraded}" id='isTraded' name="isTraded" required><br><br>
    <label for="emitentId">emitentId</label><br>
    <input type="number" value="${sec.emitentId}" id='emitentId' name="emitentId" required><br><br>
    <label for="emitentTitle">emitentTitle</label><br>
    <input type="text" value="${sec.emitentTitle}" id='emitentTitle' name="emitentTitle" required><br><br>
    <label for="emitentInn">emitentInn</label><br>
    <input type="text" value="${sec.emitentInn}" id='emitentInn' name="emitentInn" required><br><br>
    <label for="emitentOkpo">emitentOkpo</label><br>
    <input type="text" value="${sec.emitentOkpo}" id='emitentOkpo' name="emitentOkpo" required><br><br>
    <label for="gosReg">gosReg</label><br>
    <input type="text" value="${sec.gosReg}" id='gosReg' name="gosReg" required><br><br>
    <label for="type">type</label><br>
    <input type="text" value="${sec.type}" id='type' name="type" required><br><br>
    <label for="group">group</label><br>
    <input type="text" value="${sec.group}" id='group' name="group" required><br><br>
    <label for="primaryBoardId">primaryBoardId</label><br>
    <input type="text" value="${sec.primaryBoardId}" id='primaryBoardId' name="primaryBoardId" required><br><br>
    <label for="marketPriceBoardId">marketPriceBoardId</label><br>
    <input type="text" value="${sec.marketPriceBoardId}" id='marketPriceBoardId' name="marketPriceBoardId" required><br><br>
    <button type="submit">Save</button>
    <button onclick="saveSecurity()">Save</button>
    <button onclick="reset()">Reset</button>
</form>

<script>
    var isNew = true;

    function saveSecurity() {
        if ($("#saveSec").valid()) {
            var url, data, method;

            if (isNew) {
                url = '/testtask/securities';
                data = $("#saveSec").serialize();
                method = 'POST';
            }

            $.ajax({
                type: method,
                url: url,
                dataType: 'JSON',
                data: data,

                success: function (data) {
                    if (isNew) {
                        getAll();
                        alert("Security record added");
                    }
                }
            });
        }
    }


    function getAll() {
        isNew = true;
        var id = null;

        $('#securityList').dataTable().fnDestroy();

        $.ajax({
            url: "/testtask/securities",
            type: "GET",
            dataType: "JSON",

            success: function () {
                setContext('/testtask/securities');
                $('#securityToList').DataTable({
                    pageLength: 16,
                    ajax: {
                        url: '/testtask/securities',
                        dataSrc: ''
                    },
                    columns: [
                        {
                            title: 'Secid',
                            data: 'secid'
                        },
                        {
                            title: 'RegNumber',
                            data: 'regNumber'
                        },
                        {
                            title: 'Name',
                            data: 'name'
                        },
                        {
                            title: 'EmitentTitle',
                            data: 'emitentTitle'
                        },
                        {
                            title: 'TradeDate',
                            data: 'tradeDate'
                        },
                        {
                            title: 'NumTrades',
                            data: 'regNumber'
                        },
                        {
                            title: 'Open',
                            data: 'open'
                        },
                        {
                            title: 'Close',
                            data: 'close'
                        },
                        {
                            "sTitle": "Edit",
                            "mData": "id",
                            "render": function (mData, type, row, meta) {
                                return '<button onClick="getDetails(' + mData + ')">Edit</button>'
                            },
                            "defaultContent": "",
                            "orderable": false
                        },
                        {
                            "sTitle": "Delete",
                            "mData": "id",
                            "render": function (mData, type, row, meta) {
                                return '<button onClick="getDelete(' + mData + ')">Delete</button>'
                            },
                            "defaultContent": "",
                            "orderable": false
                        }
                    ]
                });
            }
        });
    }


    function getDetails(id) {
        $.ajax({
            type: 'POST',
            data: {"id": id},
            url: '/testtask/securities/' + id,

            success: function (data) {
                isNew = false
                var obj = JSON.parse(data);
                id = obj[0].id;
            }

        });
    }
</script>

</body>
</html>
