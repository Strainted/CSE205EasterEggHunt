import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class MazeSolver {

	
private Stack<Node> stack;
private char[][] maze;
private int eggFound;
private int mHeight;
private int mWidth;

public MazeSolver() { //default constructor
	stack = new Stack<Node>();
	eggFound = 0;
}

public void printMaze() { //prints the maze
	int i;
	int j;
	for (i = 0; i < mHeight; i++) {		//Iterates through the columns 
		for (j = 0; j < mWidth; j++) { //iterates through the rows
			System.out.print(maze[i][j]);
		}
		System.out.println();
	}
}

public void depthFirstSearch() { //the search method to find the eggs in the char array
	Node start = new Node(0,0); //pushes node at 0,0 position 
	stack.push(start);
	while (stack.isEmpty() == false) { //infinite loop to go through all possible routes to find the eggs 
			Node val = stack.pop();
			if (maze[val.getX()][val.getY()] == 'E') { //if char equals 'E' the eggCount is increased
				eggFound += 1;
			}		
			maze[val.getX()][val.getY()] = 'x';
			
			
			Node south =  new Node(val.getX() + 1,val.getY()); //finds the node to the south and decides if its in the maze and a valid path
			if (south.getX() >= 0 && south.getY() >= 0 && south.getX() < mHeight && south.getY() < mWidth) {
				if ((maze[south.getX()][south.getY()] != '#') && (maze[south.getX()][south.getY()] != 'x')) {
					stack.push(south);
			}
		}
			Node east = new Node(val.getX(), val.getY() + 1);//finds the node to the east and decides if its in the maze and a valid path
			if (east.getX() >= 0 && east.getY() >= 0 && east.getX() < mHeight && east.getY() < mWidth) {
				if ((maze[east.getX()][east.getY()] != '#') && (maze[east.getX()][east.getY()] != 'x')) {
					stack.push(east);
			}
		}
			Node north = new Node(val.getX() - 1, val.getY()); //finds the node to the north and decides if its in the maze and a valid path
			if (north.getX() >= 0 && north.getY() >= 0 && north.getX() < mHeight && north.getY() < mWidth) {
				if ((maze[north.getX()][north.getY()] != '#') && (maze[north.getX()][north.getY()] != 'x')) {
					stack.push(north);
			}
		}
			Node west = new Node(val.getX(), val.getY() - 1); //finds the node to the west and decides if its in the maze and a valid path
			if (west.getX() >= 0 && west.getY() >= 0 && west.getX() < mHeight && west.getY() < mWidth) {
				if ((maze[west.getX()][west.getY()] != '#') && (maze[west.getX()][west.getY()] != 'x')) {
					stack.push(west);
			}
		}
	}
}

	// ************************************************************************************
	// ************** Utility method to read maze from user input *************************
	// ************************************************************************************
	public void readMaze() {

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Height of the maze: ");
			String line = reader.readLine();
			mHeight = Integer.parseInt(line);

			System.out.println("Width of the maze: ");
			line = reader.readLine();
			mWidth = Integer.parseInt(line);
			maze = new char[mHeight][mWidth];

			for (int i = 0; i < mHeight; i++) {
				line = reader.readLine();
				for (int j = 0; j < mWidth; j++) {
					maze[i][j] = line.charAt(j);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public int getEggFound() { //getter method for the egg count 
		return eggFound;
	}
}
