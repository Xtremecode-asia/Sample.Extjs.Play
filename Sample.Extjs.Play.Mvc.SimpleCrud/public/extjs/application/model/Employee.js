/**
 * Created with JetBrains WebStorm.
 * User: Wendy Sanarwanto (saintc0d3r@gmail.com)
 * Date: 10/27/12
 * Time: 10:45 PM
 */

Ext.define('Sample.Extjs.Play.Mvc.SimpleCrud.model.Employee',{
    extend: 'Ext.data.Model',
    fields: [
        {name: 'id', type: 'long'},
        {name: 'firstName', type: 'string'},
        {name: 'lastName', type: 'string'},
        {name: 'code', type: 'string'},
        {name: 'address', type: 'string'},
        {name: 'phone', type: 'long'},
        {name: 'email', type: 'string'}]
});
