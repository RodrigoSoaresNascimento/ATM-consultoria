package com.cursoandroid.alcoolgasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool;
    private TextInputEditText editPrecoGasolina;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina = findViewById(R.id.editPrecoGasolina);
        textResult = findViewById(R.id.textResult);

    }

    public void calcularPreco (View view){

        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        Boolean resultado = validarCampos(precoAlcool,precoGasolina);

        if(resultado){

            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);

            Double melhorPreco = valorAlcool/valorGasolina;

            if(melhorPreco >= 0.7){
                textResult.setText("Melhor usar gasolina");
            }else{
                textResult.setText("Melhor usar alcool");
            }



        }else{
            textResult.setText("Preencha os preços primeiro!");
        }


    }

    public  Boolean validarCampos (String precoAlcool, String precoGasolina){

        return precoAlcool != null || !precoAlcool.isEmpty() && precoGasolina != null || !precoGasolina.isEmpty();
    }

}
