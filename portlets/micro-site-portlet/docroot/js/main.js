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
	
	var CONFIRM_MICRO_SITE_URL = '';
	var BASE_MICRO_SITE_URL = '';
	var CHECKBOX_ADMIN = 'microSiteAdminCheckbox';
	var DROPDOWN_MICROSITES = 'microSiteList';
	var CONFIRM_MICRO_SITE_ANCHOR = 'completeMicroSite';
	var SITE_ID = 'siteId';
	var SET_ADMIN = 'setAdmin';
	var TABLE_CELL = 'table-cell';
	
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

	// called when updating a microsite status
	A.microsites.initUpdateMicroSite = function (portletNS) {
		portletNamespace = portletNamespace || portletNS;
		initDropDownMicroSite();
		setCheckBoxAdminHandler();
		setConfirmMicroSiteUrl(A.all('#' + portletNamespace + CHECKBOX_ADMIN), A.all('#' + portletNamespace + DROPDOWN_MICROSITES));
	}

	// helper functions when updating status and set it as 'complete'
	function setCheckBoxAdminHandler() {
		A.all('#' + portletNamespace + CHECKBOX_ADMIN).on('change', function (event) {
			checkBoxHandler(event, this, event.target.ancestor('.' + TABLE_CELL).all('#' + portletNamespace + DROPDOWN_MICROSITES));
		});
	}

	function setConfirmBaseUrl(confirmUrl) {
		BASE_MICRO_SITE_URL = BASE_MICRO_SITE_URL || confirmUrl;
	}

	function initDropDownMicroSite() {
		A.all('#' + portletNamespace + DROPDOWN_MICROSITES).on('change', function (event) {
			setConfirmMicroSiteUrl(A.one('#' + portletNamespace + CHECKBOX_ADMIN), event.target);
		});
	}

	function checkBoxHandler(event, checkbox, dropDown) {
		setConfirmMicroSiteUrl(checkbox, dropDown);
	}

	function setConfirmMicroSiteUrl(checkbox, dropDown) {
		if(!checkbox || !dropDown) return;
		setConfirmBaseUrl(A.all('#' + portletNamespace + CONFIRM_MICRO_SITE_ANCHOR).attr('href'));
		var siteId = getDropDownValue(dropDown);
		CONFIRM_MICRO_SITE_URL = buildActionUrl(siteId, checkbox.attr('checked')[0]);
		A.all('#' + portletNamespace + CONFIRM_MICRO_SITE_ANCHOR).setAttribute('href', CONFIRM_MICRO_SITE_URL.toString());
	}

	function buildActionUrl (siteId, setAdmin) {
		var url = new Liferay.PortletURL.createActionURL();
		url.options.basePortletURL = BASE_MICRO_SITE_URL;
		url.setParameter(SITE_ID, siteId);
		url.setParameter(SET_ADMIN, setAdmin);
		return url;
	}

	function getDropDownValue(dropDown) {
		return dropDown.val();
	}
},
'',
{
	requires:['aui-base','aui-modal', 'aui-io-request','liferay-portlet-url']
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