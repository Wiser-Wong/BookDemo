package com.wiser.bookdemo.frame;

import com.wiser.bookdemo.frame.manage.MManage;
import com.wiser.bookdemo.frame.manage.permission.IMPermissionManage;
import com.wiser.bookdemo.frame.manage.toast.MToastManage;
import com.wiser.library.helper.WISERHelper;

/**
 * @author Wiser
 * 
 *         扩展帮助类
 */
public class MHelper extends WISERHelper {

	/**
	 * 权限管理
	 *
	 * @return
	 */
	public static IMPermissionManage permission() {
		MManage mManage = getManage();
		return mManage.permission();
	}

	/**
	 * Toast
	 * 
	 * @return
	 */
	public static MToastManage toast() {
		MManage mManage = getManage();
		return mManage.toastManage();
	}
}
