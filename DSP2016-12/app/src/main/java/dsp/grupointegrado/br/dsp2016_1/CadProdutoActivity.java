package dsp.grupointegrado.br.dsp2016_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import dsp.grupointegrado.br.dsp2016_1.dao.ProdutoDAO;
import dsp.grupointegrado.br.dsp2016_1.dao.TipoProdutoDAO;
import dsp.grupointegrado.br.dsp2016_1.model.Produto;
import dsp.grupointegrado.br.dsp2016_1.model.TipoProduto;

public class CadProdutoActivity extends AppCompatActivity {

    private EditText edtId;
    private EditText edtNome;
    private EditText edtValor;

    private Spinner spnTipoProduto;

    private ProdutoDAO produtoDAO;
    private Produto produto;
    private TipoProdutoDAO tpProdutoDao;

    private boolean insert = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_produto);

        produtoDAO = new ProdutoDAO(this);
        tpProdutoDao = new TipoProdutoDAO(this);

        edtId = (EditText) findViewById(R.id.edtId);
        edtNome = (EditText) findViewById(R.id.edtNome);
        edtValor = (EditText) findViewById(R.id.edtValor);

        List<TipoProduto> tiposProduto = tpProdutoDao.listar();

        ArrayAdapter<TipoProduto> adapterTpProduto =
                new ArrayAdapter<TipoProduto>(this, android.R.layout.simple_dropdown_item_1line, tiposProduto);

        spnTipoProduto = (Spinner) findViewById(R.id.spnTipoProduto);
        spnTipoProduto.setAdapter(adapterTpProduto);

        edtId.setEnabled(false);

        try {
            produto = (Produto) getIntent().getSerializableExtra("produto");
            setProduto(produto);
            insert = false;
        } catch (NullPointerException e) {
            Log.e("MSG", "Não veio Produto.");
        }
    }

    public void setProduto (Produto p) {
        edtId.setText(String.valueOf(p.getCod()));

        edtNome.setText(p.getNome());
        edtValor.setText(String.valueOf(p.getValor()));
    }

    public void btnSalvarClick () {
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

    public void btnListarClick () {
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.cadastro, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.mnSalvar:
                    this.btnSalvarClick();
                break;

            case R.id.mnListar:
                    this.btnListarClick();
                break;

        }

        return super.onOptionsItemSelected(item);
    }
}
