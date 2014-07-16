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

package com.rivetlogic.microsite.bean.impl;

import com.liferay.portal.kernel.util.StringPool;
import com.rivetlogic.microsite.bean.MicroSiteBean;
import com.rivetlogic.microsite.util.MicroSiteConstants;

public class MicroSiteBeanImpl implements MicroSiteBean {
	protected long microSiteId; 
    protected long groupId;
    protected String name;
    protected String description;
    protected boolean active;
    protected String friendlyURL;
    protected int type;
    protected boolean manualMembership;
    protected long publicLayoutSetPrototypeId;
    protected boolean publicLayoutSetPrototypeLinkEnabled;
    protected long privateLayoutSetPrototypeId;
    protected boolean privateLayoutSetPrototypeLinkEnabled;
    protected String layoutSetPrototypeName;
    
    public MicroSiteBeanImpl(){
        
    }
    
    /**
     * @return microSiteId
     */
    public long getMicroSiteId(){
    	return microSiteId;
    }
    
    /**
     * @param microSiteId the microSiteId to set
     */
    public void setMicroSiteId(long microSiteId){
    	this.microSiteId = microSiteId;
    }
    
    /**
     * @return the groupId
     */
    public long getGroupId() {
        return groupId;
    }

    /**
     * @param groupId the groupId to set
     */
    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * @return the friendlyURL
     */
    public String getFriendlyURL() {
        return friendlyURL;
    }

    /**
     * @param friendlyURL the friendlyURL to set
     */
    public void setFriendlyURL(String friendlyURL) {
        this.friendlyURL = friendlyURL;
    }

    /**
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * @return the manualMembership
     */
    public boolean isManualMembership() {
        return manualMembership;
    }

    /**
     * @param manualMembership the manualMembership to set
     */
    public void setManualMembership(boolean manualMembership) {
        this.manualMembership = manualMembership;
    }

    /**
     * @return the publicLayoutSetPrototypeId
     */
    public long getPublicLayoutSetPrototypeId() {
        return publicLayoutSetPrototypeId;
    }

    /**
     * @param publicLayoutSetPrototypeId the publicLayoutSetPrototypeId to set
     */
    public void setPublicLayoutSetPrototypeId(long publicLayoutSetPrototypeId) {
        this.publicLayoutSetPrototypeId = publicLayoutSetPrototypeId;
    }

    /**
     * @return the publicLayoutSetPrototypeLinkEnabled
     */
    public boolean isPublicLayoutSetPrototypeLinkEnabled() {
        return publicLayoutSetPrototypeLinkEnabled;
    }

    /**
     * @param publicLayoutSetPrototypeLinkEnabled the publicLayoutSetPrototypeLinkEnabled to set
     */
    public void setPublicLayoutSetPrototypeLinkEnabled(boolean publicLayoutSetPrototypeLinkEnabled) {
        this.publicLayoutSetPrototypeLinkEnabled = publicLayoutSetPrototypeLinkEnabled;
    }

    /**
     * @return the privateLayoutSetPrototypeId
     */
    public long getPrivateLayoutSetPrototypeId() {
        return privateLayoutSetPrototypeId;
    }

    /**
     * @param privateLayoutSetPrototypeId the privateLayoutSetPrototypeId to set
     */
    public void setPrivateLayoutSetPrototypeId(long privateLayoutSetPrototypeId) {
        this.privateLayoutSetPrototypeId = privateLayoutSetPrototypeId;
    }

    /**
     * @return the privateLayoutSetPrototypeLinkEnabled
     */
    public boolean isPrivateLayoutSetPrototypeLinkEnabled() {
        return privateLayoutSetPrototypeLinkEnabled;
    }

    /**
     * @param privateLayoutSetPrototypeLinkEnabled the privateLayoutSetPrototypeLinkEnabled to set
     */
    public void setPrivateLayoutSetPrototypeLinkEnabled(boolean privateLayoutSetPrototypeLinkEnabled) {
        this.privateLayoutSetPrototypeLinkEnabled = privateLayoutSetPrototypeLinkEnabled;
    }

    /**
     * @return the layoutSetPrototypeName
     */
    public String getLayoutSetPrototypeName() {
        return layoutSetPrototypeName;
    }

    /**
     * @param layoutSetPrototypeName the layoutSetPrototypeName to set
     */
    public void setLayoutSetPrototypeName(String layoutSetPrototypeName) {
        this.layoutSetPrototypeName = layoutSetPrototypeName;
    }
    
    public String getTypeString(){
        if(type == MicroSiteConstants.MICRO_SITE_OPEN_TYPE) {
            return MicroSiteConstants.MICRO_SITE_OPEN_TYPE_STRING;
        } else if(type == MicroSiteConstants.MICRO_SITE_RESTRICTED_TYPE) {
            return MicroSiteConstants.MICRO_SITE_RESTRICTED_TYPE_STRING;
        } else if(type == MicroSiteConstants.MICRO_SITE_PRIVATE_TYPE) {
            return MicroSiteConstants.MICRO_SITE_PRIVATE_TYPE_STRING;
        }
        return StringPool.BLANK;
    }
    public String getActiveString(){
        return active ? MicroSiteConstants.MICRO_SITE_ACTIVE_YES :  MicroSiteConstants.MICRO_SITE_ACTIVE_NO;
    }
}
