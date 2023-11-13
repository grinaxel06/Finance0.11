package com.example.finance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class AddOperation extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_operation);


    }
    public void add(View view){
        EditText editTitle = this.findViewById(R.id.editDscr);
        EditText editMoney = this.findViewById(R.id.editMoney);
        EditText editDate = this.findViewById(R.id.editCom);
        Intent intent = new Intent(AddOperation.this, MainActivity.class);
        intent.putExtra("title", editTitle.getText().toString());
        intent.putExtra("money", editMoney.getText().toString());
        intent.putExtra("date", editDate.getText().toString());
        intent.putExtra("flag",true);
        startActivity(intent);

    }
}