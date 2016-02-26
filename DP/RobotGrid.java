/*
	Cracking the coding interview 6th edition 
	Chapter 8 Question 2
	Question: Imagine a robot sitting on the upper left of the grid with r rows and c columns.
	The robot can move in two directions, right and down. but certain cells are "off limits" such that
	that robot cannot step on them.Design an algorithm to find a path from the top left to bottom right.
*/
import java.util.*;

class Point {
	public int row,column; 
	public Point(int row, int col) {
		this.row=row;
		this.column = col;
	}
}
public class RobotGrid {
	public static ArrayList<Point> getPath(boolean[][] maze) {
		ArrayList<Point> path = new ArrayList<Point>();
		HashSet<Point> failedPoints = new HashSet<Point>();
		if(getPath(maze, maze.length-1, maze[0].length-1, path, failedPoints)) {
			return path;
		}
		return null;
	}
	public static boolean getPath(boolean[][]maze, int row, int col,ArrayList<Point>path,HashSet<Point> failedPoints) {
		if(row<0||col<0||maze[row][col]) {
			return false;
		}
		Point p = new Point(row,col);
		if(failedPoints.contains(p)) {
			return false;
		}
		boolean isOrigin = (row==0) && (col==0);
		if(isOrigin||getPath(maze,row,col-1,path,failedPoints)|| getPath(maze,row-1,col,path,failedPoints)) {
			path.add(p);
			return true;
		}
		failedPoints.add(p);
		return false;
	}
	public static void main(String[] args) {
		boolean[][] maze = {{true,false,false,false},
                {false,false,true,false},
                {false,true,true,false},
                {true,false,true,true}};
        ArrayList<Point> path = getPath(maze);
        if(path==null) {
        	System.out.println("No Path found");
        }
        else {
        	System.out.println("Path found");
        }
	}
}