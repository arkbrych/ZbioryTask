package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * @author Arkadiusz
 * class load names from file, than filter unique names and priting them
 */
public class Main {
    public static void main(String[] args) {
        final String FILE_NAME = "src\\resources\\namespl.txt";
        TreeSet<String> set = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        List<String> resultList = fileReader(FILE_NAME);

        for (int i =0; i < resultList.size(); i++){
            set.add(resultList.get(i));
        }
        System.out.println("Ilość elementów w pierwotnej liście: " + resultList.size());
        System.out.println("Ilość elementów w posortowanej liście: " + set.size());
        System.out.println("Pierwszy element: " + set.first());
        System.out.println("Ostatni element: " + set.last());

    }

    static List<String> fileReader(String fileName) {
        List<String> namesFromFile = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);
            String nextLine = null;
            while((nextLine = bufferedReader.readLine())!=null){
                namesFromFile.add(nextLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return namesFromFile;
    }
}
