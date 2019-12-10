/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youtubetrender;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.json.stream.JsonParsingException;

/**
 * This class provides methods to parse YouTube video JSON data. It also stores
 * an arraylist of YouTubeVideo java objects.
 *
 * @author Joel Pillar-Rogers
 */
public class YouTubeDataParser {

    /**
     * The arraylist underpinning every object of this class.
     */
    ArrayList<YouTubeVideo> ytVideoList = new ArrayList();

    /**
     * A boolean variable which indicates whether the Json file has an array of
     * objects or a single object.
     */
    boolean array = true;

    /**
     * Parses a YouTube Json file and populates the class arraylist with
     * YouTubeVideo objects
     *
     * @param filename contains the json data to be parsed.
     * @throws YouTubeDataParserException when several other exceptions are
     * propogated up to this method.
     */
    public void parse(String filename) throws YouTubeDataParserException {
        try {
            // Declare method variables to monitor the time taken for each task
            /**
             * A long variable to mark the start time of this method.
             */
            long startTime;
            /**
             * A long variable to mark the end time of the json parse in this
             * method.
             */
            long jsonTime;
            /**
             * A long variable to mark the end time of the arraylist populating
             * in this method.
             */
            long stopTime;
            /**
             * A long variable to calculate time taken to parse the json file in
             * this method.
             */
            long readTime;
            /**
             * A long variable to calculate time taken to populate the arraylist
             * in this method.
             */
            long populateTime;
            /**
             * A long variable to calculate total time taken by this method.
             */
            long runTime;

            startTime = System.nanoTime();

            // Use the class helper method to parse the json file 
            /**
             * An Json array to temporarily store the objects read from the json
             * file.
             */
            JsonArray items = parseJson(filename);
            jsonTime = System.nanoTime();

            // Use the class helper method to populate the class arraylist
            if (array) {
                convertJsonArray(items);
            } else {
                //populate single video
                populateSingleVideo(filename);
            }
            stopTime = System.nanoTime();

            // Calculate and print the time taken for each task
            readTime = jsonTime - startTime;
            populateTime = stopTime - jsonTime;
            runTime = stopTime - startTime;
            System.out.println("------Parse complete!------");
            System.out.println("JSON Data Read Time (ms): " + readTime / 1000000);
            System.out.println("ArrayList Populate Time (ms): " + populateTime / 1000000);
            System.out.println("Total Run Time (ms): " + runTime / 1000000);
            System.out.println("");

            // Error catching
        } catch (FileNotFoundException fnte) {
            throw new YouTubeDataParserException("This file cannot be found: " + filename);
        } catch (JsonParsingException jpe) {
            throw new YouTubeDataParserException("Corrupted Json File: " + jpe.getMessage());
        } catch (NullPointerException npe) {
            throw new YouTubeDataParserException("Null field encountered when populating parser array.");
        }
    }

    /**
     * Reads data from a Json file and returns a JsonArray
     *
     * @param filename contains the json data to be parsed, passed down from the
     * parse method.
     * @return a Json Array containing the Json objects in the Json file.
     * @throws FileNotFoundException when the filename is entered incorrectly or
     * doesn't exist.
     * @throws JsonParsingException when the Json file has errors in it that
     * prevent parsing.
     */
    private JsonArray parseJson(String filename) throws FileNotFoundException, JsonParsingException {
        /**
         * A JsonReader to parse the Json file
         */
        JsonReader jsonReader = Json.createReader(new FileInputStream(filename));
        /**
         * A Json Object to hold the data from the Json file (consisting of a
         * list of YouTube videos).
         */
        JsonObject jobj = jsonReader.readObject();
        /**
         * A Json Array to hold all of the individual Json video objects.
         */
        JsonArray items;
        if (jobj.getJsonArray("items") == null) {
            array = false;
        }
        items = jobj.getJsonArray("items");
        return items;
    }

