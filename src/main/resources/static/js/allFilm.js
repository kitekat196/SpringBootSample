function test () {

    $.ajax({
        url: '/api/film/get?id=1',
        type: 'get',
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        success: function (film) {
            console.log(film);
            console.log(film.title);
            console.log(film.rating);
            alert('success');
        },
        error: function (response) {
            alert('error');
        }
    });
}

$(document).ready(function() {
   alert("loaded");
    $.ajax({
        url: '/api/film/all',
        type: 'get',
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        success: function (film) {
            console.log(film);
            for (var i = 0; i < film.length; i++) {
                $("#forAdd").before(
                    "<tr>" +
                    "<td>" + film[i].id +"</td>"+
                    "<td>" + film[i].title +"</td>"+
                    "<td>" + film[i].rating +"</td>"+
                    "<td>" +film[i].age + "</td>"+
                    "<td>" +
                    "<button  type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" onclick=\"editFilm("+ film[i].id+")\" data-target=\"#editModal\">\n" +
                    "Create\n" +
                    "</button>" +
                    "<a class='\btn btn-danger' href=\"deleteFilm?id=" + film[i].id + "\">Buy</a>" +
                    "</td>"+
                    "</tr>");
                console.log(film[i].title);
            }

        },
        error: function (response) {
            alert('error');
        }
    });
});



function editFilm(id) {
    alert(id);

    $.ajax({
        method: "get",
        url:"/api/film/get?id=" + id,
        contentType: "application/json; charset=utf-8",
        success: function(film){
            console.log(film);
            var title = film.title;
            var rating = film.rating;
            var age = film.age;
            $("#id-edit").val(id);
            $("#title-edit").val(title);
            $("#rating-edit").val(rating);
            $("#age-edit").val(age);

            var newFilm={
                'title' : title,
                'rating': rating,
                'age': age
            }

        }

    })

}
function saveData() {
    var id = $("#id-edit").val();
    var title =  $("#title-edit").val();
    var rating = $("#rating-edit").val();
    var age = $("#age-edit").val();

    var newFilm= {
        'id' : id,
        'title' : title,
        'rating' : rating,
        'age' : age
    }
    $.ajax({
        method: "post",
        url: "/api/film/add",
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(newFilm),
        success: function () {
            window.location.replace("/allFilm")
        },
        error: function (error) {

        }
    });
}



function addFilm() {
    var title = $("#title").val();
    var rating = $("#rating").val();
    var age = $("#age").val();

    var newFilm= {
        'title' : title,
        'rating' : rating,
        'age' : age
    }
    $.ajax({
        method: "post",
        url: "/api/film/add",
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(newFilm),
        success: function () {
            window.location.replace("/allFilm")
        },
        error: function (error) {

        }
    });

}