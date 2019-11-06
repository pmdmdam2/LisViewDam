package com.ejemplo.lisviewdam;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Actividad principal que muestra un ejemplo de ListView sencillo, sin personalizar
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvAlumnos = findViewById(R.id.lvAlumnos);

        String[] alumnos = {"Javi", "Laura", "Adrian","Sergio"};

        //adaptador sencillo, basado en un TextView que proporciona Android y un array de cadenas
        //para los datos
        ArrayAdapter<String> adaptadorAlumnos =
                new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,
                        alumnos);
        //subscripción de los elementos del ListView al evento click
        lvAlumnos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //efecto de rotación sobre el item seleccionado
                view.animate().rotationXBy(360);

                Toast.makeText(MainActivity.this,((TextView)view).getText(),Toast.LENGTH_LONG).show();
            }
        });
        //asignación del adaptor al ListView
        lvAlumnos.setAdapter(adaptadorAlumnos);
    }
}
