// -- Entry Point
Ext.application({
		name: 'Sample.ExtJs.Play.Mvc.SimpleCrud',
		launch: onApplicationLaunched
	}
);

// Helpers
function onApplicationLaunched() {
	var mainViewPort = 
		Ext.create('Ext.container.Viewport', {				
				layout: 'border',
				items: [{
					region: 'north',
					title: '.:: Sample MVC CRUD ::.',
					margins: '3 3 3 3'					
				}, {
					region: 'west',
					id: 'panelWest',
					collapsible: true,
					title: 'Functions',							
					width: 190,
					margins: '0 2 0 3',					
					layout: 'fit',
					items: buildTreePanel()
				}, {
					region: 'south',
					collapsible: false,
					split: false,
					html: '<h2> TODO -- Add status bar here </h2> ',
					height: 20,
					minHeight: 20
				}, {
					region: 'center',
					items: [builToolbar(),	
					{	
						xtype: 'tabpanel',
						id: 'mainTabPanel',
						html: '<h3>Double click the function item to display its tab.</h3>'
//						activeTab: 0,
//						items: {
//							title: 'Default Tab',
//							closable: true,
//            				html: 'The first tab\'s content. Others may be added dynamically'
//						}
					}]
				}]
			}
		);			
}

function buildTreePanel(){
	return [{	xtype: 'treepanel',
				root: { 
					text: 'Root', 
					expanded: true,
					id: 'rootNode',
					children: [{
						text: 'Master Data',
						expanded: true,
						id: 'masterDataNode',
						children: buildMasterDataNodes()
					}, {
						text: 'Transactional Data',
						expanded: true,
						id: 'transactionalDataNode'
					}, {
						text: 'Reports',
						expanded: true,
						id: 'reportsNode'
					}]									
				},
				listeners: {
					itemdblclick: function (parent, record, item, index, e, eOpts ){
						onMainTreePanelDoubleClicked(parent, record, item, index, e, eOpts);										
					}
				}
			}];
}

function onMainTreePanelDoubleClicked(parent, record, item, index, e, eOpts ){
	// Does the user click a leaf node in the main tree view ?
	if (record.isLeaf() && record.raw.fields.length > 1){
 		var nodeTabId = record.raw.fields[1].tabId;
 		var nodeTab = Ext.getCmp(nodeTabId);
 		// Try to get the active panel 1st
 		var mainTabPanel = Ext.getCmp('mainTabPanel');
		if (nodeTab == null){			
			// The requested panel does not exist. So let's create it 1st
			nodeTab = mainTabPanel.add( record.raw.fields[0].tabConfigs );			
		}
		mainTabPanel.setActiveTab(nodeTab);		
	}
}

function buildMasterDataNodes(){
	// TODO -- Add other nodes
	return [ buildChildNodeConfig('Employee', 'employeeNode','employeeTab') ];
}

function buildChildNodeConfig( tabTitle, nodeId, tabId){
	// TODO -- Changes the parameters to be in an array of params
	return { text: tabTitle,
			  id: nodeId,
			  leaf: true,
			  fields: [{ tabConfigs: { title: tabTitle, closable: true, id: tabId } },
			  		   { tabId: tabId}]
	};
}

function builToolbar(){
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
					
	
	return 	{	xtype: 'toolbar',
				items: [{
					xtype: 'button',
					text: 'File' 
				}, {
					xtype: 'button',
					text: 'Help'
				}]
			};	
}