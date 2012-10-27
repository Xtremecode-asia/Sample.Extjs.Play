// **********************************//
// ** By: Wendy Sanarwanto **********//
// ** e-mail: saintc0d3r@gmail.com **//
// **********************************//

// Declare the Employee's Entry Panel
Ext.define('Sample.Extjs.Play.Mvc.SimpleCrud.view.EmployeeEntryView',{
	extend: 'Ext.form.Panel',
	alias: 'widget.employeeEntryForm',
	requires: ['Ext.form.field.Text'],

	activeRecord: null,
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
	        name: 'first',
	        allowBlank: false
	    }, {
	        fieldLabel: 'Last Name',
	        name: 'last'
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
		        id: 'buttonSave'		        
		    }, { 
		    	text: 'Clear',
		    	scope: this,
		    	//iconCls: 'icon-reset',
	    	    id: 'buttonClear'			
	    	}]
	}],	
	
	initComponent: function(){
		this.addEvents('create');
		this.callParent();
        console.info('Employee Entry View has been initialised.');
	}
});