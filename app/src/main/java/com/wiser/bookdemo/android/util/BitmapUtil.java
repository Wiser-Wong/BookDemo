package com.wiser.bookdemo.android.util;

import com.wiser.library.util.WISERApp;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

/**
 * @author Wiser
 *
 */
public class BitmapUtil {

	/**
	 * 获取图片真实宽高
	 * 
	 * @param iv
	 * @return
	 */
	public static int[] getImageRealWH(ImageView iv) {

		// 获得ImageView中Image的真实宽高，
		int dw = iv.getDrawable().getBounds().width();
		int dh = iv.getDrawable().getBounds().height();
		Log.d("wiser", "drawable_X = " + dw + ", drawable_Y = " + dh);

		// 获得ImageView中Image的变换矩阵
		Matrix m = iv.getImageMatrix();
		float[] values = new float[10];
		m.getValues(values);

		// Image在绘制过程中的变换矩阵，从中获得x和y方向的缩放系数
		float sx = values[0];
		float sy = values[4];
		Log.d("wiser", "scale_X = " + sx + ", scale_Y = " + sy);

		int[] imgValues = new int[2];
		// 计算Image在屏幕上实际绘制的宽高
		imgValues[0] = (int) (dw * sx);
		imgValues[1] = (int) (dh * sy);
		Log.d("wiser", "caculate_W = " + imgValues[0] + ", caculate_H = " + imgValues[1]);
		return imgValues;
	}

	/**
	 * 获取View 坐标
	 * 
	 * @param view
	 * @return
	 */
	public static int[] getLayoutPosition(View view) {
		int[] position = new int[4];
		int[] location = new int[2];
		view.getLocationOnScreen(location);
		position[0] = location[0];
		position[1] = location[1] - WISERApp.getStatusBarHeight();
		position[2] = position[0] + view.getWidth();
		position[3] = position[1] + view.getHeight();
		return position;
	}
}
