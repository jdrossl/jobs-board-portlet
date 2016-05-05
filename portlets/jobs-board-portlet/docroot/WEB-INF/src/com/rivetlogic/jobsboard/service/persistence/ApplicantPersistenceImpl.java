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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.rivetlogic.jobsboard.NoSuchApplicantException;
import com.rivetlogic.jobsboard.model.Applicant;
import com.rivetlogic.jobsboard.model.impl.ApplicantImpl;
import com.rivetlogic.jobsboard.model.impl.ApplicantModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the applicant service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author joseross
 * @see ApplicantPersistence
 * @see ApplicantUtil
 * @generated
 */
public class ApplicantPersistenceImpl extends BasePersistenceImpl<Applicant>
	implements ApplicantPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ApplicantUtil} to access the applicant persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ApplicantImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ApplicantModelImpl.ENTITY_CACHE_ENABLED,
			ApplicantModelImpl.FINDER_CACHE_ENABLED, ApplicantImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ApplicantModelImpl.ENTITY_CACHE_ENABLED,
			ApplicantModelImpl.FINDER_CACHE_ENABLED, ApplicantImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ApplicantModelImpl.ENTITY_CACHE_ENABLED,
			ApplicantModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYGROUPJOB =
		new FinderPath(ApplicantModelImpl.ENTITY_CACHE_ENABLED,
			ApplicantModelImpl.FINDER_CACHE_ENABLED, ApplicantImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyGroupJob",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUPJOB =
		new FinderPath(ApplicantModelImpl.ENTITY_CACHE_ENABLED,
			ApplicantModelImpl.FINDER_CACHE_ENABLED, ApplicantImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyGroupJob",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			ApplicantModelImpl.COMPANYID_COLUMN_BITMASK |
			ApplicantModelImpl.GROUPID_COLUMN_BITMASK |
			ApplicantModelImpl.JOBID_COLUMN_BITMASK |
			ApplicantModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYGROUPJOB = new FinderPath(ApplicantModelImpl.ENTITY_CACHE_ENABLED,
			ApplicantModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCompanyGroupJob",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the applicants where companyId = &#63; and groupId = &#63; and jobId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param jobId the job ID
	 * @return the matching applicants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Applicant> findByCompanyGroupJob(long companyId, long groupId,
		long jobId) throws SystemException {
		return findByCompanyGroupJob(companyId, groupId, jobId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the applicants where companyId = &#63; and groupId = &#63; and jobId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.ApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param jobId the job ID
	 * @param start the lower bound of the range of applicants
	 * @param end the upper bound of the range of applicants (not inclusive)
	 * @return the range of matching applicants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Applicant> findByCompanyGroupJob(long companyId, long groupId,
		long jobId, int start, int end) throws SystemException {
		return findByCompanyGroupJob(companyId, groupId, jobId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the applicants where companyId = &#63; and groupId = &#63; and jobId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.ApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param jobId the job ID
	 * @param start the lower bound of the range of applicants
	 * @param end the upper bound of the range of applicants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching applicants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Applicant> findByCompanyGroupJob(long companyId, long groupId,
		long jobId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUPJOB;
			finderArgs = new Object[] { companyId, groupId, jobId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYGROUPJOB;
			finderArgs = new Object[] {
					companyId, groupId, jobId,
					
					start, end, orderByComparator
				};
		}

		List<Applicant> list = (List<Applicant>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Applicant applicant : list) {
				if ((companyId != applicant.getCompanyId()) ||
						(groupId != applicant.getGroupId()) ||
						(jobId != applicant.getJobId())) {
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

			query.append(_SQL_SELECT_APPLICANT_WHERE);

			query.append(_FINDER_COLUMN_COMPANYGROUPJOB_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYGROUPJOB_GROUPID_2);

			query.append(_FINDER_COLUMN_COMPANYGROUPJOB_JOBID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ApplicantModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(jobId);

				if (!pagination) {
					list = (List<Applicant>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Applicant>(list);
				}
				else {
					list = (List<Applicant>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first applicant in the ordered set where companyId = &#63; and groupId = &#63; and jobId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param jobId the job ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching applicant
	 * @throws com.rivetlogic.jobsboard.NoSuchApplicantException if a matching applicant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Applicant findByCompanyGroupJob_First(long companyId, long groupId,
		long jobId, OrderByComparator orderByComparator)
		throws NoSuchApplicantException, SystemException {
		Applicant applicant = fetchByCompanyGroupJob_First(companyId, groupId,
				jobId, orderByComparator);

		if (applicant != null) {
			return applicant;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", jobId=");
		msg.append(jobId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApplicantException(msg.toString());
	}

	/**
	 * Returns the first applicant in the ordered set where companyId = &#63; and groupId = &#63; and jobId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param jobId the job ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching applicant, or <code>null</code> if a matching applicant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Applicant fetchByCompanyGroupJob_First(long companyId, long groupId,
		long jobId, OrderByComparator orderByComparator)
		throws SystemException {
		List<Applicant> list = findByCompanyGroupJob(companyId, groupId, jobId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last applicant in the ordered set where companyId = &#63; and groupId = &#63; and jobId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param jobId the job ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching applicant
	 * @throws com.rivetlogic.jobsboard.NoSuchApplicantException if a matching applicant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Applicant findByCompanyGroupJob_Last(long companyId, long groupId,
		long jobId, OrderByComparator orderByComparator)
		throws NoSuchApplicantException, SystemException {
		Applicant applicant = fetchByCompanyGroupJob_Last(companyId, groupId,
				jobId, orderByComparator);

		if (applicant != null) {
			return applicant;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", jobId=");
		msg.append(jobId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApplicantException(msg.toString());
	}

	/**
	 * Returns the last applicant in the ordered set where companyId = &#63; and groupId = &#63; and jobId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param jobId the job ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching applicant, or <code>null</code> if a matching applicant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Applicant fetchByCompanyGroupJob_Last(long companyId, long groupId,
		long jobId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCompanyGroupJob(companyId, groupId, jobId);

		if (count == 0) {
			return null;
		}

		List<Applicant> list = findByCompanyGroupJob(companyId, groupId, jobId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the applicants before and after the current applicant in the ordered set where companyId = &#63; and groupId = &#63; and jobId = &#63;.
	 *
	 * @param applicantId the primary key of the current applicant
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param jobId the job ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next applicant
	 * @throws com.rivetlogic.jobsboard.NoSuchApplicantException if a applicant with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Applicant[] findByCompanyGroupJob_PrevAndNext(long applicantId,
		long companyId, long groupId, long jobId,
		OrderByComparator orderByComparator)
		throws NoSuchApplicantException, SystemException {
		Applicant applicant = findByPrimaryKey(applicantId);

		Session session = null;

		try {
			session = openSession();

			Applicant[] array = new ApplicantImpl[3];

			array[0] = getByCompanyGroupJob_PrevAndNext(session, applicant,
					companyId, groupId, jobId, orderByComparator, true);

			array[1] = applicant;

			array[2] = getByCompanyGroupJob_PrevAndNext(session, applicant,
					companyId, groupId, jobId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Applicant getByCompanyGroupJob_PrevAndNext(Session session,
		Applicant applicant, long companyId, long groupId, long jobId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_APPLICANT_WHERE);

		query.append(_FINDER_COLUMN_COMPANYGROUPJOB_COMPANYID_2);

		query.append(_FINDER_COLUMN_COMPANYGROUPJOB_GROUPID_2);

		query.append(_FINDER_COLUMN_COMPANYGROUPJOB_JOBID_2);

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
			query.append(ApplicantModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		qPos.add(jobId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(applicant);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Applicant> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the applicants where companyId = &#63; and groupId = &#63; and jobId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param jobId the job ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompanyGroupJob(long companyId, long groupId, long jobId)
		throws SystemException {
		for (Applicant applicant : findByCompanyGroupJob(companyId, groupId,
				jobId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(applicant);
		}
	}

	/**
	 * Returns the number of applicants where companyId = &#63; and groupId = &#63; and jobId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param jobId the job ID
	 * @return the number of matching applicants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCompanyGroupJob(long companyId, long groupId, long jobId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYGROUPJOB;

		Object[] finderArgs = new Object[] { companyId, groupId, jobId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_APPLICANT_WHERE);

			query.append(_FINDER_COLUMN_COMPANYGROUPJOB_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYGROUPJOB_GROUPID_2);

			query.append(_FINDER_COLUMN_COMPANYGROUPJOB_JOBID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(jobId);

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

	private static final String _FINDER_COLUMN_COMPANYGROUPJOB_COMPANYID_2 = "applicant.companyId = ? AND ";
	private static final String _FINDER_COLUMN_COMPANYGROUPJOB_GROUPID_2 = "applicant.groupId = ? AND ";
	private static final String _FINDER_COLUMN_COMPANYGROUPJOB_JOBID_2 = "applicant.jobId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FILTERS = new FinderPath(ApplicantModelImpl.ENTITY_CACHE_ENABLED,
			ApplicantModelImpl.FINDER_CACHE_ENABLED, ApplicantImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFilters",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_FILTERS = new FinderPath(ApplicantModelImpl.ENTITY_CACHE_ENABLED,
			ApplicantModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByFilters",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				String.class.getName(), String.class.getName()
			});

	/**
	 * Returns all the applicants where companyId = &#63; and groupId = &#63; and jobId = &#63; and name LIKE &#63; and status LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param jobId the job ID
	 * @param name the name
	 * @param status the status
	 * @return the matching applicants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Applicant> findByFilters(long companyId, long groupId,
		long jobId, String name, String status) throws SystemException {
		return findByFilters(companyId, groupId, jobId, name, status,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the applicants where companyId = &#63; and groupId = &#63; and jobId = &#63; and name LIKE &#63; and status LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.ApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param jobId the job ID
	 * @param name the name
	 * @param status the status
	 * @param start the lower bound of the range of applicants
	 * @param end the upper bound of the range of applicants (not inclusive)
	 * @return the range of matching applicants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Applicant> findByFilters(long companyId, long groupId,
		long jobId, String name, String status, int start, int end)
		throws SystemException {
		return findByFilters(companyId, groupId, jobId, name, status, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the applicants where companyId = &#63; and groupId = &#63; and jobId = &#63; and name LIKE &#63; and status LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.ApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param jobId the job ID
	 * @param name the name
	 * @param status the status
	 * @param start the lower bound of the range of applicants
	 * @param end the upper bound of the range of applicants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching applicants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Applicant> findByFilters(long companyId, long groupId,
		long jobId, String name, String status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FILTERS;
		finderArgs = new Object[] {
				companyId, groupId, jobId, name, status,
				
				start, end, orderByComparator
			};

		List<Applicant> list = (List<Applicant>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Applicant applicant : list) {
				if ((companyId != applicant.getCompanyId()) ||
						(groupId != applicant.getGroupId()) ||
						(jobId != applicant.getJobId()) ||
						!StringUtil.wildcardMatches(applicant.getName(), name,
							CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, false) ||
						!StringUtil.wildcardMatches(applicant.getStatus(),
							status, CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, false)) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(7 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(7);
			}

			query.append(_SQL_SELECT_APPLICANT_WHERE);

			query.append(_FINDER_COLUMN_FILTERS_COMPANYID_2);

			query.append(_FINDER_COLUMN_FILTERS_GROUPID_2);

			query.append(_FINDER_COLUMN_FILTERS_JOBID_2);

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

			boolean bindStatus = false;

			if (status == null) {
				query.append(_FINDER_COLUMN_FILTERS_STATUS_1);
			}
			else if (status.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FILTERS_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_FILTERS_STATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ApplicantModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(jobId);

				if (bindName) {
					qPos.add(name.toLowerCase());
				}

				if (bindStatus) {
					qPos.add(status.toLowerCase());
				}

				if (!pagination) {
					list = (List<Applicant>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Applicant>(list);
				}
				else {
					list = (List<Applicant>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first applicant in the ordered set where companyId = &#63; and groupId = &#63; and jobId = &#63; and name LIKE &#63; and status LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param jobId the job ID
	 * @param name the name
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching applicant
	 * @throws com.rivetlogic.jobsboard.NoSuchApplicantException if a matching applicant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Applicant findByFilters_First(long companyId, long groupId,
		long jobId, String name, String status,
		OrderByComparator orderByComparator)
		throws NoSuchApplicantException, SystemException {
		Applicant applicant = fetchByFilters_First(companyId, groupId, jobId,
				name, status, orderByComparator);

		if (applicant != null) {
			return applicant;
		}

		StringBundler msg = new StringBundler(12);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", jobId=");
		msg.append(jobId);

		msg.append(", name=");
		msg.append(name);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApplicantException(msg.toString());
	}

	/**
	 * Returns the first applicant in the ordered set where companyId = &#63; and groupId = &#63; and jobId = &#63; and name LIKE &#63; and status LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param jobId the job ID
	 * @param name the name
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching applicant, or <code>null</code> if a matching applicant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Applicant fetchByFilters_First(long companyId, long groupId,
		long jobId, String name, String status,
		OrderByComparator orderByComparator) throws SystemException {
		List<Applicant> list = findByFilters(companyId, groupId, jobId, name,
				status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last applicant in the ordered set where companyId = &#63; and groupId = &#63; and jobId = &#63; and name LIKE &#63; and status LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param jobId the job ID
	 * @param name the name
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching applicant
	 * @throws com.rivetlogic.jobsboard.NoSuchApplicantException if a matching applicant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Applicant findByFilters_Last(long companyId, long groupId,
		long jobId, String name, String status,
		OrderByComparator orderByComparator)
		throws NoSuchApplicantException, SystemException {
		Applicant applicant = fetchByFilters_Last(companyId, groupId, jobId,
				name, status, orderByComparator);

		if (applicant != null) {
			return applicant;
		}

		StringBundler msg = new StringBundler(12);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", jobId=");
		msg.append(jobId);

		msg.append(", name=");
		msg.append(name);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApplicantException(msg.toString());
	}

	/**
	 * Returns the last applicant in the ordered set where companyId = &#63; and groupId = &#63; and jobId = &#63; and name LIKE &#63; and status LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param jobId the job ID
	 * @param name the name
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching applicant, or <code>null</code> if a matching applicant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Applicant fetchByFilters_Last(long companyId, long groupId,
		long jobId, String name, String status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByFilters(companyId, groupId, jobId, name, status);

		if (count == 0) {
			return null;
		}

		List<Applicant> list = findByFilters(companyId, groupId, jobId, name,
				status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the applicants before and after the current applicant in the ordered set where companyId = &#63; and groupId = &#63; and jobId = &#63; and name LIKE &#63; and status LIKE &#63;.
	 *
	 * @param applicantId the primary key of the current applicant
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param jobId the job ID
	 * @param name the name
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next applicant
	 * @throws com.rivetlogic.jobsboard.NoSuchApplicantException if a applicant with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Applicant[] findByFilters_PrevAndNext(long applicantId,
		long companyId, long groupId, long jobId, String name, String status,
		OrderByComparator orderByComparator)
		throws NoSuchApplicantException, SystemException {
		Applicant applicant = findByPrimaryKey(applicantId);

		Session session = null;

		try {
			session = openSession();

			Applicant[] array = new ApplicantImpl[3];

			array[0] = getByFilters_PrevAndNext(session, applicant, companyId,
					groupId, jobId, name, status, orderByComparator, true);

			array[1] = applicant;

			array[2] = getByFilters_PrevAndNext(session, applicant, companyId,
					groupId, jobId, name, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Applicant getByFilters_PrevAndNext(Session session,
		Applicant applicant, long companyId, long groupId, long jobId,
		String name, String status, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_APPLICANT_WHERE);

		query.append(_FINDER_COLUMN_FILTERS_COMPANYID_2);

		query.append(_FINDER_COLUMN_FILTERS_GROUPID_2);

		query.append(_FINDER_COLUMN_FILTERS_JOBID_2);

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

		boolean bindStatus = false;

		if (status == null) {
			query.append(_FINDER_COLUMN_FILTERS_STATUS_1);
		}
		else if (status.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_FILTERS_STATUS_3);
		}
		else {
			bindStatus = true;

			query.append(_FINDER_COLUMN_FILTERS_STATUS_2);
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
			query.append(ApplicantModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		qPos.add(jobId);

		if (bindName) {
			qPos.add(name.toLowerCase());
		}

		if (bindStatus) {
			qPos.add(status.toLowerCase());
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(applicant);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Applicant> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the applicants where companyId = &#63; and groupId = &#63; and jobId = &#63; and name LIKE all &#63; and status LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.ApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param jobId the job ID
	 * @param names the names
	 * @param status the status
	 * @return the matching applicants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Applicant> findByFilters(long companyId, long groupId,
		long jobId, String[] names, String status) throws SystemException {
		return findByFilters(companyId, groupId, jobId, names, status,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the applicants where companyId = &#63; and groupId = &#63; and jobId = &#63; and name LIKE all &#63; and status LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.ApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param jobId the job ID
	 * @param names the names
	 * @param status the status
	 * @param start the lower bound of the range of applicants
	 * @param end the upper bound of the range of applicants (not inclusive)
	 * @return the range of matching applicants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Applicant> findByFilters(long companyId, long groupId,
		long jobId, String[] names, String status, int start, int end)
		throws SystemException {
		return findByFilters(companyId, groupId, jobId, names, status, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the applicants where companyId = &#63; and groupId = &#63; and jobId = &#63; and name LIKE all &#63; and status LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.ApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param jobId the job ID
	 * @param names the names
	 * @param status the status
	 * @param start the lower bound of the range of applicants
	 * @param end the upper bound of the range of applicants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching applicants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Applicant> findByFilters(long companyId, long groupId,
		long jobId, String[] names, String status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if ((names != null) && (names.length == 1)) {
			return findByFilters(companyId, groupId, jobId, names[0], status,
				start, end, orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] {
					companyId, groupId, jobId, StringUtil.merge(names), status
				};
		}
		else {
			finderArgs = new Object[] {
					companyId, groupId, jobId, StringUtil.merge(names), status,
					
					start, end, orderByComparator
				};
		}

		List<Applicant> list = (List<Applicant>)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_FILTERS,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Applicant applicant : list) {
				if ((companyId != applicant.getCompanyId()) ||
						(groupId != applicant.getGroupId()) ||
						(jobId != applicant.getJobId()) ||
						!ArrayUtil.contains(names, applicant.getName()) ||
						!Validator.equals(status, applicant.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_APPLICANT_WHERE);

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

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_FILTERS_JOBID_5);

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

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			if (status == null) {
				query.append(_FINDER_COLUMN_FILTERS_STATUS_4);
			}
			else if (status.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FILTERS_STATUS_6);
			}
			else {
				query.append(_FINDER_COLUMN_FILTERS_STATUS_5);
			}

			conjunctionable = true;

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ApplicantModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(jobId);

				if (names != null) {
					qPos.add(names);
				}

				if (status != null) {
					qPos.add(status);
				}

				if (!pagination) {
					list = (List<Applicant>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Applicant>(list);
				}
				else {
					list = (List<Applicant>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the applicants where companyId = &#63; and groupId = &#63; and jobId = &#63; and name LIKE &#63; and status LIKE &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param jobId the job ID
	 * @param name the name
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByFilters(long companyId, long groupId, long jobId,
		String name, String status) throws SystemException {
		for (Applicant applicant : findByFilters(companyId, groupId, jobId,
				name, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(applicant);
		}
	}

	/**
	 * Returns the number of applicants where companyId = &#63; and groupId = &#63; and jobId = &#63; and name LIKE &#63; and status LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param jobId the job ID
	 * @param name the name
	 * @param status the status
	 * @return the number of matching applicants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByFilters(long companyId, long groupId, long jobId,
		String name, String status) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_FILTERS;

		Object[] finderArgs = new Object[] {
				companyId, groupId, jobId, name, status
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_COUNT_APPLICANT_WHERE);

			query.append(_FINDER_COLUMN_FILTERS_COMPANYID_2);

			query.append(_FINDER_COLUMN_FILTERS_GROUPID_2);

			query.append(_FINDER_COLUMN_FILTERS_JOBID_2);

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

			boolean bindStatus = false;

			if (status == null) {
				query.append(_FINDER_COLUMN_FILTERS_STATUS_1);
			}
			else if (status.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FILTERS_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_FILTERS_STATUS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(jobId);

				if (bindName) {
					qPos.add(name.toLowerCase());
				}

				if (bindStatus) {
					qPos.add(status.toLowerCase());
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
	 * Returns the number of applicants where companyId = &#63; and groupId = &#63; and jobId = &#63; and name LIKE all &#63; and status LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param jobId the job ID
	 * @param names the names
	 * @param status the status
	 * @return the number of matching applicants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByFilters(long companyId, long groupId, long jobId,
		String[] names, String status) throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId, groupId, jobId, StringUtil.merge(names), status
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_FILTERS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_APPLICANT_WHERE);

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

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_FILTERS_JOBID_5);

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

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			if (status == null) {
				query.append(_FINDER_COLUMN_FILTERS_STATUS_4);
			}
			else if (status.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FILTERS_STATUS_6);
			}
			else {
				query.append(_FINDER_COLUMN_FILTERS_STATUS_5);
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

				qPos.add(jobId);

				if (names != null) {
					qPos.add(names);
				}

				if (status != null) {
					qPos.add(status);
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

	private static final String _FINDER_COLUMN_FILTERS_COMPANYID_2 = "applicant.companyId = ? AND ";
	private static final String _FINDER_COLUMN_FILTERS_COMPANYID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_FILTERS_COMPANYID_2) + ")";
	private static final String _FINDER_COLUMN_FILTERS_GROUPID_2 = "applicant.groupId = ? AND ";
	private static final String _FINDER_COLUMN_FILTERS_GROUPID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_FILTERS_GROUPID_2) + ")";
	private static final String _FINDER_COLUMN_FILTERS_JOBID_2 = "applicant.jobId = ? AND ";
	private static final String _FINDER_COLUMN_FILTERS_JOBID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_FILTERS_JOBID_2) + ")";
	private static final String _FINDER_COLUMN_FILTERS_NAME_1 = "applicant.name LIKE NULL AND ";
	private static final String _FINDER_COLUMN_FILTERS_NAME_2 = "lower(applicant.name) LIKE ? AND ";
	private static final String _FINDER_COLUMN_FILTERS_NAME_3 = "(applicant.name IS NULL OR applicant.name LIKE '') AND ";
	private static final String _FINDER_COLUMN_FILTERS_NAME_4 = "(" +
		removeConjunction(_FINDER_COLUMN_FILTERS_NAME_1) + ")";
	private static final String _FINDER_COLUMN_FILTERS_NAME_5 = "(" +
		removeConjunction(_FINDER_COLUMN_FILTERS_NAME_2) + ")";
	private static final String _FINDER_COLUMN_FILTERS_NAME_6 = "(" +
		removeConjunction(_FINDER_COLUMN_FILTERS_NAME_3) + ")";
	private static final String _FINDER_COLUMN_FILTERS_STATUS_1 = "applicant.status LIKE NULL";
	private static final String _FINDER_COLUMN_FILTERS_STATUS_2 = "lower(applicant.status) LIKE ?";
	private static final String _FINDER_COLUMN_FILTERS_STATUS_3 = "(applicant.status IS NULL OR applicant.status LIKE '')";
	private static final String _FINDER_COLUMN_FILTERS_STATUS_4 = "(" +
		removeConjunction(_FINDER_COLUMN_FILTERS_STATUS_1) + ")";
	private static final String _FINDER_COLUMN_FILTERS_STATUS_5 = "(" +
		removeConjunction(_FINDER_COLUMN_FILTERS_STATUS_2) + ")";
	private static final String _FINDER_COLUMN_FILTERS_STATUS_6 = "(" +
		removeConjunction(_FINDER_COLUMN_FILTERS_STATUS_3) + ")";

	public ApplicantPersistenceImpl() {
		setModelClass(Applicant.class);
	}

	/**
	 * Caches the applicant in the entity cache if it is enabled.
	 *
	 * @param applicant the applicant
	 */
	@Override
	public void cacheResult(Applicant applicant) {
		EntityCacheUtil.putResult(ApplicantModelImpl.ENTITY_CACHE_ENABLED,
			ApplicantImpl.class, applicant.getPrimaryKey(), applicant);

		applicant.resetOriginalValues();
	}

	/**
	 * Caches the applicants in the entity cache if it is enabled.
	 *
	 * @param applicants the applicants
	 */
	@Override
	public void cacheResult(List<Applicant> applicants) {
		for (Applicant applicant : applicants) {
			if (EntityCacheUtil.getResult(
						ApplicantModelImpl.ENTITY_CACHE_ENABLED,
						ApplicantImpl.class, applicant.getPrimaryKey()) == null) {
				cacheResult(applicant);
			}
			else {
				applicant.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all applicants.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ApplicantImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ApplicantImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the applicant.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Applicant applicant) {
		EntityCacheUtil.removeResult(ApplicantModelImpl.ENTITY_CACHE_ENABLED,
			ApplicantImpl.class, applicant.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Applicant> applicants) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Applicant applicant : applicants) {
			EntityCacheUtil.removeResult(ApplicantModelImpl.ENTITY_CACHE_ENABLED,
				ApplicantImpl.class, applicant.getPrimaryKey());
		}
	}

	/**
	 * Creates a new applicant with the primary key. Does not add the applicant to the database.
	 *
	 * @param applicantId the primary key for the new applicant
	 * @return the new applicant
	 */
	@Override
	public Applicant create(long applicantId) {
		Applicant applicant = new ApplicantImpl();

		applicant.setNew(true);
		applicant.setPrimaryKey(applicantId);

		return applicant;
	}

	/**
	 * Removes the applicant with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param applicantId the primary key of the applicant
	 * @return the applicant that was removed
	 * @throws com.rivetlogic.jobsboard.NoSuchApplicantException if a applicant with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Applicant remove(long applicantId)
		throws NoSuchApplicantException, SystemException {
		return remove((Serializable)applicantId);
	}

	/**
	 * Removes the applicant with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the applicant
	 * @return the applicant that was removed
	 * @throws com.rivetlogic.jobsboard.NoSuchApplicantException if a applicant with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Applicant remove(Serializable primaryKey)
		throws NoSuchApplicantException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Applicant applicant = (Applicant)session.get(ApplicantImpl.class,
					primaryKey);

			if (applicant == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchApplicantException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(applicant);
		}
		catch (NoSuchApplicantException nsee) {
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
	protected Applicant removeImpl(Applicant applicant)
		throws SystemException {
		applicant = toUnwrappedModel(applicant);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(applicant)) {
				applicant = (Applicant)session.get(ApplicantImpl.class,
						applicant.getPrimaryKeyObj());
			}

			if (applicant != null) {
				session.delete(applicant);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (applicant != null) {
			clearCache(applicant);
		}

		return applicant;
	}

	@Override
	public Applicant updateImpl(
		com.rivetlogic.jobsboard.model.Applicant applicant)
		throws SystemException {
		applicant = toUnwrappedModel(applicant);

		boolean isNew = applicant.isNew();

		ApplicantModelImpl applicantModelImpl = (ApplicantModelImpl)applicant;

		Session session = null;

		try {
			session = openSession();

			if (applicant.isNew()) {
				session.save(applicant);

				applicant.setNew(false);
			}
			else {
				session.merge(applicant);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ApplicantModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((applicantModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUPJOB.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						applicantModelImpl.getOriginalCompanyId(),
						applicantModelImpl.getOriginalGroupId(),
						applicantModelImpl.getOriginalJobId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYGROUPJOB,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUPJOB,
					args);

				args = new Object[] {
						applicantModelImpl.getCompanyId(),
						applicantModelImpl.getGroupId(),
						applicantModelImpl.getJobId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYGROUPJOB,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUPJOB,
					args);
			}
		}

		EntityCacheUtil.putResult(ApplicantModelImpl.ENTITY_CACHE_ENABLED,
			ApplicantImpl.class, applicant.getPrimaryKey(), applicant);

		return applicant;
	}

	protected Applicant toUnwrappedModel(Applicant applicant) {
		if (applicant instanceof ApplicantImpl) {
			return applicant;
		}

		ApplicantImpl applicantImpl = new ApplicantImpl();

		applicantImpl.setNew(applicant.isNew());
		applicantImpl.setPrimaryKey(applicant.getPrimaryKey());

		applicantImpl.setApplicantId(applicant.getApplicantId());
		applicantImpl.setJobId(applicant.getJobId());
		applicantImpl.setGroupId(applicant.getGroupId());
		applicantImpl.setCompanyId(applicant.getCompanyId());
		applicantImpl.setCreateDate(applicant.getCreateDate());
		applicantImpl.setModifiedDate(applicant.getModifiedDate());
		applicantImpl.setName(applicant.getName());
		applicantImpl.setEmail(applicant.getEmail());
		applicantImpl.setPhone(applicant.getPhone());
		applicantImpl.setCv(applicant.getCv());
		applicantImpl.setInfo(applicant.getInfo());
		applicantImpl.setStatus(applicant.getStatus());
		applicantImpl.setNotes(applicant.getNotes());

		return applicantImpl;
	}

	/**
	 * Returns the applicant with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the applicant
	 * @return the applicant
	 * @throws com.rivetlogic.jobsboard.NoSuchApplicantException if a applicant with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Applicant findByPrimaryKey(Serializable primaryKey)
		throws NoSuchApplicantException, SystemException {
		Applicant applicant = fetchByPrimaryKey(primaryKey);

		if (applicant == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchApplicantException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return applicant;
	}

	/**
	 * Returns the applicant with the primary key or throws a {@link com.rivetlogic.jobsboard.NoSuchApplicantException} if it could not be found.
	 *
	 * @param applicantId the primary key of the applicant
	 * @return the applicant
	 * @throws com.rivetlogic.jobsboard.NoSuchApplicantException if a applicant with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Applicant findByPrimaryKey(long applicantId)
		throws NoSuchApplicantException, SystemException {
		return findByPrimaryKey((Serializable)applicantId);
	}

	/**
	 * Returns the applicant with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the applicant
	 * @return the applicant, or <code>null</code> if a applicant with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Applicant fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Applicant applicant = (Applicant)EntityCacheUtil.getResult(ApplicantModelImpl.ENTITY_CACHE_ENABLED,
				ApplicantImpl.class, primaryKey);

		if (applicant == _nullApplicant) {
			return null;
		}

		if (applicant == null) {
			Session session = null;

			try {
				session = openSession();

				applicant = (Applicant)session.get(ApplicantImpl.class,
						primaryKey);

				if (applicant != null) {
					cacheResult(applicant);
				}
				else {
					EntityCacheUtil.putResult(ApplicantModelImpl.ENTITY_CACHE_ENABLED,
						ApplicantImpl.class, primaryKey, _nullApplicant);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ApplicantModelImpl.ENTITY_CACHE_ENABLED,
					ApplicantImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return applicant;
	}

	/**
	 * Returns the applicant with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param applicantId the primary key of the applicant
	 * @return the applicant, or <code>null</code> if a applicant with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Applicant fetchByPrimaryKey(long applicantId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)applicantId);
	}

	/**
	 * Returns all the applicants.
	 *
	 * @return the applicants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Applicant> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the applicants.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.ApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of applicants
	 * @param end the upper bound of the range of applicants (not inclusive)
	 * @return the range of applicants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Applicant> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the applicants.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.ApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of applicants
	 * @param end the upper bound of the range of applicants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of applicants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Applicant> findAll(int start, int end,
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

		List<Applicant> list = (List<Applicant>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_APPLICANT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_APPLICANT;

				if (pagination) {
					sql = sql.concat(ApplicantModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Applicant>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Applicant>(list);
				}
				else {
					list = (List<Applicant>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the applicants from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Applicant applicant : findAll()) {
			remove(applicant);
		}
	}

	/**
	 * Returns the number of applicants.
	 *
	 * @return the number of applicants
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

				Query q = session.createQuery(_SQL_COUNT_APPLICANT);

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
	 * Initializes the applicant persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rivetlogic.jobsboard.model.Applicant")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Applicant>> listenersList = new ArrayList<ModelListener<Applicant>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Applicant>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ApplicantImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_APPLICANT = "SELECT applicant FROM Applicant applicant";
	private static final String _SQL_SELECT_APPLICANT_WHERE = "SELECT applicant FROM Applicant applicant WHERE ";
	private static final String _SQL_COUNT_APPLICANT = "SELECT COUNT(applicant) FROM Applicant applicant";
	private static final String _SQL_COUNT_APPLICANT_WHERE = "SELECT COUNT(applicant) FROM Applicant applicant WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "applicant.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Applicant exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Applicant exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ApplicantPersistenceImpl.class);
	private static Applicant _nullApplicant = new ApplicantImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Applicant> toCacheModel() {
				return _nullApplicantCacheModel;
			}
		};

	private static CacheModel<Applicant> _nullApplicantCacheModel = new CacheModel<Applicant>() {
			@Override
			public Applicant toEntityModel() {
				return _nullApplicant;
			}
		};
}