package com.wallpaper.wallpapersurfer.api

import android.content.Context
import com.wallpaper.wallpapersurfer.BuildConfig
import com.wallpaper.wallpapersurfer.R
import com.wallpaper.wallpapersurfer.model.PhotoResponse
import com.wallpaper.wallpapersurfer.model.User
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface UnsplashApiService {
    companion object {
        fun create(context: Context): UnsplashApiService {

            val logging = HttpLoggingInterceptor()
            if (BuildConfig.DEBUG)
                logging.level = HttpLoggingInterceptor.Level.BODY
            else
                logging.level = HttpLoggingInterceptor.Level.NONE

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor { chain ->
                    var request = chain.request().newBuilder()
                        .addHeader("client_id", context.resources.getString(R.string.unsplash_access_key))
                        .build()

                    chain.proceed(request)
                }
                .addInterceptor(logging)

            val retrofit = Retrofit.Builder()
//                .client(okHttpClient.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(context.resources.getString(R.string.url))
                .build()

            return retrofit.create(UnsplashApiService::class.java)
        }
    }

    @GET("photos/")
    fun getPhoto(@Query("client_id") clientID: String?, @Query("page") Page: Int?, @Query("per_page") perPage: Int?, @Query("order_by") orderBy: String?) : Observable<ArrayList<PhotoResponse>>
}