package com.wallpaper.wallpapersurfer.main.ui

import android.content.Context
import android.util.Log
import com.wallpaper.wallpapersurfer.R
import com.wallpaper.wallpapersurfer.api.UnsplashApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainPresenter(private var mainViewInterface: MainViewInterface, private var context: Context): MainPresenterInterface {

    private var page = 1

    override fun loadMore() {
        page++
        Log.d("SonNN", "Load Page $page")
        queryWallpaper(page)
    }

    private val unsplashApiService by lazy {
        UnsplashApiService.create(context)
    }

    private var disposable: CompositeDisposable = CompositeDisposable()

    override fun getWallpaper(page: Int) {
        queryWallpaper(page)
    }

    private fun queryWallpaper(page: Int) {
        disposable.add(unsplashApiService.getPhoto(context.resources.getString(R.string.unsplash_access_key), page, 20, null)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { }
            .doOnError { }
            .doOnComplete { }
            .subscribe(
                { result -> mainViewInterface.displayWallpaper(result, page) },
                { error -> Log.d("SonNN", "Error: " + error.toString())}
            ))
    }

    override fun disposeService() {
        disposable.dispose()
    }
}