package ubhacking.thumbpedometer;

/**
 * Created by John on 11/7/14.
 */
public class Data {
    private float _xDist, _yDist, _totalDist;

    public Data(){

    }

    //Set X Dist
    public void setX(float xChange){

        _xDist+=xChange;
        System.out.println(_xDist);
    }
}
