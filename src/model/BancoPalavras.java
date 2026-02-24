package model;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Random;

public class BancoPalavras {
    private String[] palavrasCincoLetras = {
            "ARRAY", "CLASS", "VALUE", "TYPES", "LOGIC", "CONST", "QUEUE", "CHILD", "FLOAT",
            "TUPLE", "LOOPS", "WHILE", "BREAK", "MERGE", "QUERY", "DEBUG", "PRINT", "INPUT",
            "CALLS", "CLONE", "TESTS", "ERROR", "TRACE", "CRASH", "EVENT", "ASYNC", "AWAIT",
            "STATE", "POINT", "COMMA", "COLON", "JAVAS", "SWIFT", "REACT", "VUEJS", "BREAK",
            "BYTES", "SLICE", "RANGE", "INDEX", "MATCH", "CASES", "ENDIF", "TIMES", "COUNT",
            "LIMIT", "SCOPE", "LOCAL", "FINAL", "FILES", "WRITE", "FLUSH", "CLOSE", "YIELD",
            "GAMES", "STDIN", "FATAL", "LEVEL", "ORDER", "GROUP", "INNER", "OUTER", "RIGHT",
            "CODES", "CROSS", "WHERE", "ALTER", "TRUNC", "YIELD", "USING", "ENUMS", "SEALED",
            "BEGIN", "TRANS", "FETCH", "PATCH", "ROUTE", "LOGIN", "WIDTH", "SCALE", "SHORT",
            "CURVE", "VERTEX", "COLOR", "ALPHA", "BLEND", "LAYER", "CLEAR", "COMPI", "TOTAL",
            "RESET", "ABORT", "RETRY", "CATCH", "THROW", "RAISE", "SUITE", "STUB", "BUILD",
            "START", "PAUSE", "SLEEP", "DELAY", "TIMER", "CLOCK", "TODAY", "MONTH", "MICRO",
            "EPOCH", "ZONE", "PARSE", "SPLIT", "STRIP", "MATCH", "INDEX", "ITEMS", "INPUT",
            "DEPTH", "SHAPE", "MODEL", "PANEL", "FRAME", "MODAL", "POPUP", "USING", "TRAIT",
            "LABEL", "RADIO", "CHECK", "COMBO", "FIELD", "FOCUS", "MOUSE", "PRESS", "PRINT",
            "ENTER", "LEAVE", "WHEEL", "TOUCH", "SWIPE", "PINCH", "SHAKE", "IMAGE", "AUDIO",
            "VIDEO", "MEDIA", "SINK", "DIRTY", "VALID", "EMPTY", "EVERY", "FIRST", "LIMIT",
            "XAXIS", "YAXIS", "ZAXIS", "LABEL", "TITLE", "TABLE", "QUEUE", "TUPLE", "FLOAT",
            "STACK", "GRAPH", "ROOT", "BRANCH", "CYCLE", "VISIT", "SCAN", "SHIFT", "SPLIT",
            "MERGE", "PATCH", "PATCH", "MIXIN", "ALIAS", "WHILE", "MATCH", "CURRY", "YIELD",
            "YIELD", "APPLY","BREAK", "PAINT"
    };
    Set<String> palavrasUnicas = new LinkedHashSet<>(Arrays.asList(palavrasCincoLetras));

    String[] arraySemDuplicatas = palavrasUnicas.toArray(new String[0]);
    private Random sorteador = new Random();

    public String palavraSecreta() {
        return arraySemDuplicatas[sorteador.nextInt(arraySemDuplicatas.length)];
    }

}
