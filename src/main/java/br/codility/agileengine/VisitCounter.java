package br.codility.agileengine;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

/*
The system you work with on a daily basis runs multiple microservices. You have been asked to prepare an aggregation that represents number of user visits to all microservices, for use by data analysis.

The architect you are working with has already designed the API, which consists of a single class:VisitCounter.VisitCounter has a single method,count.

It returns Map<Long , Long> - this map should contain the number of visits by the user with a given ID.

This method accepts an array of Map<String , UserStats>. Every Map represents the total number of visits per user to a given microservice. There are some problems, however:

1. The Map key, which is a string, should be parseable to Long - but it may not be. You must skip any such faulty entries.(())

2. for some keys, UserStats may be null. You must skip any such faulty entries.(())

3. UserStats has a single field, visitCount, of type Optional<Long>. A getter for this field is also implemented. This field will never be null; however it might be empty. You must skip any such faulty entries.(())

Remember that you may receive some invalid input: null,empty maps, and so on. Handle it all appropriately and return an empty map/
You may use Java 8 Streams API to implement your solution.
 */

class UserStats {
    private Optional<Long> visitCount;

    public UserStats(Optional<Long> visitCount) {
        this.visitCount = visitCount;
    }

    public Optional<Long> getVisitCount() {
        return visitCount;
    }
}

public class VisitCounter {

    public Map<Long, Long> count(Map<String, UserStats>[] microservices) {
        if (microservices == null || Stream.of(microservices).anyMatch(map -> map == null || map.isEmpty())) {
            return new HashMap<>();
        }

        HashMap<Long, Long> resul = Stream.of(microservices)
                .filter(this::isValidMap)
                .flatMap(map -> map.entrySet().stream())
                .filter(this::isValidEntry)
                .collect(
                        HashMap::new,
                        (resultMap, entry) -> resultMap.merge(parseUserId(entry.getKey()), entry.getValue().getVisitCount().orElse(0L), Long::sum),
                        HashMap::putAll
                );
        return resul;
    }

    private boolean isValidMap(Map<String, UserStats> map) {
        return map != null && !map.isEmpty();
    }

    private boolean isValidEntry(Map.Entry<String, UserStats> entry) {
        return isNumeric(entry.getKey()) && isValidUserStats(entry.getValue());
    }

    private boolean isValidUserStats(UserStats userStats) {
        return userStats != null && userStats.getVisitCount().isPresent();
    }

    private long parseUserId(String key) {
        try {
            return Long.parseLong(key);
        } catch (NumberFormatException e) {
            // Handle parsing error, return a default value (e.g., -1) or throw an exception
            return -1;
        }
    }

    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        int sz = str.length();
        for (int i = 0; i < sz; i++) {
            if (Character.isDigit(str.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
        // Example usage
        VisitCounter visitCounter = new VisitCounter();

        // Creating some example microservices data
        Map<String, UserStats> microservice1 = new HashMap<>();
        microservice1.put("123", new UserStats(Optional.of(5L)));
        microservice1.put("456", new UserStats(Optional.empty()));
        microservice1.put("789", null);

        Map<String, UserStats> microservice2 = new HashMap<>();
        microservice2.put("123", new UserStats(Optional.of(3L)));
        microservice2.put("456", new UserStats(Optional.of(7L)));
        microservice2.put("invalid", new UserStats(Optional.of(2L)));

        // Calculating aggregated user visits
        Map<Long, Long> aggregatedVisits = visitCounter.count(new Map[]{microservice1, microservice2});

        // Displaying the result
        System.out.println(aggregatedVisits);
    }
}
