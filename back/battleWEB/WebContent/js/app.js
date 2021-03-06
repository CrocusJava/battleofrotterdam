$(window).load(function() {
    call_all();
});
function call_all() {
    call_setup_localozation();

    call_scroll();
//    call_slider_sequence();
//    call_datatables();
//    call_tab();


    call_lightbox();
    call_control_color_theme();

    call_form_validation();


    call_event_create_comment();
    call_start_carousel();
    call_data_for_index_html();
    call_cookie_navigator();
    call_data_for_footer();
    call_uploading_file_on_server();
    //$(".trylater").click(trylater());
    call_trylater();
}

function call_form_validation() {

    if ($('.login_form_validation').length > 0) {
        $('.login_form_validation').validate({
            submitHandler: AjaxRegistrationLogin
        });
    }
    if ($('#forgotpassword').length > 0) {
        $('#forgotpassword').validate({
            submitHandler: AjaxRegistrationLogin
        });
    }
    if ($('.comment_form_validation').length > 0) {
        $('.comment_form_validation').validate({
            submitHandler: AjaxSendComment
        });
    }
    if ($('#search').length > 0) {
        $('#search').validate({
            submitHandler: AjaxSendSearch
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



//function call_tab() {
//    $('.nav-tabs a').click(function(e) { //lobster_tab
//        e.preventDefault();
//        $(this).tab('show');
//    });
//}



//function call_datatables() {
//    if ($('.datatables_group').length > 0) {
//        var oTable = $('.datatables_group').dataTable({
//            "fnDrawCallback": function(oSettings) {
//                if (oSettings.aiDisplay.length == 0)
//                {
//                    return;
//                }
//                var nTrs = $('.datatables_group tbody tr');
//                var iColspan = nTrs[0].getElementsByTagName('td').length;
//                var sLastGroup = "";
//                for (var i = 0; i < nTrs.length; i++)
//                {
//                    var iDisplayIndex = oSettings._iDisplayStart + i;
//                    var sGroup = oSettings.aoData[ oSettings.aiDisplay[iDisplayIndex] ]._aData[0];
//                    if (sGroup != sLastGroup)
//                    {
//                        var nGroup = document.createElement('tr');
//                        var nCell = document.createElement('td');
//                        nCell.colSpan = iColspan;
//                        nCell.className = "group";
//                        nCell.innerHTML = sGroup;
//                        nGroup.appendChild(nCell);
//                        nTrs[i].parentNode.insertBefore(nGroup, nTrs[i]);
//                        sLastGroup = sGroup;
//                    }
//                }
//            },
//            "aoColumnDefs": [
//                {
//                    "bVisible": false,
//                    "aTargets": [0]
//                }
//            ],
//            "aaSortingFixed": [[0, 'asc']],
//            "aaSorting": [[1, 'asc']],
//            "sDom": 'lfr<"giveHeight"t>ip',
//            "sPaginationType": "full_numbers",
//            "aoColumns": [
//                {
//                    "sWidth": "10%"
//                }, {
//                    "sWidth": "45%"
//                }, {
//                    "sWidth": "45%"
//                }]
//        });
//    }
//}

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


function call_lightbox_news() {
    if ($('.news_index').length > 0) {
        $('.news_index').magnificPopup({
            delegate: 'a',
            type: 'image',
            tLoading: 'Loading image...',
            mainClass: 'mfp-img-mobile',
            image: {
                tError: 'The image could not be loaded.',
                titleSrc: function(item) {
                    return item.el.attr('title');
                }
            }
        });


    }

}

function call_lightbox_current_rank() {
    if ($('.current_rank').length > 0) {
        $('.current_rank').magnificPopup({
            delegate: 'a',
            type: 'image',
            tLoading: 'Loading image...',
            mainClass: 'mfp-img-mobile',
            image: {
                tError: 'The image could not be loaded.',
                titleSrc: function(item) {
                    return item.el.attr('title');
                }
            }
        });


    }

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
                    return '<a href="single_project.html#projectid=' + item.el.attr('projectid') + '">' + item.el.attr('title') + '<small>By ' + item.el.attr("data-user") + '</small></a>';
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
    if (form.id === "sendcomment") {
        collection.data["projectid"] = window.projectId;
    }
    if (form.id === "search") {
        collection.data["firstposition"] = 0;
        collection.data["size"] = 10;
    }

    collection.data = JSON.stringify(collection.data);
    return collection;
}

function AjaxRegistrationLogin(form) {
    call_disabling_submit_button();
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
                $("#myModal > div.modal-body>p").text(data.registrationmessage);
                $("#myModal").modal("show");
                $("#myModal").on("hide", function() {
                    window.location = "index.html";
                });
            }
            else if (!data.statuslogin) {
                alert("когда логин занят \n" + data.registrationmessage + "\n попробуйте еще раз");
            }
            else if (!data.statusemail) {
                alert("когда эмэел занят \n" + data.registrationmessage + "\n попробуйте еще раз");
            }
        }
        if (form.id === "login") {
            if (data.iduser) {
                $.session.set("login", true);
                window.location = "myaccount.html";
            }
            else {
                $.session.set("login", false);
                $("#sorry").text(data.message);
                $("input").focus(function() {
                    $("#sorry").text("");
                });
            }
        }

        if (form.id === "forgotpassword") {
            if (data.newpasswordmessage) {
                $("#newpasswordmessage").text(data.newpasswordmessage);
            }
        }

        call_enabling_submit_button();
        console.log(data);
    }).fail(function(data) {
        $.session.set("login", false);
        $("#sorry").text("Sorry, no guessing. Try again.");
        $("input").focus(function() {
            $("#sorry").text("");
        });
        call_enabling_submit_button();
        console.log(data, "\n faile");
    });
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
        if (data["status"] === true) {
            createComment(form, JSON.parse(config.data));
            $("#f3").val("");
        }
        else {
            alert(data["message"]);
        }
        console.log(data);
    }).fail(function(error) {
        console.log(error);
    });
    console.log(JSON.parse(config.data));
    return false;
}


