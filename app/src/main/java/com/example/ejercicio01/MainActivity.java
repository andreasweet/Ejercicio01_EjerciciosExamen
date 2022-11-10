package com.example.ejercicio01;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ejercicio01.databinding.ActivityMainBinding;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private final int NUMINICIALCIGARROS = 20;
    private int numCigarrillos;
    private int dineroAhorrado;
    NumberFormat nf = NumberFormat.getCurrencyInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        numCigarrillos = NUMINICIALCIGARROS;
        binding.contentMain.lblNumCigarrosMain.setText("Cigarros restantes: "+ numCigarrillos);

        binding.contentMain.btnDescartarCigarroMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numCigarrillos -= 1;
                if(numCigarrillos <1){
                    numCigarrillos = NUMINICIALCIGARROS;
                    dineroAhorrado += 5;
                    Toast.makeText(MainActivity.this, "MUY BIEN, TE HAS ACABADO LA CAJA, AHORRAS "+nf.format(5), Toast.LENGTH_SHORT).show();
                    binding.contentMain.lblDineroAhorradoMain.setText("Dinero Ahorrado: "+nf.format(dineroAhorrado));
                }
                binding.contentMain.lblNumCigarrosMain.setText("Cigarros restantes: "+ numCigarrillos);
            }
        });











    }



}