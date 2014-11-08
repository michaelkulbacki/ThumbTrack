package ubhacking.thumbpedometer;

import android.util.DisplayMetrics;

/**
 * Created by John on 11/7/14.
 */
public class Data {
    private float _xDistPixels, _yDistPixels, _totalDistPixels, _totalDistInch,_xDistInch, _yDistInch;
    private float _density;

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
}
