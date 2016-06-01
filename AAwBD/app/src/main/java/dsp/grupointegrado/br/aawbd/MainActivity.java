package dsp.grupointegrado.br.aawbd;

import android.content.Intent;
import android.support.annotation.MenuRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OnActivityResult;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.OptionsMenuItem;
import org.androidannotations.annotations.ViewById;

@OptionsMenu(R.menu.cadastro)
@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    public static final int LIST_REQUEST = 600;

    @ViewById
    EditText edtCodigo;

    @ViewById
    EditText edtNome;

    EstadoDAO estadoDAO;

    @AfterViews
    public void init () {
        estadoDAO = new EstadoDAO(this);
    }

    public Estado getEstado () {
        Estado estado = new Estado();
        estado.setNome(edtNome.getText().toString());

        try {
            estado.setCod(Integer.parseInt(edtCodigo.getText().toString()));
        } catch (NumberFormatException e) {}

        return estado;
    }

    public void setEstado (Estado estado) {
        edtCodigo.setText(String.valueOf(estado.getCod()));
        edtNome.setText(estado.getNome());
    }

    public void limpar () {
        edtCodigo.setText("");
        edtNome.setText("");
    }

    @OptionsItem(R.id.mnSalvar)
    public void salvar () {
        Estado e = getEstado();

        if (e.getCod() == 0)
            estadoDAO.add(e);
        else
            estadoDAO.update(e);

        limpar();
    }

    @OptionsItem(R.id.mnListar)
    public void listar () {
        startActivityForResult(new Intent(this, ListEstadoActivity_.class), LIST_REQUEST);
    }

    @OnActivityResult(LIST_REQUEST)
    public void listResult (int resultCode, Intent data, @OnActivityResult.Extra String value) {
        try {
            Estado e = (Estado) data.getExtras().getSerializable("estado");
            setEstado(e);
        } catch (NullPointerException ex) {
            Log.e("MSG", "Não voltou estado.");
        }
    }

}
