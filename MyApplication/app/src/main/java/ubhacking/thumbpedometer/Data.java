package ubhacking.thumbpedometer;

/**
 * Created by John on 11/7/14.
 */
public class Data {
    private float _xDist, _yDist, _totalDist;

    public Data(){

    }

    //Sets Y dist
    public void setY(float yChange){
        _yDist+=Math.abs(yChange);
        System.out.println("Total y distance: "+_yDist);
    }

    //Set X Dist
    public void setX(float xChange){

        _xDist+=Math.abs(xChange);
        System.out.println("Total x Distance: "+_xDist);
    }

    //Set Total distance
    public void setTotalDist(float xChange, float yChange){
        _totalDist+=Math.abs((Math.pow(xChange,2)+Math.pow(yChange,2)));
        System.out.println("Total Distance scrolled: "+_totalDist);
    }
}