function call_event_create_comment() {
    if ($(".comments").length > 0) {
        $(".comments").on("click", "a.reply", function() {
            $("#f3").focus();
            var $this = $(this);
            $("#sendcomment").data("element", $this);
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
        li.prependTo(conteiner);
    }

    var article = $(document.createElement("article"));
    article.appendTo(li);
    var h5 = $(document.createElement("h5"));
    h5.addClass("autor").text($.session.get("name")).appendTo(article); //имя зарегистрированного нужно гдето хранить или как глобальная переменная или кеш или локалсторедж

    var img = $(document.createElement("img"));
    img.addClass("avatar").attr({
        "src": $.session.get("avatar"), // тоже самое со ссылкой на фото участника
        "alt": "preview"
    }).appendTo(article);
    var div = $(document.createElement("div"));
    div.addClass("comment_inner").attr("style", "display:block;").appendTo(article);
    var p = $(document.createElement("p"));
    p.text(info.commenttext).appendTo(div); // текст нужно получить с формы

    var p_time = $(document.createElement("p"));
    p_time.attr({
        "style": "color:rgba(0, 181, 0,1);"
    }).appendTo(div);
    var i = $(document.createElement("i"));
    i.addClass("icon-time").appendTo(p_time);
    var span = $(document.createElement("span"));
    span.addClass("padding_comment").attr({
        "name": "time"
    }).text((new Date().toLocaleString())).appendTo(p_time);
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
    function go_to_project() {
        var href = $(this).attr("href");
        href = href + "#projectid=" + load_data["projectid"];
        $(this).attr("href", href);
    }

    var index_last_events_template = [
        {tag: "li", children: [
                {tag: "div", add_class: "content_post", children: [
                        {tag: "img", add_class: "pull-left img_preview", attr: {src: "photopath", alt: "preview"}},
                        {tag: "h4", text: "projectname"},
                        {tag: "p", add_class: "single_row_index", text: "photodescription"},
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
                        {tag: "a", attr: {href: "single_project.html"}, add_handler: {"click": go_to_project}, add_class: "btn btn-primary btn-mini flat", children: [
                                {tag: "span", add_class: "en unvisiblin", text: "Read More"},
                                {tag: "span", add_class: "nl", text: "Lees meer"}]
                        }
                    ]}
            ]
        }];
    call_markup_index(index_last_events_template, $("#index_last_events"), load_data);
}



function call_load_data_for_index_comments(load_data) {
    function go_to_user_profile() {
        var href = $(this).attr("href");
        href = href + "#userid=" + load_data["userid"];
        $(this).attr("href", href);
    }
    function go_to_project() {
        var href = $(this).attr("href");
        href = href + "#projectid=" + load_data["projectid"];
        $(this).attr("href", href);
    }
    var index_last_comments_template = [
        {tag: "li", add_class: "clearfix", children: [
                {tag: "a", attr: {href: "static_profile.html"}, add_handler: {"click": go_to_user_profile}, children: [
                        {tag: "img", add_class: "pull-left img_client", attr: {src: "userphotopath", alt: "image"}}
                    ]},
                {tag: "h4", add_class: "media-heading", text: "userlogin"},
                {tag: "a", attr: {href: "single_project.html"}, add_handler: {"click": go_to_project}, children: [
                        {tag: "p", add_class: "single_row", text: "commenttext"},
                        {tag: "p", children: [
                                {tag: "span", children: [
                                        {tag: "i", add_class: "icon-time"},
                                        {tag: "span", add_class: "padding_comment", text: "commentdate"}
                                    ]}
                            ]}
                    ]}
            ]
        }];
    call_markup_index(index_last_comments_template, $("#index_last_comments"), load_data);
}




function call_data_for_index_html() {
//<<<<<<<<<<<<=============================задачи для страницы индекс
    if (window.location.href.match(/index.html/) || window.location.href.match(/battleWEB\/$/)) {


        call_load_data_for_news_index();
        $.post("/battleWEB/controller?command=index", function(respons, status) {

            call_start_count_timer(respons["battleyearfinishdate"], respons["battlemonthfinishdate"]);
            $("#battledescriptionshort").html(respons["battledescriptionshort"]);
            $("#battleanimationdescription").html(respons["battleanimationdescription"]);
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
            call_setup_localozation();
        }, "json").fail(function() {
            console.log("Somsing wrang for inde post");
        });
    }

//<<<<<<<<<<<<=============================задачи для страницы поиска

    if (window.location.href.match(/search.html$/)) {
//пока задач нет но появлятся
    }

//<<<<<<<<<<<<=============================задачи для страницы вопросов и ответов

    if (window.location.href.match(/FAQ.html$/)) {
        call_data_for_faq();
    }

//<<<<<<<<<<<<=============================задачи для страницы про нас

    if (window.location.href.match(/about_battle.html$/)) {
        call_load_data_for_about_battle();
    }

//<<<<<<<<<<<<=============================задачи для страницы мой акаунт

    if (window.location.href.match(/myaccount.html/)) {

        call_load_data_for_myaccount();
    }
//<<<<<<<<<<<<=============================задачи для страницы учасники или конкурс

    if (window.location.href.match(/competitions.html$/)) {
        call_data_load_for_competitions();
    }

//<<<<<<<<<<<<=============================задачи для страницы логина

    if (window.location.href.match(/login.html#login$/) || window.location.href.match(/login.html$/)) {
        call_modal_window_forgotten_password();
    }

//<<<<<<<<<<<<=============================задачи для страницы вывода троих лидеров по годовому и месячному соревнованию

    if (window.location.href.match(/current_rankings.html$/)) {
        call_load_data_for_current_rankings();
    }

//<<<<<<<<<<<<=============================задачи для страницы вывода всех проектов

    if (window.location.href.match(/projets.html$/)) {
        call_load_data_for_projets_page(0);
    }

//<<<<<<<<<<<<=============================задачи для всех страницы


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
                // <<<<<<<<<<================================== Если атрибут является объектом
                if ({}.toString.call(value) === "[object Object]") {
// <<<<<<<<<<================================== Требуется сабатрибут для опредиления конечного значения
                    var subvalue = value[templateObj["subattr"][name_prop]];
                    element.attr(name_prop, subvalue);
                }
                else {
                    element.attr(name_prop, value);
                }
            }
        }
// <<<<<<<<<<================================== Добавление текста к элементу
        if ("text" in templateObj) {
            var text_key = templateObj["text"];
            var text_value = dataObj[text_key] ? dataObj[text_key] : dataObj[text_key] === 0 ? 0 : dataObj[text_key] === "" ? "  " : text_key; //var text_value = dataObj[text_key] || text_key;
            // <<<<<<<<<<================================== Если текст является объектом
            if ({}.toString.call(text_value) === "[object Object]") {
// <<<<<<<<<<================================== Требуется сабатрибут для опредиления конечного значения
                var subvalue_text = text_value[templateObj["subattr"][text_key]];
                element.text(subvalue_text);
            }
            else {
                element.text(text_value);
            }

        }
// <<<<<<<<<<================================== Добавление обработчика событий к элементу
        if ("add_handler" in templateObj) {
            for (var event in templateObj["add_handler"]) {
                element.on(event, templateObj["add_handler"][event]);
            }
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
        {tag: "div", add_class: "nomasonry item_grid item3", children: [
                {tag: "a", attr: {href: "photopath", title: "projectname", "data-user": "userlogin", projectid: "projectid"}, children: [
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


        call_load_data_for_index_footer_contacts(respons["contacts"]);
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
//        call_grid();
        console.log("Respons data for footer ====> ", status);
    }, "json").fail(function(data) {
        console.log("Somsing wrang", data);
    });
}


function call_uploading_file_on_server() {
    var command_value;
    var target;
    if (window.location.href.match(/myaccount.html/)) {
        command_value = "uploadavatar";
        target = "uploadavatar";
    }

    if (window.location.href.match(/edit_project.html/)) {
        command_value = "uploadphoto&projectid=" + window.projectId;
        target = "uploadphoto";
    }

    if (target) {
        window.upload_file = new AjaxUpload(target, {
            action: '/battleWEB/controller?command=' + command_value, //command=uploadavatar command=uploadphoto

            autoSubmit: false,
            responseType: "json",
            onChange: function(file, ext) {
                if (ext && /^(jpg|gif|jpeg|bmp|png)$/.test(ext)) {
                    var reader = new FileReader();
                    if (target === "uploadavatar") {
                        $(reader).on("load", function() {
                            var img = $("#preview_avatar");
                            $(img).attr("src", reader.result);
                        });
                    }
                    if (target === "uploadphoto") {
                        $(reader).on("load", function() {
                            call_new_added_photo_for_edit_project(reader.result);
                        });
                    }

                    reader.readAsDataURL(window.upload_file._input.files[0]);
                } else {
//<<<<<<<<<<<<<<<<<<<<<=========================здесь код что файл не поддерживается

                    alert("Можно загружать только файлы с разширением jpg | gif | jpeg | bmp | png ");
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
                console.log("передача файла завершена");
                try {
                    var parent_block = window.upload_file.block_of_sended_photo;
                    try {
                        $(parent_block).data({"fixed_id_photo": response["idphoto"]});
                    }
                    catch (e) {
                        console.log(e);
                    }
                    $(parent_block).trigger("my_send.description");

                    console.log(response);
                    console.log(parent_block);
                    console.log(window.upload_file.upload_desription);

                    call_send_description_for_this_photo(response["idphoto"], window.upload_file.upload_desription);


                }
                catch (e) {
                }

            }
        });
    }

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
            call_markup_for_admin_text(return_faq_template_end_scope(count), $("#accordion"), faqlist[list]);
            count++;
        }

    }, "json").fail(function() {
        console.log("not loaded FAQ list");
    });
}




function call_load_data_for_about_battle() {
    $.post("/battleWEB/controller?command=aboutbattle", function(data) {
        var template_for_about_battle = [
            {tag: "h1", add_class: "font_hotel", text: "title"},
            {tag: "p", text: "description"}
        ];
        call_markup_for_admin_text(template_for_about_battle, $("#aboutbattle"), data.aboutbattle);
        call_markup_for_admin_text(template_for_about_battle, $("#rules "), data.rules);
        call_markup_for_admin_text(template_for_about_battle, $("#aboutus"), data.aboutus);
        call_markup_for_admin_text(template_for_about_battle, $("#information"), data.information);
        console.log(data);
    }, "json").fail("data for about battle not loaded");
}

function call_event_logout() {
    $("#logout").click(function() {
        $.post("/battleWEB/controller?command=logout");
        $.session.set("login", false);
        window.location = "index.html";
    });
}



function call_load_data_for_news_index() {
    $.post("/battleWEB/controller?command=news", function(data) {
        var template_for_news_index = [
            {tag: "div", add_class: "span4 text_center", children: [
                    {tag: "div", add_class: "news_index boxfeature", children: [
                            {tag: "a", attr: {href: "photopath", title: "text", "data-href": "photopath"}, children: [
                                    {tag: "div", add_class: "hover"},
                                    {tag: "div", add_class: "img_preview", children: [
                                            {tag: "img", attr: {src: "photopath", "data-src": "photopath", alt: "img_preview"}},
                                            {tag: "h4", text: "loaddate"}
                                        ]},
                                    {tag: "div", add_class: "desc", children: [
                                            {tag: "p", text: "title"}



                                        ]}
                                ]}

                        ]}

                ]}
        ];
        /*=======================мой код для попапа================================*/
        var template_for_news_index_popup = [
            {tag: "div", add_class: "popvis text_center", children: [
                    {tag: "div", add_class: "boxfeature", children: [
                            {tag: "div", add_class: "img_preview", children: [
                                    {tag: "i", add_class: "icon-remove close_popup_news"},
                                    {tag: "img", attr: {src: "photopath", "data-src": "photopath", alt: "img_preview"}},
                                    {tag: "h4", text: "loaddate"}
                                ]},
                            {tag: "div", add_class: "desc_news desc", children: [
                                    {tag: "p", text: "text"}
                                ]}
                        ]}
                ]},
            {tag: "div", add_class: "popup_back_news"}
        ];
        /*=======================конец моего кода для попапа============================*/




        for (var i in data.lastnews) {
            var data_popup_news = data.lastnews[i];
            call_markup_for_admin_text(template_for_news_index, $("#news_index"), data.lastnews[i]);
            call_lightbox_news();


        }


    }, "json").fail(function() {
        console.log("Error for load news");
    });
}



/*=======================Рекомендовано для передачи данных в формате JSON============================*/
function call_data_load_for_competitions() {
    var year = JSON.stringify(
            {
                firstposition: 0,
                size: 1,
                filter: {
                    type: "year"  //year / month // 2 запрос а разрыми параметрами type
                }
            });
    var month = JSON.stringify(
            {
                firstposition: 0,
                size: 1,
                filter: {
                    type: "month"  //year / month // 2 запрос а разрыми параметрами type
                }
            });
    $.ajax({
        type: "POST",
        url: "/battleWEB/controller?command=competitions",
        dataType: "json",
        contentType: "application/json",
        data: year
    }).done(function(year) {
        year = year.competitions[0];
        $("#yearly_battle_competitions_name").html(year["name"]);
        $("#yearly_battle_competitions_startdate").html(year["startdate"]);
        $("#yearly_battle_competitions_enddate").html(year["enddate"]);
        $("#yearly_battle_competitions_description").html(year["description"]);
        call_setup_localozation();
    }).fail(function() {
        console.log("Error for load for competitions.html");
    });
    $.ajax({
        type: "POST",
        url: "/battleWEB/controller?command=competitions",
        dataType: "json",
        contentType: "application/json",
        data: month
    }).done(function(month) {
        month = month.competitions[0];
        $("#monthly_battle_competitions_name").html(month["name"]);
        $("#monthly_battle_competitions_startdate").html(month["startdate"]);
        $("#monthly_battle_competitions_enddate").html(month["enddate"]);
        $("#monthly_battle_competitions_description").html(month["description"]);
        call_setup_localozation();
    }).fail(function() {
        console.log("Error for load for competitions.html");
    });
}

function call_modal_window_forgotten_password() {
    $("#forgotten_password").click(function() {
        $("#myModal").modal("show");
    });
}


function call_disabling_submit_button() {
    if ($("#forgotpassword button[type=submit]").length > 0) {
        $("#forgotpassword button[type=submit]").each(function() {
            var $this = $(this);
            $this.addClass("disabled");
            $this.prop("disabled", true);
        });
    }
}

function call_enabling_submit_button() {
    if ($("#forgotpassword button[type=submit]").length > 0) {
        $("#forgotpassword button[type=submit]").each(function() {
            var $this = $(this);
            $this.removeClass("disabled");
            $this.prop("disabled", false);
        });
    }
}

function call_trylater() {
    $(".trylater").click(function() {
        $('body').append('<div class="popup_text">Try Later. Thank YOU for understanding and patience</div>');
        $('body').append('<div class="popup_back"></div>');
        $('.popup_text').append('<input type="button" class="close_popup" value="Ok"></div>');
        $('.close_popup').click(function() {
            $('.popup_text').remove();
            $('.popup_back').remove();
        });
    });
}

/*
 function call_load_data_for_news_index() {
 $.post("/battleWEB/controller?command=news", function(data) {
 var template_for_news_index = [
 {tag: "div", add_class: "span4 text_center", children: [
 {tag: "div", add_class: "news_index boxfeature", children: [
 {tag: "a", attr: {href: "photopath", title: "text", "data-href": "photopath"}, children: [
 {tag: "div", add_class: "hover"},
 {tag: "div", add_class: "img_preview", children: [
 {tag: "img", attr: {src: "photopath", "data-src": "photopath", alt: "img_preview"}},
 {tag: "h4", text: "loaddate"}
 ]}
 ]},
 {tag: "div", add_class: "desc", children: [
 {tag: "p", text: "text"},
 {tag: "p", children: [
 {tag: "a", add_class: "unvisiblin news_butt btn btn-primary flat btn-large", text: "Read More", add_handler: {"click": "popup_news"}
 //, bind: {popup_news:click}
 }
 ]}
 ]}


 ]}

 ]}
 ];


 */

function call_load_data_for_current_rankings() {
    $.post("/battleWEB/controller?command=currentrankings", function(data) {
        function go_to_project() {
            var href = $(this).attr("href");
            var projectid = $(this).attr("projectid");
            href = href + "#projectid=" + projectid;
            $(this).attr("href", href);
        }
        var count = 0;
        function return_carent_rankings_template(count, img) {

            return [
                {tag: "div", add_class: "span4 text_center", children: [
                        {tag: "div", add_class: "boxfeature_", children: [
                                {tag: "div", add_class: "current_rank img_preview_", children: [
                                        {tag: "a", attr: {href: "lastphoto", title: "lastphoto", "data-href": "lastphoto"}, subattr: {href: "path", title: "description", "data-href": "path"}, children: [
                                                {tag: "div", add_class: "hover"},
                                                {tag: "img", attr: {src: "lastphoto", "data-src": "", alt: "img_preview"}, subattr: {src: "path"}},
                                                {tag: "a", add_class: "label flat label-success likes", attr: {"href": ""}, children: [
                                                        {tag: "span", text: "rating"},
                                                        {tag: "span", add_class: "en unvisiblin", text: " Likes"},
                                                        {tag: "span", add_class: "nl", text: " Sympathieën"}
                                                    ]},
                                                {tag: "a", add_class: "label flat label-success label_comments", attr: {"href": ""}, children: [
                                                        {tag: "span", text: "commentquantity"},
                                                        {tag: "span", add_class: "en unvisiblin", text: " Comments"},
                                                        {tag: "span", add_class: "nl", text: " Reacties"}
                                                    ]},
                                                {tag: "img", attr: {src: "img/" + img + ".png"}, add_class: ("star" + count)}


                                            ]}
                                    ]},
                                {tag: "div", add_class: "desc", children: [
                                        {tag: "p", add_class: "single_row", text: "lastphoto", subattr: {"lastphoto": "description"}},
                                        {tag: "p", children: [
                                                {tag: "a", add_class: "btn btn-primary flat btn-large", attr: {href: "single_project.html", projectid: "id"}, add_handler: {"click": go_to_project}, children: [
                                                        {tag: "span", add_class: "en unvisiblin", text: "Read More"},
                                                        {tag: "span", add_class: "nl", text: "Lees meer"}

                                                    ]}
                                            ]}
                                    ]}
                            ]}
                    ]}
            ];
        }

        var yearprojects = data["yearprojects"];
        var monthprojects = data["monthprojects"];
        for (var i in monthprojects) {
            ++count;
            call_markup_index(return_carent_rankings_template(count, count), $("#monthly_battle_competitions"), monthprojects[i]);

        }
        count = 0;
        for (var i in yearprojects) {
            ++count;
            call_markup_index(return_carent_rankings_template(count, count), $("#yearly_battle_competitions"), yearprojects[i]);

        }

        call_lightbox_current_rank();
        call_setup_localozation();
    }).fail(function() {
        console.log("ошибка загрузки данных по current_rankings");
    });
}




function call_load_data_for_viewproject() {

    var viewproject_template = [];
    var send_data = {projectid: 17};
    $.ajax({
        type: "POST",
        url: "/battleWEB/controller?command=viewproject",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(send_data)
    }).done(function(respons) {
        console.log(respons);
    });
}


function call_load_data_for_index_footer_contacts(contacts) {
    var index_contacts_template = [
        {tag: "li", add_class: "location", text: "contactsaddress"},
        {tag: "li", add_class: "phone", children: [
                {tag: "span", text: "contactsphone"},
                {tag: "br"},
                {tag: "span", text: "contactsfax"}
            ]},
        {tag: "li", add_class: "skype", children: [
                {tag: "a", attr: {href: "skype:echo123?call"}, text: "contactsskype"}
            ]},
        {tag: "li", text: "contactsemail"}
    ];
    call_markup_index(index_contacts_template, $("#index_contact_info"), contacts);
}


function call_load_data_for_page_contacts(contacts) {
    var contacts_template = [
        {tag: "div", add_class: "name_static_profile font-hotel", text: "Contact Us"},
        {tag: "div", add_class: "margin_text_longname", children: [
                {tag: "span", add_class: "en unvisiblin", text: "University of Applied Sciences Rotterdam"},
                {tag: "span", add_class: "nl", text: "Hogeschool Rotterdam"}
            ]},
        {tag: "div", add_class: "margin_text", text: "contactsaddress"},
        {tag: "div", add_class: "margin_text", text: "contactsphone"},
        {tag: "div", add_class: "margin_text", text: "contactsfax"},
        {tag: "div", add_class: "margin_text", text: "contactsemail"},
        {tag: "div", add_class: "skype", children: [
                {tag: "a", attr: {href: "skype:echo123?call"}, text: "contactsskype"}
            ]}

    ];
    call_markup_index(contacts_template, $("#contacts_page_content"), contacts);
}




function call_load_data_for_myaccount(id) {

    var send_data = {iduser: (id ? id : 0)};
    $.ajax({
        type: "POST",
        url: "/battleWEB/controller?command=account",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(send_data)
    }).done(function(respons) {

        if (!send_data.iduser) {
            $.session.set("name", respons["login"]);
            $.session.set("avatar", respons["photopath"]);
            call_cookie_navigator();
        }


        $("#preview_avatar").attr({"src": respons["photopath"], "data-src": respons["photopath"]});

        applyKO(respons);

        //        $.session.set("avatar", respons["photopath"]);
        /* действие области работы KNOCKOUT JS
         $("#name_static_profile").text(respons["login"]);
         $("#FirstName").text(respons["firstname"]);
         $("#MiddletName").text(respons["middlename"]);
         $("#LastName").text(respons["lastname"]);
         $("#birthday").text(respons["birthday"]);
         $("#town").text(respons["town"]);
         $("#street").text(respons["street"]);
         $("#housenumber").text(respons["housenumber"]);
         $("#postcode").text(respons["postcode"]);
         $("#telephone").text(respons["phone"]);
         $("#mail").text(respons["email"]);
         */

        if (id) {
            for (var project in respons["projects"]) {
                call_create_murkup_for_static_profile_projects(respons["projects"][project], respons);
            }
        }
        else {
//            for (var project in respons["projects"]) {
//                call_create_murkup_for_account_projects(respons["projects"][project], respons);
//            }
        }
        call_setup_localozation();
    }).fail(function() {
        if (!send_data.iduser) { //если акаунт мой то выйти
            $("#logout").trigger("click");
        }
    });
}





function call_upload_data_for_updateaccaunt() {
    var uploadData = {};
    uploadData.login = $("#name_static_profile").text();
    uploadData.firstname = $("#FirstName").text();
    uploadData.middlename = $("#MiddletName").text();
    uploadData.lastname = $("#LastName").text();
    uploadData.birthday = $("#birthday").text();
    uploadData.phone = $("#telephone").text();
    uploadData.email = $("#mail").text();
    uploadData.town = $("#town").text();
    uploadData.street = $("#street").text();
    uploadData.housenumber = $("#housenumber").text();
    uploadData.postcode = $("#postcode").text();
    uploadData.password = $("#password").val();
    uploadData.passwordnew = $("#passwordnew").val();
    var password_ = $("#password_").val();
    if (password_ !== uploadData.passwordnew) {
        alert("Пароль не совпадает!!!!!!!!!!");
        return false;
    }
    uploadData = JSON.stringify(uploadData);
    $.ajax({
        type: "POST",
        url: "/battleWEB/controller?command=updateaccount",
        dataType: "json",
        contentType: "application/json",
        data: uploadData
    }).done(function(data) {
        alert(data.message);
    }).fail(function() {
        console.log("Problemi s obnovleniem dannih");
    });
}

//function call_create_murkup_for_account_projects(project, respons) {
//
//    function  call_delete_project(event) {
//        var deleting_project = {
//            projectid: project["projectid"]
//        },
//        url = "/battleWEB/controller?command=deleteproject";
////        $("#Modal_delete_project").modal("show");
//
//        if ('') {
//            deleting_project = JSON.stringify(deleting_project);
//
//            $.ajax({
//                type: "POST",
//                url: url,
//                dataType: "json",
//                contentType: "application/json",
//                data: deleting_project
//            }).done(function(data) {
//                console.log(data);
//                window.location.reload();
//            }).fail(function(error) {
//                console.log("Problemi s Удалением проекта", error);
//                alert("ERRORE DELETING");
//                window.location.reload();
//            });
//        }
//        event.preventDefault();
//        /*POST
//         command:deleteproject
//         url:http://edu.bionic-universitsingle_project.htmly.com:1120/battleWEB/controller
//
//         {
//         “projectid”:23
//         }
//         window.location.reload()
//         **/
//    }
//    var template_for_project = '<section class="project_block" >' +
//            '<div class="blog-line" style="background: rgba(51,21,272,0.2);  margin-bottom: 0px;">' +
//            '<a><i class="icon-star-empty"></i><span>' + project["competitionname"] + '</span></a>' +
//            '</div>' +
//            '<div class="blog-line" style="background: rgba(0,181,0,0.3);">' +
//            '<a><i class="icon-calendar"></i><span> ' + project["projectdatecteation"] + '</span></a>' +
//            '<span> <a> <i class="icon-ok"></i><span>' + project["voicescount"] + '</span> <span class="en unvisiblin"> Likes</span><span class="nl">Sympathieën</span></a></span>' +
//            '<a class="trylater"><i class="icon-comments"></i><span>' + project["commentscount"] + '</span> <span class="en unvisiblin"> Comments</span><span class="nl">Reacties</span></a>' +
//            '<a href="#" name="delete"><span class="text-error"><i class="icon-trash"></i> <span class="en unvisiblin">DELETE THIS PROJECT</span><span class="nl">DELETE DIT PROJECT</span></span></a>' +
//            '</div>' +
//            '<div class="project_block_ava" ><img src="' + respons["photopath"] + '" class="img-circle ava_proj" >' +
//            '</div>' +
//            '<article  class="project_block_proj">' +
//            '<div class="project_block_proj_name">' + project["projectname"] + '</div>' +
//            '<div class="project_block_proj_descr">' + project["projectdescription"] + '</div>' +
//            '<div class="viewtheproj">' +
//            '<div class="buttonviewtheproj btn btn-primary btn-large flat " > <a href="edit_project.html#projectid=' + project["projectid"] + '" style="color:#fff;"><span class="en unvisiblin">Edit the project</span><span class="nl">Bewerk het project</span></a>' +
//            '</div>' +
//            '</div>' +
//            '</article>' +
//            '<div class="project_block_photo" ><img src="' + (project.photos.length > 0 ? project["photos"][0]["photopath"] : "img/nophoto.png") + '" class="img-polaroid photo_proj" >' +
//            '</section>' + '<div style="height:15px;"></div>';
//    var section = $(template_for_project);  //сначало сформировать объект а потом с ним работать
//    $(section).find("a[name=delete]").click(call_delete_project);
//    $(section).appendTo("#account_projects");
//}

function call_create_murkup_for_static_profile_projects(project, respons) {
    var template_for_project = '<section class="project_block" >' +
            '<div class="blog-line" style="background: rgba(51,21,272,0.2);  margin-bottom: 0px;">' +
            '<a><i class="icon-star-empty"></i><span>' + project["competitionname"] + '</span></a>' +
            '</div>' +
            '<div class="blog-line" style="background: rgba(0,181,0,0.3);">' +
            '<a><i class="icon-calendar"></i><span> ' + project["projectdatecteation"] + '</span></a>' +
            '<span> <a> <i class="icon-ok"></i><span>' + project["voicescount"] + '</span> <span class="en unvisiblin">Likes</span><span class="nl">Sympathieën</span></a></span>' +
            '<a class="trylater"><i class="icon-comments"></i><span>' + project["commentscount"] + '</span> <span class="en unvisiblin">Comments </span><span class="nl">Reacties</span></a>' +
            '</div>' +
            '<div class="project_block_ava" ><img src="' + respons["photopath"] + '" class="img-circle ava_proj" >' +
            '</div>' +
            '<article  class="project_block_proj">' +
            '<div class="project_block_proj_name">' + project["projectname"] + '</div>' +
            '<div class="project_block_proj_descr">' + project["projectdescription"] + '</div>' +
            '<div class="viewtheproj">' +
            '<div class="buttonviewtheproj btn btn-primary btn-large flat " > <a href="single_project.html#projectid=' + project["projectid"] + '" style="color:#fff;"><span class="en unvisiblin">View the project</span><span class="nl">Bekijk het project</span></a>' +
            '</div>' +
            '</div>' +
            '</article>' +
            '<div class="project_block_photo" ><img src="' + (project.photos.length > 0 ? project["photos"][0]["photopath"] : "img/nophoto.png") + '" class="img-polaroid photo_proj" >' +
            '</section>' + '<div style="height:15px;"></div>';
    var section = $(template_for_project);  //сначало сформировать объект а потом с ним работать

    $(section).appendTo("#account_projects");

}


function call_cookie_navigator() {
    if (window.location.hash.length > 1) {
        var parametrs = window.location.hash.substr(1);
        parametrs = parametrs.split("=");
        switch (parametrs[0]) {
            case "projectid":
                if (parametrs[1]) {
                    var projectid = parseInt(parametrs[1]);
                    window.projectId = projectid;
                    call_load_data_for_viewproject(projectid);
                    call_load_data_for_viewprojectcomments(projectid, 0);
                    call_load_data_for_viewprojectphotos(projectid, 0);
                }
                break;
            case "userid":
                if (parametrs[1]) {
                    var userid = parseInt(parametrs[1]);
                    call_load_data_for_myaccount(userid);
                }
                break;
        }

    }

    if ($.session.get("login") === "true") {
        var login_name = $.session.get("name");
        $("#login_name").text(" " + login_name + " ");
        $("#dropdown_login_no").hide();
        $("#dropdown_login_yes").show();
        $(".forall").removeClass("forall").addClass("for_registered");
        call_event_logout();
    }
    else {
        $(".for_registered").removeClass("for_registered").addClass("forall");
        $("#dropdown_login_yes").hide();
        $("#dropdown_login_no").show();
    }


}

function call_load_data_for_viewproject(projectid) {
    var data = {projectid: projectid};
    data = JSON.stringify(data);
    var url = "/battleWEB/controller?command=viewproject";
    $.ajax({
        url: url,
        type: "POST",
        dataType: "json",
        data: data,
        contentType: "application/json"
    }).done(function(respons) {

        applyKO(respons.voteable, respons.user.login);

        window.pagenation = {
            comments: respons.commentquantity,
            photos: respons.photoquantity
        };

        paging_for_photos();
        paging_for_comments();

        call_create_markup_for_viewproject(respons);
    }).fail(function() {
        console.log("error onload command=viewproject ");
    });
}





function call_create_markup_for_viewproject(respons) {
    $("#user").text(respons["user"]["login"]);
    $("#user_account").attr("href", "static_profile.html#userid=" + respons["user"]["id"]);
    $("#name").text(respons["name"]);
    $("#creationdate").text(respons["creationdate"]);
    $("#description").text(respons["description"]);
    $("#rating").text(respons["rating"]);
    $("#commentquantity").text(respons["commentquantity"]);
    try {
        $("#firstphoto_path").attr("src", respons["firstphoto"]["path"]);
        $("#firstphoto_path_big").attr("href", respons["firstphoto"]["path"]);
        $("#firstphoto_description").text(respons["firstphoto"]["description"]);
    }
    catch (e) {
        $("#firstphoto_path").attr("src", "img/nophoto.png");
        $("#firstphoto_path_big").attr("href", "img/nophoto.png");
    }
    try {
        $("#lastphoto_path_big").attr("href", respons["lastphoto"]["path"]);
        $("#lastphoto_path").attr("src", respons["lastphoto"]["path"]);
        $("#lastphoto_description").text(respons["lastphoto"]["description"]);
    }
    catch (e) {
        $("#lastphoto_path_big").attr("href", "img/nophoto.png");
        $("#lastphoto_path").attr("src", "img/nophoto.png");
    }


}



function call_load_data_for_viewprojectcomments(projectid, firstposition) {
    var data = {
        projectid: projectid,
        firstposition: firstposition,
        size: 5
    };
    data = JSON.stringify(data);
    var url = "/battleWEB/controller?command=viewprojectcomments";
    $.ajax({
        url: url,
        type: "POST",
        dataType: "json",
        data: data,
        contentType: "application/json"
    }).done(function(respons) {
        if (respons.comments.length) {
            $("#main_conteiner_comments").empty();
            for (var comment in respons["comments"]) {
                call_create_markup_for_viewprojectcomments(respons["comments"][comment]);
            }
        }
    }).fail(function() {
        console.log("error onload command=viewprojectcomments ");
    });
}

function call_create_markup_for_viewprojectcomments(respons) {
    var template_for_viewprojectcomments = "<li>" +
            " <!-- Comment Entry -->" +
            " <article>" +
            "       <h5 class=autor>" + respons["user"]["login"] + "</h5>" +
            '       <a href="static_profile.html#userid=' + respons["user"]["id"] + '">' +
            "            <img class=avatar src=" + respons["user"]["avatarpath"] + " alt=preview>" +
            "       </a>" +
            "       <div class=comment_inner style=display:block;>" +
            "           <p>" + respons["text"] + "</p>" +
            "           <p style='color:rgba(0, 181, 0,1);'>" +
            "               <i class=icon-time></i>" +
            "               <span class=padding_comment name=time > " + respons["date"] + "</span></p>" +
            "      </div>" +
            "</article>" +
            "</li>";
    $(template_for_viewprojectcomments).appendTo("#main_conteiner_comments");
}



function call_load_data_for_projets_page(firstposition) {


    var url = "/battleWEB/controller?command=projects";
    var data = JSON.stringify({
        firstposition: firstposition,
        size: 2,
        orderby: "date",
        sort: "desc"
    });
    $.ajax({
        url: url,
        type: "POST",
        dataType: "json",
        data: data,
        contentType: "application/json"
    }).done(function(respons) {
        window.pagenation = {
            projects: respons.projectquantity
        };
        if (respons.projects.length) {
            $("#projects").empty();
            for (var project in respons.projects) {
                call_create_markup_for_projects(respons.projects[project]);
            }

            if (!paging_for_projects.loaded) {
                paging_for_projects();
                paging_for_projects.loaded = true;
            }
        }
        call_setup_localozation();


    }).fail(function() {
        console.log("error onload command = projects ");
    });
    function call_create_markup_for_projects(respons) {

        function go_to_project() {
            var href = $(this).attr("href");
            href = href + "#projectid=" + respons["id"];
            $(this).attr("href", href);
        }

        var template_projets_page = [
            {tag: "section", add_class: "project_block", children: [
                    {tag: "div", add_class: "blog-line", attr: {style: "background: rgba(0,181,0,0.3);"}, children: [
                            {tag: "a", attr: {href: "#"}, children: [
                                    {tag: "i", add_class: "icon-user"},
                                    {tag: "span", text: "user", subattr: {"user": "login"}}
                                ]},
                            {tag: "span", children: [
                                    {tag: "a", attr: {href: "#"}, children: [
                                            {tag: "i", add_class: "icon-ok"},
                                            {tag: "span", add_class: "en unvisiblin", text: "rating"},
                                            {tag: "span", add_class: "en unvisiblin", text: " Likes"},
                                            {tag: "span", add_class: "nl", text: " Sympathieën"}
                                        ]}
                                ]},
                            {tag: "a", attr: {href: "#"}, add_class: "trylater", children: [
                                    {tag: "i", add_class: "icon-comments"},
                                    {tag: "span", text: "commentquantity"},
                                    {tag: "span", add_class: "en unvisiblin", text: " Comments"},
                                    {tag: "span", add_class: "nl", text: " Reacties"}
                                ]}
                        ]},
                    {tag: "div", add_class: "project_block_ava", children: [
                            {tag: "img", attr: {src: "user"}, subattr: {"src": "avatarpath"}, add_class: "img-circle ava_proj"}
                        ]},
                    {tag: "article", add_class: "project_block_proj", children: [
                            {tag: "div", add_class: "project_block_proj_name", text: "name"},
                            {tag: "div", add_class: "project_block_proj_descr", text: "lastphoto", subattr: {"lastphoto": "description"}},
                            {tag: "div", add_class: "viewtheproj", children: [
                                    {tag: "div", add_class: "buttonviewtheproj btn btn-primary btn-large flat", children: [
                                            {tag: "a", attr: {href: "single_project.html", style: "color:#fff;"}, add_handler: {"click": go_to_project}, children: [
                                                    {tag: "span", add_class: "en unvisiblin", text: "View the project"},
                                                    {tag: "span", add_class: "nl", text: "Bekijk het project"}]


                                            }


                                        ]}
                                ]}
                        ]},
                    {tag: "div", add_class: "project_block_photo", children: [
                            {tag: "img", attr: {src: "lastphoto"}, subattr: {"src": "path"}, add_class: "img-polaroid photo_proj"}

                        ]}
                ]},
            {tag: "div", attr: {"style": "height:35px;"}}

        ];
        call_markup_index(template_projets_page, $("#projects"), respons);

    }
}


function AjaxSendSearch(form) {
    var config = data_collection_forms(form);
    $.ajax({
        url: config.url,
        type: "POST",
        dataType: "json",
        data: config.data,
        contentType: "application/json"
    }).done(function(data) {

        var container = $("#result_search");
        if (data.result.length > 0) {
            $(container).html("");
            for (var i in data.result) {
                call_create_template_for_search_page(container, data.result[i]);
            }
        }

    }).fail(function(error) {
        console.log(error);
    });
    console.log(JSON.parse(config.data));
    return false;
}

function call_create_template_for_search_page(container, result) {
    var template = '<div class="res_search">' +
            '           <strong style="font-size: 2em;">' +
            '               <a href="' + (result["type"] === "project" || result["type"] === "comment" ? "single_project.html#projectid=" : "#") + result["id"] + '">  <i class="icon-share-alt"></i> </a>' +
            '           </strong>' +
            '           <p>' + result["description"] + '</p>' +
            '           <p>' + result["name"] + '</p>' +
            '           <p>' + result["type"] + '</p>' +
            '</div>';
    var view = $(template);
    $(view).appendTo(container);

}

function call_send_vote(projectid) {
    var url = "/battleWEB/controller?command=vote";
    var data = JSON.stringify({
        projectid: projectid
    });
    $.ajax({
        url: url,
        type: "POST",
        dataType: "json",
        data: data,
        contentType: "application/json"
    }).done(function(vote) {
        if (vote.voteresult === true) {
            var text_rating = $("#rating").text();
            text_rating = parseInt(text_rating);
            text_rating++;
            $("#rating").text(text_rating);
        }
        else {
            alert("You cant vote!");
        }
    }).fail(function() {
        console.log("Error for VOTE");
    });
}



function call_createproject() {
    var url = "/battleWEB/controller?command=createproject";
    var data = {};
    data.name = $("#name").val();
    data.description = $("#description").val();
    data.type = $("[name=type]:checked").val();
//
    data = JSON.stringify(data);
    $.ajax({
        url: url,
        type: "POST",
        dataType: "json",
        data: data,
        contentType: "application/json"
    }).done(function(respons) {
        if (respons.projectid) {
            window.location = "edit_project.html#projectid=" + respons.projectid;
        }
        else {
            alert(respons["message"]);
        }
    }).fail(function() {
        console.log("Error for projectsave");
    });
}



function call_new_added_photo_for_edit_project(photo) {
    function Save_img_and_description(event) {
        var parent = $(this).parents("section.project_block");
        var id = $(parent).data("fixed_id_photo");
        if (id) {
            $(parent).trigger("my_send.description");//call_send_description_for_this_photo(id, description_photo);
        }
        else {
            window.upload_file.block_of_sended_photo = parent;
            window.upload_file.submit();
            window.upload_file.enable();
            $("#uploadphoto").css("visibility", "visible");
        }

        $(this).removeClass("btn-danger").addClass("btn-primary");
        event.preventDefault();
    }
    function Send_description_this_photo(event) {
        var description = $(this).find("[name=description]").text();
        var id = $(this).data("fixed_id_photo");
        if (id) {
            call_send_description_for_this_photo(id, description);
        }
        else {
            window.upload_file.upload_desription = description;
        }

        photo["description"] = description;//<<<<<<<================ нужно разобраться как определять изменения в тексте для только что созданного елемента
        event.preventDefault();
        console.log(description);

    }
    function Delete_this_photo_and_description(event) {
        var parent = $(this).parents("section.project_block");

        var id = $(parent).data("fixed_id_photo");
        if (id) {
            call_delete_photo(id);
        }
        else {
            window.upload_file._clearInput();
            window.upload_file.enable();
            $("#uploadphoto").css("visibility", "visible");
        }
        $(parent).remove();
        event.preventDefault();
    }

    function Fixed_what_this_description_changed() {
        var prev_text = photo["description"];//<<<<<<<================ нужно разобраться как определять изменения в тексте для только что созданного елемента
        var current_text = $(this).text();
        var parent = $(this).parents("section.project_block")[0];
        if (current_text !== prev_text) {
            console.log(current_text);
            $(parent).find("[name=save-description-photo]").removeClass("btn-primary").addClass("btn-danger");
        }
        else {
            $(parent).find("[name=save-description-photo]").removeClass("btn-danger").addClass("btn-primary");
        }

    }

    window.upload_file.disable();
    $("#uploadphoto").css("visibility", "hidden");

    var temlate_for_new_added_photo_for_edit_project = [
        {tag: "section", add_class: "project_block", attr: {style: "border-box: solid #333 1px; padding: 5px; width:95%; height:250px; margin: 0 auto;"}, add_handler: {"my_send.description": Send_description_this_photo}, children: [
                {tag: "a", add_class: "image_link", children: [
                        {tag: "div", add_class: "with_hover"},
                        {tag: "div", attr: {style: "width:25%; margin: 0 1%; float: left;  height:200px;"}, children: [
                                {tag: "img", add_class: "img-polaroid", attr: {src: photo, style: "width:100%;"}}
                            ]}
                    ]},
                {tag: "article", attr: {style: "width:65%;  float: left; overflow: hidden; text-overflow: ellipsis; -o-text-overflow: ellipsis; padding: 15px;  font-size: 1em; text-align: left;"}, children: [
                        {tag: "p", text: "Description your photo", attr: {contenteditable: "true", name: "description"}, add_handler: {"blur": Fixed_what_this_description_changed}},
                        {tag: "p", children: [
                                {tag: "span", children: [
                                        {tag: "a", add_class: "btn btn-primary flat", add_handler: {"click": Delete_this_photo_and_description}, children: [
                                                {tag: "span", add_class: "en unvisiblin", text: "Delete"},
                                                {tag: "span", add_class: "nl", text: "Verwijderen"},
                                                {tag: "i", add_class: "icon-angle-right"}
                                            ]}
                                    ]},
                                {tag: "span", children: [
                                        {tag: "a", add_class: "visiblin btn btn-danger flat", attr: {"name": "save-description-photo"}, add_handler: {"click": Save_img_and_description}, children: [
                                                {tag: "span", add_class: "en unvisiblin", text: "Save"},
                                                {tag: "span", add_class: "nl", text: "Besparen"},
                                                {tag: "i", add_class: "icon-angle-right"}
                                            ]}
                                    ]}
                            ]}
                    ]}
            ]},
        {tag: "div", attr: {style: "height:35px;"}
        }];
    call_markup_index(temlate_for_new_added_photo_for_edit_project, $("#new_added_photo"), {});

}

/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/

function call_load_photo_for_edit_project(photo) {
    function Save_description_this_photo(event) {
        var parent = $(this).parents("section.project_block");
        $(parent).trigger("find.description");
        $(this).removeClass("btn-danger").addClass("btn-primary");
        event.preventDefault();
    }
    function Find_description_this_photo(event) {
        var description = $(this).find("[name=description_photo]").text();

        call_send_description_for_this_photo(photo["id"], description);
        photo["description"] = description;
        event.preventDefault();
        console.log(description);

    }
    function Delete_this_photo_and_description(event) {
        var parent = $(this).parents("section.project_block");
        var whate = confirm("У Е Р Е Н Ы ??????!!!!!!!!!");
        if (whate) {
            call_delete_photo(photo["id"]);
            $(parent).remove();
        }

        event.preventDefault();
    }

    function Fixed_what_this_description_changed() {
        var prev_text = photo["description"];
        var current_text = $(this).text();
        var parent = $(this).parents("section.project_block")[0];
        if (current_text !== prev_text) {
            console.log(current_text);
            $(parent).find("[name=save-description-photo]").removeClass("btn-primary").addClass("btn-danger");
        }
        else {
            $(parent).find("[name=save-description-photo]").removeClass("btn-danger").addClass("btn-primary");
        }

    }
    var temlate_for_new_added_photo_for_edit_project = [
        {tag: "section", add_class: "project_block", attr: {style: "border-box: solid #333 1px; padding: 5px; width:95%; height:250px; margin: 0 auto;"}, add_handler: {"find.description": Find_description_this_photo}, children: [
                {tag: "a", add_class: "image_link", children: [
                        {tag: "div", add_class: "with_hover"},
                        {tag: "div", attr: {style: "width:25%; margin: 0 1%; float: left;  height:200px;"}, children: [
                                {tag: "img", add_class: "img-polaroid", attr: {src: "photopath", style: "width:100%;"}}
                            ]}
                    ]},
                {tag: "article", attr: {style: "width:65%;  float: left; overflow: hidden; text-overflow: ellipsis; -o-text-overflow: ellipsis; padding: 15px;  font-size: 1em; text-align: left;"}, children: [
                        {tag: "p", text: "description", attr: {contenteditable: "true", name: "description_photo"}, add_handler: {"blur": Fixed_what_this_description_changed}},
                        {tag: "p", children: [
                                {tag: "span", children: [
                                        {tag: "a", add_class: "btn btn-primary flat", add_handler: {"click": Delete_this_photo_and_description}, children: [
                                                {tag: "span", add_class: "en unvisiblin", text: "Delete"},
                                                {tag: "span", add_class: "nl", text: "Verwijderen"},
                                                {tag: "i", add_class: "icon-angle-right"}
                                            ]}
                                    ]},
                                {tag: "span", children: [
                                        {tag: "a", add_class: "visiblin btn btn-primary flat", attr: {"name": "save-description-photo"}, add_handler: {"click": Save_description_this_photo}, children: [
                                                {tag: "span", add_class: "en unvisiblin", text: "Save"},
                                                {tag: "span", add_class: "nl", text: "Besparen"},
                                                {tag: "i", add_class: "icon-angle-right"}
                                            ]}
                                    ]}
                            ]}
                    ]}
            ]},
        {tag: "div", attr: {style: "height:35px;"}
        }];
    call_markup_index(temlate_for_new_added_photo_for_edit_project, $("#viewprojectphotos"), photo);

}




function call_send_description_for_this_photo(idphoto, description_photo) {

    var send_data = {
        id: idphoto,
        description: description_photo
    };
    var url = "/battleWEB/controller?command=editphotodescription";
    send_data = JSON.stringify(send_data);

    $.ajax({
        url: url,
        type: "POST",
        dataType: "json",
        data: send_data,
        contentType: "application/json"
    }).done(function(respons) {
        console.log("Description of photo sended");
        console.log(respons);
    }).fail(function() {
        console.log("error  command=editphotodescription");
    });
}


function call_delete_photo(id) {

    var delete_photo = {
        photoid: id
    };
    delete_photo = JSON.stringify(delete_photo);
    var url = "/battleWEB/controller?command=deletephoto";

    $.ajax({
        url: url,
        type: "POST",
        dataType: "json",
        data: delete_photo,
        contentType: "application/json"
    }).done(function(respons) {
        console.log(" photo DELETED");
        console.log(respons);
    }).fail(function() {
        console.log("error  command = deletephoto");
    });
}

function  call_load_data_for_viewprojectphotos(projectid, firstposition) {
    var data = {
        projectid: projectid,
        firstposition: firstposition,
        size: 2
    };
    data = JSON.stringify(data);
    var url = "/battleWEB/controller?command=viewprojectphotos";
    $.ajax({
        url: url,
        type: "POST",
        dataType: "json",
        data: data,
        contentType: "application/json"
    }).done(function(respons) {
        if (respons.photos.length) {
            if (window.location.href.match(/edit_project.html/)) {//<<<<======================= вывести все ранее сохраненные фото с описанием при помощи фукции для создания нового фото
                $("#viewprojectphotos").empty();
                for (var photo in respons["photos"]) {
                    call_load_photo_for_edit_project(respons["photos"][photo]);
                }
                call_setup_localozation();
            }
            else {
                $("#viewprojectphotos").empty();
                for (var photo in respons["photos"]) {
                    call_create_markup_for_viewprojectphotos(respons["photos"][photo]);
                }
                call_setup_localozation();
            }
        }


    }).fail(function() {
        console.log("error onload command=viewprojectphotos ");
    });
}
function call_create_markup_for_viewprojectphotos(respons) {
    var template_for_viewprojectphotos = '<section class="project_block singlephotoblock">' +
            ' <a href="' + respons["photopath"] + '" class="image_link">' +
            ' <div class="with_hover"></div>' +
            '<div class="hover singlephoto" ><img src="' + respons["photopath"] + '" class="img-polaroid" style="width:100%;">' +
            '</div>  </a>' +
            '<article class="descr_singlephoto"  >' +
            ' <p class="abzac" >' + respons["description"] + '</p>' +
            ' </article>' +
            ' </section>';
    $(template_for_viewprojectphotos).appendTo("#viewprojectphotos");
}

/*command:editproject
 url:http://edu.bionic-university.com:1120/battleWEB/controller

 {
 “projectid”:23,
 “name” : “***”,
 “description”:”***”
 }
 ответ от сервера:
 {
 “status”:true/false,
 “message”:”***”                //изменения внесены…
 }*/
function call_send_data_editproject() {
    var data = {
        projectid: window.projectId,
        "name": $("#name").text(),
        "description": $("#description").text()
    };
    data = JSON.stringify(data);
    var url = "/battleWEB/controller?command=editproject";
    $.ajax({
        url: url,
        type: "POST",
        dataType: "json",
        data: data,
        contentType: "application/json"
    }).done(function(respons) {
        console.log(respons);

    }).fail(function() {
        console.log("error onload command=editproject ");
    });
}

/*
 * search
 {
 "text":"***",
 "firstposition":0,
 "size":10
 }

 */




function call_markup_for_admin_text(markupTemplate, parentsContainer, dataObj) {

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
                // <<<<<<<<<<================================== Если атрибут является объектом
                if ({}.toString.call(value) === "[object Object]") {
// <<<<<<<<<<================================== Требуется сабатрибут для опредиления конечного значения
                    var subvalue = value[templateObj["subattr"][name_prop]];
                    element.attr(name_prop, subvalue);
                }
                else {
                    element.attr(name_prop, value);
                }
            }
        }
// <<<<<<<<<<================================== Добавление текста к элементу
        if ("text" in templateObj) {
            var text_key = templateObj["text"];
            var text_value = dataObj[text_key] ? dataObj[text_key] : dataObj[text_key] === 0 ? 0 : dataObj[text_key] === "" ? "  " : text_key; //var text_value = dataObj[text_key] || text_key;
            // <<<<<<<<<<================================== Если текст является объектом
            if ({}.toString.call(text_value) === "[object Object]") {
// <<<<<<<<<<================================== Требуется сабатрибут для опредиления конечного значения
                var subvalue_text = text_value[templateObj["subattr"][text_key]];
                element.html(subvalue_text);
            }
            else {
                element.html(text_value);
            }

        }
// <<<<<<<<<<================================== Добавление обработчика событий к элементу
        if ("add_handler" in templateObj) {
            for (var event in templateObj["add_handler"]) {
                element.on(event, templateObj["add_handler"][event]);
            }
        }
// <<<<<<<<<<================================== Добавление дочерих элементов к элементу
        if ("children" in templateObj) {
            call_markup_for_admin_text(templateObj["children"], new_parentsContainer, dataObj);
        }

    }

}


