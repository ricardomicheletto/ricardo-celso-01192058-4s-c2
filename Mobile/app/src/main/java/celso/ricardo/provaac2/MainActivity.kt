package celso.ricardo.provaac2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    var naoEncontrou1: Boolean = false
    var naoEncontrou2: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun comprar(view: View) {
        var etCachorro1:EditText = findViewById(R.id.et_cachorro1)
        var etCachorro2:EditText = findViewById(R.id.et_cachorro2)

        var id1 = etCachorro1.text.toString().toInt()
        var id2 = etCachorro2.text.toString().toInt()

        val telaResultado = Intent(this, TelaResultado::class.java)
        val telaDeuRuim = Intent(this, TelaDeuRuim::class.java)

        val apiCachorros = ConexaoApiCachorros.criar()

        apiCachorros.get(id1).enqueue(object : Callback<Cachorro>{
            override fun onResponse(call: Call<Cachorro>, response: Response<Cachorro>) {
                if(response.code() == 404){
                    naoEncontrou1 = true
                    telaResultado.putExtra("precoMedioCachorro1", 0)
                }else{
                    telaResultado.putExtra("precoMedioCachorro1", response.body()!!.precoMedio)
                }
            }

            override fun onFailure(call: Call<Cachorro>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
            }
        })

        apiCachorros.get(id2).enqueue(object : Callback<Cachorro>{
            override fun onResponse(call: Call<Cachorro>, response: Response<Cachorro>) {
                if(response.code() == 404){
                    naoEncontrou2 = true
                    telaResultado.putExtra("precoMedioCachorro2", 0)
                }else{
                    telaResultado.putExtra("precoMedioCachorro2", response.body()!!.precoMedio)
                }
            }

            override fun onFailure(call: Call<Cachorro>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
            }
        })

        if(naoEncontrou1 && naoEncontrou2){
            telaDeuRuim.putExtra("id1", etCachorro1.text.toString().toInt())
            telaDeuRuim.putExtra("id2", etCachorro2.text.toString().toInt())
            startActivity(telaDeuRuim)
        }else{
            telaResultado.putExtra("naoEncontrou1", naoEncontrou1)
            telaResultado.putExtra("naoEncontrou2", naoEncontrou2)
            startActivity(telaResultado)
        }
    }
}