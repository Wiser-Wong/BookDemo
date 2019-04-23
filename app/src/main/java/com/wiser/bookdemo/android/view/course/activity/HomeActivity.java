package com.wiser.bookdemo.android.view.course.activity;

import com.wiser.anim.AnimTools;
import com.wiser.anim.OpenBookAnimationListener;
import com.wiser.anim.PhotoMeasureModel;
import com.wiser.bookdemo.R;
import com.wiser.bookdemo.android.model.CourseBookModel;
import com.wiser.bookdemo.android.view.course.adapter.HomeCourseAdapter;
import com.wiser.bookdemo.android.view.course.fragment.CourseCatalogueFragment;
import com.wiser.bookdemo.frame.MHelper;
import com.wiser.library.base.WISERActivity;
import com.wiser.library.base.WISERBuilder;

import android.content.Intent;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.TextView;

import butterknife.BindView;


/**
 * @author Wiser
 * 
 *         首页
 */
public class HomeActivity extends WISERActivity<HomeBiz> implements HomeCourseAdapter.OnItemClickListener {

	@BindView(R.id.tv_common_title) TextView			tvTitle;

	@BindView(R.id.fl_cover) FrameLayout				flCover;

	@BindView(R.id.fl_cover_content) FrameLayout		flCoverContent;

	@BindView(R.id.fl_catalogue_content) FrameLayout	flCatalogueContent;

	@BindView(R.id.iv_cover)
    AppCompatImageView ivCover;

	private HomeCourseAdapter							homeCourseAdapter;

	private PhotoMeasureModel photoMeasureModel;

	private boolean										isEndAnim	= true;

	@Override protected WISERBuilder build(WISERBuilder builder) {
		builder.layoutId(R.layout.course_home_act);
		builder.recycleView().recycleViewId(R.id.rlv_course_books);
		builder.recycleView().recycleViewGridManager(2, LinearLayoutManager.VERTICAL, null);
		builder.recycleView().recycleAdapter(homeCourseAdapter = new HomeCourseAdapter(this));
		return builder;
	}

	@Override protected void initData(Intent intent) {
		tvTitle.setText(getResources().getString(R.string.course_home_title));
		homeCourseAdapter.setOnItemClickListener(this);
		biz().getCourseBooksData();
	}

	@Override public void onItemClick(PhotoMeasureModel photoMeasureModel, CourseBookModel courseBookModel) {
		if (courseBookModel == null) return;
		this.photoMeasureModel = photoMeasureModel;
		MHelper.display().commitReplace(R.id.fl_catalogue_content, CourseCatalogueFragment.newInstance(courseBookModel.courseId, courseBookModel.courseName));
		if (!isEndAnim) return;
		isEndAnim = false;
		flCover.setVisibility(View.VISIBLE);
		flCoverContent.setVisibility(View.VISIBLE);
		AnimTools.openBookAnim(photoMeasureModel, ivCover, flCatalogueContent, this, new OpenBookAnimationListener() {

			@Override public void endAnim(Animation animation) {
				super.endAnim(animation);
				isEndAnim = true;
				flCover.setVisibility(View.GONE);
			}
		});
	}

	@Override public void onBackPressed() {
		if (flCoverContent.getVisibility() == View.VISIBLE) {
			if (!isEndAnim) return;
			isEndAnim = false;
			flCover.setVisibility(View.VISIBLE);
			AnimTools.closeBookAnim(photoMeasureModel, ivCover, flCatalogueContent, this, new OpenBookAnimationListener() {

				@Override public void endAnim(Animation animation) {
					flCoverContent.setVisibility(View.GONE);
					isEndAnim = true;
					flCover.setVisibility(View.GONE);
				}
			});
		} else {
			super.onBackPressed();
		}
	}
}
