package model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void 계산기_덧셈_테스트() {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculate(10, "+", 20)).isEqualTo(30);
    }

    @Test
    void 연산자가_다른_문자열로_온_겨우() {
        //assertThrows(Illegal)
    }

    @AfterEach
    void testDown() {
        calculator = null;
    }
}