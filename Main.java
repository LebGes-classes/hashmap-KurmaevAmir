public class Main {
    public static void main(String[] args) {
        CustomHashMap<String, Integer> customHashMap = new CustomHashMap<>();
        customHashMap.put("one", 1);
        customHashMap.put("two", 2);
        customHashMap.put("three", 3);
        System.out.println(customHashMap.get("one"));
        System.out.println(customHashMap.get("two"));
    }
}
