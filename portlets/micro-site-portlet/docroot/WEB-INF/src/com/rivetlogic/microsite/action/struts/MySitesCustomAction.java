package com.rivetlogic.microsite.action.struts;

import com.liferay.portal.kernel.struts.BaseStrutsPortletAction;
import com.liferay.portal.kernel.struts.StrutsPortletAction;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.rivetlogic.microsite.model.SiteRequest;
import com.rivetlogic.microsite.service.SiteRequestLocalServiceUtil;
import com.rivetlogic.microsite.util.MicroSiteConstants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

public class MySitesCustomAction extends BaseStrutsPortletAction {


    @Override
    public void processAction(StrutsPortletAction originalStrutsPortletAction, PortletConfig portletConfig,
            ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        
        SiteRequestLocalServiceUtil.add(
                themeDisplay.getCompanyGroupId(),
                themeDisplay.getScopeGroupId(),
                themeDisplay.getUserId(),
                actionRequest.getParameter(MicroSiteConstants.SITE_REQUEST_NAME),
                actionRequest.getParameter(MicroSiteConstants.SITE_REQUEST_DESCRIPTION)
                );
        
        actionResponse.sendRedirect(actionRequest.getParameter("redirect"));
        
        super.processAction(originalStrutsPortletAction, portletConfig, actionRequest, actionResponse);
    }
    
    @Override
    public String render(StrutsPortletAction originalStrutsPortletAction, PortletConfig portletConfig,
            RenderRequest renderRequest, RenderResponse renderResponse) throws Exception {
        
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        
        List siteRequestValues = new ArrayList();
        
        if(themeDisplay.isSignedIn()) {
            List<SiteRequest> siteRequests = SiteRequestLocalServiceUtil.findByCompanyGroupUser(
                    themeDisplay.getCompanyGroupId(),
                    themeDisplay.getScopeGroupId(),
                    themeDisplay.getUserId()
                    );
            
            for(SiteRequest siteRequest : siteRequests) {
                Map values = new HashMap();
                values.put("name", siteRequest.getName());
                values.put("status", siteRequest.getStatus());
                if(siteRequest.getStatus().equals("rejected")) {
                    values.put("response", siteRequest.getResponse());
                }
                values.put("modifiedDate", siteRequest.getModifiedDate());
                siteRequestValues.add(values);
            }
            
        }
       
        renderRequest.setAttribute(MicroSiteConstants.SITE_REQUESTS_LIST, siteRequestValues);
        
        return originalStrutsPortletAction.render(portletConfig, renderRequest, renderResponse);
    }
    
    @Override
    public void serveResource(StrutsPortletAction originalStrutsPortletAction, PortletConfig portletConfig,
            ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
        
        originalStrutsPortletAction.serveResource(portletConfig, resourceRequest, resourceResponse);
    }
    
}
