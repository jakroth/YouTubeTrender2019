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
 * @author Joel
 */
public class YouTubeVideoTest {

    public YouTubeVideoTest() {
    }
    YouTubeVideo testVid = new YouTubeVideo();

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        testVid.setKind("testKind");
        testVid.setEtag("testEtag");
        testVid.setId("testId");
        testVid.setPublishedAt("2000-01-01T00:00:00.000Z");
        testVid.setChannelId("testChannelId");
        testVid.setTitle("testTitle");
        testVid.setDescription("testDescription");
        testVid.setChannelTitle("testChannelTitle");
        testVid.setCategoryId("testCategoryId");
        testVid.setViewCount(-1);
        testVid.setLikeCount(-1);
        testVid.setDislikeCount(-1);
        testVid.setFavouriteCount(-1);
        testVid.setCommentCount(-1);
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of toString method, of class YouTubeVideo.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "2000-01-01 00:00 - testChannelTitle - testTitle (Views: -1)";
        String result = testVid.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getKind method, of class YouTubeVideo.
     */
    @Test
    public void testGetKind() {
        System.out.println("getKind");
        String expResult = "testKind";
        String result = testVid.getKind();
        assertEquals(expResult, result);
    }

    /**
     * Test of setKind method, of class YouTubeVideo.
     */
    @Test
    public void testSetKind() {
        System.out.println("setKind");
        testVid.setKind("setKind");
        String expResult = "setKind";
        String result = testVid.getKind();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEtag method, of class YouTubeVideo.
     */
    @Test
    public void testGetEtag() {
        System.out.println("getEtag");
        String expResult = "testEtag";
        String result = testVid.getEtag();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEtag method, of class YouTubeVideo.
     */
    @Test
    public void testSetEtag() {
        System.out.println("setEtag");
        testVid.setEtag("setEtag");
        String expResult = "setEtag";
        String result = testVid.getEtag();
        assertEquals(expResult, result);
    }

    /**
     * Test of getId method, of class YouTubeVideo.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        String expResult = "testId";
        String result = testVid.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class YouTubeVideo.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        testVid.setId("setId");
        String expResult = "setId";
        String result = testVid.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPublishedAt method, of class YouTubeVideo.
     */
    @Test
    public void testGetPublishedAt() {
        System.out.println("getPublishedAt");
        String expResult = "2000-01-01T00:00:00.000Z";
        String result = testVid.getPublishedAt();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPublishedAt method, of class YouTubeVideo.
     */
    @Test
    public void testSetPublishedAt() {
        System.out.println("setPublishedAt");
        testVid.setPublishedAt("1999-11-11T11:11:11.111A");
        String expResult = "1999-11-11T11:11:11.111A";
        String result = testVid.getPublishedAt();
        assertEquals(expResult, result);
    }

    /**
     * Test of getChannelId method, of class YouTubeVideo.
     */
    @Test
    public void testGetChannelId() {
        System.out.println("getChannelId");
        String expResult = "testChannelId";
        String result = testVid.getChannelId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setChannelId method, of class YouTubeVideo.
     */
    @Test
    public void testSetChannelId() {
        System.out.println("setChannelId");
        testVid.setChannelId("setChannelId");
        String expResult = "setChannelId";
        String result = testVid.getChannelId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTitle method, of class YouTubeVideo.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        String expResult = "testTitle";
        String result = testVid.getTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTitle method, of class YouTubeVideo.
     */
    @Test
    public void testSetTitle() {
        System.out.println("setTitle");
        testVid.setTitle("setTitle");
        String expResult = "setTitle";
        String result = testVid.getTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class YouTubeVideo.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        String expResult = "testDescription";
        String result = testVid.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDescription method, of class YouTubeVideo.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        testVid.setDescription("setDescription");
        String expResult = "setDescription";
        String result = testVid.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getChannelTitle method, of class YouTubeVideo.
     */
    @Test
    public void testGetChannelTitle() {
        System.out.println("getChannelTitle");
        String expResult = "testChannelTitle";
        String result = testVid.getChannelTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of setChannelTitle method, of class YouTubeVideo.
     */
    @Test
    public void testSetChannelTitle() {
        System.out.println("setChannelTitle");
        testVid.setChannelTitle("setChannelTitle");
        String expResult = "setChannelTitle";
        String result = testVid.getChannelTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCategoryId method, of class YouTubeVideo.
     */
    @Test
    public void testGetCategoryId() {
        System.out.println("getCategoryId");
        String expResult = "testCategoryId";
        String result = testVid.getCategoryId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCategoryId method, of class YouTubeVideo.
     */
    @Test
    public void testSetCategoryId() {
        System.out.println("setCategoryId");
        testVid.setCategoryId("setCategoryId");
        String expResult = "setCategoryId";
        String result = testVid.getCategoryId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getViewCount method, of class YouTubeVideo.
     */
    @Test
    public void testGetViewCount() {
        System.out.println("getViewCount");
        int expResult = -1;
        int result = testVid.getViewCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of setViewCount method, of class YouTubeVideo.
     */
    @Test
    public void testSetViewCount() {
        System.out.println("setViewCount");
        testVid.setViewCount(99);
        int expResult = 99;
        int result = testVid.getViewCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLikeCount method, of class YouTubeVideo.
     */
    @Test
    public void testGetLikeCount() {
        System.out.println("getLikeCount");
        int expResult = -1;
        int result = testVid.getLikeCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLikeCount method, of class YouTubeVideo.
     */
    @Test
    public void testSetLikeCount() {
        System.out.println("setLikeCount");
        testVid.setLikeCount(99);
        int expResult = 99;
        int result = testVid.getLikeCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDislikeCount method, of class YouTubeVideo.
     */
    @Test
    public void testGetDislikeCount() {
        System.out.println("getDislikeCount");
        int expResult = -1;
        int result = testVid.getDislikeCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDislikeCount method, of class YouTubeVideo.
     */
    @Test
    public void testSetDislikeCount() {
        System.out.println("setDislikeCount");
        testVid.setDislikeCount(99);
        int expResult = 99;
        int result = testVid.getDislikeCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFavouriteCount method, of class YouTubeVideo.
     */
    @Test
    public void testGetFavouriteCount() {
        System.out.println("getFavouriteCount");
        int expResult = -1;
        int result = testVid.getFavouriteCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFavouriteCount method, of class YouTubeVideo.
     */
    @Test
    public void testSetFavouriteCount() {
        System.out.println("setFavouriteCount");
        testVid.setFavouriteCount(99);
        int expResult = 99;
        int result = testVid.getFavouriteCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCommentCount method, of class YouTubeVideo.
     */
    @Test
    public void testGetCommentCount() {
        System.out.println("getCommentCount");
        int expResult = -1;
        int result = testVid.getCommentCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCommentCount method, of class YouTubeVideo.
     */
    @Test
    public void testSetCommentCount() {
        System.out.println("setCommentCount");
        testVid.setCommentCount(99);
        int expResult = 99;
        int result = testVid.getCommentCount();
        assertEquals(expResult, result);
    }

}
