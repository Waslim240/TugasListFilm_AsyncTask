package waslim.binar.andlima.json.network

import retrofit2.Call
import retrofit2.http.*
import waslim.binar.andlima.json.model.film.GetAllFilmResponseItem

interface ApiService {

    @GET("film")
    fun getAllFilm() : Call<List<GetAllFilmResponseItem>>


}