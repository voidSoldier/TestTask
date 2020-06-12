<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css" type="text/css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>


    <title>Title</title>
</head>
<body>
<script type="text/javascript" src="resources/js/security.js" defer></script>
<h2>Manage security records</h2>
<table id="securityList" class="display" style="width:100%"></table>
<br><br><br><br><br>
<jsp:useBean id="sec" class="com.javajunior.testtask.model.Security" scope="request"/>
<h3>Add or update security record</h3>
<form id="saveSec" method="post" action="${pageContext.request.contextPath}/securities">
    <label for="id">secid</label><br>
    <input type="number" value="${sec.id}" id="id" name="id" required><br><br>
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
    <button onclick="saveSecurity()">Save</button>
    <button onclick="reset()">Reset</button>
</form>

<%--<script type='text/javascript'>--%>
<%--    var isNew = true;--%>

<%--    $(document).ready(function () {--%>
<%--        getAll();--%>
<%--    });--%>

<%--    function getAll() {--%>
<%--        $('#securityList').dataTable({--%>
<%--            pageLength: 16,--%>
<%--            ajax: {--%>
<%--                url: '/testtask/securities/',--%>
<%--                dataSrc: ''--%>
<%--            },--%>
<%--            columns: [--%>
<%--                {--%>
<%--                    title: 'Id',--%>
<%--                    data: 'id'--%>
<%--                },--%>
<%--                {--%>
<%--                    title: 'Secid',--%>
<%--                    data: 'secid'--%>
<%--                },--%>
<%--                {--%>
<%--                    title: 'ShortName',--%>
<%--                    data: 'shortName'--%>
<%--                },--%>
<%--                {--%>
<%--                    title: 'RegNumber',--%>
<%--                    data: 'regNumber'--%>
<%--                },--%>
<%--                {--%>
<%--                    title: 'Name',--%>
<%--                    data: 'name'--%>
<%--                },--%>
<%--                {--%>
<%--                    title: 'Isin',--%>
<%--                    data: 'isin'--%>
<%--                },--%>
<%--                {--%>
<%--                    title: 'IsTraded',--%>
<%--                    data: 'isTraded'--%>
<%--                },--%>
<%--                {--%>
<%--                    title: 'EmitentId',--%>
<%--                    data: 'emitentId'--%>
<%--                },--%>
<%--                {--%>
<%--                    title: 'EmitentTitle',--%>
<%--                    data: 'emitentTitle'--%>
<%--                },--%>
<%--                {--%>
<%--                    title: 'EmitentInn',--%>
<%--                    data: 'emitentInn'--%>
<%--                },--%>
<%--                {--%>
<%--                    title: 'EmitentOkpo',--%>
<%--                    data: 'emitentOkpo'--%>
<%--                },--%>
<%--                {--%>
<%--                    title: 'GosReg',--%>
<%--                    data: 'gosReg'--%>
<%--                },--%>
<%--                {--%>
<%--                    title: 'Type',--%>
<%--                    data: 'type'--%>
<%--                },--%>
<%--                {--%>
<%--                    title: 'Group',--%>
<%--                    data: 'group'--%>
<%--                },--%>
<%--                {--%>
<%--                    title: 'PrimaryBoardId',--%>
<%--                    data: 'primaryBoardId'--%>
<%--                },--%>
<%--                {--%>
<%--                    title: 'MarketPriceBoardId',--%>
<%--                    data: 'marketPriceBoardId'--%>
<%--                },--%>
<%--                {--%>
<%--                    "sTitle": "Edit",--%>
<%--                    // "mData": "id",--%>
<%--                    "render": function (data, type, row) {--%>
<%--                        return '<button onClick="updateSec(' + row.id + ')">Edit</button>'--%>
<%--                    },--%>
<%--                    "defaultContent": "",--%>
<%--                    "orderable": false--%>
<%--                },--%>
<%--                {--%>
<%--                    "sTitle": "Delete",--%>
<%--                    "mData": "id",--%>
<%--                    "render": function (mData, type, row, meta) {--%>
<%--                        return '<button onClick="deleteSec(' + mData + ')">Delete</button>'--%>
<%--                    },--%>
<%--                    "defaultContent": "",--%>
<%--                    "orderable": false--%>
<%--                }--%>
<%--            ]--%>
<%--        });--%>
<%--    }--%>

<%--    function saveSecurity() {--%>
<%--        var data = $("#saveSec").serialize();--%>

<%--            $.ajax({--%>
<%--                method: 'POST',--%>
<%--                url: '/testtask/securities',--%>
<%--                dataType: 'JSON',--%>
<%--                data: data,--%>

<%--                success: function () {--%>
<%--                    clearForm();--%>
<%--                    destroyTable();--%>
<%--                }--%>
<%--            });--%>
<%--    }--%>


<%--    function clearForm() {--%>
<%--        $("#saveSec").val('');--%>
<%--        // form.find(":input").val("");--%>
<%--    }--%>


<%--    // function updateTable() {--%>
<%--    //     $.get('/testtask/securities', updateTableByData);--%>
<%--    // }--%>
<%--    //--%>
<%--    // function updateTableByData(data) {--%>
<%--    //     context.datatableApi.clear().rows.add(data).draw();--%>
<%--    // }--%>


<%--    function updateSec(id) {--%>

<%--            $.ajax({--%>
<%--                url: '/testtask/securities/' + id,--%>
<%--                method: 'GET',--%>
<%--                dataType: 'json',--%>
<%--                success: function (data) {--%>
<%--                    $('#id').val(data.id);--%>
<%--                    $('#secid').val(data.secid);--%>
<%--                    $('#shortName').val(data.secid);--%>
<%--                    $('#regNumber').val(data.regNumber);--%>
<%--                    $('#name').val(data.name);--%>
<%--                    $('#isin').val(data.isin);--%>
<%--                    $('#isTraded').val(data.isTraded);--%>
<%--                    $('#emitentId').val(data.emitentId);--%>
<%--                    $('#emitentTitle').val(data.emitentTitle);--%>
<%--                    $('#emitentInn').val(data.emitentInn);--%>
<%--                    $('#emitentOkpo').val(data.emitentOkpo);--%>
<%--                    $('#gosReg').val(data.gosReg);--%>
<%--                    $('#type').val(data.type);--%>
<%--                    $('#group').val(data.group);--%>
<%--                    $('#primaryBoardId').val(data.primaryBoardId);--%>
<%--                    $('#marketPriceBoardId').val(data.marketPriceBoardId);--%>

<%--                }--%>
<%--            })--%>
<%--        }--%>



<%--    function deleteSec(id) {--%>
<%--        if (confirm("Delete")) {--%>
<%--            $.ajax({--%>
<%--                url: "/testtask/securities/" + id,--%>
<%--                type: "DELETE"--%>
<%--            }).done(function () {--%>
<%--                destroyTable();--%>
<%--            });--%>
<%--        }--%>
<%--    }--%>


<%--    function destroyTable() {--%>
<%--        var table = $('#securityList').DataTable();--%>
<%--        table.destroy();--%>
<%--        getAll();--%>
<%--    }--%>

<%--</script>--%>

</body>
</html>
