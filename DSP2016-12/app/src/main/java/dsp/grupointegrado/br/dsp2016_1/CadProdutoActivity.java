package dsp.grupointegrado.br.dsp2016_1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CadProdutoActivity extends AppCompatActivity {

    private EditText edtId;
    private EditText edtNome;
    private EditText edtValor;

    private ProdutoDAO produtoDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_produto);

        edtId = (EditText) findViewById(R.id.edtId);
        edtNome = (EditText) findViewById(R.id.edtNome);
        edtValor = (EditText) findViewById(R.id.edtValor);

        edtId.setEnabled(false);

        produtoDAO = new ProdutoDAO(this);
    }

    public void btnSalvarClick (View v) {
        Produto p = new Produto();
        p.setNome(edtNome.getText().toString());
        p.setValor(Double.parseDouble(edtValor.getText().toString()));

        try {
            produtoDAO.salvar(p);
        } catch (IllegalAccessException e) {
            Toast.makeText(this, "Erro ao Salvar Produto! =D", Toast.LENGTH_LONG).show();
        }

        Toast.makeText(this, "Produto salvo com sucesso! =D", Toast.LENGTH_LONG).show();
    }

}
