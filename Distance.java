import java.util.*;

public class Distance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get start point from user
        System.out.print("Enter start point (x, y): ");
        int[] start = new int[2];
        start[0] = scanner.nextInt();
        start[1] = scanner.nextInt();

        // Get path from user
        System.out.print("Enter path: ");
        String path = scanner.next();

        // Initialize x and y coordinates
        int x = start[0];
        int y = start[1];

        // Iterate through path and update x and y coordinates
        for (int i = 0; i < path.length(); i++) {
            char direction = path.charAt(i);
            if (direction == 'N') {
                y++;
            } else if (direction == 'S') {
                y--;
            } else if (direction == 'E') {
                x++;
            } else if (direction == 'W') {
                x--;
            }
        }

        // Calculate distance using Pythagorean theorem
        double distance = Math.sqrt(Math.pow(x - start[0], 2) + Math.pow(y - start[1], 2));

        System.out.println("Shortest distance: " + distance);
    }
}
