function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#blah')
                .attr('src', e.target.result);
        };

        reader.readAsDataURL(input.files[0]);
    }
}

$(document).ready(function () {
    var counter = 0;

    $("#addrow").on("click", function () {
        var newRow = $("<tr>");
        var cols = "";

        cols += '<td><input type="text" class="form-control" name="nom' + counter + '"/></td>';
        cols += '<td><input type="text" class="form-control" name="description' + counter + '"/></td>';
        cols += '<td><input type="text" class="form-control" name="date' + counter + '"/></td>';

        cols += '<td><button class="ibtnDel btn btn-md btn-danger "><i class="fa fa-trash-o" aria-hidden="true"></i></button></td>';
        newRow.append(cols);
        $("table.order-list").append(newRow);
        counter++;
    });



    $("table.order-list").on("click", ".ibtnDel", function (event) {
        $(this).closest("tr").remove();
        counter -= 1
    });


});

$(document).ready(function () {
    var counter = 0;

    $("#addrow2").on("click", function () {
        var newRow = $("<tr>");
        var cols = "";

        cols += '<td><input type="text" class="form-control" name="nom' + counter + '"/></td>';
        cols += '<td><input type="text" class="form-control" name="poste' + counter + '"/></td>';
        cols += '<td><input type="text" class="form-control" name="description' + counter + '"/></td>';
        cols += '<td><input type="text" class="form-control" name="date' + counter + '"/></td>';

        cols += '<td><button class="ibtnDel2 btn btn-md btn-danger "><i class="fa fa-trash-o" aria-hidden="true"></i></button></td>';
        newRow.append(cols);
        $("table.order-list2").append(newRow);
        counter++;
    });



    $("table.order-list2").on("click", ".ibtnDel2", function (event) {
        $(this).closest("tr").remove();
        counter -= 1
    });


});

