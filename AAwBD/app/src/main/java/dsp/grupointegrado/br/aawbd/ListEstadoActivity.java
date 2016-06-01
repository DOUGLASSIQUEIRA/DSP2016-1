package dsp.grupointegrado.br.aawbd;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.InjectMenu;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_list_estado)
public class ListEstadoActivity extends AppCompatActivity {

    @ViewById
    ListView lvEstado;

    EstadoDAO estadoDAO;

    private Estado estado;

    @AfterViews
    public void init () {

        estadoDAO = new EstadoDAO(this);

        setAdapterEstado();
    }

    public void setAdapterEstado () {
        ArrayAdapter<Estado> aaEstado =
                new ArrayAdapter<Estado>(this, android.R.layout.simple_list_item_1, estadoDAO.list());

        lvEstado.setAdapter(aaEstado);
    }

    @ItemClick(R.id.lvEstado)
    public void estadoClick (Estado estado) {

        this.estado = estado;

        lvEstado.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                getMenuInflater().inflate(R.menu.list, contextMenu);
                contextMenu.setHeaderTitle("Estado");
            }
        });
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.mnAlterar:

                Intent i = new Intent();
                i.putExtra("estado", estado);

                setResult(MainActivity_.LIST_REQUEST, i);
                finish();

                break;

            case R.id.mnDel:

                    mostraDialogDelete();

                break;

        }

        return super.onContextItemSelected(item);
    }

    public void mostraDialogDelete () {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Deletar " + estado.getNome() + " ?");
        builder.setMessage("Deseja realmente deletar ?");

        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener(){

            public void onClick(DialogInterface dialog, int which) {

                estadoDAO.delete(estado);
                setAdapterEstado();

                dialog.dismiss();
            }

        });

        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.create().show();
    }
}
