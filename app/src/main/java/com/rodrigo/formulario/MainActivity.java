package com.rodrigo.formulario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

public class MainActivity extends AppCompatActivity {

    private Button buttonSiguiente;
    private android.support.design.widget.TextInputEditText nombre;
    private android.support.design.widget.TextInputEditText telefono;
    private android.support.design.widget.TextInputEditText emaill;
    private android.support.design.widget.TextInputEditText descripcion;
    private DatePicker datePicker;
    private boolean bandera=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonSiguiente=(Button)findViewById(R.id.buttonSiguiente);
        nombre= (android.support.design.widget.TextInputEditText) findViewById(R.id.nombre);
        telefono= (android.support.design.widget.TextInputEditText) findViewById(R.id.telefono);
        emaill= (android.support.design.widget.TextInputEditText) findViewById(R.id.emaill);
        descripcion= (android.support.design.widget.TextInputEditText) findViewById(R.id.descripcion);
        datePicker=(DatePicker)findViewById(R.id.datePicker);

        bandera= getIntent().getBooleanExtra("bandera",false);
        if (bandera==true)  {
            int ano= ((int) getIntent().getIntExtra("ano", 0));
            int mes= ((int) getIntent().getIntExtra("mes", 0));
            int dia= ((int) getIntent().getIntExtra("dia", 0));
            Log.i("dia", Integer.toString(dia));
            Log.i("mes", Integer.toString(mes));
            Log.i("año", Integer.toString(ano));
            datePicker.updateDate(ano,mes,dia);
            nombre.setText(getIntent().getStringExtra("nombre"));
            descripcion.setText(getIntent().getStringExtra("descripcion"));
            emaill.setText(getIntent().getStringExtra("emaill"));
            telefono.setText(getIntent().getStringExtra("telefono"));
        }
        buttonSiguiente.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, Confirmacion.class);
            intent.putExtra("nombre", nombre.getText().toString());
            intent.putExtra("telefono", telefono.getText().toString());
            intent.putExtra("emaill", emaill.getText().toString());
            intent.putExtra("descripcion", descripcion.getText().toString());
            intent.putExtra("ano", Integer.toString(datePicker.getYear()));
            intent.putExtra("mes", Integer.toString(datePicker.getMonth() + 1));
            intent.putExtra("dia", Integer.toString(datePicker.getDayOfMonth()));
            startActivity(intent);
        }
    });

}}
