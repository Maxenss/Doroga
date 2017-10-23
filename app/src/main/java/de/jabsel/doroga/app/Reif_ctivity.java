package de.jabsel.doroga.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Reif_ctivity extends AppCompatActivity {

    String[] names = {
            "Beni1", "Patrik1", "Andi1", "Regina1", "Sany1", "Daniel1" };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reif_);

    }

// Menu:....

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_reif_, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        TextView headerView = (TextView) findViewById(R.id.header);
        switch (id) {
            case R.id.action_daten_aktualisieren:
                headerView.setText("Aktualisiert");
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