function paging_for_comments() {
    var comments = window.pagenation.comments;
    var kolichestvo_stranic;
    var next = $("#comments_next");
    var count = 0;
    if (comments > 5) {
        kolichestvo_stranic = Math.ceil(comments / 5);
    }
    else {
        kolichestvo_stranic = 1;
    }
    for (var i = 0; i < kolichestvo_stranic; i++) {
        $('<li id="' + count + '"><a href="#">' + (i + 1) + '</a></li>').click(function(event) {
//            $("#main_conteiner_comments").empty();
            $(this).siblings().removeClass("active");
            $(this).addClass("active");
            var firstposition = $(this).attr("id");
            call_load_data_for_viewprojectcomments(parseInt(window.projectId), parseInt(firstposition));
            event.preventDefault();
        }).insertBefore(next);
        count += 5;
    }

}

function paging_for_photos() {
    var photos = window.pagenation.photos;
    var kolichestvo_stranic;
    var next = $("#photos_next");
    var count = 0;
    if (photos > 2) {
        kolichestvo_stranic = Math.ceil(photos / 2);
    }
    else {
        kolichestvo_stranic = 1;
    }

    for (var i = 0; i < kolichestvo_stranic; i++) {
        $('<li id="' + count + '"><a href="#">' + (i + 1) + '</a></li>').click(function(event) {
//            $("#viewprojectphotos").empty();
            $(this).siblings().removeClass("active");
            $(this).addClass("active");
            var firstposition = $(this).attr("id");
            call_load_data_for_viewprojectphotos(parseInt(window.projectId), parseInt(firstposition));
            event.preventDefault();
        }).insertBefore(next);
        count += 2;
    }

}

