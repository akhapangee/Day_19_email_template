package com.akhilesh.core.helper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Akhilesh
 */
public class FileHelper {

    public static String readFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader
                = new BufferedReader(
                        new FileReader(filePath))) {
            String line = "";

            while ((line = reader.readLine()) != null) {
                content.append(line).append(("\r\n"));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return content.toString();
    }
}
