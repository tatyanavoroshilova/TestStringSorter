package rudenko.testtask;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByKey;

public class StringSorter {
    private static final String EMPTY_STRING = "";

    public String getSortedString(String testString) {
        List<String> testList = Arrays.asList(testString.split(" "));
        //form pairs: char - strings starts with this char
        Map<Character, List<String>> charStrMap = new HashMap<>();
        testList.stream()
                .filter(s -> !s.isEmpty())
                .forEach(oneStr -> {
                    List<String> existingList = charStrMap.get(oneStr.charAt(0));
                    if (existingList == null) {
                        existingList = new ArrayList<>();
                    }
                    existingList.add(oneStr);
                    charStrMap.put(oneStr.charAt(0), existingList);
                });

        charStrMap.forEach((key, value) -> { //sort strings inside group
            (value).sort((s1, s2) -> {
                if (s1.length() == s2.length()) {
                    return s1.compareTo(s2);
                }
                return s1.length() > s2.length() ? -1 : 1;
            });
        });

        return charStrMap.size() > 0 ? charStrMap.entrySet().stream()
                .filter(x -> x.getValue().size() > 1)
                .sorted(comparingByKey())
                .map(e -> e.getKey() + "=" + e.getValue())
                .collect(Collectors.joining(", ", "[", "]"))
                : EMPTY_STRING;
    }
}