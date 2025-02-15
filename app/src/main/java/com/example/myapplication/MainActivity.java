package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttonBookConsultation;
    private Button buttonMyRequests;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonBookConsultation = findViewById(R.id.button_book_consultation);
        buttonMyRequests = findViewById(R.id.button_my_requests);

        buttonBookConsultation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Переход на экран записи на консультацию
                Intent intent = new Intent(MainActivity.this, BookConsultationActivity.class);
                startActivity(intent);
            }
        });

        buttonMyRequests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Переход на экран моих запросов
                Intent intent = new Intent(MainActivity.this, MyRequestsActivity.class);
                startActivity(intent);
            }
        });
    }
}