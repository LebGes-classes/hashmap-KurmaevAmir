import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CustomHashMapTest {
    @Test
    void testCustomHashMap() {
        CustomHashMap<String, Integer> customHashMap = new CustomHashMap<>();

        customHashMap.put("one", 1);
        customHashMap.put("two", 2);
        customHashMap.put("three", 3);

        assertEquals(3, customHashMap.size());

        assertEquals(1, customHashMap.get("one"));
        assertEquals(2, customHashMap.get("two"));
        assertEquals(3, customHashMap.get("three"));

        assertTrue(customHashMap.containsKey("two"));
        assertFalse(customHashMap.containsKey("four"));
        assertTrue(customHashMap.containsValue(3));
        assertFalse(customHashMap.containsValue(4));

        customHashMap.remove("two");
        assertNull(customHashMap.get("two"));
        assertEquals(2, customHashMap.size());
    }
}