    /**
     * Populates the class ArrayList with YTVideos converted from JsonArray
     * objects
     *
     * @param items is the Json Array constructed in the parseJson method, that
     * contains Json objects representing YouTube videos.
     * @throws NullPointerException when a Json Object is missing a field.
     */
    private void convertJsonArray(JsonArray items) throws NullPointerException {
        /**
         * A temporary YouTubeVideo object that is reconstructed for every Json
         * Object and added to the class ArrayList.
         */
        YouTubeVideo tempVid;

        for (int i = 0; i < items.size(); i++) {

            tempVid = new YouTubeVideo();
            /**
             * A JsonValue that checks whether a field in the Json Object exists
             * or is null.
             */
            JsonValue checkNull;

            // set general variables
            JsonObject video = items.getJsonObject(i);
            tempVid.setKind(video.getString("kind"));
            tempVid.setEtag(video.getString("etag"));
            tempVid.setId(video.getString("id"));

            // this code attempts to retrieve the strings in "tags" but 
            // doesn't work properly at the moment (just returns all nulls).
            checkNull = video.get("tags");
            if (checkNull == null) {
                tempVid.setTags(null);
            } else {
                JsonArray tagArray = video.getJsonArray("tags");
                System.out.println(tagArray.getString(1));
                String[] tempArray = new String[20];
                for (int j = 0; j < tagArray.size(); j++) {
                    tempArray[j] = tagArray.getString(j);
                    System.out.println(tagArray.getString(j));
                }
                tempVid.setTags(tempArray);
            }

            // set snippet variables
            JsonObject snippet = video.getJsonObject("snippet");
            tempVid.setPublishedAt(snippet.getString("publishedAt"));
            tempVid.setChannelId(snippet.getString("channelId"));
            tempVid.setTitle(snippet.getString("title"));
            tempVid.setDescription(snippet.getString("description"));
            tempVid.setChannelTitle(snippet.getString("channelTitle"));
            tempVid.setCategoryId(snippet.getString("categoryId"));

            // set statistics variables (with null checks)
            JsonObject statistics = video.getJsonObject("statistics");
            tempVid.setViewCount(Integer.parseInt(statistics.getString("viewCount")));
            checkNull = statistics.get("likeCount");
            if (checkNull == null) {
                tempVid.setLikeCount(0);
            } else {
                tempVid.setLikeCount(Integer.parseInt(statistics.getString("likeCount")));
            }
            checkNull = statistics.get("dislikeCount");
            if (checkNull == null) {
                tempVid.setDislikeCount(0);
            } else {
                tempVid.setDislikeCount(Integer.parseInt(statistics.getString("dislikeCount")));
            }
            tempVid.setFavouriteCount(Integer.parseInt(statistics.getString("favoriteCount")));
            tempVid.setCommentCount(Integer.parseInt(statistics.getString("commentCount")));

            ytVideoList.add(tempVid);
        }
    }

    /**
     * Populates the class ArrayList with a single YTVideo converted from a
     * single unlisted Json Object
     *
     * @param filename contains the json data to be parsed, passed down from the
     * parse method.
     * @throws FileNotFoundException when the filename is entered incorrectly or
     * doesn't exist.
     * @throws NullPointerException NullPointerException when the Json Object is
     * missing a field.
     */
    private void populateSingleVideo(String filename) throws FileNotFoundException, NullPointerException {
        /**
         * A JsonReader to parse the Json file
         */
        JsonReader jsonReader = Json.createReader(new FileInputStream(filename));
        /**
         * A Json Object to hold the data from the Json file (consisting of a
         * single YouTube video).
         */
        JsonObject video = jsonReader.readObject();
        /**
         * A temporary YouTubeVideo object that is constructed for the Json
         * Object and added to the class ArrayList.
         */
        YouTubeVideo tempVid = new YouTubeVideo();
        /**
         * A JsonValue that checks whether a field in the Json Object exists or
         * is null.
         */
        JsonValue checkNull;

        // set general variables
        tempVid.setKind(video.getString("kind"));
        tempVid.setEtag(video.getString("etag"));
        tempVid.setId(video.getString("id"));

        // this code attempts to retrieve the strings in "tags" but 
        // doesn't work properly at the moment (just returns all nulls).
        checkNull = video.get("tags");
        if (checkNull == null) {
            tempVid.setTags(null);
        } else {
            JsonArray tagArray = video.getJsonArray("tags");
            System.out.println("Print this if this part is working");
            System.out.println(tagArray.getString(1));
            String[] tempArray = new String[20];
            for (int j = 0; j < tagArray.size(); j++) {
                tempArray[j] = tagArray.getString(j);
                System.out.println(tagArray.getString(j));
            }
            tempVid.setTags(tempArray);
        }

        // set snippet variables
        JsonObject snippet = video.getJsonObject("snippet");
        tempVid.setPublishedAt(snippet.getString("publishedAt"));
        tempVid.setChannelId(snippet.getString("channelId"));
        tempVid.setTitle(snippet.getString("title"));
        tempVid.setDescription(snippet.getString("description"));
        tempVid.setChannelTitle(snippet.getString("channelTitle"));
        tempVid.setCategoryId(snippet.getString("categoryId"));

        // set statistics variables (with null checks)
        JsonObject statistics = video.getJsonObject("statistics");
        tempVid.setViewCount(Integer.parseInt(statistics.getString("viewCount")));
        checkNull = statistics.get("likeCount");
        if (checkNull == null) {
            tempVid.setLikeCount(0);
        } else {
            tempVid.setLikeCount(Integer.parseInt(statistics.getString("likeCount")));
        }
        checkNull = statistics.get("dislikeCount");
        if (checkNull == null) {
            tempVid.setDislikeCount(0);
        } else {
            tempVid.setDislikeCount(Integer.parseInt(statistics.getString("dislikeCount")));
        }
        tempVid.setFavouriteCount(Integer.parseInt(statistics.getString("favoriteCount")));
        tempVid.setCommentCount(Integer.parseInt(statistics.getString("commentCount")));

        ytVideoList.add(tempVid);

    }

