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
});
