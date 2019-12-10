/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youtubetrender;

import java.util.Comparator;

/**
 * This class compares two YouTubeVideo objects based on their Description Length. 
 * @author Joel Pillar-Rogers
 */
public class YouTubeVideoDescriptionComparator implements Comparator<YouTubeVideo> {

    public int compare(YouTubeVideo v1, YouTubeVideo v2) {
        return v1.getDescription().length() - v2.getDescription().length();
    }
}