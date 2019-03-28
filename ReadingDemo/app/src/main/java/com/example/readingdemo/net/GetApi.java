package com.example.readingdemo.net;

import com.example.readingdemo.net.api.DictoraryApi;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yuzhiqi on 2019/03/06
 *
 * @author 于治麒 yuzhiqi@bytedance.com
 */
public class GetApi {
    private static volatile DictoraryApi mDictionaryApi;

    public static DictoraryApi getDictionaryApi(){
        if(mDictionaryApi == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://fy.iciba.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
            mDictionaryApi = retrofit.create(DictoraryApi.class);
        }
        return mDictionaryApi;
    }
}
