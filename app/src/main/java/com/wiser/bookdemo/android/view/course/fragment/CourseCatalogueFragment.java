package com.wiser.bookdemo.android.view.course.fragment;

import com.wiser.bookdemo.R;
import com.wiser.bookdemo.android.common.IConstants;
import com.wiser.bookdemo.android.view.course.adapter.CatalogueFirstLevelAdapter;
import com.wiser.library.base.WISERBuilder;
import com.wiser.library.base.WISERFragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.TextView;

import butterknife.BindView;

/**
 * @author Wiser
 * 
 *         目录页面
 */
public class CourseCatalogueFragment extends WISERFragment<CourseCatalogueBiz> {

	@BindView(R.id.tv_common_title) TextView		tvTitle;

	public static CourseCatalogueFragment newInstance(int type, String title) {
		CourseCatalogueFragment courseCatalogueFragment = new CourseCatalogueFragment();
		Bundle bundle = new Bundle();
		bundle.putInt(IConstants.COURSE_KEY, type);
		bundle.putString(IConstants.COURSE_TITLE_KEY, title);
		courseCatalogueFragment.setArguments(bundle);
		return courseCatalogueFragment;
	}

	@Override protected WISERBuilder build(WISERBuilder builder) {
		builder.layoutId(R.layout.course_catalogue_act);
		builder.layoutBarId(R.layout.common_title_layout);
		builder.recycleView().recycleViewId(R.id.rlv_catalogue);
		builder.recycleView().recycleViewLinearManager(LinearLayoutManager.VERTICAL, null);
		builder.recycleView().recycleAdapter(new CatalogueFirstLevelAdapter(this));
		return builder;
	}

	@Override protected void initData(Bundle savedInstanceState) {
		tvTitle.setText(biz().getTitle());
		biz().switchCourse();
	}
}
