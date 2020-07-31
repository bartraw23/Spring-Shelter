let i;
let data;
let x;

function submitVisitation() {
    data = $("form").formToJson();
    $.ajax({
        url: 'http://localhost:8100/animals/' + x + '/visit',
        type: "POST",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(data),
        success: function (result) {
            console.log(result);
            window.alert('Succes in making visit request');
        },
        error: function (error) {
            console.log(error);
            window.alert("Error during making visit request");
        }
    })
    return false;
};

function persistUUID(y) {
    x = y;
}

function jsonToList(jsonList) {
    let listHtml = '<table class="table table-striped">' +
        '<thead>' +
        '    <tr>' +
        '        <th>Name</th>' +
        '        <th>Species</th>' +
        '        <th>Race</th>' +
        '       <th>Visit</th>' +
        '    </tr>' +
        '    </thead>';

    for (i = 0; i < jsonList.length; i++) {
        listHtml = listHtml.concat('<tr>' +
            '<td>' +
            jsonList[i].name +
            '</td>' +
            '<td>' +
            jsonList[i].species +
            '</td>' +
            '<td>' +
            jsonList[i].race +
            '</td>' +
            '<td>' +
            '<button class="btn btn-info" data-toggle="modal" data-target="#visitWindow" onclick="persistUUID(&quot;' + jsonList[i].id + '&quot;)">Visit</button>' +
            '</td>' +
            '</tr>');
    }
    listHtml = listHtml.concat('</table>');
    document.getElementById('list').innerHTML = listHtml;
}