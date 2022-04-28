package waslim.binar.andlima.json.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Response
import waslim.binar.andlima.json.model.film.GetAllFilmResponseItem
import waslim.binar.andlima.json.network.ApiClient

class ViewModelFilm : ViewModel() {

    var liveDataFilm : MutableLiveData<List<GetAllFilmResponseItem>?> = MutableLiveData()

    fun getLiveFilmObresver() : MutableLiveData<List<GetAllFilmResponseItem>?>{
        return liveDataFilm
    }

    fun makeApiFilm(){
        ApiClient.instance.getAllFilm()
            .enqueue(object : retrofit2.Callback<List<GetAllFilmResponseItem>>{
                override fun onResponse(
                    call: Call<List<GetAllFilmResponseItem>>,
                    response: Response<List<GetAllFilmResponseItem>>
                ) {
                    if (response.isSuccessful){
                        liveDataFilm.postValue(response.body())
                    }else{
                        liveDataFilm.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<GetAllFilmResponseItem>>, t: Throwable) {
                    liveDataFilm.postValue(null)
                }

            })
    }



}