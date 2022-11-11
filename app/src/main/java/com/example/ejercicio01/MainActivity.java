package com.example.ejercicio01;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ejercicio01.databinding.ActivityMainBinding;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    // ------Buena Praxis----
    private final int NUMINICIALCIGARROS = 20;
    private final int COSTEPAQUETE = 5;

    //Contadores
    private int numCigarrillos;
    private int dineroAhorrado;
    private NumberFormat nf;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        nf = NumberFormat.getCurrencyInstance();

        numCigarrillos = NUMINICIALCIGARROS;
        binding.contentMain.lblNumCigarrosMain.setText("Cigarros restantes: "+ numCigarrillos);

        binding.contentMain.btnDescartarCigarroMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numCigarrillos -= 1;
                if(numCigarrillos  == 0){
                    numCigarrillos = NUMINICIALCIGARROS;
                    dineroAhorrado += 5;
                    Toast.makeText(MainActivity.this, "MUY BIEN, TE HAS ACABADO LA CAJA, AHORRAS "+nf.format(5), Toast.LENGTH_SHORT).show();
                    binding.contentMain.lblDineroAhorradoMain.setText("Dinero Ahorrado: "+nf.format(dineroAhorrado));
                }
                binding.contentMain.lblNumCigarrosMain.setText("Cigarros restantes: "+ numCigarrillos);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("DINERO", dineroAhorrado);
        outState.putInt("CIGARROS", numCigarrillos);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        dineroAhorrado = savedInstanceState.getInt("DINERO");
        numCigarrillos = savedInstanceState.getInt("CIGARROS");

        binding.contentMain.lblDineroAhorradoMain.setText("Dinero Ahorrado: "+nf.format(dineroAhorrado));
        binding.contentMain.lblNumCigarrosMain.setText("Cigarros restantes: "+ numCigarrillos);
    }
}