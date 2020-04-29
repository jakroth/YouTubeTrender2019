/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youtubetrender;

import java.util.Set;
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
public class YouTubeWordItemTest {

    YouTubeWordItem wi;
    YouTubeVideo testVid;

    public YouTubeWordItemTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        wi = new YouTubeWordItem("testWord");
        testVid = new YouTubeVideo();
        wi.addPost(testVid);
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of addPost method, of class YouTubeWordItem.
     */
    @Test
    public void testAddPost() {
        System.out.println("addPost");
        YouTubeVideo v2 = new YouTubeVideo();
        wi.addPost(v2);
        int expResult = 2;
        int result = wi.getPostCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPosts method, of class YouTubeWordItem.
     */
    @Test
    public void testGetPosts() {
        System.out.println("getPosts");
        Set resultSet = wi.getPosts();
        int expResult = 1;
        int result = resultSet.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPostCount method, of class YouTubeWordItem.
     */
    @Test
    public void testGetPostCount() {
        System.out.println("getPostCount");
        int expResult = 1;
        int result = wi.getPostCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of addCount method, of class YouTubeWordItem.
     */
    @Test
    public void testAddCount() {
        System.out.println("addCount");
        int i = 1;
        wi.addCount(i);
        int result = wi.getCount();
        int expResult = 2;
        assertEquals(expResult, result);
    }

    /**
     * Test of getCount method, of class YouTubeWordItem.
     */
    @Test
    public void testGetCount() {
        System.out.println("getCount");
        int expResult = 1;
        int result = wi.getCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of getWord method, of class YouTubeWordItem.
     */
    @Test
    public void testGetWord() {
        System.out.println("getWord");
        String expResult = "testWord";
        String result = wi.getWord();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class YouTubeWordItem.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String result = wi.toString();
        String expResult = "testWord,1,1";
        assertEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class YouTubeWordItem.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        YouTubeWordItem wc = new YouTubeWordItem("firstWord");
        wc.addCount(1);
        int expResult = 1;
        int result = wi.compareTo(wc);
        assertEquals(expResult, result);
    }

}
