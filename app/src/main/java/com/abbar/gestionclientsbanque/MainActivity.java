package com.abbar.gestionclientsbanque;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import  android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.lang.Math;


public class MainActivity extends AppCompatActivity {

    EditText Nom;
    EditText Pernom;
    EditText montant;
    EditText Taux;
    EditText Duree;
    EditText Resume;

    Button btnCalculer;
    Button btnEffacer;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Nom=(EditText) findViewById(R.id.nom);
        Resume=(EditText) findViewById(R.id.resume);
        Pernom=(EditText) findViewById(R.id.prenom);
        montant=(EditText) findViewById(R.id.montant);
        Taux=(EditText) findViewById(R.id.taux);
        Duree=(EditText) findViewById(R.id.duree);
        btnCalculer=(Button) findViewById(R.id.calculer);
        btnEffacer=(Button) findViewById(R.id.effacer);
        btnCalculer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Pernom.getText().toString().isEmpty()|| Nom.getText().toString().isEmpty() ||montant.getText().toString().isEmpty()||
                        Taux.getText().toString().isEmpty()||
                        Duree.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Remplir Les Champs svp",Toast.LENGTH_SHORT).show();
                }else{
                    int montant1=Integer.parseInt(montant.getText().toString());
                    double taux1=(Double.parseDouble(Taux.getText().toString()))/100;
                    double duree1=Double.parseDouble(Duree.getText().toString())/12;
                    double mensualite=((montant1*(taux1/12))/(1-Math.pow((1+(taux1/12)),(-1*duree1))));
                    double total=mensualite*duree1;
                    Resume.setText("La mensualite est " + mensualite + " total est "+total);
                    Toast.makeText(getApplicationContext(),"La mensualite est " + mensualite + " total est "+total,Toast.LENGTH_SHORT).show();
                }

            }
        });
        btnEffacer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pernom.setText("");
                Nom.setText("");
                montant.setText("");
                Taux.setText("");
                Duree.setText("");
                Resume.setText("");
            }
        });


    }

}

