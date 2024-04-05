package com.example.laboratorio2iot_20203651;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.ImageView;

public class calculadora extends AppCompatActivity {
    private EditText textoentrada;
    private EditText operacion;

    private String numeroactual = "";
    private String aritmetica = "";
    private boolean existeresultado = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculadora);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageView imageView = findViewById(R.id.imageView2);
        ImageView historial = findViewById(R.id.historial123);
        textoentrada = findViewById(R.id.editTextText10);
        operacion = findViewById(R.id.editTextText20);


        Button boton0 = findViewById(R.id.boton0);
        Button boton1 = findViewById(R.id.boton1);
        Button boton2 = findViewById(R.id.boton2);
        Button boton3 = findViewById(R.id.boton3);
        Button boton4 = findViewById(R.id.boton4);
        Button boton5 = findViewById(R.id.boton5);
        Button boton6 = findViewById(R.id.boton6);
        Button boton7 = findViewById(R.id.boton7);
        Button boton8 = findViewById(R.id.boton8);
        Button boton9 = findViewById(R.id.boton9);
        Button botonmas = findViewById(R.id.botonmas);
        Button botonmenos = findViewById(R.id.botonmenos);
        Button botonpor = findViewById(R.id.botonpor);
        Button botondivision = findViewById(R.id.botondivision);
        Button botonigual = findViewById(R.id.botonigual);

        boton0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setnumero("0");
            }
        });
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setnumero("1");
            }
        });
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setnumero("2");
            }
        });
        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setnumero("3");
            }
        });
        boton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setnumero("4");
            }
        });
        boton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setnumero("5");
            }
        });
        boton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setnumero("6");
            }
        });
        boton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setnumero("7");
            }
        });
        boton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setnumero("8");
            }
        });
        boton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setnumero("9");
            }
        });


        botonmas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setoperacion("+");
            }
        });

        botonmenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setoperacion("-");
            }
        });

        botonpor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setoperacion("*");
            }
        });

        botondivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setoperacion("/");
            }
        });
        botonigual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularesultado();
            }
        });

        Button buttonClear = findViewById(R.id.CLR);
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiar();
            }
        });
        historial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(calculadora.this, Historial.class);
                startActivity(intent);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(calculadora.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setnumero(String number) {
        if (existeresultado) {
            limpiar();
            existeresultado = false;
        }
        numeroactual += number;
        textoentrada.setText(numeroactual);
    }

    private void setoperacion(String operation) {
        if (!numeroactual.isEmpty()) {
            aritmetica = operation;
            operacion.setText(numeroactual + " " + aritmetica);
            numeroactual = "";
        }
    }

    private void limpiar() {
        textoentrada.setText("0");
        operacion.setText("");
        numeroactual = "";
        aritmetica = "";
    }

    private void calcularesultado() {
        if (!numeroactual.isEmpty() && !aritmetica.isEmpty()) {
            double resultado = 0;
            double numero1 = Double.parseDouble(numeroactual);
            double numero2 = Double.parseDouble(textoentrada.getText().toString());

            if (aritmetica.equals("+")) {
                resultado = numero1 + numero2;
            } else if (aritmetica.equals("-")) {
                resultado = numero1 - numero2;
            } else if (aritmetica.equals("*")) {
                resultado = numero1 * numero2;
            } else if (aritmetica.equals("/")) {
                if (numero2 != 0) {
                    resultado = numero1 / numero2;
                } else {
                    textoentrada.setText("Error");
                    return;
                }
            }

            textoentrada.setText(String.valueOf(resultado));
            operacion.setText("");
            aritmetica = "";
            numeroactual = "";
            existeresultado = true;
        }
    }
}