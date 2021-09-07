package marsrover.landingsurface;


import marsrover.BaseTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlateauTest extends BaseTest {

    @Test
    public void whenPlateauIsConstructedLowerLeftCoordinatesAreZeroZero() {
        assertEquals(0, plateau.getLowerBoundCoordinateX());
        assertEquals(0, plateau.getLowerBoundCoordinateY());
    }
}
