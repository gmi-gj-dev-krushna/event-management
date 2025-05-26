package com.example.eventmanagementapp.repositories

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.example.eventmanagementapp.data.model.User
import kotlinx.coroutines.tasks.await
import java.lang.Exception // Added for clarity, though often implicitly available

class AuthRepository(
    private val firebaseAuth: FirebaseAuth,
    private val firestore: FirebaseFirestore
) {

    /**
     * Attempts to register a new user with the provided email and password.
     *
     * @param email The user's email address.
     * @param pass The user's chosen password.
     * @return Result<FirebaseUser> indicating success with the FirebaseUser object or failure with an Exception.
     */
    suspend fun registerUser(email: String, pass: String): Result<FirebaseUser> {
        return try {
            val authResult = firebaseAuth.createUserWithEmailAndPassword(email, pass).await()
            // Check if authResult.user is null, which can happen in rare cases or if the process is interrupted.
            authResult.user?.let {
                Result.success(it)
            } ?: Result.failure(Exception("Firebase user is null after successful registration attempt."))
        } catch (e: Exception) {
            // Catch any exceptions from createUserWithEmailAndPassword (e.g., network issues, weak password, email already in use)
            Result.failure(e)
        }
    }

    /**
     * Saves user details to the Firestore "users" collection.
     * The document ID will be the user's unique ID (Firebase UID).
     *
     * @param user The User data model object containing user details.
     * @return Result<Unit> indicating success or failure with an Exception.
     */
    suspend fun saveUserDetails(user: User): Result<Unit> {
        return try {
            // Attempt to save the user object to Firestore.
            // The document will be named with user.userId, and the content will be the user object.
            firestore.collection("users").document(user.userId).set(user).await()
            Result.success(Unit) // Indicate success with no specific return value (Unit).
        } catch (e: Exception) {
            // Catch any exceptions from the Firestore operation (e.g., network issues, permissions).
            Result.failure(e)
        }
    }

    /**
     * Attempts to log in an existing user with the provided email and password.
     *
     * @param email The user's email address.
     * @param pass The user's password.
     * @return Result<FirebaseUser> indicating success with the FirebaseUser object or failure with an Exception.
     */
    suspend fun loginUser(email: String, pass: String): Result<FirebaseUser> {
        return try {
            val authResult = firebaseAuth.signInWithEmailAndPassword(email, pass).await()
            authResult.user?.let {
                Result.success(it)
            } ?: Result.failure(Exception("Firebase user is null after login"))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // Future methods for logout, fetching current user, etc., will be added here.
}
