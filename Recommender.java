import java.util.*;

public class Recommender {
    public static void main(String[] args) {

        Map<Integer, List<Integer>> userData = new HashMap<>();

        userData.put(1, Arrays.asList(101, 102));
        userData.put(2, Arrays.asList(102, 103));
        userData.put(3, Arrays.asList(101, 103, 104));

        System.out.println("Recommended Items for User 1:");

        List<Integer> recommended = userData.get(3);

        for (int item : recommended) {
            if (!userData.get(1).contains(item)) {
                System.out.println("Item: " + item);
            }
        }
    }
}