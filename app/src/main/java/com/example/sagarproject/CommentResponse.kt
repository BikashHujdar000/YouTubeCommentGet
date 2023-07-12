package com.example.sagarproject

data class CommentResponse(
    val etag: String,
    val items: List<Item>,
    val kind: String,
    val pageInfo: PageInfo
)