let data;
$("form").submit(function () {
    data = $(this).formToJson();
    $.ajax({
        url: 'http://localhost:8100/animals',
        type: "POST",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(data),
        success: function (result) {
            console.log(result);
            window.alert('Succes in adding: ' + result.name + ' to shelter :D');
        },
        error: function (error) {
            console.log(error);
            window.alert("Error during adding animal into shelter");
        }
    })

    return false;
});