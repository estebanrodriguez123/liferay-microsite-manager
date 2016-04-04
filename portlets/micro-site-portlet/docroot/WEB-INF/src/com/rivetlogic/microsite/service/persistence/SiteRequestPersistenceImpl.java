/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.rivetlogic.microsite.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.rivetlogic.microsite.NoSuchSiteRequestException;
import com.rivetlogic.microsite.model.SiteRequest;
import com.rivetlogic.microsite.model.impl.SiteRequestImpl;
import com.rivetlogic.microsite.model.impl.SiteRequestModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the Site Request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author steven.barba
 * @see SiteRequestPersistence
 * @see SiteRequestUtil
 * @generated
 */
public class SiteRequestPersistenceImpl extends BasePersistenceImpl<SiteRequest>
	implements SiteRequestPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SiteRequestUtil} to access the Site Request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SiteRequestImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SiteRequestModelImpl.ENTITY_CACHE_ENABLED,
			SiteRequestModelImpl.FINDER_CACHE_ENABLED, SiteRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SiteRequestModelImpl.ENTITY_CACHE_ENABLED,
			SiteRequestModelImpl.FINDER_CACHE_ENABLED, SiteRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SiteRequestModelImpl.ENTITY_CACHE_ENABLED,
			SiteRequestModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYGROUP =
		new FinderPath(SiteRequestModelImpl.ENTITY_CACHE_ENABLED,
			SiteRequestModelImpl.FINDER_CACHE_ENABLED, SiteRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP =
		new FinderPath(SiteRequestModelImpl.ENTITY_CACHE_ENABLED,
			SiteRequestModelImpl.FINDER_CACHE_ENABLED, SiteRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyGroup",
			new String[] { Long.class.getName(), Long.class.getName() },
			SiteRequestModelImpl.COMPANYID_COLUMN_BITMASK |
			SiteRequestModelImpl.GROUPID_COLUMN_BITMASK |
			SiteRequestModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYGROUP = new FinderPath(SiteRequestModelImpl.ENTITY_CACHE_ENABLED,
			SiteRequestModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyGroup",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the Site Requests where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching Site Requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SiteRequest> findByCompanyGroup(long companyId, long groupId)
		throws SystemException {
		return findByCompanyGroup(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the Site Requests where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.microsite.model.impl.SiteRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of Site Requests
	 * @param end the upper bound of the range of Site Requests (not inclusive)
	 * @return the range of matching Site Requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SiteRequest> findByCompanyGroup(long companyId, long groupId,
		int start, int end) throws SystemException {
		return findByCompanyGroup(companyId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the Site Requests where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.microsite.model.impl.SiteRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of Site Requests
	 * @param end the upper bound of the range of Site Requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching Site Requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SiteRequest> findByCompanyGroup(long companyId, long groupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP;
			finderArgs = new Object[] { companyId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYGROUP;
			finderArgs = new Object[] {
					companyId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<SiteRequest> list = (List<SiteRequest>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SiteRequest siteRequest : list) {
				if ((companyId != siteRequest.getCompanyId()) ||
						(groupId != siteRequest.getGroupId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_SITEREQUEST_WHERE);

			query.append(_FINDER_COLUMN_COMPANYGROUP_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYGROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SiteRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<SiteRequest>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SiteRequest>(list);
				}
				else {
					list = (List<SiteRequest>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first Site Request in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching Site Request
	 * @throws com.rivetlogic.microsite.NoSuchSiteRequestException if a matching Site Request could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SiteRequest findByCompanyGroup_First(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchSiteRequestException, SystemException {
		SiteRequest siteRequest = fetchByCompanyGroup_First(companyId, groupId,
				orderByComparator);

		if (siteRequest != null) {
			return siteRequest;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSiteRequestException(msg.toString());
	}

	/**
	 * Returns the first Site Request in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching Site Request, or <code>null</code> if a matching Site Request could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SiteRequest fetchByCompanyGroup_First(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SiteRequest> list = findByCompanyGroup(companyId, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last Site Request in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching Site Request
	 * @throws com.rivetlogic.microsite.NoSuchSiteRequestException if a matching Site Request could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SiteRequest findByCompanyGroup_Last(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchSiteRequestException, SystemException {
		SiteRequest siteRequest = fetchByCompanyGroup_Last(companyId, groupId,
				orderByComparator);

		if (siteRequest != null) {
			return siteRequest;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSiteRequestException(msg.toString());
	}

	/**
	 * Returns the last Site Request in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching Site Request, or <code>null</code> if a matching Site Request could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SiteRequest fetchByCompanyGroup_Last(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyGroup(companyId, groupId);

		if (count == 0) {
			return null;
		}

		List<SiteRequest> list = findByCompanyGroup(companyId, groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the Site Requests before and after the current Site Request in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param siteRequestId the primary key of the current Site Request
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next Site Request
	 * @throws com.rivetlogic.microsite.NoSuchSiteRequestException if a Site Request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SiteRequest[] findByCompanyGroup_PrevAndNext(long siteRequestId,
		long companyId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchSiteRequestException, SystemException {
		SiteRequest siteRequest = findByPrimaryKey(siteRequestId);

		Session session = null;

		try {
			session = openSession();

			SiteRequest[] array = new SiteRequestImpl[3];

			array[0] = getByCompanyGroup_PrevAndNext(session, siteRequest,
					companyId, groupId, orderByComparator, true);

			array[1] = siteRequest;

			array[2] = getByCompanyGroup_PrevAndNext(session, siteRequest,
					companyId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SiteRequest getByCompanyGroup_PrevAndNext(Session session,
		SiteRequest siteRequest, long companyId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SITEREQUEST_WHERE);

		query.append(_FINDER_COLUMN_COMPANYGROUP_COMPANYID_2);

		query.append(_FINDER_COLUMN_COMPANYGROUP_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SiteRequestModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(siteRequest);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SiteRequest> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the Site Requests where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompanyGroup(long companyId, long groupId)
		throws SystemException {
		for (SiteRequest siteRequest : findByCompanyGroup(companyId, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(siteRequest);
		}
	}

	/**
	 * Returns the number of Site Requests where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching Site Requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCompanyGroup(long companyId, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYGROUP;

		Object[] finderArgs = new Object[] { companyId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SITEREQUEST_WHERE);

			query.append(_FINDER_COLUMN_COMPANYGROUP_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYGROUP_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_COMPANYGROUP_COMPANYID_2 = "siteRequest.companyId = ? AND ";
	private static final String _FINDER_COLUMN_COMPANYGROUP_GROUPID_2 = "siteRequest.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYGROUPUSER =
		new FinderPath(SiteRequestModelImpl.ENTITY_CACHE_ENABLED,
			SiteRequestModelImpl.FINDER_CACHE_ENABLED, SiteRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyGroupUser",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUPUSER =
		new FinderPath(SiteRequestModelImpl.ENTITY_CACHE_ENABLED,
			SiteRequestModelImpl.FINDER_CACHE_ENABLED, SiteRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCompanyGroupUser",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			SiteRequestModelImpl.COMPANYID_COLUMN_BITMASK |
			SiteRequestModelImpl.GROUPID_COLUMN_BITMASK |
			SiteRequestModelImpl.USERID_COLUMN_BITMASK |
			SiteRequestModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYGROUPUSER = new FinderPath(SiteRequestModelImpl.ENTITY_CACHE_ENABLED,
			SiteRequestModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCompanyGroupUser",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the Site Requests where companyId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching Site Requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SiteRequest> findByCompanyGroupUser(long companyId,
		long groupId, long userId) throws SystemException {
		return findByCompanyGroupUser(companyId, groupId, userId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the Site Requests where companyId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.microsite.model.impl.SiteRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of Site Requests
	 * @param end the upper bound of the range of Site Requests (not inclusive)
	 * @return the range of matching Site Requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SiteRequest> findByCompanyGroupUser(long companyId,
		long groupId, long userId, int start, int end)
		throws SystemException {
		return findByCompanyGroupUser(companyId, groupId, userId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the Site Requests where companyId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.microsite.model.impl.SiteRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of Site Requests
	 * @param end the upper bound of the range of Site Requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching Site Requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SiteRequest> findByCompanyGroupUser(long companyId,
		long groupId, long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUPUSER;
			finderArgs = new Object[] { companyId, groupId, userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYGROUPUSER;
			finderArgs = new Object[] {
					companyId, groupId, userId,
					
					start, end, orderByComparator
				};
		}

		List<SiteRequest> list = (List<SiteRequest>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SiteRequest siteRequest : list) {
				if ((companyId != siteRequest.getCompanyId()) ||
						(groupId != siteRequest.getGroupId()) ||
						(userId != siteRequest.getUserId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_SITEREQUEST_WHERE);

			query.append(_FINDER_COLUMN_COMPANYGROUPUSER_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYGROUPUSER_GROUPID_2);

			query.append(_FINDER_COLUMN_COMPANYGROUPUSER_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SiteRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(userId);

				if (!pagination) {
					list = (List<SiteRequest>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SiteRequest>(list);
				}
				else {
					list = (List<SiteRequest>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first Site Request in the ordered set where companyId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching Site Request
	 * @throws com.rivetlogic.microsite.NoSuchSiteRequestException if a matching Site Request could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SiteRequest findByCompanyGroupUser_First(long companyId,
		long groupId, long userId, OrderByComparator orderByComparator)
		throws NoSuchSiteRequestException, SystemException {
		SiteRequest siteRequest = fetchByCompanyGroupUser_First(companyId,
				groupId, userId, orderByComparator);

		if (siteRequest != null) {
			return siteRequest;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSiteRequestException(msg.toString());
	}

	/**
	 * Returns the first Site Request in the ordered set where companyId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching Site Request, or <code>null</code> if a matching Site Request could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SiteRequest fetchByCompanyGroupUser_First(long companyId,
		long groupId, long userId, OrderByComparator orderByComparator)
		throws SystemException {
		List<SiteRequest> list = findByCompanyGroupUser(companyId, groupId,
				userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last Site Request in the ordered set where companyId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching Site Request
	 * @throws com.rivetlogic.microsite.NoSuchSiteRequestException if a matching Site Request could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SiteRequest findByCompanyGroupUser_Last(long companyId,
		long groupId, long userId, OrderByComparator orderByComparator)
		throws NoSuchSiteRequestException, SystemException {
		SiteRequest siteRequest = fetchByCompanyGroupUser_Last(companyId,
				groupId, userId, orderByComparator);

		if (siteRequest != null) {
			return siteRequest;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSiteRequestException(msg.toString());
	}

	/**
	 * Returns the last Site Request in the ordered set where companyId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching Site Request, or <code>null</code> if a matching Site Request could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SiteRequest fetchByCompanyGroupUser_Last(long companyId,
		long groupId, long userId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCompanyGroupUser(companyId, groupId, userId);

		if (count == 0) {
			return null;
		}

		List<SiteRequest> list = findByCompanyGroupUser(companyId, groupId,
				userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the Site Requests before and after the current Site Request in the ordered set where companyId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param siteRequestId the primary key of the current Site Request
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next Site Request
	 * @throws com.rivetlogic.microsite.NoSuchSiteRequestException if a Site Request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SiteRequest[] findByCompanyGroupUser_PrevAndNext(
		long siteRequestId, long companyId, long groupId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchSiteRequestException, SystemException {
		SiteRequest siteRequest = findByPrimaryKey(siteRequestId);

		Session session = null;

		try {
			session = openSession();

			SiteRequest[] array = new SiteRequestImpl[3];

			array[0] = getByCompanyGroupUser_PrevAndNext(session, siteRequest,
					companyId, groupId, userId, orderByComparator, true);

			array[1] = siteRequest;

			array[2] = getByCompanyGroupUser_PrevAndNext(session, siteRequest,
					companyId, groupId, userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SiteRequest getByCompanyGroupUser_PrevAndNext(Session session,
		SiteRequest siteRequest, long companyId, long groupId, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SITEREQUEST_WHERE);

		query.append(_FINDER_COLUMN_COMPANYGROUPUSER_COMPANYID_2);

		query.append(_FINDER_COLUMN_COMPANYGROUPUSER_GROUPID_2);

		query.append(_FINDER_COLUMN_COMPANYGROUPUSER_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SiteRequestModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(siteRequest);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SiteRequest> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the Site Requests where companyId = &#63; and groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompanyGroupUser(long companyId, long groupId,
		long userId) throws SystemException {
		for (SiteRequest siteRequest : findByCompanyGroupUser(companyId,
				groupId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(siteRequest);
		}
	}

	/**
	 * Returns the number of Site Requests where companyId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching Site Requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCompanyGroupUser(long companyId, long groupId, long userId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYGROUPUSER;

		Object[] finderArgs = new Object[] { companyId, groupId, userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SITEREQUEST_WHERE);

			query.append(_FINDER_COLUMN_COMPANYGROUPUSER_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYGROUPUSER_GROUPID_2);

			query.append(_FINDER_COLUMN_COMPANYGROUPUSER_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(userId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_COMPANYGROUPUSER_COMPANYID_2 = "siteRequest.companyId = ? AND ";
	private static final String _FINDER_COLUMN_COMPANYGROUPUSER_GROUPID_2 = "siteRequest.groupId = ? AND ";
	private static final String _FINDER_COLUMN_COMPANYGROUPUSER_USERID_2 = "siteRequest.userId = ?";

	public SiteRequestPersistenceImpl() {
		setModelClass(SiteRequest.class);
	}

	/**
	 * Caches the Site Request in the entity cache if it is enabled.
	 *
	 * @param siteRequest the Site Request
	 */
	@Override
	public void cacheResult(SiteRequest siteRequest) {
		EntityCacheUtil.putResult(SiteRequestModelImpl.ENTITY_CACHE_ENABLED,
			SiteRequestImpl.class, siteRequest.getPrimaryKey(), siteRequest);

		siteRequest.resetOriginalValues();
	}

	/**
	 * Caches the Site Requests in the entity cache if it is enabled.
	 *
	 * @param siteRequests the Site Requests
	 */
	@Override
	public void cacheResult(List<SiteRequest> siteRequests) {
		for (SiteRequest siteRequest : siteRequests) {
			if (EntityCacheUtil.getResult(
						SiteRequestModelImpl.ENTITY_CACHE_ENABLED,
						SiteRequestImpl.class, siteRequest.getPrimaryKey()) == null) {
				cacheResult(siteRequest);
			}
			else {
				siteRequest.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all Site Requests.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SiteRequestImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SiteRequestImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the Site Request.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SiteRequest siteRequest) {
		EntityCacheUtil.removeResult(SiteRequestModelImpl.ENTITY_CACHE_ENABLED,
			SiteRequestImpl.class, siteRequest.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SiteRequest> siteRequests) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SiteRequest siteRequest : siteRequests) {
			EntityCacheUtil.removeResult(SiteRequestModelImpl.ENTITY_CACHE_ENABLED,
				SiteRequestImpl.class, siteRequest.getPrimaryKey());
		}
	}

	/**
	 * Creates a new Site Request with the primary key. Does not add the Site Request to the database.
	 *
	 * @param siteRequestId the primary key for the new Site Request
	 * @return the new Site Request
	 */
	@Override
	public SiteRequest create(long siteRequestId) {
		SiteRequest siteRequest = new SiteRequestImpl();

		siteRequest.setNew(true);
		siteRequest.setPrimaryKey(siteRequestId);

		return siteRequest;
	}

	/**
	 * Removes the Site Request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param siteRequestId the primary key of the Site Request
	 * @return the Site Request that was removed
	 * @throws com.rivetlogic.microsite.NoSuchSiteRequestException if a Site Request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SiteRequest remove(long siteRequestId)
		throws NoSuchSiteRequestException, SystemException {
		return remove((Serializable)siteRequestId);
	}

	/**
	 * Removes the Site Request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the Site Request
	 * @return the Site Request that was removed
	 * @throws com.rivetlogic.microsite.NoSuchSiteRequestException if a Site Request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SiteRequest remove(Serializable primaryKey)
		throws NoSuchSiteRequestException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SiteRequest siteRequest = (SiteRequest)session.get(SiteRequestImpl.class,
					primaryKey);

			if (siteRequest == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSiteRequestException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(siteRequest);
		}
		catch (NoSuchSiteRequestException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected SiteRequest removeImpl(SiteRequest siteRequest)
		throws SystemException {
		siteRequest = toUnwrappedModel(siteRequest);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(siteRequest)) {
				siteRequest = (SiteRequest)session.get(SiteRequestImpl.class,
						siteRequest.getPrimaryKeyObj());
			}

			if (siteRequest != null) {
				session.delete(siteRequest);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (siteRequest != null) {
			clearCache(siteRequest);
		}

		return siteRequest;
	}

	@Override
	public SiteRequest updateImpl(
		com.rivetlogic.microsite.model.SiteRequest siteRequest)
		throws SystemException {
		siteRequest = toUnwrappedModel(siteRequest);

		boolean isNew = siteRequest.isNew();

		SiteRequestModelImpl siteRequestModelImpl = (SiteRequestModelImpl)siteRequest;

		Session session = null;

		try {
			session = openSession();

			if (siteRequest.isNew()) {
				session.save(siteRequest);

				siteRequest.setNew(false);
			}
			else {
				session.merge(siteRequest);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SiteRequestModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((siteRequestModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						siteRequestModelImpl.getOriginalCompanyId(),
						siteRequestModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP,
					args);

				args = new Object[] {
						siteRequestModelImpl.getCompanyId(),
						siteRequestModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP,
					args);
			}

			if ((siteRequestModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUPUSER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						siteRequestModelImpl.getOriginalCompanyId(),
						siteRequestModelImpl.getOriginalGroupId(),
						siteRequestModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYGROUPUSER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUPUSER,
					args);

				args = new Object[] {
						siteRequestModelImpl.getCompanyId(),
						siteRequestModelImpl.getGroupId(),
						siteRequestModelImpl.getUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYGROUPUSER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUPUSER,
					args);
			}
		}

		EntityCacheUtil.putResult(SiteRequestModelImpl.ENTITY_CACHE_ENABLED,
			SiteRequestImpl.class, siteRequest.getPrimaryKey(), siteRequest);

		return siteRequest;
	}

	protected SiteRequest toUnwrappedModel(SiteRequest siteRequest) {
		if (siteRequest instanceof SiteRequestImpl) {
			return siteRequest;
		}

		SiteRequestImpl siteRequestImpl = new SiteRequestImpl();

		siteRequestImpl.setNew(siteRequest.isNew());
		siteRequestImpl.setPrimaryKey(siteRequest.getPrimaryKey());

		siteRequestImpl.setSiteRequestId(siteRequest.getSiteRequestId());
		siteRequestImpl.setGroupId(siteRequest.getGroupId());
		siteRequestImpl.setCompanyId(siteRequest.getCompanyId());
		siteRequestImpl.setUserId(siteRequest.getUserId());
		siteRequestImpl.setCreateDate(siteRequest.getCreateDate());
		siteRequestImpl.setModifiedDate(siteRequest.getModifiedDate());
		siteRequestImpl.setName(siteRequest.getName());
		siteRequestImpl.setDescription(siteRequest.getDescription());
		siteRequestImpl.setStatus(siteRequest.getStatus());
		siteRequestImpl.setResponse(siteRequest.getResponse());
		siteRequestImpl.setSiteId(siteRequest.getSiteId());
		siteRequestImpl.setAdmin(siteRequest.isAdmin());

		return siteRequestImpl;
	}

	/**
	 * Returns the Site Request with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the Site Request
	 * @return the Site Request
	 * @throws com.rivetlogic.microsite.NoSuchSiteRequestException if a Site Request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SiteRequest findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSiteRequestException, SystemException {
		SiteRequest siteRequest = fetchByPrimaryKey(primaryKey);

		if (siteRequest == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSiteRequestException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return siteRequest;
	}

	/**
	 * Returns the Site Request with the primary key or throws a {@link com.rivetlogic.microsite.NoSuchSiteRequestException} if it could not be found.
	 *
	 * @param siteRequestId the primary key of the Site Request
	 * @return the Site Request
	 * @throws com.rivetlogic.microsite.NoSuchSiteRequestException if a Site Request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SiteRequest findByPrimaryKey(long siteRequestId)
		throws NoSuchSiteRequestException, SystemException {
		return findByPrimaryKey((Serializable)siteRequestId);
	}

	/**
	 * Returns the Site Request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the Site Request
	 * @return the Site Request, or <code>null</code> if a Site Request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SiteRequest fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SiteRequest siteRequest = (SiteRequest)EntityCacheUtil.getResult(SiteRequestModelImpl.ENTITY_CACHE_ENABLED,
				SiteRequestImpl.class, primaryKey);

		if (siteRequest == _nullSiteRequest) {
			return null;
		}

		if (siteRequest == null) {
			Session session = null;

			try {
				session = openSession();

				siteRequest = (SiteRequest)session.get(SiteRequestImpl.class,
						primaryKey);

				if (siteRequest != null) {
					cacheResult(siteRequest);
				}
				else {
					EntityCacheUtil.putResult(SiteRequestModelImpl.ENTITY_CACHE_ENABLED,
						SiteRequestImpl.class, primaryKey, _nullSiteRequest);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SiteRequestModelImpl.ENTITY_CACHE_ENABLED,
					SiteRequestImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return siteRequest;
	}

	/**
	 * Returns the Site Request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param siteRequestId the primary key of the Site Request
	 * @return the Site Request, or <code>null</code> if a Site Request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SiteRequest fetchByPrimaryKey(long siteRequestId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)siteRequestId);
	}

	/**
	 * Returns all the Site Requests.
	 *
	 * @return the Site Requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SiteRequest> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the Site Requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.microsite.model.impl.SiteRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of Site Requests
	 * @param end the upper bound of the range of Site Requests (not inclusive)
	 * @return the range of Site Requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SiteRequest> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the Site Requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.microsite.model.impl.SiteRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of Site Requests
	 * @param end the upper bound of the range of Site Requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of Site Requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SiteRequest> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<SiteRequest> list = (List<SiteRequest>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SITEREQUEST);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SITEREQUEST;

				if (pagination) {
					sql = sql.concat(SiteRequestModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SiteRequest>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SiteRequest>(list);
				}
				else {
					list = (List<SiteRequest>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the Site Requests from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SiteRequest siteRequest : findAll()) {
			remove(siteRequest);
		}
	}

	/**
	 * Returns the number of Site Requests.
	 *
	 * @return the number of Site Requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SITEREQUEST);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the Site Request persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rivetlogic.microsite.model.SiteRequest")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SiteRequest>> listenersList = new ArrayList<ModelListener<SiteRequest>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SiteRequest>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(SiteRequestImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SITEREQUEST = "SELECT siteRequest FROM SiteRequest siteRequest";
	private static final String _SQL_SELECT_SITEREQUEST_WHERE = "SELECT siteRequest FROM SiteRequest siteRequest WHERE ";
	private static final String _SQL_COUNT_SITEREQUEST = "SELECT COUNT(siteRequest) FROM SiteRequest siteRequest";
	private static final String _SQL_COUNT_SITEREQUEST_WHERE = "SELECT COUNT(siteRequest) FROM SiteRequest siteRequest WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "siteRequest.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SiteRequest exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SiteRequest exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SiteRequestPersistenceImpl.class);
	private static SiteRequest _nullSiteRequest = new SiteRequestImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SiteRequest> toCacheModel() {
				return _nullSiteRequestCacheModel;
			}
		};

	private static CacheModel<SiteRequest> _nullSiteRequestCacheModel = new CacheModel<SiteRequest>() {
			@Override
			public SiteRequest toEntityModel() {
				return _nullSiteRequest;
			}
		};
}