package dsp.grupointegrado.br.dsp201612bim.arrayadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import dsp.grupointegrado.br.dsp201612bim.R;
import dsp.grupointegrado.br.dsp201612bim.model.Cliente;

/**
 * Created by bhpachulski on 5/11/2016.
 */
public class ClienteArrayAdapter extends ArrayAdapter<Cliente> {

    public ClienteArrayAdapter(Context context, List<Cliente> clientes) {
        super(context, R.layout.arrayadapter_cliente, clientes);
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        LayoutInflater li = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = li.inflate(R.layout.arrayadapter_cliente, null);

        TextView tvId = (TextView) v.findViewById(R.id.tvAAClienteID);
        TextView tvNome = (TextView) v.findViewById(R.id.tvAAClienteNome);

        tvId.setText(String.valueOf(getItem(position).getId()));
        tvNome.setText(getItem(position).getNome());

        return v;
    }

    @Override
    public View getDropDownView(int position, View v, ViewGroup parent) {
        return this.getView(position, v, parent);
    }
}
