package org.sergiolozanoprofe.util;

import org.junit.jupiter.api.Test;
import org.sergiolozanoprofe.model.OperationType;

import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {

    // parseInt tests
    @Test
    void parseIntegerNormally() {
        int value = InputParser.parseInt("42");
        assertEquals(42, value, "42 debería convertirse a 42");
    }

    @Test
    void parseIntegerWithSpacesAndZeros() {
        int value = InputParser.parseInt(" 007 ");
        assertEquals(7, value, "' 007 ' debería convertirse a 7");
    }

    @Test
    void parseIntInvalidStrings() {
        assertThrows(NumberFormatException.class, () -> InputParser.parseInt("abc"), "Texto no válido");
        assertThrows(NumberFormatException.class, () -> InputParser.parseInt("12.3"), "Número decimal no válido");
    }

    @Test
    void parseIntNullInput() {
        assertThrows(NumberFormatException.class, () -> InputParser.parseInt(null), "Entrada nula debería fallar");
    }

    // parseOperation tests
    @Test
    void parseOperationSymbols() {
        assertEquals(OperationType.ADD, InputParser.parseOperation("+"), "Símbolo + debería ser ADD");
        assertEquals(OperationType.SUBTRACT, InputParser.parseOperation("-"), "Símbolo - debería ser SUBTRACT");
        assertEquals(OperationType.MULTIPLY, InputParser.parseOperation("*"), "Símbolo * debería ser MULTIPLY");
        assertEquals(OperationType.DIVIDE, InputParser.parseOperation("/"), "Símbolo / debería ser DIVIDE");
    }

    @Test
    void parseOperationWordsAndCase() {
        assertEquals(OperationType.ADD, InputParser.parseOperation("Add"), "Palabra Add");
        assertEquals(OperationType.ADD, InputParser.parseOperation("SUMA"), "Palabra SUMA");
        assertEquals(OperationType.SUBTRACT, InputParser.parseOperation("resta"), "Palabra resta");
        assertEquals(OperationType.MULTIPLY, InputParser.parseOperation("MULTIPLICA"), "Palabra MULTIPLICA");
        assertEquals(OperationType.DIVIDE, InputParser.parseOperation("Dividir"), "Palabra Dividir");
    }

    @Test
    void parseOperationWithSpaces() {
        assertEquals(OperationType.ADD, InputParser.parseOperation("  add  "), "Espacios alrededor de add");
    }

    @Test
    void parseOperationInvalidOrNull() {
        assertThrows(IllegalArgumentException.class, () -> InputParser.parseOperation("?"), "Símbolo inválido");
        assertThrows(IllegalArgumentException.class, () -> InputParser.parseOperation("hola"), "Palabra inválida");
        assertThrows(IllegalArgumentException.class, () -> InputParser.parseOperation(null), "Null debería fallar");
    }
}