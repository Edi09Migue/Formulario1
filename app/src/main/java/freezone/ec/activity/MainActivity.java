package freezone.ec.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    //picker Fecha para el text edit
    TextInputLayout FechaLayout;
    TextInputEditText FechaEdit;
    DatePickerDialog.OnDateSetListener setListener;


    //metodo para enviar los datos y en el boton siguiente se especifica el metodo OnClick
    TextInputEditText tieNombre;
    TextInputEditText tieFecha;
    TextInputEditText tieTelefono;
    TextInputEditText tieEmail;
    TextInputEditText tieDescripcionContacto;

    //boton para regresar a la actividad
    Button BtSiguiente;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //picker Fecha para el text edit
        FechaEdit = findViewById(R.id.tieFecha);
        FechaLayout = findViewById(R.id.tilFecha);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);





        FechaEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MainActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth
                        , setListener, year, month, day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month =month+1;
                String date = day+"/"+month+"/"+year;
                FechaEdit.setText(date);
            }
        };



        //metodo para enviar los datos y en el boton siguiente se especifica el metodo OnClick
        tieNombre = (TextInputEditText)findViewById(R.id.tieNombre);
        tieFecha = (TextInputEditText)findViewById(R.id.tieFecha);
        tieTelefono = (TextInputEditText)findViewById(R.id.tieTelefono);
        tieEmail = (TextInputEditText)findViewById(R.id.tieEmail);
        tieDescripcionContacto  = (TextInputEditText)findViewById(R.id.tieDescripcionContacto);


        //metodo para cambiar de actividad
        BtSiguiente = (Button) findViewById(R.id.BtSiguiente);
        BtSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this,Main2Activity.class);



                i.putExtra("dato1",tieNombre.getText().toString());
                i.putExtra("dato2",tieFecha.getText().toString());
                i.putExtra("dato3",tieTelefono.getText().toString());
                i.putExtra("dato4",tieEmail .getText().toString());
                i.putExtra("dato5",tieDescripcionContacto.getText().toString());
                startActivity(i);


            }
        });

    }


    //para guardar los datos al cambiar la actividad dos metodos
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("dato1",tieNombre.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        tieNombre.setText(savedInstanceState.getString("dato1"));

    }
}
