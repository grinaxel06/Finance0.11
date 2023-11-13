package com.example.finance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private final static List<Item> items = new ArrayList<>();

    private static boolean  RoG;
    MaterialButton show;
    MaterialButton show1;
    Dialog dialog;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView.Adapter<RecyclerView.ViewHolder> adapter = new MyAdapter(items);
        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String money = intent.getStringExtra("money");
        String date = intent.getStringExtra("date");
        boolean flag = intent.getBooleanExtra("flag", false);
        if (flag) {
            items.add(new Item(title, money, date,RoG));
            adapter.notifyDataSetChanged();
            Log.i("SIZE", "onCreate: "+ items.size());
        }


        show = findViewById(R.id.plus_button);
        show1 = findViewById(R.id.minus_button);
        dialog = new Dialog(MainActivity.this);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RoG = true;
                showCustomDialog();
            }
        });
        show1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                RoG = false;
                showCustomDialog();
            }
        });


    }


    private void showCustomDialog() {
        dialog.setContentView(R.layout.regular_or_single);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

        MaterialButton btt_on_AddOperation = dialog.findViewById(R.id.single_btt);

        View.OnClickListener oclBtt_on_AddOperation = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddOperation.class);
                startActivity(intent);
            }
        };
        btt_on_AddOperation.setOnClickListener(oclBtt_on_AddOperation);
    }


}