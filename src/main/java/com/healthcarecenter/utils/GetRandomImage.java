package com.healthcarecenter.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class GetRandomImage {
    public static String getRandomImage() {
        try {
            String folderPath = FileUtils.getFile("/images").getAbsolutePath();
            List<String> imageFiles = Files.list(Paths.get(folderPath))
                    .filter(Files::isRegularFile)
                    .map(path -> path.toString())
                    .collect(Collectors.toList());
            Random random = new Random();
            return imageFiles.get(random.nextInt(imageFiles.size()));
        } catch (IOException ex) {
        }
        return null;
    }
}
