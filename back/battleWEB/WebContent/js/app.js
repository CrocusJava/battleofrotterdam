$(window).load(function() {
    call_all();
});
function call_all() {
    call_grid();
    call_scroll();
//    call_slider_sequence();
    call_datatables();
    call_tab();
//    call_full_calendar();
//    call_functional_reservations();
    call_lightbox();
    call_control_color_theme();
//    call_lazy_load_images();
    call_form_validation();
//    call_events_show_hide_login_registration();

    call_event_create_comment();

//    call_activate_menu_links();


    call_start_carousel();

    call_data_for_index_html();

    call_data_for_footer();

//    call_uploading_file_on_server();


}

function call_form_validation() {
    if ($('#account').length > 0) {
        $('#account').validate({
            rules: {
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
            $('#back_to_top').fadeIn();


        } else {
            $('#top_header').removeClass('mini_menu');
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
                    return item.el.attr('title') + '<small>By ' + item.el.attr("data-user") + '</small>';
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
        if (form.id === "registration") {
            if (data.statuslogin === true && data.statusemail === true) {
                $(".modal-body>p").text(data.registrationmessage);
                $("#myModal").modal("show");
                $("#myModal").on("hide", function() {
                    window.location = "index.html";
                });
            }
        }
        if (form.id === "login") {
            if (data.iduser) {
                window.location = "myaccount.html";
            }
//"iduser": 45637932,
//"idrole": 2,
//"nameuser":"John"
        }
        console.log(data);
    }).fail(function(data) {
        console.log(data, "\n faile");
    });
    if (window.upload_file._input.files.length > 0) {
        window.upload_file.submit();
    }
    console.log(config, form.id);
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
    if ($(".comments").length > 0) {
        $(".comments").on("click", "a.reply", function() {
            $("#f3").focus();
            var $this = $(this);
            $("#comments_form").data("element", $this);
        });
    }
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


function call_start_count_timer(yearly_date, monthly_date) {
    try {
        $("#count-down-yearly").county({endDateTime: new Date(yearly_date + ' 00:00:00'), reflection: false, animation: 'scroll', theme: 'black'});
        $("#count-down-monthly").county({endDateTime: new Date(monthly_date + ' 00:00:00'), reflection: false, animation: 'scroll', theme: 'black', speed: 400});
    }
    catch (e) {

    }
}

function call_start_carousel() {
    $('#myCarousel').carousel();
}

function call_load_data_for_index_events(load_data) {
    var index_last_events_template = [
        {tag: "li", children: [
                {tag: "div", add_class: "content_post", children: [
                        {tag: "img", add_class: "pull-left img_preview", attr: {src: "photopath", alt: "preview"}},
                        {tag: "h4", text: "competitionname"},
                        {tag: "p", text: "photodescription"},
                        {tag: "p", add_class: "clear", children: [
                                {tag: "span", children: [
                                        {tag: "i", add_class: "icon-time"},
                                        {tag: "span", add_class: "padding_comment", text: "loaddate"}
                                    ]},
                                {tag: "span", add_class: "pull-right", children: [
                                        {tag: "i", add_class: "icon-user"},
                                        {tag: "span", add_class: "padding_comment", text: "userlogin"}
                                    ]}
                            ]},
                        {tag: "a", add_class: "btn btn-primary btn-mini flat", text: "Read More"}
                    ]}
            ]
        }];

    call_markup_index(index_last_events_template, $("#index_last_events"), load_data);
}



function call_load_data_for_index_comments(load_data) {
    var index_last_comments_template = [
        {tag: "li", add_class: "clearfix", children: [
                {tag: "img", add_class: "pull-left img_client", attr: {src: "userphotopath", alt: "image"}},
                {tag: "h4", add_class: "media-heading", text: "userlogin"},
                {tag: "p", text: "commenttext"},
                {tag: "p", children: [
                        {tag: "span", children: [
                                {tag: "i", add_class: "icon-time"},
                                {tag: "span", add_class: "padding_comment", text: "commentdate"}
                            ]}
                    ]}
            ]
        }];
    call_markup_index(index_last_comments_template, $("#index_last_comments"), load_data);

}




function call_data_for_index_html() {
    //<<<<<<<<<<<<=============================задачи для страницы индекс
    if (window.location.href.match(/index.html$/) || window.location.href.match(/battleWEB\/$/)) {

        $.post("/battleWEB/controller?command=index", function(respons, status) {

            //respons = JSON.parse(respons); в ответе приходит готовый объэкт, парсить не нужно

            call_start_count_timer(respons["battleyearfinishdate"], respons["battlemonthfinishdate"]);
            $("#battledescriptionshort").text(respons["battledescriptionshort"]);
            $("#battleanimationdescription").text(respons["battleanimationdescription"]);
            $("#battleanimationurl").attr("src", respons["battleanimationurl"]);

            var dataArray = respons["lastcommentslist"];
            for (var i in dataArray) {
                var dataObj = dataArray[i];
                call_load_data_for_index_comments(dataObj);
            }

            var dataArray = respons["lastphotoslist"];
            for (var i in dataArray) {
                var dataObj = dataArray[i];
                call_load_data_for_index_events(dataObj);
            }


            console.log("Respons data for index ====> ", status);
        }, "json").fail(function(data) {
            console.log("Somsing wrang", data);
        });
    }

    //<<<<<<<<<<<<=============================задачи для страницы поска

    if (window.location.href.match(/search.html$/)) {
        var result_search = $("#result_search");
        $("#search").on("keyup", function() {
            var $this = $(this);
            $(result_search).text($this.val());
            if ($this.val().length >= 3) {
                console.log("ajax");
            }
        });
    }

    //<<<<<<<<<<<<=============================задачи для страницы вопросов и ответов

    if (window.location.href.match(/FAQ.html$/)) {
        call_data_for_faq();
    }

    //<<<<<<<<<<<<=============================задачи для страницы про нас

    if (window.location.href.match(/about_battle.html$/)) {
        call_load_data_for_about_battle();
    }

}




function call_markup_index(markupTemplate, parentsContainer, dataObj) {

    for (var j in markupTemplate) {

        var templateObj = markupTemplate[j];
        // <<<<<<<<<<================================== Создание элемента тега
        if ("tag" in templateObj) {
            var element = $(document.createElement(templateObj["tag"]));
            element.appendTo(parentsContainer);
            var new_parentsContainer = element;
        }
        // <<<<<<<<<<================================== Добавление класса к элементу
        if ("add_class" in templateObj) {
            element.addClass(templateObj["add_class"]);
        }
        // <<<<<<<<<<================================== Добавление атрибутов к элементу
        if ("attr" in templateObj) {
            var attr = templateObj["attr"];
            for (var name_prop in attr) {
                var value = attr[name_prop];
                value = dataObj[value] || value;
                element.attr(name_prop, value);
            }
        }
        // <<<<<<<<<<================================== Добавление текста к элементу
        if ("text" in templateObj) {
            var text_key = templateObj["text"];
            text_key = dataObj[text_key] || text_key;
            element.text(text_key);
        }
        // <<<<<<<<<<================================== Добавление дочерих элементов к элементу
        if ("children" in templateObj) {
            call_markup_index(templateObj["children"], new_parentsContainer, dataObj);
        }

    }

}

function call_load_data_for_footer_links(load_data) {
    var index_footer_links_template = [
        {tag: "li", children: [
                {tag: "a", attr: {href: "linkurl"}, text: "linktitle"}
            ]}
    ];
    call_markup_index(index_footer_links_template, $("#footer_links"), load_data);
}

function call_load_data_for_footer_gallery(load_data) {
    var index_footer_gallery_template = [
        // <div class="item_grid item3">
//          <a href="img/5388055503_bdfec0a3d5.jpg" title="Image Title">
//               <div class="hover"></div>
//               <img src="img/5388055503_bdfec0a3d5.jpg" alt="img_preview">
//          </a>
//      </div>
        {tag: "div", add_class: "item_grid item3", children: [
                {tag: "a", attr: {href: "photopath", title: "projectname", "data-user": "userlogin"}, children: [
                        {tag: "div", add_class: "hover"},
                        {tag: "img", attr: {src: "photopath", alt: "img_preview"}}
                    ]}
            ]}
    ];
    call_markup_index(index_footer_gallery_template, $("#footer_gallery"), load_data);
}

function call_data_for_footer() {
    $.post("/battleWEB/controller?command=footer", function(respons, status) {

        //respons = JSON.parse(respons); в ответе приходит готовый объэкт, парсить не нужно



        var dataArray = respons["battlelinks"];
        for (var i in dataArray) {
            var dataObj = dataArray[i];
            call_load_data_for_footer_links(dataObj);
        }

        var dataArray = respons["footergallery"];
        for (var i in dataArray) {
            var dataObj = dataArray[i];
            call_load_data_for_footer_gallery(dataObj);
        }
        //<<<<<<<<<<<<<========= Вызов плагина масонри для выравнивания картинок
        call_grid();

        console.log("Respons data for footer ====> ", status);
    }, "json").fail(function(data) {
        console.log("Somsing wrang", data);
    });
}


function call_uploading_file_on_server(command_value) {
    if (window.location.href.match(/registration.html#registration$/)) {
        var command_value = "uploadavatar";
    }
//  /battleWEB/controller?command=upload', //command=uploadavatar command=uploadphoto
    window.upload_file = new AjaxUpload(command_value, {
        action: '/battleWEB/controller?command=' + command_value, //command=uploadavatar command=uploadphoto
        name: command_value,
        data: {
            'some_key1': "This data won't be sent, we will overwrite it."
        },
        autoSubmit: false,
        onChange: function(file, ext) {
            if (ext && /^(jpg|gif|jpeg|bmp|png)$/.test(ext)) {
                var reader = new FileReader();
                $(reader).on("load", function() {
                    var img = $("#preview_avatar");
                    $(img).attr("src", reader.result);
                });
                reader.readAsDataURL(window.upload_file._input.files[0]);


            } else {
                //<<<<<<<<<<<<<<<<<<<<<=========================здесь код что файл не поддерживается
                $("#warning_load_file").show();
                $("#warning_load_file").fadeOut(5000);
                return false;
            }

        },
        onSubmit: function(file, ext) {
            if (ext && /^(jpg|gif|jpeg|bmp|png)$/.test(ext)) {
            } else {
                //<<<<<<<<<<<<<<<<<<<<<=========================здесь код что файл не поддерживается
                return false;
            }
        },
        onComplete: function(file, response) {


        }
    });


}


function call_data_for_faq() {
    $.post("/battleWEB/controller?command=faq", function(data) {
        var count = 0;
        function return_faq_template_end_scope(count) {

            return [
                {tag: "div", add_class: "panel panel-defaul", children: [
                        {tag: "div", add_class: "panel-heading", children: [
                                {tag: "h4", add_class: "panel-title", children: [
                                        {tag: "a", add_class: "collapsed", attr: {"data-toggle": "collapse", "data-parent": "#accordion", "href": ("#" + count)}, text: "faqquestion"}
                                    ]}
                            ]},
                        {tag: "div", add_class: "panel-collapse collapse", attr: {id: count}, children: [
                                {tag: "div", add_class: "panel-body", text: "faqansver"}
                            ]}
                    ]}
            ];

        }



        var faqlist = data.faqlist;

        for (var list in faqlist) {
            call_markup_index(return_faq_template_end_scope(count), $("#accordion"), faqlist[list]);
            count++;
        }

    }, "json").fail(function() {
        console.log("not loaded FAQ list");
    });
}


function call_load_data_for_myaccount() {
    $.post("/battleWEB/controller?command=account", function(data) {
        console.log(data);
    }, "json");
}

function call_load_data_for_about_battle() {
    $.post("/battleWEB/controller?command=aboutbattle", function(data) {
        var template_for_about_battle = [
            {tag: "h4", add_class: "text_center", text: "title"},
            {tag: "p", text: "description"}
        ];
        call_markup_index(template_for_about_battle, $("#aboutbattle"), data.aboutbattle);
        call_markup_index(template_for_about_battle, $("#rules "), data.rules);
        call_markup_index(template_for_about_battle, $("#aboutus"), data.aboutus);
        call_markup_index(template_for_about_battle, $("#information"), data.information);
        console.log(data);
    }, "json").fail("data for about battle not loaded");
}