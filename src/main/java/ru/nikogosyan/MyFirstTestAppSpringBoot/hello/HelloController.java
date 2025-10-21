package ru.nikogosyan.MyFirstTestAppSpringBoot.hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name",
            defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    private final List<String> arrayList = new ArrayList<>();
    private final Map<Integer, String> hashMap = new HashMap<>();
    private final AtomicInteger mapKeyGenerator = new AtomicInteger(1);

    @GetMapping("/update-array")
    public String updateArrayList(@RequestParam String s) {
        arrayList.add(s);
        return "Added to ArrayList: " + s;
    }

    @GetMapping("/show-array")
    public List<String> showArrayList() {
        return new ArrayList<>(arrayList);
    }

    @GetMapping("/update-map")
    public String updateHashMap(@RequestParam String s) {
        int key = mapKeyGenerator.getAndIncrement();
        hashMap.put(key, s);
        return "Added to HashMap: key=" + key + ", value=" + s;
    }

    @GetMapping("/show-map")
    public Map<Integer, String> showHashMap() {
        return new LinkedHashMap<>(hashMap);
    }

    @GetMapping("/show-all-lenght")
    public String showAllLength() {
        return String.format("ArrayList содержит %d элементов, HashMap содержит %d элементов",
                arrayList.size(), hashMap.size());
    }
}
