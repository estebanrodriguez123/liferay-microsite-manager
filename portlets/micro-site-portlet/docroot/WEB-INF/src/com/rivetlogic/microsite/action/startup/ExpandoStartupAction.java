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

package com.rivetlogic.microsite.action.startup;

import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.SimpleAction;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.LayoutSetPrototype;
import com.liferay.portlet.expando.DuplicateColumnNameException;
import com.liferay.portlet.expando.DuplicateTableNameException;
import com.liferay.portlet.expando.model.ExpandoColumn;
import com.liferay.portlet.expando.model.ExpandoColumnConstants;
import com.liferay.portlet.expando.model.ExpandoTable;
import com.liferay.portlet.expando.service.ExpandoColumnLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoTableLocalServiceUtil;

/**
 * @author Christopher Jimenez
 *
 */
public class ExpandoStartupAction extends SimpleAction {

	private static Log LOG = LogFactoryUtil.getLog(ExpandoStartupAction.class);
	public final static String COLUMN_NAME = "available-for-micro-site-portlet"; 
	
	@Override
	public void run(String[] ids) throws ActionException {
		try{
			doRun(ids);
		}catch (Exception e) {
			LOG.error(e);
		}
	}

	private void doRun(String[] ids) throws Exception{
		ExpandoTable table = null;

		long companyId = Long.parseLong(ids[0]);

		try {
		 	table = ExpandoTableLocalServiceUtil.addDefaultTable(
			 	companyId, LayoutSetPrototype.class.getName());
		}
		catch(DuplicateTableNameException dtne) {
		 	table = ExpandoTableLocalServiceUtil.getDefaultTable(
			 	companyId, LayoutSetPrototype.class.getName());
		}
		long tableId = table.getTableId();

		try {
			ExpandoColumn column = ExpandoColumnLocalServiceUtil.addColumn(
				tableId, COLUMN_NAME, ExpandoColumnConstants.BOOLEAN);
			
			ExpandoColumnLocalServiceUtil.updateExpandoColumn(column);
		}
		catch(DuplicateColumnNameException dcne) {
			LOG.debug("Expando" +  COLUMN_NAME + " already exist!");
	
		}
	}
}
