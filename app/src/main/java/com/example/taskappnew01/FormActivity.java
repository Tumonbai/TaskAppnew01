package com.example.taskappnew01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.example.taskappnew01.models.Task;

public class FormActivity extends AppCompatActivity {

    private EditText editTitle;
    private EditText editDesc;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Новая задача");
        }
        editTitle = findViewById(R.id.editTitle);
        editDesc = findViewById(R.id.editDesc);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void OnClick(View view) {
        String title = editTitle.getText().toString().trim();
        String desk = editDesc.getText().toString().trim();
        Task task = new Task(title,desk);
        Intent intent = new Intent();
        intent.putExtra("task", task);
        setResult(RESULT_OK, intent);
        finish();


    }
}
