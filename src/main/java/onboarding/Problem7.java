package onboarding;

import java.util.*;

public class Problem7 {

    public static void main(String[] args) {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        solution(user, friends, visitors);
    }

    public static Map<String, List<String>> friendsMap = new HashMap<>();
    public static Map<String, Integer> scoreMap = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        getFriends(friends);
        getScore(user, visitors);

        System.out.println(friendsMap);
        System.out.println(scoreMap);

        return null;
    }

    public static void getScore(String user, List<String> visitors) {
        getFriendScore(user);
        getVisitScore(visitors);
    }

    public static void getVisitScore(List<String> visitors) {
        for (String visitor : visitors) {
            if (scoreMap.containsKey(visitor)) scoreMap.compute(visitor, (k, v) -> v++);
            else scoreMap.put(visitor, 1);
        }
    }

    public static void getFriendScore(String user) {
        Set<String> keys = friendsMap.keySet();
        List<String> userFriends = friendsMap.get(user);

        for (String key : keys) {
            List<String> nowFriends = friendsMap.get(key);
            for (String name : nowFriends) scoreMap.put(name, calculateFriendScore(userFriends, nowFriends));
        }
    }

    private static int calculateFriendScore(List<String> userFriends, List<String> nowFriends){
        int score = 0;
        for (String userFriend : userFriends) {
            if (nowFriends.contains(userFriend)) score += 10;
        }

        return score;
    }

    public static void getFriends(List<List<String>> friends){
        for (List<String> friend : friends) {
            String name1 = friend.get(0);
            String name2 = friend.get(1);
            mappingFriend(friendsMap, name1, name2);
            mappingFriend(friendsMap, name2, name1);
        }
    }

    private static void mappingFriend(Map<String, List<String>> friendsMap, String name1, String name2) {
        if (friendsMap.containsKey(name1)) friendsMap.get(name1).add(name2);
        else {
            List<String> tmp = new ArrayList<>();
            tmp.add(name2);
            friendsMap.put(name1, tmp);
        }
    }
}
