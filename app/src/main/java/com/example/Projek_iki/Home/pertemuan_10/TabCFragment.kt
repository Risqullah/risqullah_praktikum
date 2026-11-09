package com.example.Projek_iki.Home.pertemuan_10

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.Projek_iki.R
import com.example.Projek_iki.databinding.FragmentTabCBinding

class TabCFragment : Fragment() {
    private var _binding: FragmentTabCBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentTabCBinding.inflate(inflater, container, false)
        return binding.root
    }

    private val productList = listOf(
        ProductModel(
            "Sepatu Running Nike",
            "Rp 850.000",
            "https://picsum.photos/seed/shoe1/400/300"
        ),
        ProductModel(
            "Kemeja Flannel",
            "Rp 320.000",
            "https://picsum.photos/seed/shirt1/400/300"),
        ProductModel(
            "Tas Ransel Laptop",
            "Rp 450.000",
            "https://picsum.photos/seed/bag1/400/300"),
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val productAdapter = ProductAdapter(productList) { selectedItem ->
            Toast.makeText(
                requireContext(),
                "Anda memilih ${selectedItem.name}",
                Toast.LENGTH_SHORT
            ).show()
        }
        binding.rvProducts.apply {
            //layoutManager = GridLayoutManager(requireContext(), 2)
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
            adapter = productAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}