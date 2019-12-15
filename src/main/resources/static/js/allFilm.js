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
                    "<a type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#exampleModal\">\n" +
                    "  Edit\n" +
                    "</a>\n" +
                    "\n" +
                    "<div class=\"modal fade\" id=\"exampleModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n" +
                    "  <div class=\"modal-dialog\" role=\"document\">\n" +
                    "    <div class=\"modal-content\">\n" +
                    "      <div class=\"modal-header\">\n" +
                    "        <h5 class=\"modal-title\" id=\"exampleModalLabel\">Modal title</h5>\n" +
                    "        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n" +
                    "          <span aria-hidden=\"true\">&times;</span>\n" +
                    "        </button>\n" +
                    "      </div>\n" +
                    "      <div class=\"modal-body\">\n" +
                    "        <form action=\"/editFilm\" method=\"post\">\n" +
                    "        <input name=\"id\" readonly>\n" +
                    "        <h3 id=\"Title\">Title</h3>\n" +
                    "        <input name=\"title\" \"залупа\">\n" + "\n" +
                    "        <h3 id=\"Rat\">Rat</h3>\n" +
                    "        <input name=\"rat\" \"залупа\">\n" + "\n" +
                    "        <h3 id=\"age\">Age</h3>\n" +
                    "        <input name=\"age\" \"залупа\">\n" + "   \n" +
                    "      </div>\n" +
                    "      <div class=\"modal-footer\">\n" +
                    "        <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Close</button>\n" +
                    "        <button type=\"submit\" class=\"btn btn-success\">Save changes</button>\n" +
                    "      </div>\n" +
                    "      </form>\n" +
                    "    </div>\n" +
                    "  </div>\n" +
                    "</div>" +
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

/*



* */