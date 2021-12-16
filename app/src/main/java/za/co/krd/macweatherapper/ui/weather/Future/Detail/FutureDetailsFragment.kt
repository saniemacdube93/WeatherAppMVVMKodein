package za.co.krd.macweatherapper.ui.weather.Future.Detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.future_details_fragment.*
import za.co.krd.macweatherapper.R

class FutureDetailsFragment : Fragment() {

    companion object {
        fun newInstance() = FutureDetailsFragment()
    }

    private lateinit var viewModel: FutureDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.future_details_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FutureDetailsViewModel::class.java)
        // TODO: Use the ViewModel

        letsee.text = requireArguments().getString("temperature")
        textView_min_max_temperature.text  = requireArguments().getString("temperature")
        textView_min_max_temperature.text  = requireArguments().getString("temperature")
    }




}