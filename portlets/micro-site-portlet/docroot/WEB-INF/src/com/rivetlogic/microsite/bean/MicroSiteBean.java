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

package com.rivetlogic.microsite.bean;

public interface MicroSiteBean {
	public long getMicroSiteId();
	public void setMicroSiteId(long microSiteId);
    public long getGroupId();
    public void setGroupId(long groupId);
    public String getName();
    public void setName(String name);
    public String getDescription();
    public void setDescription(String description);
    public boolean isActive();
    public void setActive(boolean active);
    public String getFriendlyURL();
    public void setFriendlyURL(String friendlyUrl);
    public int getType();
    public void setType(int type);
    public boolean isManualMembership();
    public void setManualMembership(boolean manualMembership);
    
    public long getPublicLayoutSetPrototypeId();
    public void setPublicLayoutSetPrototypeId(long publicLayoutSetPrototypeId);
    public boolean isPublicLayoutSetPrototypeLinkEnabled();
    public void setPublicLayoutSetPrototypeLinkEnabled(boolean publicLayoutSetPrototypeLinkEnabled);
    public long getPrivateLayoutSetPrototypeId();
    public void setPrivateLayoutSetPrototypeId(long privateLayoutSetPrototypeId);
    public boolean isPrivateLayoutSetPrototypeLinkEnabled();
    public void setPrivateLayoutSetPrototypeLinkEnabled(boolean privateLayoutSetPrototypeLinkEnabled);
    
    public String getLayoutSetPrototypeName();
    public void setLayoutSetPrototypeName(String layoutSetPrototypeName);
    
    public String getTypeString();
    public String getActiveString();
}
