// You are given an array of integers nums of length n and a positive integer k.

// The power of an array is defined as:

// Its maximum element if all of its elements are consecutive and sorted in ascending order.
// -1 otherwise.
// You need to find the power of all subarrays of nums of size k.

// Return an integer array results of size n - k + 1, where results[i] is the power of nums[i..(i + k - 1)].

 

// Example 1:

// Input: nums = [1,2,3,4,3,2,5], k = 3

// Output: [3,4,-1,-1,-1]

// Explanation:

// There are 5 subarrays of nums of size 3:

// [1, 2, 3] with the maximum element 3.
// [2, 3, 4] with the maximum element 4.
// [3, 4, 3] whose elements are not consecutive.
// [4, 3, 2] whose elements are not sorted.
// [3, 2, 5] whose elements are not consecutive.
// Example 2:

// Input: nums = [2,2,2,2,2], k = 4

// Output: [-1,-1]

// Example 3:

// Input: nums = [3,2,3,2,3,2], k = 2

// Output: [-1,3,-1,3,-1]


//                                                                             SOLUTION




class Solution {
    public int[] resultsArray(int[] a, int k) {
        
        int n = a.length;

        int i=0,j=0;

        List<Integer> list = new ArrayList<>();
        int diff = 0;
        int maxx = a[0];
        int count = 1;

        while(j<n)
        {
            if(j>0 && a[j] == a[j-1]+1)  //check if they are consecutive or not 
            {
                count++;
            }
            else
            {
                count = 1;
            }

            if(j-i+1 < k)
            {
                j++;
            }
            else if(j-i+1 == k)       //window size hit
            {
                if(count>=k)
                {
                    list.add(a[j]);
                }
                else
                {
                    list.add(-1);
                }

                i++;
                j++;
            }
            
        }

        return list.stream()
                   .mapToInt(Integer::intValue)                  //used stream to return list as an array
                   .toArray();
    }
}
