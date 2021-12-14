package com.company.io;

import com.company.data.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader<T> {
    public List<T> read(DataFileWrapper<T> instanceWrapper, String filePath) {
        List<T> list = new ArrayList<T>();
        try {
            //pass the path to the file as a parameter "D:\\skola\\KOP\\firstHW\\nr\\NR4_inst.dat"
            File file = new File(filePath);
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                T dc = instanceWrapper.read(sc.nextLine());
                list.add(dc);
                //System.out.println(dc.toString());
            }
        } catch(Exception e) {
            System.out.println("file not found");
        }

        return list;
    }
}
