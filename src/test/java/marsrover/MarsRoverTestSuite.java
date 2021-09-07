package marsrover;


import marsrover.command.MoveForwardCommandTest;
import marsrover.command.SpinLeftCommandTest;
import marsrover.command.SpinRightCommandTest;
import marsrover.direction.EastDirectionTest;
import marsrover.direction.NorthDirectionTest;
import marsrover.direction.SouthDirectionTest;
import marsrover.direction.WestDirectionTest;
import marsrover.landingsurface.PlateauTest;
import marsrover.rover.RoverExceptionTest;
import marsrover.rover.RoverTest;
import marsrover.utils.InputUtilTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        MoveForwardCommandTest.class,
        SpinLeftCommandTest.class,
        SpinRightCommandTest.class,
        EastDirectionTest.class,
        NorthDirectionTest.class,
        SouthDirectionTest.class,
        WestDirectionTest.class,
        RoverTest.class,
        RoverExceptionTest.class,
        InputUtilTest.class,
        PlateauTest.class
})
public class MarsRoverTestSuite extends BaseTest {

}
