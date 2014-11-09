package ubhacking.thumbpedometer;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

/**
 * Created by John on 11/8/14.
 */
public class ThummyService extends Service {
    private Data _data;
    private static final String TAG = ThummyService.class.getSimpleName();

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    MyActivity _act;
    @Override
    public void onCreate() {
        super.onCreate();
        _act = new MyActivity();
        DisplayMetrics dm = new DisplayMetrics();
        _act.getWindowManager().getDefaultDisplay().getMetrics(dm);
//        _data = new Data(dm);

        Log.d(TAG, "onCreate Finished");
    }

    @Override
    public void onStart(Intent intent, int startId) {
//        super.onStart(intent, startId);
//        View v = _act.getWindow().getDecorView();
////        System.out.println("View Set");
//
//        v.setOnTouchListener(new Touchable(_data));

        Log.d(TAG,"OnStart complete");
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.d(TAG,"onDestroy completed");
    }

}
