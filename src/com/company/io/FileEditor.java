package com.company.io;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class FileEditor<T> {
    public List<T> readFile(String filePath) {
        List<T> list = new ArrayList<T>();
        try {
            File file = new File(filePath);
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                T dc = read(sc.nextLine());
                //System.out.println(dc);
                list.add(dc);
            }
        } catch(Exception e) {
            System.out.println("file not found");
        }

        return list;
    }

    abstract protected T read(String line);
}
