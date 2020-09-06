package com.example.appdosactividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Date;

public class DetalleActivity2 extends AppCompatActivity {

    TextView tvNombre;
    TextView tvFechaNacimiento;
    TextView tvTelefono;
    TextView tvCorreo;
    TextView tvDescripcion;
    Button btnEditar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle2);

        tvNombre = (TextView)findViewById(R.id.tvNombrecompleto);
        tvFechaNacimiento = (TextView)findViewById(R.id.tvFechaNacimiento);
        tvTelefono = (TextView)findViewById(R.id.tvTelefono);
        tvCorreo = (TextView)findViewById(R.id.tvEmail);
        tvDescripcion = (TextView)findViewById(R.id.tvDescripcion);
        btnEditar = (Button)findViewById(R.id.btnEditar);

        Bundle param = getIntent().getExtras();
        String nombre = param.getString("NOMBRE");
        String fechaNacimiento = param.getString("FECHA");
        String telefono = param.getString("TELEFONO");
        String correo = param.getString("CORREO");
        String descripcion = param.getString("DESCRIPCION");

        tvNombre.setText(nombre);
        tvFechaNacimiento.setText(fechaNacimiento);
        tvTelefono.setText(telefono);
        tvCorreo.setText(correo);
        tvDescripcion.setText(descripcion);

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetalleActivity2.this, MainActivity.class);
                intent.putExtra("NOMBRE",tvNombre.getText().toString());
                intent.putExtra("FECHA",tvFechaNacimiento.getText().toString());
                intent.putExtra("CORREO",tvCorreo.getText().toString());
                intent.putExtra("TELEFONO",tvTelefono.getText().toString());
                intent.putExtra("DESCRIPCION",tvDescripcion.getText().toString());
                startActivity(intent);
            }
        });
    }
}