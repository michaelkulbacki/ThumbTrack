package ubhacking.thumbpedometer;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.util.DisplayMetrics;

/**
 * Created by John on 11/7/14.
 */
public class Data{
    private float _xDistPixels, _yDistPixels, _totalDistPixels;

    //Sets Y dist
    public float setY(float yChange){
        return _yDistPixels +=Math.abs(yChange);
    }

    //Set X Dist
    public float setX(float xChange){
        return _xDistPixels +=Math.abs(xChange);
    }

    //Set Total distance
    public float setTotalDist(float xChange, float yChange){
        return _totalDistPixels +=Math.sqrt(Math.abs((Math.pow(xChange, 2) + Math.pow(yChange, 2))));
    }
}
