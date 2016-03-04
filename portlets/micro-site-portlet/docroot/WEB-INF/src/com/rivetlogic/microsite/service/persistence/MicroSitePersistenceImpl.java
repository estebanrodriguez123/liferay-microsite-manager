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

import com.rivetlogic.microsite.NoSuchMicroSiteException;
import com.rivetlogic.microsite.model.MicroSite;
import com.rivetlogic.microsite.model.impl.MicroSiteImpl;
import com.rivetlogic.microsite.model.impl.MicroSiteModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the micro site service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author steven.barba
 * @see MicroSitePersistence
 * @see MicroSiteUtil
 * @generated
 */
public class MicroSitePersistenceImpl extends BasePersistenceImpl<MicroSite>
	implements MicroSitePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MicroSiteUtil} to access the micro site persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MicroSiteImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MicroSiteModelImpl.ENTITY_CACHE_ENABLED,
			MicroSiteModelImpl.FINDER_CACHE_ENABLED, MicroSiteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MicroSiteModelImpl.ENTITY_CACHE_ENABLED,
			MicroSiteModelImpl.FINDER_CACHE_ENABLED, MicroSiteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MicroSiteModelImpl.ENTITY_CACHE_ENABLED,
			MicroSiteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_GROUPID = new FinderPath(MicroSiteModelImpl.ENTITY_CACHE_ENABLED,
			MicroSiteModelImpl.FINDER_CACHE_ENABLED, MicroSiteImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByGroupId",
			new String[] { Long.class.getName() },
			MicroSiteModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(MicroSiteModelImpl.ENTITY_CACHE_ENABLED,
			MicroSiteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the micro site where groupId = &#63; or throws a {@link com.rivetlogic.microsite.NoSuchMicroSiteException} if it could not be found.
	 *
	 * @param groupId the group ID
	 * @return the matching micro site
	 * @throws com.rivetlogic.microsite.NoSuchMicroSiteException if a matching micro site could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MicroSite findByGroupId(long groupId)
		throws NoSuchMicroSiteException, SystemException {
		MicroSite microSite = fetchByGroupId(groupId);

		if (microSite == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchMicroSiteException(msg.toString());
		}

		return microSite;
	}

	/**
	 * Returns the micro site where groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @return the matching micro site, or <code>null</code> if a matching micro site could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MicroSite fetchByGroupId(long groupId) throws SystemException {
		return fetchByGroupId(groupId, true);
	}

	/**
	 * Returns the micro site where groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching micro site, or <code>null</code> if a matching micro site could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MicroSite fetchByGroupId(long groupId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_GROUPID,
					finderArgs, this);
		}

		if (result instanceof MicroSite) {
			MicroSite microSite = (MicroSite)result;

			if ((groupId != microSite.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_MICROSITE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				List<MicroSite> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"MicroSitePersistenceImpl.fetchByGroupId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					MicroSite microSite = list.get(0);

					result = microSite;

					cacheResult(microSite);

					if ((microSite.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID,
							finderArgs, microSite);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GROUPID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (MicroSite)result;
		}
	}

	/**
	 * Removes the micro site where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @return the micro site that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MicroSite removeByGroupId(long groupId)
		throws NoSuchMicroSiteException, SystemException {
		MicroSite microSite = findByGroupId(groupId);

		return remove(microSite);
	}

	/**
	 * Returns the number of micro sites where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching micro sites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupId(long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MICROSITE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "microSite.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYUSER =
		new FinderPath(MicroSiteModelImpl.ENTITY_CACHE_ENABLED,
			MicroSiteModelImpl.FINDER_CACHE_ENABLED, MicroSiteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyUser",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYUSER =
		new FinderPath(MicroSiteModelImpl.ENTITY_CACHE_ENABLED,
			MicroSiteModelImpl.FINDER_CACHE_ENABLED, MicroSiteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyUser",
			new String[] { Long.class.getName(), Long.class.getName() },
			MicroSiteModelImpl.COMPANYID_COLUMN_BITMASK |
			MicroSiteModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYUSER = new FinderPath(MicroSiteModelImpl.ENTITY_CACHE_ENABLED,
			MicroSiteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyUser",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the micro sites where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @return the matching micro sites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MicroSite> findByCompanyUser(long companyId, long userId)
		throws SystemException {
		return findByCompanyUser(companyId, userId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the micro sites where companyId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.microsite.model.impl.MicroSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of micro sites
	 * @param end the upper bound of the range of micro sites (not inclusive)
	 * @return the range of matching micro sites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MicroSite> findByCompanyUser(long companyId, long userId,
		int start, int end) throws SystemException {
		return findByCompanyUser(companyId, userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the micro sites where companyId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.microsite.model.impl.MicroSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of micro sites
	 * @param end the upper bound of the range of micro sites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching micro sites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MicroSite> findByCompanyUser(long companyId, long userId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYUSER;
			finderArgs = new Object[] { companyId, userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYUSER;
			finderArgs = new Object[] {
					companyId, userId,
					
					start, end, orderByComparator
				};
		}

		List<MicroSite> list = (List<MicroSite>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MicroSite microSite : list) {
				if ((companyId != microSite.getCompanyId()) ||
						(userId != microSite.getUserId())) {
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

			query.append(_SQL_SELECT_MICROSITE_WHERE);

			query.append(_FINDER_COLUMN_COMPANYUSER_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYUSER_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MicroSiteModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(userId);

				if (!pagination) {
					list = (List<MicroSite>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MicroSite>(list);
				}
				else {
					list = (List<MicroSite>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first micro site in the ordered set where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching micro site
	 * @throws com.rivetlogic.microsite.NoSuchMicroSiteException if a matching micro site could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MicroSite findByCompanyUser_First(long companyId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchMicroSiteException, SystemException {
		MicroSite microSite = fetchByCompanyUser_First(companyId, userId,
				orderByComparator);

		if (microSite != null) {
			return microSite;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMicroSiteException(msg.toString());
	}

	/**
	 * Returns the first micro site in the ordered set where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching micro site, or <code>null</code> if a matching micro site could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MicroSite fetchByCompanyUser_First(long companyId, long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<MicroSite> list = findByCompanyUser(companyId, userId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last micro site in the ordered set where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching micro site
	 * @throws com.rivetlogic.microsite.NoSuchMicroSiteException if a matching micro site could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MicroSite findByCompanyUser_Last(long companyId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchMicroSiteException, SystemException {
		MicroSite microSite = fetchByCompanyUser_Last(companyId, userId,
				orderByComparator);

		if (microSite != null) {
			return microSite;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMicroSiteException(msg.toString());
	}

	/**
	 * Returns the last micro site in the ordered set where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching micro site, or <code>null</code> if a matching micro site could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MicroSite fetchByCompanyUser_Last(long companyId, long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyUser(companyId, userId);

		if (count == 0) {
			return null;
		}

		List<MicroSite> list = findByCompanyUser(companyId, userId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the micro sites before and after the current micro site in the ordered set where companyId = &#63; and userId = &#63;.
	 *
	 * @param microSiteId the primary key of the current micro site
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next micro site
	 * @throws com.rivetlogic.microsite.NoSuchMicroSiteException if a micro site with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MicroSite[] findByCompanyUser_PrevAndNext(long microSiteId,
		long companyId, long userId, OrderByComparator orderByComparator)
		throws NoSuchMicroSiteException, SystemException {
		MicroSite microSite = findByPrimaryKey(microSiteId);

		Session session = null;

		try {
			session = openSession();

			MicroSite[] array = new MicroSiteImpl[3];

			array[0] = getByCompanyUser_PrevAndNext(session, microSite,
					companyId, userId, orderByComparator, true);

			array[1] = microSite;

			array[2] = getByCompanyUser_PrevAndNext(session, microSite,
					companyId, userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MicroSite getByCompanyUser_PrevAndNext(Session session,
		MicroSite microSite, long companyId, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MICROSITE_WHERE);

		query.append(_FINDER_COLUMN_COMPANYUSER_COMPANYID_2);

		query.append(_FINDER_COLUMN_COMPANYUSER_USERID_2);

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
			query.append(MicroSiteModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(microSite);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MicroSite> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the micro sites where companyId = &#63; and userId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompanyUser(long companyId, long userId)
		throws SystemException {
		for (MicroSite microSite : findByCompanyUser(companyId, userId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(microSite);
		}
	}

	/**
	 * Returns the number of micro sites where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @return the number of matching micro sites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCompanyUser(long companyId, long userId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYUSER;

		Object[] finderArgs = new Object[] { companyId, userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MICROSITE_WHERE);

			query.append(_FINDER_COLUMN_COMPANYUSER_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYUSER_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_COMPANYUSER_COMPANYID_2 = "microSite.companyId = ? AND ";
	private static final String _FINDER_COLUMN_COMPANYUSER_USERID_2 = "microSite.userId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_COMPANYGROUPUSER = new FinderPath(MicroSiteModelImpl.ENTITY_CACHE_ENABLED,
			MicroSiteModelImpl.FINDER_CACHE_ENABLED, MicroSiteImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCompanyGroupUser",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			MicroSiteModelImpl.COMPANYID_COLUMN_BITMASK |
			MicroSiteModelImpl.GROUPID_COLUMN_BITMASK |
			MicroSiteModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYGROUPUSER = new FinderPath(MicroSiteModelImpl.ENTITY_CACHE_ENABLED,
			MicroSiteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCompanyGroupUser",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns the micro site where companyId = &#63; and groupId = &#63; and userId = &#63; or throws a {@link com.rivetlogic.microsite.NoSuchMicroSiteException} if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching micro site
	 * @throws com.rivetlogic.microsite.NoSuchMicroSiteException if a matching micro site could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MicroSite findByCompanyGroupUser(long companyId, long groupId,
		long userId) throws NoSuchMicroSiteException, SystemException {
		MicroSite microSite = fetchByCompanyGroupUser(companyId, groupId, userId);

		if (microSite == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(", userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchMicroSiteException(msg.toString());
		}

		return microSite;
	}

	/**
	 * Returns the micro site where companyId = &#63; and groupId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching micro site, or <code>null</code> if a matching micro site could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MicroSite fetchByCompanyGroupUser(long companyId, long groupId,
		long userId) throws SystemException {
		return fetchByCompanyGroupUser(companyId, groupId, userId, true);
	}

	/**
	 * Returns the micro site where companyId = &#63; and groupId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching micro site, or <code>null</code> if a matching micro site could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MicroSite fetchByCompanyGroupUser(long companyId, long groupId,
		long userId, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { companyId, groupId, userId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_COMPANYGROUPUSER,
					finderArgs, this);
		}

		if (result instanceof MicroSite) {
			MicroSite microSite = (MicroSite)result;

			if ((companyId != microSite.getCompanyId()) ||
					(groupId != microSite.getGroupId()) ||
					(userId != microSite.getUserId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_MICROSITE_WHERE);

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

				List<MicroSite> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COMPANYGROUPUSER,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"MicroSitePersistenceImpl.fetchByCompanyGroupUser(long, long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					MicroSite microSite = list.get(0);

					result = microSite;

					cacheResult(microSite);

					if ((microSite.getCompanyId() != companyId) ||
							(microSite.getGroupId() != groupId) ||
							(microSite.getUserId() != userId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COMPANYGROUPUSER,
							finderArgs, microSite);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COMPANYGROUPUSER,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (MicroSite)result;
		}
	}

	/**
	 * Removes the micro site where companyId = &#63; and groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the micro site that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MicroSite removeByCompanyGroupUser(long companyId, long groupId,
		long userId) throws NoSuchMicroSiteException, SystemException {
		MicroSite microSite = findByCompanyGroupUser(companyId, groupId, userId);

		return remove(microSite);
	}

	/**
	 * Returns the number of micro sites where companyId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching micro sites
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

			query.append(_SQL_COUNT_MICROSITE_WHERE);

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

	private static final String _FINDER_COLUMN_COMPANYGROUPUSER_COMPANYID_2 = "microSite.companyId = ? AND ";
	private static final String _FINDER_COLUMN_COMPANYGROUPUSER_GROUPID_2 = "microSite.groupId = ? AND ";
	private static final String _FINDER_COLUMN_COMPANYGROUPUSER_USERID_2 = "microSite.userId = ?";

	public MicroSitePersistenceImpl() {
		setModelClass(MicroSite.class);
	}

	/**
	 * Caches the micro site in the entity cache if it is enabled.
	 *
	 * @param microSite the micro site
	 */
	@Override
	public void cacheResult(MicroSite microSite) {
		EntityCacheUtil.putResult(MicroSiteModelImpl.ENTITY_CACHE_ENABLED,
			MicroSiteImpl.class, microSite.getPrimaryKey(), microSite);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID,
			new Object[] { microSite.getGroupId() }, microSite);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COMPANYGROUPUSER,
			new Object[] {
				microSite.getCompanyId(), microSite.getGroupId(),
				microSite.getUserId()
			}, microSite);

		microSite.resetOriginalValues();
	}

	/**
	 * Caches the micro sites in the entity cache if it is enabled.
	 *
	 * @param microSites the micro sites
	 */
	@Override
	public void cacheResult(List<MicroSite> microSites) {
		for (MicroSite microSite : microSites) {
			if (EntityCacheUtil.getResult(
						MicroSiteModelImpl.ENTITY_CACHE_ENABLED,
						MicroSiteImpl.class, microSite.getPrimaryKey()) == null) {
				cacheResult(microSite);
			}
			else {
				microSite.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all micro sites.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MicroSiteImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MicroSiteImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the micro site.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MicroSite microSite) {
		EntityCacheUtil.removeResult(MicroSiteModelImpl.ENTITY_CACHE_ENABLED,
			MicroSiteImpl.class, microSite.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(microSite);
	}

	@Override
	public void clearCache(List<MicroSite> microSites) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MicroSite microSite : microSites) {
			EntityCacheUtil.removeResult(MicroSiteModelImpl.ENTITY_CACHE_ENABLED,
				MicroSiteImpl.class, microSite.getPrimaryKey());

			clearUniqueFindersCache(microSite);
		}
	}

	protected void cacheUniqueFindersCache(MicroSite microSite) {
		if (microSite.isNew()) {
			Object[] args = new Object[] { microSite.getGroupId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID, args,
				microSite);

			args = new Object[] {
					microSite.getCompanyId(), microSite.getGroupId(),
					microSite.getUserId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPANYGROUPUSER,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COMPANYGROUPUSER,
				args, microSite);
		}
		else {
			MicroSiteModelImpl microSiteModelImpl = (MicroSiteModelImpl)microSite;

			if ((microSiteModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { microSite.getGroupId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID, args,
					microSite);
			}

			if ((microSiteModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_COMPANYGROUPUSER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						microSite.getCompanyId(), microSite.getGroupId(),
						microSite.getUserId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPANYGROUPUSER,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COMPANYGROUPUSER,
					args, microSite);
			}
		}
	}

	protected void clearUniqueFindersCache(MicroSite microSite) {
		MicroSiteModelImpl microSiteModelImpl = (MicroSiteModelImpl)microSite;

		Object[] args = new Object[] { microSite.getGroupId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GROUPID, args);

		if ((microSiteModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_GROUPID.getColumnBitmask()) != 0) {
			args = new Object[] { microSiteModelImpl.getOriginalGroupId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GROUPID, args);
		}

		args = new Object[] {
				microSite.getCompanyId(), microSite.getGroupId(),
				microSite.getUserId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYGROUPUSER, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COMPANYGROUPUSER, args);

		if ((microSiteModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_COMPANYGROUPUSER.getColumnBitmask()) != 0) {
			args = new Object[] {
					microSiteModelImpl.getOriginalCompanyId(),
					microSiteModelImpl.getOriginalGroupId(),
					microSiteModelImpl.getOriginalUserId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYGROUPUSER,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COMPANYGROUPUSER,
				args);
		}
	}

	/**
	 * Creates a new micro site with the primary key. Does not add the micro site to the database.
	 *
	 * @param microSiteId the primary key for the new micro site
	 * @return the new micro site
	 */
	@Override
	public MicroSite create(long microSiteId) {
		MicroSite microSite = new MicroSiteImpl();

		microSite.setNew(true);
		microSite.setPrimaryKey(microSiteId);

		return microSite;
	}

	/**
	 * Removes the micro site with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param microSiteId the primary key of the micro site
	 * @return the micro site that was removed
	 * @throws com.rivetlogic.microsite.NoSuchMicroSiteException if a micro site with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MicroSite remove(long microSiteId)
		throws NoSuchMicroSiteException, SystemException {
		return remove((Serializable)microSiteId);
	}

	/**
	 * Removes the micro site with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the micro site
	 * @return the micro site that was removed
	 * @throws com.rivetlogic.microsite.NoSuchMicroSiteException if a micro site with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MicroSite remove(Serializable primaryKey)
		throws NoSuchMicroSiteException, SystemException {
		Session session = null;

		try {
			session = openSession();

			MicroSite microSite = (MicroSite)session.get(MicroSiteImpl.class,
					primaryKey);

			if (microSite == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMicroSiteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(microSite);
		}
		catch (NoSuchMicroSiteException nsee) {
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
	protected MicroSite removeImpl(MicroSite microSite)
		throws SystemException {
		microSite = toUnwrappedModel(microSite);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(microSite)) {
				microSite = (MicroSite)session.get(MicroSiteImpl.class,
						microSite.getPrimaryKeyObj());
			}

			if (microSite != null) {
				session.delete(microSite);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (microSite != null) {
			clearCache(microSite);
		}

		return microSite;
	}

	@Override
	public MicroSite updateImpl(
		com.rivetlogic.microsite.model.MicroSite microSite)
		throws SystemException {
		microSite = toUnwrappedModel(microSite);

		boolean isNew = microSite.isNew();

		MicroSiteModelImpl microSiteModelImpl = (MicroSiteModelImpl)microSite;

		Session session = null;

		try {
			session = openSession();

			if (microSite.isNew()) {
				session.save(microSite);

				microSite.setNew(false);
			}
			else {
				session.merge(microSite);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !MicroSiteModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((microSiteModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYUSER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						microSiteModelImpl.getOriginalCompanyId(),
						microSiteModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYUSER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYUSER,
					args);

				args = new Object[] {
						microSiteModelImpl.getCompanyId(),
						microSiteModelImpl.getUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYUSER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYUSER,
					args);
			}
		}

		EntityCacheUtil.putResult(MicroSiteModelImpl.ENTITY_CACHE_ENABLED,
			MicroSiteImpl.class, microSite.getPrimaryKey(), microSite);

		clearUniqueFindersCache(microSite);
		cacheUniqueFindersCache(microSite);

		return microSite;
	}

	protected MicroSite toUnwrappedModel(MicroSite microSite) {
		if (microSite instanceof MicroSiteImpl) {
			return microSite;
		}

		MicroSiteImpl microSiteImpl = new MicroSiteImpl();

		microSiteImpl.setNew(microSite.isNew());
		microSiteImpl.setPrimaryKey(microSite.getPrimaryKey());

		microSiteImpl.setMicroSiteId(microSite.getMicroSiteId());
		microSiteImpl.setCompanyId(microSite.getCompanyId());
		microSiteImpl.setUserId(microSite.getUserId());
		microSiteImpl.setUserName(microSite.getUserName());
		microSiteImpl.setCreateDate(microSite.getCreateDate());
		microSiteImpl.setModifiedDate(microSite.getModifiedDate());
		microSiteImpl.setGroupId(microSite.getGroupId());
		microSiteImpl.setSiteId(microSite.getSiteId());

		return microSiteImpl;
	}

	/**
	 * Returns the micro site with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the micro site
	 * @return the micro site
	 * @throws com.rivetlogic.microsite.NoSuchMicroSiteException if a micro site with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MicroSite findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMicroSiteException, SystemException {
		MicroSite microSite = fetchByPrimaryKey(primaryKey);

		if (microSite == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMicroSiteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return microSite;
	}

	/**
	 * Returns the micro site with the primary key or throws a {@link com.rivetlogic.microsite.NoSuchMicroSiteException} if it could not be found.
	 *
	 * @param microSiteId the primary key of the micro site
	 * @return the micro site
	 * @throws com.rivetlogic.microsite.NoSuchMicroSiteException if a micro site with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MicroSite findByPrimaryKey(long microSiteId)
		throws NoSuchMicroSiteException, SystemException {
		return findByPrimaryKey((Serializable)microSiteId);
	}

	/**
	 * Returns the micro site with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the micro site
	 * @return the micro site, or <code>null</code> if a micro site with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MicroSite fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		MicroSite microSite = (MicroSite)EntityCacheUtil.getResult(MicroSiteModelImpl.ENTITY_CACHE_ENABLED,
				MicroSiteImpl.class, primaryKey);

		if (microSite == _nullMicroSite) {
			return null;
		}

		if (microSite == null) {
			Session session = null;

			try {
				session = openSession();

				microSite = (MicroSite)session.get(MicroSiteImpl.class,
						primaryKey);

				if (microSite != null) {
					cacheResult(microSite);
				}
				else {
					EntityCacheUtil.putResult(MicroSiteModelImpl.ENTITY_CACHE_ENABLED,
						MicroSiteImpl.class, primaryKey, _nullMicroSite);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(MicroSiteModelImpl.ENTITY_CACHE_ENABLED,
					MicroSiteImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return microSite;
	}

	/**
	 * Returns the micro site with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param microSiteId the primary key of the micro site
	 * @return the micro site, or <code>null</code> if a micro site with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MicroSite fetchByPrimaryKey(long microSiteId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)microSiteId);
	}

	/**
	 * Returns all the micro sites.
	 *
	 * @return the micro sites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MicroSite> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the micro sites.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.microsite.model.impl.MicroSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of micro sites
	 * @param end the upper bound of the range of micro sites (not inclusive)
	 * @return the range of micro sites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MicroSite> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the micro sites.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.microsite.model.impl.MicroSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of micro sites
	 * @param end the upper bound of the range of micro sites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of micro sites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MicroSite> findAll(int start, int end,
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

		List<MicroSite> list = (List<MicroSite>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MICROSITE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MICROSITE;

				if (pagination) {
					sql = sql.concat(MicroSiteModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<MicroSite>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MicroSite>(list);
				}
				else {
					list = (List<MicroSite>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the micro sites from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (MicroSite microSite : findAll()) {
			remove(microSite);
		}
	}

	/**
	 * Returns the number of micro sites.
	 *
	 * @return the number of micro sites
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

				Query q = session.createQuery(_SQL_COUNT_MICROSITE);

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
	 * Initializes the micro site persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rivetlogic.microsite.model.MicroSite")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<MicroSite>> listenersList = new ArrayList<ModelListener<MicroSite>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<MicroSite>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(MicroSiteImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_MICROSITE = "SELECT microSite FROM MicroSite microSite";
	private static final String _SQL_SELECT_MICROSITE_WHERE = "SELECT microSite FROM MicroSite microSite WHERE ";
	private static final String _SQL_COUNT_MICROSITE = "SELECT COUNT(microSite) FROM MicroSite microSite";
	private static final String _SQL_COUNT_MICROSITE_WHERE = "SELECT COUNT(microSite) FROM MicroSite microSite WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "microSite.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MicroSite exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No MicroSite exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MicroSitePersistenceImpl.class);
	private static MicroSite _nullMicroSite = new MicroSiteImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<MicroSite> toCacheModel() {
				return _nullMicroSiteCacheModel;
			}
		};

	private static CacheModel<MicroSite> _nullMicroSiteCacheModel = new CacheModel<MicroSite>() {
			@Override
			public MicroSite toEntityModel() {
				return _nullMicroSite;
			}
		};
}