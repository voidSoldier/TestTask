
var context;

$(document).ready(function () {
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
                "render": renderEditBtn,
                "defaultContent": "",
                "orderable": false
            },
            {
                "render": renderDeleteBtn,
                "defaultContent": "",
                "orderable": false
            }
        ]
    });
    updateTable: updateFilteredTable
});

function setContext(ctx) {
    context = ctx;
}

function save() {
    $.ajax({
        type: "POST",
        url: "/testtask/securities",
        data: form.serialize()
    }).done(function () {
        $("#editRow").modal("hide");
        context.updateTable();
    });
}


function add() {
    $("#modalTitle").html(i18n["addTitle"]);
    form.find(":input").val("");
    $("#editRow").modal();
}

function updateRow(id) {
    $("#modalTitle").html("Edit");
    $.get("/testtask/securities/" + id, function (data) {
        $.each(data, function (key, value) {
            form.find("input[name='" + key + "']").val(value);
        });
        $('#editRow').modal();
    });
}

function deleteRow(id) {
    if (confirm("Delete")) {
        $.ajax({
            url: "/testtask/securities/" + id,
            type: "DELETE"
        }).done(function () {
            context.updateTable();
        });
    }
}

function updateTableByData(data) {
    context.datatableApi.clear().rows.add(data).draw();
}

function updateFilteredTable() {
    $.ajax({
        type: "GET",
        url: "/testtask/securities" + "/filter",
        data: $("#filter").serialize()
    }).done(updateTableByData);
}

function clearFilter() {
    $("#filter")[0].reset();
    $.get("/testtask/securities", updateTableByData);
}

function renderEditBtn(data, type, row) {
    if (type === "display") {
        return "<a onclick='updateRow(" + row.id + ");'>Update</span></a>";
    }
}


function renderDeleteBtn(data, type, row) {
    if (type === "display") {
        return "<a onclick='deleteRow(" + row.id + ");'>Delete</span></a>";
    }
}