package com.wiser.bookdemo.android.view.course.adapter;

import android.graphics.Bitmap;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.wiser.anim.PhotoMeasureModel;
import com.wiser.bookdemo.R;
import com.wiser.bookdemo.android.model.CourseBookModel;
import com.wiser.bookdemo.android.util.BitmapUtil;
import com.wiser.library.adapter.WISERHolder;
import com.wiser.library.adapter.WISERRVAdapter;
import com.wiser.library.base.WISERActivity;
import com.wiser.library.util.WISERCheck;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author Wiser
 * 
 *         首页图书填充器
 */
public class HomeCourseAdapter extends WISERRVAdapter<CourseBookModel, HomeCourseAdapter.BooksHolder> {

	private OnItemClickListener onItemClickListener;

	public HomeCourseAdapter(WISERActivity mWiserActivity) {
		super(mWiserActivity);
	}

	@Override public BooksHolder newViewHolder(ViewGroup viewGroup, int type) {
		return new BooksHolder(inflate(viewGroup, R.layout.course_home_item));
	}

	public class BooksHolder extends WISERHolder<CourseBookModel> {

		@BindView(R.id.iv_book_pic) ImageView	ivBookPic;

		@BindView(R.id.tv_book_name) TextView	tvBookName;

		public BooksHolder(@NonNull View itemView) {
			super(itemView);
		}

		@Override public void bindData(CourseBookModel courseBookModel, final int position) {
			if (courseBookModel == null) return;
			Glide.with(activity()).load(courseBookModel.courseImgId).asBitmap().centerCrop().crossFade().into(new SimpleTarget<Bitmap>() {

				@Override public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
					CourseBookModel bookModel = (CourseBookModel) getItem(position);
					bookModel.photoBitmap = resource;
					getItems().set(position, bookModel);
					ivBookPic.setImageBitmap(resource);
				}
			});
			if (!WISERCheck.isEmpty(courseBookModel.courseName)) tvBookName.setText(courseBookModel.courseName);
		}

		@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP) @OnClick(value = { R.id.iv_book_pic }) public void onClickView(View view) {
			switch (view.getId()) {
				case R.id.iv_book_pic:
					CourseBookModel courseBookModel = (CourseBookModel) getItem(getAdapterPosition());
					if (courseBookModel == null) return;
					int[] valuesPic = BitmapUtil.getImageRealWH(ivBookPic);
					int[] positionPic = BitmapUtil.getLayoutPosition(ivBookPic);
					PhotoMeasureModel photoMeasureModel = new PhotoMeasureModel();
					photoMeasureModel.coverBitmap = ((CourseBookModel) getItem(getAdapterPosition())).photoBitmap;
					photoMeasureModel.coverPicId = courseBookModel.courseImgId;
					photoMeasureModel.width = valuesPic[0];
					photoMeasureModel.height = valuesPic[1];
					photoMeasureModel.left = positionPic[0];
					photoMeasureModel.top = positionPic[1];
					photoMeasureModel.right = positionPic[2];
					photoMeasureModel.bottom = positionPic[3];
					if (onItemClickListener != null) {
						onItemClickListener.onItemClick(photoMeasureModel, courseBookModel);
					}
					break;
			}
		}

	}

	public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
		this.onItemClickListener = onItemClickListener;
	}

	public interface OnItemClickListener {

		void onItemClick(PhotoMeasureModel photoMeasureModel, CourseBookModel courseBookModel);
	}

}
