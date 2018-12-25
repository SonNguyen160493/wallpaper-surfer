package com.wallpaper.wallpapersurfer.model

data class User(val id: String,
                val updated_at: String,
                val username: String,
                val name: String,
                val first_name: String,
                val last_name: String,
                val twitter_username: String,
                val portfolio_url: String,
                val bio: String,
                val location: String,
                val links: LinkUser,
                val profile_image: ProfileImage,
                val instagram_username: String,
                val total_collections: Int,
                val total_likes: Int,
                val totalPhotos: Int,
                val acceptedTos: Boolean)
