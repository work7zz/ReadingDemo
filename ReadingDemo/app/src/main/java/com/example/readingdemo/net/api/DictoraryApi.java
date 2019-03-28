package com.example.readingdemo.net.api;

import com.example.readingdemo.something.Translation;
import io.reactivex.Observable;

import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by yuzhiqi on 2019/03/03
 *
 * @author 于治麒 yuzhiqi@bytedance.com
 */
public interface DictoraryApi {

    @GET("ajax.php?a=fy&f=auto&t=auto")
    Observable<Translation> getDictorary(@Query("w") String word);

    @GET("ajax.php?a=fy")
    Observable<Translation> getDictorary(@Query("f")String from,@Query("t")String to,@Query("w")String word);

}
