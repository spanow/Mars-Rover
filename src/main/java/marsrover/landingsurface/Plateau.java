package marsrover.landingsurface;


import static marsrover.utils.Constants.BASE_COORDINATE_X;
import static marsrover.utils.Constants.BASE_COORDINATE_Y;

public class Plateau {

    private final Point base = new Point (BASE_COORDINATE_X,BASE_COORDINATE_Y);
    private final Point upperBound = new Point (0,0);


    public Plateau(Point upperBound) {
        this.upperBound.setX(upperBound.getX());
        this.upperBound.setY(upperBound.getY());
    }

    public int getUpperBoundCoordinateX() {
        return upperBound.getX();
    }

    public int getUpperBoundCoordinateY() {
        return upperBound.getY();
    }

    public int getLowerBoundCoordinateX() {
        return base.getX();
    }

    public int getLowerBoundCoordinateY() {
        return base.getY();
    }
}
