package com.example.mainproject.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.mainproject.presentation.viewmodels.MainViewModel
import com.example.mainproject.R
import com.example.mainproject.commons.extensions.configureToolbar
import com.example.mainproject.presentation.adapters.ProductAdapter


class HomeFragment : Fragment() {
    private lateinit var adapter: ProductAdapter
    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //view model
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        //recycler
        val recycler = view.findViewById<RecyclerView>(R.id.recycler)

        val items = mainViewModel.getProducts()
        adapter = ProductAdapter(items){
            val bundle = bundleOf("data" to it)
            findNavController().navigate(R.id.action_homeFragment_to_productDetailFragment, bundle)
        }


        recycler.adapter = adapter
        (requireActivity() as AppCompatActivity).configureToolbar("Home", false)
    }
}

