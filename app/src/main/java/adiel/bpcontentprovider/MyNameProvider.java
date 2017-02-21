package adiel.bpcontentprovider;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;

/**
 * Created by recntrek7 on 21/02/17.
 */

public class MyNameProvider extends ContentProvider {

    private int counter=0;
    private static final int NAME=1;
    private static UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    SharedPreferences sharedPreferences;
    MyCursor myCursor;

    static {
        uriMatcher.addURI(ContentProviderAct.CONTENT_AUTHROITY,ContentProviderAct.PATH_NAME,NAME);
    }


    @Override
    public boolean onCreate() {
        myCursor = new MyCursor();
        sharedPreferences = getContext().getSharedPreferences("MySp", Context.MODE_PRIVATE);
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String orderBy) {
        int match = uriMatcher.match(uri);

        switch (match){
            case NAME:
                String name = sharedPreferences.getString(projection[0], "empty");
                Bundle bundle = new Bundle();
                bundle.putString("name",name);
                myCursor.myData = bundle;
                break;
            default:
                throw new IllegalArgumentException();

        }
        myCursor.setNotificationUri(getContext().getContentResolver(),uri);
        return myCursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        Uri retVal;
        int match = uriMatcher.match(uri);
        switch (match){
            case NAME:
                String name = contentValues.getAsString("name");
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name",name);
                editor.commit();
                retVal=Uri.parse("new name:"+name);
                break;
            default:
                throw new IllegalArgumentException("wrong insert uri");
        }
        getContext().getContentResolver().notifyChange(uri,null);
        return retVal;
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;
    }

    public class MyCursor implements Cursor {

        public Bundle myData;
        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public int getPosition() {
            return 0;
        }

        @Override
        public boolean move(int i) {
            return false;
        }

        @Override
        public boolean moveToPosition(int i) {
            return false;
        }

        @Override
        public boolean moveToFirst() {
            return false;
        }

        @Override
        public boolean moveToLast() {
            return false;
        }

        @Override
        public boolean moveToNext() {
            return false;
        }

        @Override
        public boolean moveToPrevious() {
            return false;
        }

        @Override
        public boolean isFirst() {
            return false;
        }

        @Override
        public boolean isLast() {
            return false;
        }

        @Override
        public boolean isBeforeFirst() {
            return false;
        }

        @Override
        public boolean isAfterLast() {
            return false;
        }

        @Override
        public int getColumnIndex(String s) {
            return 0;
        }

        @Override
        public int getColumnIndexOrThrow(String s) throws IllegalArgumentException {
            return 0;
        }

        @Override
        public String getColumnName(int i) {
            return null;
        }

        @Override
        public String[] getColumnNames() {
            return new String[0];
        }

        @Override
        public int getColumnCount() {
            return 0;
        }

        @Override
        public byte[] getBlob(int i) {
            return new byte[0];
        }

        @Override
        public String getString(int i) {
            counter++;
            return "kkkkk:"+counter;

        }

        @Override
        public void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer) {

        }

        @Override
        public short getShort(int i) {
            return 0;
        }

        @Override
        public int getInt(int i) {
            return 0;
        }

        @Override
        public long getLong(int i) {
            return 0;
        }

        @Override
        public float getFloat(int i) {
            return 0;
        }

        @Override
        public double getDouble(int i) {
            return 0;
        }

        @Override
        public int getType(int i) {
            return 0;
        }

        @Override
        public boolean isNull(int i) {
            return false;
        }

        @Override
        public void deactivate() {

        }

        @Override
        public boolean requery() {
            return false;
        }

        @Override
        public void close() {

        }

        @Override
        public boolean isClosed() {
            return false;
        }

        @Override
        public void registerContentObserver(ContentObserver contentObserver) {

        }

        @Override
        public void unregisterContentObserver(ContentObserver contentObserver) {

        }

        @Override
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {

        }

        @Override
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

        }

        @Override
        public void setNotificationUri(ContentResolver contentResolver, Uri uri) {

        }

        @Override
        public Uri getNotificationUri() {
            return null;
        }

        @Override
        public boolean getWantsAllOnMoveCalls() {
            return false;
        }

        @Override
        public void setExtras(Bundle bundle) {

        }

        @Override
        public Bundle getExtras() {
            return null;
        }

        @Override
        public Bundle respond(Bundle bundle) {
            return null;
        }
    };

}
