package org.halbasch.sudoku;

import org.halbasch.sudoku.constructordi.SudokuDLXFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.halbasch.constructordi")
public class Config {
	private static final SudokuDLXFactory sudokuDLXFactory = new SudokuDLXFactory(); 
	
    @Bean
    public SudokuDLXFactory sudokuDLXFactory() {
        return sudokuDLXFactory;
    }
}
