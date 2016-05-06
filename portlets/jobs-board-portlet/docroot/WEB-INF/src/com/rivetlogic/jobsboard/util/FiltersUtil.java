package com.rivetlogic.jobsboard.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.RenderRequest;

public class FiltersUtil {

    public static String[] processKeywords(String keywords) {
        String[] list = keywords.split(" ");
        for(int i = 0; i < list.length; i++) {
            list[i] = StringPool.PERCENT + list[i] + StringPool.PERCENT;
        }
        return list;
    }
    
    // TODO: Always return only active if the user is not logged/admin
    public static boolean[] getStatus(RenderRequest req, ThemeDisplay themeDisplay) {
        String value = ParamUtil.getString(req, "status", "all");
        if(!themeDisplay.isSignedIn()) { // || doesn't have role....
            return new boolean[] { true };
        }else if(Validator.equals(value, "all")) {
            return new boolean[]{ true, false };
        } else {
            return new boolean[]{ Boolean.parseBoolean(value) };
        }
    }
    
    public static long[] getFilter(RenderRequest req, String name, List<AssetCategory> categories) {
       if(Validator.isNull(categories)) {
           return new long[] {};
       }
       String value = ParamUtil.getString(req, name);
       if(Validator.isNull(value) || Validator.equals(value, StringPool.BLANK) || Validator.equals(value, "all")) {
           List<Long> ids = new ArrayList<Long>();
           for(AssetCategory cat : categories) {
               ids.add(cat.getCategoryId());
           }
           return ArrayUtil.toArray(ids.toArray(new Long[]{}));
       } else {
           return new long[] { Long.parseLong(value)};
       }
    }
    
    public static List<AssetCategory> getCategories(ThemeDisplay themeDisplay, String name) throws PortalException, SystemException {
        List<AssetVocabulary> vocabularies = AssetVocabularyLocalServiceUtil
                .getGroupVocabularies(themeDisplay.getScopeGroupId(), false);
        for(AssetVocabulary voc : vocabularies) {
            if(Validator.equals(name, voc.getName())) {
                return voc.getCategories();
            }
        }
        return null;
    }
    
}
