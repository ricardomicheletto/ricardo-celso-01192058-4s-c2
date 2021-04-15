package celso.ricardo.provaac2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class TelaResultado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_resultado)

        var tvCachorro1:TextView = findViewById(R.id.tv_cachorro1)
        var tvCachorro2:TextView = findViewById(R.id.tv_cachorro2)
        var tvValorTotal:TextView = findViewById(R.id.tv_valor_total)

        var naoEncontrou1 = intent.getBooleanExtra("naoEncontrou1", false)
        var naoEncontrou2 = intent.getBooleanExtra("naoEncontrou2", false)
        var valorMedioCachorro1 = intent.getIntExtra("precoMedioCachorro1",0)
        var valorMedioCachorro2 = intent.getIntExtra("precoMedioCachorro2",0)

        if(naoEncontrou1){
            tvCachorro1.setText(R.string.cachorro1 + R.string.nao_encontrado)
        }

        if(naoEncontrou2){
            tvCachorro2.setText(R.string.cachorro2 + R.string.nao_encontrado)
        }

        var valor = getString(R.string.valor_total, (valorMedioCachorro1 + valorMedioCachorro2))

        tvValorTotal.setText(valor)
    }
}