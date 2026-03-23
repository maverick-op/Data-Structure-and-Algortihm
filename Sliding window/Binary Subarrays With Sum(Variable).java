// Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.

// A subarray is a contiguous part of the array.

 

// Example 1:

// Input: nums = [1,0,1,0,1], goal = 2
// Output: 4
// Explanation: The 4 subarrays are bolded and underlined below:
// [1,0,1,0,1]
// [1,0,1,0,1]
// [1,0,1,0,1]
// [1,0,1,0,1]
// Example 2:

// Input: nums = [0,0,0,0,0], goal = 0
// Output: 15

//                                                                      SOLUTION

//Approach : We are calculating for atmost(k) and atmost(k-1) and to get exact k value we are subrating both the values
//we need the subarrays with exact goal but to calculate every subarray we need to calcualte the atmost values

class Solution {

    public int helper(int[] a, int k)
    {
        if(k<0)
        {
            return 0;
        }
        int n = a.length;
        int i=0,j=0,count=0,sum=0;

        while(j<n)
        {
            sum += a[j];

            while(sum>k)    // remove the element whose sum is greateer than k
            {
                sum -= a[i];
                i++;
            }

            count += (j-i+1); //If the largest window is valid, all smaller ones ending here are also valid, Valid window → count all subarrays ending at right
            j++;
        }

        return count;
    }
    public int numSubarraysWithSum(int[] a, int goal) {
        
        return helper(a,goal)-helper(a,goal-1);    // give the exact subarray with sum==goal
    }

}
