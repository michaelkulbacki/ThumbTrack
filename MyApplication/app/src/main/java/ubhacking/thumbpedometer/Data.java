package ubhacking.thumbpedometer;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.util.DisplayMetrics;

/**
 * Created by John on 11/7/14.
 */
public class Data extends ContentProvider {
    private float _xDistPixels, _yDistPixels, _totalDistPixels;


    @Override
    public boolean onCreate() {
        DisplayMetrics dm = new DisplayMetrics();
        _xDistPixels=0;
        _yDistPixels=0;
        _totalDistPixels=0;
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings2, String s2) {
        return null;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

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




    //Sets Y dist
    public void setY(float yChange){
        _yDistPixels +=Math.abs(yChange);
        System.out.println("Total y distance pixels: "+ _yDistPixels);

    }

    //Set X Dist
    public void setX(float xChange){

        _xDistPixels +=Math.abs(xChange);
        System.out.println("Total x Distance: "+ _xDistPixels);
    }

    //Set Total distance
    public void setTotalDist(float xChange, float yChange){
        _totalDistPixels +=Math.sqrt(Math.abs((Math.pow(xChange, 2) + Math.pow(yChange, 2))));
        System.out.println("Total Distance scrolled: "+ _totalDistPixels);
    }


    public float getXDist(){return _xDistPixels;}

    public float getYDist(){return _yDistPixels;}

    public float getTotalDist(){return _totalDistPixels;}
}
