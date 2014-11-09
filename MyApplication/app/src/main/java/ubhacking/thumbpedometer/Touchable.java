package ubhacking.thumbpedometer;

import java.lang.reflect.Array;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;

/**
 * Created by John on 11/7/14.
 */


public class Touchable implements View.OnTouchListener{
    private int[] _list;
    private int _count;
    private MotionEvent.PointerCoords _event;
    private Data _data;
    private float xInit, yInit;
    public Touchable(Data d){

        super();
        _data=d;
        _list = new int[10];
        _count = 0;
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

    private VelocityTracker vTracker = null;
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent){
        //System.out.println(motionEvent.getAction());


        if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
            if(vTracker == null){
                vTracker = VelocityTracker.obtain();
            }
            else{
                vTracker.clear();
            }
            vTracker.addMovement(motionEvent);

//            System.out.println("Touch Start");
            xInit=motionEvent.getRawX();
            yInit=motionEvent.getRawY();
            System.out.println("Raw x: "+motionEvent.getRawX());
            System.out.println("Raw y: "+motionEvent.getRawY());
        }
        if(motionEvent.getAction()== MotionEvent.ACTION_MOVE){
            vTracker.addMovement(motionEvent);
            vTracker.computeCurrentVelocity(1000);
            int Xvel = (int)vTracker.getXVelocity();
            int Yvel = (int)vTracker.getYVelocity();
            double totalV = Math.sqrt(Math.pow(Xvel,2) + Math.pow(Yvel,2));
            int total = (int)totalV;
            _list[_count] = total;
            _count++;
            if(_count==10){
                _count = 0;
                System.out.println("Average Velocity " + velocity(_list));
            }



        }
        if(motionEvent.getAction() == MotionEvent.ACTION_CANCEL){
            vTracker.recycle();
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

    public int velocity(int[] list){
        int velocity = (list[0] + list[1] + list[2] + list[3] + list[4] + list[5] + list[6] + list[7] + list[8] + list[9])/2;
        return velocity;
    }
}
