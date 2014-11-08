package ubhacking.thumbpedometer;

import android.view.DragEvent;
import android.view.View;

/**
 * Created by John on 11/8/14.
 */
public class Dragger implements View.OnDragListener {
    @Override
    public boolean onDrag(View view, DragEvent dragEvent) {
        System.out.println("dragged");
        return false;
    }
}
