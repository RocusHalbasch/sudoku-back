package org.halbasch.sudoku.constructordi;

import org.halbasch.sudoku.dlx.Group;
import org.halbasch.sudoku.dlx.SudokuDLX;

public class SudokuDLXFactory {
	public SudokuDLX getSudokuDLX(Group[] groups) {
		return new SudokuDLX(groups);
	}
}
