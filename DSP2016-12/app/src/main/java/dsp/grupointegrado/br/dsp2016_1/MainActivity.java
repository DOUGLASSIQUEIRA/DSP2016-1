package dsp.grupointegrado.br.dsp2016_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private EditText edtNumero1;
    private EditText edtNumero2;

    private Conexao conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        edtNumero1 = (EditText) findViewById(R.id.edtNumero1);
        edtNumero2 = (EditText) findViewById(R.id.edtNumero2);

        conn = new Conexao(this);
    }

    public void btnSomar (View v) {

        try {

            double vl1 = Double.parseDouble(edtNumero1.getText().toString());
            double vl2 = Double.parseDouble(edtNumero2.getText().toString());
            double soma = vl1 + vl2;

            Toast.makeText(getBaseContext(), "A soma é " + soma, Toast.LENGTH_LONG).show();

        } catch (NumberFormatException e) {

            Toast.makeText(getBaseContext(), "Insira dados válidos", Toast.LENGTH_LONG).show();

        }

    }

    public void btnMultiplicar (View v) {

        Produto p = new Produto();
        p.setNome("Teste ");
        p.setValor(50.0);

        conn.salvaProduto(p);

        Toast.makeText(getBaseContext(),
                "Produto criado", Toast.LENGTH_LONG).show();

    }

    public void btnSubtrair (View v) {

        Toast.makeText(getBaseContext(),
                conn.getProdutos().toString(), Toast.LENGTH_LONG).show();
    }

    public void btnDividir (View v) {
        Intent i = new Intent(this, ListaActivity.class);

        Produto p = new Produto();
        p.setNome("Teste de intent");

        i.putExtra("produto", p);

        this.startActivity(i);
    }

}
