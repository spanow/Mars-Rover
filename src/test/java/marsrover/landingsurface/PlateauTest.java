package marsrover.landingsurface;


import marsrover.BaseTest;
import org.junit.Test;

import static marsrover.utils.Constants.BASE_COORDINATE_X;
import static marsrover.utils.Constants.BASE_COORDINATE_Y;
import static org.junit.Assert.assertEquals;

public class PlateauTest extends BaseTest {

    @Test
    public void whenPlateauIsConstructedLowerLeftCoordinatesAreZeroZero() {
        assertEquals(BASE_COORDINATE_X, plateau.getLowerBoundCoordinateX());
        assertEquals(BASE_COORDINATE_Y, plateau.getLowerBoundCoordinateY());
    }
}
