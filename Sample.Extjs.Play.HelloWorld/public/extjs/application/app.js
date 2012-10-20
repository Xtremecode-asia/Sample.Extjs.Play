Ext.application({
		name: 'Sample.ExtJs.Play.HelloWorld',
		launch: function() {
			// Create main viewPort
			Ext.create('Ext.container.Viewport', {
					layout: 'fit',
					items: [{
						title: '.:: '+document.title+' ::.',
						html: 'Hello Play 2 & ExtJS.'
					}]
				}
			);
		}
	}
);
