package flyweight;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class User {
    static List<String> names = new ArrayList<>();
    private int[] userFullName;

    public User(String fullName) {
        fullName.trim();
        ToIntFunction<String> getOrAdd = s -> {
            int index = names.indexOf(s);
            if (index == -1) {
                names.add(s);
                index = names.size() - 1;
            }
            return index;
        };

        userFullName = Arrays.stream(fullName.split("\\s"))
                .mapToInt(getOrAdd).toArray();
    }

    public String getName() {
        return Arrays.stream(userFullName).mapToObj(i -> names.get(i))
                .collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {
        User user = new User("Blo Blo");
        User user2 = new User("Joe Blo");
        System.out.println(user.getName());
        System.out.println(user2.getName());
    }
}
