package com.strangecoder.region

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.strangecoder.region.models.CountryItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private var countryList: List<CountryItem>? = null
    private lateinit var countryListAdapter: CountryListVPAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        runBlocking {
            val result = RetrofitService.retrofitService.getCountries()
            withContext(Dispatchers.Default) {
                countryList = result
            }
        }
        val compositePageTransformer = CompositePageTransformer().also {
            it.addTransformer(MarginPageTransformer(22))
        }

        countryListAdapter = CountryListVPAdapter(countryList!!)
        findViewById<ViewPager2>(R.id.countryListViewPager).apply {
            adapter = countryListAdapter
            offscreenPageLimit = 3
            setPageTransformer(compositePageTransformer)
        }
    }
}