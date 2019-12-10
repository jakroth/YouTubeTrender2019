/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youtubetrender;

import java.util.Comparator;

/**
 * This class compares two YouTubeVideo objects based on their Like to Dislike Ration. 
 * @author Joel Pillar-Rogers
 */
public class YouTubeVideoLikeRatioComparator implements Comparator<YouTubeVideo> {

    public int compare(YouTubeVideo v1, YouTubeVideo v2) {    
        float a = v1.getLikeCount();
        float b = v1.getDislikeCount()+1;
        float c = v2.getLikeCount();
        float d = v2.getDislikeCount()+1;
                   
        return (int)((a/b - c/d)*1000000);
    }
}