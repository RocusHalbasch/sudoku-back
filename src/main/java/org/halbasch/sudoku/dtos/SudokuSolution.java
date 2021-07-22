package org.halbasch.sudoku.dtos;

import org.halbasch.sudoku.dlx.SudokuDLX.AnswerStatus;
import org.halbasch.sudoku.dlx.SudokuDLX.ClueStatus;

public class SudokuSolution {
	private int[] clues;
	private int[] all;
	private ClueStatus clueStatus;
	private AnswerStatus answerStatus;

	public SudokuSolution(int[] clues, int[] all, ClueStatus clueStatus, AnswerStatus answerStatus) {
		this.clues = clues;
		this.all = all;
		this.clueStatus = clueStatus;
		this.answerStatus = answerStatus;
	}

	public int[] getClues() {
		return clues;
	}

	public void setClues(int[] clues) {
		this.clues = clues;
	}

	public int[] getAll() {
		return all;
	}

	public void setAll(int[] all) {
		this.all = all;
	}

	public ClueStatus getClueStatus() {
		return clueStatus;
	}

	public void setClueStatus(ClueStatus clueStatus) {
		this.clueStatus = clueStatus;
	}

	public AnswerStatus getAnswerStatus() {
		return answerStatus;
	}

	public void setAnswerStatus(AnswerStatus answerStatus) {
		this.answerStatus = answerStatus;
	}
}
