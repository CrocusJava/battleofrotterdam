function applyKO(voteable, user) {

    var login_name = $.session.get("name");

    var viewModel = {
        voteable: ko.observable(voteable),
        owner: (login_name === user)
    };
    window.viewModel = viewModel;

    ko.applyBindings(viewModel);
}

