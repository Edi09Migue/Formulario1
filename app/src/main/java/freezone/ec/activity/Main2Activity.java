package freezone.ec.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class Main2Activity extends AppCompatActivity {
    //boton para regresar a la actividad
    Button BontonEditarDatos;

    //recibe el dato de la actividad 1
    TextView TvNombre;
    TextView TvFecha;
    TextView TvTelefono;
    TextView TvEmail;
    TextView TvDescripcion;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //metodo para cambiar de actividad
        BontonEditarDatos= (Button) findViewById(R.id.BtnEditarDatos);
        BontonEditarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this,MainActivity.class);

                startActivity(i);
            }
        });

        //recibe el dato de la actividad 1
        TvNombre = (TextView)findViewById(R.id.TvNombre);
        TvFecha = (TextView)findViewById(R.id.TvFecha);
        TvTelefono = (TextView)findViewById(R.id.TvTelefono);
        TvEmail = (TextView)findViewById(R.id.TvEmail);
        TvDescripcion = (TextView)findViewById(R.id.TvDescripcion);

        String dato1 = getIntent().getStringExtra("dato1");
        TvNombre.setText(dato1);
        String dato2 = getIntent().getStringExtra("dato2");
        TvFecha.setText("Fecha de nacimiento:  "+ dato2);
        String dato3 = getIntent().getStringExtra("dato3");
        TvTelefono.setText("Tel.  "+dato3);
        String dato4 = getIntent().getStringExtra("dato4");
        TvEmail.setText("Email:  "+dato4);
        String dato5 = getIntent().getStringExtra("dato5");
        TvDescripcion.setText("Descripción:  "+dato5);


    }
}
