package com.example.appdosactividades;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Button btnnext;
    EditText dtNombre;
    DatePicker dpfechaNacimiento;
    EditText dtCorreo;
    EditText dtDescripcion;
    EditText dtTelefono;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dtNombre = (EditText)findViewById(R.id.dtNombrecompleto);
        dpfechaNacimiento = (DatePicker)findViewById(R.id.dpFechaNacimiento);
        dtCorreo = (EditText)findViewById(R.id.dtEmail);
        dtTelefono = (EditText)findViewById(R.id.dtTelefono);
        dtDescripcion = (EditText)findViewById(R.id.dtDescripcion);

        if(getIntent()!= null && getIntent().getExtras() != null){
            Bundle param = getIntent().getExtras();
            String nombre = param.getString("NOMBRE");
            String fechaNacimiento = param.getString("FECHA");
            String telefono = param.getString("TELEFONO");
            String correo = param.getString("CORREO");
            String descripcion = param.getString("DESCRIPCION");
            String[] fechaSplit = fechaNacimiento.split("/");

            dtNombre.setText(nombre);
            dpfechaNacimiento.updateDate(Integer.parseInt(fechaSplit[0]),Integer.parseInt(fechaSplit[1]),Integer.parseInt(fechaSplit[2]));
            dtTelefono.setText(telefono);
            dtCorreo.setText(correo);
            dtDescripcion.setText(descripcion);
        }

        btnnext = (Button)findViewById(R.id.btnSiguiente);
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DetalleActivity2.class);
                intent.putExtra("NOMBRE",dtNombre.getText().toString());
                intent.putExtra("FECHA", dpfechaNacimiento.getYear()+"/"+dpfechaNacimiento.getMonth()+"/"+dpfechaNacimiento.getDayOfMonth());
                intent.putExtra("CORREO",dtCorreo.getText().toString());
                intent.putExtra("TELEFONO",dtTelefono.getText().toString());
                intent.putExtra("DESCRIPCION",dtDescripcion.getText().toString());
                startActivity(intent);
            }
        });


    }

}