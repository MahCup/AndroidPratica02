package com.example.pratica02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button genRel;
    private EditText nome, idade, peso, altura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instanciando os widgets
        genRel = findViewById(R.id.buttonGenRel);
        nome = findViewById(R.id.editTextTextPersonName);
        idade = findViewById(R.id.Idade);
        peso = findViewById(R.id.Peso);
        altura = findViewById(R.id.Altura);
    }

    public void clickButton (View view) {
        String name = nome.getText().toString();
        Integer age = Integer.parseInt(idade.getText().toString().trim());
        Double weight = Double.parseDouble(peso.getText().toString().trim());
        Double height = Double.parseDouble(altura.getText().toString().trim());

        Intent it = new Intent(getBaseContext(), Tela2.class);
        Bundle params = new Bundle();
        params.putString("nome", name);
        params.putInt("idade", age);
        params.putDouble("peso", weight);
        params.putDouble("altura", height);

        it.putExtras(params);
        startActivity(it);
    }

}