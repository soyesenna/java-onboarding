package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {

    public static void main(String[] args) {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        );
        System.out.println(solution(forms));
    }
    public static List<String> solution(List<List<String>> forms) {

        List<String> names = forms.stream()
                .map((person) -> person.get(1))
                .collect(Collectors.toList());

        List<String> answer = checkOverlap(names, forms).stream()
                .sorted()
                .collect(Collectors.toList());
        return answer;
    }

    public static List<String> checkOverlap(List<String> names, List<List<String>> forms) {
        Set<String> result = new HashSet<>();

        for (String name : names) {
            for (int i = 0; i < name.length() - 1; i++) {
                String now = name.substring(i, i + 2);
                for (List<String> person : forms) {
                    if (name.equals(person.get(1))) continue;
                    if (person.get(1).contains(now)) result.add(person.get(0));
                }
            }
        }
        return result.stream()
                .collect(Collectors.toList());
    }
}
