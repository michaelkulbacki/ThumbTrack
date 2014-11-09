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
    private float _density;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getActionBar().hide();
        super.onCreate(savedInstanceState);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        _density = dm.xdpi;

        setContentView(R.layout.activity_my);
        View v = getWindow().getDecorView();

//        v.setOnTouchListener(new Touchable(data));  //Must give value of data class



    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
        //Write text file with density, xpixels, ypixels
    }


}
