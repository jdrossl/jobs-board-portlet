AUI.add('jobs-board-portlet', function (A) {
  
  A.JobsBoard = A.Base.create('jobs-board-portlet', A.Base, [Liferay.PortletBase], {
    
    initializer: function () {
      console.log('initialized');
      this.bindEvents();
    },
    
    bindEvents: function() {
      var self = this;
      this.one('.filters a').on('click', function(e) {
          e.preventDefault();
          self.one('.filters-form').toggleClass('hidden');
      });
      A.one(document).on('click', function(e) {
        if (!e.target.ancestor('.filters')) {
          self.one('.filters-form').addClass('hidden');
        }
      });
    }
  }, {
    ATTRS: {
      
      /**
      * Resource portlet url provided to execute ajax calls
      * 
      */
      portletResourceUrl: {
        value: null
      }
    }
  });
  
}, '1.0.0', {
  requires: ['liferay-portlet-base', 'aui-popover']
});
