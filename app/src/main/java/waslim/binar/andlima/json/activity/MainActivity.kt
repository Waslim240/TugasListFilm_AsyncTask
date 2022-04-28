package waslim.binar.andlima.json.activity

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import waslim.binar.andlima.json.R
import waslim.binar.andlima.json.adapter.film.AdapterFilm
import waslim.binar.andlima.json.vm.ViewModelFilm

@SuppressLint("StaticFieldLeak")
@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    lateinit var adapterFilm: AdapterFilm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GetDataFilmAsyncTask().execute()

    }


// ====================================================== ASYNCTASK =====================================//


        inner class GetDataFilmAsyncTask : AsyncTask<Void, Void, Void>() {

            lateinit var pdialog : ProgressDialog

            override fun onPreExecute() {
                super.onPreExecute()
                pdialog = ProgressDialog(this@MainActivity)
                pdialog.show()
            }

            override fun doInBackground(vararg p0: Void?): Void? {
                rvFilm.layoutManager = LinearLayoutManager(this@MainActivity)
                adapterFilm = AdapterFilm()
                rvFilm.adapter = adapterFilm

                return null
            }

            override fun onProgressUpdate(vararg values: Void?) {
                super.onProgressUpdate(*values)
            }

            override fun onPostExecute(result: Void?) {
                super.onPostExecute(result)
                pdialog.dismiss()

                val viewModel = ViewModelProvider(this@MainActivity).get(ViewModelFilm::class.java)

                viewModel.getLiveFilmObresver().observe(this@MainActivity, Observer {
                    if (it != null){
                        adapterFilm.setDataFilm(it)
                        adapterFilm.notifyDataSetChanged()
                    }
                })

                viewModel.makeApiFilm()

            }

    }



}