// You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

// Return the max sliding window.

 

// Example 1:

// Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
// Output: [3,3,5,5,6,7]
// Explanation: 
// Window position                Max
// ---------------               -----
// [1  3  -1] -3  5  3  6  7       3
//  1 [3  -1  -3] 5  3  6  7       3
//  1  3 [-1  -3  5] 3  6  7       5
//  1  3  -1 [-3  5  3] 6  7       5
//  1  3  -1  -3 [5  3  6] 7       6
//  1  3  -1  -3  5 [3  6  7]      7
// Example 2:

// Input: nums = [1], k = 1
// Output: [1]
 

// Constraints:

// 1 <= nums.length <= 105
// -104 <= nums[i] <= 104
// 1 <= k <= nums.length



//                                                                    SOLUTION
// Approach : we are maintaining a dequeue in which we are keeping the max value at front and smaller at last and removing the smaller element once we hit the window size we return the
// max value from the front and check if the max value is at the starting index or not i.e i if it is in starting we remove that element


class Solution {
    public int[] maxSlidingWindow(int[] a, int k) {
        int n = a.length;

        // int[] res;
        List<Integer> ans = new ArrayList<>();

        int i=0,j=0,maxx=Integer.MIN_VALUE;

        Deque<Integer> dq = new ArrayDeque<Integer>();
        
        while(j<n)
        {
            while(dq.size()> 0 && dq.peekLast() < a[j])
            {
                dq.removeLast();
            }

            dq.addLast(a[j]);

            if(j-i+1 < k)
            {
                j++;
            }
            else if(j-i+1 == k)
            {
                ans.add(dq.peekFirst());
                //maxx = Integer.MIN_VALUE;

                if(dq.peekFirst() == a[i])
                {
                    dq.removeFirst();
                }

                i++;
                j++;
            }
        }
        

        int[] res = ans.stream().mapToInt(p -> p).toArray();

        return res;
    }
}
