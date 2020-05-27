package com.cirta.software.lambda;

import java.io.File;
import java.io.FileFilter;

public class FirstLambda {
    public static void main (String [] args){

        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().startsWith(".java");
            }
        };

        FileFilter fileFilterLambda = (File pathname) -> pathname.getName().startsWith(".java");

        File file = new File("d:/tmp");
        File[] files = file.listFiles(fileFilterLambda);
        for (File f : files) {
            System.out.println(f);
        }
    }
}
