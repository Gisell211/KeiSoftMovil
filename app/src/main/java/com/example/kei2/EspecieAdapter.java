package com.example.kei2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.kei2.Modelo.Especie;

import java.util.List;

public class EspecieAdapter extends ArrayAdapter<Especie> {


    private Context context;
    private List<Especie> especie;

    public EspecieAdapter(@NonNull Context context, int resource, @NonNull List<Especie> objects) {
        super(context, resource, objects);

        this.context = context;
        this.especie = objects;
    }

    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = layoutInflater.inflate(R.layout.content_main, parent, false);


        TextView txtidEspecie = (TextView) rowView.findViewById(R.id.IdEspecie);
        TextView txtNombre = (TextView) rowView.findViewById(R.id.Nombre);
        ;
        TextView txtEdad = (TextView) rowView.findViewById(R.id.Edad);
        TextView txtRaza = (TextView) rowView.findViewById(R.id.Raza);
        ;

        txtidEspecie.setText(String.format("ID:%d", especie.get(position).getId()));
        txtNombre.setText(String.format("NOMBRE:%s", especie.get(position).getNombre()));
        txtRaza.setText(String.format("RAZA: %s", especie.get(position).getRaza()));
        txtEdad.setText(String.format("EDAD: %s", especie.get(position).getEdad()));

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EspecieActivity.class);
                intent.putExtra("ID", String.valueOf(especie.get(position).getId()));
                intent.putExtra("NOMBRE", especie.get(position).getNombre());
                intent.putExtra("RAZA", especie.get(position).getRaza());
                intent.putExtra("EDAD", especie.get(position).getEdad());
                context.startActivity(intent);
            }
        });
        return rowView;


    }

}
