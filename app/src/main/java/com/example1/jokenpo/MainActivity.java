package com.example1.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view) {
        this.opcaoSelecionada("pedra");
    }

    public void selecionadoPapel(View view) {
        this.opcaoSelecionada("papel");
    }

    public void selecionadoTesoura(View view) {
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String escolhaUsuario) {

        ImageView imgResultado = findViewById(R.id.imgResultado);
        TextView txtResultado = findViewById(R.id.txtResultado);

        int numero = new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String computador = opcoes[numero];

        switch (computador) {
            case "pedra":
                imgResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imgResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imgResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if ((computador == "tesoura" && escolhaUsuario == "papel")
                || (computador == "papel" && escolhaUsuario == "pedra")
                || (computador == "pedra" && escolhaUsuario == "tesoura")) {

            txtResultado.setText("VOCÊ PERDEU!");

        } else if ((escolhaUsuario == "tesoura" && computador == "papel")
                || (escolhaUsuario == "papel" && computador == "pedra")
                || (escolhaUsuario == "pedra" && computador == "tesoura")) {

            txtResultado.setText("VOCÊ GANHOU!");
        } else {

            txtResultado.setText("EMPATE!");

        }
    }
}