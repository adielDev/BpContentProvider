package adiel.bpcontentprovider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.Loader;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.app.LoaderManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ContentProviderAct extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    public static final String CONTENT_AUTHROITY ="adiel.content";
    public static final String PATH_NAME="name";

    public static final Uri BASE_CONTENT_URI =Uri.parse("content://"+CONTENT_AUTHROITY);
    public static final Uri NAME_URI =Uri.withAppendedPath(BASE_CONTENT_URI,PATH_NAME);
    private static final int URL_LOADER = 0;

    EditText et ;
    Button save;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLoaderManager().initLoader(URL_LOADER,null,this);
        setContentView(R.layout.activity_content_provider);

        et = (EditText) findViewById(R.id.et);
        save = (Button) findViewById(R.id.save);
        tv = (TextView) findViewById(R.id.tv);


    }

    public void save(View view) {

        ContentResolver contentResolver = getContentResolver();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",et.getText().toString());
        Uri insert = contentResolver.insert(NAME_URI, contentValues);
        Log.d("adiel","returned from provider :"+insert);

    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        String [] projection = new String[]{"name"};
        CursorLoader cursorLoader = new CursorLoader(this,NAME_URI,projection,null,null,null);
        return cursorLoader;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        String name = cursor.getString(0);
        tv.setText(name);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        tv.setText("reset..");
    }
}
