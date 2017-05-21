package ru.dvs.eshop.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import butterknife.ButterKnife
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.dvs.eshop.R
import ru.dvs.eshop.data.App
import ru.dvs.eshop.data.components.eshop.vendor.ItemInputResponse
import ru.dvs.eshop.data.components.eshop.vendor.Vendor


class MainActivity : AppCompatActivity() {
    var posts: ArrayList<Vendor>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)

        App.api!!.getItem(1).enqueue(object : Callback<ItemInputResponse> {
            override fun onResponse(call: Call<ItemInputResponse>, response: Response<ItemInputResponse>) {
                posts = ArrayList()
                //posts!!.addAll(response.body())
            }

            override fun onFailure(call: Call<ItemInputResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, "An error occurred during networking", Toast.LENGTH_SHORT).show()
            }
        })
    }


}
