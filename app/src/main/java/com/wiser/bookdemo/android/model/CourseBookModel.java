package com.wiser.bookdemo.android.model;

import android.graphics.Bitmap;
import android.support.annotation.DrawableRes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author Wiser
 * 
 *         课程图书首页数据
 */
public class CourseBookModel {

	@SerializedName("courseImgId") @Expose public @DrawableRes int	courseImgId;

	@SerializedName("courseName") @Expose public String				courseName;

	@SerializedName("courseId") @Expose public int					courseId;

	@SerializedName("photoBitmap") @Expose public Bitmap			photoBitmap;

	public CourseBookModel(@DrawableRes int courseImgId, String courseName, int courseId) {
		this.courseImgId = courseImgId;
		this.courseName = courseName;
		this.courseId = courseId;
	}

}
