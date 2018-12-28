package com.wallpaper.wallpapersurfer.main.ui

import com.wallpaper.wallpapersurfer.model.PhotoResponse

interface MainViewInterface {
    fun displayWallpaper(responses: ArrayList<PhotoResponse>, page: Int)
}