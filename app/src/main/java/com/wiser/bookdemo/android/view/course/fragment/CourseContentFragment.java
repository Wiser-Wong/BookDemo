package com.wiser.bookdemo.android.view.course.fragment;

import com.wiser.bookdemo.R;
import com.wiser.bookdemo.frame.MHelper;
import com.wiser.library.base.WISERBuilder;
import com.wiser.library.base.WISERFragment;
import com.wiser.library.util.WISERBitmap;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author Wiser
 * 
 *         图书内容展示页面
 */
public class CourseContentFragment extends WISERFragment {

	@BindView(R.id.iv_book_content_pic)
    AppCompatImageView ivBookContentPic;

	private boolean											isShow	= true;

	public static CourseContentFragment newInstance(int previewPhoto) {
		CourseContentFragment courseContentFragment = new CourseContentFragment();
		Bundle bundle = new Bundle();
		bundle.putInt("photoId", previewPhoto);
		courseContentFragment.setArguments(bundle);
		return courseContentFragment;
	}

	@Override protected WISERBuilder build(WISERBuilder builder) {
		builder.layoutId(R.layout.course_content_frg);
		return builder;
	}

	@Override protected void initData(Bundle savedInstanceState) {
		if (savedInstanceState != null) {
			ivBookContentPic.setImageBitmap(WISERBitmap.getResBitmap(MHelper.getActivityManage().getCurrentIsRunningActivity(), savedInstanceState.getInt("photoId")));
		}
		hideVirtualKey();
	}

	@OnClick(value = { R.id.iv_book_content_pic }) public void onClickView(View view) {
		switch (view.getId()) {
			case R.id.iv_book_content_pic:
				if (isShow) {
					isShow = false;
					showVirtualKey();
				} else {
					isShow = true;
					hideVirtualKey();
				}
				break;
		}
	}

	/**
	 * 显示虚拟按键
	 */
	private void showVirtualKey() {
		// 显示虚拟按键
		if (Build.VERSION.SDK_INT < 19) {
			// 低版本sdk
			View v = activity().getWindow().getDecorView();
			v.setSystemUiVisibility(View.VISIBLE);
		} else {
			View decorView = activity().getWindow().getDecorView();
			int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
			decorView.setSystemUiVisibility(uiOptions);
		}
	}

	/**
	 * 隐藏虚拟按键
	 */
	private void hideVirtualKey() {
		// 隐藏虚拟按键
		if (Build.VERSION.SDK_INT < 19) {
			View v = activity().getWindow().getDecorView();
			v.setSystemUiVisibility(View.GONE);
		} else {
			View decorView = activity().getWindow().getDecorView();
			int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_FULLSCREEN;
			decorView.setSystemUiVisibility(uiOptions);
		}
	}
}
