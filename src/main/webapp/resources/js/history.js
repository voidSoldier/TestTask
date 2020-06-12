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
        url: '/testtask/histories',
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
            $('#boardId').val(data.boardId);
            $('#tradeDate').val(data.tradeDate);
            $('#shortName').val(data.shortName);
            $('#secid').val(data.secid);
            $('#numTrades').val(data.numTrades);
            $('#isTraded').val(data.isTraded);
            $('#value').val(data.value);
            $('#open').val(data.open);
            $('#low').val(data.low);
            $('#high').val(data.high);
            $('#waPrice').val(data.waPrice);
            $('#close').val(data.close);
            $('#volume').val(data.volume);
            $('#marketPrice2').val(data.marketPrice2);
            $('#marketPrice3').val(data.marketPrice3);
            $('#marketPrice3TradesValue').val(data.marketPrice3TradesValue);
            $('#admittedValue').val(data.admittedValue);
            $('#waVal').val(data.waVal);


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

