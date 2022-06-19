package work_with_file;

import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        wordCounter("src\\main\\java\\work_with_file\\test.txt");
    }

    private static void wordCounter(String path) throws IOException {
        Map<String,Integer> map = new HashMap<>();
        FileInputStream fis = new FileInputStream(path);
        String[] data = IOUtils.toString(fis, StandardCharsets.UTF_8).
                replaceAll("[^а-яА-Я_0-9]"," ").
                replaceAll("\\s+"," ").split(" ");
        Arrays.stream(data).forEach(s->map.merge(s,1, Integer::sum));
        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach((x)-> System.out.println(x.getValue() + ":" + x.getKey()));
    }
}
