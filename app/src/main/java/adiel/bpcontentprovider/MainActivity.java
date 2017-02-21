package adiel.bpcontentprovider;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener{

    EditText et ;
    Button save;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText) findViewById(R.id.et);
        save = (Button) findViewById(R.id.save);
        tv = (TextView) findViewById(R.id.tv);

        SharedPreferences sharedPreferences = getSharedPreferences("MySp",MODE_PRIVATE);
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
        String name = sharedPreferences.getString("name", "empty");
        tv.setText(name);


    }

    public void save(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("MySp",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("data",et.getText().toString());
        editor.commit();
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        String name = sharedPreferences.getString(s, "weird");
        tv.setText(name);
    }

    public void moveTo(View view) {
        startActivity(new Intent(MainActivity.this,ContentProviderAct.class));
    }
}
