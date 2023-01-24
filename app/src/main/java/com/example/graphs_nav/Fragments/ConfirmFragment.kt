package com.example.graphs_nav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.graphs_nav.databinding.FragmentConfirmBinding


class ConfirmFragment : Fragment(R.layout.fragment_confirm) {
    private var _binding: FragmentConfirmBinding? = null
    private val binding get() = _binding!!
    private lateinit var recipient: String
    private lateinit var money: Message

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipient = arguments?.getString("recipient").toString()
        money = arguments?.getParcelable("amount")!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentConfirmBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val amount = money.amount
        val confirmationMessage = "Yello, you have sent this --: ${amount}$ to $recipient"
        binding.confirmationMessage.text = confirmationMessage
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}