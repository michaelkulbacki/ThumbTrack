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
    private TextView _Xinch, _Xfeet, _Xmiles, _Yinch, _Yfeet, _Ymiles, _Totalinch,
            _Totalfeet, _Totalmiles;
    private float xInit, yInit;
    private float _xDist, _yDist, _totalDist, _density;

    public Touchable(Data d, TextView Xin, TextView Xfeet, TextView Xmiles,
                     TextView Yin, TextView Yfeet, TextView Ymiles,
                     TextView Totalin, TextView Totalfeet, TextView Totalmiles, float density){
        super();
        _data=d;
        _Xinch = Xin;
        _Xfeet = Xfeet;
        _Xmiles = Xmiles;
        _Yinch = Yin;
        _Yfeet = Yfeet;
        _Ymiles = Ymiles;
        _Totalinch = Totalin;
        _Totalfeet = Totalfeet;
        _Totalmiles = Totalmiles;
        _density = density;
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
              _xDist=  _data.setX(motionEvent.getRawX() - xInit);
              _yDist=  _data.setY(motionEvent.getRawY() - yInit);
//                System.out.println("Total x distance: "+a);
//                System.out.println("Total y distance: "+b);
                _data.setTotalDist(motionEvent.getRawX() - xInit, motionEvent.getRawY() - yInit);
                _Xinch.setText("" + calcXInch());
                _Xfeet.setText("" + calcXFeet());
                _Xmiles.setText("" + calcXMiles());
                _Yinch.setText("" + calcYInch());
                _Yfeet.setText("" + calcYFeet());
                _Ymiles.setText("" + calcYMiles());
                _Totalinch.setText("" + calcTotalInch());
                _Totalfeet.setText("" + calcTotalFeet());
                _Totalmiles.setText("" + calcTotalMiles());

//            System.out.println("Touch end"+'\n');

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
}