function paging_for_projects() {
    if (paging_for_projects.loaded) {
        return;
    }
    var projects = window.pagenation.projects;
    var kolichestvo_stranic;
    var next = $("#projects_next");
    var count = 0;
    if (projects > 2) {
        kolichestvo_stranic = Math.ceil(projects / 2);
    }
    else {
        kolichestvo_stranic = 1;
    }

    for (var i = 0; i < kolichestvo_stranic; i++) {
        $('<li id="' + count + '"><a href="#">' + (i + 1) + '</a></li>').click(function(event) {
//            $("#projects").empty();
            $(this).siblings().removeClass("active");
            $(this).addClass("active");
            var firstposition = $(this).attr("id");
            call_load_data_for_projets_page(parseInt(firstposition));
            event.preventDefault();
        }).insertBefore(next);
        count += 2;
    }
}

function next_page() {
    $("li[data-name=next]").click(function(event) {
        var $this = $(this);

        var active = $this.siblings(".active");
        if (!active.length) {
            var next = $this.siblings("#0").next();
            if ($(next).attr("data-name") === "next") {
                return false;
            }
            else {
                $(next).click();
            }
        }
        else {
            var next = $(active).next();
            if ($(next).attr("data-name") === "next") {
                return false;
            }
            else {
                $(active).removeClass("active");
                $(next).trigger("click");
            }

        }
        event.preventDefault();
    });
}
function preview_page() {
    $("li[data-name=prev]").click(function(event) {
        var $this = $(this);

        var active = $this.siblings(".active");
        if (!active.length) {
            return false;
        }
        else {
            var prev = $(active).prev();
            if ($(prev).attr("data-name") === "prev") {
                return false;
            }
            else {
                $(active).removeClass("active");
                $(prev).trigger("click");
            }

        }
        event.preventDefault();
    });
}


function set_eng_localization() {
    $(".en").removeClass("unvisiblin");
    $(".nl").addClass('unvisiblin');
    $.cookie("locale", "en");

}
function set_nl_localization() {
    $(".nl").removeClass("unvisiblin");
    $(".en").addClass('unvisiblin');
    $.cookie("locale", "nl");

}

function call_setup_localozation() {
    var language = $.cookie("locale");
    switch (language) {
        case "nl":
            set_nl_localization();
            break;
        case "en":
            set_eng_localization();
            break;
    }
}
