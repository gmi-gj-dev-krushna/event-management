package com.example.eventmanagementapp.data.model

/**
 * Data class representing a user in the application.
 *
 * @property userId Unique identifier for the user (e.g., Firebase UID).
 * @property email User's email address (nullable).
 * @property displayName User's display name (nullable).
 * @property profileImageUrl URL for the user's profile picture (nullable).
 */
data class User(
    val userId: String,
    val email: String? = null,
    val displayName: String? = null,
    val profileImageUrl: String? = null
)
