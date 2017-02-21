package adiel.bpcontentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by recntrek7 on 21/02/17.
 */

public class MyNameProvider extends ContentProvider {

    private static final int NAME=1;
    private static UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    SharedPreferences sharedPreferences;

    static {
        uriMatcher.addURI(ContentProviderAct.CONTENT_AUTHROITY,ContentProviderAct.PATH_NAME,NAME);
    }


    @Override
    public boolean onCreate() {
        sharedPreferences = getContext().getSharedPreferences("MySp", Context.MODE_PRIVATE);
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1) {
        return null;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;
    }
}