    /**
     * Returns the video at the specified index in the ArrayList of this parser
     * object.
     *
     * @param i specifies the index in the array which contains the YouTubeVideo
     * object to be returned.
     * @return a YouTubeVideo object at the specified index.
     */
    public YouTubeVideo getVideo(int i) {
        return ytVideoList.get(i);
    }

    /**
     * Returns the number of YouTubeVideos in the ArrayList of this parser
     * object.
     *
     * @return an int
     */
    public int size() {
        return ytVideoList.size();
    }

    // PRINTING METHODS
    /**
     * Prints out the videos in the array, using their default toString method
     */
    public void print() {
        ytVideoList.forEach(v -> System.out.println(v));
        System.out.println("");
    }

    /**
     * Prints out all the fields of a selected video from the ArrayList of this
     * parse object.
     *
     * @param i specifies the index in the array which contains the YouTubeVideo
     * object whose fields will be printed.
     */
    public void printVideo(int i) {
        // Check to see if array index number provided is out of bounds
        try {
            if (i < 0) {
                i = 0;
                System.out.println("Index was out of bounds, returning video at index (" + i + ").");
            }
            if (i >= ytVideoList.size()) {
                i = ytVideoList.size() - 1;
                System.out.println("Index was out of bounds, returning final video at index (" + i + ").");
            }
            System.out.println("------YOUTUBE VIDEO " + (i + 1) + "------");
            System.out.println("Kind: " + ytVideoList.get(i).getKind());
            System.out.println("Etag: " + ytVideoList.get(i).getEtag());
            System.out.println("ID: " + ytVideoList.get(i).getId());
            System.out.println("");
            System.out.println("Title: " + ytVideoList.get(i).getTitle());
            System.out.println("Date: " + ytVideoList.get(i).getPublishedAt());
            System.out.println("");
            System.out.println("ChannelID: " + ytVideoList.get(i).getChannelId());
            System.out.println("Channel Title: " + ytVideoList.get(i).getChannelTitle());
            System.out.println("Category ID: " + ytVideoList.get(i).getCategoryId());
            System.out.println("");
            // Still trying to make this code work!!!
            //System.out.print("Tags: ");
            //for (int j = 0; j < ytVideoList.get(i).getTagsArray().length; j++) {
            //    System.out.print(ytVideoList.get(i).getTag(j));
            //}
            //System.out.println("");

            System.out.println("Description: \n" + ytVideoList.get(i).getDescription());
            System.out.println("");
            System.out.println("Views: " + ytVideoList.get(i).getViewCount());
            System.out.println("Likes: " + ytVideoList.get(i).getLikeCount());
            System.out.println("Dislikes: " + ytVideoList.get(i).getDislikeCount());
            System.out.println("Favourites: " + ytVideoList.get(i).getFavouriteCount());
            System.out.println("Number of Comments: " + ytVideoList.get(i).getCommentCount());
            System.out.println("");
        } catch (ArrayIndexOutOfBoundsException aioob) {
            System.out.println("There are no videos in this parser.");
        }
    }

    /**
     * Prints out the descriptions of every YouTubeVideo in the ArrayList of
     * this parse object.
     */
    public void printDescription() {
        for (int i = 0; i < ytVideoList.size(); i++) {
            System.out.println("***************************************");
            System.out.println("----VIDEO " + (i + 1) + " - DESCRIPTION------");
            System.out.println("***************************************");
            System.out.println("Title: " + ytVideoList.get(i).getTitle());
            System.out.println("");
            System.out.println("Description: ");
            System.out.println(ytVideoList.get(i).getDescription());
            System.out.println("");
        }
    }

