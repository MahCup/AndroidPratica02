package com.example.pratica02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Tela2 extends AppCompatActivity {

    Button back;
    private EditText nome, idade, peso, altura, imc, classificacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela2);

        //instanciando os widgets
        nome = findViewById(R.id.viewNome);
        idade = findViewById(R.id.viewIdade);
        peso = findViewById(R.id.viewPeso);
        altura = findViewById(R.id.viewAltura);
        imc = findViewById(R.id.viewImc);
        classificacao = findViewById(R.id.viewClassificacao);

        //buscando o conteúdo da outra tela
        Intent it = getIntent();
        Bundle params = it.getExtras();
        calculateAndSet(params);
    }

    public void calculateAndSet(Bundle params) {
        nome.setText(params.getString("nome"));
        idade.setText(String.valueOf(params.getInt("idade")) + " anos");
        peso.setText(String.valueOf(params.getDouble("peso")) + " Kg");
        altura.setText(String.valueOf(params.getDouble("altura")) + " m");

        DecimalFormat formatador = new DecimalFormat("0.00");
        Double imcResult = params.getDouble("peso") / Math.pow(params.getDouble("altura"),2);
        imc.setText(String.valueOf(formatador.format(imcResult)) + " Kg/m2");

        if(imcResult < 18.5) {
            classificacao.setText("Abaixo do Peso");
        } else if (imcResult <= 24.9) {
            classificacao.setText("Saudável");
        } else if (imcResult <= 29.9) {
            classificacao.setText("Sobrepeso");
        } else if (imcResult <= 34.9) {
            classificacao.setText("Obesidade Grau I");
        } else if (imcResult <= 39.9) {
            classificacao.setText("Obesidade Grau II (severa)");
        } else {
            classificacao.setText("Obesidade Grau III (morbida)");
        }


    }

    public void back(View view) {
        finish();
    }

}