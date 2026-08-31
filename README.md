# DSA Revision Sheet — Java

> Personal cheat sheet built from this repo (**1219 Java files** across LeetCode, GeeksforGeeks, Codeforces, Coding Ninjas, InterviewBit, cf_sheets).
> Every class, method and template listed here is something that actually appears in my solutions — plus the gaps worth knowing for a campus drive.

---

## Table of Contents

| # | Section |
|---|---------|
| 1 | [Repo Map](#1-repo-map) |
| 2 | [Import & Boilerplate Templates](#2-import--boilerplate-templates) |
| 3 | [Arrays (primitive)](#3-arrays-primitive) |
| 4 | [`Arrays` utility class](#4-arrays-utility-class) |
| 5 | [`String`](#5-string) |
| 6 | [`StringBuilder`](#6-stringbuilder) |
| 7 | [`Character`](#7-character) |
| 8 | [Wrappers: `Integer` / `Long` / `Double`](#8-wrappers-integer--long--double) |
| 9 | [`Math`](#9-math) |
| 10 | [`List` / `ArrayList` / `LinkedList`](#10-list--arraylist--linkedlist) |
| 11 | [`Map`: HashMap / TreeMap / LinkedHashMap](#11-map-hashmap--treemap--linkedhashmap) |
| 12 | [`Set`: HashSet / TreeSet / LinkedHashSet](#12-set-hashset--treeset--linkedhashset) |
| 13 | [`Stack` & `Deque`](#13-stack--deque) |
| 14 | [`Queue` / `ArrayDeque`](#14-queue--arraydeque) |
| 15 | [`PriorityQueue` (Heap)](#15-priorityqueue-heap) |
| 16 | [`Collections` utility class](#16-collections-utility-class) |
| 17 | [Comparators & Sorting](#17-comparators--sorting) |
| 18 | [Custom Classes I Write](#18-custom-classes-i-write) |
| 19 | [Trie](#19-trie) |
| 20 | [Disjoint Set Union (DSU)](#20-disjoint-set-union-dsu) |
| 21 | [Segment Tree & Lazy Propagation](#21-segment-tree--lazy-propagation) |
| 22 | [Binary Search Patterns](#22-binary-search-patterns) |
| 23 | [Two Pointers & Sliding Window](#23-two-pointers--sliding-window) |
| 24 | [Monotonic Stack](#24-monotonic-stack) |
| 25 | [Linked List Patterns](#25-linked-list-patterns) |
| 26 | [Binary Trees & BST](#26-binary-trees--bst) |
| 27 | [Graphs](#27-graphs) |
| 28 | [Dynamic Programming](#28-dynamic-programming) |
| 29 | [Recursion & Backtracking](#29-recursion--backtracking) |
| 30 | [Bit Manipulation](#30-bit-manipulation) |
| 31 | [Math & Number Theory](#31-math--number-theory) |
| 32 | [String Algorithms](#32-string-algorithms) |
| 33 | [Greedy](#33-greedy) |
| 34 | [Design Problems](#34-design-problems) |
| 35 | [Complexity Cheat Table](#35-complexity-cheat-table) |
| 36 | [Gotchas That Cost Me Submissions](#36-gotchas-that-cost-me-submissions) |
| 37 | [Exam-Day Checklist](#37-exam-day-checklist) |

---

## 1. Repo Map

```
coding_platform/
├── Leetcode/           835 files  ← 759 in root + Contest467..513, BiContest176..188, Quest/
├── Geeksforgeeks/      236 files  ← topic-wise folders (see below)
├── cf_sheets/          119 files  ← sheet1..sheet6 (A.java, B.java ... per sheet)
├── Coding_Ninjas/       15 files
├── InterviewBit/         5 files  ← Two_pointers
├── CodeForces/           4 files  ← Round 1090 Div.4
└── Learning/             4 files  ← Tries/, Segmented_Trees/
```

**GfG topic distribution** (what I've drilled most → least):

| Topic | Files | Topic | Files |
|---|---|---|---|
| Trees | 35 | Stack | 10 |
| Arrays | 31 | Heaps | 10 |
| DP | 28 | Binary Search | 10 |
| Graphs | 24 | Bit Manipulation | 7 |
| LinkedList | 20 | Greedy | 6 |
| Recursion | 19 | Tries | 4 |
| Two Pointers | 11 | Segment Trees | 3 |
| Hashing | 11 | Queues / Backtracking | 3 each |

**Weakest coverage → revise these first:** Strings (1 file), Segment Trees (3), Backtracking (3), Queues (3), Greedy (6), Tries (4).

---

## 2. Import & Boilerplate Templates

### The one import that covers everything
```java
import java.util.*;      // Collections, Arrays, Scanner (Math is java.lang — no import)
import java.io.*;        // BufferedReader, PrintWriter
import java.math.BigInteger;
```

### LeetCode / GfG template (what I use most)
```java
class Solution {
    public int solve(int[] nums) {
        // no main, no IO — just return
    }
}
```

### Codeforces template — Scanner (simple, slower)
```java
import java.util.Scanner;
public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            System.out.println(solve(n, a));
        }
        sc.close();
    }
}
```

### Codeforces template — Fast IO (use when n ≥ 1e5)
```java
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());
            sb.append(solve(n, a)).append('\n');
        }
        System.out.print(sb);          // ONE print at the end — never println in a loop
    }
}
```

### Scanner methods I use
| Method | Reads |
|---|---|
| `sc.nextInt()` | int |
| `sc.nextLong()` | long |
| `sc.nextDouble()` / `nextFloat()` | double / float |
| `sc.next()` | one token (word) |
| `sc.nextLine()` | rest of line **incl. leftover `\n`** |
| `sc.nextBigInteger()` | BigInteger |
| `sc.hasNext()` | more input? |
| `sc.close()` | release |

> ⚠️ **Classic bug:** `nextInt()` then `nextLine()` returns `""`. Call an extra `sc.nextLine()` to eat the newline.

---

## 3. Arrays (primitive)

```java
int[] a = new int[n];                 // default 0
int[] a = {1, 2, 3};
int[][] g = new int[n][m];            // default 0
int[][] jag = new int[n][];           // rows allocated later
boolean[] vis = new boolean[n];       // default false
char[] c = s.toCharArray();
long[] dp = new long[n + 1];

a.length          // field, NO parentheses  (String uses s.length() WITH parens)
g.length          // rows
g[0].length       // cols
```

### Frequency array — my go-to for lowercase strings
```java
int[] freq = new int[26];
for (char ch : s.toCharArray()) freq[ch - 'a']++;
// for all ASCII: new int[128] or new int[256]
```

### 2D fill (`Arrays.fill` only fills 1D)
```java
int[][] dp = new int[n][m];
for (int[] row : dp) Arrays.fill(row, -1);   // memo init
```

---

## 4. `Arrays` utility class

| Method | Use |
|---|---|
| `Arrays.sort(a)` | dual-pivot quicksort for primitives — O(n log n) avg, worst O(n²) |
| `Arrays.sort(a, from, to)` | sort subrange `[from, to)` |
| `Arrays.sort(arr, (x,y) -> x[0]-y[0])` | 2D `int[][]` sort by column — needs object array |
| `Arrays.fill(a, v)` | fill whole array |
| `Arrays.fill(a, from, to, v)` | fill range |
| `Arrays.toString(a)` | `[1, 2, 3]` — debugging |
| `Arrays.deepToString(g)` | 2D debugging |
| `Arrays.copyOf(a, newLen)` | resize/clone |
| `Arrays.copyOfRange(a, from, to)` | subarray `[from, to)` |
| `Arrays.equals(a, b)` | element-wise compare |
| `Arrays.binarySearch(a, key)` | **sorted only**; returns `-(insertionPoint)-1` if absent |
| `Arrays.asList(1,2,3)` | fixed-size List view |
| `Arrays.stream(a).sum()/max()/min()` | quick aggregates |
| `System.arraycopy(src,sp,dst,dp,len)` | fastest block copy |
| `a.clone()` | shallow copy of 1D |

> ⚠️ **Anti-hack:** on Codeforces, `Arrays.sort(int[])` can be forced to O(n²). Fix: box it —
> `Integer[] b = ...; Arrays.sort(b);` or shuffle before sorting.

---

## 5. `String`

Immutable. Every "modification" allocates a new String.

| Method | Notes |
|---|---|
| `s.length()` | with parens |
| `s.charAt(i)` | **495 uses in my repo** — the workhorse |
| `s.substring(i)` / `s.substring(i, j)` | `[i, j)`, O(n) |
| `s.indexOf(x)` / `lastIndexOf(x)` | -1 if absent |
| `s.contains(x)` | boolean |
| `s.equals(t)` | **always this, never `==`** |
| `s.equalsIgnoreCase(t)` | |
| `s.compareTo(t)` | <0, 0, >0 — lexicographic |
| `s.toCharArray()` | for in-place char work |
| `s.split(" ")` / `s.split("")` | regex! escape `\\.` `\\|` `\\+` |
| `s.trim()` / `s.strip()` | |
| `s.toLowerCase()` / `toUpperCase()` | |
| `s.replace(a, b)` / `replaceAll(regex, b)` | |
| `s.startsWith(p)` / `endsWith(p)` | |
| `s.isEmpty()` / `s.isBlank()` | |
| `s.repeat(k)` | Java 11+ |
| `s.chars()` | IntStream of chars |
| `String.valueOf(x)` | any type → String |
| `String.join(",", list)` | |
| `String.format("%d %.2f", a, b)` | |

### Building strings
```java
// ❌ O(n²) — TLE on big inputs
String res = ""; for (...) res += ch;

// ✅ O(n)
StringBuilder sb = new StringBuilder(); for (...) sb.append(ch); String res = sb.toString();
```

### Sort a string
```java
char[] c = s.toCharArray();
Arrays.sort(c);
String sorted = new String(c);        // anagram key
```

---

## 6. `StringBuilder`

| Method | Notes |
|---|---|
| `sb.append(x)` | any type; chainable |
| `sb.toString()` | final string |
| `sb.length()` | |
| `sb.charAt(i)` / `sb.setCharAt(i, ch)` | O(1) mutation |
| `sb.insert(i, x)` | O(n) |
| `sb.deleteCharAt(i)` | **backtracking undo** |
| `sb.delete(from, to)` | |
| `sb.reverse()` | in-place |
| `sb.setLength(k)` | truncate — cheap backtracking undo |
| `sb.indexOf(x)` | |

### Backtracking with StringBuilder (avoids string copies)
```java
sb.append(ch);
backtrack(...);
sb.deleteCharAt(sb.length() - 1);      // undo
```

---

## 7. `Character`

| Method | Returns |
|---|---|
| `Character.isDigit(c)` | boolean |
| `Character.isLetter(c)` | |
| `Character.isLetterOrDigit(c)` | alphanumeric check (palindrome problems) |
| `Character.isUpperCase(c)` / `isLowerCase(c)` | |
| `Character.isAlphabetic(c)` / `isWhitespace(c)` | |
| `Character.toUpperCase(c)` / `toLowerCase(c)` | char |
| `Character.getNumericValue(c)` | `'7'` → `7` |
| `Character.toString(c)` | |

```java
int d = c - '0';        // char digit → int  (faster than getNumericValue)
char c = (char)(d + '0');
int idx = c - 'a';      // 0..25
```

---

## 8. Wrappers: `Integer` / `Long` / `Double`

| Method | Notes |
|---|---|
| `Integer.parseInt(s)` | → int, throws on bad input |
| `Integer.parseInt(s, radix)` | binary: `Integer.parseInt("1011", 2)` |
| `Integer.valueOf(x)` | → Integer object (caches -128..127) |
| `Integer.toString(x)` / `toString(x, radix)` | |
| `Integer.toBinaryString(x)` | |
| `Integer.toHexString(x)` / `toOctalString(x)` | |
| `Integer.MAX_VALUE` = 2_147_483_647 | ~2.1e9 |
| `Integer.MIN_VALUE` = -2_147_483_648 | |
| `Integer.bitCount(x)` | popcount |
| `Integer.highestOneBit(x)` / `lowestOneBit(x)` | |
| `Integer.numberOfLeadingZeros(x)` / `numberOfTrailingZeros(x)` | |
| `Integer.reverse(x)` | reverse bits |
| `Integer.compare(a, b)` | **safe** comparator (no overflow) |
| `Long.MAX_VALUE` ≈ 9.2e18 | |
| `Long.compare(a, b)`, `Long.parseLong(s)`, `Long.bitCount(x)` | |
| `Double.compare(a, b)`, `Double.parseDouble(s)` | |

> ⚠️ `Integer a = 1000, b = 1000; a == b` → **false**. Use `.equals()` or unbox to `int`.
> ⚠️ Comparator `(a,b) -> a - b` **overflows** for large/negative values → use `Integer.compare(a,b)`.

---

## 9. `Math`

| Method | Note |
|---|---|
| `Math.max(a,b)` / `Math.min(a,b)` | **712 uses** — most-called methods in this repo |
| `Math.abs(x)` | ⚠️ `Math.abs(Integer.MIN_VALUE)` is still negative |
| `Math.pow(a,b)` | returns **double** — cast, and use fast-power for modular |
| `Math.sqrt(x)` | double; for exact int sqrt verify `r*r == x` |
| `Math.cbrt(x)` | |
| `Math.ceil(x)` / `Math.floor(x)` / `Math.round(x)` | double in, double out (round → long) |
| `Math.log(x)` (natural) / `Math.log10(x)` | `log2(x) = Math.log(x)/Math.log(2)` |
| `Math.hypot(a,b)` | √(a²+b²) |
| `Math.acos/asin/atan/atan2`, `Math.toDegrees/toRadians` | geometry problems |
| `Math.floorDiv(a,b)` / `Math.floorMod(a,b)` | **correct for negatives**, unlike `/` and `%` |

```java
int ceilDiv = (a + b - 1) / b;              // integer ceiling, a,b > 0
long mid = l + (r - l) / 2;                 // overflow-safe midpoint
int mod = ((x % m) + m) % m;                // non-negative modulo
```

---

## 10. `List` / `ArrayList` / `LinkedList`

```java
List<Integer> list = new ArrayList<>();
List<List<Integer>> adj = new ArrayList<>();
for (int i = 0; i < V; i++) adj.add(new ArrayList<>());   // adjacency list — my standard
List<Integer> ll = new LinkedList<>();                     // when used as Queue/Deque
```

| Method | ArrayList | LinkedList |
|---|---|---|
| `add(e)` | O(1) amort | O(1) |
| `add(i, e)` | O(n) | O(n) |
| `get(i)` | **O(1)** | **O(n)** ← never index a LinkedList in a loop |
| `set(i, e)` | O(1) | O(n) |
| `remove(i)` / `remove(Object)` | O(n) | O(n) |
| `size()`, `isEmpty()`, `clear()` | O(1) | O(1) |
| `contains(e)` | O(n) | O(n) |
| `addAll(c)`, `removeAll(c)`, `retainAll(c)` | | |
| `indexOf(e)`, `lastIndexOf(e)` | O(n) | O(n) |
| `subList(from, to)` | view, `[from,to)` | |
| `toArray(new Integer[0])` | | |
| `sort(cmp)` | | |
| `forEach(x -> ...)` | | |

> ⚠️ `list.remove(2)` removes **index 2**; `list.remove(Integer.valueOf(2))` removes the **value 2**.
> ⚠️ Removing while iterating with a for-each → `ConcurrentModificationException`. Use `Iterator.remove()` or loop backwards.

### List ↔ array
```java
int[] arr = list.stream().mapToInt(Integer::intValue).toArray();
List<Integer> l = Arrays.stream(arr).boxed().collect(Collectors.toList());
List<int[]> res = ...; int[][] out = res.toArray(new int[0][]);
```

---

## 11. `Map`: HashMap / TreeMap / LinkedHashMap

```java
Map<Integer, Integer> freq = new HashMap<>();          // O(1) avg, unordered
Map<Integer, List<Integer>> graph = new HashMap<>();
TreeMap<Integer, Integer> tm = new TreeMap<>();        // O(log n), sorted by key
LinkedHashMap<Integer,Integer> lru = new LinkedHashMap<>(); // insertion order
```

| Method | Note |
|---|---|
| `put(k, v)` | returns old value or null |
| `get(k)` | **null if absent** |
| `getOrDefault(k, def)` | **85 uses** — the clean frequency idiom |
| `containsKey(k)` / `containsValue(v)` | value is O(n) |
| `putIfAbsent(k, v)` | |
| `computeIfAbsent(k, x -> new ArrayList<>())` | build adjacency/groups in one line |
| `merge(k, 1, Integer::sum)` | frequency in one line |
| `remove(k)`, `size()`, `isEmpty()`, `clear()` | |
| `keySet()` / `values()` / `entrySet()` | iteration |
| `entry.getKey()` / `entry.getValue()` / `setValue()` | |

### Frequency counting — three equivalent ways
```java
map.put(x, map.getOrDefault(x, 0) + 1);       // what I use
map.merge(x, 1, Integer::sum);                 // shortest
map.compute(x, (k, v) -> v == null ? 1 : v + 1);
```

### Grouping (anagrams etc.)
```java
map.computeIfAbsent(key, k -> new ArrayList<>()).add(val);
```

### Iterating
```java
for (Map.Entry<Integer,Integer> e : map.entrySet()) { e.getKey(); e.getValue(); }
for (int k : map.keySet()) { ... }
```

### TreeMap — extra ordered methods (great for "nearest value" problems)
| Method | Returns |
|---|---|
| `firstKey()` / `lastKey()` | smallest / largest |
| `firstEntry()` / `lastEntry()` | |
| `pollFirstEntry()` / `pollLastEntry()` | remove + return |
| `floorKey(k)` | greatest key ≤ k |
| `ceilingKey(k)` | smallest key ≥ k |
| `lowerKey(k)` | greatest key < k (strict) |
| `higherKey(k)` | smallest key > k (strict) |
| `headMap(k)` / `tailMap(k)` / `subMap(a,b)` | range views |
| `descendingMap()` / `descendingKeySet()` | |

> **TreeMap = multiset.** `tm.merge(x,1,Integer::sum)` to add, and decrement/remove at 0 to delete. This replaces C++'s `multiset` for sliding-window-maximum-style problems.

---

## 12. `Set`: HashSet / TreeSet / LinkedHashSet

```java
Set<Integer> seen = new HashSet<>();      // O(1) avg
Set<Integer> ts  = new TreeSet<>();       // O(log n), sorted
Set<Integer> lhs = new LinkedHashSet<>(); // insertion order
```

| Method | Note |
|---|---|
| `add(e)` | **returns false if already present** — cycle/dup detection in one call |
| `contains(e)` / `remove(e)` | |
| `size()`, `isEmpty()`, `clear()` | |
| `addAll(c)` (union) / `retainAll(c)` (intersection) / `removeAll(c)` (difference) | |

**TreeSet ordered methods:** `first()`, `last()`, `floor(e)`, `ceiling(e)`, `lower(e)`, `higher(e)`, `pollFirst()`, `pollLast()`, `headSet`, `tailSet`, `subSet`, `descendingSet()`.

```java
if (!seen.add(x)) return true;   // duplicate found
```

---

## 13. `Stack` & `Deque`

```java
Stack<Integer> st = new Stack<>();                 // legacy but what I use (185 refs)
Deque<Integer> st = new ArrayDeque<>();            // faster, preferred
```

| `Stack` | `Deque` equivalent | Note |
|---|---|---|
| `push(x)` | `push(x)` / `addFirst(x)` | |
| `pop()` | `pop()` / `pollFirst()` | ⚠️ Stack throws `EmptyStackException` when empty |
| `peek()` | `peek()` / `peekFirst()` | Stack throws; Deque returns null |
| `isEmpty()` / `empty()` | `isEmpty()` | |
| `size()` | `size()` | |
| `search(x)` | — | 1-based from top, O(n) |

> ⚠️ `Stack` extends `Vector` → iterating it goes **bottom-to-top** (opposite of pop order), and it's synchronized (slow). `ArrayDeque` is ~2–3× faster.
> ⚠️ `ArrayDeque` does **not** allow `null`.

---

## 14. `Queue` / `ArrayDeque`

```java
Queue<Integer> q = new LinkedList<>();       // what I use for BFS (68 refs)
Deque<Integer> dq = new ArrayDeque<>();      // faster, also a deque
```

| Operation | Throws on failure | Returns null/false |
|---|---|---|
| insert | `add(e)` | `offer(e)` |
| remove | `remove()` | `poll()` |
| examine | `element()` | `peek()` |

**Deque both-ends:** `addFirst/addLast`, `offerFirst/offerLast`, `pollFirst/pollLast`, `peekFirst/peekLast`, `removeFirst/removeLast`, `getFirst/getLast`, `descendingIterator()`.

### BFS level-order template
```java
Queue<Integer> q = new LinkedList<>();
q.offer(src);
boolean[] vis = new boolean[n]; vis[src] = true;
int level = 0;
while (!q.isEmpty()) {
    int sz = q.size();                     // freeze size = one level
    for (int i = 0; i < sz; i++) {
        int node = q.poll();
        for (int nei : adj.get(node)) {
            if (!vis[nei]) { vis[nei] = true; q.offer(nei); }
        }
    }
    level++;
}
```

---

## 15. `PriorityQueue` (Heap)

```java
PriorityQueue<Integer> minHeap = new PriorityQueue<>();                        // min by default
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);          // by first element
PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);          // max by first
PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);       // Dijkstra
PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.cost, b.cost)); // long-safe
PriorityQueue<double[]> pq = new PriorityQueue<>((a,b) -> Double.compare(b[0], a[0]));
PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> a.compareTo(b));
```

| Method | Cost |
|---|---|
| `offer(e)` / `add(e)` | O(log n) |
| `poll()` | O(log n) — removes min/top |
| `peek()` | O(1) |
| `remove(Object)` | **O(n)** — avoid inside loops |
| `size()`, `isEmpty()`, `clear()` | O(1) |
| `new PriorityQueue<>(collection)` | O(n) heapify — faster than n×offer |

> ⚠️ Iterating a PriorityQueue is **not** in sorted order. Only `poll()` order is sorted.
> ⚠️ `(a,b) -> a - b` overflows on large ints → prefer `Integer.compare`.

### Top-K pattern
```java
// k largest → keep a MIN-heap of size k
PriorityQueue<Integer> pq = new PriorityQueue<>();
for (int x : nums) { pq.offer(x); if (pq.size() > k) pq.poll(); }
// pq.peek() = kth largest
```

### Two-heap median (`MedianFinder`)
```java
PriorityQueue<Integer> lo = new PriorityQueue<>(Collections.reverseOrder()); // max-heap, small half
PriorityQueue<Integer> hi = new PriorityQueue<>();                           // min-heap, big half

void addNum(int x) {
    lo.offer(x);
    hi.offer(lo.poll());
    if (hi.size() > lo.size()) lo.offer(hi.poll());
}
double findMedian() { return lo.size() > hi.size() ? lo.peek() : (lo.peek() + hi.peek()) / 2.0; }
```

---

## 16. `Collections` utility class

| Method | Note |
|---|---|
| `Collections.sort(list)` | natural order |
| `Collections.sort(list, cmp)` | custom |
| `Collections.reverse(list)` | in-place |
| `Collections.reverseOrder()` | **descending comparator** — my max-heap idiom |
| `Collections.max(list)` / `min(list)` | optional comparator |
| `Collections.swap(list, i, j)` | |
| `Collections.frequency(list, x)` | O(n) |
| `Collections.shuffle(list)` | anti-quicksort-hack |
| `Collections.nCopies(n, v)` | |
| `Collections.emptyList()` / `singletonList(x)` | |
| `Collections.unmodifiableList(l)` | |
| `Collections.binarySearch(list, key)` | sorted list |
| `Collections.fill(list, v)` | |
| `Collections.addAll(list, a, b, c)` | |

---

## 17. Comparators & Sorting

```java
// 1D primitives
Arrays.sort(arr);

// descending primitives — NO direct way; box or sort-then-reverse
Integer[] b = new Integer[n];
Arrays.sort(b, Collections.reverseOrder());

// 2D by column 0 asc
Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

// 2D by col 1 asc (activity selection / non-overlapping intervals)
Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

// edges by weight (Kruskal)
Arrays.sort(edges, (a, b) -> a[2] - b[2]);

// multi-key: col0 asc, tie-break col1 desc
Arrays.sort(arr, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);

// Comparator chaining
list.sort(Comparator.comparingInt((int[] a) -> a[0])
                    .thenComparing(a -> a[1], Comparator.reverseOrder()));

// Comparable on a custom class
class Pair implements Comparable<Pair> {
    int dist, node;
    public int compareTo(Pair o) { return Integer.compare(this.dist, o.dist); }
}
```

**Comparator contract:** return **negative** if `a` comes first, **0** if equal, **positive** if `b` comes first.

---

## 18. Custom Classes I Write

### `Pair` / `Pairs` (used 128× — no built-in Pair in core Java)
```java
class Pair {
    int first, second;
    Pair(int first, int second) { this.first = first; this.second = second; }
}
// graph flavour
class Pairs { int dist, node; Pairs(int dist, int node){ this.dist=dist; this.node=node; } }
// cycle-detection flavour
class Pair { int curr, parent; Pair(int c, int p){ curr=c; parent=p; } }
```
> `new int[]{a, b}` is often faster and avoids a class — but a named Pair reads better in Dijkstra.
> `Map.Entry<K,V>` via `new AbstractMap.SimpleEntry<>(k, v)` is the built-in alternative.

### `ListNode` (LeetCode linked list)
```java
class ListNode {
    int val; ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
```

### `TreeNode` (LeetCode / GfG binary tree)
```java
class TreeNode {
    int val; TreeNode left, right;
    TreeNode(int x) { val = x; }
}
```

### `Node` for doubly-linked list (LRU)
```java
class Node { int key, value; Node left, right; Node(int k, int v){ key=k; value=v; } }
```

---

## 19. Trie

My implementation (`Learning/Tries/Tries.java`) — the node encapsulates its own link logic:

```java
class Node {
    Node[] links = new Node[26];
    boolean flag = false;

    boolean containsKey(char ch) { return links[ch - 'a'] != null; }
    Node get(char ch)            { return links[ch - 'a']; }
    void put(char ch, Node node) { links[ch - 'a'] = node; }
    void setEnd()                { flag = true; }
    boolean isEnd()              { return flag; }
}

class Trie {
    private Node root = new Node();

    void insert(String word) {                       // O(len)
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i)))
                node.put(word.charAt(i), new Node());
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }

    boolean search(String word) {                    // exact word
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) return false;
            node = node.get(word.charAt(i));
        }
        return node.isEnd();
    }

    boolean startsWith(String prefix) {              // any word with this prefix
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (!node.containsKey(prefix.charAt(i))) return false;
            node = node.get(prefix.charAt(i));
        }
        return true;
    }
}
```

**Variants to remember:**
- Add `int countPrefix, countEnd` per node → "count words starting with prefix" / erase support.
- **Binary Trie** (`links = new Node[2]`) → **Maximum XOR pair**: insert all numbers bit 31→0, then for each number walk greedily toward the *opposite* bit.

```java
// Max XOR — greedy on binary trie
int maxXor(int num) {
    Node node = root; int max = 0;
    for (int i = 31; i >= 0; i--) {
        int bit = (num >> i) & 1;
        if (node.links[1 - bit] != null) { max |= (1 << i); node = node.links[1 - bit]; }
        else node = node.links[bit];
    }
    return max;
}
```

---

## 20. Disjoint Set Union (DSU)

From `Geeksforgeeks/Graphs/DisjoinSet.java`. **Union by size** is the version to default to.

```java
class DisjointSet {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size   = new ArrayList<>();
    List<Integer> rank   = new ArrayList<>();

    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) { parent.add(i); size.add(1); rank.add(0); }
    }

    public int findParent(int node) {                       // path compression
        if (node == parent.get(node)) return node;
        int ulp = findParent(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionBySize(int u, int v) {
        int a = findParent(u), b = findParent(v);
        if (a == b) return;
        if (size.get(a) < size.get(b)) { parent.set(a, b); size.set(b, size.get(b) + size.get(a)); }
        else                           { parent.set(b, a); size.set(a, size.get(a) + size.get(b)); }
    }

    public void unionByRank(int u, int v) {
        int a = findParent(u), b = findParent(v);
        if (a == b) return;
        if (rank.get(a) < rank.get(b))      parent.set(a, b);
        else if (rank.get(b) < rank.get(a)) parent.set(b, a);
        else { parent.set(b, a); rank.set(a, rank.get(a) + 1); }
    }
}
```

**Complexity:** ~O(α(n)) ≈ O(1) per op with both optimizations.

**Key reminders (from my own comments):**
- In `findParent`, do path compression by pointing the node at its *ultimate* parent.
- In `unionByRank`, attach the smaller-rank tree under the larger-rank tree.
- Rank is only a *height hint* — after compression it isn't the true height, which is fine.

**Uses:** Kruskal MST, connected components, cycle detection in undirected graphs, "number of provinces", "accounts merge", "number of islands II".

### Kruskal MST
```java
Arrays.sort(edges, (a, b) -> a[2] - b[2]);
DisjointSet ds = new DisjointSet(V);
int cost = 0;
for (int[] e : edges)
    if (ds.findParent(e[0]) != ds.findParent(e[1])) { ds.unionBySize(e[0], e[1]); cost += e[2]; }
```

---

## 21. Segment Tree & Lazy Propagation

### Point update + range query (`Learning/Segmented_Trees/segmented_tree.java`)
```java
class SegmentTree {
    int[] tree; int n;

    SegmentTree(int[] arr) { n = arr.length; tree = new int[4 * n]; build(0, 0, n - 1, arr); }

    void build(int node, int l, int r, int[] arr) {
        if (l == r) { tree[node] = arr[l]; return; }
        int mid = (l + r) / 2;
        build(2*node+1, l, mid, arr);
        build(2*node+2, mid+1, r, arr);
        tree[node] = tree[2*node+1] + tree[2*node+2];       // merge (swap for min/max/gcd)
    }

    int query(int node, int l, int r, int ql, int qr) {
        if (qr < l || r < ql) return 0;                     // no overlap  → identity
        if (ql <= l && r <= qr) return tree[node];           // full overlap
        int mid = (l + r) / 2;                              // partial     → recurse both
        return query(2*node+1, l, mid, ql, qr) + query(2*node+2, mid+1, r, ql, qr);
    }

    void update(int node, int l, int r, int idx, int val) {
        if (l == r) { tree[node] = val; return; }
        int mid = (l + r) / 2;
        if (idx <= mid) update(2*node+1, l, mid, idx, val);
        else            update(2*node+2, mid+1, r, idx, val);
        tree[node] = tree[2*node+1] + tree[2*node+2];
    }
}
```
Size `4*n`. Build O(n), query/update O(log n).
**Identity per operation:** sum → `0`, min → `Integer.MAX_VALUE`, max → `Integer.MIN_VALUE`, gcd → `0`.

### Lazy propagation (range update + range query)
> *Key idea from my notes: "do work only when needed" — defer updates until a node is actually visited.*
> Without lazy, a range update is O(n); with lazy it is O(log n).

```java
class SegmentTreeLazy {
    int[] seg, lazy; int n;

    SegmentTreeLazy(int[] arr) { n = arr.length; seg = new int[4*n]; lazy = new int[4*n]; build(0,0,n-1,arr); }

    private void propagate(int idx, int low, int high) {
        if (lazy[idx] != 0) {
            seg[idx] += (high - low + 1) * lazy[idx];       // apply to this node
            if (low != high) {                              // push down to children
                lazy[2*idx+1] += lazy[idx];
                lazy[2*idx+2] += lazy[idx];
            }
            lazy[idx] = 0;
        }
    }

    void update(int idx, int low, int high, int l, int r, int val) {
        propagate(idx, low, high);
        if (high < l || r < low) return;
        if (l <= low && high <= r) { lazy[idx] += val; propagate(idx, low, high); return; }
        int mid = (low + high) / 2;
        update(2*idx+1, low, mid, l, r, val);
        update(2*idx+2, mid+1, high, l, r, val);
        seg[idx] = seg[2*idx+1] + seg[2*idx+2];
    }

    int query(int idx, int low, int high, int l, int r) {
        propagate(idx, low, high);
        if (high < l || r < low) return 0;
        if (l <= low && high <= r) return seg[idx];
        int mid = (low + high) / 2;
        return query(2*idx+1, low, mid, l, r) + query(2*idx+2, mid+1, high, l, r);
    }
}
```
Related: LeetCode 307 (Range Sum Query – Mutable).

### Fenwick / BIT (shorter alternative for prefix sums)
```java
int[] bit; int n;
void update(int i, int delta) { for (i++; i <= n; i += i & -i) bit[i] += delta; }
int  query(int i)             { int s = 0; for (i++; i > 0; i -= i & -i) s += bit[i]; return s; }
int  rangeSum(int l, int r)   { return query(r) - query(l - 1); }
```

---

## 22. Binary Search Patterns

### Classic (exact match)
```java
int lo = 0, hi = n - 1;
while (lo <= hi) {
    int mid = lo + (hi - lo) / 2;        // overflow-safe
    if (a[mid] == target) return mid;
    else if (a[mid] < target) lo = mid + 1;
    else hi = mid - 1;
}
return -1;
```

### Lower bound (first index with `a[i] >= target`)
```java
int lo = 0, hi = n;                      // hi = n, not n-1
while (lo < hi) {
    int mid = lo + (hi - lo) / 2;
    if (a[mid] < target) lo = mid + 1; else hi = mid;
}
return lo;                               // n if none
```

### Upper bound (first index with `a[i] > target`)
```java
while (lo < hi) { int mid = lo+(hi-lo)/2; if (a[mid] <= target) lo = mid+1; else hi = mid; }
```
`count(target) = upperBound - lowerBound`

### Binary search on the ANSWER (the campus-drive favourite)
```java
// "minimum capacity/speed/days such that isFeasible(x) is true"
int lo = minPossible, hi = maxPossible, ans = hi;
while (lo <= hi) {
    int mid = lo + (hi - lo) / 2;
    if (isFeasible(mid)) { ans = mid; hi = mid - 1; }   // shrink toward minimum
    else                 { lo = mid + 1; }
}
return ans;
```
Problems: Koko Eating Bananas, Ship Packages in D Days, Split Array Largest Sum, Aggressive Cows, Allocate Books, Minimize Max Distance.

### Rotated sorted array
```java
while (lo <= hi) {
    int mid = lo + (hi - lo) / 2;
    if (a[mid] == target) return mid;
    if (a[lo] <= a[mid]) {                        // left half sorted
        if (a[lo] <= target && target < a[mid]) hi = mid - 1; else lo = mid + 1;
    } else {                                      // right half sorted
        if (a[mid] < target && target <= a[hi]) lo = mid + 1; else hi = mid - 1;
    }
}
```

---

## 23. Two Pointers & Sliding Window

### Opposite ends (sorted array — Two Sum II, container with most water)
```java
int l = 0, r = n - 1;
while (l < r) {
    int sum = a[l] + a[r];
    if (sum == target) return new int[]{l, r};
    else if (sum < target) l++;
    else r--;
}
```

### Fixed-size window
```java
long sum = 0, best = Long.MIN_VALUE;
for (int i = 0; i < n; i++) {
    sum += a[i];
    if (i >= k) sum -= a[i - k];
    if (i >= k - 1) best = Math.max(best, sum);
}
```

### Variable-size window (longest valid)
```java
int l = 0, best = 0;
Map<Character,Integer> win = new HashMap<>();
for (int r = 0; r < n; r++) {
    win.merge(s.charAt(r), 1, Integer::sum);
    while (/* window invalid */ win.size() > k) {
        char c = s.charAt(l);
        win.merge(c, -1, Integer::sum);
        if (win.get(c) == 0) win.remove(c);
        l++;
    }
    best = Math.max(best, r - l + 1);
}
```

### Shortest valid window (minimum window substring)
```java
int l = 0, best = Integer.MAX_VALUE;
for (int r = 0; r < n; r++) {
    add(a[r]);
    while (isValid()) { best = Math.min(best, r - l + 1); remove(a[l++]); }
}
```

### Sliding window maximum (monotonic deque, O(n))
```java
Deque<Integer> dq = new ArrayDeque<>();          // stores INDICES, values decreasing
for (int i = 0; i < n; i++) {
    while (!dq.isEmpty() && dq.peekFirst() <= i - k) dq.pollFirst();       // out of window
    while (!dq.isEmpty() && a[dq.peekLast()] <= a[i]) dq.pollLast();       // smaller → useless
    dq.offerLast(i);
    if (i >= k - 1) res[i - k + 1] = a[dq.peekFirst()];
}
```

### Fast & slow pointers (cycle / middle)
```java
ListNode slow = head, fast = head;
while (fast != null && fast.next != null) {
    slow = slow.next; fast = fast.next.next;
    if (slow == fast) { /* cycle */ }
}
// slow = middle when the loop ends
```

---

## 24. Monotonic Stack

Answers "next/previous greater/smaller element" in O(n).

```java
// Next Greater Element to the RIGHT
int[] nge = new int[n];
Arrays.fill(nge, -1);
Stack<Integer> st = new Stack<>();                  // indices
for (int i = 0; i < n; i++) {
    while (!st.isEmpty() && a[st.peek()] < a[i]) nge[st.pop()] = a[i];
    st.push(i);
}
```

| Want | Iterate | Pop while |
|---|---|---|
| Next greater (right) | left → right | `a[st.peek()] < a[i]` |
| Next smaller (right) | left → right | `a[st.peek()] > a[i]` |
| Prev greater (left) | left → right, answer before push | `a[st.peek()] <= a[i]` |
| Prev smaller (left) | left → right, answer before push | `a[st.peek()] >= a[i]` |

**Uses:** Largest Rectangle in Histogram, Maximal Rectangle, Trapping Rain Water, Daily Temperatures, Stock Span, Sum of Subarray Minimums, Asteroid Collision, Remove K Digits.

### Largest rectangle in histogram
```java
Stack<Integer> st = new Stack<>();
int best = 0;
for (int i = 0; i <= n; i++) {
    int cur = (i == n) ? 0 : h[i];
    while (!st.isEmpty() && h[st.peek()] >= cur) {
        int height = h[st.pop()];
        int width = st.isEmpty() ? i : i - st.peek() - 1;
        best = Math.max(best, height * width);
    }
    st.push(i);
}
```

---

## 25. Linked List Patterns

### Reverse (iterative — memorize this)
```java
ListNode prev = null, cur = head;
while (cur != null) { ListNode nxt = cur.next; cur.next = prev; prev = cur; cur = nxt; }
return prev;
```

### Dummy head (simplifies deletions/merges)
```java
ListNode dummy = new ListNode(0, head), prev = dummy;
// ... prev.next = prev.next.next;  to delete
return dummy.next;
```

### Middle node
```java
ListNode slow = head, fast = head;
while (fast != null && fast.next != null) { slow = slow.next; fast = fast.next.next; }
```

### Cycle start (Floyd)
```java
// after slow == fast:
slow = head;
while (slow != fast) { slow = slow.next; fast = fast.next; }
return slow;                         // cycle entry
```

### Merge two sorted lists
```java
ListNode dummy = new ListNode(0), t = dummy;
while (a != null && b != null) {
    if (a.val <= b.val) { t.next = a; a = a.next; } else { t.next = b; b = b.next; }
    t = t.next;
}
t.next = (a != null) ? a : b;
return dummy.next;
```

**Other patterns in this repo:** remove Nth from end (two pointers with gap n), reorder list (mid + reverse + merge), add two numbers, flatten multilevel list, copy list with random pointer (HashMap old→new), sort list (merge sort), rotate list, palindrome list.

---

## 26. Binary Trees & BST

### Traversals — recursive
```java
void inorder(TreeNode r, List<Integer> out)  { if (r==null) return; inorder(r.left,out);  out.add(r.val); inorder(r.right,out); }
void preorder(TreeNode r, List<Integer> out) { if (r==null) return; out.add(r.val); preorder(r.left,out); preorder(r.right,out); }
void postorder(TreeNode r, List<Integer> out){ if (r==null) return; postorder(r.left,out); postorder(r.right,out); out.add(r.val); }
```

### Inorder — iterative (asked often)
```java
Stack<TreeNode> st = new Stack<>();
TreeNode cur = root;
while (cur != null || !st.isEmpty()) {
    while (cur != null) { st.push(cur); cur = cur.left; }
    cur = st.pop();
    res.add(cur.val);
    cur = cur.right;
}
```

### Morris inorder — O(1) space
```java
TreeNode cur = root;
while (cur != null) {
    if (cur.left == null) { res.add(cur.val); cur = cur.right; }
    else {
        TreeNode pred = cur.left;
        while (pred.right != null && pred.right != cur) pred = pred.right;
        if (pred.right == null) { pred.right = cur; cur = cur.left; }        // thread
        else { pred.right = null; res.add(cur.val); cur = cur.right; }       // unthread
    }
}
```

### Level order
```java
Queue<TreeNode> q = new LinkedList<>();
if (root != null) q.offer(root);
while (!q.isEmpty()) {
    int sz = q.size();
    List<Integer> level = new ArrayList<>();
    for (int i = 0; i < sz; i++) {
        TreeNode node = q.poll();
        level.add(node.val);
        if (node.left  != null) q.offer(node.left);
        if (node.right != null) q.offer(node.right);
    }
    res.add(level);
}
```

### Height / Diameter (single pass)
```java
int diameter = 0;
int height(TreeNode r) {
    if (r == null) return 0;
    int lh = height(r.left), rh = height(r.right);
    diameter = Math.max(diameter, lh + rh);
    return 1 + Math.max(lh, rh);
}
```

### LCA (binary tree)
```java
TreeNode lca(TreeNode r, TreeNode p, TreeNode q) {
    if (r == null || r == p || r == q) return r;
    TreeNode l = lca(r.left, p, q), ri = lca(r.right, p, q);
    if (l == null) return ri;
    if (ri == null) return l;
    return r;                     // p and q on opposite sides
}
```

### BST facts
- **Inorder of a BST is sorted** — validate with a prev pointer, or find kth smallest by counting.
- Search / insert / delete: O(h) — O(log n) balanced, O(n) skewed.
- LCA in BST: walk down; if both < node go left, both > node go right, else current node.
- Validate BST: pass a `(min, max)` range down, **not** just compare with children.

**Other tree problems here:** vertical/top/bottom/left/right view, zigzag, boundary traversal, path sum, max path sum, serialize/deserialize, construct from inorder+preorder, symmetric, balanced check, nodes at distance K, burn tree, count nodes in complete tree, BST iterator.

---

## 27. Graphs

### Representations
```java
// Adjacency list — the standard in my solutions
List<List<Integer>> adj = new ArrayList<>();
for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
for (int[] e : edges) { adj.get(e[0]).add(e[1]); adj.get(e[1]).add(e[0]); }  // undirected

// weighted
List<List<Pairs>> adj = new ArrayList<>();          // Pairs { dist, node }

// grid as an implicit graph
int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};        // 4-dir
int[] dr8 = {-1,-1,-1,0,0,1,1,1}, dc8 = {-1,0,1,-1,1,-1,0,1};
```

### DFS (213 uses — my most-written algorithm)
```java
void dfs(int node, List<List<Integer>> adj, boolean[] vis) {
    vis[node] = true;
    for (int nei : adj.get(node)) if (!vis[nei]) dfs(nei, adj, vis);
}
```

### Cycle detection — undirected (BFS with parent)
```java
Queue<Pair> q = new LinkedList<>();          // Pair { curr, parent }
q.add(new Pair(src, -1)); vis[src] = true;
while (!q.isEmpty()) {
    Pair p = q.poll();
    for (int nei : adj.get(p.curr)) {
        if (!vis[nei]) { vis[nei] = true; q.add(new Pair(nei, p.curr)); }
        else if (nei != p.parent) return true;         // visited & not parent → cycle
    }
}
```

### Cycle detection — directed (DFS + pathVisited)
```java
boolean dfs(int node, List<List<Integer>> adj, boolean[] vis, boolean[] pathVis) {
    vis[node] = true; pathVis[node] = true;
    for (int nei : adj.get(node)) {
        if (!vis[nei]) { if (dfs(nei, adj, vis, pathVis)) return true; }
        else if (pathVis[nei]) return true;            // back edge in the current path
    }
    pathVis[node] = false;                             // ← the line people forget
    return false;
}
```

### Topological sort — Kahn's (BFS, also detects cycle)
```java
int[] inDegree = new int[V];
for (int u = 0; u < V; u++) for (int v : adj.get(u)) inDegree[v]++;
Queue<Integer> q = new LinkedList<>();
for (int i = 0; i < V; i++) if (inDegree[i] == 0) q.offer(i);
List<Integer> topo = new ArrayList<>();
while (!q.isEmpty()) {
    int u = q.poll(); topo.add(u);
    for (int v : adj.get(u)) if (--inDegree[v] == 0) q.offer(v);
}
if (topo.size() != V) { /* cycle exists */ }
```
**Uses:** Course Schedule I/II, Alien Dictionary, Eventual Safe States.

### Dijkstra — O(E log V), non-negative weights only
```java
class Pairs { int dist, node; Pairs(int d, int n){ dist=d; node=n; } }

int[] dist = new int[V];
Arrays.fill(dist, Integer.MAX_VALUE);
dist[src] = 0;
PriorityQueue<Pairs> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
pq.offer(new Pairs(0, src));
while (!pq.isEmpty()) {
    Pairs p = pq.poll();
    if (p.dist > dist[p.node]) continue;                    // stale entry — skip
    for (Pairs e : adj.get(p.node)) {
        if (p.dist + e.dist < dist[e.node]) {
            dist[e.node] = p.dist + e.dist;
            pq.offer(new Pairs(dist[e.node], e.node));
        }
    }
}
```

### Bellman–Ford — O(V·E), handles negative weights, detects negative cycles
```java
int INF = 100000000;                       // NOT Integer.MAX_VALUE (overflows on +w)
int[] dist = new int[V];
Arrays.fill(dist, INF);
dist[src] = 0;
for (int i = 0; i < V - 1; i++)                        // V-1 relaxation rounds
    for (int[] e : edges) {
        int u = e[0], v = e[1], w = e[2];
        if (dist[u] != INF && dist[u] + w < dist[v]) dist[v] = dist[u] + w;
    }
for (int[] e : edges)                                  // Vth pass → negative cycle
    if (dist[e[0]] != INF && dist[e[0]] + e[2] < dist[e[1]]) return new int[]{-1};
```
> *My note:* Bellman–Ford works with negative weights, detects negative cycles, and handles "at most K stops" constraints — but it is slower. Dijkstra is greedy, O(E log V), non-negative only.

### Floyd–Warshall — all pairs, O(V³)
```java
for (int k = 0; k < V; k++)
  for (int i = 0; i < V; i++)
    for (int j = 0; j < V; j++)
      if (d[i][k] != INF && d[k][j] != INF)
        d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
// d[i][i] < 0 → negative cycle
```

### Prim's MST — O(E log V)
```java
PriorityQueue<Pairs> pq = new PriorityQueue<>((a,b) -> a.dist - b.dist);
boolean[] inMST = new boolean[V];
pq.offer(new Pairs(0, 0));
int cost = 0;
while (!pq.isEmpty()) {
    Pairs p = pq.poll();
    if (inMST[p.node]) continue;
    inMST[p.node] = true; cost += p.dist;
    for (Pairs e : adj.get(p.node)) if (!inMST[e.node]) pq.offer(e);
}
```

### Bipartite check (2-colouring)
```java
int[] color = new int[V];
Arrays.fill(color, -1);
// BFS: color[nei] = 1 - color[node]; if color[nei] == color[node] → not bipartite
```

**Also in this repo:** number of islands, rotten oranges (multi-source BFS), flood fill, surrounded regions, word ladder, shortest path in a binary matrix, number of provinces, 0-1 BFS (deque), Kosaraju SCC, bridges/articulation points (Tarjan).

---

## 28. Dynamic Programming

### The 5 steps
1. Express the state — what do `i`, `j`, `mask` mean?
2. Write the recurrence (choices at each state).
3. Base cases.
4. Memoize (top-down) → then convert to tabulation (bottom-up).
5. Space-optimize (usually keep only the previous row).

### Memoization template (my style — 55 memo files)
```java
int[][] dp;
int solve(int i, int j) {
    if (/* base */) return 0;
    if (dp[i][j] != -1) return dp[i][j];
    int take = 0, skip = 0;   // ... compute
    return dp[i][j] = Math.max(take, skip);
}
// init: dp = new int[n][m]; for (int[] r : dp) Arrays.fill(r, -1);
```

### Tabulation template (50 files)
```java
int[][] dp = new int[n + 1][m + 1];
for (int i = 1; i <= n; i++)
    for (int j = 1; j <= m; j++)
        dp[i][j] = /* recurrence */;
return dp[n][m];
```

### 0/1 Knapsack
```java
for (int i = 1; i <= n; i++)
    for (int w = 0; w <= W; w++) {
        dp[i][w] = dp[i-1][w];                                     // skip
        if (wt[i-1] <= w)
            dp[i][w] = Math.max(dp[i][w], val[i-1] + dp[i-1][w - wt[i-1]]);  // take
    }
```
**Unbounded knapsack:** use `dp[i][w - wt[i-1]]` (same row) instead of `dp[i-1][...]`.
**1D coin change (combinations):** `for (coin) for (a = coin; a <= amt; a++) dp[a] += dp[a - coin];`

### LCS (Longest Common Subsequence)
```java
for (int i = 1; i <= n; i++)
    for (int j = 1; j <= m; j++)
        dp[i][j] = (s.charAt(i-1) == t.charAt(j-1))
                 ? 1 + dp[i-1][j-1]
                 : Math.max(dp[i-1][j], dp[i][j-1]);
```
Derived: LPS = `LCS(s, reverse(s))`, min insertions/deletions = `n + m - 2*LCS`, edit distance, shortest common supersequence, distinct subsequences, wildcard matching.

### LIS — O(n²)
```java
int[] dp = new int[n]; Arrays.fill(dp, 1);
for (int i = 1; i < n; i++)
    for (int j = 0; j < i; j++)
        if (a[j] < a[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
```
### LIS — O(n log n) (patience)
```java
List<Integer> tails = new ArrayList<>();
for (int x : a) {
    int idx = lowerBound(tails, x);
    if (idx == tails.size()) tails.add(x); else tails.set(idx, x);
}
return tails.size();               // NOTE: tails is not the actual LIS sequence
```

### Kadane — max subarray sum
```java
int cur = 0, best = Integer.MIN_VALUE;
for (int x : a) { cur = Math.max(x, cur + x); best = Math.max(best, cur); }
```

### Matrix Chain / Partition DP
```java
for (int len = 2; len <= n; len++)
  for (int i = 0; i + len <= n; i++) {
    int j = i + len - 1;
    dp[i][j] = Integer.MAX_VALUE;
    for (int k = i; k < j; k++)
        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + cost(i,k,j));
  }
```
Problems: MCM, Burst Balloons, Palindrome Partitioning II, Boolean Parenthesization, Min Cost to Cut a Stick.

### DP on Stocks (state machine)
```java
// buy == 1 means "allowed to buy"
int f(int i, int buy, int cap) {
    if (i == n || cap == 0) return 0;
    if (buy == 1) return Math.max(-prices[i] + f(i+1, 0, cap), f(i+1, 1, cap));
    else          return Math.max( prices[i] + f(i+1, 1, cap-1), f(i+1, 0, cap));
}
```

### DP families in this repo
| Family | Examples |
|---|---|
| 1D | Climbing stairs, House Robber I/II, Frog Jump, Min cost climbing |
| 2D grid | Unique Paths I/II, Min Path Sum, Triangle, Falling Path, Cherry Pickup |
| Subsequence | Subset sum, Partition equal subset, Target sum, Count subsets |
| Knapsack | 0/1, unbounded, rod cutting, coin change I/II |
| Strings | LCS, edit distance, wildcard, distinct subsequences |
| Stocks | I–IV, with cooldown, with fee |
| LIS | LIS, printing LIS, largest divisible subset, longest string chain, bitonic |
| Partition/MCM | MCM, burst balloons, palindrome partitioning II |
| Bitmask | TSP, assign tasks, count subsets with mask |
| Digit DP | count numbers with a property ≤ N |
| Tree DP | House robber III, diameter, max path sum |

---

## 29. Recursion & Backtracking

### The template
```java
void backtrack(int idx, List<Integer> path, List<List<Integer>> res) {
    if (/* goal */) { res.add(new ArrayList<>(path)); return; }   // ⚠️ new copy!
    for (int i = idx; i < n; i++) {
        if (!isValid(i)) continue;
        path.add(nums[i]);            // choose
        backtrack(i + 1, path, res);  // explore  (pass i, not i+1, if reuse is allowed)
        path.remove(path.size() - 1); // un-choose
    }
}
```

### Skip duplicates (sorted input)
```java
Arrays.sort(nums);
for (int i = idx; i < n; i++) {
    if (i > idx && nums[i] == nums[i-1]) continue;   // skip same value at same depth
    // ...
}
```

### Subsets — pick / not-pick
```java
void f(int i, List<Integer> cur) {
    if (i == n) { res.add(new ArrayList<>(cur)); return; }
    cur.add(nums[i]); f(i + 1, cur); cur.remove(cur.size() - 1);   // pick
    f(i + 1, cur);                                                  // not pick
}
```

### Permutations (swap method, O(1) extra space)
```java
void permute(int i) {
    if (i == n) { res.add(toList(nums)); return; }
    for (int j = i; j < n; j++) { swap(i, j); permute(i + 1); swap(i, j); }
}
```

**Classic backtracking problems:** N-Queens, Sudoku Solver, Rat in a Maze, Word Search, Combination Sum I/II/III, Palindrome Partitioning, Letter Combinations, Generate Parentheses, M-Coloring, Kth Permutation.

> ⚠️ `res.add(path)` adds a **reference** — the stored list keeps mutating. Always `res.add(new ArrayList<>(path))`.

---

## 30. Bit Manipulation

| Trick | Code |
|---|---|
| Get i-th bit | `(n >> i) & 1` |
| Set i-th bit | `n \| (1 << i)` |
| Clear i-th bit | `n & ~(1 << i)` |
| Toggle i-th bit | `n ^ (1 << i)` |
| Lowest set bit | `n & -n` |
| Clear lowest set bit | `n & (n - 1)` |
| Is power of two | `n > 0 && (n & (n - 1)) == 0` |
| Count set bits | `Integer.bitCount(n)` |
| Is odd | `(n & 1) == 1` |
| Multiply / divide by 2 | `n << 1` / `n >> 1` |
| Swap without temp | `a ^= b; b ^= a; a ^= b;` |
| XOR properties | `x ^ x = 0`, `x ^ 0 = x` |

### Subset enumeration (bitmask)
```java
for (int mask = 0; mask < (1 << n); mask++) {
    for (int i = 0; i < n; i++)
        if ((mask & (1 << i)) != 0) { /* i is in the subset */ }
}
```
### Iterate submasks of a mask
```java
for (int sub = mask; sub > 0; sub = (sub - 1) & mask) { /* ... */ }
```

> ⚠️ Use `>>>` (unsigned right shift) when the sign bit matters — `>>` sign-extends.
> ⚠️ `1 << 31` overflows int. Use `1L << i` for i ≥ 31.

**Problems:** single number I/II/III, missing number, subsets, count bits, reverse bits, max XOR (binary trie), min flips, divide two integers.

---

## 31. Math & Number Theory

### GCD / LCM
```java
int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }
long lcm(long a, long b) { return a / gcd(a, b) * b; }   // divide FIRST to avoid overflow
```

### Sieve of Eratosthenes — O(n log log n)
```java
boolean[] isPrime = new boolean[n + 1];
Arrays.fill(isPrime, true);
isPrime[0] = isPrime[1] = false;
for (int i = 2; (long) i * i <= n; i++)
    if (isPrime[i])
        for (int j = i * i; j <= n; j += i) isPrime[j] = false;
```

### Primality — O(√n)
```java
boolean isPrime(int n) {
    if (n < 2) return false;
    for (int i = 2; (long) i * i <= n; i++) if (n % i == 0) return false;
    return true;
}
```

### Divisors in O(√n)
```java
for (int i = 1; (long) i * i <= n; i++)
    if (n % i == 0) { list.add(i); if (i != n / i) list.add(n / i); }
```

### Fast modular exponentiation
```java
static final int MOD = 1_000_000_007;
long power(long b, long e, long m) {
    long res = 1; b %= m;
    while (e > 0) {
        if ((e & 1) == 1) res = res * b % m;
        b = b * b % m;
        e >>= 1;
    }
    return res;
}
// modular inverse (m prime): power(a, m - 2, m)
```

### Modular arithmetic safety
```java
long add = (a + b) % MOD;
long sub = ((a - b) % MOD + MOD) % MOD;      // keep non-negative
long mul = (a % MOD) * (b % MOD) % MOD;      // both as long!
```

### BigInteger (when long overflows)
```java
BigInteger a = BigInteger.valueOf(x);
a.add(b); a.subtract(b); a.multiply(b); a.divide(b); a.mod(b);
a.pow(k); a.gcd(b); a.compareTo(b); a.equals(b); a.toString();
BigInteger.ZERO / ONE / TWO / TEN
```

---

## 32. String Algorithms

### Z-function (my `Search Pattern` solution) — O(n + m)
```java
int[] zFunction(String s) {
    int n = s.length();
    int[] z = new int[n];
    int l = 0, r = 0;
    for (int i = 1; i < n; i++) {
        if (i <= r) z[i] = Math.min(r - i + 1, z[i - l]);
        while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) z[i]++;
        if (i + z[i] - 1 > r) { l = i; r = i + z[i] - 1; }
    }
    return z;
}
// pattern search: build s = pattern + '$' + text;
// every i with z[i] == m is a match starting at i - m - 1 in text
```

### KMP LPS array
```java
int[] buildLPS(String p) {
    int[] lps = new int[p.length()];
    int len = 0, i = 1;
    while (i < p.length()) {
        if (p.charAt(i) == p.charAt(len)) lps[i++] = ++len;
        else if (len != 0) len = lps[len - 1];
        else lps[i++] = 0;
    }
    return lps;
}
```
`n - lps[n-1]` = length of the smallest repeating unit.

### Rabin–Karp (rolling hash)
```java
long hash = 0, BASE = 31, MOD = 1_000_000_007L;
for (char c : s.toCharArray()) hash = (hash * BASE + (c - 'a' + 1)) % MOD;
// roll: hash = ((hash - old * pow) * BASE + newChar) % MOD
```

### Palindrome check (two pointers, ignoring non-alphanumerics)
```java
int l = 0, r = s.length() - 1;
while (l < r) {
    while (l < r && !Character.isLetterOrDigit(s.charAt(l))) l++;
    while (l < r && !Character.isLetterOrDigit(s.charAt(r))) r--;
    if (Character.toLowerCase(s.charAt(l++)) != Character.toLowerCase(s.charAt(r--))) return false;
}
```

### Longest palindromic substring — expand around centre O(n²)
```java
for (int i = 0; i < n; i++) { expand(i, i); expand(i, i + 1); }   // odd + even
```

### Anagram key
```java
char[] c = s.toCharArray(); Arrays.sort(c); String key = new String(c);
// or: int[26] frequency → Arrays.toString(freq) as the key
```

---

## 33. Greedy

**How to justify greedy:** prove an exchange argument — swapping to the greedy choice never makes the answer worse.

| Problem | Sort by |
|---|---|
| N meetings / activity selection | **end time** ascending |
| Non-overlapping intervals | **end time** ascending |
| Merge intervals | **start time** ascending |
| Minimum platforms | sort arrivals & departures separately, two pointers |
| Job sequencing (deadline) | profit descending, then latest free slot |
| Fractional knapsack | value/weight ratio descending |
| Minimum coins | largest denomination first (canonical systems only) |
| Candy distribution | left→right then right→left pass |
| Gas station | running tank; reset start when it goes negative |

```java
// Merge intervals
Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
List<int[]> res = new ArrayList<>();
for (int[] it : intervals) {
    if (res.isEmpty() || res.get(res.size()-1)[1] < it[0]) res.add(it);
    else res.get(res.size()-1)[1] = Math.max(res.get(res.size()-1)[1], it[1]);
}
return res.toArray(new int[0][]);
```

---

## 34. Design Problems

Classes I've implemented — each is a favourite in machine-coding rounds.

| Class | Data structures | Key idea |
|---|---|---|
| `MinStack` | 2 stacks (or 1 with encoded values) | push the running min alongside each value → O(1) `getMin()` |
| `LRUCache` | `HashMap` + doubly-linked list | map key→node; move to head on access; evict tail |
| `LFUCache` | `HashMap` + freq→DLL map + minFreq | evict least-frequent, tie → least-recent |
| `MedianFinder` | two heaps (max-heap low, min-heap high) | keep sizes balanced |
| `Trie` / `WordDictionary` | `Node[26]` | prefix tree; `.` wildcard → try all children |
| `BSTIterator` | stack of the left spine | `next()` amortized O(1) |
| `BrowserHistory` | two stacks, or array + pointer | back / forward / visit |
| `MyStack` / `MyQueue` | queue↔stack simulation | classic interview swap |
| `Graph` | adjacency list | |
| Circular Queue / Deque | array + front/rear + size | `(rear + 1) % capacity` |

### MinStack (O(1) getMin)
```java
Stack<Integer> st = new Stack<>(), minSt = new Stack<>();
void push(int x) { st.push(x); minSt.push(minSt.isEmpty() ? x : Math.min(x, minSt.peek())); }
void pop()       { st.pop(); minSt.pop(); }
int  top()       { return st.peek(); }
int  getMin()    { return minSt.peek(); }
```

### LRUCache skeleton (from my GfG solution)
```java
class LRUCache {
    class Node { int key, value; Node left, right; Node(int k, int v){ key=k; value=v; } }
    private int capacity;
    private HashMap<Integer, Node> cache = new HashMap<>();
    private Node head = new Node(-1,-1), tail = new Node(-1,-1);

    LRUCache(int cap) { capacity = cap; head.right = tail; tail.left = head; }

    private void remove(Node n) { n.left.right = n.right; n.right.left = n.left; }
    private void add(Node n)    { n.right = head.right; n.right.left = n; head.right = n; n.left = head; }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        Node n = cache.get(key); remove(n); add(n); return n.value;
    }
    public void put(int key, int value) {
        if (cache.containsKey(key)) { Node n = cache.get(key); n.value = value; remove(n); add(n); return; }
        Node n = new Node(key, value); cache.put(key, n); add(n);
        if (cache.size() > capacity) { Node del = tail.left; remove(del); cache.remove(del.key); }
    }
}
```

---

## 35. Complexity Cheat Table

### Java collections
| Structure | Access | Search | Insert | Delete | Ordered? |
|---|---|---|---|---|---|
| `int[]` | O(1) | O(n) | — | — | no |
| `ArrayList` | O(1) | O(n) | O(1)* | O(n) | insertion |
| `LinkedList` | O(n) | O(n) | O(1) at ends | O(1) at ends | insertion |
| `ArrayDeque` | — | O(n) | O(1)* | O(1)* | insertion |
| `Stack` | — | O(n) | O(1) | O(1) | LIFO |
| `HashMap` / `HashSet` | — | O(1) avg | O(1) avg | O(1) avg | **no** |
| `LinkedHashMap` | — | O(1) | O(1) | O(1) | insertion |
| `TreeMap` / `TreeSet` | — | O(log n) | O(log n) | O(log n) | **sorted** |
| `PriorityQueue` | peek O(1) | O(n) | O(log n) | O(log n) | heap only |

\* amortized

### Algorithms
| Algorithm | Time | Space |
|---|---|---|
| Binary search | O(log n) | O(1) |
| Merge sort / heap sort | O(n log n) | O(n) / O(1) |
| Quicksort | O(n log n) avg, O(n²) worst | O(log n) |
| Counting sort | O(n + k) | O(k) |
| DFS / BFS | O(V + E) | O(V) |
| Dijkstra (heap) | O(E log V) | O(V) |
| Bellman–Ford | O(V·E) | O(V) |
| Floyd–Warshall | O(V³) | O(V²) |
| Kruskal | O(E log E) | O(V) |
| Prim (heap) | O(E log V) | O(V) |
| DSU op | ~O(α(n)) ≈ O(1) | O(n) |
| Segment tree build / query | O(n) / O(log n) | O(4n) |
| Fenwick update / query | O(log n) | O(n) |
| Trie insert / search | O(L) | O(26·N·L) |
| KMP / Z | O(n + m) | O(n) |
| Subsets / permutations | O(2ⁿ·n) / O(n!·n) | O(n) |

### Input size → target complexity
| n | Feasible |
|---|---|
| ≤ 10–12 | O(n!) |
| ≤ 20–25 | O(2ⁿ) bitmask |
| ≤ 100 | O(n³) |
| ≤ 1,000–5,000 | O(n²) |
| ≤ 1e5–1e6 | O(n log n) |
| ≤ 1e7–1e8 | O(n) |
| > 1e9 | O(log n) / O(1) |

---

## 36. Gotchas That Cost Me Submissions

1. **Integer overflow.** `int * int` overflows even when assigned to a `long`. Cast first: `(long) a * b`. Sums of 1e5 values up to 1e9 need `long`.
2. **`mid` overflow.** `(lo + hi) / 2` → use `lo + (hi - lo) / 2`.
3. **`==` on Strings and Integers.** Use `.equals()`. `Integer` caches only −128..127.
4. **`a - b` comparators overflow.** Use `Integer.compare(a, b)` / `Long.compare(a, b)`.
5. **`s.length()` vs `arr.length`.** Parens on String, none on array.
6. **`Scanner.nextInt()` then `nextLine()`** returns the leftover newline.
7. **`list.remove(int)` vs `list.remove(Object)`.** Wrap with `Integer.valueOf(x)` to remove by value.
8. **Backtracking result aliasing.** `res.add(new ArrayList<>(path))`, never `res.add(path)`.
9. **`Arrays.fill` on 2D** only fills the row references — loop over rows.
10. **`String +=` in a loop** is O(n²) → use `StringBuilder`.
11. **`Integer.MAX_VALUE` as INF** overflows on `dist[u] + w`. Use `1e8` or `Long.MAX_VALUE/4`.
12. **`%` on negatives** returns negative in Java: use `((x % m) + m) % m` or `Math.floorMod`.
13. **`Math.pow` returns double** — precision loss for large ints; write fast power.
14. **Stack overflow on deep recursion** (~1e4–1e5 frames) → convert DFS to an explicit stack.
15. **`Arrays.sort(int[])` quicksort hack** on Codeforces → box to `Integer[]` or shuffle first.
16. **Forgetting `pathVisited[node] = false`** in directed cycle detection.
17. **Iterating a `PriorityQueue`** is not sorted — only `poll()` order is.
18. **`ArrayDeque` rejects null**; `LinkedList` accepts it.
19. **`println` inside a hot loop** on Codeforces → collect into a `StringBuilder`, print once.
20. **Modifying a collection while for-each iterating** → `ConcurrentModificationException`.

---

## 37. Exam-Day Checklist

**Before coding**
- [ ] Restate the problem; confirm input ranges → pick the target complexity from §35.
- [ ] Ask about duplicates, negatives, empty input, and whether the input is sorted.
- [ ] Pick the data structure *first* — "need order? need O(1) lookup? need min/max fast?"

**Data structure decision tree**
| Need | Use |
|---|---|
| O(1) lookup by key | `HashMap` / `HashSet` |
| Sorted keys, floor/ceiling queries | `TreeMap` / `TreeSet` |
| Min or max repeatedly | `PriorityQueue` |
| LIFO / undo / matching brackets | `Stack` / `ArrayDeque` |
| FIFO / level-by-level | `Queue` (`LinkedList` / `ArrayDeque`) |
| Both ends | `ArrayDeque` |
| Prefix / dictionary queries | `Trie` |
| Connectivity / merging groups | `DSU` |
| Range query + point update | Segment tree / Fenwick |
| Insertion order preserved | `LinkedHashMap` / `LinkedHashSet` |

**Before submitting**
- [ ] Edge cases: `n == 0`, `n == 1`, all equal, all negative, max constraints.
- [ ] `long` where sums or products can exceed 2.1e9.
- [ ] Loop bounds: `<` vs `<=`, `n` vs `n-1`.
- [ ] Result copied, not aliased (backtracking).
- [ ] Every recursion has a reachable base case.

**Revision priority for this drive** (thinnest coverage first)
1. Strings + string algorithms (only 1 GfG file)
2. Backtracking (3 files) — N-Queens, Sudoku, Combination Sum
3. Segment Tree / Fenwick (3 files)
4. Greedy interval problems (6 files)
5. Tries (4 files) — including the binary trie for max XOR
6. Queues (3 files) — circular queue, deque design

---

*Generated from this repository. Update as new topics get added.*
