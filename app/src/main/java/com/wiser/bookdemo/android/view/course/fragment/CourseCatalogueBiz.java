package com.wiser.bookdemo.android.view.course.fragment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.wiser.bookdemo.android.common.IConstants;
import com.wiser.bookdemo.android.model.CourseCatalogueModel;
import com.wiser.library.base.WISERBiz;
import com.wiser.library.util.WISERCheck;
import com.wiser.library.util.WISERGson;

import android.os.Bundle;

/**
 * @author Wiser
 * 
 *         目录业务
 */
public class CourseCatalogueBiz extends WISERBiz<CourseCatalogueFragment> {

	private int		courseType;

	private String	title;

	@Override public void initBiz(Bundle bundle) {
		super.initBiz(bundle);
		if (bundle != null) {
			courseType = bundle.getInt(IConstants.COURSE_KEY);
			title = bundle.getString(IConstants.COURSE_TITLE_KEY);
		}
	}

	public String getTitle() {
		return title;
	}

	// 切换课程目录
	public void switchCourse() {
		switch (courseType) {
			case IConstants.XX_FIRST_SECOND_GRADE:// 小学1、2年级
				getCatalogueData(getAssetJson("catalogue_xx_first_second_grade.json"));
				break;
			case IConstants.XX_THREE_FOUR_GRADE:// 小学3、4年级
				getCatalogueData(getAssetJson("catalogue_xx_three_four_grade.json"));
				break;
			case IConstants.XX_FIVE_SIX_GRADE:// 小学5、6年级
				getCatalogueData(getAssetJson("catalogue_xx_five_six_grade.json"));
				break;
			case IConstants.JUNIOR_HIGH_SCHOOL:// 初中版
				getCatalogueData(getAssetJson("catalogue_chzh.json"));
				break;
			case IConstants.SENIOR_HIGH_SCHOOL:// 高中版
				getCatalogueData(getAssetJson("catalogue_gzh.json"));
				break;
			case IConstants.UNIVERSITY:// 大学版
				getCatalogueData(getAssetJson("catalogue_ten_teach.json"));
				break;
		}
	}

	/**
	 * 获取目录数据
	 */
	private void getCatalogueData(String json) {
		if (WISERCheck.isEmpty(json)) return;
		try {
			CourseCatalogueModel courseCatalogueModel = WISERGson.getData(json, CourseCatalogueModel.class);
			if (courseCatalogueModel == null) return;
			List<CourseCatalogueModel.CourseCatalogueFirstLevelModel> courseCatalogueFirstLevelModels = courseCatalogueModel.catalogueList;
			if (courseCatalogueFirstLevelModels == null || courseCatalogueFirstLevelModels.size() == 0) return;
			ui().setItems(courseCatalogueFirstLevelModels);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 获取asset中json文件
	private String getAssetJson(String assetJsonName) {
		StringBuilder jsonStringBuilder = new StringBuilder();
		InputStream inputStream;
		try {
			inputStream = ui().getResources().getAssets().open(assetJsonName);
			InputStreamReader isr = new InputStreamReader(inputStream);
			BufferedReader reader = new BufferedReader(isr);
			String jsonLine;
			while ((jsonLine = reader.readLine()) != null) {
				jsonStringBuilder.append(jsonLine);
			}
			reader.close();
			isr.close();
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonStringBuilder.toString();
	}

}
