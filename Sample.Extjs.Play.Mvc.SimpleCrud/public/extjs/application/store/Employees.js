/**
 * Created with JetBrains WebStorm.
 * User: Wendy Sanarwanto (saintc0d3r@gmail.com)
 * Date: 10/27/12
 * Time: 10:04 PM
 */

Ext.define('Sample.Extjs.Play.Mvc.SimpleCrud.store.Employees',{
    extend: 'Ext.data.Store',
    model: 'Sample.Extjs.Play.Mvc.SimpleCrud.model.Employee',

    autoLoad: true,
    autoSync: false,

    proxy:{
        type: 'rest',
        url: '/employees'
    },

    reader: {
        type: 'json',
        idProperty: 'id',
        successProperty: 'IsSuccess',
        messageProperty: 'Error',
        totalProperty: 'count'
    },

    writer: {
        type: 'json'
    }
});
