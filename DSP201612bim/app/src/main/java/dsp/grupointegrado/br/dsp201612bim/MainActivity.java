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

import java.util.List;

import dsp.grupointegrado.br.dsp201612bim.model.Aluno;
import dsp.grupointegrado.br.dsp201612bim.service.AlunoService;
import dsp.grupointegrado.br.dsp201612bim.service.AlunoService_;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById(R.id.testeBruno)
    TextView testeBruno;

    @AfterViews
    public void inicio () {

        testeBruno.setText("Olá AndroidAnnotations ! =D");

    }

    @Background
    public void ws () {

        AlunoService alunoService = new AlunoService_(this);
        String test = alunoService.teste();

        Log.d("TEST", test);

        //Toast.makeText(this, test, Toast.LENGTH_LONG).show();

    }

    @Background
    @Click(R.id.btnTest)
    public void testWS () {

        ws();

    }

}
