/**
 * Created with JetBrains WebStorm.
 * User: Wendy Sanarwanto (saintc0d3r@gmail.com)
 * Date: 10/27/12
 * Time: 7:02 AM
 */

Ext.define('Sample.Extjs.Play.Mvc.SimpleCrud.controller.EmployeeController',{
    extend: 'Ext.app.Controller',

    views: [
        'EmployeeEntryView',
        'EmployeeGridView'
    ],

    init: function(){
        console.info('Employee Controller is initialised.');
        this.control({
            'viewport > panel': {
                render: this.onPanelRendered
            }
        });
    },

    onPanelRendered: function(){
        console.info('Employee Controller\'s panel has been rendered');
    }
});
