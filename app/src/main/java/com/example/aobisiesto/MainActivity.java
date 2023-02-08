package com.example.aobisiesto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public Button aleatorio;
    public TextView texto1;
    public Button comprobar;
    public EditText resultado;
    public RadioButton si;
    public RadioButton no;
    public Switch amarillo;
    public ConstraintLayout fondo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aleatorio= (Button) findViewById(R.id.aleatorio);
        texto1= (TextView)  findViewById(R.id.muestraNumero);
        comprobar= (Button) findViewById(R.id.comprobar);
        resultado=(EditText) findViewById(R.id.resultado);
        si=(RadioButton) findViewById(R.id.si);
        no=(RadioButton) findViewById(R.id.no);
        amarillo=(Switch) findViewById(R.id.switch1);
        fondo=(ConstraintLayout)findViewById(R.id.fondo);

        aleatorio.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                int num= (int)(Math.random()*(2500-1901)+1900);
                    texto1.setText(String.valueOf(num));

            }
        });

        amarillo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(amarillo.isChecked()){
                    fondo.setBackgroundColor(Color.parseColor("#FFFF99"));
                }else {
                    fondo.setBackgroundColor(Color.WHITE);
                }
            }
        });

        comprobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cadena =texto1.getText().toString();
                if (cadena.isEmpty()){
                    resultado.setTextColor(Color.parseColor("#FF0040E3"));
                    resultado.setText("Debes generar un número");
                }else{
                    int numero = Integer.parseInt(cadena);
                    if (numero % 4 == 0 && (numero % 100 != 0 || numero % 400 == 0)){
                        if(si.isChecked()){
                            resultado.setTextColor(Color.parseColor("#03FF07"));
                            resultado.setText("Correcto");
                        }else{
                            if(no.isChecked()){
                                resultado.setTextColor(Color.parseColor("#FA0000"));
                                resultado.setText("Incorrecto, es bisiesto");
                            }else {
                                resultado.setTextColor(Color.parseColor("#FF3700B3"));
                                resultado.setText("Marca alguna opción");

                            }
                        }

                    }else{
                        if(no.isChecked()){
                            resultado.setTextColor(Color.parseColor("#03FF07"));
                            resultado.setText("Correcto");
                        }else{
                            if(si.isChecked()){
                                resultado.setTextColor(Color.parseColor("#FA0000"));
                                resultado.setText("Incorrecto, no es bisiesto");
                            }else {
                                resultado.setTextColor(Color.parseColor("#FF3700B3"));
                                resultado.setText("Debes marcar alguna de las dos opciones");
                            }
                        }

                    }
                }

            }
        });



    }
}