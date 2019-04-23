package com.wiser.bookdemo.frame;

import java.util.concurrent.TimeUnit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.wiser.bookdemo.android.http.IHttpConstants;
import com.wiser.bookdemo.frame.manage.MManage;
import com.wiser.library.base.IWISERBind;
import com.wiser.library.manager.WISERManage;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Wiser
 * 
 *         扩展绑定类
 */
public class MBind implements IWISERBind {

	@Override public Retrofit getRetrofit(Retrofit.Builder builder) {
		OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();

		// 超时
		okHttpBuilder.connectTimeout(90, TimeUnit.SECONDS);
		okHttpBuilder.readTimeout(90, TimeUnit.SECONDS);
		okHttpBuilder.writeTimeout(90, TimeUnit.SECONDS);

		builder.client(okHttpBuilder.build());
		builder.baseUrl(IHttpConstants.BASE_URL);
		Gson gson = new GsonBuilder().setLenient().create();
		builder.addConverterFactory(GsonConverterFactory.create(gson));
		builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
		return builder.build();
	}

	@Override public WISERManage getManage() {
		return new MManage();
	}
}
