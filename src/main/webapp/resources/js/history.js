$(document).ready(function () {
    getAll();
});

function getAll() {
    $('#historyList').DataTable({
        pageLength: 16,
        ajax: {
            url: '/testtask/histories',
            dataSrc: ''
        },
        columns: [
            {
                title: 'BoardId',
                data: 'boardId'
            },
            {
                title: 'TradeDate',
                data: 'tradeDate'
            },
            {
                title: 'ShortName',
                data: 'shortName'
            },
            {
                title: 'Secid',
                data: 'secid'
            },
            {
                title: 'NumTrades',
                data: 'numTrades'
            },
            {
                title: 'Value',
                data: 'value'
            },
            {
                title: 'Open',
                data: 'open'
            },
            {
                title: 'Low',
                data: 'low'
            },
            {
                title: 'High',
                data: 'high'
            },
            {
                title: 'LegalClosePrice',
                data: 'legalClosePrice'
            },
            {
                title: 'WaPrice',
                data: 'waPrice'
            },
            {
                title: 'Close',
                data: 'close'
            },
            {
                title: 'Volume',
                data: 'volume'
            }, {
                title: 'MarketPrice2',
                data: 'marketPrice2'
            }, {
                title: 'MarketPrice3',
                data: 'marketPrice3'
            }, {
                title: 'AdmittedQuote',
                data: 'admittedQuote'
            },
            {
                title: 'Mp2ValTrd',
                data: 'mp2ValTrd'
            },
            {
                title: 'MarketPrice3TradesValue',
                data: 'marketPrice3TradesValue'
            },
            {
                title: 'AdmittedValue',
                data: 'admittedValue'
            },
            {
                title: 'WaVal',
                data: 'waVal'
            },
            {
                "sTitle": "Edit",
                "render": function (data, type, row) {
                    return '<button onClick="updateHist(' + row.id + ')">Edit</button>'
                },
                "defaultContent": "",
                "orderable": false
            },
            {
                "sTitle": "Delete",
                "mData": "id",
                "render": function (mData, type, row, meta) {
                    return '<button onClick="deleteHist(' + mData + ')">Delete</button>'
                },
                "defaultContent": "",
                "orderable": false
            }
        ]
    });
}


function saveHistory() {
    var data = $("#saveSec").serialize();

    $.ajax({
        method: 'POST',
        url: '/testtask/histories/',
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



function updateHist(id) {

    $.ajax({
        url: '/testtask/histories/' + id,
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



function deleteHist(id) {
    if (confirm("Delete")) {
        $.ajax({
            url: "/testtask/histories/" + id,
            type: "DELETE"
        }).done(function () {
            destroyTable();
        });
    }
}


function destroyTable() {
    var table = $('#historyList').DataTable();
    table.destroy();
    getAll();
}

