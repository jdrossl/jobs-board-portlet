AUI.add('jobs-board-portlet', function (A) {
  
  A.JobsBoard = A.Base.create('jobs-board-portlet', A.Base, [Liferay.PortletBase], {
    
    initializer: function () {
      console.log('initialized');
      this.bindEvents();
    },
    
    bindEvents: function() {
      var self = this;
      this.one('.portlet-body').delegate('click', function(e) {
          e.preventDefault();
          self.one('.filters-form').toggleClass('hidden');
      }, '.filters a');
      
      A.one(document).on('click', function(e) {
        if (!e.target.ancestor('.filters') && self.one('.filters-form')) {
          self.one('.filters-form').addClass('hidden');
        }
      });
      
      this.one('.portlet-body').delegate('change', function(e) {
          var val = (this.get('value').length) ? this.get('value').match(/[^\/\\]+$/)[0] : '';
          this.ancestor('.file-field').one('input[type="text"]').set('value', val);
      }, '.file-field input');
      
      this.one('.portlet-body').delegate('change', function(e) {
    	  A.one('.main-filters-form').submit();
      }, '.filters-submit');
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
