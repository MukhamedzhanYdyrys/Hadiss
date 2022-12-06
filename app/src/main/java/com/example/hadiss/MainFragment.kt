package com.example.hadiss

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.hadiss.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    lateinit var binding: FragmentMainBinding
    private val adapter = AdapterRecyclerView()
    private val viewmodel by viewModels<MainFragmentViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recView.adapter = adapter

        viewmodel.getAllHadeest()
        viewmodel.list.observe(viewLifecycleOwner){
            adapter.setList(it)
        }
    }

}