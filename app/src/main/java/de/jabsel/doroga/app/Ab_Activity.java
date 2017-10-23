package de.jabsel.doroga.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Ab_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ab_);
    }
    //SMS:


// Menu-Taste, nicht angeschlossen...

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_ab_, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        TextView headerView = (TextView) findViewById(R.id.textView6);
        switch (id) {
            case R.id.action_daten_aktualisieren:
                headerView.setText("Aktualisiert");
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
