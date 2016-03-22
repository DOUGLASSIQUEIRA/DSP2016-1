package dsp.grupointegrado.br.dsp2016_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import dsp.grupointegrado.br.dsp2016_1.dao.ProdutoDAO;
import dsp.grupointegrado.br.dsp2016_1.model.Produto;

public class ListaActivity extends AppCompatActivity {

    private ProdutoDAO produtoDAO;

    private ListView lvProdutos;
    private List<Produto> produtoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        lvProdutos = (ListView) findViewById(R.id.lvProdutos);

        produtoDAO = new ProdutoDAO(this);

        lvProdutos.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
                                                      @Override
                                                      public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                                                          getMenuInflater().inflate(R.menu.context, contextMenu);
                                                      }
                                                  }
        );
    }

    @Override
    protected void onResume() {
        super.onResume();

        produtoList = produtoDAO.listar();
        ArrayAdapter<Produto> adapterProdutos = new ArrayAdapter<Produto>(this,
                android.R.layout.simple_list_item_1, produtoList);

        lvProdutos.setAdapter(adapterProdutos);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.cadastro, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.mnCadastro:
                startActivity(new Intent(this, CadProdutoActivity.class));
            break;

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo pListMenu = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Produto p = produtoList.get(pListMenu.position);

        switch (item.getItemId()) {

            case R.id.mnAlterar:

                Intent intentCadProduto = new Intent(this, CadProdutoActivity.class);
                intentCadProduto.putExtra("produto", p);
                this.startActivity(intentCadProduto);

            break;

            case R.id.mnDeletar:

                try {
                    produtoDAO.deletar(p);
                    this.onResume();
                } catch (IllegalAccessException e) {
                    Log.e("MSG", "ERRO ao deletar.");
                }

                break;

        }

        return super.onContextItemSelected(item);
    }
}
