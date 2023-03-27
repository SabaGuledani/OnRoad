package com.example.onroad.fragments.authentification

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.onroad.R
import com.example.onroad.databinding.FragmentRegistration2Binding
import com.google.firebase.database.DatabaseReference

class RegistrationFragment2 : Fragment(R.layout.fragment_registration2) {
    private lateinit var binding: FragmentRegistration2Binding
    private lateinit var dbref: DatabaseReference

    override fun onResume() {
        super.onResume()
        val languages = resources.getStringArray(R.array.languages)
        val arrayAdapter = ArrayAdapter(requireContext(),R.layout.dropdown_item,languages)
        binding.autocompletetext.setAdapter(arrayAdapter)
        binding.autocompletetext2.setAdapter(arrayAdapter)
        binding.autocompletetext3.setAdapter(arrayAdapter)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegistration2Binding.bind(view)

        binding.addLanguages.setOnClickListener{
            if(binding.autocompletetext2.visibility==View.GONE && binding.autocompletetext3.visibility==View.GONE){
                binding.autocompletetext2.visibility = View.VISIBLE
                binding.addLanguage2.visibility = View.VISIBLE
            }else if(binding.autocompletetext2.visibility == View.VISIBLE && binding.autocompletetext3.visibility==View.GONE ){
                binding.autocompletetext3.visibility = View.VISIBLE
                binding.addLanguage3.visibility = View.VISIBLE
            }
        }
    }

}