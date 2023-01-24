package com.example.graphs_nav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.graphs_nav.databinding.ActivityMainBinding.inflate
import com.example.graphs_nav.databinding.FragmentSpecifyBinding
import java.math.BigDecimal


class SpecifyFragment : Fragment(R.layout.fragment_specify) {

    private lateinit var navController: NavController
    private lateinit var recipient: String

    private var _binding: FragmentSpecifyBinding?? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipient = arguments?.getString("recipient").toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSpecifyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        val message = "You are sending a message to $recipient"
        binding.recipient.text = message

        binding.sendBtn.setOnClickListener {

            if (binding.inpiutMessage.text!!.isNotEmpty()) {
                val amount = Message(BigDecimal(binding.inpiutMessage.text.toString()))
                val bundle = bundleOf(
                    "recipient" to recipient,
                    "message" to amount
                )
                navController.navigate(
                    R.id.action_specifyFragment_to_confirmFragment,
                    bundle
                )
            } else
            {
                Toast.makeText(activity, "Type a message to send", Toast.LENGTH_SHORT).show()
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