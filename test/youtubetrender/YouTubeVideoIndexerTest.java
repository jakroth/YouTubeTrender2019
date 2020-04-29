/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youtubetrender;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Joel
 */
public class YouTubeVideoIndexerTest {

    YouTubeDataParser parser1;
    YouTubeDataParser parser2;
    YouTubeDataParser parser3;

    public YouTubeVideoIndexerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {

        parser1 = new YouTubeDataParser();
        parser1.parse("data/youtubedata_15_50.json");

        parser2 = new YouTubeDataParser();
        parser2.parse("data/youtubedata_loremipsum.json");

        parser3 = new YouTubeDataParser();
        parser3.parse("data/youtubedata_indextest.json");
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of index method, of class YouTubeVideoIndexer.
     */
    @Test
    public void testIndex() throws Exception {
        System.out.println("index");
        YouTubeVideoIndexer yti = new YouTubeVideoIndexer();
        yti.index(parser1);
        int result = yti.getSortedWordItems().size();
        int expResult = 2518;
        assertEquals(expResult, result);
    }

    /**
     * Test of countUniqueWords method, of class YouTubeVideoIndexer.
     */
    @Test
    public void testCountUniqueWords() throws Exception {
        System.out.println("countUniqueWords");
        YouTubeVideoIndexer yti = new YouTubeVideoIndexer();
        yti.index(parser2);
        int result = yti.countUniqueWords();
        int expResult = 238;
        assertEquals(expResult, result);
    }

    /**
     * Test of getSortedWordItems method, of class YouTubeVideoIndexer.
     */
    @Test
    public void testGetSortedWordItems() throws Exception {
        System.out.println("getSortedWordItems");
        YouTubeVideoIndexer yti = new YouTubeVideoIndexer();
        yti.index(parser1);
        String result = yti.getSortedWordItems().get(0).getWord();
        result += yti.getSortedWordItems().get(yti.getSortedWordItems().size() - 1).getWord();
        String expResult = "theJimbo";
        assertEquals(expResult, result);
    }

    /**
     * Test of getSortedWordItems method, of class YouTubeVideoIndexer.
     */
    @Test(expected = YouTubeDataParserException.class)
    public void testGetSortedWordItems2() throws Exception {
        System.out.println("getSortedWordItems2");
        YouTubeVideoIndexer yti = new YouTubeVideoIndexer();
        String expResult = "There are no WordItems in this HashMap";
        try {
            yti.getSortedWordItems();
        } catch (YouTubeDataParserException y) {
            System.out.println(y.getMessage());
            if (y.getMessage().contains(expResult)) {
                throw new YouTubeDataParserException("");
            }
        }
    }

    /**
     * Test of getWordItem method, of class YouTubeVideoIndexer.
     */
    @Test
    public void testGetWordItem() throws Exception {
        System.out.println("getWordItem");
        YouTubeVideoIndexer yti = new YouTubeVideoIndexer();
        yti.index(parser3);
        YouTubeWordItem wi = yti.getWordItem("FOUR");
        int result = wi.getCount();
        int expResult = 4;
        assertEquals(expResult, result);
    }

    /**
     * Test of getWordItem method exception, of class YouTubeVideoIndexer.
     */
    @Test 
    public void testGetWordItem2() {
        System.out.println("getWordItem2");
        YouTubeVideoIndexer yti = new YouTubeVideoIndexer();
        yti.index(parser3);        
        YouTubeWordItem wi = yti.getWordItem("absent");
        assertNull(wi);
    }

    /**
     * Test of getMostUsedWord method, of class YouTubeVideoIndexer.
     */
    @Test
    public void testGetMostUsedWord() throws Exception {
        System.out.println("getMostUsedWord");
        YouTubeVideoIndexer yti = new YouTubeVideoIndexer();
        yti.index(parser3);
        yti.getSortedWordItems();
        String result = yti.getMostUsedWord().getWord();
        String expResult = "FIVE";
        assertEquals(expResult, result);
    }

    /**
     * Test of getMostUsedWord method, check whether fails if list not yet
     * sorted, of class YouTubeVideoIndexer.
     */
    @Test
    public void testGetMostUsedWord2() throws Exception {
        System.out.println("getMostUsedWord2");
        YouTubeVideoIndexer yti = new YouTubeVideoIndexer();
        String result = yti.getMostUsedWord().getWord();
        String expResult = "ArrayList not yet sorted. Please run the getSortedWordItems method and try again.";
        assertEquals(expResult, result);
    }
}
