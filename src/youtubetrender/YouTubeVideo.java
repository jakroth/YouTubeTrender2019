/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youtubetrender;

/**
 * This class stores the details of a YouTube video.
 *
 * @author Joel Pillar-Rogers
 */
public class YouTubeVideo implements Comparable<YouTubeVideo> {

    //video general variables
    /**
     * The kind of json data, e.g. youtube video.
     */
    String kind;
    /**
     * The etag of this video, provided by YouTube. A long random character
     * string.
     */
    String etag;
    /**
     * The ID of this video provided by YouTube. A short string of characters.
     */
    String id;
    /**
     * Some videos are tagged with word strings to describe the content. Stored
     * here as a string array.
     */
    String[] tags = new String[20];

    //video snippet variables
    /**
     * The date this YouTube video was uploaded.
     */
    String publishedAt;
    /**
     * The channel ID of this video. A long string of characters provided by
     * YouTube.
     */
    String channelId;
    /**
     * The title of this video, provided by the uploader.
     */
    String title;
    /**
     * The description of this video, provided by the uploader. Can be a very
     * long, multi-line string.
     */
    String description;
    /**
     * The title of the channel hosting this video, provided by the uploader.
     * Usually a few words.
     */
    String channelTitle;
    /**
     * The category ID for this video, provided by YouTube.
     */
    String categoryId;

    //video activity variables
    /**
     * The number of people that have viewed this video on YouTube.
     */
    int viewCount;
    /**
     * The number of likes given by people that have viewed this video on
     * YouTube.
     */
    int likeCount;
    /**
     * The number of dislikes given by people that have viewed this video on
     * YouTube.
     */
    int dislikeCount;
    /**
     * The number of favourites given by people that have viewed this video on
     * YouTube. This does not appear to be implemented by YouTube yet as all of
     * the data is 0 for this field.
     */
    int favouriteCount;
    /**
     * The number of comments on this video by people who have viewed it on
     * YouTube.
     */
    int commentCount;

    //constructor(s)
    /**
     * This creates a YouTube video. It takes no parameters.
     */
    public YouTubeVideo() {
    }

    /**
     * Overrides the toString method
     *
     * @return a string containing the date, channel, title and view count of a
     * <code>YouTubeVideo</code>.
     */
    @Override
    public String toString() {
        return publishedAt.substring(0, 10) + " " + publishedAt.substring(11, 16) + " - " + channelTitle + " - " + title + " (Views: " + viewCount + ")";
    }

    // Getter and Setter methods 
    /**
     * Gets the kind of this video.
     *
     * @return kind as a string.
     */
    public String getKind() {
        return kind;
    }

    /**
     * Sets the kind field of this video.
     *
     * @param kind is a string parameter that is assigned to this video's kind
     * field.
     */
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * Gets the etag of this video.
     *
     * @return etag as a string.
     */
    public String getEtag() {
        return etag;
    }

    /**
     * Sets the etag of this video.
     *
     * @param etag is a string parameter that is assigned to this video's etag
     * field.
     */
    public void setEtag(String etag) {
        this.etag = etag;
    }

    /**
     * Gets the ID of this video.
     *
     * @return ID as a string.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the ID of this video.
     *
     * @param id is a string parameter that is assigned to this video's ID
     * field.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the Tags of this video.
     *
     * @return Tags as a string array.
     */
    public String[] getTagsArray() {
        return tags;
    }

    public String getTag(int i) {
        return tags[i];
    }

    /**
     * Sets the Tags of this video.
     *
     * @param tags is a string array parameter that is assigned to this video's
     * Tags field.
     */
    public void setTags(String[] tags) {
        this.tags = tags;
    }

    /**
     * Gets the Date Published for this video.
     *
     * @return the Date as a string.
     */
    public String getPublishedAt() {
        return publishedAt;
    }

    /**
     * Sets the Date Published of this video.
     *
     * @param publishedAt is a string parameter that is assigned to this video's
     * PublishedAt field.
     */
    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    /**
     * Gets the Channel ID of this video.
     *
     * @return the Channel ID as a string.
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * Sets the Channel ID of this video.
     *
     * @param channelId is a string parameter that is assigned to this video's
     * channelID field.
     */
    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    /**
     * Gets the Title of this video.
     *
     * @return the Title as a string.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the Title of this video.
     *
     * @param title is a string parameter that is assigned to this video's Title
     * field.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the Description of this video.
     *
     * @return the Description as a string.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the Description of this video.
     *
     * @param description is a string parameter that is assigned to this video's
     * Description field.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the Channel Title of this video.
     *
     * @return the Channel Title as a string.
     */
    public String getChannelTitle() {
        return channelTitle;
    }

    /**
     * Sets the Channel Title of this video.
     *
     * @param channelTitle is a string parameter that is assigned to this
     * video's channelTitle field.
     */
    public void setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
    }

    /**
     * Gets the Category ID of this video.
     *
     * @return the Category ID as a string.
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * Sets the Category ID of this video.
     *
     * @param categoryId is a string parameter that is assigned to this video's
     * categoryID field.
     */
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * Gets the View Count of this video.
     *
     * @return the View Count as an int.
     */
    public int getViewCount() {
        return viewCount;
    }

    /**
     * Sets the View Count of this video.
     *
     * @param viewCount is an int parameter that is assigned to this video's
     * viewCount field.
     */
    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    /**
     * Gets the Like Count of this video.
     *
     * @return Like Count as an int.
     */
    public int getLikeCount() {
        return likeCount;
    }

    /**
     * Sets the Like Count of this video.
     *
     * @param likeCount is an int parameter that is assigned to this video's
     * likeCount field.
     */
    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    /**
     * Gets the Dislike Count of this video.
     *
     * @return Dislike Count as an int.
     */
    public int getDislikeCount() {
        return dislikeCount;
    }

    /**
     * Sets the Dislike Count of this video.
     *
     * @param dislikeCount is an int parameter that is assigned to this video's
     * dislikeCount field.
     */
    public void setDislikeCount(int dislikeCount) {
        this.dislikeCount = dislikeCount;
    }

    /**
     * Gets the ratio of Likes to Dislikes of this video.
     *
     * @return Like Count as float.
     */
    public float getLikeRatio() {
        return ((float)getLikeCount() / ((float)getDislikeCount() + 1));
    }

    /**
     * Gets the Favourite Count of this video.
     *
     * @return Favourite Count as an int.
     */
    public int getFavouriteCount() {
        return favouriteCount;
    }

    /**
     * Sets the Favourite Count of this video.
     *
     * @param favouriteCount is an int parameter that is assigned to this
     * video's favouriteCount field.
     */
    public void setFavouriteCount(int favouriteCount) {
        this.favouriteCount = favouriteCount;
    }

    /**
     * Gets the Comment Count of this video.
     *
     * @return Comment Count as an int.
     */
    public int getCommentCount() {
        return commentCount;
    }

    /**
     * Sets the Comment Count of this video.
     *
     * @param commentCount is an int parameter that is assigned to this video's
     * commentCount field.
     */
    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    @Override
    public int compareTo(YouTubeVideo o) {
        return o.id.compareTo(this.id);
    }

}
