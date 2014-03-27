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