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

    *   **Set up the Node.js Environment in `admin_panel/`:**
        1.  Navigate to the `admin_panel` directory in your terminal.
        2.  Initialize `package.json`:
            ```bash
            npm init -y
            ```
        3.  Install core dependencies:
            ```bash
            npm install express body-parser
            ```
        4.  Install `nodemon` for automatic server restarts during development:
            ```bash
            npm install -D nodemon
            ```
        5.  (Optional but Recommended) Add a script to your `admin_panel/package.json` for easy startup:
            ```json
            "scripts": {
              "start": "node server.js", 
              "dev": "nodemon server.js"
            }
            ```
            (Ensure these are added within the existing `"scripts"` object in `package.json`. If the `start` script already exists from `npm init -y`, you can update it or just add the `dev` script.)
            You can then run the development server using:
            ```bash
            npm run dev
            ```
            (Note: you'll be running this command from within the `admin_panel` directory).

    *   **Choose and Install a Database Driver:**
        *   The current `server.js` has conceptual placeholders for database interaction. You need to select a database (e.g., PostgreSQL, MySQL, MongoDB) and install its corresponding Node.js driver. For example, for PostgreSQL:
            ```bash
            npm install pg
            ```
    *   **Configure Database Connection:**
        *   Update `admin_panel/server.js` (or preferably, use environment variables or a dedicated config file) with your actual database connection details (host, user, password, database name, port). The current code contains commented-out placeholders for this.
    *   **Implement API Endpoints:**
        *   Flesh out the API endpoint stubs in `admin_panel/server.js` with actual database queries and business logic. The current code provides conceptual outlines for authentication and listing categories.
    *   **Implement Authentication and Authorization:**
        *   Develop robust authentication (e.g., using JWT and bcrypt for password hashing) and authorization mechanisms to secure the admin panel.
    *   **Develop Business Logic:**
        *   Implement the core logic for all management features (events, users, bookings, etc.).
    *   **Implement File Upload Functionality:**
        *   Add support for uploading images (e.g., for event banners, user profile pictures if added later).

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
