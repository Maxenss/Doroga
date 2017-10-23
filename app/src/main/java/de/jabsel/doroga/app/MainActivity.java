package de.jabsel.doroga.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button swith = (Button)findViewById(R.id.button3);
        Button swith4 = (Button)findViewById(R.id.button4);
        Button swith5 = (Button)findViewById(R.id.button5);
        Button swith6 = (Button)findViewById(R.id.button6);

        swith.setOnClickListener(new View.OnClickListener() {
        @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Uber_Activity.class));
            }
        });

        swith4.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 startActivity(new Intent(MainActivity.this, Reif_ctivity.class));
             }
        });

        swith5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Ab_Activity.class));
            }
        });

        swith6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RegistrierenActivity.class));
            }
        });}

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        startActivity(new Intent(MainActivity.this, InfoActivity.class));
        switch (id) {
            case R.id.activity_info:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
