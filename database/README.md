## Database Schema for Event Management App

This document outlines the database schema for the Event Management Application.

### 1. Users Table

Stores information about registered users (both app users and admins).

-   `user_id` (Primary Key, Auto Increment, Integer)
-   `username` (Unique, Varchar)
-   `password_hash` (Varchar) - Store hashed passwords only.
-   `email` (Unique, Varchar)
-   `full_name` (Varchar)
-   `role` (Enum: 'user', 'admin') - To differentiate between regular users and administrators.
-   `created_at` (Timestamp, Default: Current Timestamp)
-   `updated_at` (Timestamp, Default: Current Timestamp on Update)

### 2. Categories Table

Stores event categories.

-   `category_id` (Primary Key, Auto Increment, Integer)
-   `name` (Varchar) - e.g., "Music", "Sports", "Tech"
-   `description` (Text, Nullable)
-   `created_at` (Timestamp, Default: Current Timestamp)
-   `updated_at` (Timestamp, Default: Current Timestamp on Update)

### 3. Events Table

Stores details about events.

-   `event_id` (Primary Key, Auto Increment, Integer)
-   `title` (Varchar)
-   `description` (Text)
-   `date_time` (Timestamp) - Start date and time of the event.
-   `end_date_time` (Timestamp, Nullable) - End date and time of the event.
-   `location` (Varchar)
-   `category_id` (Foreign Key, References `Categories.category_id`)
-   `organizer_id` (Foreign Key, References `Users.user_id`) - The user who created the event.
-   `capacity` (Integer, Nullable) - Maximum number of attendees.
-   `price` (Decimal, Nullable) - Ticket price.
-   `status` (Enum: 'pending_approval', 'approved', 'rejected', 'cancelled', 'completed') - Default: 'pending_approval'.
-   `banner_image_url` (Varchar, Nullable)
-   `created_at` (Timestamp, Default: Current Timestamp)
-   `updated_at` (Timestamp, Default: Current Timestamp on Update)

### 4. Bookings Table

Stores information about event bookings made by users.

-   `booking_id` (Primary Key, Auto Increment, Integer)
-   `event_id` (Foreign Key, References `Events.event_id`)
-   `user_id` (Foreign Key, References `Users.user_id`)
-   `number_of_tickets` (Integer, Default: 1)
-   `total_price` (Decimal)
-   `booking_date` (Timestamp, Default: Current Timestamp)
-   `status` (Enum: 'confirmed', 'cancelled', 'pending_payment') - Default: 'pending_payment'.
-   `payment_id` (Varchar, Nullable) - Reference to a payment transaction.
-   `updated_at` (Timestamp, Default: Current Timestamp on Update)

### 5. Sliders Table (for Home Page Banner)

Stores images and links for the home page slider/banner in the admin panel.

-   `slider_id` (Primary Key, Auto Increment, Integer)
-   `title` (Varchar, Nullable)
-   `image_url` (Varchar)
-   `link_url` (Varchar, Nullable) - URL to navigate to when the banner is clicked.
-   `display_order` (Integer, Default: 0)
-   `is_active` (Boolean, Default: True)
-   `created_at` (Timestamp, Default: Current Timestamp)
-   `updated_at` (Timestamp, Default: Current Timestamp on Update)

### 6. ContactSubjects Table

Stores subjects for contact messages (e.g., "General Inquiry", "Technical Support").

-   `subject_id` (Primary Key, Auto Increment, Integer)
-   `subject_text` (Varchar, Unique)
-   `created_at` (Timestamp, Default: Current Timestamp)

### 7. Contacts Table

Stores messages submitted through the contact form.

-   `contact_id` (Primary Key, Auto Increment, Integer)
-   `name` (Varchar)
-   `email` (Varchar)
-   `subject_id` (Foreign Key, References `ContactSubjects.subject_id`, Nullable)
-   `message` (Text)
-   `status` (Enum: 'new', 'read', 'archived') - Default: 'new'.
-   `received_at` (Timestamp, Default: Current Timestamp)
-   `notes` (Text, Nullable) - For admin to add notes.

### 8. Notifications Table

Stores notifications to be sent to users or admins.

-   `notification_id` (Primary Key, Auto Increment, Integer)
-   `user_id` (Foreign Key, References `Users.user_id`, Nullable) - If null, it might be a broadcast message.
-   `title` (Varchar)
-   `message` (Text)
-   `type` (Enum: 'event_approval', 'booking_confirmation', 'new_event_category', 'custom')
-   `status` (Enum: 'pending', 'sent', 'failed', 'read') - Default: 'pending'.
-   `scheduled_at` (Timestamp, Nullable) - For scheduled notifications.
-   `sent_at` (Timestamp, Nullable)
-   `created_at` (Timestamp, Default: Current Timestamp)

### 9. ApplicationSettings Table

Stores application-wide settings configurable by the admin.

-   `setting_id` (Primary Key, Auto Increment, Integer)
-   `setting_key` (Varchar, Unique) - e.g., "site_name", "default_currency", "max_bookings_per_user".
-   `setting_value` (Text)
-   `description` (Varchar, Nullable)
-   `created_at` (Timestamp, Default: Current Timestamp)
-   `updated_at` (Timestamp, Default: Current Timestamp on Update)

This schema provides a comprehensive foundation for the event management application.
Relationships are defined using Foreign Keys. Indexing should be considered for frequently queried columns (e.g., foreign keys, dates, status fields) to optimize performance.
