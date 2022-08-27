package com.example.finalapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.finalapp.databinding.FragmentTicketBinding
import com.example.finalapp.model.TicketViewModel


class TicketFragment : Fragment() {
    private var binding: FragmentTicketBinding? = null
    // reference to the shared view model
    private val sharedViewModel : TicketViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentTicketBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.ticketFragment = this
    }

    /**
     * Start an order with the desired quantity of cupcakes and navigate to the next screen.
     */
    fun orderTicket(quantity: Int) {
        sharedViewModel.setQuantity(quantity)
        // Nav Controller, Navigation action
        findNavController().navigate(R.id.action_ticketFragment_to_summuryFragment)
    }

    /**
     * This fragment lifecycle method is called when the view hierarchy associated with the fragment
     * is being removed. As a result, clear out the binding object.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}