package com.wiser.bookdemo.android.view.course.activity;

import com.wiser.bookdemo.R;
import com.wiser.bookdemo.android.common.IConstants;
import com.wiser.bookdemo.android.view.SpecialActivity;
import com.wiser.library.base.WISERActivity;
import com.wiser.library.base.WISERBuilder;
import com.wiser.library.helper.WISERHelper;
import com.wiser.library.pager.banner.BannerPagerView;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.view.WindowManager;

import butterknife.BindView;

/**
 * @author Wiser
 * 
 *         图书内容展示页面
 */
public class CourseContentActivity extends WISERActivity<CourseContentBiz> implements BannerPagerView.OnPageChangeListener {

	@BindView(R.id.bpv_page) BannerPagerView bpvPage;

	// 跳转
	public static void intent(int type, int indexSkip) {
		Intent intent = new Intent();
		intent.putExtra(IConstants.COURSE_CATALOGUE_TYPE_KEY, type);
		intent.putExtra(IConstants.INDEX_SKIP_KEY, indexSkip);
		WISERHelper.display().intent(CourseContentActivity.class, intent);
	}

	@Override protected WISERBuilder build(WISERBuilder builder) {
		builder.layoutId(R.layout.course_content_act);
		return builder;
	}

	@Override protected void initData(Intent intent) {
		// 是虚拟按键覆盖布局并透明
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

		bpvPage.setFragmentPages(this, biz().switchCourseContent()).setOffsetPageLimit(5).isDot(true).addOnPageChangeListener(this);

		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);// 当前activity强制设置为横屏

	}

	@Override public void onPageScrolled(int i, float v, int i1) {

	}

	@Override public void onPageSelected(int i) {
		if (biz().getIndex() == i) {
			SpecialActivity.intent("视频路径 或者 名称");
		}
	}

	@Override public void onPageScrollStateChanged(int i) {

	}

}
