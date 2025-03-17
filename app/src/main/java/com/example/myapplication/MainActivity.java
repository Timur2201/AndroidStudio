package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private MenuHandler menuHandler;
    private Button buttonBookConsultation;
    private Button buttonMyRequests;
    private Button buttonContextMenu;
    private Button buttonShowTime;
    private Button buttonShowDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация кнопок
        buttonBookConsultation = findViewById(R.id.button_book_consultation);
        buttonMyRequests = findViewById(R.id.button_my_requests);
        buttonContextMenu = findViewById(R.id.button_context_menu);
        buttonShowTime = findViewById(R.id.button_show_time);
        buttonShowDate = findViewById(R.id.button_show_date);

        buttonBookConsultation.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, BookConsultationActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slow_slide_in_right, R.anim.slow_slide_out_left);
        });


        buttonMyRequests.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MyRequestsActivity.class);
            startActivity(intent);
        });

        buttonShowTime.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ShowTimeActivity.class);
            startActivity(intent);
        });

        buttonShowDate.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ShowDateActivity.class);
            startActivity(intent);
        });

        // Регистрация контекстного меню для кнопки
        registerForContextMenu(buttonContextMenu);

        menuHandler = new MenuHandler(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menuHandler.setupMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return menuHandler.handleMenuItem(item) || super.onOptionsItemSelected(item);
    }

    // Создание контекстного меню
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v.getId() == R.id.button_context_menu) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.context_menu, menu);
        }
    }

    // Обработка выбора пунктов контекстного меню
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_view_lawyers) {
            Toast.makeText(this, "Список юристов", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_cancel_booking) {
            Toast.makeText(this, "Запись отменена", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            return super.onContextItemSelected(item);
        }
    }
}
