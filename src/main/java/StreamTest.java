import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {
        getUserIds().forEach(userId -> System.out.println(userId)); // Результат: StreamTest.UserId(id=5)
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class UserId {
        private Integer id;
    }

    private static List<UserId> getUserIds() {
        var list = new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(null);
            add(5);
        }};


        // дополнить -> List<UserId[5]
        return list.stream().filter(data -> data != null).filter(data -> data >= 5).map(data -> new UserId(data)).collect(Collectors.toList());
    }
}
