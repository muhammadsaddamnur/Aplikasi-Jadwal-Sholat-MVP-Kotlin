package simpixie.com.mvpkotlin.service

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import simpixie.com.mvpkotlin.model.Solat

interface RetrofitService{
    @GET("{city}.json?key=771bdf07c52bc0846dd3932ff30d0c78")
    fun getApi(@Path("city") city:String) : Call<Solat>

    companion object {
        fun create(): RetrofitService {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://muslimsalat.com/")
                .build()
            return retrofit.create(RetrofitService::class.java)
        }
    }
}