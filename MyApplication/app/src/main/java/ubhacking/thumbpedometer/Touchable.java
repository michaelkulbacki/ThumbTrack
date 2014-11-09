package ubhacking.thumbpedometer;

import android.view.VelocityTracker;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/**
 * Created by John on 11/7/14.
 */
public class Touchable implements View.OnTouchListener{

    private MotionEvent.PointerCoords _event;
    private int _count;
    private double[] _list;
    private Data _data;
    private TextView _Xinch, _Yinch, _Totalinch;
    private float xInit, yInit;
    private float _xDist, _yDist, _totalDist, _density;

    public Touchable(Data d, TextView Xin, TextView Yin, TextView Totalin, float density){
        super();
        _count = 0;
        _list = new double[10];
        _data=d;
        _Xinch = Xin;
        _Yinch = Yin;
        _Totalinch = Totalin;
        _density = density;
    }

    //Calculates total distance of motion _event
    public float calcDist(float x, float y){
        return (float)Math.abs((Math.pow(x,2)+Math.pow(y,2)));
    }


    //Gets total dist moved
    public float getTotalDist(){
        return calcDist(_event.x, _event.y);
    }

    private VelocityTracker vTracker = null;
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent){



        if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
            if(vTracker == null){
                vTracker = VelocityTracker.obtain();
            }
            else {
                vTracker.clear();
            }
            vTracker.addMovement(motionEvent);

            xInit=motionEvent.getRawX();
            yInit=motionEvent.getRawY();
            System.out.println("Raw x: "+motionEvent.getRawX());
            System.out.println("Raw y: "+motionEvent.getRawY());
        }
        if(motionEvent.getAction() == MotionEvent.ACTION_MOVE){
            vTracker.addMovement(motionEvent);
            vTracker.computeCurrentVelocity(1000);
            double xVel = (double)vTracker.getXVelocity();
            double yVel = (double)vTracker.getYVelocity();
            double total = Math.sqrt(Math.pow(xVel,2)+Math.pow(yVel,2));
            _list[_count++] = total;
            if(_count == 10){
                _count = 0;
                System.out.println("Average Velocity "+velocity(_list));
            }
        }
        else {
            if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                System.out.println("Raw x: "+motionEvent.getRawX());
                System.out.println("Raw y: "+motionEvent.getRawY());
              _xDist=  _data.setX(motionEvent.getRawX() - xInit);
              _yDist=  _data.setY(motionEvent.getRawY() - yInit);
                _totalDist=(float)Math.abs(Math.sqrt(Math.pow(_xDist,2)+Math.pow(_yDist,2)));
                _Xinch.setText("" + calcXInch());
                _Yinch.setText("" + calcYInch());
                _Totalinch.setText("" + calcTotalInch());



            }
        }

        return true;
    }

    public float calcXInch(){ return  _xDist/_density;}

    public float calcYInch(){return _yDist/_density;}

    public float calcTotalInch(){return _totalDist/_density;}

    public float calcXFeet(){return calcXInch()/12;}

    public float calcYFeet(){return calcYInch()/12;}

    public float calcTotalFeet(){return calcTotalInch()/12;}

    public float calcXMiles(){return calcXFeet()/5280;}

    public float calcYMiles(){return calcYFeet()/5280;}

    public float calcTotalMiles(){return calcTotalFeet()/5280;}

    public double velocity(double[] list){
        double velocity = (list[0]+list[1]+list[2]+list[3]+list[4]+list[5]+list[6]+list[7]+list[8]+list[9])/10.0;
        return velocity;
    }
}
