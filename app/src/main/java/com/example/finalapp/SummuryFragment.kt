package com.example.finalapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.example.finalapp.databinding.FragmentSummuryBinding
import com.example.finalapp.model.TicketViewModel



class SummuryFragment : Fragment() {
    private var binding: FragmentSummuryBinding? = null
    private val sharedViewModel : TicketViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentSummuryBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root }//end View

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            summaryFragment = this@SummuryFragment
        }//end apply
    }//end onViewCreated
    fun sendOrder() {
        Toast.makeText(activity, "Confirm Order", Toast.LENGTH_SHORT).show() }// end sendOrder

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null }//onDestroyView
}// end summaryFragment