    /**
     * Prints out the title, likes, dislikes and like ratio of each YouTubeVideo
     * in the ArrayList of this parse object.
     */
    public void printLikes() {
        for (int i = 0; i < ytVideoList.size(); i++) {
            System.out.println("Title: " + ytVideoList.get(i).getTitle());
            System.out.println("Likes: " + ytVideoList.get(i).getLikeCount());
            System.out.println("Dislikes: " + ytVideoList.get(i).getDislikeCount());
            System.out.println("LikeRatio: " + ytVideoList.get(i).getLikeRatio());
            System.out.println("");
        }
    }

    //SORTING METHODS
    /**
     * Sorts the ArrayList of this parse object by the Published Date of each
     * YouTubeVideo.
     */
    public void sortByDate() {
        long startTime, stopTime;
        startTime = System.nanoTime();
        Collections.sort(ytVideoList, new YouTubeVideoDateComparator());
        stopTime = System.nanoTime();
        System.out.println("------Sort by Date complete!------");
        System.out.println("Sort time (ms): " + (stopTime - startTime) / 1000000);
        System.out.println("");
    }

    /**
     * Sorts the ArrayList of this parse object by the Title of each
     * YouTubeVideo.
     */
    public void sortByTitle() {
        long startTime, stopTime;
        startTime = System.nanoTime();
        Collections.sort(ytVideoList, new YouTubeVideoTitleComparator());
        stopTime = System.nanoTime();
        System.out.println("------Sort by Title complete!------");
        System.out.println("Sort time (ms): " + (stopTime - startTime) / 1000000);
        System.out.println("");
    }

    /**
     * Sorts the ArrayList of this parse object by the Channel Title of each
     * YouTubeVideo.
     */
    public void sortByChannelTitle() {
        long startTime, stopTime;
        startTime = System.nanoTime();
        Collections.sort(ytVideoList, new YouTubeVideoChannelComparator());
        stopTime = System.nanoTime();
        System.out.println("------Sort by Channel Title complete!------");
        System.out.println("Sort time (ms): " + (stopTime - startTime) / 1000000);
        System.out.println("");
    }

    /**
     * Sorts the ArrayList of this parse object by the View Count of each
     * YouTubeVideo.
     */
    public void sortByViews() {
        long startTime, stopTime;
        startTime = System.nanoTime();
        Collections.sort(ytVideoList, new YouTubeVideoViewComparator());
        stopTime = System.nanoTime();
        System.out.println("------Sort by Views complete!------");
        System.out.println("Sort time (ms): " + (stopTime - startTime) / 1000000);
        System.out.println("");
    }

    /**
     * Sorts the ArrayList of this parse object by the Description Length of
     * each YouTubeVideo.
     */
    public void sortByDescriptionLength() {
        long startTime, stopTime;
        startTime = System.nanoTime();
        Collections.sort(ytVideoList, new YouTubeVideoDescriptionComparator());
        stopTime = System.nanoTime();
        System.out.println("------Sort by Description Length complete!------");
        System.out.println("Sort time (ms): " + (stopTime - startTime) / 1000000);
        System.out.println("");
    }

    /**
     * Sorts the ArrayList of this parse object by the Number of Likes of each
     * YouTubeVideo.
     */
    public void sortByLikes() {
        long startTime, stopTime;
        startTime = System.nanoTime();
        Collections.sort(ytVideoList, new YouTubeVideoLikeComparator());
        stopTime = System.nanoTime();
        System.out.println("------Sort by Likes complete!------");
        System.out.println("Sort time (ms): " + (stopTime - startTime) / 1000000);
        System.out.println("");
    }

    /**
     * Sorts the ArrayList of this parse object by the Ratio of Likes to
     * Dislikes of each YouTubeVideo.
     */
    public void sortByLikeRatio() {
        long startTime, stopTime;
        startTime = System.nanoTime();
        Collections.sort(ytVideoList, new YouTubeVideoLikeRatioComparator());
        stopTime = System.nanoTime();
        System.out.println("------Sort by Like Ratio complete!------");
        System.out.println("Sort time (ms): " + (stopTime - startTime) / 1000000);
        System.out.println("");
    }

    /**
     * Sorts the ArrayList of this parse object by the number of Comments of
     * each YouTubeVideo.
     */
    public void sortByComments() {
        long startTime, stopTime;
        startTime = System.nanoTime();
        Collections.sort(ytVideoList, new YouTubeVideoCommentComparator());
        stopTime = System.nanoTime();
        System.out.println("------Sort by Comments complete!------");
        System.out.println("Sort time (ms): " + (stopTime - startTime) / 1000000);
        System.out.println("");
    }

    /**
     * Returns the member ArrayList so it can be used by the GUI.
     */
    public ArrayList getArray() {
        return ytVideoList;
    }

}
