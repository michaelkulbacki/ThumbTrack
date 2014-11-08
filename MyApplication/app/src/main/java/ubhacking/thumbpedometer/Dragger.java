package ubhacking.thumbpedometer;

import android.view.DragEvent;
import android.view.View;

/**
 * Created by John on 11/8/14.
 */
public class Dragger implements View.OnDragListener {
    public Dragger(){
        super();
        System.out.println("Dragger Created");
    }
    @Override
    public boolean onDrag(View view, DragEvent dragEvent) {
        System.out.println("dragged");
        return false;
    }
}
