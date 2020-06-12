$(document).ready(function () {
    getAll();
});

function getAll() {
    $('#securityList').dataTable({
        pageLength: 16,
        ajax: {
            url: '/testtask/securities/',
            dataSrc: ''
        },
        columns: [
            {
                title: 'Id',
                data: 'id'
            },
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
                "sTitle": "Edit",
                "render": function (data, type, row) {
                    return '<button onClick="updateSec(' + row.id + ')">Edit</button>'
                },
                "defaultContent": "",
                "orderable": false
            },
            {
                "sTitle": "Delete",
                "mData": "id",
                "render": function (mData, type, row, meta) {
                    return '<button onClick="deleteSec(' + mData + ')">Delete</button>'
                },
                "defaultContent": "",
                "orderable": false
            }
        ]
    });
}

function saveSecurity() {
    var data = $("#saveSec").serialize();

    $.ajax({
        method: 'POST',
        url: '/testtask/securities',
        dataType: 'JSON',
        data: data,

        success: function () {
            clearForm();
            destroyTable();
        }
    });
}


function clearForm() {
    $("#saveSec").val('');
}



function updateSec(id) {

    $.ajax({
        url: '/testtask/securities/' + id,
        method: 'GET',
        dataType: 'json',
        success: function (data) {
            $('#id').val(data.id);
            $('#secid').val(data.secid);
            $('#shortName').val(data.secid);
            $('#regNumber').val(data.regNumber);
            $('#name').val(data.name);
            $('#isin').val(data.isin);
            $('#isTraded').val(data.isTraded);
            $('#emitentId').val(data.emitentId);
            $('#emitentTitle').val(data.emitentTitle);
            $('#emitentInn').val(data.emitentInn);
            $('#emitentOkpo').val(data.emitentOkpo);
            $('#gosReg').val(data.gosReg);
            $('#type').val(data.type);
            $('#group').val(data.group);
            $('#primaryBoardId').val(data.primaryBoardId);
            $('#marketPriceBoardId').val(data.marketPriceBoardId);

        }
    })
}



function deleteSec(id) {
    if (confirm("Delete")) {
        $.ajax({
            url: "/testtask/securities/" + id,
            type: "DELETE"
        }).done(function () {
            destroyTable();
        });
    }
}


function destroyTable() {
    var table = $('#securityList').DataTable();
    table.destroy();
    getAll();
}

