package com.strangecoder.region

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.strangecoder.region.models.CountryItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class CountryListVPAdapter(private val countries: List<CountryItem>) :
    RecyclerView.Adapter<CountryListVPAdapter.CountryListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryListViewHolder {
        return CountryListViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.country_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CountryListViewHolder, position: Int) {
        holder.bind(countries[position])
    }

    override fun getItemCount() = countries.size

    inner class CountryListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(countryItem: CountryItem) {
            itemView.apply {
                Glide.with(this)
                    .asDrawable()
                    .load(countryItem.flag)
                    .into(findViewById(R.id.flagImage))
                findViewById<TextView>(R.id.countryName).text = countryItem.name
                findViewById<TextView>(R.id.countryCapital).text = resources.getString(
                    R.string.formatted_string,
                    "Capital",
                    countryItem.capital
                )
                findViewById<TextView>(R.id.countryRegion).text = resources.getString(
                    R.string.formatted_string,
                    "Region",
                    countryItem.region
                )
                findViewById<TextView>(R.id.countrySubRegion).text = resources.getString(
                    R.string.formatted_string,
                    "Sub-Region",
                    countryItem.subregion
                )
                findViewById<TextView>(R.id.countryPopulation).text =
                    resources.getString(
                        R.string.formatted_string,
                        "Population",
                        countryItem.population.toString()
                    )
                findViewById<TextView>(R.id.countryBorders).text =
                    resources.getString(
                        R.string.formatted_string,
                        "Borders",
                        Utils.listToString(countryItem.borders)
                    )
                findViewById<TextView>(R.id.countryLanguages).text =
                    resources.getString(
                        R.string.formatted_string,
                        "Languages",
                        Utils.objectListToString(countryItem.languages)
                    )
            }
        }
    }
}