package simpixie.com.mvpkotlin.view

import simpixie.com.mvpkotlin.model.Item
import simpixie.com.mvpkotlin.model.Solat

interface ISalatView{
    fun onDataCompleteFromApi(salat: Item)
    fun onClick(kota: String)
    fun onDataErrorFromApi(throwable: Throwable)
    fun onDataCityCompleteFromApi(kota: Solat)

}