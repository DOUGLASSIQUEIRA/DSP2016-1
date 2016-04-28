package dsp.grupointegrado.br.dsp201612bim;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.util.Date;
import java.util.List;

import dsp.grupointegrado.br.dsp201612bim.model.Aluno;
import dsp.grupointegrado.br.dsp201612bim.model.Cliente;
import dsp.grupointegrado.br.dsp201612bim.service.ClienteService;
import dsp.grupointegrado.br.dsp201612bim.service.ClienteService_;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById(R.id.testeBruno)
    TextView testeBruno;

    @AfterViews
    public void inicio () {

        testeBruno.setText("Olá AndroidAnnotations ! =D");

    }

    @Background
    public void getClientes () {
        ClienteService cs = new ClienteService_(this);
        List<Cliente> clientes = cs.getClientes();

        Log.d("TEST", clientes.toString());
    }

    @Background
    @Click(R.id.btnGet)
    public void getClientesClick () {
        getClientes();
    }

    @Background
    public void setClientes () {
        ClienteService cs = new ClienteService_(this);

        Cliente c = new Cliente();
        c.setId(999);
        c.setNome(new Date().toString());

        cs.setCliente(c);
    }

    @Background
    @Click(R.id.btnSet)
    public void setClientesClick () {
        setClientes();
    }

}
