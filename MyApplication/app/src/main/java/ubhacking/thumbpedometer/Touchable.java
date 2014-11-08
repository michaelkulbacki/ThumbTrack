package ubhacking.thumbpedometer;

import android.view.MotionEvent;
import android.view.View;

/**
 * Created by John on 11/7/14.
 */
public class Touchable implements View.OnTouchListener{
    private MotionEvent.PointerCoords _event;

    public Touchable(){
        super();
        System.out.println("Touchable Created");
    }

    //Calculates total distance of motion _event
    public float calcDist(float x, float y){
        return (float)Math.abs((Math.pow(x,2)+Math.pow(y,2)));
    }

    //Gets x component of motion _event
//    public float getX(){
//        return _event.x;
//    }

    //Gets y component of motion _event
//    public float getY(){
//        return _event.y;
//    }

    //Gets total dist moved
    public float getTotalDist(){
        return calcDist(_event.x, _event.y);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent){
        System.out.println("Touch Start");
        System.out.println("Raw x: "+motionEvent.getRawX());
        System.out.println("Raw y: "+motionEvent.getRawY());
//        System.out.println("getX: "+motionEvent.getX());
//        System.out.println("getY: "+motionEvent.getY());
        System.out.println("Touch complete");
        return true;
    }
}
