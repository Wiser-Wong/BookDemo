package com.wiser.bookdemo.android.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author Wiser
 * 
 *         课程图书目录数据
 */
public class CourseCatalogueModel {

	@SerializedName("catalogueList") @Expose public List<CourseCatalogueFirstLevelModel> catalogueList;

	public static class CourseCatalogueFirstLevelModel {

		@SerializedName("firstLevelTitle") @Expose public String						firstLevelTitle;

		@SerializedName("list") @Expose public List<CourseCatalogueSecondLevelModel>	list;
	}

	public static class CourseCatalogueSecondLevelModel {

		@SerializedName("secondLevelTitle") @Expose public String	secondLevelTitle;

		@SerializedName("id") @Expose public int					id;					// 内容通过id 获取对应数据

		@SerializedName("indexSkip") @Expose public int				indexSkip;			// 第几个位置跳转特殊界面

	}

}
