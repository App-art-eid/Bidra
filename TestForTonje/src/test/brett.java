package test;

public class brett {
	
	private static final int K = 5;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printBoard(K);
	}
	
	public static void printBoard(int size){
		int[][] board = new int[size][size];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = 0;
				System.out.println(board[i][j]);
			}
		}
	}
	

}
