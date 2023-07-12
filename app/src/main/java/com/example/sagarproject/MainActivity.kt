package com.example.sagarproject
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.sagarproject.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {


    private val BASEURl = "https://www.googleapis.com/youtube/v3/"
    private val apiKey= "AIzaSyDQnc0tRaT-HiZA61CxKwlEXw3LMpaw3ro"
    private lateinit var apiService: YouTubeService
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Create Retrofit instance
        val retrofit = Retrofit.Builder()
            .baseUrl(BASEURl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // Create YouTubeService instance
        val service = retrofit.create(YouTubeService::class.java)

        binding.getComment.setOnClickListener{

            // Make API call
            val call = service.getComments("snippet","fQYoOokVW48",apiKey)
            call.enqueue(object : Callback<CommentResponse> {
                override fun onResponse(
                    call: Call<CommentResponse>,
                    response: Response<CommentResponse>
                ) {
                    if (response.isSuccessful) {


                        Log.d("Bikash " ,"data is Received ")
                        Log.d("Data Received",response.body().toString())


                    } else {
                        Log.d("Bikash " ,"data Failed ")
                    }
                }

                override fun onFailure(call: Call<CommentResponse>, t: Throwable) {

                    Log.d("Bikash " ,"Failure Method Called  "+t.message)
                }
            })

        }


    }

    }





