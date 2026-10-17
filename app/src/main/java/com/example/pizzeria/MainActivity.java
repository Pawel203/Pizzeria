package com.example.pizzeria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    RadioGroup rozmiar;
    CheckBox grubeCiasto;
    EditText liczbaSztuk;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rozmiar = findViewById(R.id.rozmiary);
        grubeCiasto = findViewById(R.id.grubeCiasto);
        liczbaSztuk = findViewById(R.id.liczbaSztuk);
    }

    public void dodaj(View view) {
        int nowaLiczba = Integer.parseInt(liczbaSztuk.getText().toString()) + 1;
        liczbaSztuk.setText(String.valueOf(nowaLiczba));
    }

    public void odejmij(View view) {
        if (Integer.parseInt(liczbaSztuk.getText().toString()) > 1){
            int nowaLiczba = Integer.parseInt(liczbaSztuk.getText().toString()) - 1;
            liczbaSztuk.setText(String.valueOf(nowaLiczba));
        }
    }

    public void podsumowanie(View view) {
        int cena = 0;
        String rozmiarNazwa;

        if (rozmiar.getCheckedRadioButtonId() == R.id.mala){
            cena = 25;
            rozmiarNazwa = "Mała";
        } else if (rozmiar.getCheckedRadioButtonId() == R.id.srednia) {
            cena = 35;
            rozmiarNazwa = "Średnia";
        }
        else  {
            cena = 45;
            rozmiarNazwa = "Duża";
        }

        if (grubeCiasto.isChecked()){
            cena += 5;
        }

        int sztuki = Integer.parseInt(liczbaSztuk.getText().toString());

        cena *= sztuki;

        Intent intent = new Intent(MainActivity.this, Podsumowanie.class);
        intent.putExtra("KEY_CENA", cena);
        intent.putExtra("KEY_ROZMIAR", rozmiarNazwa);
        intent.putExtra("KEY_GRUBOSC", grubeCiasto.isChecked());
        intent.putExtra("KEY_ILOSC", sztuki);

        startActivity(intent);


    }
}