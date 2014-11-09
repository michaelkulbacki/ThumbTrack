package ubhacking.thumbpedometer;

import android.app.Activity;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;


public class MyActivity extends Activity{
    DisplayMetrics _dm= new DisplayMetrics();
    private boolean _initilized=false;
    private ServiceConnection _connect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        Data data = new Data(dm);
        setContentView(R.layout.activity_my);
//        System.out.println("This is a test");

        View v = getWindow().getDecorView();
//        System.out.println("View Set");

        v.setOnTouchListener(new Touchable(data));



    }

    @Override
    protected void onPause() {

    }


}
