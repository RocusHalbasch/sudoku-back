package org.halbasch.sudoku;

import org.halbasch.sudoku.constructordi.SudokuDLXFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.halbasch.constructordi")
public class Config {
    @Bean
    public SudokuDLXFactory sudokuDLXFactory() {
        return new SudokuDLXFactory();
    }
}
