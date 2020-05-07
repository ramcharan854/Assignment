package notimeforataxicab;



public class Position {
	
	int x;
    int y;


    public Position(Position position) {
        this(position.x, position.y);
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public int getBlocksAway() {
        return Math.abs(x) + Math.abs(y);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Position))
            return false;

        Position position = (Position) o;

        if (x != position.x)
            return false;
        return y == position.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return "(" + x + ";" + y + ")";
    }
}
