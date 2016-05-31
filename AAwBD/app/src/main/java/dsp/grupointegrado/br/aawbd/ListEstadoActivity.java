package dsp.grupointegrado.br.aawbd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_list_estado)
public class ListEstadoActivity extends AppCompatActivity {

    @ViewById
    ListView lvEstado;

    EstadoDAO estadoDAO;

    @AfterViews
    public void init () {

        estadoDAO = new EstadoDAO(this);

        ArrayAdapter<Estado> aaEstado =
                new ArrayAdapter<Estado>(this, android.R.layout.simple_list_item_1, estadoDAO.list());

        lvEstado.setAdapter(aaEstado);
    }

    @ItemClick(R.id.lvEstado)
    public void escadoClick (Estado estado) {
        Intent i = new Intent();
        i.putExtra("estado", estado);

        setResult(MainActivity_.LIST_REQUEST, i);
        finish();
    }

}
