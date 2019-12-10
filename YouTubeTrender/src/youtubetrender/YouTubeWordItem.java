/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youtubetrender;

import java.util.HashSet;
import java.util.Set;

/**
 * This class stores the word strings used in YouTube video title and
 * descriptions. It also stores the number of times those words appeared in a
 * given list of YouTube videos.
 *
 * @author Joel Pillar-Rogers
 */
public class YouTubeWordItem implements Comparable<YouTubeWordItem> {

    // Declare variables for this class
    /**
     * A string containing the word that has been parsed and indexed.
     */
    String word;
    /**
     * An int holding the number of times this word was parsed in the Title or
     * Description of each video.
     */
    int count;
    /**
     * A hashset holding all of the YouTubeVideoItems in which the word
     * appeared.
     */
    Set videos = new HashSet();

    /**
     * Constructs a WordItem, taking a word string as a initialisation
     * parameter.
     *
     * @param word is the string that this object is indexing.
     */
    YouTubeWordItem(String word) {
        this.word = word;
        count = 1;
    }

    /**
     * Adds a YouTubeVideo to the class hashset of videos.
     *
     * @param v is the YouTubeVideo to be added to the hashset.
     */
    public void addPost(YouTubeVideo v) {
        videos.add(v);
    }

    /**
     * Returns a set of the YouTubeVideos associated with this WordItem.
     *
     * @return a set.
     */
    public Set getPosts() {
        return videos;
    }

    /**
     * Counts the number of YouTubeVideos associated with this WordItem.
     *
     * @return an int.
     */
    public int getPostCount() {
        return videos.size();
    }

    /**
     * Prints the videos associated with this WordItem
     */
    public void printPosts() {
        System.out.println("----Videos with \"" + word + "\" in the Title or Description----");
        videos.forEach(v -> System.out.println(v));
        System.out.println("");
    }

    /**
     * Adds a specified int to the word usage count.
     *
     * @param i is the int value to be added.
     */
    public void addCount(int i) {
        count += i;
    }

    /**
     * Returns the count of the number of times the word was parsed.
     *
     * @return an int.
     */
    public int getCount() {
        return count;
    }

    /**
     * Returns the word of this WordItem.
     *
     * @return a string.
     */
    public String getWord() {
        return word;
    }

    /**
     * Overrides the toString method
     *
     * @return a string containing the word, count and number of associated
     * videos of this YouTubeWordItem.
     */
    @Override
    public String toString() {
        return word + "," + count + "," + getPostCount();
    }

    /**
     * Compares WordItems by their count (descending).
     *
     * @param i is another YouTubeWordItem that is used to describe how two
     * WordItems are compared.
     * @return an int.
     */
    @Override
    public int compareTo(YouTubeWordItem i) {
        return i.count - this.count;
    }
}
