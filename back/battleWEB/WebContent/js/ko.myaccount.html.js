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
    var viewModel = ko.toJS(Model);


    viewModel.visibleButtonCreateNewProject = ko.computed(function() {
        var arr = $.map(viewModel.projects, function(element, index) {
            return element.competitiontypename;
        });
        return !($.inArray("month", arr) > -1 && $.inArray("year", arr) > -1);
    });

    viewModel.choiceCompetitionType = ko.computed(function() {
        var arr = $.map(viewModel.projects, function(element, index) {
            return element.competitiontypename;
        });
        return {
            month: !($.inArray("month", arr) > -1),
            year: !($.inArray("year", arr) > -1)
        };
    });



    viewModel.accept_delete_project = function() {
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

    viewModel.delete_this_project = function(project) {
        $("#Modal_delete_project").modal("show");
        window.viewModel.accept_delete_project.projectID = project.projectid;
    };

    window.viewModel = viewModel;

    ko.applyBindings(viewModel);
}