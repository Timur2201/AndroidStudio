// MainActivity.java
package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView mainText;
    private Button mainBtn;
    private EditText clientNameInput;
    private Spinner serviceTypeSpinner;
    private Button saveBtn;
    private long score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация элементов
        mainText = findViewById(R.id.mainTxt);
        mainBtn = findViewById(R.id.main_btn);
        clientNameInput = findViewById(R.id.client_name_input);
        serviceTypeSpinner = findViewById(R.id.service_type_spinner);
        saveBtn = findViewById(R.id.save_btn);

        // Настройка Spinner (выпадающего списка)
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.service_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        serviceTypeSpinner.setAdapter(adapter);

        // Обработчик кнопки подсчета кликов
        mainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               score++;
                String s = "Кликов: " + score;
                mainText.setText(s);
            }
        });

        // Обработчик кнопки сохранения
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String clientName = clientNameInput.getText().toString();
                String selectedService = serviceTypeSpinner.getSelectedItem().toString();

                if (clientName.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Введите имя клиента", Toast.LENGTH_SHORT).show();
                } else {
                    String message = "Клиент: " + clientName + "\nУслуга: " + selectedService;
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
