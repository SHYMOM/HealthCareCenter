package com.healthcarecenter.utils;

import java.io.*;

public class FileUtils {

    public static File getFile(String filePath) {
        String absolutePath = new File("Test/HealthCareCenter/src/main/resources", filePath).getAbsolutePath();
        return new File(absolutePath);
    }

    public static boolean doesFileExist(String filePath) {
        String absolutePath = new File("Test/HealthCareCenter/src/main/resources", filePath).getAbsolutePath();
        File file = getFile(absolutePath); 
        return file.exists();
    }
}
