/* Problem Statement 
Find the duplicate words in String or Array/List of Strings
*/

// Online Java Compiler
import java.util.stream.Collectors;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;


class DuplicateWordsFinderInString {
  
    public static void main(String[] args) {
        String orgnStr =  "Fruits - Mango Apple Mango Pineapple Apple";
        
        /**************************************************
            Java 8 Features
        **************************************************/
        
        List<String> duplStr = Arrays.asList(orgnStr.split(" ")).stream(). 
        collect(Collectors.groupingBy(word -> word, Collectors.counting())).entrySet().stream().
        filter(entry -> entry.getValue() > 1).map(Map.Entry :: getKey).collect(Collectors.toList());
        
        System.out.println("Duplicate Words : "+ duplStr);

        //ways to initialize list in java - https://www.geeksforgeeks.org/initialize-an-arraylist-in-java/
  	    /* List<String> strList = new ArrayList<String>(){ 
          { add("Mango");
            add("Apple");
            add("Mango");
            add("Pineapple");
            add("Apple");
          }
        };
        */
      
        List<String> strList = new ArrayList<>(List.of("Mango","Apple","Mango","Pineapple","Apple"));
        Set<String> temp = new HashSet<>();
        
        List<String> dupliStr = strList.stream().filter(word -> !temp.add(word)).collect(Collectors.toList());
        
        /*
        List<String> dupliStr = Stream.of("Mango","Apple","Mango","Pineapple","Apple").
        collect(Collectors.groupingBy(word -> word, Collectors.counting())).entrySet().
        stream().filter(entry -> entry.getValue() > 1).map(Map.Entry :: getKey).collect(Collectors.toList());
        */
        
        System.out.println("Duplicate Words : "+ dupliStr);
        
        
        /**************************************************
             Without Java 8 Features
        **************************************************/
        
        //Approach 1
        String orgStr =  "Fruits - Mango Apple Mango Pineapple Apple";
        Set<String> tempSet = new HashSet<>();
        List<String> duplicateStrs = new ArrayList<>();
        
        for(String word : orgStr.split(" "))
        {
           if(!tempSet.add(word))      //if word already exists in list then add() will return false value
            {
              duplicateStrs.add(word);
            }
        }
        
        System.out.println("Duplicate Words : "+ duplicateStrs);
        //JFR - data in tempList - [Apple, Mango, Pineapple, -, Fruits]
        
        
        //Approach 2
        Map<String, Integer> map = new HashMap<String, Integer>();
        System.out.println("Duplicate Words : ");
        for(String word : orgStr.split(" "))
        {
          if(map.containsKey(word))
            System.out.println(word);
          else
            map.put(word, map.get(word) ==null ? 0 : map.get(word)+1);
        }
        
    }
}



/*
Output:

Duplicate Words : [Apple, Mango]
Duplicate Words : [Mango, Apple]
Duplicate Words : [Mango, Apple]
Duplicate Words : 
Mango
Apple
*/
