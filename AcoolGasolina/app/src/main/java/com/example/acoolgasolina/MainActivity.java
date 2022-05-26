package com.example.acoolgasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoalcool, editPrecogasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editPrecoalcool = findViewById(R.id.editPrecoalcool);
        editPrecogasolina = findViewById(R.id.editPrecogasolina);
        textResultado = findViewById(R.id.textResultado);
    }

    public void calcularPreco (View view){
        //recuperar valores digitados
        String precoAlcool = editPrecoalcool.getText().toString();
        String precoGasolina = editPrecogasolina.getText().toString();

        Boolean camposValidados = validarCampos(precoAlcool, precoGasolina);
     if( camposValidados ){

    Double valorAlcool = Double.parseDouble(precoAlcool);
    Double valorGasolina = Double.parseDouble(precoGasolina);

    double resultado = valorAlcool / valorGasolina;
    if ( resultado >= 0.7){

        textResultado.setText("Melhor utilizar Gasolina");
    }else{
        textResultado.setText("Melhor utilizar Alcool");
    }


}else{

    textResultado.setText("Preencha os campos");
   }

    }

    public Boolean validarCampos ( String pAlcool, String pGasolina){

        Boolean camposValidados = true;
        String campo = "Preenchido";

        if ( pAlcool == null || pAlcool.equals("")){
            camposValidados = false;
            campo = "alcool";
        }else if(pGasolina == null || pGasolina.equals("")){
                camposValidados = false;
                campo = "gasolina";
        }
        return camposValidados;
    }
}