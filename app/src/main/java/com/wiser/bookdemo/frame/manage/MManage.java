package com.wiser.bookdemo.frame.manage;

import com.wiser.bookdemo.frame.manage.permission.IMPermissionManage;
import com.wiser.bookdemo.frame.manage.permission.MPermissionManage;
import com.wiser.bookdemo.frame.manage.toast.MToastManage;
import com.wiser.library.base.IWISERBind;
import com.wiser.library.manager.WISERManage;

import android.app.Application;

/**
 * @author Wiser
 * 
 *         扩展管理器
 */
public class MManage extends WISERManage {

	private IMPermissionManage	permissionManage;	// 权限管理

	private MToastManage		toastManage;		// 自定义布局Toast

	@Override public void init(IWISERBind iwiserBind, Application application) {
		super.init(iwiserBind, application);
	}

	/**
	 * 获取权限管理
	 *
	 * @return
	 */
	public IMPermissionManage permission() {
		if (permissionManage == null) synchronized (IMPermissionManage.class) {
			if (permissionManage == null) permissionManage = new MPermissionManage();
		}
		return permissionManage;
	}

	/**
	 * 获取Toast管理
	 *
	 * @return
	 */
	public MToastManage toastManage() {
		if (toastManage == null) synchronized (MToastManage.class) {
			if (toastManage == null) toastManage = new MToastManage();
		}
		return toastManage;
	}

}
