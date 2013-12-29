$(function() {

    $('.navbar a').click(function() {
        $('.navbar .active').removeClass("active");
        $(this).parent().addClass("active");

    });
    $("a", ".well .nav.first").click(function() {
        $(this).tab("show");
    });

    $("a", ".well .nav.second").click(function() {
        $("li", ".well .nav.second").removeClass("active");
        $(this).parent().addClass("active");

    });

    $("#loginForm, #registrationForm").on("submit", AjaxRegistrationLogin);

    try {
        $("#count-down").county({endDateTime: new Date('2014/12/31 00:00:00'), reflection: false, animation: 'scroll', theme: 'black'});
    }
    catch (e) {

    }
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
    var url = "/battleWEB/controller?command=" + command;
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
        if (data.statuslogin === true && data.statusemail === true) {
            $(".alert>h5").text(data.registrationmessage);
            $("#visit_email").show();
            $(".alert .btn-primary").click(function() {
                $("#visit_email").hide();
                window.location = "account_photo.html";
            });

        }

        console.log(data);
    }).fail(function(data) {
        console.log(data);
    });
    console.log(data);
    return false;
}
//registrationmessage: "Please check your email to complete your registration"
//statuslogin: true
//