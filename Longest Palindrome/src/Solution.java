import java.util.HashMap;
import java.util.Iterator;

public class Solution {
	/**
     * @param s: a string which consists of lowercase or uppercase letters
     * @return: the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s) {
        if(s == null) {
        	System.out.println("0");
        	return 0;
        }
        int result = 1;
        HashMap<String, Integer> hash = new HashMap <String, Integer>();
        for (int i=1; i<s.length(); i++) {
        	String pre = s.substring(0,i);
        	String cursor = String.valueOf(s.charAt(i));
        	if (pre.contains(cursor)) {
        		if (hash.get(cursor) != null) {
        			int value = hash.get(cursor);
        			hash.put(cursor, value+1);
        		}else {
        			hash.put(cursor,2);
        		}
        	}
        }
        for(String name: hash.keySet()) {
        	String key = name.toString();
        	String value = hash.get(name).toString();
        	System.out.println(key + " " + value);
        }
        
        Iterator<String> iter = hash.keySet().iterator();
        while (iter.hasNext()) {
        	String key = iter.next();
        	int value = hash.get(key);
        	if (value > 1 && value % 2 == 0){
        		result += value;
        	}else {
        		result += value -1 ;
        		
        	}
        }
        if (result == (s.length()+1)) {
        	result --;
        }
        System.out.println(result);
        return result;
    }
}

    
