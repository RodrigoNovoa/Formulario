package com.rodrigo.formulario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Confirmacion extends AppCompatActivity {

    TextView nombre;
    TextView descripcion;
    TextView email;
    TextView telefono;
    TextView f_naci;
    Button edit_datos;
    boolean bandera=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);

        nombre= (TextView)findViewById(R.id.textView12);
        descripcion= (TextView)findViewById(R.id.textView8);
        email= (TextView)findViewById(R.id.textView9);
        telefono= (TextView)findViewById(R.id.textView10);
        f_naci= (TextView)findViewById(R.id.textView11);

        nombre.setText(getIntent().getStringExtra("nombre"));
        descripcion.setText(getIntent().getStringExtra("descripcion"));
        email.setText(getIntent().getStringExtra("emaill"));
        telefono.setText(getIntent().getStringExtra("telefono"));
        f_naci.setText(getIntent().getStringExtra("dia")+"/"+getIntent().getStringExtra("mes")+"/"+getIntent().getStringExtra("ano"));
        edit_datos= (Button)findViewById(R.id.editar_datos);
        edit_datos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String text = f_naci.getText().toString();
                String[] parts = text.split("/");
                int dia = Integer.parseInt(parts[0]);
                int mes = Integer.parseInt(parts[1])-1;
                int year = Integer.parseInt(parts[2]);


                bandera=true;

                Intent intent= new Intent(Confirmacion.this,MainActivity.class);
                intent.putExtra("nombre",nombre.getText().toString());
                intent.putExtra("telefono", telefono.getText().toString());
                intent.putExtra("emaill", email.getText().toString());
                intent.putExtra("descripcion", descripcion.getText().toString());
                intent.putExtra("bandera", bandera);
                intent.putExtra("ano", year);
                intent.putExtra("mes", mes);
                intent.putExtra("dia", dia);

                startActivity(intent);


            }
        });

    }
}
