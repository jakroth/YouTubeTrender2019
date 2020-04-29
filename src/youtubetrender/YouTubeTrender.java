/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youtubetrender;

/**
 * This class contains {@link #main(java.lang.String[])}. It calls methods to
 * parse YouTube video JSON data and finds trends in the data. It also contains
 * some testing methods to prove the program is functioning correctly.
 *
 * @author Joel Pillar-Rogers (extends an application designed by Trent)
 */
public class YouTubeTrender {

    /**
     * Starts the program, calls methods from the other classes and runs the tests.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("YouTube Trender Application");
        System.out.println("");

        // Choose a file to parse
        System.out.println("Choose a file to parse: ");
        String filename = "data/youtubedata_15_50.json";
        System.out.println("Filename entered: " + filename);
        System.out.println("");

        /**
         * Runs a YouTubeDataParser over the selected file.
         */
        System.out.println("------PARSING: " + filename + "------");
        YouTubeDataParser ytParser = new YouTubeDataParser();
        try {
            ytParser.parse(filename);
        } catch (YouTubeDataParserException tydpe) {
            System.out.println("An error was encountered during parsing. Here is a brief description of the error:  \n \"" + tydpe.getMessage() + "\"");
            System.out.println("");
        }

        /**
         * Runs a YouTubeVideoIndexer over the YouTubeDataParser.
         */
        YouTubeVideoIndexer ytIndexer = new YouTubeVideoIndexer();
        ytIndexer.index(ytParser);

        
               
        
        System.out.println("\n********TESTING********\n\n");

