$(window).load(function() {
    call_all();
});
function call_all() {
    call_grid();
    call_scroll();
    //call_slider_sequence();
    call_datatables();
    call_tab();
    call_full_calendar();
    call_functional_reservations();
    call_lightbox();
    call_control_color_theme();
    //call_lazy_load_images();
    call_form_validation();
    call_events_show_hide_login_registration();
    call_event_create_comment();
    call_activate_menu_links();
    call_start_count_timer();
    call_start_carousel();
    call_load_data_for_index_comments();
    call_load_data_for_index_events();

}

function call_form_validation() {
    if ($('.login_form_validation').length > 0) {
        $('.login_form_validation').validate({
            submitHandler: AjaxRegistrationLogin
        });
    }
    if ($('.comment_form_validation').length > 0) {
        $('.comment_form_validation').validate({
            submitHandler: AjaxSendComment
        });
    }
    if ($('.singup_form_validation').length > 0) {
        $('.singup_form_validation').validate({
            rules: {
                password: {
                    equalTo: "#repassword"
                },
                birthday: {
                    date: true
                },
                postcode: {
                    number: true
                }
            },
            submitHandler: AjaxRegistrationLogin
        });
    }
}



function call_lazy_load_images() {
//$("#content img").unveil(300)
    $("#content img").unveil(300);
}

function call_control_color_theme() {
    if ($.cookie('color_theme')) {
        $('body').removeClass().addClass($.cookie('color_theme'));
    }
    $('.control_color a').click(function(e) {
        e.preventDefault();
        $.cookie('color_theme', $(this).data('color'), {
            expires: 7
        });
        $('body').removeClass().addClass($(this).data('color'));
    });
}

function call_functional_reservations() {
    $('.select_room .item_grid').click(function(e) {
        e.preventDefault();
        $('.select_room').find('.item_grid').removeClass('selected');
        $(this).addClass('selected');
        $('#form_select_room').val($(this).data('date'));
    });
    $('.checkbox_extras').click(function(e) {
        call_grid();
        if ($(this).is(':checked')) {
            $(this).parents('.panel').find('select').show();
        } else {
            $(this).parents('.panel').find('select').hide();
        }
    });
}

function call_tab() {
    $('.nav-tabs a').click(function(e) { //lobster_tab
        e.preventDefault();
        $(this).tab('show');
    });
}

function call_full_calendar() {
    var date = new Date();
    var d = date.getDate();
    var m = date.getMonth();
    var y = date.getFullYear();
    var selector = $('#calendar');
    if ($(selector).length > 0) {
        $('#calendar').fullCalendar({
            editable: false,
            events: [
                {
                    title: 'Full',
                    start: new Date(y, m, 1)
                }, {
                    title: 'Full',
                    start: new Date()
                }],
            dayClick: function() {
                $('#calendar').find('td').removeClass('selected');
                $(this).addClass('selected');
                $('#form_date').val($(this).data('date'));
            }
        });
        $('#calendar2').fullCalendar({
            editable: false,
            events: [
                {
                    title: 'Full',
                    start: new Date(y, m, 1)
                }, {
                    title: 'Full',
                    start: new Date()
                }],
            dayClick: function() {
                $('#calendar2').find('td').removeClass('selected');
                $(this).addClass('selected');
                $('#form_date2').val($(this).data('date'));
            }
        });
        $('#calendar3').fullCalendar({
            editable: false,
            events: [
                {
                    title: 'Full',
                    start: new Date(y, m, 1)
                }, {
                    title: 'Full',
                    start: new Date()
                }],
            dayClick: function() {
                $('#calendar3').find('td').removeClass('selected');
                $(this).addClass('selected');
                $('#form_date3').val($(this).data('date'));
            }
        });
    }
}

function call_datatables() {
    if ($('.datatables_group').length > 0) {
        var oTable = $('.datatables_group').dataTable({
            "fnDrawCallback": function(oSettings) {
                if (oSettings.aiDisplay.length == 0)
                {
                    return;
                }
                var nTrs = $('.datatables_group tbody tr');
                var iColspan = nTrs[0].getElementsByTagName('td').length;
                var sLastGroup = "";
                for (var i = 0; i < nTrs.length; i++)
                {
                    var iDisplayIndex = oSettings._iDisplayStart + i;
                    var sGroup = oSettings.aoData[ oSettings.aiDisplay[iDisplayIndex] ]._aData[0];
                    if (sGroup != sLastGroup)
                    {
                        var nGroup = document.createElement('tr');
                        var nCell = document.createElement('td');
                        nCell.colSpan = iColspan;
                        nCell.className = "group";
                        nCell.innerHTML = sGroup;
                        nGroup.appendChild(nCell);
                        nTrs[i].parentNode.insertBefore(nGroup, nTrs[i]);
                        sLastGroup = sGroup;
                    }
                }
            },
            "aoColumnDefs": [
                {
                    "bVisible": false,
                    "aTargets": [0]
                }
            ],
            "aaSortingFixed": [[0, 'asc']],
            "aaSorting": [[1, 'asc']],
            "sDom": 'lfr<"giveHeight"t>ip',
            "sPaginationType": "full_numbers",
            "aoColumns": [
                {
                    "sWidth": "10%"
                }, {
                    "sWidth": "45%"
                }, {
                    "sWidth": "45%"
                }]
        });
    }
}

