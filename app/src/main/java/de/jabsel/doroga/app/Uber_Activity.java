package de.jabsel.doroga.app;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Uber_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uber_);
    }

// für Menü:...

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_uber_, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
            int id = item.getItemId();
            TextView headerView = (TextView) findViewById(R.id.header1);
            switch (id) {
                case R.id.action_daten_aktualisieren:
                    headerView.setText("Aktualisiert!");
                    return true;
            }
            return super.onOptionsItemSelected(item);
        }
    }