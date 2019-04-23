package com.wiser.bookdemo.android;

import com.wiser.bookdemo.BuildConfig;
import com.wiser.bookdemo.frame.MBind;
import com.wiser.bookdemo.frame.MHelper;

import android.app.Application;

/**
 * @author Wiser
 */
public class IApplication extends Application {

	@Override public void onCreate() {
		super.onCreate();
		// WiserFrame
		MHelper.newBind().setWiserBind(new MBind()).Inject(this, BuildConfig.DEBUG);
	}
}