function call_slider_sequence() {
    if ($('#sequence').length > 0) {
        var options = {
            autoPlay: true,
            autoPlayDelay: 6000,
            pauseOnHover: false,
            hidePreloaderDelay: 1000,
            nextButton: true,
            prevButton: true,
            pauseButton: true,
            preloader: true,
            hidePreloaderUsingCSS: false,
            animateStartingFrameIn: true,
            navigationSkipThreshold: 1700,
            preventDelayWhenReversingAnimations: true,
            customKeyEvents: {
                80: "pause"
            }
        };
        var sequence = $("#sequence").sequence(options).data("sequence");
    }
}


function call_grid() {
    setTimeout(function() {
        var selector = $('.gridmasonry');
        if ($(selector).length > 0) {
            $(selector).fadeIn();
            var $container = $('.gridmasonry');
            // trigger masonry
            $container.masonry({
                itemSelector: '.item_grid'
            });
        }
    }, 500);
}

function call_scroll() {
    /*Show back to top*/
    $(window).scroll(function() {
        if ($(this).scrollTop() > 250) {
            $('#top_header').addClass('mini_menu');
            $(".input-search").addClass("input-search-small").removeClass("input-search");
            $(".btn", ".input-append").addClass("search-small-btn");
            $('#back_to_top').fadeIn();
        } else {
            $('#top_header').removeClass('mini_menu');
            $(".input-search-small").addClass("input-search").removeClass("input-search-small");
            $(".btn", ".input-append").removeClass("search-small-btn");
            $('#back_to_top').fadeOut('fast');
        }
    });
    $("#back_to_top").localScroll({
        target: 'body'
    });
}

function call_lightbox() {
    if ($('.image_link').length > 0) {
        $('.image_link').magnificPopup({
            type: 'image'

        });
    }

    if ($('.galeries_footer').length > 0) {
        $('.galeries_footer').magnificPopup({
            delegate: 'a',
            type: 'image',
            tLoading: 'Loading image...',
            mainClass: 'mfp-img-mobile',
            gallery: {
                enabled: true,
                navigateByImgClick: true,
                preload: [0, 1] // Will preload 0 - before current, and 1 after the current image
            },
            image: {
                tError: 'The image could not be loaded.',
                titleSrc: function(item) {
                    return item.el.attr('title') + '<small>by Your name</small>';
                }
            }
        });
    }
}
function data_collection_forms(form) {
    var collection = {};
    collection.data = {};
    var command = $(form).attr("id");
    collection.url = "/battleWEB/controller?command=" + command;
    var post = $(form).serializeArray();
    for (var i in post) {
        collection.data[post[i].name] = post[i].value;
    }
    collection.data = JSON.stringify(collection.data);
    return collection;
}

function AjaxRegistrationLogin(form) {
    var config = data_collection_forms(form);
    $.ajax({
        url: config.url,
        type: "POST",
        dataType: "json",
        data: config.data,
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
        console.log(data, "\n faile");
    });
    console.log(config);
    return false;
}

function AjaxSendComment(form) {
    var config = data_collection_forms(form);
    $.ajax({
        url: config.url,
        type: "POST",
        dataType: "json",
        data: config.data,
        contentType: "application/json"
    }).done(function(data) {

        console.log(data);
    }).fail(function(error) {
        console.log(error);
    });
    console.log(JSON.parse(config.data));
    createComment(form, JSON.parse(config.data));
    return false;
}

function call_events_show_hide_login_registration() {
    $("a[href$=#login]").on("click", function() {
        $(".singup_area").slideUp(function() {
            $(".login_area").slideDown();
        });
    });
    $("a[href$=#singup]").on("click", function() {
        $(".login_area").slideUp(function() {
            $(".singup_area").slideDown();
        });
    });
}



function call_event_create_comment() {
    $(".comments").on("click", "a.reply", function() {
        $("#f3").focus();
        var $this = $(this);
        $("#comments_form").data("element", $this);
    });
}



