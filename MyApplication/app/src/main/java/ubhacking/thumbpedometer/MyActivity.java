package ubhacking.thumbpedometer;

import android.app.Activity;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class MyActivity extends Activity{
    private float _density, _xDist,_yDist, _totalDist;
    private SharedPreferences _save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getActionBar().hide();
        super.onCreate(savedInstanceState);
        _save= getSharedPreferences("Database",MODE_PRIVATE);
        Data data = new Data();
        setDensity();
        setContentView(R.layout.activity_my);

        _xDist=_save.getFloat("xDist",0);
        _yDist =_save.getFloat("yDist",0);
        _density = _save.getFloat("density",setDensity());
        data.setX(_xDist);
        data.setY(_yDist);
        TextView totalInches = (TextView)findViewById(R.id.totalinches);
        totalInches.setText("I made a change");
        _totalDist = data.setTotalDist(_xDist,_yDist);
        System.out.println("x distance from float create: " + _xDist);
        System.out.println("y distance from float create: "+_yDist);
        System.out.println("Density from float create: "+_density);

        View v = getWindow().getDecorView();

        v.setOnTouchListener(new Touchable(data));  //Must give value of data class
    }

    @Override
    protected void onResume() {
        super.onResume();
        _xDist=_save.getFloat("xDist",0);
        _yDist =_save.getFloat("yDist",0);
        _density = _save.getFloat("density",setDensity());
        System.out.println("x distance from float resume: " + _xDist);
        System.out.println("y distance from float resume: "+_yDist);
        System.out.println("Density from float resume: "+_density);
    }

    @Override
    protected void onPause() {
        _save.edit().putFloat("xDist",_xDist).commit();
        _save.edit().putFloat("yDist",_yDist).commit();
        _save.edit().putFloat("density",_density).commit();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        _save.edit().putFloat("xDist",_xDist).commit();
        _save.edit().putFloat("yDist",_yDist).commit();
        _save.edit().putFloat("density",_density).commit();
        super.onDestroy();
    }

    public float setDensity(){
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        return _density = dm.xdpi;
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
