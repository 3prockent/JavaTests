package com.company.test;


import com.company.Comparer;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


@RunWith(JUnitParamsRunner.class)
public class ComparerTest {

    static Comparer c;

    @Before
    public void init() throws Exception {
        c = new Comparer("test.txt");

        c.createMaxPairs();
    }

    @Test
    public void testNotFoundFileException() throws Exception {
        assertThrows(NoSuchFileException.class, ()->
                new Comparer("test.tx"));
    }

    @Test
    @Parameters({
            "test1.txt, abs asd",
            "test2.txt, asd sadasd"
    })
    public void readFromFile(String filePath, String expectedResult) throws Exception {
        c = new Comparer(filePath);
        assertEquals(c.getData(),expectedResult);
    }

    @Test
    public void  notNullWords(){
        assertNotNull(c.getWordsList());
    }

    @Test
    public void  WordsEquals(){
        c.wordsList();
        c.createMaxPairs();
        var testList = new ArrayList<String>();
        testList.add("aaaaaaaaaaaa");
        testList.add("bbbbbbbbbbb");
        testList.add("abababa");
        testList.add("aabababa");
        testList.add("aaaaaaaaaaaaaaa");
        testList.add("aaaaa");

        assertArrayEquals(c.getWordsList().toArray(), testList.toArray());
    }
    @Test
    public void firstWordEqual(){
        c.wordsList();
        c.createMaxPairs();
        var firstWord = c.getMaxPairs().get(0).get(0);
        var secondWord = c.getMaxPairs().get(0).get(1);
        assertEquals(firstWord,"aaaaaaaaaaaa");
        assertEquals(secondWord, "bbbbbbbbbbb");
    }

    @Test
    public void createMaxPairsResult() {

    }

    @Test
    public void getWordsList() {
        c.wordsList();
        assertThat(c.getWordsList(),hasItems("aaaaaaaaaaaa","bbbbbbbbbbb","abababa","aabababa",
                "aaaaaaaaaaaaaaa","aaaaa"));
    }

    @Test
    public void getMaxPairs() {
        c.wordsList();
        c.createMaxPairs();
        assertThat(c.getMaxPairs(),hasSize(2));
    }
}

