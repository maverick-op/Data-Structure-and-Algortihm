// Given a binary array nums, you should delete one element from it.

// Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.

 

// Example 1:

// Input: nums = [1,1,0,1]
// Output: 3
// Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
// Example 2:

// Input: nums = [0,1,1,1,0,1,1,0,1]
// Output: 5
// Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].
// Example 3:

// Input: nums = [1,1,1]
// Output: 2
// Explanation: You must delete one element.

//                                                                                                            SOLUTION

//Approach : we will maintain a count of zero once the count becomes greater than 0 we will decrease the count by strating from the ith index
//and will shift the ith index ans will be stored with max element here we are taking j-i because we need to delete one element.




class Solution {
    public int longestSubarray(int[] a) {
        
        int n = a.length;

        int i=0,j=0,count=0;
        int maxx = Integer.MIN_VALUE;

        while(j<n)
        {
            if(a[j]==0)
            {
                count++;
            }

            while(count>1)   //count of zero is greater than 1 keep removing it from the window once it become less than 1
            {
                if(a[i]==0){
                count--;
                }
                i++;
            }
            maxx = Math.max(maxx,j-i);  // it will store the total element present - deleted element.
            j++;
        }


        return maxx;
    }
}
