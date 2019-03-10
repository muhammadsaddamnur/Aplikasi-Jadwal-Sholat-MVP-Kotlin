package simpixie.com.mvpkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import simpixie.com.mvpkotlin.model.Item
import kotlinx.android.synthetic.main.activity_main.*
import simpixie.com.mvpkotlin.model.Solat
import simpixie.com.mvpkotlin.presenter.SalatPresenter
import simpixie.com.mvpkotlin.view.ISalatView

class MainActivity : AppCompatActivity(), ISalatView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        SalatPresenter(this).getDataFromApi("jakarta")

        btnNY.setOnClickListener {
            onClick("newyork")
        }
        btnJakarta.setOnClickListener {
            onClick("jakarta")
        }
    }

    override fun onDataCompleteFromApi(salat: Item) {
        subuh.text = salat.fajr
        dzuhur.text = salat.dhuhr
        asar.text = salat.asr
        magrib.text = salat.maghrib
        isya.text = salat.isha
        txtTanggal.text = salat.dateFor
    }

    override fun onDataErrorFromApi(throwable: Throwable) {
        error("error -------> ${throwable.localizedMessage}")
    }

    override fun onClick(kota: String) {
        SalatPresenter(this).getDataFromApi(kota)
    }

    override fun onDataCityCompleteFromApi(kota: Solat) {
        txtKota.text = kota.state
    }
}
