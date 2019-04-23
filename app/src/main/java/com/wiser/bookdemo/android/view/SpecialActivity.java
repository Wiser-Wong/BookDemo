package com.wiser.bookdemo.android.view;

import com.wiser.bookdemo.R;
import com.wiser.library.base.WISERActivity;
import com.wiser.library.base.WISERBuilder;
import com.wiser.library.helper.WISERHelper;

import android.content.Intent;

/**
 * @author Wiser
 * 
 *         留出来的单独Activity页面
 */
public class SpecialActivity extends WISERActivity {

	public static void intent(String videoName) {
		WISERHelper.display().intent(SpecialActivity.class);
	}

	@Override protected WISERBuilder build(WISERBuilder builder) {
		builder.layoutId(R.layout.special_act);
		builder.swipeBack(true);
		return builder;
	}

	@Override protected void initData(Intent intent) {

	}
}
