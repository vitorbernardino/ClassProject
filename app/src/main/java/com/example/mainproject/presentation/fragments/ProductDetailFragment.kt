package com.example.mainproject.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.mainproject.R
import com.example.mainproject.commons.extensions.configureToolbar
import com.example.mainproject.data.models.Product


class ProductDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val productBundle = arguments?.getSerializable("data", Product::class.java)



        val name = view.findViewById<TextView>(R.id.tvProductName)
        val price = view.findViewById<TextView>(R.id.tvProductPrice)
        val image = view.findViewById<ImageView>(R.id.imgProduct)


        name.text = productBundle?.name
        price.text = productBundle?.price
        Glide.with(this).load(productBundle?.urlImage).centerCrop().into(image)

        (requireActivity() as AppCompatActivity).configureToolbar("Product Detail", true)
    }


}