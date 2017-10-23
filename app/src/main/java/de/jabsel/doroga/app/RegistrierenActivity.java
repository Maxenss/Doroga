package de.jabsel.doroga.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;

// "UserActivity"
public class RegistrierenActivity extends AppCompatActivity {

    private final static String FILE_NAME = "content.text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrieren);
    }
    //сохранение файла
    public void saveText(View view) {

        FileOutputStream fos = null;
        try {
            EditText textBox = (EditText) findViewById(R.id.name);
            String text = textBox.getText().toString();

            fos = openFileOutput(FILE_NAME, MODE_APPEND);
            fos.write(text.getBytes());
            Toast.makeText(this, "Daten gespeichert", Toast.LENGTH_SHORT).show();
        } catch (IOException ex) {

            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        } finally {
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException ex) {

                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    //alt: Menu +...
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_registrieren, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        startActivity(new Intent(RegistrierenActivity.this, AGBActivity.class));
        switch (id) {
            case R.id.activity_agb:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
