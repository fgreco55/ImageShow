package com.example.imageshow.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import coil.load
import coil.transform.BlurTransformation
import coil.transform.CircleCropTransformation
import com.example.imageshow.R
import kotlin.random.Random
import kotlin.random.nextInt

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var myimage: ImageView
    private lateinit var myroot: View
    private lateinit var next: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        myroot = inflater.inflate(R.layout.main_fragment, container, false)

        myimage = myroot.findViewById(R.id.imageView)
        next = myroot.findViewById(R.id.nextButton)

        return myroot
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        nextImage()

        // When Submit button clicked/touched ---------------------------------
        next.setOnClickListener {
            Log.i("Frank", "Inside onClick()")
            nextImage()
        }
    }

    fun nextImage() {
        myimage.load(pickImage())
    }

    fun pickImage() : String {
        val list = listOf (
            "https://www.suhr.com/wp-content/uploads/SKU/01-SIG-0030.jpg",
            "https://www.suhr.com/wp-content/uploads/SKU/01-STP-0041.jpg",
            "https://www.suhr.com/wp-content/uploads/SKU/01-CLS-0001.jpg",
            "https://img.kytary.com/eshop_ie/velky_v2/na/636824679358500000/d61badb1/64621731/prs-dgt-birds-dark-cherry-sunburst.jpg",
            "https://www.suhr.com/wp-content/uploads/SKU/01-ALT-0022.jpg",
            "https://media.guitarcenter.com/is/image/MMGS7/J07969000003000-00-720x720.jpg",
            "https://sc1.musik-produktiv.com/img/guitargallery/thumbs/010123740/010123740_01_1280x1920.jpg",
            "https://media.rainpos.com/8400/prs_dgt_david_grissom_tremolo_electric_guitar_gold_top_3.jpg",
            "https://friedmanamplification.com/images/guitars/Vintage_t/FRIEDMAN-VINTAGE-T--AMVB90_-1600-x-1200-front-min.jpg",
            "https://cdn.mos.cms.futurecdn.net/PFsaMHC88gSz2Czegzs5th-1024-80.jpg.webp"
        )
        var mypick = Random.nextInt(0..list.size-1)   // pick an Int between 0 and the-size-of-the-list-minus-1
        Log.i("Frank", "mypick is $mypick")

        return list.get(mypick)
    }

}