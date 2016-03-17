package dsp.grupointegrado.br.dsp2016_1;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import dsp.grupointegrado.br.dsp2016_1.dao.ProdutoDAO;
import dsp.grupointegrado.br.dsp2016_1.model.Produto;

public class ListaActivity extends Activity {

    private ProdutoDAO produtoDAO;

    private ListView lvProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        lvProdutos = (ListView) findViewById(R.id.lvProdutos);

        produtoDAO = new ProdutoDAO(this);
        final List<Produto> produtoList = produtoDAO.listar();

        ArrayAdapter<Produto> adapterProdutos = new ArrayAdapter<Produto>(this,
                android.R.layout.simple_list_item_1, produtoList);

        lvProdutos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(view.getContext(), "Produto: " + produtoList.get(i).getNome(), Toast.LENGTH_LONG).show();

                return false;
            }
        });

        lvProdutos.setAdapter(adapterProdutos);
    }
}
