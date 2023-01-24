package com.example.graphs_nav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation

import com.example.graphs_nav.databinding.FragmentMainBinding


class MainFragment : Fragment(R.layout.fragment_main) {
    private lateinit var navController: NavController
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        binding.viewTransactionsBtn.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_transactionFragment)
        }

        binding.sendMessageBtn.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_chooseFragment)
        }

//        binding.viewBalanceBtn.setOnClickListener {
//            navController.navigate(R.id.action_mainFragment_to_balanceFragment)
//        }


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}