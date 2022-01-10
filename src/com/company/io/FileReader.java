package com.company.io;

import com.company.data.*;

import javax.sound.sampled.Line;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader<T extends LineReader> {
    public List<T> read(String filePath, T reader) {
        List<T> list = new ArrayList<T>();
        try {
            //pass the path to the file as a parameter "D:\\skola\\KOP\\firstHW\\nr\\NR4_inst.dat"
            File file = new File(filePath);
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                T dc = (T) reader.read(sc.nextLine());
                list.add(dc);
            }
        } catch(Exception e) {
            System.out.println("file not found");
        }

        return list;
    }
}
