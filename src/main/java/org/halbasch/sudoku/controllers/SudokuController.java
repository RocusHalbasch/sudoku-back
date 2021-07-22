package org.halbasch.sudoku.controllers;

import org.halbasch.sudoku.SudokuStringUtils;
import org.halbasch.sudoku.constructordi.SudokuDLXFactory;
import org.halbasch.sudoku.dlx.Groups;
import org.halbasch.sudoku.dlx.SudokuDLX;
import org.halbasch.sudoku.dtos.SudokuSolution;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://sudoku.halbasch.org"})
public class SudokuController {
    private final SudokuDLXFactory sudokuDLXFactory;

    public SudokuController(SudokuDLXFactory sudokuDLXFactory) {
		this.sudokuDLXFactory = sudokuDLXFactory;
	}
    
    @GetMapping("/sudoku")
    public SudokuSolution solveSudoku(@RequestParam(required = false) String solve, @RequestParam Groups[] groups) {
    	SudokuDLX sudoku = sudokuDLXFactory.getSudokuDLX(groups);
    	if(solve != null)
    		sudoku.setClues(SudokuStringUtils.toArray(solve));
    	else
    		sudoku.generate();
    	return new SudokuSolution(sudoku.getClues(), sudoku.getAll(), sudoku.getClueStatus(), sudoku.getAnswerStatus());
    }
}