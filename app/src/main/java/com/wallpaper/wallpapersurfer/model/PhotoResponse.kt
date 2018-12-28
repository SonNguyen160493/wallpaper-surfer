package com.wallpaper.wallpapersurfer.model


data class PhotoResponse(val id: String,
                         val created_at: String,
                         val updated_at: String,
                         val width: Int,
                         val height: Int,
                         val color: String,
                         val description: Any,
                         val urls: Urls,
                         val links: LinkPhoto,
                         val categories: ArrayList<Any>,
                         val sponsored: Boolean,
                         val sponsored_by: Any,
                         val sponsored_impressions_id: Any,
                         val likes: Int,
                         val liked_by_user: Boolean,
                         val current_user_collections: ArrayList<Any>,
                         val slug: Any,
                         val user: User)
