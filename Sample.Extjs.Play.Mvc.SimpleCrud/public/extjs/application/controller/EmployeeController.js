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
    }, {
        ref: 'gridView',
        selector: 'employeeGridForm'
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
                selectionchange: this.onSelectionChange
            },
            'employeeGridForm button[action=delete]':{
                click: this.onDelete
            },
            'employeeGridForm button[action=sync]':{
                click: this.onSync
            }
        });
    },

    onSave: function(){
        //  1. Get Record
        var targetRecord = this.getEntryForm().getRecord();
        var values = this.getEntryForm().getValues();
        if (targetRecord == null){
            // Does the user has entered valid values on the form ?
            if (this.getEntryForm().getForm().hasInvalidField()){
                Ext.Msg.alert('Error', 'Some fields in the form contain invalid value.');
                this.getEntryForm().focus();
                return;
            }

            //  User tries to create a new record. Check for duplicated code 1st.
            if (this.getEmployeesStore().find('code', values.code) <0){
                // Create a new record and push it into store
                var newEmployee = new Sample.Extjs.Play.Mvc.SimpleCrud.model.Employee(
                    {
                        firstName : values.firstName,
                        lastName : values.lastName,
                        code : values.code,
                        address : values.address,
                        phone : values.phone,
                        email : values.email
                    }
                );
                this.getEmployeesStore().add(newEmployee);
            }
            else{
                //TODO: Display Error ? or Confirmation to update an existing with entered values?
            }
        }
        else{
            // Update the record
            targetRecord.set(values);
        }
        // TODO:
        //  2. Push the dirty records to server.
    },

    onClear: function(){
        this.getGridView().getSelectionModel().deselectAll();
        this.getEntryForm().setCurrentRecord(null);
    },

    onSelectionChange: function(grid, selected, eOpts){
        this.getEntryForm().setCurrentRecord(selected[0]);
    },

    onDelete: function(button){
        var targetRecord = this.getEntryForm().getRecord();
        if (targetRecord != null){
            //Remove the selected record
            this.getEmployeesStore().remove(targetRecord);
            this.getEntryForm().setCurrentRecord(null);
        }
    },

    onSync: function(button){
        this.getEmployeesStore().sync();
    }
});
