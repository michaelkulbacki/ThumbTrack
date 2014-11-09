package ubhacking.thumbpedometer;

import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/**
 * Created by John on 11/7/14.
 */
public class Touchable implements View.OnTouchListener{
    private MotionEvent.PointerCoords _event;
    private Data _data;
    private float xInit, yInit;
    public Touchable(Data d){
        super();
        _data=d;
//        System.out.println("Touchable Created");
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
        //System.out.println(motionEvent.getAction());


        if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
//            System.out.println("Touch Start");
            xInit=motionEvent.getRawX();
            yInit=motionEvent.getRawY();
            System.out.println("Raw x: "+motionEvent.getRawX());
            System.out.println("Raw y: "+motionEvent.getRawY());
        }
        else {
            if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                System.out.println("Raw x: "+motionEvent.getRawX());
                System.out.println("Raw y: "+motionEvent.getRawY());
              float a=  _data.setX(motionEvent.getRawX() - xInit);
              float b=  _data.setY(motionEvent.getRawY() - yInit);
                System.out.println("Total x distance: "+a);
                System.out.println("Total y distance: "+b);
                _data.setTotalDist(motionEvent.getRawX() - xInit, motionEvent.getRawY() - yInit);
//            System.out.println("Touch end"+'\n');

            }
        }

        return true;
    }
}
