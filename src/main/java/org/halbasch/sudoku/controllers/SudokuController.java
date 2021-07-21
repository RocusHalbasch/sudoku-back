package org.halbasch.sudoku.controllers;

import java.util.HashMap;
import java.util.Map;

import org.halbasch.sudoku.SudokuStringUtils;
import org.halbasch.sudoku.dlx.Groups;
import org.halbasch.sudoku.dlx.SudokuDLX;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://sudoku.halbasch.org"})
public class SudokuController {
    @GetMapping("/sudoku")
    public Map<String, Object> solveSudoku(@RequestParam(required = false) String solve, @RequestParam Groups[] groups) {
    	SudokuDLX sudoku = new SudokuDLX(groups);
    	if(solve != null)
    		sudoku.setClues(SudokuStringUtils.toArray(solve));
    	else
    		sudoku.generate();
    	Map<String, Object> out = new HashMap<>();
    	out.put("clues", sudoku.getClues());
    	out.put("all", sudoku.getAll());
    	out.put("clueStatus", sudoku.getClueStatus());
    	out.put("answerStatus", sudoku.getAnswerStatus());
    	return out;
    }
}