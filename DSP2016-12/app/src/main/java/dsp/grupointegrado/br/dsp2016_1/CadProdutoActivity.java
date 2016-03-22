package dsp.grupointegrado.br.dsp2016_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import dsp.grupointegrado.br.dsp2016_1.dao.ProdutoDAO;
import dsp.grupointegrado.br.dsp2016_1.dao.TipoProdutoDAO;
import dsp.grupointegrado.br.dsp2016_1.model.Produto;
import dsp.grupointegrado.br.dsp2016_1.model.TipoProduto;

public class CadProdutoActivity extends AppCompatActivity {

    private EditText edtId;
    private EditText edtNome;
    private EditText edtValor;

    private ProdutoDAO produtoDAO;
    private Produto produto;
    private boolean insert = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_produto);

        edtId = (EditText) findViewById(R.id.edtId);
        edtNome = (EditText) findViewById(R.id.edtNome);
        edtValor = (EditText) findViewById(R.id.edtValor);

        edtId.setEnabled(false);

        try {
            produto = (Produto) getIntent().getSerializableExtra("produto");
            setProduto(produto);
            insert = false;
        } catch (NullPointerException e) {
            Log.e("MSG", "Não veio Produto.");
        }

        produtoDAO = new ProdutoDAO(this);
    }

    public void setProduto (Produto p) {
        edtId.setText(String.valueOf(p.getCod()));

        edtNome.setText(p.getNome());
        edtValor.setText(String.valueOf(p.getValor()));
    }

    public void btnSalvarClick (View v) {
        try {

            Produto p = this.getProduto();

            if (insert)
                produtoDAO.salvar(p);
            else {
                produtoDAO.alterar(p);
            }

            this.finish();
        } catch (IllegalAccessException e) {
            Toast.makeText(this, "Erro ao Salvar Produto! =D", Toast.LENGTH_LONG).show();
        }

        Toast.makeText(this, "Produto salvo com sucesso! =D", Toast.LENGTH_LONG).show();
    }

    public void btnListarClick (View v) {
        Intent i = new Intent(this, ListaActivity.class);
        startActivity(i);
    }

    public Produto getProduto () {
        Produto p = new Produto();

        try {
            p.setCod(Integer.parseInt(edtId.getText().toString()));
        } catch (Exception e) {}

        p.setNome(edtNome.getText().toString());
        p.setValor(Double.parseDouble(edtValor.getText().toString()));

        return p;
    }

}
