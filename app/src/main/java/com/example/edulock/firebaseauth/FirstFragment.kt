package com.example.edulock.firebaseauth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.edulock.R
import com.example.edulock.combine.ChooseUser
import com.example.edulock.databinding.FragmentRegisterKidBinding
import com.google.android.material.button.MaterialButton

class FirstFragment : Fragment() {

    private var _binding: FragmentRegisterKidBinding? = null
    private val binding get() = _binding!!

    override fun onResume() {
        super.onResume()
        val jenKel = resources.getStringArray(R.array.jenKel)
        val jumlahAnak = resources.getStringArray(R.array.jumlahAnak)

        val arrayAdapterFirst = ArrayAdapter(requireContext(), R.layout.dropdown_item, jenKel)
        binding.autoCompleteTextView.setAdapter(arrayAdapterFirst)

        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, jumlahAnak)
        binding.autoCompleteTextView.setAdapter(arrayAdapter)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Inflate the layout for this fragment
        _binding = FragmentRegisterKidBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}