/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function applyKO(Model) {
    var viewModel = ko.toJS(Model);



    window.viewModel = viewModel;

    ko.applyBindings(viewModel);
}