package com.akhilesh.core;

import com.akhilesh.core.helper.FileHelper;
import com.akhilesh.core.util.Parser;

/**
 *
 * @author Akhilesh
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String template = FileHelper.readFile("template/email.txt");
//        System.out.println(template);

        String[] names = {"Akhilesh", "Hari", "Shyam", "Akash"};
        for (String name : names) {
            Parser parser = new Parser("[", "]");
            parser.addData("name", name)
                    .addData("url", "http://akhilesh.com.np/")
                    .addData("product_url", "http://akhilesh.com.np/");
            System.out.println(parser.parse(template));
            System.out.println("=============================================================");
        }

    }

}
