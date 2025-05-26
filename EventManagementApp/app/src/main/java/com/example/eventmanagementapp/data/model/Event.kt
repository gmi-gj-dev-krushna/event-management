package com.example.eventmanagementapp.data.model

/**
 * Data class representing an event in the application.
 *
 * @property eventId Unique identifier for the event.
 * @property eventName Name of the event (nullable).
 * @property description Detailed description of the event (nullable).
 * @property dateTime Timestamp representing the date and time of the event (e.g., `System.currentTimeMillis()`).
 * @property location Venue or address of the event (nullable).
 * @property creatorUserId ID of the user who created the event, to link back to the `User` model.
 * @property imageUrl URL for the event's banner image or picture (nullable).
 */
data class Event(
    val eventId: String,
    val eventName: String? = null,
    val description: String? = null,
    val dateTime: Long,
    val location: String? = null,
    val creatorUserId: String,
    val imageUrl: String? = null
)
