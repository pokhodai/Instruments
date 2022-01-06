package com.decorator1889.instruments.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.decorator1889.instruments.R
import com.decorator1889.instruments.databinding.FragmentBoardingBinding
import com.decorator1889.instruments.databinding.FragmentMainBinding

class BoardingFragment : Fragment() {

    private lateinit var binding: FragmentBoardingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentBoardingBinding.inflate(inflater, container, false).apply {
        binding = this
    }.root

}