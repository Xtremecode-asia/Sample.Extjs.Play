Ext.application({
		name: 'Sample.ExtJs.Play.HelloWorld',
		launch: function() {
			var mainViewPort = 
				Ext.create('Ext.container.Viewport', {
						layout: 'border',
						items: [{
							region: 'north',
							title: '.:: Sample MVC CRUD ::.',
							margins: '3 3 3 3',
							items: [{
								xtype: 'toolbar',
								items: [{
									xtype: 'button',
									text: 'File'
								}, {
									xtype: 'button',
									text: 'Help'
								}]
							}]
//							html: '<h1>TODO -- Put main menu & Toolbar here</h1>'
//							items: [{
//								xtype: 'menu',
//								floatable: true,
//								floating: false,
//								items: [{
//									text: 'file'
//								}, {
//									text: 'help'
//								}]													
//							}]
							
						}, {
							region: 'west',
							id: 'panelWest',
							collapsible: true,
							title: 'Functions',							
							width: 190,
							layout: 'fit',
							items: [{
								xtype: 'treepanel',
								root: { 
										text: 'Root', 
										expanded: true,
										id: 'rootNode',
										children: [{
											text: 'Master Data',
											expanded: true,
											id: 'masterDataNode'
										}, {
											text: 'Transactional Data',
											expanded: true,
											id: 'transactionalDataNode'
										}, {
											text: 'Reports',
											expanded: true,
											id: 'reportsNode'
										}]									
									}
							}]
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
//			var panelWest = mainViewPort.getLayout().getLayoutItems()[1];
//			console.info(panelWest.items);
//			var panelWest = currentLayout.westRegion;
		}
	}
);
