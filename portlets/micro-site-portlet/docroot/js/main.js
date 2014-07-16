/**
 * Copyright (C) 2005-2014 Rivet Logic Corporation.
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; version 3 of the License.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */

AUI().add('microsites', function(A) {
	A.namespace('microsites');
	var iFrameURL = null;
	var portletNamespace = null;
	var searchSiteTemplateModal = undefined;
	
	A.microsites.setIFrameURL = function(url,pns) {
		iFrameURL = url;
		portletNamespace = pns;
	};
	
	A.microsites.choosesSiteTemplateModal = function() {
		Liferay.Util.openWindow({
            dialog: {
                align: Liferay.Util.Window.ALIGN_CENTER,
                cache: false,
                width: 850,
                height: 600,
                bodyContent: Liferay.Language.get('modal-loading-content'),
                modal: true,
                visible:false
            },
            id: 'site-template-iframe',
            title: Liferay.Language.get('modal-title'),
            uri: iFrameURL
        }, function (modal) {
        	searchSiteTemplateModal = modal;
        });
	};
	
	A.microsites.handleClickEvent = function(event) {
		if(searchSiteTemplateModal) {
			searchSiteTemplateModal.destroy();
		}
		A.microsites.choosesSiteTemplateModal();
		searchSiteTemplateModal.show();
	};
	
	A.microsites.handlePopupResult = function(data) {
		var siteTemplateId = data['id'];
		var siteTemplateName = data['name'];
		A.one('#'+portletNamespace+'layoutSetPrototypeId').set('value', siteTemplateId);
		A.one('#'+portletNamespace+'layoutSetPrototypeIdTemp').set('value', siteTemplateId);
		A.one('#'+portletNamespace+'layoutSetPrototypeName').set('value', siteTemplateName);
	};
	
	A.microsites.onChangeMicroSiteName = function () {
		var microSiteName = A.one('#'+portletNamespace+"name");
		microSiteName.on('valuechange', function(event){
			var value = microSiteName.get('value');
			if(value) {
				value = value.toLowerCase().split(' ').join('-');
			}
			A.one('#'+portletNamespace+'friendlyURL').set('value', '/'+value);
		});
	};
	
},
'',
{
	requires:['aui-base','aui-modal']
});

AUI().add('modal_site_template', function(A) {
	A.namespace('modal_site_template');
	A.modal_site_template.handleChooseClick = function(pns, url) {
		var Util = Liferay.Util;
		A.one('#'+pns+'choose_site_template').delegate('click', function(event) {
			var result = Util.getAttributes(event.currentTarget, 'data-');
			Util.getOpener().handlePopupResult(result);
			Util.getWindow().hide();
		}, '.selector-button');
	};
},
'',
{
	requires:['aui-base']
});

AUI().add('micrositeform', function(A) {
	A.namespace('micrositeform');
	var portletNamespace = null;
	
	A.micrositeform.init = function(pns) {
		portletNamespace = pns;
	};
	
	A.micrositeform.handleChoosePublicLayout = function() {
		var publicLayoutSetPrototype = A.one('#' + portletNamespace + 'publicLayoutSetPrototypeId');
		publicLayoutSetPrototype.on('change', function(event) {
			var value = publicLayoutSetPrototype.get('value');
			var publicLayoutSetPrototypeLinkEnabled = A.one('#' + portletNamespace + 'publicLayoutSetPrototypeLinkEnabledCheckbox');
			if(value != '0') {
				A.one('#' + portletNamespace + 'TemplateError').hide();
				publicLayoutSetPrototypeLinkEnabled.set('disabled', false);
			} else {
				publicLayoutSetPrototypeLinkEnabled.set('disabled', true);
				publicLayoutSetPrototypeLinkEnabled.set('checked', false);
			}
		});
	};
	
	A.micrositeform.handleChoosePrivateLayout = function() {
		var privateLayoutSetPrototype = A.one('#' + portletNamespace + 'privateLayoutSetPrototypeId');
		privateLayoutSetPrototype.on('change', function(event) {
			var value = privateLayoutSetPrototype.get('value');
			var privateLayoutSetPrototypeLinkEnabled = A.one('#' + portletNamespace + 'privateLayoutSetPrototypeLinkEnabledCheckbox');
			if(value != '0') {
				A.one('#' + portletNamespace + 'TemplateError').hide();
				privateLayoutSetPrototypeLinkEnabled.set('disabled', false);
			} else {
				privateLayoutSetPrototypeLinkEnabled.set('disabled', true);
				privateLayoutSetPrototypeLinkEnabled.set('checked', false);
			} 
		});
	};
	
	A.micrositeform.onSubmit = function(event) {
		var publicLayoutSetPrototype = A.one('#' + portletNamespace + 'publicLayoutSetPrototypeId').val();
		var privateLayoutSetPrototype = A.one('#' + portletNamespace + 'privateLayoutSetPrototypeId').val();
		
		if(publicLayoutSetPrototype == '0' && privateLayoutSetPrototype == '0'){
			//event.preventDefault();
			event.stopPropagation();
			A.one('#' + portletNamespace + 'TemplateError').show();
		}
	};
},
'',
{
	requires:['aui-base', 'liferay-notice']
});