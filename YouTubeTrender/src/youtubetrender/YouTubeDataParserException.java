/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youtubetrender;

/**
 * This class provides an exception for the java class YouTubeDataParser. It is used to summarise any built-in exceptions arising from the parsing process. 
 * @author Joel
 */
public class YouTubeDataParserException extends Exception {

    /**
     * Overrides the default constructor for this exception, adding a message when is is first thrown. 
     * @param message is a string that is passed into the message field of the super class, to be retrieved when the exception is caught. 
     */
    public YouTubeDataParserException(String message) {
        super(message);
    }
}
