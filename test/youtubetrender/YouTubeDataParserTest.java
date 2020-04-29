/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youtubetrender;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author trent
 */
public class YouTubeDataParserTest {

    public YouTubeDataParserTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of parse method, of class YouTubeDataParser.
     */
    @Test
    public void testParse1() {
        System.out.println("parse1");
        YouTubeDataParser ytp = new YouTubeDataParser();
        try {
            ytp.parse("data/youtubedata_15_50.json");
        } catch (YouTubeDataParserException ytdpe) {
        }
        int expResult = 50;
        int result = ytp.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of parse method for corrupted data, of class YouTubeDataParser.
     */
    @Test(expected = YouTubeDataParserException.class)
    public void testParse2() throws Exception {
        System.out.println("parse2");
        YouTubeDataParser ytp = new YouTubeDataParser();
        String expResult = "Corrupted Json File: ";
        try {
            ytp.parse("data/youtubedata_malformed.json");
        } catch (YouTubeDataParserException y) {
            System.out.println(y.getMessage());
            if (y.getMessage().contains(expResult)) {
                throw new YouTubeDataParserException("");
            }
        }
    }

    /**
     * Test of parse method for incorrect filename, of class YouTubeDataParser.
     */
    @Test(expected = YouTubeDataParserException.class)
    public void testParse3() throws Exception {
        System.out.println("parse3");
        YouTubeDataParser ytp = new YouTubeDataParser();
        String expResult = "This file cannot be found: ";
        try {
            ytp.parse("data/youtubedata_incorrect.json");
        } catch (YouTubeDataParserException y) {
            System.out.println(y.getMessage());
            if (y.getMessage().contains(expResult)) {
                throw new YouTubeDataParserException("");
            }
        }
    }

    /**
     * Test of parse method for null data, of class YouTubeDataParser.
     */
    @Test(expected = YouTubeDataParserException.class)
    public void testParse4() throws Exception {
        System.out.println("parse4");
        YouTubeDataParser ytp = new YouTubeDataParser();
        String expResult = "Null field encountered when populating parser array.";
        try {
            ytp.parse("data/youtubedata_nulls.json");
        } catch (YouTubeDataParserException y) {
            if (y.getMessage().equals(expResult)) {
                throw new YouTubeDataParserException("");
            }
        }
    }

    /**
     * Test of getVideo method, of class YouTubeDataParser.
     */
    @Test
    public void testGetVideo() {
        System.out.println("getVideo1");
        int i = 0;
        int j = 11;
        int k = 49;
        YouTubeDataParser ytp = new YouTubeDataParser();
        try {
            ytp.parse("data/youtubedata_15_50.json");
        } catch (YouTubeDataParserException ytdpe) {
        }
        String iString = ytp.getVideo(i).getTitle().substring(0, 3);
        String jString = ytp.getVideo(j).getTitle().substring(0, 3);
        String kString = ytp.getVideo(k).getTitle().substring(0, 3);

        int l = 0;
        ytp = new YouTubeDataParser();
        try {
            ytp.parse("data/youtubedata.json");
        } catch (YouTubeDataParserException ytdpe) {
        }
        String lString = ytp.getVideo(l).getTitle().substring(0, 3);

        String expResult = "GuySurMicThi";
        String result = iString + jString + kString + lString;
        assertEquals(expResult, result);
    }

    /**
     * Test of getVideo method to test OutofRange videos, of class
     * YouTubeDataParser.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetVideo2() {
        System.out.println("getVideo2");
        int i = 1;
        YouTubeDataParser ytp = new YouTubeDataParser();
        try {
            ytp.parse("data/youtubedata.json");
        } catch (YouTubeDataParserException ytdpe) {
        }
        ytp.getVideo(i);
    }

    /**
     * Test of size method, of class YouTubeDataParser.
     */
    @Test
    public void testSize() {
        System.out.println("size1");
        int result = 0;
        YouTubeDataParser ytp = new YouTubeDataParser();
        try {
            ytp.parse("data/youtubedata.json");
        } catch (YouTubeDataParserException ytdpe) {
        }
        result = ytp.size();
        ytp = new YouTubeDataParser();
        try {
            ytp.parse("data/youtubedata_15_50.json");
        } catch (YouTubeDataParserException ytdpe) {
        }
        result += ytp.size();
        ytp = new YouTubeDataParser();
        try {
            ytp.parse("data/youtubedata_loremipsum.json");
        } catch (YouTubeDataParserException ytdpe) {
        }
        result += ytp.size();
        ytp = new YouTubeDataParser();
        try {
            ytp.parse("data/youtubedata_indextest.json");
        } catch (YouTubeDataParserException ytdpe) {
        }
        result += ytp.size();
        ytp = new YouTubeDataParser();
        try {
            ytp.parse("data/youtubedata_singleitem.json");
        } catch (YouTubeDataParserException ytdpe) {
        }
        result += ytp.size();
        int expResult = 63;
        assertEquals(expResult, result);
    }

    /**
     * Test of size method, of class YouTubeDataParser.
     */
    @Test
    public void testSize2() {
        System.out.println("size2");
        YouTubeDataParser ytp = new YouTubeDataParser();
        int result = ytp.size();
        int expResult = 0;
        assertEquals(expResult, result);
    }

    /**
     * Test of sortByDate method, of class YouTubeDataParser.
     */
    @Test
    public void testSortByDate() throws Exception {
        System.out.println("sortByDate");
        YouTubeDataParser ytp = new YouTubeDataParser();
        ytp.parse("data/youtubedata_15_50.json");
        ytp.sortByDate();
        String result = ytp.getVideo(0).getTitle();
        result += ytp.getVideo(49).getTitle();
        String expResult = "Reunited after a long holidayTalking Kitty Cat 48 - The Random Gibsons";
        assertEquals(expResult, result);
    }

    /**
     * Test of sortByDate method on an empty array, of class YouTubeDataParser.
     */
    @Test
    public void testSortByDate2() {
        System.out.println("sortByDate2");
        YouTubeDataParser ytp = new YouTubeDataParser();
        ytp.sortByDate();
    }

    /**
     * Test of sortByDate method for each item, of class YouTubeDataParser.
     */
    @Test
    public void testSortByDate3() throws Exception {
        System.out.println("sortByDate3");
        boolean sorted = true;
        YouTubeDataParser ytp = new YouTubeDataParser();
        ytp.parse("data/youtubedata_loremipsum.json");
        ytp.sortByDate();
        for (int i = 0; i < ytp.size() - 1; i++) {
            sorted = ytp.getVideo(i).getPublishedAt().compareTo(ytp.getVideo(i + 1).getPublishedAt()) < 0;
        }
        assertTrue(sorted);
    }

    /**
     * Test of sortByTitle method, of class YouTubeDataParser.
     */
    @Test
    public void testSortByTitle() throws Exception {
        System.out.println("sortByTitle");
        YouTubeDataParser ytp = new YouTubeDataParser();
        ytp.parse("data/youtubedata_15_50.json");
        ytp.sortByTitle();
        String result = ytp.getVideo(0).getTitle();
        result += ytp.getVideo(49).getTitle();
        String expResult = "06 19 15   Hummingbird Tormenting Rex讓猴子做一樣的事，卻給不平等獎勵的實驗 (中文字幕)";
        assertEquals(expResult, result);
    }

    /**
     * Test of sortByChannelTitle method, of class YouTubeDataParser.
     */
    @Test
    public void testSortByChannelTitle() throws Exception {
        System.out.println("sortByChannelTitle");
        YouTubeDataParser ytp = new YouTubeDataParser();
        ytp.parse("data/youtubedata_15_50.json");
        ytp.sortByChannelTitle();
        String result = ytp.getVideo(0).getTitle();
        result += ytp.getVideo(49).getTitle();
        String expResult = "Hamish & Andy - Kangaroo Ladygitinurbed";
        assertEquals(expResult, result);
    }

    /**
     * Test of sortByViews method, of class YouTubeDataParser.
     */
    @Test
    public void testSortByViews() throws Exception {
        System.out.println("sortByViews");
        YouTubeDataParser ytp = new YouTubeDataParser();
        ytp.parse("data/youtubedata_15_50.json");
        ytp.sortByViews();
        String result = ytp.getVideo(0).getTitle();
        result += ytp.getVideo(49).getTitle();
        String expResult = "Chautauqua 4K - CHAIRMANS SPRINT10 СУМАСШЕДШИХ БИТВ ЖИВОТНЫХ СНЯТЫХ НА КАМЕРУ";
        assertEquals(expResult, result);
    }

    /**
     * Test of sortByDescriptionLength method, of class YouTubeDataParser.
     */
    @Test
    public void testSortByDescriptionLength() throws Exception {
        System.out.println("sortByDescriptionLength");
        YouTubeDataParser ytp = new YouTubeDataParser();
        ytp.parse("data/youtubedata_15_50.json");
        ytp.sortByDescriptionLength();
        String result = ytp.getVideo(0).getTitle();
        result += ytp.getVideo(49).getTitle();
        String expResult = "Hamish & Andy - Kangaroo LadyPLAY DOH JURASSIC WORLD WRECK ‘N ROAR DINOSAUR GAME for Kids Egg Surprise Toys Marvel SuperHero";
        assertEquals(expResult, result);
    }

    /**
     * Test of sortByLikes method, of class YouTubeDataParser.
     */
    @Test
    public void testSortByLikes() throws Exception {
        System.out.println("sortByLikes");
        YouTubeDataParser ytp = new YouTubeDataParser();
        ytp.parse("data/youtubedata_15_50.json");
        ytp.sortByLikes();
        String result = ytp.getVideo(0).getTitle();
        result += ytp.getVideo(49).getTitle();
        String expResult = "Jellyfish: April 24, 201610 СУМАСШЕДШИХ БИТВ ЖИВОТНЫХ СНЯТЫХ НА КАМЕРУ";
        assertEquals(expResult, result);
    }

    /**
     * Test of sortByLikeRatio method, of class YouTubeDataParser.
     */
    @Test
    public void testSortByLikeRatio() throws Exception {
        System.out.println("sortByLikeRatio");
        YouTubeDataParser ytp = new YouTubeDataParser();
        ytp.parse("data/youtubedata_15_50.json");
        ytp.sortByLikeRatio();
        String result = ytp.getVideo(0).getTitle();
        result += ytp.getVideo(49).getTitle();
        String expResult = "Jellyfish: April 24, 2016Talking Kitty Cat 48 - The Random Gibsons";
        assertEquals(expResult, result);
    }
    
        /**
     * Test of sortByComments method, of class YouTubeDataParser.
     */
    @Test
    public void testSortByComments() throws Exception {
        System.out.println("sortByComments");
        YouTubeDataParser ytp = new YouTubeDataParser();
        ytp.parse("data/youtubedata_15_50.json");
        ytp.sortByComments();
        String result = ytp.getVideo(0).getTitle();
        result += ytp.getVideo(49).getTitle();
        String expResult = "Chautauqua 4K - CHAIRMANS SPRINTSHOULD WE GET THIS DOG?!";
        assertEquals(expResult, result);
    }

}
