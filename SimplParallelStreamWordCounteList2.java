package com.program.java8.streams;

import static java.lang.Integer.compare;
import static java.lang.Integer.parseInt;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimplParallelStreamWordCounteList2 {
    public static void main(String[] args) throws Exception {
        System.out.println("\n\nParallel word count example using Old Testement King James bible");
        textWordCount("C:/MyProjects/Java8Features/src/com/program/java8/streams/kjvdat.txt");
    }
    /**
     * Return the top 5 most frequently used words from the sample text.
     * @throws Exception
     */
    private static void textWordCount(String fileName) throws Exception {
        long start = Instant.now().toEpochMilli();
        ConcurrentHashMap<String, LongAdder> wordCounts = new ConcurrentHashMap<>();
        System.out.println("\tReading file: "+fileName);
        Path filePath = Paths.get(fileName);
        Stream<String> lines = Files.readAllLines(filePath)
            .parallelStream()                               
            .map(line -> line.split("\\s+")).flatMap(wordsOFList->Stream.of(wordsOFList));   
        lines.forEach(System.out::println);
            /*.flatMap(Arrays::stream)                        
            .parallel()                                     
            .filter(w -> w.matches("\\w+"))                 // Filter out non-word items
            .map(String::toLowerCase)                       // Convert to lower case
            .forEach(word -> {                              // Use an AtomicAdder to tally word counts
                if (!wordCounts.containsKey(word))          // If a hashmap entry for the word doesn't exist yet
                    wordCounts.put(word, new LongAdder());  // Create a new LongAdder
                wordCounts.get(word).increment();           // Increment the LongAdder for each instance of a word
            });*/
       /* wordCounts
                .keySet()
                .stream()
                .map(key -> String.format("%-10d %s", wordCounts.get(key).intValue(), key))
                .sorted((prev, next) -> compare(parseInt(next.split("\\s+")[0]), parseInt(prev.split("\\s+")[0])))
                .limit(5)
                .forEach(t -> System.out.println("\t"+t));
        long end = Instant.now().toEpochMilli();*/
      //  System.out.println(String.format("\tCompleted in %d milliseconds", (end-start)));
    }
}