package celso.ricardo.provaac2;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path

interface ApiCachorros {
    @GET("cachorros/{id}")
    fun get(@Path("id") id: Int): Call<Cachorro>
}
