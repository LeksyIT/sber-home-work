package work_with_file;

import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String path1 = "src\\main\\java\\work_with_file\\test.txt";
        String path2 = "src\\main\\java\\work_with_file\\test1.txt";
        counterByLength(path1);
        counterByCount(path1);
        lineReverse(path2);
        getLine(path2,4);
    }

    private static Map<String,Integer> wordPars(String path) throws IOException {
        Map<String,Integer> map = new HashMap<>();
        FileInputStream fis = new FileInputStream(path);
        String[] data = IOUtils.toString(fis, StandardCharsets.UTF_8).
                replaceAll("[^а-яА-Я_0-9]"," ").
                replaceAll("\\s+"," ").split(" ");
        Arrays.stream(data).forEach(s->map.merge(s,1, Integer::sum));
        return map;
    }
    private static void counterByCount(String path) throws IOException {
        wordPars(path).
                entrySet().
                stream().
                sorted(Map.Entry.comparingByValue()).
                forEach((x)-> System.out.println(x.getValue() + ":" + x.getKey()));
    }

    private static void counterByLength(String path) throws IOException {
        wordPars(path).
                entrySet().
                stream().sorted(Map.Entry.comparingByKey(Comparator.comparingInt(String::length))).
                forEach((x)-> System.out.println(x.getKey() + ":" + x.getValue()));
    }
    private static void lineReverse(String path) throws IOException {
        List<String> read = Files.readAllLines(Paths.get(path));
        Collections.reverse(read);
        System.out.println(read);
    }

    private static void getLine(String path,int line) throws IOException {
        List<String> read = Files.readAllLines(Paths.get(path));
        System.out.println(read.get(line-1));
    }


}