function createComment(element, info) {
    var tmp = element;
    element = $(element).data("element");
    if (element) { //если контеинер получен по клику
        $(tmp).removeData("element");
        var li = element.parents("li")[0];
        var Ul = $(li).children("ul:first")[0]; // получить контеинер если существует
    }
    else {
        var Ul = $("#main_conteiner_comments"); // если коментарий не адресован пользователю то коментарий адресован проекту
    }
    console.log(Ul);
    createElements(Ul, li, info);
}

function createElements(conteiner, parent, info) {
    var li = $(document.createElement("li"));
    if (!conteiner) { // если ето первый коментарий направленный к пользователю то создать контеинер
        var ul = $(document.createElement("ul"));
        ul.appendTo(parent);
        li.appendTo(ul);
    }
    else {
        li.appendTo(conteiner);
    }

    var article = $(document.createElement("article"));
    article.appendTo(li);
    var h5 = $(document.createElement("h5"));
    h5.addClass("autor").text(info.firstname).appendTo(article); //имя зарегистрированного нужно гдето хранить или как глобальная переменная или кеш или локалсторедж

    var img = $(document.createElement("img"));
    img.addClass("avatar").attr({
        "src": "img/c1.jpg", // тоже самое со ссылкой на фото участника
        "alt": "preview"
    }).appendTo(article);
    var div = $(document.createElement("div"));
    div.addClass("comment_inner").appendTo(article);
    var p = $(document.createElement("p"));
    p.text(info.message).appendTo(div); // текст нужно получить с формы

    var a = $(document.createElement("a"));
    a.addClass("reply").text("Reply").attr({
        "href": "#comment"
    }).appendTo(div);
}

//< article >
//        < h5 class = "autor" > Bina Setiawan Grec < /h5>
//        < img class = "avatar" src = "img/c2.jpg" alt = "preview" >
//        < div class = "comment_inner" >
//              < p > Lorem ipsum dolor sit amet, consectetur adipiscing elit.Donec pretium sagittis justo vel lobortis.Suspendisse dictum eleifend quam quis porta.Mauris sit amet magna elit.Mauris sed magna vel enim congue condimentum sit amet et augue.Duis tincidunt interdum varius.Suspendisse vel sem vitae quam < /p>
//                  < a href = "#comment" class = "reply" > Reply < /a>
//        < /div>
//< /article>

function call_activate_menu_links() {
    $(".main_navbar").on("click", "a", function() { // ссылки главного меню
        $(this).parent().addClass("active").siblings().removeClass("active");
    });
    /* ############################################################################ */

    $(".lobster_tab").on("click", "a", function() {
        $(this).parent().addClass("active").siblings().removeClass("active");
    });
    /* ############################################################################ */

    $(".link_acomodation").on("click", "a", function() { // ссылки боковой навигации на странице myaccount.html
        var link = $(this).parent().addClass("active").siblings().removeClass("active").end().end().attr("href");
        link = link.substr(1).split("/");
        var url = "/frontBattleOfRotterdam/" + link[0] + " " + link[1];
        $(".span9").load(url);
        return false;
    });
}


function call_start_count_timer() {
    try {
        $("#count-down").county({endDateTime: new Date('2014/12/31 00:00:00'), reflection: false, animation: 'scroll', theme: 'black'});
    }
    catch (e) {

    }
}

function call_start_carousel() {
    $('#myCarousel').carousel();
}

function call_load_data_for_index_events() {
    var index_last_events = {
        name: "li", children: [
            {name: "div", add_class: "content_post", children: [
                    {name: "img", add_class: "pull-left img_preview", attr: {src: "img/file000995479886.jpg", alt: "preview"}},
                    {name: "h4", bind: {"text": "text"}},
                    {name: "p", bind: {"text": "text"}},
                    {name: "a", add_class: "btn btn-primary btn-mini flat", bind: {"text": "text"}}
                ]}
        ]
    };

    $("#index_last_comments").load("/battleWeb/controller?command=index", function(data) {
        call_markup_index(index_last_events, data);
        console.log(data);
    }, "json");
}

function call_load_data_for_index_comments() {
    var index_last_comments = {
        name: "li", add_class: "clearfix", children: [
            {name: "img", add_class: "pull-left img_client", attr: {src: "img/c1.jpg", alt: "image"}},
            {name: "h4", add_class: "media-heading", bind: {"text": "text"}},
            {name: "p", bind: {"text": "text"}}
        ]
    };

    $("#index_last_comments").load("/battleWeb/controller?command=index", function(data) {
        call_markup_index(index_last_comments, data);
        console.log(data);
    }, "json");
}


function call_markup_index(markupTemplate, data) {

}