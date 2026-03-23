// You are given an array nums consisting of positive integers.

// We call a subarray of an array complete if the following condition is satisfied:

// The number of distinct elements in the subarray is equal to the number of distinct elements in the whole array.
// Return the number of complete subarrays.

// A subarray is a contiguous non-empty part of an array.

 

// Example 1:

// Input: nums = [1,3,1,2,2]
// Output: 4
// Explanation: The complete subarrays are the following: [1,3,1,2], [1,3,1,2,2], [3,1,2] and [3,1,2,2].
// Example 2:

// Input: nums = [5,5,5,5]
// Output: 10
// Explanation: The array consists only of the integer 5, so any subarray is complete. The number of subarrays that we can choose is 10.


//                                                                                                             SOLUTION
//Approach : first we will identify how much distinct element is present in the array 
// Then we will increase the window size and put that element in a map along with frquency and check when it hit the window size 
// we will take the count of the subarrays as after that j that subarrays will also get included so no need to traverse every time
// Then we will shrink the window my decreasing the frequency of the ith element and once the freq becomes zero we will remove it from the map





  class Solution {
    public int countCompleteSubarrays(int[] a) {
        
        int i=0,j=0;
        int count=0;
        int n = a.length;

        HashMap<Integer, Integer> mp = new HashMap<>();
        HashMap<Integer, Integer> np = new HashMap<>();

        for(int k=0; k<n; k++)
        {
            mp.put(a[k],mp.getOrDefault(a[k],0)+1);
        }

        int window = mp.size();

        while(j<n)
        {
            np.put(a[j],np.getOrDefault(a[j],0)+1);

            while(np.size() == window)
            {
                count += n-j;

                np.put(a[i],np.get(a[i])-1);

                if(np.get(a[i]) == 0)
                {
                    np.remove(a[i]);
                }

                i++;
            }
            j++;
        }

        return count;
    }
}
