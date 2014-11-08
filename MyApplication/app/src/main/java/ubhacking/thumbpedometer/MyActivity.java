package ubhacking.thumbpedometer;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;


public class MyActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        System.out.println("This is a test");

        View v =getWindow().getDecorView().getRootView();

        v.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                System.out.print("Pressed");
                return true;
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

//    @Override
//    public boolean onTouch(View view, MotionEvent motionEvent) {
//          TextView test = (TextView)findViewById(R.id.test);
//            test.setText("Touch Recorded");
//
//          System.out.println("Touch Detected.");
////        System.out.println("Raw x: "+motionEvent.getRawX());
////        System.out.println("Raw y: "+motionEvent.getRawY());
////        System.out.println("getX: "+motionEvent.getX());
////        System.out.println("getY: "+motionEvent.getY());
//        return true;
//    }
}
