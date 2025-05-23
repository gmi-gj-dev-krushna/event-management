# Android Event Management App & Admin Panel

This project aims to develop a feature-rich Android Event App accompanied by a web-based Admin Panel. Users can create and book events via the Android app, while administrators can manage events, users, categories, and other application aspects through the admin panel.

## Project Structure

The project is organized into two main components:

*   **`admin_panel/`**: Contains the web-based admin panel built with HTML, CSS (Bootstrap), and conceptual JavaScript.
    *   `css/`: Stylesheets (currently empty, intended for `style.css`).
    *   `images/`: Image assets (currently empty).
    *   `js/`: JavaScript files (currently empty, but HTML files link to conceptual JS functions).
    *   `views/`: HTML files for the admin panel interface (dashboard, login, category management, event management, user management, sliders, contacts, bookings, reports, notifications, settings).
    *   `server.js`: A conceptual Node.js Express server outline with API endpoint stubs.
*   **`android_app/`**: Contains the initial structure and conceptual UI layouts for the Android application.
    *   `src/main/res/layout/`: XML layout files outlining basic screens (login, register, event list, event detail, booking, user profile).
*   **`database/`**:
    *   `README.md`: Detailed database schema for the application.
*   **`LICENSE`**: Project license file.

## Current Status & Work Done

This initial phase focuses on setting up the project structure and creating the UI mockups/conceptual outlines for the Admin Panel and the Android App.

**Admin Panel:**
*   Responsive layout using Bootstrap 5.
*   Conceptual backend server (`server.js`) with API stubs for Node.js/Express.
*   UI pages created for:
    *   Login
    *   Dashboard (with placeholders for analytics)
    *   Category Management (list, add, edit)
    *   Event Management (list, create, edit/approve)
    *   User Account Management (list)
    *   Home Slider/Banner Management (list, add)
    *   Contact Subject & Message Management (list, add subject)
    *   Event Booking Management (list)
    *   Reporting (placeholder page)
    *   Notification Management (placeholder page)
    *   Application Settings (placeholder page)
*   The HTML files can be viewed directly in a browser to inspect the UI.

**Android App:**
*   Conceptual XML layout outlines for key screens, providing a structural base for UI development.

**Database:**
*   A comprehensive database schema has been designed and documented.

## Next Steps

This project is currently in the initial design and UI mockup phase. The following steps are crucial for further development:

**1. Admin Panel Backend Development:**
    *   Set up a proper Node.js environment:
        *   Create `package.json` in `admin_panel/` (`npm init -y`).
        *   Install dependencies: `npm install express body-parser pg` (for PostgreSQL, or `mysql2`, `mongodb` etc. depending on DB choice).
        *   Install `nodemon` for development: `npm install -D nodemon`.
    *   Implement the API endpoints defined in `admin_panel/server.js`.
    *   Connect to the chosen database (PostgreSQL, MongoDB, etc.) based on the schema in `database/README.md`.
    *   Implement authentication and authorization (e.g., using JWT or sessions).
    *   Develop business logic for all management features.
    *   Implement file upload functionality for banners/images.

**2. Android App Development:**
    *   Set up a full Android project in Android Studio.
    *   Translate the XML layout outlines into functional Jetpack Compose or XML views.
    *   Develop Kotlin/Java logic for each screen.
    *   Implement API client to communicate with the backend.
    *   Implement user authentication flow.
    *   Build out features for event listing, details, booking, user profiles, etc.

**3. Styling and JavaScript:**
    *   Write custom CSS in `admin_panel/css/style.css` to refine the admin panel's appearance.
    *   Implement client-side JavaScript in `admin_panel/js/` for dynamic UI interactions, form validation, and API calls to the backend.

**4. Testing:**
    *   Implement unit and integration tests for both backend and frontend components.
    *   Conduct thorough user acceptance testing (UAT).

**5. Deployment:**
    *   Prepare both the admin panel (web server) and Android app (APK/App Bundle) for deployment.

## How to View Admin Panel UI Mockups

1.  Clone this repository.
2.  Navigate to the `admin_panel/views/` directory.
3.  Open any of an HTML file (e.g., `index.html`, `login.html`, `categories.html`) directly in your web browser.

**Note:** The admin panel backend (`server.js`) is conceptual. To make it runnable, follow the initial steps in "Admin Panel Backend Development."
