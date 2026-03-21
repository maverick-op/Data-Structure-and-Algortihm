// Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

 

// Example 1:

// Input: s = "cbaebabacd", p = "abc"
// Output: [0,6]
// Explanation:
// The substring with start index = 0 is "cba", which is an anagram of "abc".
// The substring with start index = 6 is "bac", which is an anagram of "abc".
// Example 2:

// Input: s = "abab", p = "ab"
// Output: [0,1,2]
// Explanation:
// The substring with start index = 0 is "ab", which is an anagram of "ab".
// The substring with start index = 1 is "ba", which is an anagram of "ab".
// The substring with start index = 2 is "ab", which is an anagram of "ab".
 

// Constraints:

// 1 <= s.length, p.length <= 3 * 104
// s and p consist of lowercase English letters.


//                                                            SOLUTION
//Approach : We will keep a count of the string for which we need to check the anagrams and we will move block by block and will decrease the count of the word and once the overall count becomes zero
//we will add the first block index to answer and then we will add the element back to map and will increase the count



  class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> ans = new ArrayList<>();

        int n = s.length();
        int m = p.length();

        int i=0,j=0;

        HashMap<Character, Integer> mp = new HashMap<>();

        for(int k=0; k<m; k++)
        {
            mp.put(p.charAt(k),mp.getOrDefault(p.charAt(k),0)+1);
        }

        int count = mp.size();

        while(j<n)
        {
            if(mp.containsKey(s.charAt(j)))
            {
                mp.put(s.charAt(j), mp.get(s.charAt(j))-1);
                if(mp.get(s.charAt(j)) ==0 )
                {
                    count--;
                }
            }

            if(j-i+1 < m)
            {
                j++;
            }
            else if(j-i+1 == m)
            {
                if(count == 0)
                {
                    ans.add(i);
                }

                if(mp.containsKey(s.charAt(i)))
                {
                    mp.put(s.charAt(i), mp.getOrDefault(s.charAt(i),0)+1);
                    if(mp.get(s.charAt(i)) == 1)
                    {
                        count++;
                    }
                }
                i++;
                j++;
            }
        }

        return ans;
    }
}
