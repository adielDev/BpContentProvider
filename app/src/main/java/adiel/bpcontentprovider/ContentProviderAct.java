package adiel.bpcontentprovider;

import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ContentProviderAct extends AppCompatActivity {

    public static final String CONTENT_AUTHROITY ="adiel.content";
    public static final String PATH_NAME="name";

    public static final Uri BASE_CONTENT_URI =Uri.parse("content://"+CONTENT_AUTHROITY);
    public static final Uri NAME_URI =Uri.withAppendedPath(BASE_CONTENT_URI,PATH_NAME);

    EditText et ;
    Button save;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider);

        et = (EditText) findViewById(R.id.et);
        save = (Button) findViewById(R.id.save);
        tv = (TextView) findViewById(R.id.tv);


    }

}
