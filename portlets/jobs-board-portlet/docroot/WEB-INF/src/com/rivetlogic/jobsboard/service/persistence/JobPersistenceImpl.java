/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.rivetlogic.jobsboard.service.persistence;

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
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.rivetlogic.jobsboard.NoSuchJobException;
import com.rivetlogic.jobsboard.model.Job;
import com.rivetlogic.jobsboard.model.impl.JobImpl;
import com.rivetlogic.jobsboard.model.impl.JobModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the job service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author joseross
 * @see JobPersistence
 * @see JobUtil
 * @generated
 */
public class JobPersistenceImpl extends BasePersistenceImpl<Job>
	implements JobPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link JobUtil} to access the job persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = JobImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(JobModelImpl.ENTITY_CACHE_ENABLED,
			JobModelImpl.FINDER_CACHE_ENABLED, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(JobModelImpl.ENTITY_CACHE_ENABLED,
			JobModelImpl.FINDER_CACHE_ENABLED, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(JobModelImpl.ENTITY_CACHE_ENABLED,
			JobModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYGROUP =
		new FinderPath(JobModelImpl.ENTITY_CACHE_ENABLED,
			JobModelImpl.FINDER_CACHE_ENABLED, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP =
		new FinderPath(JobModelImpl.ENTITY_CACHE_ENABLED,
			JobModelImpl.FINDER_CACHE_ENABLED, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyGroup",
			new String[] { Long.class.getName(), Long.class.getName() },
			JobModelImpl.COMPANYID_COLUMN_BITMASK |
			JobModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYGROUP = new FinderPath(JobModelImpl.ENTITY_CACHE_ENABLED,
			JobModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyGroup",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the jobs where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Job> findByCompanyGroup(long companyId, long groupId)
		throws SystemException {
		return findByCompanyGroup(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the jobs where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.JobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @return the range of matching jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Job> findByCompanyGroup(long companyId, long groupId,
		int start, int end) throws SystemException {
		return findByCompanyGroup(companyId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the jobs where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.JobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Job> findByCompanyGroup(long companyId, long groupId,
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

		List<Job> list = (List<Job>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Job job : list) {
				if ((companyId != job.getCompanyId()) ||
						(groupId != job.getGroupId())) {
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

			query.append(_SQL_SELECT_JOB_WHERE);

			query.append(_FINDER_COLUMN_COMPANYGROUP_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYGROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(JobModelImpl.ORDER_BY_JPQL);
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
					list = (List<Job>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Job>(list);
				}
				else {
					list = (List<Job>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first job in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws com.rivetlogic.jobsboard.NoSuchJobException if a matching job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Job findByCompanyGroup_First(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchJobException, SystemException {
		Job job = fetchByCompanyGroup_First(companyId, groupId,
				orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchJobException(msg.toString());
	}

	/**
	 * Returns the first job in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Job fetchByCompanyGroup_First(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Job> list = findByCompanyGroup(companyId, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last job in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws com.rivetlogic.jobsboard.NoSuchJobException if a matching job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Job findByCompanyGroup_Last(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchJobException, SystemException {
		Job job = fetchByCompanyGroup_Last(companyId, groupId, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchJobException(msg.toString());
	}

	/**
	 * Returns the last job in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Job fetchByCompanyGroup_Last(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyGroup(companyId, groupId);

		if (count == 0) {
			return null;
		}

		List<Job> list = findByCompanyGroup(companyId, groupId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the jobs before and after the current job in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param jobId the primary key of the current job
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job
	 * @throws com.rivetlogic.jobsboard.NoSuchJobException if a job with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Job[] findByCompanyGroup_PrevAndNext(long jobId, long companyId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchJobException, SystemException {
		Job job = findByPrimaryKey(jobId);

		Session session = null;

		try {
			session = openSession();

			Job[] array = new JobImpl[3];

			array[0] = getByCompanyGroup_PrevAndNext(session, job, companyId,
					groupId, orderByComparator, true);

			array[1] = job;

			array[2] = getByCompanyGroup_PrevAndNext(session, job, companyId,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Job getByCompanyGroup_PrevAndNext(Session session, Job job,
		long companyId, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_JOB_WHERE);

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
			query.append(JobModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(job);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Job> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the jobs where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompanyGroup(long companyId, long groupId)
		throws SystemException {
		for (Job job : findByCompanyGroup(companyId, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(job);
		}
	}

	/**
	 * Returns the number of jobs where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching jobs
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

			query.append(_SQL_COUNT_JOB_WHERE);

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

	private static final String _FINDER_COLUMN_COMPANYGROUP_COMPANYID_2 = "job.companyId = ? AND ";
	private static final String _FINDER_COLUMN_COMPANYGROUP_GROUPID_2 = "job.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FILTERS = new FinderPath(JobModelImpl.ENTITY_CACHE_ENABLED,
			JobModelImpl.FINDER_CACHE_ENABLED, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFilters",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Boolean.class.getName(),
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_FILTERS = new FinderPath(JobModelImpl.ENTITY_CACHE_ENABLED,
			JobModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByFilters",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Boolean.class.getName(),
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the jobs where companyId = &#63; and groupId = &#63; and name LIKE &#63; and active = &#63; and category = &#63; and location = &#63; and type = &#63; and description LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param name the name
	 * @param active the active
	 * @param category the category
	 * @param location the location
	 * @param type the type
	 * @param description the description
	 * @return the matching jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Job> findByFilters(long companyId, long groupId, String name,
		boolean active, long category, long location, long type,
		String description) throws SystemException {
		return findByFilters(companyId, groupId, name, active, category,
			location, type, description, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the jobs where companyId = &#63; and groupId = &#63; and name LIKE &#63; and active = &#63; and category = &#63; and location = &#63; and type = &#63; and description LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.JobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param name the name
	 * @param active the active
	 * @param category the category
	 * @param location the location
	 * @param type the type
	 * @param description the description
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @return the range of matching jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Job> findByFilters(long companyId, long groupId, String name,
		boolean active, long category, long location, long type,
		String description, int start, int end) throws SystemException {
		return findByFilters(companyId, groupId, name, active, category,
			location, type, description, start, end, null);
	}

	/**
	 * Returns an ordered range of all the jobs where companyId = &#63; and groupId = &#63; and name LIKE &#63; and active = &#63; and category = &#63; and location = &#63; and type = &#63; and description LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.JobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param name the name
	 * @param active the active
	 * @param category the category
	 * @param location the location
	 * @param type the type
	 * @param description the description
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Job> findByFilters(long companyId, long groupId, String name,
		boolean active, long category, long location, long type,
		String description, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FILTERS;
		finderArgs = new Object[] {
				companyId, groupId, name, active, category, location, type,
				description,
				
				start, end, orderByComparator
			};

		List<Job> list = (List<Job>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Job job : list) {
				if ((companyId != job.getCompanyId()) ||
						(groupId != job.getGroupId()) ||
						!StringUtil.wildcardMatches(job.getName(), name,
							CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, false) ||
						(active != job.getActive()) ||
						(category != job.getCategory()) ||
						(location != job.getLocation()) ||
						(type != job.getType()) ||
						!StringUtil.wildcardMatches(job.getDescription(),
							description, CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, false)) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(10 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(10);
			}

			query.append(_SQL_SELECT_JOB_WHERE);

			query.append(_FINDER_COLUMN_FILTERS_COMPANYID_2);

			query.append(_FINDER_COLUMN_FILTERS_GROUPID_2);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_FILTERS_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FILTERS_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_FILTERS_NAME_2);
			}

			query.append(_FINDER_COLUMN_FILTERS_ACTIVE_2);

			query.append(_FINDER_COLUMN_FILTERS_CATEGORY_2);

			query.append(_FINDER_COLUMN_FILTERS_LOCATION_2);

			query.append(_FINDER_COLUMN_FILTERS_TYPE_2);

			boolean bindDescription = false;

			if (description == null) {
				query.append(_FINDER_COLUMN_FILTERS_DESCRIPTION_1);
			}
			else if (description.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FILTERS_DESCRIPTION_3);
			}
			else {
				bindDescription = true;

				query.append(_FINDER_COLUMN_FILTERS_DESCRIPTION_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(JobModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindName) {
					qPos.add(name.toLowerCase());
				}

				qPos.add(active);

				qPos.add(category);

				qPos.add(location);

				qPos.add(type);

				if (bindDescription) {
					qPos.add(description.toLowerCase());
				}

				if (!pagination) {
					list = (List<Job>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Job>(list);
				}
				else {
					list = (List<Job>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first job in the ordered set where companyId = &#63; and groupId = &#63; and name LIKE &#63; and active = &#63; and category = &#63; and location = &#63; and type = &#63; and description LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param name the name
	 * @param active the active
	 * @param category the category
	 * @param location the location
	 * @param type the type
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws com.rivetlogic.jobsboard.NoSuchJobException if a matching job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Job findByFilters_First(long companyId, long groupId, String name,
		boolean active, long category, long location, long type,
		String description, OrderByComparator orderByComparator)
		throws NoSuchJobException, SystemException {
		Job job = fetchByFilters_First(companyId, groupId, name, active,
				category, location, type, description, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(18);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", name=");
		msg.append(name);

		msg.append(", active=");
		msg.append(active);

		msg.append(", category=");
		msg.append(category);

		msg.append(", location=");
		msg.append(location);

		msg.append(", type=");
		msg.append(type);

		msg.append(", description=");
		msg.append(description);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchJobException(msg.toString());
	}

	/**
	 * Returns the first job in the ordered set where companyId = &#63; and groupId = &#63; and name LIKE &#63; and active = &#63; and category = &#63; and location = &#63; and type = &#63; and description LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param name the name
	 * @param active the active
	 * @param category the category
	 * @param location the location
	 * @param type the type
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Job fetchByFilters_First(long companyId, long groupId, String name,
		boolean active, long category, long location, long type,
		String description, OrderByComparator orderByComparator)
		throws SystemException {
		List<Job> list = findByFilters(companyId, groupId, name, active,
				category, location, type, description, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last job in the ordered set where companyId = &#63; and groupId = &#63; and name LIKE &#63; and active = &#63; and category = &#63; and location = &#63; and type = &#63; and description LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param name the name
	 * @param active the active
	 * @param category the category
	 * @param location the location
	 * @param type the type
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws com.rivetlogic.jobsboard.NoSuchJobException if a matching job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Job findByFilters_Last(long companyId, long groupId, String name,
		boolean active, long category, long location, long type,
		String description, OrderByComparator orderByComparator)
		throws NoSuchJobException, SystemException {
		Job job = fetchByFilters_Last(companyId, groupId, name, active,
				category, location, type, description, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(18);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", name=");
		msg.append(name);

		msg.append(", active=");
		msg.append(active);

		msg.append(", category=");
		msg.append(category);

		msg.append(", location=");
		msg.append(location);

		msg.append(", type=");
		msg.append(type);

		msg.append(", description=");
		msg.append(description);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchJobException(msg.toString());
	}

	/**
	 * Returns the last job in the ordered set where companyId = &#63; and groupId = &#63; and name LIKE &#63; and active = &#63; and category = &#63; and location = &#63; and type = &#63; and description LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param name the name
	 * @param active the active
	 * @param category the category
	 * @param location the location
	 * @param type the type
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Job fetchByFilters_Last(long companyId, long groupId, String name,
		boolean active, long category, long location, long type,
		String description, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByFilters(companyId, groupId, name, active, category,
				location, type, description);

		if (count == 0) {
			return null;
		}

		List<Job> list = findByFilters(companyId, groupId, name, active,
				category, location, type, description, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the jobs before and after the current job in the ordered set where companyId = &#63; and groupId = &#63; and name LIKE &#63; and active = &#63; and category = &#63; and location = &#63; and type = &#63; and description LIKE &#63;.
	 *
	 * @param jobId the primary key of the current job
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param name the name
	 * @param active the active
	 * @param category the category
	 * @param location the location
	 * @param type the type
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job
	 * @throws com.rivetlogic.jobsboard.NoSuchJobException if a job with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Job[] findByFilters_PrevAndNext(long jobId, long companyId,
		long groupId, String name, boolean active, long category,
		long location, long type, String description,
		OrderByComparator orderByComparator)
		throws NoSuchJobException, SystemException {
		Job job = findByPrimaryKey(jobId);

		Session session = null;

		try {
			session = openSession();

			Job[] array = new JobImpl[3];

			array[0] = getByFilters_PrevAndNext(session, job, companyId,
					groupId, name, active, category, location, type,
					description, orderByComparator, true);

			array[1] = job;

			array[2] = getByFilters_PrevAndNext(session, job, companyId,
					groupId, name, active, category, location, type,
					description, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Job getByFilters_PrevAndNext(Session session, Job job,
		long companyId, long groupId, String name, boolean active,
		long category, long location, long type, String description,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_JOB_WHERE);

		query.append(_FINDER_COLUMN_FILTERS_COMPANYID_2);

		query.append(_FINDER_COLUMN_FILTERS_GROUPID_2);

		boolean bindName = false;

		if (name == null) {
			query.append(_FINDER_COLUMN_FILTERS_NAME_1);
		}
		else if (name.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_FILTERS_NAME_3);
		}
		else {
			bindName = true;

			query.append(_FINDER_COLUMN_FILTERS_NAME_2);
		}

		query.append(_FINDER_COLUMN_FILTERS_ACTIVE_2);

		query.append(_FINDER_COLUMN_FILTERS_CATEGORY_2);

		query.append(_FINDER_COLUMN_FILTERS_LOCATION_2);

		query.append(_FINDER_COLUMN_FILTERS_TYPE_2);

		boolean bindDescription = false;

		if (description == null) {
			query.append(_FINDER_COLUMN_FILTERS_DESCRIPTION_1);
		}
		else if (description.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_FILTERS_DESCRIPTION_3);
		}
		else {
			bindDescription = true;

			query.append(_FINDER_COLUMN_FILTERS_DESCRIPTION_2);
		}

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
			query.append(JobModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (bindName) {
			qPos.add(name.toLowerCase());
		}

		qPos.add(active);

		qPos.add(category);

		qPos.add(location);

		qPos.add(type);

		if (bindDescription) {
			qPos.add(description.toLowerCase());
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(job);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Job> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the jobs where companyId = &#63; and groupId = &#63; and name LIKE all &#63; and active = any &#63; and category = any &#63; and location = any &#63; and type = any &#63; and description LIKE all &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.JobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param names the names
	 * @param actives the actives
	 * @param categories the categories
	 * @param locations the locations
	 * @param types the types
	 * @param descriptions the descriptions
	 * @return the matching jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Job> findByFilters(long companyId, long groupId,
		String[] names, boolean[] actives, long[] categories, long[] locations,
		long[] types, String[] descriptions) throws SystemException {
		return findByFilters(companyId, groupId, names, actives, categories,
			locations, types, descriptions, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the jobs where companyId = &#63; and groupId = &#63; and name LIKE all &#63; and active = any &#63; and category = any &#63; and location = any &#63; and type = any &#63; and description LIKE all &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.JobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param names the names
	 * @param actives the actives
	 * @param categories the categories
	 * @param locations the locations
	 * @param types the types
	 * @param descriptions the descriptions
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @return the range of matching jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Job> findByFilters(long companyId, long groupId,
		String[] names, boolean[] actives, long[] categories, long[] locations,
		long[] types, String[] descriptions, int start, int end)
		throws SystemException {
		return findByFilters(companyId, groupId, names, actives, categories,
			locations, types, descriptions, start, end, null);
	}

	/**
	 * Returns an ordered range of all the jobs where companyId = &#63; and groupId = &#63; and name LIKE all &#63; and active = any &#63; and category = any &#63; and location = any &#63; and type = any &#63; and description LIKE all &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.JobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param names the names
	 * @param actives the actives
	 * @param categories the categories
	 * @param locations the locations
	 * @param types the types
	 * @param descriptions the descriptions
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Job> findByFilters(long companyId, long groupId,
		String[] names, boolean[] actives, long[] categories, long[] locations,
		long[] types, String[] descriptions, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if ((names != null) && (names.length == 1) && (actives != null) &&
				(actives.length == 1) && (categories != null) &&
				(categories.length == 1) && (locations != null) &&
				(locations.length == 1) && (types != null) &&
				(types.length == 1) && (descriptions != null) &&
				(descriptions.length == 1)) {
			return findByFilters(companyId, groupId, names[0], actives[0],
				categories[0], locations[0], types[0], descriptions[0], start,
				end, orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] {
					companyId, groupId, StringUtil.merge(names),
					StringUtil.merge(actives), StringUtil.merge(categories),
					StringUtil.merge(locations), StringUtil.merge(types),
					StringUtil.merge(descriptions)
				};
		}
		else {
			finderArgs = new Object[] {
					companyId, groupId, StringUtil.merge(names),
					StringUtil.merge(actives), StringUtil.merge(categories),
					StringUtil.merge(locations), StringUtil.merge(types),
					StringUtil.merge(descriptions),
					
					start, end, orderByComparator
				};
		}

		List<Job> list = (List<Job>)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_FILTERS,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Job job : list) {
				if ((companyId != job.getCompanyId()) ||
						(groupId != job.getGroupId()) ||
						!ArrayUtil.contains(names, job.getName()) ||
						!ArrayUtil.contains(actives, job.getActive()) ||
						!ArrayUtil.contains(categories, job.getCategory()) ||
						!ArrayUtil.contains(locations, job.getLocation()) ||
						!ArrayUtil.contains(types, job.getType()) ||
						!ArrayUtil.contains(descriptions, job.getDescription())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_JOB_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_FILTERS_COMPANYID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_FILTERS_GROUPID_5);

			conjunctionable = true;

			if ((names == null) || (names.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < names.length; i++) {
					String name = names[i];

					if (name == null) {
						query.append(_FINDER_COLUMN_FILTERS_NAME_4);
					}
					else if (name.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_FILTERS_NAME_6);
					}
					else {
						query.append(_FINDER_COLUMN_FILTERS_NAME_5);
					}

					if ((i + 1) < names.length) {
						query.append(WHERE_AND);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if ((actives == null) || (actives.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < actives.length; i++) {
					query.append(_FINDER_COLUMN_FILTERS_ACTIVE_5);

					if ((i + 1) < actives.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if ((categories == null) || (categories.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < categories.length; i++) {
					query.append(_FINDER_COLUMN_FILTERS_CATEGORY_5);

					if ((i + 1) < categories.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if ((locations == null) || (locations.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < locations.length; i++) {
					query.append(_FINDER_COLUMN_FILTERS_LOCATION_5);

					if ((i + 1) < locations.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if ((types == null) || (types.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < types.length; i++) {
					query.append(_FINDER_COLUMN_FILTERS_TYPE_5);

					if ((i + 1) < types.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if ((descriptions == null) || (descriptions.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < descriptions.length; i++) {
					String description = descriptions[i];

					if (description == null) {
						query.append(_FINDER_COLUMN_FILTERS_DESCRIPTION_4);
					}
					else if (description.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_FILTERS_DESCRIPTION_6);
					}
					else {
						query.append(_FINDER_COLUMN_FILTERS_DESCRIPTION_5);
					}

					if ((i + 1) < descriptions.length) {
						query.append(WHERE_AND);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(JobModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (names != null) {
					qPos.add(names);
				}

				if (actives != null) {
					qPos.add(actives);
				}

				if (categories != null) {
					qPos.add(categories);
				}

				if (locations != null) {
					qPos.add(locations);
				}

				if (types != null) {
					qPos.add(types);
				}

				if (descriptions != null) {
					qPos.add(descriptions);
				}

				if (!pagination) {
					list = (List<Job>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Job>(list);
				}
				else {
					list = (List<Job>)QueryUtil.list(q, getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_FILTERS,
					finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_FILTERS,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the jobs where companyId = &#63; and groupId = &#63; and name LIKE &#63; and active = &#63; and category = &#63; and location = &#63; and type = &#63; and description LIKE &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param name the name
	 * @param active the active
	 * @param category the category
	 * @param location the location
	 * @param type the type
	 * @param description the description
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByFilters(long companyId, long groupId, String name,
		boolean active, long category, long location, long type,
		String description) throws SystemException {
		for (Job job : findByFilters(companyId, groupId, name, active,
				category, location, type, description, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(job);
		}
	}

	/**
	 * Returns the number of jobs where companyId = &#63; and groupId = &#63; and name LIKE &#63; and active = &#63; and category = &#63; and location = &#63; and type = &#63; and description LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param name the name
	 * @param active the active
	 * @param category the category
	 * @param location the location
	 * @param type the type
	 * @param description the description
	 * @return the number of matching jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByFilters(long companyId, long groupId, String name,
		boolean active, long category, long location, long type,
		String description) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_FILTERS;

		Object[] finderArgs = new Object[] {
				companyId, groupId, name, active, category, location, type,
				description
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(9);

			query.append(_SQL_COUNT_JOB_WHERE);

			query.append(_FINDER_COLUMN_FILTERS_COMPANYID_2);

			query.append(_FINDER_COLUMN_FILTERS_GROUPID_2);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_FILTERS_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FILTERS_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_FILTERS_NAME_2);
			}

			query.append(_FINDER_COLUMN_FILTERS_ACTIVE_2);

			query.append(_FINDER_COLUMN_FILTERS_CATEGORY_2);

			query.append(_FINDER_COLUMN_FILTERS_LOCATION_2);

			query.append(_FINDER_COLUMN_FILTERS_TYPE_2);

			boolean bindDescription = false;

			if (description == null) {
				query.append(_FINDER_COLUMN_FILTERS_DESCRIPTION_1);
			}
			else if (description.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FILTERS_DESCRIPTION_3);
			}
			else {
				bindDescription = true;

				query.append(_FINDER_COLUMN_FILTERS_DESCRIPTION_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindName) {
					qPos.add(name.toLowerCase());
				}

				qPos.add(active);

				qPos.add(category);

				qPos.add(location);

				qPos.add(type);

				if (bindDescription) {
					qPos.add(description.toLowerCase());
				}

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

	/**
	 * Returns the number of jobs where companyId = &#63; and groupId = &#63; and name LIKE all &#63; and active = any &#63; and category = any &#63; and location = any &#63; and type = any &#63; and description LIKE all &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param names the names
	 * @param actives the actives
	 * @param categories the categories
	 * @param locations the locations
	 * @param types the types
	 * @param descriptions the descriptions
	 * @return the number of matching jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByFilters(long companyId, long groupId, String[] names,
		boolean[] actives, long[] categories, long[] locations, long[] types,
		String[] descriptions) throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId, groupId, StringUtil.merge(names),
				StringUtil.merge(actives), StringUtil.merge(categories),
				StringUtil.merge(locations), StringUtil.merge(types),
				StringUtil.merge(descriptions)
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_FILTERS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_JOB_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_FILTERS_COMPANYID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_FILTERS_GROUPID_5);

			conjunctionable = true;

			if ((names == null) || (names.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < names.length; i++) {
					String name = names[i];

					if (name == null) {
						query.append(_FINDER_COLUMN_FILTERS_NAME_4);
					}
					else if (name.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_FILTERS_NAME_6);
					}
					else {
						query.append(_FINDER_COLUMN_FILTERS_NAME_5);
					}

					if ((i + 1) < names.length) {
						query.append(WHERE_AND);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if ((actives == null) || (actives.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < actives.length; i++) {
					query.append(_FINDER_COLUMN_FILTERS_ACTIVE_5);

					if ((i + 1) < actives.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if ((categories == null) || (categories.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < categories.length; i++) {
					query.append(_FINDER_COLUMN_FILTERS_CATEGORY_5);

					if ((i + 1) < categories.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if ((locations == null) || (locations.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < locations.length; i++) {
					query.append(_FINDER_COLUMN_FILTERS_LOCATION_5);

					if ((i + 1) < locations.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if ((types == null) || (types.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < types.length; i++) {
					query.append(_FINDER_COLUMN_FILTERS_TYPE_5);

					if ((i + 1) < types.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if ((descriptions == null) || (descriptions.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < descriptions.length; i++) {
					String description = descriptions[i];

					if (description == null) {
						query.append(_FINDER_COLUMN_FILTERS_DESCRIPTION_4);
					}
					else if (description.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_FILTERS_DESCRIPTION_6);
					}
					else {
						query.append(_FINDER_COLUMN_FILTERS_DESCRIPTION_5);
					}

					if ((i + 1) < descriptions.length) {
						query.append(WHERE_AND);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (names != null) {
					qPos.add(names);
				}

				if (actives != null) {
					qPos.add(actives);
				}

				if (categories != null) {
					qPos.add(categories);
				}

				if (locations != null) {
					qPos.add(locations);
				}

				if (types != null) {
					qPos.add(types);
				}

				if (descriptions != null) {
					qPos.add(descriptions);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_FILTERS,
					finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_FILTERS,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_FILTERS_COMPANYID_2 = "job.companyId = ? AND ";
	private static final String _FINDER_COLUMN_FILTERS_COMPANYID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_FILTERS_COMPANYID_2) + ")";
	private static final String _FINDER_COLUMN_FILTERS_GROUPID_2 = "job.groupId = ? AND ";
	private static final String _FINDER_COLUMN_FILTERS_GROUPID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_FILTERS_GROUPID_2) + ")";
	private static final String _FINDER_COLUMN_FILTERS_NAME_1 = "job.name LIKE NULL AND ";
	private static final String _FINDER_COLUMN_FILTERS_NAME_2 = "lower(job.name) LIKE ? AND ";
	private static final String _FINDER_COLUMN_FILTERS_NAME_3 = "(job.name IS NULL OR job.name LIKE '') AND ";
	private static final String _FINDER_COLUMN_FILTERS_NAME_4 = "(" +
		removeConjunction(_FINDER_COLUMN_FILTERS_NAME_1) + ")";
	private static final String _FINDER_COLUMN_FILTERS_NAME_5 = "(" +
		removeConjunction(_FINDER_COLUMN_FILTERS_NAME_2) + ")";
	private static final String _FINDER_COLUMN_FILTERS_NAME_6 = "(" +
		removeConjunction(_FINDER_COLUMN_FILTERS_NAME_3) + ")";
	private static final String _FINDER_COLUMN_FILTERS_ACTIVE_2 = "job.active = ? AND ";
	private static final String _FINDER_COLUMN_FILTERS_ACTIVE_5 = "(" +
		removeConjunction(_FINDER_COLUMN_FILTERS_ACTIVE_2) + ")";
	private static final String _FINDER_COLUMN_FILTERS_CATEGORY_2 = "job.category = ? AND ";
	private static final String _FINDER_COLUMN_FILTERS_CATEGORY_5 = "(" +
		removeConjunction(_FINDER_COLUMN_FILTERS_CATEGORY_2) + ")";
	private static final String _FINDER_COLUMN_FILTERS_LOCATION_2 = "job.location = ? AND ";
	private static final String _FINDER_COLUMN_FILTERS_LOCATION_5 = "(" +
		removeConjunction(_FINDER_COLUMN_FILTERS_LOCATION_2) + ")";
	private static final String _FINDER_COLUMN_FILTERS_TYPE_2 = "job.type = ? AND ";
	private static final String _FINDER_COLUMN_FILTERS_TYPE_5 = "(" +
		removeConjunction(_FINDER_COLUMN_FILTERS_TYPE_2) + ")";
	private static final String _FINDER_COLUMN_FILTERS_DESCRIPTION_1 = "job.description LIKE NULL";
	private static final String _FINDER_COLUMN_FILTERS_DESCRIPTION_2 = "lower(job.description) LIKE ?";
	private static final String _FINDER_COLUMN_FILTERS_DESCRIPTION_3 = "(job.description IS NULL OR job.description LIKE '')";
	private static final String _FINDER_COLUMN_FILTERS_DESCRIPTION_4 = "(" +
		removeConjunction(_FINDER_COLUMN_FILTERS_DESCRIPTION_1) + ")";
	private static final String _FINDER_COLUMN_FILTERS_DESCRIPTION_5 = "(" +
		removeConjunction(_FINDER_COLUMN_FILTERS_DESCRIPTION_2) + ")";
	private static final String _FINDER_COLUMN_FILTERS_DESCRIPTION_6 = "(" +
		removeConjunction(_FINDER_COLUMN_FILTERS_DESCRIPTION_3) + ")";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BOOKMARKS =
		new FinderPath(JobModelImpl.ENTITY_CACHE_ENABLED,
			JobModelImpl.FINDER_CACHE_ENABLED, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByBookmarks",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Boolean.class.getName(),
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_BOOKMARKS =
		new FinderPath(JobModelImpl.ENTITY_CACHE_ENABLED,
			JobModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByBookmarks",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Boolean.class.getName(),
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				String.class.getName(), String.class.getName()
			});

	/**
	 * Returns all the jobs where companyId = &#63; and groupId = &#63; and name LIKE &#63; and active = &#63; and category = &#63; and location = &#63; and type = &#63; and description LIKE &#63; and bookmarks LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param name the name
	 * @param active the active
	 * @param category the category
	 * @param location the location
	 * @param type the type
	 * @param description the description
	 * @param bookmarks the bookmarks
	 * @return the matching jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Job> findByBookmarks(long companyId, long groupId, String name,
		boolean active, long category, long location, long type,
		String description, String bookmarks) throws SystemException {
		return findByBookmarks(companyId, groupId, name, active, category,
			location, type, description, bookmarks, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the jobs where companyId = &#63; and groupId = &#63; and name LIKE &#63; and active = &#63; and category = &#63; and location = &#63; and type = &#63; and description LIKE &#63; and bookmarks LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.JobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param name the name
	 * @param active the active
	 * @param category the category
	 * @param location the location
	 * @param type the type
	 * @param description the description
	 * @param bookmarks the bookmarks
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @return the range of matching jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Job> findByBookmarks(long companyId, long groupId, String name,
		boolean active, long category, long location, long type,
		String description, String bookmarks, int start, int end)
		throws SystemException {
		return findByBookmarks(companyId, groupId, name, active, category,
			location, type, description, bookmarks, start, end, null);
	}

	/**
	 * Returns an ordered range of all the jobs where companyId = &#63; and groupId = &#63; and name LIKE &#63; and active = &#63; and category = &#63; and location = &#63; and type = &#63; and description LIKE &#63; and bookmarks LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.JobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param name the name
	 * @param active the active
	 * @param category the category
	 * @param location the location
	 * @param type the type
	 * @param description the description
	 * @param bookmarks the bookmarks
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Job> findByBookmarks(long companyId, long groupId, String name,
		boolean active, long category, long location, long type,
		String description, String bookmarks, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BOOKMARKS;
		finderArgs = new Object[] {
				companyId, groupId, name, active, category, location, type,
				description, bookmarks,
				
				start, end, orderByComparator
			};

		List<Job> list = (List<Job>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Job job : list) {
				if ((companyId != job.getCompanyId()) ||
						(groupId != job.getGroupId()) ||
						!StringUtil.wildcardMatches(job.getName(), name,
							CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, false) ||
						(active != job.getActive()) ||
						(category != job.getCategory()) ||
						(location != job.getLocation()) ||
						(type != job.getType()) ||
						!StringUtil.wildcardMatches(job.getDescription(),
							description, CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, false) ||
						!StringUtil.wildcardMatches(job.getBookmarks(),
							bookmarks, CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, false)) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(11 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(11);
			}

			query.append(_SQL_SELECT_JOB_WHERE);

			query.append(_FINDER_COLUMN_BOOKMARKS_COMPANYID_2);

			query.append(_FINDER_COLUMN_BOOKMARKS_GROUPID_2);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_BOOKMARKS_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BOOKMARKS_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_BOOKMARKS_NAME_2);
			}

			query.append(_FINDER_COLUMN_BOOKMARKS_ACTIVE_2);

			query.append(_FINDER_COLUMN_BOOKMARKS_CATEGORY_2);

			query.append(_FINDER_COLUMN_BOOKMARKS_LOCATION_2);

			query.append(_FINDER_COLUMN_BOOKMARKS_TYPE_2);

			boolean bindDescription = false;

			if (description == null) {
				query.append(_FINDER_COLUMN_BOOKMARKS_DESCRIPTION_1);
			}
			else if (description.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BOOKMARKS_DESCRIPTION_3);
			}
			else {
				bindDescription = true;

				query.append(_FINDER_COLUMN_BOOKMARKS_DESCRIPTION_2);
			}

			boolean bindBookmarks = false;

			if (bookmarks == null) {
				query.append(_FINDER_COLUMN_BOOKMARKS_BOOKMARKS_1);
			}
			else if (bookmarks.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BOOKMARKS_BOOKMARKS_3);
			}
			else {
				bindBookmarks = true;

				query.append(_FINDER_COLUMN_BOOKMARKS_BOOKMARKS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(JobModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindName) {
					qPos.add(name.toLowerCase());
				}

				qPos.add(active);

				qPos.add(category);

				qPos.add(location);

				qPos.add(type);

				if (bindDescription) {
					qPos.add(description.toLowerCase());
				}

				if (bindBookmarks) {
					qPos.add(bookmarks.toLowerCase());
				}

				if (!pagination) {
					list = (List<Job>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Job>(list);
				}
				else {
					list = (List<Job>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first job in the ordered set where companyId = &#63; and groupId = &#63; and name LIKE &#63; and active = &#63; and category = &#63; and location = &#63; and type = &#63; and description LIKE &#63; and bookmarks LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param name the name
	 * @param active the active
	 * @param category the category
	 * @param location the location
	 * @param type the type
	 * @param description the description
	 * @param bookmarks the bookmarks
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws com.rivetlogic.jobsboard.NoSuchJobException if a matching job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Job findByBookmarks_First(long companyId, long groupId, String name,
		boolean active, long category, long location, long type,
		String description, String bookmarks,
		OrderByComparator orderByComparator)
		throws NoSuchJobException, SystemException {
		Job job = fetchByBookmarks_First(companyId, groupId, name, active,
				category, location, type, description, bookmarks,
				orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(20);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", name=");
		msg.append(name);

		msg.append(", active=");
		msg.append(active);

		msg.append(", category=");
		msg.append(category);

		msg.append(", location=");
		msg.append(location);

		msg.append(", type=");
		msg.append(type);

		msg.append(", description=");
		msg.append(description);

		msg.append(", bookmarks=");
		msg.append(bookmarks);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchJobException(msg.toString());
	}

	/**
	 * Returns the first job in the ordered set where companyId = &#63; and groupId = &#63; and name LIKE &#63; and active = &#63; and category = &#63; and location = &#63; and type = &#63; and description LIKE &#63; and bookmarks LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param name the name
	 * @param active the active
	 * @param category the category
	 * @param location the location
	 * @param type the type
	 * @param description the description
	 * @param bookmarks the bookmarks
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Job fetchByBookmarks_First(long companyId, long groupId,
		String name, boolean active, long category, long location, long type,
		String description, String bookmarks,
		OrderByComparator orderByComparator) throws SystemException {
		List<Job> list = findByBookmarks(companyId, groupId, name, active,
				category, location, type, description, bookmarks, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last job in the ordered set where companyId = &#63; and groupId = &#63; and name LIKE &#63; and active = &#63; and category = &#63; and location = &#63; and type = &#63; and description LIKE &#63; and bookmarks LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param name the name
	 * @param active the active
	 * @param category the category
	 * @param location the location
	 * @param type the type
	 * @param description the description
	 * @param bookmarks the bookmarks
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws com.rivetlogic.jobsboard.NoSuchJobException if a matching job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Job findByBookmarks_Last(long companyId, long groupId, String name,
		boolean active, long category, long location, long type,
		String description, String bookmarks,
		OrderByComparator orderByComparator)
		throws NoSuchJobException, SystemException {
		Job job = fetchByBookmarks_Last(companyId, groupId, name, active,
				category, location, type, description, bookmarks,
				orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(20);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", name=");
		msg.append(name);

		msg.append(", active=");
		msg.append(active);

		msg.append(", category=");
		msg.append(category);

		msg.append(", location=");
		msg.append(location);

		msg.append(", type=");
		msg.append(type);

		msg.append(", description=");
		msg.append(description);

		msg.append(", bookmarks=");
		msg.append(bookmarks);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchJobException(msg.toString());
	}

	/**
	 * Returns the last job in the ordered set where companyId = &#63; and groupId = &#63; and name LIKE &#63; and active = &#63; and category = &#63; and location = &#63; and type = &#63; and description LIKE &#63; and bookmarks LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param name the name
	 * @param active the active
	 * @param category the category
	 * @param location the location
	 * @param type the type
	 * @param description the description
	 * @param bookmarks the bookmarks
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Job fetchByBookmarks_Last(long companyId, long groupId, String name,
		boolean active, long category, long location, long type,
		String description, String bookmarks,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByBookmarks(companyId, groupId, name, active,
				category, location, type, description, bookmarks);

		if (count == 0) {
			return null;
		}

		List<Job> list = findByBookmarks(companyId, groupId, name, active,
				category, location, type, description, bookmarks, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the jobs before and after the current job in the ordered set where companyId = &#63; and groupId = &#63; and name LIKE &#63; and active = &#63; and category = &#63; and location = &#63; and type = &#63; and description LIKE &#63; and bookmarks LIKE &#63;.
	 *
	 * @param jobId the primary key of the current job
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param name the name
	 * @param active the active
	 * @param category the category
	 * @param location the location
	 * @param type the type
	 * @param description the description
	 * @param bookmarks the bookmarks
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job
	 * @throws com.rivetlogic.jobsboard.NoSuchJobException if a job with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Job[] findByBookmarks_PrevAndNext(long jobId, long companyId,
		long groupId, String name, boolean active, long category,
		long location, long type, String description, String bookmarks,
		OrderByComparator orderByComparator)
		throws NoSuchJobException, SystemException {
		Job job = findByPrimaryKey(jobId);

		Session session = null;

		try {
			session = openSession();

			Job[] array = new JobImpl[3];

			array[0] = getByBookmarks_PrevAndNext(session, job, companyId,
					groupId, name, active, category, location, type,
					description, bookmarks, orderByComparator, true);

			array[1] = job;

			array[2] = getByBookmarks_PrevAndNext(session, job, companyId,
					groupId, name, active, category, location, type,
					description, bookmarks, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Job getByBookmarks_PrevAndNext(Session session, Job job,
		long companyId, long groupId, String name, boolean active,
		long category, long location, long type, String description,
		String bookmarks, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_JOB_WHERE);

		query.append(_FINDER_COLUMN_BOOKMARKS_COMPANYID_2);

		query.append(_FINDER_COLUMN_BOOKMARKS_GROUPID_2);

		boolean bindName = false;

		if (name == null) {
			query.append(_FINDER_COLUMN_BOOKMARKS_NAME_1);
		}
		else if (name.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_BOOKMARKS_NAME_3);
		}
		else {
			bindName = true;

			query.append(_FINDER_COLUMN_BOOKMARKS_NAME_2);
		}

		query.append(_FINDER_COLUMN_BOOKMARKS_ACTIVE_2);

		query.append(_FINDER_COLUMN_BOOKMARKS_CATEGORY_2);

		query.append(_FINDER_COLUMN_BOOKMARKS_LOCATION_2);

		query.append(_FINDER_COLUMN_BOOKMARKS_TYPE_2);

		boolean bindDescription = false;

		if (description == null) {
			query.append(_FINDER_COLUMN_BOOKMARKS_DESCRIPTION_1);
		}
		else if (description.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_BOOKMARKS_DESCRIPTION_3);
		}
		else {
			bindDescription = true;

			query.append(_FINDER_COLUMN_BOOKMARKS_DESCRIPTION_2);
		}

		boolean bindBookmarks = false;

		if (bookmarks == null) {
			query.append(_FINDER_COLUMN_BOOKMARKS_BOOKMARKS_1);
		}
		else if (bookmarks.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_BOOKMARKS_BOOKMARKS_3);
		}
		else {
			bindBookmarks = true;

			query.append(_FINDER_COLUMN_BOOKMARKS_BOOKMARKS_2);
		}

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
			query.append(JobModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (bindName) {
			qPos.add(name.toLowerCase());
		}

		qPos.add(active);

		qPos.add(category);

		qPos.add(location);

		qPos.add(type);

		if (bindDescription) {
			qPos.add(description.toLowerCase());
		}

		if (bindBookmarks) {
			qPos.add(bookmarks.toLowerCase());
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(job);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Job> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the jobs where companyId = &#63; and groupId = &#63; and name LIKE all &#63; and active = any &#63; and category = any &#63; and location = any &#63; and type = any &#63; and description LIKE all &#63; and bookmarks LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.JobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param names the names
	 * @param actives the actives
	 * @param categories the categories
	 * @param locations the locations
	 * @param types the types
	 * @param descriptions the descriptions
	 * @param bookmarks the bookmarks
	 * @return the matching jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Job> findByBookmarks(long companyId, long groupId,
		String[] names, boolean[] actives, long[] categories, long[] locations,
		long[] types, String[] descriptions, String bookmarks)
		throws SystemException {
		return findByBookmarks(companyId, groupId, names, actives, categories,
			locations, types, descriptions, bookmarks, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the jobs where companyId = &#63; and groupId = &#63; and name LIKE all &#63; and active = any &#63; and category = any &#63; and location = any &#63; and type = any &#63; and description LIKE all &#63; and bookmarks LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.JobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param names the names
	 * @param actives the actives
	 * @param categories the categories
	 * @param locations the locations
	 * @param types the types
	 * @param descriptions the descriptions
	 * @param bookmarks the bookmarks
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @return the range of matching jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Job> findByBookmarks(long companyId, long groupId,
		String[] names, boolean[] actives, long[] categories, long[] locations,
		long[] types, String[] descriptions, String bookmarks, int start,
		int end) throws SystemException {
		return findByBookmarks(companyId, groupId, names, actives, categories,
			locations, types, descriptions, bookmarks, start, end, null);
	}

	/**
	 * Returns an ordered range of all the jobs where companyId = &#63; and groupId = &#63; and name LIKE all &#63; and active = any &#63; and category = any &#63; and location = any &#63; and type = any &#63; and description LIKE all &#63; and bookmarks LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.JobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param names the names
	 * @param actives the actives
	 * @param categories the categories
	 * @param locations the locations
	 * @param types the types
	 * @param descriptions the descriptions
	 * @param bookmarks the bookmarks
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Job> findByBookmarks(long companyId, long groupId,
		String[] names, boolean[] actives, long[] categories, long[] locations,
		long[] types, String[] descriptions, String bookmarks, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		if ((names != null) && (names.length == 1) && (actives != null) &&
				(actives.length == 1) && (categories != null) &&
				(categories.length == 1) && (locations != null) &&
				(locations.length == 1) && (types != null) &&
				(types.length == 1) && (descriptions != null) &&
				(descriptions.length == 1)) {
			return findByBookmarks(companyId, groupId, names[0], actives[0],
				categories[0], locations[0], types[0], descriptions[0],
				bookmarks, start, end, orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] {
					companyId, groupId, StringUtil.merge(names),
					StringUtil.merge(actives), StringUtil.merge(categories),
					StringUtil.merge(locations), StringUtil.merge(types),
					StringUtil.merge(descriptions), bookmarks
				};
		}
		else {
			finderArgs = new Object[] {
					companyId, groupId, StringUtil.merge(names),
					StringUtil.merge(actives), StringUtil.merge(categories),
					StringUtil.merge(locations), StringUtil.merge(types),
					StringUtil.merge(descriptions), bookmarks,
					
					start, end, orderByComparator
				};
		}

		List<Job> list = (List<Job>)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_BOOKMARKS,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Job job : list) {
				if ((companyId != job.getCompanyId()) ||
						(groupId != job.getGroupId()) ||
						!ArrayUtil.contains(names, job.getName()) ||
						!ArrayUtil.contains(actives, job.getActive()) ||
						!ArrayUtil.contains(categories, job.getCategory()) ||
						!ArrayUtil.contains(locations, job.getLocation()) ||
						!ArrayUtil.contains(types, job.getType()) ||
						!ArrayUtil.contains(descriptions, job.getDescription()) ||
						!Validator.equals(bookmarks, job.getBookmarks())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_JOB_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_BOOKMARKS_COMPANYID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_BOOKMARKS_GROUPID_5);

			conjunctionable = true;

			if ((names == null) || (names.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < names.length; i++) {
					String name = names[i];

					if (name == null) {
						query.append(_FINDER_COLUMN_BOOKMARKS_NAME_4);
					}
					else if (name.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_BOOKMARKS_NAME_6);
					}
					else {
						query.append(_FINDER_COLUMN_BOOKMARKS_NAME_5);
					}

					if ((i + 1) < names.length) {
						query.append(WHERE_AND);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if ((actives == null) || (actives.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < actives.length; i++) {
					query.append(_FINDER_COLUMN_BOOKMARKS_ACTIVE_5);

					if ((i + 1) < actives.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if ((categories == null) || (categories.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < categories.length; i++) {
					query.append(_FINDER_COLUMN_BOOKMARKS_CATEGORY_5);

					if ((i + 1) < categories.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if ((locations == null) || (locations.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < locations.length; i++) {
					query.append(_FINDER_COLUMN_BOOKMARKS_LOCATION_5);

					if ((i + 1) < locations.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if ((types == null) || (types.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < types.length; i++) {
					query.append(_FINDER_COLUMN_BOOKMARKS_TYPE_5);

					if ((i + 1) < types.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if ((descriptions == null) || (descriptions.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < descriptions.length; i++) {
					String description = descriptions[i];

					if (description == null) {
						query.append(_FINDER_COLUMN_BOOKMARKS_DESCRIPTION_4);
					}
					else if (description.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_BOOKMARKS_DESCRIPTION_6);
					}
					else {
						query.append(_FINDER_COLUMN_BOOKMARKS_DESCRIPTION_5);
					}

					if ((i + 1) < descriptions.length) {
						query.append(WHERE_AND);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			if (bookmarks == null) {
				query.append(_FINDER_COLUMN_BOOKMARKS_BOOKMARKS_4);
			}
			else if (bookmarks.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BOOKMARKS_BOOKMARKS_6);
			}
			else {
				query.append(_FINDER_COLUMN_BOOKMARKS_BOOKMARKS_5);
			}

			conjunctionable = true;

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(JobModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (names != null) {
					qPos.add(names);
				}

				if (actives != null) {
					qPos.add(actives);
				}

				if (categories != null) {
					qPos.add(categories);
				}

				if (locations != null) {
					qPos.add(locations);
				}

				if (types != null) {
					qPos.add(types);
				}

				if (descriptions != null) {
					qPos.add(descriptions);
				}

				if (bookmarks != null) {
					qPos.add(bookmarks);
				}

				if (!pagination) {
					list = (List<Job>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Job>(list);
				}
				else {
					list = (List<Job>)QueryUtil.list(q, getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_BOOKMARKS,
					finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_BOOKMARKS,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the jobs where companyId = &#63; and groupId = &#63; and name LIKE &#63; and active = &#63; and category = &#63; and location = &#63; and type = &#63; and description LIKE &#63; and bookmarks LIKE &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param name the name
	 * @param active the active
	 * @param category the category
	 * @param location the location
	 * @param type the type
	 * @param description the description
	 * @param bookmarks the bookmarks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByBookmarks(long companyId, long groupId, String name,
		boolean active, long category, long location, long type,
		String description, String bookmarks) throws SystemException {
		for (Job job : findByBookmarks(companyId, groupId, name, active,
				category, location, type, description, bookmarks,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(job);
		}
	}

	/**
	 * Returns the number of jobs where companyId = &#63; and groupId = &#63; and name LIKE &#63; and active = &#63; and category = &#63; and location = &#63; and type = &#63; and description LIKE &#63; and bookmarks LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param name the name
	 * @param active the active
	 * @param category the category
	 * @param location the location
	 * @param type the type
	 * @param description the description
	 * @param bookmarks the bookmarks
	 * @return the number of matching jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByBookmarks(long companyId, long groupId, String name,
		boolean active, long category, long location, long type,
		String description, String bookmarks) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_BOOKMARKS;

		Object[] finderArgs = new Object[] {
				companyId, groupId, name, active, category, location, type,
				description, bookmarks
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(10);

			query.append(_SQL_COUNT_JOB_WHERE);

			query.append(_FINDER_COLUMN_BOOKMARKS_COMPANYID_2);

			query.append(_FINDER_COLUMN_BOOKMARKS_GROUPID_2);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_BOOKMARKS_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BOOKMARKS_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_BOOKMARKS_NAME_2);
			}

			query.append(_FINDER_COLUMN_BOOKMARKS_ACTIVE_2);

			query.append(_FINDER_COLUMN_BOOKMARKS_CATEGORY_2);

			query.append(_FINDER_COLUMN_BOOKMARKS_LOCATION_2);

			query.append(_FINDER_COLUMN_BOOKMARKS_TYPE_2);

			boolean bindDescription = false;

			if (description == null) {
				query.append(_FINDER_COLUMN_BOOKMARKS_DESCRIPTION_1);
			}
			else if (description.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BOOKMARKS_DESCRIPTION_3);
			}
			else {
				bindDescription = true;

				query.append(_FINDER_COLUMN_BOOKMARKS_DESCRIPTION_2);
			}

			boolean bindBookmarks = false;

			if (bookmarks == null) {
				query.append(_FINDER_COLUMN_BOOKMARKS_BOOKMARKS_1);
			}
			else if (bookmarks.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BOOKMARKS_BOOKMARKS_3);
			}
			else {
				bindBookmarks = true;

				query.append(_FINDER_COLUMN_BOOKMARKS_BOOKMARKS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindName) {
					qPos.add(name.toLowerCase());
				}

				qPos.add(active);

				qPos.add(category);

				qPos.add(location);

				qPos.add(type);

				if (bindDescription) {
					qPos.add(description.toLowerCase());
				}

				if (bindBookmarks) {
					qPos.add(bookmarks.toLowerCase());
				}

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

	/**
	 * Returns the number of jobs where companyId = &#63; and groupId = &#63; and name LIKE all &#63; and active = any &#63; and category = any &#63; and location = any &#63; and type = any &#63; and description LIKE all &#63; and bookmarks LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param names the names
	 * @param actives the actives
	 * @param categories the categories
	 * @param locations the locations
	 * @param types the types
	 * @param descriptions the descriptions
	 * @param bookmarks the bookmarks
	 * @return the number of matching jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByBookmarks(long companyId, long groupId, String[] names,
		boolean[] actives, long[] categories, long[] locations, long[] types,
		String[] descriptions, String bookmarks) throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId, groupId, StringUtil.merge(names),
				StringUtil.merge(actives), StringUtil.merge(categories),
				StringUtil.merge(locations), StringUtil.merge(types),
				StringUtil.merge(descriptions), bookmarks
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_BOOKMARKS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_JOB_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_BOOKMARKS_COMPANYID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_BOOKMARKS_GROUPID_5);

			conjunctionable = true;

			if ((names == null) || (names.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < names.length; i++) {
					String name = names[i];

					if (name == null) {
						query.append(_FINDER_COLUMN_BOOKMARKS_NAME_4);
					}
					else if (name.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_BOOKMARKS_NAME_6);
					}
					else {
						query.append(_FINDER_COLUMN_BOOKMARKS_NAME_5);
					}

					if ((i + 1) < names.length) {
						query.append(WHERE_AND);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if ((actives == null) || (actives.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < actives.length; i++) {
					query.append(_FINDER_COLUMN_BOOKMARKS_ACTIVE_5);

					if ((i + 1) < actives.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if ((categories == null) || (categories.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < categories.length; i++) {
					query.append(_FINDER_COLUMN_BOOKMARKS_CATEGORY_5);

					if ((i + 1) < categories.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if ((locations == null) || (locations.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < locations.length; i++) {
					query.append(_FINDER_COLUMN_BOOKMARKS_LOCATION_5);

					if ((i + 1) < locations.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if ((types == null) || (types.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < types.length; i++) {
					query.append(_FINDER_COLUMN_BOOKMARKS_TYPE_5);

					if ((i + 1) < types.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if ((descriptions == null) || (descriptions.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < descriptions.length; i++) {
					String description = descriptions[i];

					if (description == null) {
						query.append(_FINDER_COLUMN_BOOKMARKS_DESCRIPTION_4);
					}
					else if (description.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_BOOKMARKS_DESCRIPTION_6);
					}
					else {
						query.append(_FINDER_COLUMN_BOOKMARKS_DESCRIPTION_5);
					}

					if ((i + 1) < descriptions.length) {
						query.append(WHERE_AND);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			if (bookmarks == null) {
				query.append(_FINDER_COLUMN_BOOKMARKS_BOOKMARKS_4);
			}
			else if (bookmarks.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BOOKMARKS_BOOKMARKS_6);
			}
			else {
				query.append(_FINDER_COLUMN_BOOKMARKS_BOOKMARKS_5);
			}

			conjunctionable = true;

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (names != null) {
					qPos.add(names);
				}

				if (actives != null) {
					qPos.add(actives);
				}

				if (categories != null) {
					qPos.add(categories);
				}

				if (locations != null) {
					qPos.add(locations);
				}

				if (types != null) {
					qPos.add(types);
				}

				if (descriptions != null) {
					qPos.add(descriptions);
				}

				if (bookmarks != null) {
					qPos.add(bookmarks);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_BOOKMARKS,
					finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_BOOKMARKS,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_BOOKMARKS_COMPANYID_2 = "job.companyId = ? AND ";
	private static final String _FINDER_COLUMN_BOOKMARKS_COMPANYID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_BOOKMARKS_COMPANYID_2) + ")";
	private static final String _FINDER_COLUMN_BOOKMARKS_GROUPID_2 = "job.groupId = ? AND ";
	private static final String _FINDER_COLUMN_BOOKMARKS_GROUPID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_BOOKMARKS_GROUPID_2) + ")";
	private static final String _FINDER_COLUMN_BOOKMARKS_NAME_1 = "job.name LIKE NULL AND ";
	private static final String _FINDER_COLUMN_BOOKMARKS_NAME_2 = "lower(job.name) LIKE ? AND ";
	private static final String _FINDER_COLUMN_BOOKMARKS_NAME_3 = "(job.name IS NULL OR job.name LIKE '') AND ";
	private static final String _FINDER_COLUMN_BOOKMARKS_NAME_4 = "(" +
		removeConjunction(_FINDER_COLUMN_BOOKMARKS_NAME_1) + ")";
	private static final String _FINDER_COLUMN_BOOKMARKS_NAME_5 = "(" +
		removeConjunction(_FINDER_COLUMN_BOOKMARKS_NAME_2) + ")";
	private static final String _FINDER_COLUMN_BOOKMARKS_NAME_6 = "(" +
		removeConjunction(_FINDER_COLUMN_BOOKMARKS_NAME_3) + ")";
	private static final String _FINDER_COLUMN_BOOKMARKS_ACTIVE_2 = "job.active = ? AND ";
	private static final String _FINDER_COLUMN_BOOKMARKS_ACTIVE_5 = "(" +
		removeConjunction(_FINDER_COLUMN_BOOKMARKS_ACTIVE_2) + ")";
	private static final String _FINDER_COLUMN_BOOKMARKS_CATEGORY_2 = "job.category = ? AND ";
	private static final String _FINDER_COLUMN_BOOKMARKS_CATEGORY_5 = "(" +
		removeConjunction(_FINDER_COLUMN_BOOKMARKS_CATEGORY_2) + ")";
	private static final String _FINDER_COLUMN_BOOKMARKS_LOCATION_2 = "job.location = ? AND ";
	private static final String _FINDER_COLUMN_BOOKMARKS_LOCATION_5 = "(" +
		removeConjunction(_FINDER_COLUMN_BOOKMARKS_LOCATION_2) + ")";
	private static final String _FINDER_COLUMN_BOOKMARKS_TYPE_2 = "job.type = ? AND ";
	private static final String _FINDER_COLUMN_BOOKMARKS_TYPE_5 = "(" +
		removeConjunction(_FINDER_COLUMN_BOOKMARKS_TYPE_2) + ")";
	private static final String _FINDER_COLUMN_BOOKMARKS_DESCRIPTION_1 = "job.description LIKE NULL AND ";
	private static final String _FINDER_COLUMN_BOOKMARKS_DESCRIPTION_2 = "lower(job.description) LIKE ? AND ";
	private static final String _FINDER_COLUMN_BOOKMARKS_DESCRIPTION_3 = "(job.description IS NULL OR job.description LIKE '') AND ";
	private static final String _FINDER_COLUMN_BOOKMARKS_DESCRIPTION_4 = "(" +
		removeConjunction(_FINDER_COLUMN_BOOKMARKS_DESCRIPTION_1) + ")";
	private static final String _FINDER_COLUMN_BOOKMARKS_DESCRIPTION_5 = "(" +
		removeConjunction(_FINDER_COLUMN_BOOKMARKS_DESCRIPTION_2) + ")";
	private static final String _FINDER_COLUMN_BOOKMARKS_DESCRIPTION_6 = "(" +
		removeConjunction(_FINDER_COLUMN_BOOKMARKS_DESCRIPTION_3) + ")";
	private static final String _FINDER_COLUMN_BOOKMARKS_BOOKMARKS_1 = "job.bookmarks LIKE NULL";
	private static final String _FINDER_COLUMN_BOOKMARKS_BOOKMARKS_2 = "lower(job.bookmarks) LIKE ?";
	private static final String _FINDER_COLUMN_BOOKMARKS_BOOKMARKS_3 = "(job.bookmarks IS NULL OR job.bookmarks LIKE '')";
	private static final String _FINDER_COLUMN_BOOKMARKS_BOOKMARKS_4 = "(" +
		removeConjunction(_FINDER_COLUMN_BOOKMARKS_BOOKMARKS_1) + ")";
	private static final String _FINDER_COLUMN_BOOKMARKS_BOOKMARKS_5 = "(" +
		removeConjunction(_FINDER_COLUMN_BOOKMARKS_BOOKMARKS_2) + ")";
	private static final String _FINDER_COLUMN_BOOKMARKS_BOOKMARKS_6 = "(" +
		removeConjunction(_FINDER_COLUMN_BOOKMARKS_BOOKMARKS_3) + ")";

	public JobPersistenceImpl() {
		setModelClass(Job.class);
	}

	/**
	 * Caches the job in the entity cache if it is enabled.
	 *
	 * @param job the job
	 */
	@Override
	public void cacheResult(Job job) {
		EntityCacheUtil.putResult(JobModelImpl.ENTITY_CACHE_ENABLED,
			JobImpl.class, job.getPrimaryKey(), job);

		job.resetOriginalValues();
	}

	/**
	 * Caches the jobs in the entity cache if it is enabled.
	 *
	 * @param jobs the jobs
	 */
	@Override
	public void cacheResult(List<Job> jobs) {
		for (Job job : jobs) {
			if (EntityCacheUtil.getResult(JobModelImpl.ENTITY_CACHE_ENABLED,
						JobImpl.class, job.getPrimaryKey()) == null) {
				cacheResult(job);
			}
			else {
				job.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all jobs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(JobImpl.class.getName());
		}

		EntityCacheUtil.clearCache(JobImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the job.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Job job) {
		EntityCacheUtil.removeResult(JobModelImpl.ENTITY_CACHE_ENABLED,
			JobImpl.class, job.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Job> jobs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Job job : jobs) {
			EntityCacheUtil.removeResult(JobModelImpl.ENTITY_CACHE_ENABLED,
				JobImpl.class, job.getPrimaryKey());
		}
	}

	/**
	 * Creates a new job with the primary key. Does not add the job to the database.
	 *
	 * @param jobId the primary key for the new job
	 * @return the new job
	 */
	@Override
	public Job create(long jobId) {
		Job job = new JobImpl();

		job.setNew(true);
		job.setPrimaryKey(jobId);

		return job;
	}

	/**
	 * Removes the job with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param jobId the primary key of the job
	 * @return the job that was removed
	 * @throws com.rivetlogic.jobsboard.NoSuchJobException if a job with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Job remove(long jobId) throws NoSuchJobException, SystemException {
		return remove((Serializable)jobId);
	}

	/**
	 * Removes the job with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the job
	 * @return the job that was removed
	 * @throws com.rivetlogic.jobsboard.NoSuchJobException if a job with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Job remove(Serializable primaryKey)
		throws NoSuchJobException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Job job = (Job)session.get(JobImpl.class, primaryKey);

			if (job == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchJobException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(job);
		}
		catch (NoSuchJobException nsee) {
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
	protected Job removeImpl(Job job) throws SystemException {
		job = toUnwrappedModel(job);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(job)) {
				job = (Job)session.get(JobImpl.class, job.getPrimaryKeyObj());
			}

			if (job != null) {
				session.delete(job);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (job != null) {
			clearCache(job);
		}

		return job;
	}

	@Override
	public Job updateImpl(com.rivetlogic.jobsboard.model.Job job)
		throws SystemException {
		job = toUnwrappedModel(job);

		boolean isNew = job.isNew();

		JobModelImpl jobModelImpl = (JobModelImpl)job;

		Session session = null;

		try {
			session = openSession();

			if (job.isNew()) {
				session.save(job);

				job.setNew(false);
			}
			else {
				session.merge(job);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !JobModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((jobModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						jobModelImpl.getOriginalCompanyId(),
						jobModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP,
					args);

				args = new Object[] {
						jobModelImpl.getCompanyId(), jobModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP,
					args);
			}
		}

		EntityCacheUtil.putResult(JobModelImpl.ENTITY_CACHE_ENABLED,
			JobImpl.class, job.getPrimaryKey(), job);

		return job;
	}

	protected Job toUnwrappedModel(Job job) {
		if (job instanceof JobImpl) {
			return job;
		}

		JobImpl jobImpl = new JobImpl();

		jobImpl.setNew(job.isNew());
		jobImpl.setPrimaryKey(job.getPrimaryKey());

		jobImpl.setJobId(job.getJobId());
		jobImpl.setGroupId(job.getGroupId());
		jobImpl.setCompanyId(job.getCompanyId());
		jobImpl.setUserId(job.getUserId());
		jobImpl.setUserName(job.getUserName());
		jobImpl.setCreateDate(job.getCreateDate());
		jobImpl.setModifiedDate(job.getModifiedDate());
		jobImpl.setName(job.getName());
		jobImpl.setActive(job.isActive());
		jobImpl.setCategory(job.getCategory());
		jobImpl.setLocation(job.getLocation());
		jobImpl.setType(job.getType());
		jobImpl.setDescription(job.getDescription());
		jobImpl.setSalary(job.getSalary());
		jobImpl.setBookmarks(job.getBookmarks());

		return jobImpl;
	}

	/**
	 * Returns the job with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the job
	 * @return the job
	 * @throws com.rivetlogic.jobsboard.NoSuchJobException if a job with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Job findByPrimaryKey(Serializable primaryKey)
		throws NoSuchJobException, SystemException {
		Job job = fetchByPrimaryKey(primaryKey);

		if (job == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchJobException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return job;
	}

	/**
	 * Returns the job with the primary key or throws a {@link com.rivetlogic.jobsboard.NoSuchJobException} if it could not be found.
	 *
	 * @param jobId the primary key of the job
	 * @return the job
	 * @throws com.rivetlogic.jobsboard.NoSuchJobException if a job with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Job findByPrimaryKey(long jobId)
		throws NoSuchJobException, SystemException {
		return findByPrimaryKey((Serializable)jobId);
	}

	/**
	 * Returns the job with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the job
	 * @return the job, or <code>null</code> if a job with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Job fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Job job = (Job)EntityCacheUtil.getResult(JobModelImpl.ENTITY_CACHE_ENABLED,
				JobImpl.class, primaryKey);

		if (job == _nullJob) {
			return null;
		}

		if (job == null) {
			Session session = null;

			try {
				session = openSession();

				job = (Job)session.get(JobImpl.class, primaryKey);

				if (job != null) {
					cacheResult(job);
				}
				else {
					EntityCacheUtil.putResult(JobModelImpl.ENTITY_CACHE_ENABLED,
						JobImpl.class, primaryKey, _nullJob);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(JobModelImpl.ENTITY_CACHE_ENABLED,
					JobImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return job;
	}

	/**
	 * Returns the job with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param jobId the primary key of the job
	 * @return the job, or <code>null</code> if a job with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Job fetchByPrimaryKey(long jobId) throws SystemException {
		return fetchByPrimaryKey((Serializable)jobId);
	}

	/**
	 * Returns all the jobs.
	 *
	 * @return the jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Job> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the jobs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.JobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @return the range of jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Job> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the jobs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.JobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Job> findAll(int start, int end,
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

		List<Job> list = (List<Job>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_JOB);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_JOB;

				if (pagination) {
					sql = sql.concat(JobModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Job>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Job>(list);
				}
				else {
					list = (List<Job>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Removes all the jobs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Job job : findAll()) {
			remove(job);
		}
	}

	/**
	 * Returns the number of jobs.
	 *
	 * @return the number of jobs
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

				Query q = session.createQuery(_SQL_COUNT_JOB);

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

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the job persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rivetlogic.jobsboard.model.Job")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Job>> listenersList = new ArrayList<ModelListener<Job>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Job>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(JobImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_JOB = "SELECT job FROM Job job";
	private static final String _SQL_SELECT_JOB_WHERE = "SELECT job FROM Job job WHERE ";
	private static final String _SQL_COUNT_JOB = "SELECT COUNT(job) FROM Job job";
	private static final String _SQL_COUNT_JOB_WHERE = "SELECT COUNT(job) FROM Job job WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "job.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Job exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Job exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(JobPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"active", "type"
			});
	private static Job _nullJob = new JobImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Job> toCacheModel() {
				return _nullJobCacheModel;
			}
		};

	private static CacheModel<Job> _nullJobCacheModel = new CacheModel<Job>() {
			@Override
			public Job toEntityModel() {
				return _nullJob;
			}
		};
}