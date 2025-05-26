package com.example.eventmanagementapp.ui.auth

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
// import android.widget.ProgressBar // Import ProgressBar if you add it to XML
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.eventmanagementapp.databinding.FragmentRegisterBinding
import com.example.eventmanagementapp.viewmodels.AuthViewModel
import com.example.eventmanagementapp.viewmodels.AuthViewModelFactory

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    private lateinit var authViewModel: AuthViewModel
    // private lateinit var progressBar: ProgressBar // Declare ProgressBar if you add it

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize ViewModel
        authViewModel = ViewModelProvider(this, AuthViewModelFactory())[AuthViewModel::class.java]

        // Example: progressBar = binding.myProgressBar // Initialize if you added a ProgressBar with this ID
        // Make sure to add a ProgressBar to fragment_register.xml if you want to use it.
        // For now, progress indication will be via Toasts.

        setupUIListeners()
        observeViewModel()
    }

    private fun setupUIListeners() {
        binding.buttonRegister.setOnClickListener {
            val email = binding.editTextEmail.text.toString().trim()
            val password = binding.editTextPassword.text.toString().trim()
            val confirmPassword = binding.editTextConfirmPassword.text.toString().trim()

            if (validateInput(email, password, confirmPassword)) {
                // Show progress indication (e.g., progressBar.visibility = View.VISIBLE)
                Toast.makeText(context, "Registering...", Toast.LENGTH_SHORT).show()
                authViewModel.registerUser(email, password, null) // Passing null for displayName
            }
        }

        binding.textViewLoginLink.setOnClickListener {
            // Handle navigation to LoginFragment later
            Toast.makeText(context, "Navigate to Login Screen", Toast.LENGTH_SHORT).show()
            // Example: findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
    }

    private fun validateInput(email: String, pass: String, confirmPass: String): Boolean {
        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.textFieldEmail.error = "Enter a valid email"
            binding.editTextEmail.requestFocus()
            return false
        } else {
            binding.textFieldEmail.error = null
        }

        if (pass.isEmpty() || pass.length < 6) {
            binding.textFieldPassword.error = "Password must be at least 6 characters"
            binding.editTextPassword.requestFocus()
            return false
        } else {
            binding.textFieldPassword.error = null
        }

        if (confirmPass.isEmpty()) {
            binding.textFieldConfirmPassword.error = "Please confirm your password"
            binding.editTextConfirmPassword.requestFocus()
            return false
        } else if (confirmPass != pass) {
            binding.textFieldConfirmPassword.error = "Passwords do not match"
            binding.editTextConfirmPassword.requestFocus()
            return false
        } else {
            binding.textFieldConfirmPassword.error = null
        }
        return true
    }

    private fun observeViewModel() {
        authViewModel.registrationStatus.observe(viewLifecycleOwner) { result ->
            // Hide progress indication (e.g., progressBar.visibility = View.GONE)
            result.onSuccess { firebaseUser ->
                // This is a good place to log or confirm Firebase Auth user creation if needed
                // Log.d("RegisterFragment", "Firebase Auth user created: ${firebaseUser.uid}")
                // The actual "Registration Successful" message will be shown after Firestore save.
            }.onFailure { exception ->
                Toast.makeText(context, "Registration Failed: ${exception.message}", Toast.LENGTH_LONG).show()
            }
        }

        authViewModel.saveUserStatus.observe(viewLifecycleOwner) { result ->
            // Hide progress indication (e.g., progressBar.visibility = View.GONE)
            result.onSuccess {
                Toast.makeText(context, "Registration Successful! User details saved.", Toast.LENGTH_LONG).show()
                // TODO: Navigate to another screen (e.g., Login or Main)
                // Example: findNavController().navigate(R.id.action_registerFragment_to_mainFragment)
            }.onFailure { exception ->
                Toast.makeText(context, "User details save failed: ${exception.message}", Toast.LENGTH_LONG).show()
                // Consider more sophisticated error handling here, e.g., offer to retry saving,
                // or if critical, attempt to delete the Firebase Auth user if Firestore save consistently fails.
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
