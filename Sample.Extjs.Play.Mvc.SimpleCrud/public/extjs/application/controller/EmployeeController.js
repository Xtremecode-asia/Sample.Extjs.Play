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

    stores: [ 'Employees' ],
    models: [ 'Employee' ],

    refs: [{
        ref: 'entryForm',
        selector: 'employeeEntryForm'
    }],

    init: function(){
        console.info('Employee Controller is initialised.');
        this.control({
            'employeeEntryForm button[action=save]': {
                click: this.onSave
            },
            'employeeEntryForm button[action=clear]':{
                click: this.onClear
            },
            'employeeGridForm':{
                itemclick: this.onRecordSelected
            }
        });
    },

    onSave: function(){
        console.info('Button Save has been clicked from within the controller');
        // TODO:
        //  1. Get Record
        //  2. Find if the proposed record exist, if yes, add it into Store. Otherwise, update the existing one.
//        var recordToSave = this.getEntryForm().getForm().getRecord();
//        console.info('Record to save='+recordToSave);
    },

    onClear: function(){
        console.info('Button Clear has been clicked from within the controller');
        this.getEntryForm().setCurrentRecord(null);
    },

    onRecordSelected: function(grid, record){
        console.info('selected record ='+record);
    }
});
