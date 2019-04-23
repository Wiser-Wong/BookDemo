package com.wiser.bookdemo.android.view.course.activity;

import java.util.ArrayList;
import java.util.List;

import com.wiser.bookdemo.R;
import com.wiser.bookdemo.android.common.IConstants;
import com.wiser.bookdemo.android.model.CourseBookModel;
import com.wiser.library.base.WISERBiz;

/**
 * @author Wiser
 * 
 *         首页业务
 */
public class HomeBiz extends WISERBiz<HomeActivity> {

	// 课程封页图片资源id
	private int[]		courseRes	= new int[] { R.mipmap.cover_xx_first_second_grade, R.mipmap.cover_xx_three_four_grade, R.mipmap.cover_xx_five_six_grade, R.mipmap.cover_chzh, R.mipmap.cover_gzh,
			R.mipmap.cover_university };

	// 课程名称
	private String[]	courseNames	= new String[] { "小学1-2年级版", "小学3-4年级版", "小学5-6年级版", "初中版", "高中版", "大学版" };

	// 课程id
	private int[]		courseIds	= new int[] { IConstants.XX_FIRST_SECOND_GRADE, IConstants.XX_THREE_FOUR_GRADE, IConstants.XX_FIVE_SIX_GRADE, IConstants.JUNIOR_HIGH_SCHOOL,
			IConstants.SENIOR_HIGH_SCHOOL, IConstants.UNIVERSITY };

	/**
	 * 获取首页课程图书展示数据
	 */
	public void getCourseBooksData() {
		List<CourseBookModel> courseBookModels = new ArrayList<>();
		for (int i = 0; i < courseRes.length; i++) {
			courseBookModels.add(new CourseBookModel(courseRes[i], courseNames[i], courseIds[i]));
		}
		ui().setItems(courseBookModels);
	}

}
