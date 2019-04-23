package com.wiser.bookdemo.android.view.course.adapter;

import com.wiser.bookdemo.R;
import com.wiser.bookdemo.android.model.CourseCatalogueModel;
import com.wiser.bookdemo.android.view.course.activity.CourseContentActivity;
import com.wiser.bookdemo.frame.MHelper;
import com.wiser.library.adapter.WISERHolder;
import com.wiser.library.adapter.WISERRVAdapter;
import com.wiser.library.base.WISERActivity;
import com.wiser.library.util.WISERCheck;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;

/**
 * @author Wiser
 * 
 *         二级目录填充器
 */
public class CatalogueSecondLevelAdapter extends WISERRVAdapter<CourseCatalogueModel.CourseCatalogueSecondLevelModel, CatalogueSecondLevelAdapter.CatalogueContentHolder> {

	public CatalogueSecondLevelAdapter(WISERActivity mWiserActivity) {
		super(mWiserActivity);
	}

	@Override public CatalogueContentHolder newViewHolder(ViewGroup viewGroup, int type) {
		return new CatalogueContentHolder(inflate(viewGroup, R.layout.course_catalogue_second_level_item));
	}

	public class CatalogueContentHolder extends WISERHolder<CourseCatalogueModel.CourseCatalogueSecondLevelModel> {

		@BindView(R.id.tv_catalogue_content_title) TextView	tvCatalogueTitle;

		@BindView(R.id.tv_catalogue_content_page) TextView	tvCataloguePage;

		public CatalogueContentHolder(@NonNull View itemView) {
			super(itemView);
		}

		@Override public void bindData(final CourseCatalogueModel.CourseCatalogueSecondLevelModel booksCatalogueModel, int position) {
			if (booksCatalogueModel == null) return;
			if (!WISERCheck.isEmpty(booksCatalogueModel.secondLevelTitle)) tvCatalogueTitle.setText(booksCatalogueModel.secondLevelTitle);

			itemView.setOnClickListener(new View.OnClickListener() {

				@Override public void onClick(View v) {
					if (booksCatalogueModel.id == 0) {
						MHelper.toast().show("敬请期待内容上线，感谢！");
					} else {
						CourseContentActivity.intent(booksCatalogueModel.id, booksCatalogueModel.indexSkip);
					}
				}
			});
		}

	}
}
