package edu.algorithms.strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Determine if a Sudoku is valid, according to: http://sudoku.com.au/TheRules.aspx
 *
 * The Sudoku board could be partially filled, where empty cells are filled with the character ‘.’.
 *
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
public class ValidSudoku {

    public static void main(String[] args) {
        List<String> sudoku = new ArrayList<>();
        sudoku.add("53..7....");
        sudoku.add("6..195...");
        sudoku.add(".98....6.");
        sudoku.add("8...6...3");
        sudoku.add("4..8.3..1");
        sudoku.add("7...2...6");
        sudoku.add(".6....28.");
        sudoku.add("...419..5");
        sudoku.add("....8..79");
        System.out.println("Is Sudoku valid: " + (new ValidSudoku().isValidSudoku(sudoku) == 1 ? "yes" : "no"));
    }

    public int isValidSudoku(final List<String> A) {
        if (validRows(A) && validColumns(A) && validBoxes(A)) {
            return 1;
        }
        return 0;
    }

    public boolean validRows(List<String> sudoku) {
        for (String row : sudoku) {
            Set<Character> digits = new HashSet<>();

            for (Character c : row.toCharArray()) {
                if (digits.contains(c)) {
                    return false;
                } else if (!c.equals('.')) {
                    digits.add(c);
                }
            }
        }
        return true;
    }

    public boolean validColumns(List<String> sudoku) {
        for (int i = 0; i < 9; i++) {
            Set<Character> digits = new HashSet<>();

            for (String row : sudoku) {
                Character digit = row.charAt(i);
                if (digits.contains(digit)) {
                    return false;
                } else if (!digit.equals('.')) {
                    digits.add(digit);
                }
            }
        }
        return true;
    }

    public boolean validBoxes(List<String> sudoku) {
        for (int block = 0; block < 9; block++) {
            Set<Character> digits = new HashSet<>();
            for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {
                String row = sudoku.get(i);
                for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
                    Character digit = row.charAt(j);
                    if (digits.contains(digit)) {
                        return false;
                    } else if (!digit.equals('.')) {
                        digits.add(digit);
                    }
                }
            }

        }
        return true;
    }

}
