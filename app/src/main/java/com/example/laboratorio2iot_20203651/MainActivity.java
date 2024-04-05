package com.example.laboratorio2iot_20203651;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.graphics.Color;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button indicacionesButton;
    private Button calcularButton;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        indicacionesButton = findViewById(R.id.button);
        calcularButton = findViewById(R.id.button2);
        textView = findViewById(R.id.textView4);
        registerForContextMenu(textView);
        indicacionesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, indicaciones.class);
                startActivity(intent);
            }
        });


        calcularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, calculadora.class);
                startActivity(intent);
            }
        });
    }

    /*Obtenido de chat gpt con la consulta: como haría un context Menu a partir de un textView
    y que cuando lo mantenga presionado
    me de las opciones para cambiar el color de "Telemath" a azul, verde o rojo*/
    /*Se realizaron modificaciones en los ids del textView y en las condiciones porque no estaban funcionando*/
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);


        menu.setHeaderTitle("Cambia el color");
        menu.add(0, v.getId(), 0, "Azul");
        menu.add(0, v.getId(), 0, "Verde");
        menu.add(0, v.getId(), 0, "Rojo");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if(item.getTitle().equals("Azul")) {
            textView.setTextColor(Color.BLUE);
            return true;
        }
        else if(item.getTitle().equals("Verde")) {
            textView.setTextColor(Color.GREEN);
            return true;
        }
        else if(item.getTitle().equals("Rojo")) {
            textView.setTextColor(Color.RED);
            return true;
        }
        else {
            return super.onContextItemSelected(item);
        }
    }
}
