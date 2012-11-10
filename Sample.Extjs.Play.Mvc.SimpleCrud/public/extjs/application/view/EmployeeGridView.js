// **********************************//
// ** filename: EmployeeGridView.js *//
// ** By: Wendy Sanarwanto **********//
// ** e-mail: saintc0d3r@gmail.com **//
// **********************************//

// Declare Employee's Grid view

Ext.define('Sample.Extjs.Play.Mvc.SimpleCrud.view.EmployeeGridView',{
	extend: 'Ext.grid.Panel',
	alias: 'widget.employeeGridForm',
	
	requires: [
		'Ext.grid.plugin.CellEditing',
		'Ext.form.field.Text',
		'Ext.toolbar.TextItem',
		'Sample.Extjs.Play.Mvc.SimpleCrud.store.Employees'
	],

    store: 'Employees',

//	iconCls: 'icon-grid',
	frame: true,
	dockedItems:[{
		xtype: 'toolbar',
		items: [/*{
			//iconCls: 'icon-add',
			text: 'Add',
			scope: this

		},*/ {
			//iconCls: 'icon-delete',
			text: 'Delete',
			itemId: 'buttonDelete',
			action: 'delete',
			scope: this

		}]
	}, {
		weight: 2,
		xtype: 'toolbar',
		dock: 'bottom',
		items: [{
			xtype: 'tbtext',
			text: 'Sync Mode'
		}, '|', {
			text: 'Auto',
			enableToggle: true,
            pressed: false,
            tooltip: 'When enabled, Store will execute Ajax requests as soon as a Record becomes dirty.',
            action: 'syncToggle',
            toggleHandler: function(button, press){
                button.up('grid').store.autoSync = press;
            },
            scope: this
		}/*,	{
			text: 'batch',
            enableToggle: true,
            pressed: true,
            tooltip: 'When enabled, Store will batch all records for each type of CRUD verb into a single Ajax request.',
            scope: this
		}*/]
	}, {
		weight: 1,
		xtype: 'toolbar',
		dock: 'bottom',
		ui: 'footer',
		items: [{
			//iconCls: 'icon-save',
            text: 'Sync',
            itemId: 'buttonSync',
            action: 'sync',
            scope: this
		}]
	}],

    columns:[{
        header: 'ID',
        width: 40,
        sortable: true,
        dataIndex: 'id',
        field: {
            type: 'textField'
        }

    },{
        header: 'Code',
        width: 100,
        sortable: true,
        dataIndex: 'code',
        field: {
            type: 'textField'
        }
    }, {
        header: 'First Name',
        width: 200,
        sortable: true,
        dataIndex: 'firstName',
        field: {
            type: 'textField'
        }
    }, {
        header: 'Last Name',
        width: 200,
        sortable: true,
        dataIndex: 'lastName',
        field: {
            type: 'textField'
        }
    }, {
        header: 'Address',
        width: 300,
        sortable: true,
        dataIndex: 'address',
        field: {
            type: 'textField'
        }
    }, {
        header: 'Phone',
        width: 100,
        dataIndex: 'phone',
        field: {
            type: 'textField'
        }
    }, {
        header: 'E-mail',
        width: 200,
        dataIndex: 'email',
        field: {
            type: 'textField'
        }
    }],

	initComponent: function(){
//		this.editing = Ext.create('Ext.grid.plugin.CellEditing');
//        this.plugins = [this.editing];
		this.callParent();
		this.getSelectionModel().allowDeselect = true;
        //this.getSelectionModel().on('selectionchange', this.onSelectChange, this);
	},

});
