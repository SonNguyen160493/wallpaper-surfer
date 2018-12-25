package com.wallpaper.wallpapersurfer.model

import java.util.*

data class User(val id: String,
                val updated_at: String,
                val username: String,
                val name: String,
                val first_name: String,
                val last_name: Any,
                val twitter_username: String,
                val portfolio_url: Any,
                val bio: String,
                val location: String,
                val links: LinkUser,
                val profile_image: ProfileImage,
                val instagram_username: String,
                val total_collections: Int,
                val total_likes: Int,
                val total_photos: Int,
                val accepted_tos: Boolean)
