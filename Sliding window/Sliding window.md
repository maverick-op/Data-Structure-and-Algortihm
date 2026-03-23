
✅ Keywords

“substring”
“subarray”
“contiguous”
“window”
“range”

✅ Conditions like:

“longest substring…”
“smallest subarray…”
“at most k…”
“exactly k…”
“without repeating characters”

Problem Type	Approach
Count + Exactly	atMost trick
Count + At most	direct sliding window
Count + Any integers	prefix sum
Max/Min	normal sliding window


=>MASTER SHORTCUT: “AT MOST TRICK”

Whenever you see a problem, scan for this pattern:

🚨 1. Trigger Words (BIGGEST SIGNAL)

If problem contains:

“exactly k”
“equal to k”
“count subarrays / substrings”

👉 Your brain should immediately think:

exactly(k) = atMost(k) - atMost(k-1)


When NOT to Use This

❌ If question asks:

longest / shortest
maximum / minimum

👉 Use normal sliding window

❌ If numbers include negatives (sum problems)

👉 Use:

Prefix sum + hashmap
