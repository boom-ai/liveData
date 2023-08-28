package com.sanket.livedata

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.sanket.livedata.databinding.FragmentWorkingBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [WorkingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WorkingFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var mainActivity: MainActivity
    lateinit var binding: FragmentWorkingBinding
    lateinit var workingFragment: WorkingFragment

    lateinit var liveDataClass: LiveDataClass
    lateinit var numberViewModel: NumberViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity = activity as MainActivity
        liveDataClass = ViewModelProvider(mainActivity)[LiveDataClass::class.java]
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =FragmentWorkingBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        numberViewModel=ViewModelProvider(mainActivity)[NumberViewModel::class.java
        ]
        var tvnumber = view.findViewById<TextView>(R.id.tvNumber)
        liveDataClass.data.observe(mainActivity) {
            System.out.println("it Value $it")
            tvnumber.setText(it.toString())
        }
        numberViewModel.color.observe(mainActivity){
            System.out.print("in observe method $it")
            when(it){
                1-> binding.layout.setBackgroundColor(ContextCompat.getColor(mainActivity ,R.color.Red))
                2-> binding.layout.setBackgroundColor(ContextCompat.getColor(mainActivity ,R.color.Blue))
                3-> binding.layout.setBackgroundColor(ContextCompat.getColor(mainActivity ,R.color.Green))

            }

        }
        binding.btnReset.setOnClickListener {
            binding.tvNumber.setText("0")
        }
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment WorkingFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            WorkingFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}