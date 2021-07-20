package org.halbasch.sudoku.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.halbasch.sudoku.SudokuStringUtils;
import org.halbasch.sudoku.dlx.Group;
import org.halbasch.sudoku.dlx.SudokuDLX;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://sudoku.halbasch.org"})
public class SudokuController {
    private static Group getGroup(String group) {
    	switch(group) {
	    	case "rows": return Group.rows;
	    	case "columns": return Group.columns;
	    	case "blocks": return Group.blocks;
	    	case "positions": return Group.positions;
	    	case "windows": return Group.windows;
	    	case "crosses": return Group.crosses;
	    	default: return null;
    	}
    }
    
    @GetMapping("/sudoku")
    public Map<String, Object> solveSudoku(@RequestParam(required = false) String solve, @RequestParam(required = false) List<String> groups) {
    	Group[] rules = {Group.rows, Group.columns, Group.blocks};
    	if(groups != null)
    		rules = groups.stream().map(x->getGroup(x)).toArray(Group[]::new);
    	SudokuDLX sudoku = new SudokuDLX(rules);
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