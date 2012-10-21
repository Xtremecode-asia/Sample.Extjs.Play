Ext.application({
		name: 'Sample.ExtJs.Play.HelloWorld',
		launch: function() {
			Ext.create('Ext.container.Viewport', {
					layout: 'border',
					items: [{
						region: 'north',
						title: '.:: Sample MVC CRUD ::.',
						html: '<h1>TODO -- Put main menu & Toolbar here</h1>',
						margins: '3 3 3 3'
					}, {
						region: 'west',
						collapsible: true,
						title: 'Functions',
						width: 200
					}, {
						region: 'south',
						collapsible: false,
						split: false,
						html: '<h2> TODO -- Add status bar here </h2> ',
						height: 20,
						minHeight: 20
					},{
						region: 'center',
						xtype: 'tabpanel',
						html: '<h3>Double click the function item to display its tab.</h3>'
//						activeTab: 0,
//						items: {
//							title: 'Default Tab',
//							closable: true,
//            				html: 'The first tab\'s content. Others may be added dynamically'
//						}
					}]
				}
			);
		}
	}
);
