package pe.area51.clase02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Declaramos las variables que se van a vincular
    //a los componentes
    private EditText nombre, apellido;
    private Button obtener,enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Vincular las variables a los componentes XML
        nombre=findViewById(R.id.etNombre);
        apellido=findViewById(R.id.etApellido);
        obtener=findViewById(R.id.btnObtener);
        enviar=findViewById(R.id.btnEnviar);

    }

    @Override
    protected void onResume() {
         super.onResume();
         //Creamos el evento OnClick al boton obtener
         obtener.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 //Obtenemos los datos del editText
                 String valorNombre=nombre.getText().toString();
                 String valorApellido=apellido.getText().toString();

                 //Mostramos el mensaje flotante con el texto ingresado
                 Toast.makeText(
                         MainActivity.this,
                         "Nombre: "+valorNombre+ " - Apellido: "+valorApellido ,
                         Toast.LENGTH_SHORT)
                         .show();
             }
         });
         enviar.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 //Obtenemos los datos del editText
                 String valorNombre=nombre.getText().toString();
                 String valorApellido=apellido.getText().toString();

                //Pasar a otro activity
                 Intent intent = new Intent(
                         MainActivity.this,
                         PantallaDosActivity.class
                 );
                 intent.putExtra("v_nombre",valorNombre);
                 intent.putExtra("v_apellido",valorApellido);
                 startActivity(intent);
             }
         });
    }
}
