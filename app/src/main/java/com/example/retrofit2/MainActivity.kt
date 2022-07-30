package com.example.retrofit2

//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//    }
//}


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
//import com.example.myapplication.api.ApiInterface
//import com.example.myapplication.api.RetrofitClient
//import com.example.myapplication.models.ResponseListUsers
import com.google.gson.Gson
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    lateinit var txtData: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtData = findViewById(R.id.txtData)

        getUserList()
    }

    fun getUserList() {
        var retrofit = RetrofitClient.getInstance()
        var apiInterface = retrofit.create(ApiInterface::class.java)
        lifecycleScope.launchWhenCreated {
            try {
                val response = apiInterface.getAllUsers()
                Toast.makeText(this@MainActivity,"St0",Toast.LENGTH_LONG).show()
                if (response.isSuccessful()) {
                    var json = Gson().toJson(response.body())
                    Toast.makeText(this@MainActivity,"St1",Toast.LENGTH_LONG).show()
                    txtData.setText(json)
                    Toast.makeText(this@MainActivity,"St2",Toast.LENGTH_LONG).show()
                    //if (response.body()?.data?.size!! <= 0) {
                    //    Toast.makeText(this@MainActivity,"No Data ",Toast.LENGTH_LONG).show()
                    //} else {
                    //}
                } else {
                    Toast.makeText(this@MainActivity,response.errorBody().toString(),Toast.LENGTH_LONG).show()
                }
            }catch (Ex:Exception){
                Log.e("Error",Ex.localizedMessage)
            }
        }

    }

}