package com.example.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.example.auth.databinding.FragmentAuthBinding

class AuthFragment : Fragment() {

    lateinit var binding: FragmentAuthBinding
    private val vModel: VModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAuthBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.button.setOnClickListener {
            if(binding.login.text.toString() == "" || binding.password.text.toString() == "" ||
                binding.login.text.toString().contains("[!\\\"#\$%&'()*+,./:;\\\\\\\\<=>?@\\\\[\\\\]^`{|}~]".toRegex()) ||
                (binding.password.text.toString().length < 4)) {
                val user = User("@&uuuHHkO-^f", "ghwgmffue7")
                vModel.goOn.value = user
            }
            else{
                val user = User(binding.login.text.toString(), binding.password.text.toString())
                vModel.goOn.value = user
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = AuthFragment()
    }
}