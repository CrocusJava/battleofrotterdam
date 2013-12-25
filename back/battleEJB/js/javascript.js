$(function() {
    $('.navbar a').click(function() {
        $('.navbar .active').removeClass("active");
        $(this).parent().addClass("active");

    });
    $("a", ".well .nav.first").click(function() {
        $("li", ".well .nav.first").removeClass("active");
        $(this).parent().addClass("active");
    });

    $("a", ".well .nav.second").click(function() {
        $("li", ".well .nav.second").removeClass("active");
        $(this).parent().addClass("active");
    });

    $("#loginForm, #registrationForm").on("submit", AjaxRegistrationLogin);
});

function AjaxRegistrationLogin() {
    var command = $(this).attr("id");
    switch (command) {
        case "loginForm":
            command = "login";
            break;
        case "registrationForm":
            command = "registration";
            break;
    }

    var post = $(this).serializeArray();
    var data = {};
    var url = "http://edu.bionic-university.com:1120/battleWEB/controller?command=" + command;
    for (var i in post) {
        data[post[i].name] = post[i].value;
    }
    data = JSON.stringify(data);
    $.ajax({
        url: url,
        type: "POST",
        dataType: "json",
        data: data,
        contentType: "application/json"
    }).done(function(data) {
        console.log(data);
    }).fail(function(data) {
        console.log(data);
    });
    console.log(data);
    return false;
}
