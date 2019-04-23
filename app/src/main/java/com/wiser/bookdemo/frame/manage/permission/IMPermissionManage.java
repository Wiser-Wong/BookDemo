package com.wiser.bookdemo.frame.manage.permission;

import com.wiser.library.manager.permission.IWISERPermissionCallBack;
import com.wiser.library.manager.permission.IWISERPermissionManage;

import android.app.Activity;

/**
 * @author Wiser
 * 
 *         权限管理
 */
public interface IMPermissionManage extends IWISERPermissionManage {

	int	DEFAULT_PERMISSION	= 1000;

	int	LOCATION_PERMISSION	= 1001;

	void initDefaultPermission(Activity activity, IWISERPermissionCallBack iwiserPermissionCallBack);

	/**
	 * 请求定位权限
	 *
	 * @param activity
	 * @param iwiserPermissionCallBack
	 */
	void requestLocationPermission(Activity activity, IWISERPermissionCallBack iwiserPermissionCallBack);

}
