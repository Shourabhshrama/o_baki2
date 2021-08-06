package com.kuberkings.obaki.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.kuberkings.obaki.R;
import com.kuberkings.obaki.util.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class CountrySelectionActivity extends AppCompatActivity {
    Spinner spinnerCoutry;
    Spinner spinnerLanguage;
    Button btn_fill_country_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_selection);
        spinnerCoutry=(Spinner)findViewById(R.id.spinnerCoutry);
        spinnerLanguage=(Spinner)findViewById(R.id.spinnerLanguage);
        btn_fill_country_info=(Button) findViewById(R.id.btn_fill_country_info);


        Locale[] locales = Locale.getAvailableLocales();
        ArrayList<String> countries = new ArrayList<String>();

        for (Locale locale : locales) {
            String country = locale.getDisplayCountry();
            if (country.trim().length() > 0 && !countries.contains(country)) {
                countries.add(country);
            }
        }

        Collections.sort(countries);
        for (String country : countries) {
            System.out.println(country);
        }

        ArrayAdapter<String> countryAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, countries);

        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the your spinner
        spinnerCoutry.setAdapter(countryAdapter);

        ArrayList<String> language = new ArrayList<String>();
        language.add("Hindi");
        language.add("English");


        ArrayAdapter<String> languageAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, language);

        languageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the your spinner
        spinnerLanguage.setAdapter(languageAdapter);


        findViewById(R.id.btn_fill_country_info).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utility.startActivityClass(CountrySelectionActivity.this, UserSelelctionActivity.class);
                finish();
            }
        });


    }
}