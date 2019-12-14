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
                    " <td>" +
                    "<a class='\btn btn-primary' href=\"editFilm?id=" + film[i].id + "\">Edit</a>" +
                    "<a class='\btn btn-danger' href=\"deleteFilm?id=" + film[i].id + "\">Delete</a>" +
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