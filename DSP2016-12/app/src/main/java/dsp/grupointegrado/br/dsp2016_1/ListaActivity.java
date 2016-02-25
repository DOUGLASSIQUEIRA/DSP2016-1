package dsp.grupointegrado.br.dsp2016_1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class ListaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);


        Produto p = (Produto) getIntent().getExtras().get("produto");

        Toast.makeText(this, p.getNome(), Toast.LENGTH_LONG).show();

    }

}
