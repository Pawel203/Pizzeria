package com.example.pizzeria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Podsumowanie extends AppCompatActivity {

    TextView rozmiar, sztuki, ciasto, cena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_podsumowanie);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rozmiar = findViewById(R.id.rozmiar);
        sztuki = findViewById(R.id.sztuki);
        ciasto = findViewById(R.id.ciasto);
        cena = findViewById(R.id.cena);

        Intent intent = getIntent();

        int iloscSztuk = intent.getIntExtra("KEY_ILOSC", 1);
        int rozmiarId = intent.getIntExtra("KEY_ROZMIAR", 0);


        if (intent.getBooleanExtra("KEY_GRUBOSC", false)){
            ciasto.setText("CIASTO: GRUBE");
        }
        else {
            ciasto.setText("CIASTO: CIENKIE");
        }

        if (rozmiarId == R.id.mala){
            rozmiar.setText("ROZMIAR: MAŁA");
        } else if (rozmiarId == R.id.srednia) {
            rozmiar.setText("ROZMIAR: ŚREDNIA");
        }
        else  {
            rozmiar.setText("ROZMIAR: DUŻA");
        }

        sztuki.setText("SZTUKI: " + iloscSztuk);
        cena.setText("RAZEM: " + intent.getIntExtra("KEY_CENA", 0));


    }

    public void powrot(View view) {
        finish();
    }
}