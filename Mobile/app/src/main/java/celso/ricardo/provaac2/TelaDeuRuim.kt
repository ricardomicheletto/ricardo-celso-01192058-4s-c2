package celso.ricardo.provaac2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class TelaDeuRuim : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_deu_ruim)

        var tvNenhumResultado: TextView = findViewById(R.id.et_nenhum_resultado)

        var id1 = intent.getIntExtra("id1", 0)
        var id2 = intent.getIntExtra("id2", 0)

        var texto = getString(R.string.nenhum_resultado, id1, id2)

        tvNenhumResultado.setText(texto)
    }
}