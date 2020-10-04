package vn.codegym.picture.service;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BadWords {
    private static List<String> badWordsList;

    static {
        badWordsList = new ArrayList<>();
        badWordsList.add("xxx");
        badWordsList.add("yyy");
        badWordsList.add("zzz");
        badWordsList.add("fuck");
    }

    public List<String> getBadWordList(){
        return badWordsList;
    }
}
