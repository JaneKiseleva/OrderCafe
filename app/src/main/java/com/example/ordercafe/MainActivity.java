package com.example.ordercafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextName = findViewById(R.id.editTextName);
        editTextPassword = findViewById(R.id.editTextPassword);
    }

    public void onClickCreateOrder(View view) {
        String name = editTextName.getText().toString().trim(); //переобразовываем в формат String полученное имя пользователя, вызываем метод trim, который убирает пробелы
        String password = editTextPassword.getText().toString().trim();
        if (!name.isEmpty() && !password.isEmpty()) { //если имя не пустое
            Intent intent = new Intent(this, CreateOrderActivity.class); //активность вызывает следующую класса второй активности
            intent.putExtra("name", name);
            intent.putExtra("password", password);
            startActivity(intent);
        } else {
            Toast.makeText(this,R.string.warning_fill_fields, Toast.LENGTH_SHORT).show();
            //всплывающее сообщение, с которым не взаимодействует пользователь, контекст this, дальше само сообщение и длительность (short или long). Метод show() показывает эту активность пользователю.
        }
    }
}