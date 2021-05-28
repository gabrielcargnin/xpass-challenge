package com.github.gabrielcargnin.xpasschallenge.unit;

import com.github.gabrielcargnin.xpasschallenge.service.MathSolution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MathSolutionTest {

    private final MathSolution mathSolution;

    public MathSolutionTest() {
        this.mathSolution = new MathSolution();
    }

    public static Stream<Arguments> successSolveData() {
        return Stream.of(
                Arguments.of((Object) new String[]{"XpassLovers", "15"}),
                Arguments.of((Object) new String[]{"XpassLovers", "30"}),
                Arguments.of((Object) new String[]{"XpassLovers", "45"}),
                Arguments.of((Object) new String[]{"XpassLovers", "60"}),
                Arguments.of((Object) new String[]{"XpassLovers", "75"}),
                Arguments.of((Object) new String[]{"XpassLovers", "90"}),
                Arguments.of((Object) new String[]{"IT", "5"}),
                Arguments.of((Object) new String[]{"IT", "10"}),
                Arguments.of((Object) new String[]{"IT", "20"}),
                Arguments.of((Object) new String[]{"IT", "25"}),
                Arguments.of((Object) new String[]{"IT", "35"}),
                Arguments.of((Object) new String[]{"IT", "40"}),
                Arguments.of((Object) new String[]{"Xpass", "3"}),
                Arguments.of((Object) new String[]{"Xpass", "6"}),
                Arguments.of((Object) new String[]{"Xpass", "9"}),
                Arguments.of((Object) new String[]{"Xpass", "99"}),
                Arguments.of((Object) new String[]{"Xpass", "33"}),
                Arguments.of((Object) new String[]{"1", "1"}),
                Arguments.of((Object) new String[]{"16", "16"})
        );
    }

    public static Stream<Arguments> failSolveData() {
        return Stream.of(
                Arguments.of((Object) new String[]{"IT", "15"}),
                Arguments.of((Object) new String[]{"IT", "30"}),
                Arguments.of((Object) new String[]{"IT", "45"}),
                Arguments.of((Object) new String[]{"60", "60"}),
                Arguments.of((Object) new String[]{"75", "75"}),
                Arguments.of((Object) new String[]{"Xpass", "90"}),
                Arguments.of((Object) new String[]{"Xpass", "5"}),
                Arguments.of((Object) new String[]{"Xpass", "10"}),
                Arguments.of((Object) new String[]{"XpassLovers", "20"}),
                Arguments.of((Object) new String[]{"25", "25"}),
                Arguments.of((Object) new String[]{"35", "35"}),
                Arguments.of((Object) new String[]{"XpassLovers", "40"}),
                Arguments.of((Object) new String[]{"IT", "3"}),
                Arguments.of((Object) new String[]{"IT", "6"})
        );
    }

    @ParameterizedTest
    @MethodSource(value = "successSolveData")
    void successSolve(String[] data) throws Exception {
        assertEquals(data[0], mathSolution.solve(Integer.parseInt(data[1])));
    }

    @ParameterizedTest
    @MethodSource(value = "failSolveData")
    void failSolve(String[] data) throws Exception {
        assertNotEquals(data[0], mathSolution.solve(Integer.parseInt(data[1])));
    }

    @Test
    void numberOutOfRange() {
        Throwable throwable = Assertions.assertThrows(Exception.class, () -> mathSolution.solve(-1));
        assertEquals("Number out of range!", throwable.getMessage());
    }
}
