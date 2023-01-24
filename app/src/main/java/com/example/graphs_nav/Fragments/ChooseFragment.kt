package com.example.graphs_nav

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation

import com.example.graphs_nav.databinding.FragmentChooseBinding


class ChooseFragment : Fragment(R.layout.fragment_choose) {

    private lateinit var navController: NavController

    private var _binding: FragmentChooseBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChooseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        binding.nextBtn.setOnClickListener {
            if (binding.inputRecipient.text!!.isNotEmpty()) {

                val bundle = bundleOf("recipient" to binding.inputRecipient.text.toString())
                navController.navigate(
                    R.id.action_chooseFragment_to_specifyFragment, bundle
                )

            }else{
                Toast.makeText(activity, "Enter a recipient", Toast.LENGTH_SHORT).show()
            }

        }

        binding.cancelBtn.setOnClickListener {
            activity?.onBackPressed()
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}