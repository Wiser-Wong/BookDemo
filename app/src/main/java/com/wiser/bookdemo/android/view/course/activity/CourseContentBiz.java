package com.wiser.bookdemo.android.view.course.activity;

import java.util.ArrayList;
import java.util.List;

import com.wiser.bookdemo.R;
import com.wiser.bookdemo.android.common.IConstants;
import com.wiser.bookdemo.android.view.course.fragment.CourseContentFragment;
import com.wiser.library.base.WISERBiz;

import android.content.Intent;
import android.support.v4.app.Fragment;

/**
 * @author Wiser
 *
 *         课程内容预演
 */
public class CourseContentBiz extends WISERBiz<CourseContentActivity> {

	private int		contentType;																																							// 内容展示类型

	private int		index					= -1;																																			// 当处于哪页位置
																																															// 跳转到新的Activity
	// 长征组歌

	private int[]	courseLongMarchSongs	= new int[] { R.mipmap.zg1, R.mipmap.zg2, R.mipmap.zg3, R.mipmap.zg4, R.mipmap.zg5, R.mipmap.zg6 };

	// 伟大预演
	private int[]	courseGreatPreviews		= new int[] { R.mipmap.jz1, R.mipmap.jz2, R.mipmap.jz3, R.mipmap.jz4, R.mipmap.jz5, R.mipmap.jz6, R.mipmap.jz7, R.mipmap.jz8, R.mipmap.jz9 };

	public int getIndex() {
		return index;
	}

	@Override public void initBiz(Intent intent) {
		super.initBiz(intent);
		if (intent != null) {
			contentType = intent.getIntExtra(IConstants.COURSE_CATALOGUE_TYPE_KEY, 0);
			index = intent.getIntExtra(IConstants.INDEX_SKIP_KEY, -1);
		}
	}

	// 课程内容
	public List<Fragment> switchCourseContent() {
		// 长征组歌
		if (contentType == IConstants.LONG_MARCH_SONG) {
			return getLongMarchSongFragments();
		}
		// 伟大预演
		if (contentType == IConstants.GREAT_PREVIEW) {
			return getGreatPreviewFragments();
		}
		return null;
	}

	// 获取长江组歌
	private List<Fragment> getLongMarchSongFragments() {
		List<Fragment> fragmentList = new ArrayList<>();
		for (int courseLongMarchSong : courseLongMarchSongs) {
			fragmentList.add(CourseContentFragment.newInstance(courseLongMarchSong));
		}
		return fragmentList;
	}

	// 获取伟大预演
	private List<Fragment> getGreatPreviewFragments() {
		List<Fragment> fragmentList = new ArrayList<>();
		for (int courseGreatPreview : courseGreatPreviews) {
			fragmentList.add(CourseContentFragment.newInstance(courseGreatPreview));
		}
		return fragmentList;
	}
}
