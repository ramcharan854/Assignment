package notimeforataxicab;

import java.util.Scanner;

public class Day1PuzzleMain {

	public static void main(String[] args) {
		System.out.println("Enter current position: ");
		Scanner scanner = new Scanner(System.in);
        String instructions = scanner.nextLine() ;
        NoTimeForATaxiCab taxicab = new NoTimeForATaxiCab();
        taxicab.followInstructions(instructions, ",");
        int blocksAway = taxicab.getBlocksAway();
        System.out.printf("Our taxicab is '%d' blocks away from our starting position", blocksAway);
	}

}
