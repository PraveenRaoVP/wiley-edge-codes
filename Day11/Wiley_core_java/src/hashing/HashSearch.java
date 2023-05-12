package hashing;

import java.util.HashMap;

//In Java, the search operation in a hash-based data structure, such as a HashMap or HashSet, involves using the hash code of the key to locate the corresponding entry or element.
//
//Let's take the example of a HashMap to understand how the search operation works:

public class HashSearch {
  public static void main(String[] args) {
      HashMap<String, Integer> hashMap = new HashMap<>();

      // Adding key-value pairs to the HashMap
      hashMap.put("Jahnavi", 19);
      hashMap.put("Venkat", 32);
      hashMap.put("Sachin", 21);
      hashMap.put("Steve", 28);

      // Searching for a key
      String key = "Steve";
      if (hashMap.containsKey(key)) {
          int value = hashMap.get(key);
          System.out.println("Value for key '" + key + "' found: " + value);
      } else {
          System.out.println("Key '" + key + "' not found.");
      }
  }
}

//In this example, we create a HashMap and add key-value pairs to it. The keys are of type String, and the values are of type Integer. We then demonstrate the search operation by searching for a specific key, "Bob", in the HashMap.
//
//To perform the search, the containsKey() method is used to check if the HashMap contains the specified key. If the key is found, the get() method is used to retrieve the corresponding value associated with the key.
//
//The search operation in a HashMap relies on the hash code of the key. When an element is inserted into the HashMap, the key's hash code is computed using the hashCode() method of the key object. This hash code determines the index or bucket where the element will be stored internally.
//
//During the search operation, the key's hash code is again computed, and the HashMap uses this hash code to locate the appropriate bucket where the element with the corresponding key might reside. If an element is found in that bucket, its key is compared with the search key to verify the match.
//
//It's important to note that in the case of collisions (when multiple keys have the same hash code), the HashMap uses additional techniques, such as linked lists or balanced trees, to handle multiple entries in the same bucket efficiently.
//
//Overall, the search operation in a hash-based data structure in Java involves computing the hash code of the key and then using that hash code to locate the appropriate bucket or entry where the desired element might be found.