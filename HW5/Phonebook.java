
import java.util.*;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        HashMap<String, List<String>> pb = new HashMap<>();
        List<String> names = new ArrayList<>();
        List<String> phones = new ArrayList<>();

//        Этот code snippet принимает на вход имя и тел номер.
//        Для удобства проверки задания names и phones заполнен вручную.
//        boolean inPut = false;
//        while (!inPut) {
//            System.out.print("Press 1 to add contact / Press 0 to exit ");
//            int choice = scnr.nextInt();
//
//            switch (choice) {
//                case 0 -> {
//                    inPut = true;
//                }
//                case 1 -> {
//                    System.out.print("Enter name: ");
//                    scnr.nextLine();
//                    names.add(scnr.nextLine());
//                    System.out.print("Enter number: ");
//                    phones.add(scnr.nextLine());
//                }
//            }
//        }

        names.add("John");
        names.add("Angela");
        names.add("Angela");
        names.add("Jolin");
        names.add("Leo");
        names.add("John");
        names.add("John");
        names.add("Angela");
        names.add("Leo");
        names.add("John");

        phones.add("4568");
        phones.add("7894");
        phones.add("1178");
        phones.add("5465");
        phones.add("6846");
        phones.add("5465");
        phones.add("321");
        phones.add("1654");
        phones.add("5555");
        phones.add("5465");


        // Если key повторяется, то value = value old + value new (value type is ArrayList)
        for (int i = 0; i < names.size(); i++) {
            pb.computeIfAbsent(names.get(i), c -> new ArrayList<>()).add(phones.get(i));
        }

        System.out.println(pb);
        //{Leo=[6846, 5555], John=[4568, 5465, 321, 5465], Angela=[7894, 1178, 1654], Jolin=[5465]}
        System.out.println("=======================");

        // Сортировка по количеству тел. номеров

        ArrayList<Map.Entry<String, List<String>>> workerList = new ArrayList<>(pb.entrySet());

        workerList.sort((o1, o2) -> {
            if (o1.getValue().size() == o2.getValue().size())
                return o1.getKey().compareTo(o2.getKey());

            return Integer.compare(o2.getValue().size(), o1.getValue().size());
        });
        // workerList.forEach(System.out::println);

        // Create a LinkedHashMap.
        Map sortedMap = new LinkedHashMap<>();

        // Iterate over the ArrayList and insert the key-value pairs into LinkedHashMap.
        for (Map.Entry<String, List<String>> stringListEntry : workerList) {
            sortedMap.put(stringListEntry.getKey(), stringListEntry.getValue());
        }
        sortedMap.entrySet().forEach(System.out::println);
//        John=[4568, 5465, 321, 5465]
//        Angela=[7894, 1178, 1654]
//        Leo=[6846, 5555]
//        Jolin=[5465]

    }


}