package dsp.grupointegrado.br.dsp201612bim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.util.List;

import dsp.grupointegrado.br.dsp201612bim.model.Cliente;
import dsp.grupointegrado.br.dsp201612bim.service.ClienteService;
import dsp.grupointegrado.br.dsp201612bim.service.ClienteService_;

@EActivity(R.layout.activity_list_cliente)
public class ListClienteActivity extends AppCompatActivity {

    private List<Cliente> clientes;

    @ViewById(R.id.lvClientes)
    ListView lvClientes;

    @AfterViews
    @Background
    public void buscaClientes () {
        ClienteService cs = new ClienteService_(this);
        init(cs.getClientes());
    }

    @UiThread
    public void init (List<Cliente> clientes) {
        ArrayAdapter<Cliente> aaClientes =
                new ArrayAdapter<Cliente>(this,
                        android.R.layout.simple_list_item_1, clientes);

        lvClientes.setAdapter(aaClientes);
    }

    @ItemClick(R.id.lvClientes)
    public void clienteClick (Cliente c) {
        Toast.makeText(this, c.getNome(), Toast.LENGTH_LONG).show();
    }

}
