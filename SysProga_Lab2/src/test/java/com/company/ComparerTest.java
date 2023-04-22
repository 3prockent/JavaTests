package com.company;

import com.company.Comparer;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.nio.file.NoSuchFileException;
import java.util.ArrayList;

import static org.testng.Assert.*;

public class ComparerTest {

    static Comparer c;

    @BeforeTest(groups = {"group1"})
    public void init() throws Exception {
        c = new Comparer("test.txt");

        c.createMaxPairs();
    }

    @Test(expectedExceptions = NoSuchFileException.class, groups = {"group1"})
    public void testNotFoundFileException() throws Exception {
                new Comparer("test.tx") ;
    }

    @Test
    public void successFinish(){
        c.wordsList();
        c.createMaxPairs();
        assertTrue(c.getFinished());
    }



    @Test(dataProvider = "read")
    public void readFromFile(String filePath, String expectedResult) throws Exception {
        c = new Comparer(filePath);
        assertEquals(c.getData(),expectedResult);
    }

    @Test(groups = {"group1", "group2"})
    public void  notNullWords(){
        assertNotNull(c.getWordsList());
    }


    @Test(groups = {"group1", "group2"})
    public void firstWordEqual(){
        c.wordsList();
        c.createMaxPairs();
        var firstWord = c.getMaxPairs().get(0).get(0);
        var secondWord = c.getMaxPairs().get(0).get(1);
        assertEquals(secondWord, "bbbbbbbbbbb");
    }

@Test
@DataProvider(name = "read")
public Object[][] read()
{
    return new Object[][]{
            {"test1.txt", "abs asd"},
            {"test2.txt", "asd sadasd"}
    };
}
}