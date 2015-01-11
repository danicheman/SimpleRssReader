package com.simplerssreader;

import android.test.AndroidTestCase;
import com.simplerssreader.RssParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Exception;
import java.lang.Override;

/**
 * Created by nick on 1/6/15.
 */
public class TestRssParser extends AndroidTestCase {
    private RssParser testParser;

    private String[] xmlTestFiles = { "invalid_bare_tag.xml", "invalid_tag_in_cdata.xml" };

    @Override
    protected void setUp() throws Exception {

        super.setUp();

        FileInputStream fileStream;
        List<RssItem> rssList;

        testParser = getClass();

        for ( String fileName : this.xmlTestFiles) {
            fileStream = loadXMLTestFile(fileName)
            try {
                rssList = testParser.parse(fileStream);
            } catch(Exception e) {
                //e.getMessage();
            }

        }

    }
    private InputStream loadXMLTestFile(String filename) {
        FileInputStream fileStream = new FileInputStream(filename);

        return fileStream;

    }
}
