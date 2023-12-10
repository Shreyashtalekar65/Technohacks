package in28Min;

import java.util.Random;
import java.util.Scanner;

class TicTacToe {
	char[][] board;
	char userPlayer;
	char computerPlayer;

	public TicTacToe() {
		board = new char[4][4];
		userPlayer = 'X';
		computerPlayer = 'O';
		initBoard();
	}

	void initBoard() {
		for (int i = 1; i < board.length; i++) {
			for (int j = 1; j < board[i].length; j++) {
				board[i][j] = ' ';
			}
		}
	}

	void dispBoard() {
		System.out.println("-------------------");
		for (int i = 1; i < board.length; i++) {
			System.out.print("|  ");
			for (int j = 1; j < board[i].length; j++) {
				System.out.print(board[i][j] + "  |  ");
			}
			System.out.println();
			System.out.println("-------------------");
		}
	}

	void placeUserMark(int row, int column) {
		if (row >= 1 && row <= 3 && column >= 1 && column <= 3 && board[row][column] == ' ') {
			board[row][column] = userPlayer;
		} else {
			System.err.println("Invalid Position. Try again.");
			userMove();
		}
	}

	void placeComputerMark() {
		Random random = new Random();
		int row, column;

		do {
			row = random.nextInt(3) + 1;
			column = random.nextInt(3) + 1;
		} while (board[row][column] != ' ');

		board[row][column] = computerPlayer;
	}

	boolean checkWin(char player) {
		return checkRowWin(player) || checkColWin(player) || checkDiagonalWin(player);
	}

	boolean checkColWin(char player) {
		for (int j = 1; j <= 3; j++) {
			if (board[1][j] == player && board[2][j] == player && board[3][j] == player) {
				return true;
			}
		}
		return false;
	}

	boolean checkRowWin(char player) {
		for (int i = 1; i <= 3; i++) {
			if (board[i][1] == player && board[i][2] == player && board[i][3] == player) {
				return true;
			}
		}
		return false;
	}

	boolean checkDiagonalWin(char player) {
		return (board[1][1] == player && board[2][2] == player && board[3][3] == player)
				|| (board[1][3] == player && board[2][2] == player && board[3][1] == player);
	}

	boolean isBoardFull() {
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {
				if (board[i][j] == ' ') {
					return false;
				}
			}
		}
		return true;
	}

	void userMove() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter your move (row and column): ");
		int row = scanner.nextInt();
		int column = scanner.nextInt();

		placeUserMark(row, column);
	}

	void computerMove() {
		System.out.println("Computer's move:");
		placeComputerMark();
	}
}

public class TicTacToeGame {
	public static void main(String[] args) {
		TicTacToe game = new TicTacToe();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			game.dispBoard();

			// User's turn
			game.userMove();
			if (game.checkWin(game.userPlayer)) {
				game.dispBoard();
				System.out.println("Congratulations! You win!");
				break;
			} else if (game.isBoardFull()) {
				game.dispBoard();
				System.out.println("It's a draw!");
				break;
			}

			// Computer's turn
			game.computerMove();
			if (game.checkWin(game.computerPlayer)) {
				game.dispBoard();
				System.out.println("Sorry, you lose. Better luck next time!");
				break;
			} else if (game.isBoardFull()) {
				game.dispBoard();
				System.out.println("It's a draw!");
				break;
			}
		}

		scanner.close();
	}
}
