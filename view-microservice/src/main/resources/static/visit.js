let x;

function visitSubmit(y) {
    x = y;
}

let data;

$("form").submit(function () {
    data = $(this).formToJson();
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
});