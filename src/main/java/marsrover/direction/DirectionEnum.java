package marsrover.direction;

public enum DirectionEnum {

    N(new NorthDirection()),

    E(new EastDirection()),

    S(new SouthDirection()),

    W(new WestDirection());

    private final IDirection direction;

    DirectionEnum(IDirection direction) {
        this.direction = direction;
    }

    public IDirection getDirection() {
        return direction;
    }
}
