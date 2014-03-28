/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


ko.bindingHandlers.editableText = {
    init: function(element, valueAccessor) {
        var value = valueAccessor();

        $(element)
//                .attr('contentEditable', true)
                .text(ko.unwrap(value))
                .on('blur', function() {
                    value($(this).text());
                });
    },
    update: function(element, valueAccessor) {
        var value = valueAccessor();
        $(element).text(ko.unwrap(value));
    }
};

function applyKO(Model) {
    window.viewModel = ko.toJS(Model);

    window.viewModel.accept_delete_project = function() {
        var deleting_project = {
            projectid: window.viewModel.accept_delete_project.projectID
        },
        url = "/battleWEB/controller?command=deleteproject";



        deleting_project = JSON.stringify(deleting_project);

        $.ajax({
            type: "POST",
            url: url,
            dataType: "json",
            contentType: "application/json",
            data: deleting_project
        }).done(function(data) {
            console.log(data);
            window.location.reload();
        }).fail(function(error) {
            console.log("Problemi s Удалением проекта", error);
            alert("ERRORE DELETING");
            window.location.reload();
        });

    };

    window.viewModel.delete_this_project = function(project) {
        $("#Modal_delete_project").modal("show");
        window.viewModel.accept_delete_project.projectID = project.projectid;
    };



    ko.applyBindings(window.viewModel);
}