// **********************************//
// ** By: Wendy Sanarwanto **********//
// ** e-mail: saintc0d3r@gmail.com **//
// **********************************//

// Declare the Employee's Entry Panel
Ext.define('Sample.Extjs.Play.Mvc.SimpleCrud.view.EmployeeEntryView',{
	extend: 'Ext.form.Panel',
	alias: 'widget.employeeEntryForm',
	requires: ['Ext.form.field.Text'],

	initComponent: function(){
		this.addEvents('create');
        Ext.apply(this,{
            currentRecord: null,
            //iconCls: 'icon-user',
            frame: true,
            title: 'Employee Entry Panel',
            defaultType: 'textfield',
            bodyPadding: 5,
            autoScroll: true,
            fieldDefaults: {
                //anchor: '100%',
                labelAlign: 'left'
            },

            items: [{
                fieldLabel: 'First Name',
                name: 'firstName',
                allowBlank: false
            }, {
                fieldLabel: 'Last Name',
                name: 'lastName'
            }, {
                fieldLabel: 'Code',
                name: 'code',
                width: 200,
                regex: /^[a-zA-Z0-9_]+$/,
                allowBlank: false
            }, {
                fieldLabel: 'Address',
                name: 'address'
            }, {
                fieldLabel: 'Phone',
                name: 'phone',
                width: 220,
                regex: /^[0-9_]+$/
            }, {
                fieldLabel: 'Email',
                name: 'email',
                vtype: 'email'
            }],
            dockedItems:[{
                xtype: 'toolbar',
                dock: 'bottom',
                ui: 'footer',
                items: [{
                    text: 'Save',
                    scope: this,
                    //iconCls: 'icon-save',
                    action: 'save' /*,
                    handler: this.onSave*/
                }, {
                    text: 'Clear',
                    scope: this,
                    //iconCls: 'icon-reset',
                    action: 'clear'
                }]
            }]
        });

		this.callParent();
        console.info('Employee Entry View has been initialised.');
	},

    setCurrentRecord: function(record){
        if (record == null){
            this.getForm().reset();
            this.getForm()._record = null;
        }
        else{
            this.getForm().loadRecord(record);
        }
        currentRecord = record;
    }
});