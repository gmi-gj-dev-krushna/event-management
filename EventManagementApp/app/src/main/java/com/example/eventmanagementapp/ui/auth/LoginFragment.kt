package com.example.eventmanagementapp.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.eventmanagementapp.databinding.FragmentLoginBinding // Assuming this is the generated binding class name

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    // ViewModel will be added later
    // private lateinit var authViewModel: AuthViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { // Return type should be View? as per Fragment lifecycle
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize ViewModel using AuthViewModelFactory later
        // Initialize UI listeners for login button and register link later
        // For example:
        // binding.buttonLogin.setOnClickListener { /* handle login logic */ }
        // binding.textViewRegisterLink.setOnClickListener { /* navigate to RegisterFragment */ }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Crucial to avoid memory leaks by clearing the reference to the binding
    }
}
