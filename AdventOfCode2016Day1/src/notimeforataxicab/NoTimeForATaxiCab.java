package notimeforataxicab;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class NoTimeForATaxiCab {
	
	private Set<Position> visitedPositions = new LinkedHashSet<>();
    private Set<Position> twiceVisitedPositions = new LinkedHashSet<>();

    private Direction direction = Direction.NORTH;
    private Position currentPosition = new Position(0, 0);


    public void followInstructions(String insturction, String seperator) {
        List<String> insturctions = Arrays.asList(insturction.split(seperator));
        followInstructions(insturctions);
    }

    public void followInstructions(List<String> insturctions) {
        for (String insturction : insturctions) {
            followInstruction(insturction);
        }
    }

    public void followInstruction(String instruction) {
        char turnDirection = instruction.charAt(0);
        int blocksToMove = Integer.valueOf(instruction.substring(1));
        if (turnDirection == 'R') {
            direction = direction.turnRight();
            moveForward(blocksToMove);
        } else if (turnDirection == 'L') {
            direction = direction.turnLeft();
            moveForward(blocksToMove);
        } else {
            throw new IllegalArgumentException(
                    String.format("Unexpected direction '%s' in instruction: '%s'", turnDirection, instruction));
        }
    }


    private void moveForward(int blocksToMove) {
        for (int i = 0; i < blocksToMove; i++) {
            currentPosition = new Position(currentPosition);
            if (direction == Direction.NORTH) {
                currentPosition.y++;
            } else if (direction == Direction.SOUTH) {
                currentPosition.y--;
            } else if (direction == Direction.EAST) {
                currentPosition.x++;
            } else if (direction == Direction.WEST) {
                currentPosition.x--;
            } else {
                throw new IllegalStateException("Taxicab faces in unknown direction " + direction);
            }
            boolean newVisitedPosition = visitedPositions.add(currentPosition);
            if (!newVisitedPosition) {
                twiceVisitedPositions.add(currentPosition);
            }
        }
    }


    public int getBlocksAway() {
        return currentPosition.getBlocksAway();
    }

    public Set<Position> getTwiceVisitedPositions() {
        return twiceVisitedPositions;
    }    

}
