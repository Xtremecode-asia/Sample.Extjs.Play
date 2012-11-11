// **********************************//
// ** By: Wendy Sanarwanto **********//
// ** e-mail: saintc0d3r@gmail.com **//
// **********************************//


// -- Entry Point --
Ext.application({
        name: 'Sample.Extjs.Play.Mvc.SimpleCrud',
        appFolder: '/assets/extjs/application',
        launch: onApplicationLaunched,

        controllers: ['EmployeeController']
    }
);

// ************************************************************************************************************************************************//
// ******************************************************************* Handlers *******************************************************************//
// ************************************************************************************************************************************************//

// Invoked when the application is launched 
function onApplicationLaunched() {
	Ext.QuickTips.init();
	Ext.create('Ext.container.Viewport',{
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
            height: 25,
            minHeight: 25
        }, {
            region: 'center',
            layout:'fit',
            items: [{
                xtype: 'tabpanel',
                id: 'mainTabPanel',
                html: '<h3>Double click the function item to display its tab.</h3>',
                activeTab: 0
            }]
        }]
    });
}

// Displays tab panels when a leaf node is double clicked
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

// ************************************************************************************************************************************************//
// ******************************************************************  Helpers ********************************************************************//
// ************************************************************************************************************************************************//

// Build the main tree view in the West region panel
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
                id: 'reportsNode',
                children: buildReportNodes()
            }]
        },
        listeners: {
            itemdblclick: function (parent, record, item, index, e, eOpts ){
                onMainTreePanelDoubleClicked(parent, record, item, index, e, eOpts);
            }
        }
    }];
}

// Build report nodes
function buildReportNodes(){
    // TODO -- Add report nodes
    return [buildChildNodeConfig('Employees Report', 'employeeReportNode', 'employeeReportTab', buildEmployeeReportConfig() )]
}

// Build children nodes that belong to Master Data node
function buildMasterDataNodes(){
    // TODO -- Add other nodes
    return [ buildChildNodeConfig('Employee', 'employeeNode','employeeTab', buildEmployeeFormConfig()) ];
}

// Build form panels for a child node ( displayed form when the child node is double clicked)
function buildChildNodeConfig( tabTitle, nodeId, tabId, childNodeFormConfig){
    // TODO -- Changes the parameters to be in an array of params
    return { text: tabTitle,
        id: nodeId,
        leaf: true,
        fields: [{ tabConfigs: { title: tabTitle, closable: true, id: tabId , layout: { type: 'vbox', align: 'stretch'},
                    items: childNodeFormConfig } },
            { tabId: tabId}]
    };
}

// Describe the form that belong to the employee node
function buildEmployeeFormConfig(){
    return [{
        itemId: 'panelEntryEmployeeData',
        xtype: 'employeeEntryForm',
        flex: 1,
        margins: '0 0 1 0'
    }, {
        itemId: 'panelEmployeeGridView',
        xtype: 'employeeGridForm',
        flex: 2,
        margins: '0 0 1 0'
    }];
}

// Describe the form that belong to the employee report node
function buildEmployeeReportConfig(){
    // TODO -- Implement this
    return [{
        xtype: 'component',
        itemId: 'employeeReportView',
        margins: '0 0 1 0',
        autoEl: {
            tag: 'iframe',
            src: 'http://localhost:9000/employees/report'
        }
    }];
}

function buildToolbar(){
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

