package com.wallpaper.wallpapersurfer.main.ui

interface MainPresenterInterface {
    fun getWallpaper(page: Int)
    fun loadMore()
    fun disposeService()
}