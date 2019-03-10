package simpixie.com.mvpkotlin.presenter

import android.content.Context
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import simpixie.com.mvpkotlin.service.RetrofitService
import simpixie.com.mvpkotlin.model.Item
import simpixie.com.mvpkotlin.model.Solat
import simpixie.com.mvpkotlin.view.ISalatView

class SalatPresenter(context: Context){
    val salatView = context as ISalatView

    fun getDataFromApi(city: String){
        RetrofitService.create()
            .getApi(city)
            .enqueue(object : Callback<Solat>{
                override fun onFailure(call: Call<Solat>, t: Throwable) {
                    salatView.onDataErrorFromApi(t)
                }

                override fun onResponse(call: Call<Solat>, response: Response<Solat>) {
                    salatView.onDataCompleteFromApi(response.body()?.items?.get(0) as Item)
                    salatView.onDataCityCompleteFromApi(response.body()!!)
                }
            })
    }
}