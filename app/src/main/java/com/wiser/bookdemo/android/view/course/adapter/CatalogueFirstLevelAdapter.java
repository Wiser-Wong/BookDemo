package com.wiser.bookdemo.android.view.course.adapter;

import com.wiser.bookdemo.R;
import com.wiser.bookdemo.android.model.CourseCatalogueModel;
import com.wiser.library.adapter.WISERHolder;
import com.wiser.library.adapter.WISERRVAdapter;
import com.wiser.library.base.WISERFragment;
import com.wiser.library.util.WISERCheck;

import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;

/**
 * @author Wiser
 * 
 *         一级目录填充器
 */
public class CatalogueFirstLevelAdapter extends WISERRVAdapter<CourseCatalogueModel.CourseCatalogueFirstLevelModel, CatalogueFirstLevelAdapter.CatalogueHolder> {

	public CatalogueFirstLevelAdapter(WISERFragment mWiserFragment) {
		super(mWiserFragment);
	}

	@Override public CatalogueHolder newViewHolder(ViewGroup viewGroup, int type) {
		return new CatalogueHolder(inflate(viewGroup, R.layout.course_catalogue_first_level_item));
	}

	public class CatalogueHolder extends WISERHolder<CourseCatalogueModel.CourseCatalogueFirstLevelModel> {

		@BindView(R.id.tv_catalogue_title) TextView			tvCatalogueTitle;

		@BindView(R.id.rlv_catalogue_content) RecyclerView	rlvCatalogueContent;

		public CatalogueHolder(@NonNull View itemView) {
			super(itemView);
		}

		@Override public void bindData(CourseCatalogueModel.CourseCatalogueFirstLevelModel courseCatalogueFirstLevelModel, int position) {
			if (courseCatalogueFirstLevelModel == null) return;
			if (!WISERCheck.isEmpty(courseCatalogueFirstLevelModel.firstLevelTitle)) tvCatalogueTitle.setText(courseCatalogueFirstLevelModel.firstLevelTitle);
			CatalogueSecondLevelAdapter catalogueSecondLevelAdapter = new CatalogueSecondLevelAdapter(activity());
			rlvCatalogueContent.setLayoutManager(new LinearLayoutManager(activity()));
			rlvCatalogueContent.addItemDecoration(new DividerItemDecoration(activity(), LinearLayoutManager.VERTICAL));
			rlvCatalogueContent.setAdapter(catalogueSecondLevelAdapter);
			catalogueSecondLevelAdapter.setItems(courseCatalogueFirstLevelModel.list);
		}
	}
}
