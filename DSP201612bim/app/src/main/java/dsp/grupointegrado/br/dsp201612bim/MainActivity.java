package dsp.grupointegrado.br.dsp201612bim;

import android.content.Intent;
import android.support.annotation.MenuRes;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.util.Date;
import java.util.List;

import dsp.grupointegrado.br.dsp201612bim.model.Aluno;
import dsp.grupointegrado.br.dsp201612bim.model.Cliente;
import dsp.grupointegrado.br.dsp201612bim.service.ClienteService;
import dsp.grupointegrado.br.dsp201612bim.service.ClienteService_;

@OptionsMenu(R.menu.menu)
@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById(R.id.inptId)
    TextView inptId;

    @ViewById(R.id.inptNome)
    TextView inptNome;

    @AfterViews
    public void inicio () {
        //afetrViews funciona como o onCreate
    }

    public Cliente getCliente () {
        Cliente c = new Cliente();
        c.setId(Integer.parseInt(inptId.getText().toString()));
        c.setNome(inptNome.getText().toString());

        return c;
    }

    public void limparForm () {
        inptId.setText("");
        inptNome.setText("");
    }

    @Background
    public void salvar (Cliente c) {
        ClienteService cs = new ClienteService_(this);

        cs.setCliente(c);
    }

    @Background
    public void getClientes () {
        ClienteService cs = new ClienteService_(this);
        List<Cliente> clientes = cs.getClientes();
    }

    @Background
    public void getClientesClick () {
        getClientes();
    }

    @UiThread
    @Click(R.id.btnSalvar)
    public void salvarClick () {
        salvar(getCliente());
        limparForm();
    }

    @OptionsItem(R.id.mnList)
    public void menuListar () {
        startActivity(new Intent(this, ListClienteActivity_.class));
    }

}