        /* TEST THESE ONE BY ONE BY UNCOMMENTING */
        //Test 1: Test the parsing code
        parseTest(ytParser);
        // Test 2: Test the parsing code with every file
        parseTestAll();
        // Test 3: Test the sorting code
        sortTest(ytParser);
        // Test 4: Test the indexer code
        indexerTest();
        // Test 5: Test the index finder code
        indexFinderTest(ytIndexer);
        // Test 6: Test the index counter code
        indexSorterTest(ytIndexer);
    }

    
    
    //***TESTING ONLY BELOW THIS POINT***//
    
    
    
    
    /**
     * Tests the parsing code of this package.
     *
     * @param ytParser is a YouTubeDataParser passed as a parameter to test its
     * parsing.
     */
    public static void parseTest(YouTubeDataParser ytParser) {
        System.out.println("Testing the parsing of the first file.\n");

        ytParser.printVideo(1);
        ytParser.printVideo(99);
        System.out.println("------Video List - Unsorted------");
        ytParser.print();
        System.out.println("Number of Videos: " + ytParser.size());
        System.out.println("Expected Number of Videos: 50");
        boolean success = (50 == ytParser.size());
        System.out.println("Success: " + success);
        System.out.println("");
    }

    /**
     * Tests the parsing code of this package with every other data source.
     *
     */
    public static void parseTestAll() {
        System.out.println("Testing the parsing of the other files.\n");

        String filename = "data/youtubedata.json";
        System.out.println("------PARSING: " + filename + "------");
        YouTubeDataParser ytParser = new YouTubeDataParser();
        try {
            ytParser.parse(filename);
        } catch (YouTubeDataParserException tydpe) {
            System.out.println("An error was encountered during parsing. Here is a brief description of the error:  \n \"" + tydpe.getMessage() + "\"");
            System.out.println("");
        }
        ytParser.printVideo(0);
        System.out.println("------Video List - Unsorted------");
        ytParser.print();
        System.out.println("Number of Videos: " + ytParser.size());
        System.out.println("Expected Number of Videos: 1");
        boolean success = (1 == ytParser.size());
        System.out.println("Success: " + success);
        System.out.println("");

        filename = "data/youtubedata_loremipsum.json";
        System.out.println("------PARSING: " + filename + "------");
        ytParser = new YouTubeDataParser();
        try {
            ytParser.parse(filename);
        } catch (YouTubeDataParserException tydpe) {
            System.out.println("An error was encountered during parsing. Here is a brief description of the error:  \n \"" + tydpe.getMessage() + "\"");
            System.out.println("");
        }
        ytParser.printVideo(0);
        System.out.println("------Video List - Unsorted------");
        ytParser.print();
        System.out.println("Number of Videos: " + ytParser.size());
        System.out.println("Expected Number of Videos: 10");
        success = (10 == ytParser.size());
        System.out.println("Success: " + success);
        System.out.println("");

        filename = "data/youtubedata_indextest.json";
        System.out.println("------PARSING: " + filename + "------");
        ytParser = new YouTubeDataParser();
        try {
            ytParser.parse(filename);
        } catch (YouTubeDataParserException tydpe) {
            System.out.println("An error was encountered during parsing. Here is a brief description of the error:  \n \"" + tydpe.getMessage() + "\"");
            System.out.println("");
        }
        ytParser.printVideo(0);
        System.out.println("------Video List - Unsorted------");
        ytParser.print();
        System.out.println("Number of Videos: " + ytParser.size());
        System.out.println("Expected Number of Videos: 1");
        success = (1 == ytParser.size());
        System.out.println("Success: " + success);
        System.out.println("");

        filename = "data/youtubedata_singleitem.json";
        System.out.println("------PARSING: " + filename + "------");
        ytParser = new YouTubeDataParser();
        try {
            ytParser.parse(filename);
        } catch (YouTubeDataParserException tydpe) {
            System.out.println("An error was encountered during parsing. Here is a brief description of the error:  \n \"" + tydpe.getMessage() + "\"");
            System.out.println("");
        }
        ytParser.printVideo(0);
        System.out.println("------Video List - Unsorted------");
        ytParser.print();
        System.out.println("Number of Videos: " + ytParser.size());
        System.out.println("Expected Number of Videos: 1");
        success = (1 == ytParser.size());
        System.out.println("Success: " + success);
        System.out.println("");

        filename = "data/youtubedata_malformed.json";
        System.out.println("------PARSING: " + filename + "------");
        ytParser = new YouTubeDataParser();
        try {
            ytParser.parse(filename);
        } catch (YouTubeDataParserException tydpe) {
            System.out.println("An error was encountered during parsing. Here is a brief description of the error:  \n \"" + tydpe.getMessage() + "\"");
            System.out.println("");
        }
        ytParser.printVideo(0);
        System.out.println("------Video List - Unsorted------");
        ytParser.print();
        System.out.println("Number of Videos: " + ytParser.size());
        System.out.println("Expected Number of Videos: 0 (malformed Json file)");
        System.out.println("Success if parsing error message printed");
        System.out.println("");
        
        filename = "data/youtubedata_missing.json";
        System.out.println("------PARSING: " + filename + "------");
        ytParser = new YouTubeDataParser();
        try {
            ytParser.parse(filename);
        } catch (YouTubeDataParserException tydpe) {
            System.out.println("An error was encountered during parsing. Here is a brief description of the error:  \n \"" + tydpe.getMessage() + "\"");
            System.out.println("");
        }
        ytParser.printVideo(0);
        System.out.println("------Video List - Unsorted------");
        ytParser.print();
        System.out.println("Number of Videos: " + ytParser.size());
        System.out.println("Expected Number of Videos: 0 (missing Json file)");
        System.out.println("Success if missing file error message printed");
        System.out.println("");
    }

    /**
     * Tests the sorting code of this package.
     *
     * @param ytParser is a YouTubeDataParser passed as a parameter to test its
     * sorting.
     */
    public static void sortTest(YouTubeDataParser ytParser) {
        System.out.println("Testing the sorting of the first file.");
        System.out.println("");

        ytParser.sortByDate();
        System.out.println("------Video List - Sorted by Date (ascending)------");
        ytParser.print();

        ytParser.sortByTitle();
        System.out.println("------Video List - Sorted by Title------");
        ytParser.print();

        ytParser.sortByChannelTitle();
        System.out.println("------Video List - Sorted by Channel Title------");
        ytParser.print();

        ytParser.sortByViews();
        System.out.println("------Video List - Sorted by Views (ascending)------");
        ytParser.print(); 

        ytParser.sortByComments();
        System.out.println("------Video List - Sorted by Comments (ascending)------");
        ytParser.print();

        ytParser.sortByLikes();
        System.out.println("------Video List - Sorted by Likes------");
        ytParser.printLikes();

        ytParser.sortByLikeRatio();
        System.out.println("------Video List - Sorted by Like Ratio------");
        ytParser.printLikes();

        ytParser.sortByDescriptionLength();
        System.out.println("------Video List - Sorted by Description Length------");
        ytParser.printDescription();
    }

    /**
     * Tests the indexing code of this package.
     *
     */
    public static void indexerTest() {
        System.out.println("Testing the indexing of the indextest Json file.");
        System.out.println("");

        String filename2 = "data/youtubedata_indextest.json";
        System.out.println("------PARSING: " + filename2 + "------");
        YouTubeDataParser ytParser2 = new YouTubeDataParser();
        try {
            ytParser2.parse(filename2);
        } catch (YouTubeDataParserException tydpe) {
            System.out.println("An error was encountered during parsing. Here is a brief description of the error:  \n \"" + tydpe.getMessage() + "\"");
            System.out.println("");
        }
        ytParser2.printVideo(0);

        YouTubeVideoIndexer ytIndexer2 = new YouTubeVideoIndexer();
        ytIndexer2.index(ytParser2);

        ytIndexer2.printSortedWordItems(); // careful - prints MANY rows
        try {
            System.out.println("Most used word: \"" + ytIndexer2.getMostUsedWord().getWord() + "\"");
            System.out.println("Number of unique words parsed: " + ytIndexer2.countUniqueWords());
            System.out.println("");
        } catch (IndexOutOfBoundsException ioobe) {
            System.out.println("The video list could not be parsed.");
        }
    }

    /**
     * Tests the indexing and finding code of this package.
     *
     * @param ytIndexer is a YouTubeVideoIndexer passed as a parameter to test
     * its indexing.
     */
    public static void indexFinderTest(YouTubeVideoIndexer ytIndexer) {
        System.out.println("Testing the indexing and searching of the first file.");
        System.out.println("");

        try {
            String testword = "and";
            System.out.println("Find this word: \"" + testword + "\"");
            ytIndexer.printWordItem(testword);
            ytIndexer.getWordItem(testword).printPosts();
        } catch (NullPointerException npe) {
            System.out.println("This word was not found in the Videos parsed.");
        }

        try {
            String testword = "zzz";
            System.out.println("Find this word: \"" + testword + "\"");
            ytIndexer.printWordItem(testword);
            ytIndexer.getWordItem(testword).printPosts();
        } catch (NullPointerException npe) {
            System.out.println("This word was not found in the Videos parsed.");
        }
    }

    /**
     * Tests the indexing and counting code of this package.
     *
     * @param ytIndexer is a YouTubeVideoIndexer passed as a parameter to test
     * its indexing.
     */
    public static void indexSorterTest(YouTubeVideoIndexer ytIndexer) {
        System.out.println("Testing the indexing and counting of the first file.");
        System.out.println("");

        ytIndexer.printSortedWordItems(); // careful - prints MANY rows
        try {
            System.out.println("Most used word: \"" + ytIndexer.getMostUsedWord().getWord() + "\"");
            System.out.println("Number of unique words parsed: " + ytIndexer.countUniqueWords());
            System.out.println("");
        } catch (IndexOutOfBoundsException ioobe) {
            System.out.println("The video list could not be parsed.");
        }
    }

}
