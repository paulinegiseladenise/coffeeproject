package com.example.coffee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//import retrofit2.converter.gson.GsonConverterFactory

//Tillslut lyckades jag byta vy ifrån mainactivity till mainactivity2
// (som förra filen hette countdown) genom att högerklicka på layout
// och create en ny empty activity från scratch.
// Satt hela dagen både inne och ute och tillslut gick det! lyckan! 1-0 till mig.

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val resetBtn = findViewById<Button>(R.id.resetBtn)

        viewModel = ViewModelProvider(this)[UserViewModel::class.java]

        resetBtn.setOnClickListener () {
            val intent = Intent(this, Countdown::class.java)
            startActivity(intent)
        }






        //Nedanför har jag definierat komponenterna / api från resultatsidan.

       val textResult = findViewById<TextView>(R.id.texten)
        val imgcoffee = findViewById<ImageView>(R.id.img_coffee)

        //connect retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl("https://coffee.alexflipnote.dev/dmcuHnUFluY_coffee.jpg/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        //Connection to api
        val service = retrofit.create(CoffeeAPI::class.java)
        val call = service.getResult()



        //Implementation
        call.enqueue(object : Callback<Coffee> {

            //functionality of successfull API
            //provar att ändra om den här raden..... val stringBuilder = "Result2: \n link: ${result2.link} " + "\n file: ${result2.file}"


            override fun onResponse(call: Call<Coffee>, response: Response<Coffee>) {
                //implementerar vår successfully funktionalitet av API
                if (response.isSuccessful) {
                    val result2 = response.body()!! //!! betyder att det inte kommer att bli null, gör som vi säger..the response object svaret jsonsträngen all info
                    val stringBuilder = "Result2: file: ${result2.myFile}"

                    textResult.text = stringBuilder
//load picture into activity
                    Glide.with(this@MainActivity)
                        .load(result2.myFile)
                        .into(imgcoffee)

                    println("The picture is here")

                }
            }


            override fun onFailure(call: Call<Coffee>, t: Throwable) {
                println(t) //t = throwable
            }
        })
    }


}