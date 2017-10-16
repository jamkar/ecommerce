$(document).ready(function () {

    $(".header li a").click(function (event) {
        event.preventDefault();

        var path = $(this).text();
        if (path !== "Motors") {
            window.location = "/products/" + path.toLowerCase();
        }
        else {
            $.ajax({
                url: "/products/motors",
                success: function (data, status, xhr) {
                    $(".content").html(data);
                    console.log(data);
                    console.log(status);
                    console.log(xhr);
                },
                error: function (xhr, status, errorThrown) {
                    $(".content").html("status: " + status + "errorThrown: " + errorThrown);
                    console.log(status);
                    console.log(errorThrown);
                }
            });
        }
    });

});