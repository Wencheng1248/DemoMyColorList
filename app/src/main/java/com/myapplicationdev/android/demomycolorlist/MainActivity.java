package com.myapplicationdev.android.demomycolorlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
  EditText etAdd , etAddIn;
  Button btnAdd;
  ListView lvColor;
  ArrayList<String> alColors;
  ArrayAdapter<String> aaColors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etAdd = findViewById(R.id.editTextAdd);
        btnAdd = findViewById(R.id.buttonAdd);
        lvColor = findViewById(R.id.listViewColour);
        etAddIn = findViewById(R.id.etAddIndex);
        alColors = new ArrayList<String>();
        alColors.add("Red");
        alColors.add("Orange");
        aaColors = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,alColors);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String addColor = etAdd.getText().toString();
                //alColors.add(addColor);
                int pos = Integer.parseInt(etAddIn.getText().toString());
                alColors.add(pos,addColor);
                lvColor.setAdapter(aaColors);
                aaColors.notifyDataSetChanged();
            }
        });

        lvColor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String colors = alColors.get(i);
                Toast.makeText(MainActivity.this, colors, Toast.LENGTH_SHORT).show();
            }
        });


    }
}
