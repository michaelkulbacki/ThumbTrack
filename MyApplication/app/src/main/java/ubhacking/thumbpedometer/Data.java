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
    private float _xDistPixels, _yDistPixels, _totalDistPixels, _totalDistInch,_xDistInch, _yDistInch;
    private float _density;


    @Override
    public boolean onCreate() {
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


    public Data(DisplayMetrics d){
         _density= d.xdpi;
        System.out.println("Density: "+_density);
    }

    //Sets Y dist
    public void setY(float yChange){
        _yDistPixels +=Math.abs(yChange);
        _yDistInch=_yDistPixels/_density;
        System.out.println("Total y distance pixels: "+ _yDistPixels);
        System.out.println("Total y dist inches: "+ _yDistInch);
    }

    //Set X Dist
    public void setX(float xChange){

        _xDistPixels +=Math.abs(xChange);
        _xDistInch=_xDistPixels/_density;
        System.out.println("Total x Distance: "+ _xDistPixels);
        System.out.println("Total x distance: "+ _xDistInch);
    }

    //Set Total distance
    public void setTotalDist(float xChange, float yChange){
        _totalDistPixels +=Math.sqrt(Math.abs((Math.pow(xChange, 2) + Math.pow(yChange, 2))));
        _totalDistInch=_totalDistPixels/_density;
        System.out.println("Total Distance scrolled: "+ _totalDistPixels);
        System.out.println("Total Distance inch: "+_totalDistInch);
    }

    public void setDensity(float pixDensity){
        _density = pixDensity;
    }

    public float getXDist(){return _xDistPixels/_density;}
}
