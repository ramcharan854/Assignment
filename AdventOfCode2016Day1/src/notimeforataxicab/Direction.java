package notimeforataxicab;

public enum Direction {

	NORTH, EAST, SOUTH, WEST;


    public Direction turnRight() {
        if (this.equals(WEST)) {
            return NORTH;
        }
        return Direction.values()[this.ordinal() + 1];
    }

    public Direction turnLeft() {
        if (this.equals(NORTH)) {
            return WEST;
        }
        return Direction.values()[this.ordinal() - 1];
    }
}
