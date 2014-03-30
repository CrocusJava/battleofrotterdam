function applyKO(voteable, user, projectid) {

    var url = "/battleWEB/controller?command=sendcomplaint";

    var login_name = $.session.get("name");

    var viewModel = {
        voteable: ko.observable(voteable),
        owner: (login_name === user)
    };

    viewModel.sendComplaint = function() {
        $.ajax({
            url: url,
            type: "POST",
            contentType: "application/json",
            data: projectid
        });
    };

    window.viewModel = viewModel;

    ko.applyBindings(viewModel);
}

//SendComplaint
//POST
//	command: sendcomplaint
//	url:http://edu.bionic-university.com:1120/battleWEB/controller
//{
//"projectid":123
//}