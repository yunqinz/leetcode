 Array 
//----------------------//
27.Remove Element
Given an array and a value, remove all instances of that value in place and return the new length.
Do not allocate extra space for another array, you must do this in place with constant memory.
The order of elements can be changed. It doesn't matter what you leave beyond the new length.
Example:
Given input array nums = [3,2,2,3], val = 3
Your function should return length = 2, with the first two elements of nums being 2.
Solution(Two pointer):
维护两个指针，一个指向需要清除的元素(start 指针) 一个指向需要留下来的元素(i)。
从头开始扫描 找到第一个需要留下来的元素,第一个需要被替换的元素(start 指向的元素)，用第一个留下来的元素覆盖第一个需要被替换的元素,
然后两个指针向后移动，再次找到第一个需要留下的元素 和需要被清楚的元素
Answer:
public class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0) return 0;
        int start = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] != val){
                nums[start++] = nums[i];
            }
        }
        return start;
    }
}
--------------------------------------------------------
26. Remove Duplicates from Sorted Array
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn not matter what you leave beyond the new length.
Solution:
Answer:


-----------------------


346.Reverse Vowels of a String
----
Write a function that takes a string as input and reverse only the vowels of a string.
Example 1:
Given s = "hello", return "holle".
Example 2:
Given s = "leetcode", return "leotcede"
----
Solution:
 用两个指针：一个指向String的头部一个指向String的尾部。分别找到头部和尾部第一个碰到的元音字母。然后进行交换。
 如果String 没有遍历完，继续重复上一个步骤，直到String 全部遍历完成。
<<<<<<< Updated upstream

 Answer:



------------------------------------------------------------------------------------------------------------------- 
167. Two Sum II - Input array is sorted
Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
-----------
Solution:
Because this array is sorted.So we can use two pointers to go through this array.One (p1)is from the beginning and the other(p2) is from the end.
if the sum of the these two pointers points to is equal to the target.Then we found the result.
if sum < target,we move the p1 to its right.
else move p2 too its left.
Answer:
public class Solution{
	public int[] twoSum(int[] num,int target){
		int[] res = new int[2];
		if(nums == null || nums.length < 2)return res;
		int left = 0;
		int right = nums.length -1;
		while(left < right){
			int sum = nums[left]+nums[right];
			if(sum == target){
				res[0] = left+1;
				res[1] = right+1;
			}else if(sum < target){
				left ++;
			}else{
				right --;
			}
		}
		return res;
	}
}
-------------------------------------------------------------------------------
168.Two Sum III - Data structure design
Design and implement a TwoSum class. It should support the following operations: add and find.
add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.
For example,
add(1); add(3); add(5);
find(4) -> true
find(7) -> false
Solution:
用HashMap实现，key 存的是要加入的numnber, value 存的是这个number加入了几次。
add(num):将num放到map的key,对应的value 增加一次
find(target):迭代keySet(),target减去当前的key = 目标key ,如果 目标key 在hashmap 中存在（即他的value > 1）则返回true.
			否则返回false.
			寻找目标key 的过程中会出现两种情况：1. 目标key == 原来的key ,那么他的次数 >=2 ，则返回true
												2. 目标key != 原来的key ,目标key 次数 > 1，则返回true
public class TwoSum{
	HashMap<Ingteger,Ingteger> map = new HashMap<Ingteger,Ingteger>();
	public void add(int num){
		if(!map.containsKey()){
			map.put(num,1);
		}else{
			map.put(num,map.get(num)+1);
		}
	}
	public boolean find(int target){
		for(int val:map.KeySet()){
			int wanted = target - val;
			if((wanted == val && map.get(wanted) >= 2) || (wanted != val) && map.containsKey(wanted)){
				return true;
			}
		}
		return false;
	}
}
-----------------------------------------------------------------
217. Contains Duplicate
Given an array of integers, find if the array contains any duplicates. 
Your function should return true if any value appears at least twice in the array, 
and it should return false if every element is distinct.
Solution:
利用HashSet数据结构。
Answer：
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int val:nums){
            if(set.contains(val)){
                return true;
            }else{
                set.add(val);
            }
        }
        return false;
    }
}
-----------------------------------------------------------------
219. Contains Duplicate II
Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array 
such that nums[i] = nums[j] and the difference between i and j is at most k.
Solution：
用HashMap实现. key存数组中的值，value是数组下标.
遍历数组如果map中已经存在这个值，那么判断map中的值和遍历到的值下标差值，若果差值 <= k，那么返回true.
否则更新map 
Answer：
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0;i < nums.length;i++){
            if(map.containsKey(nums[i])){
                if(i - map.get(nums[i]) <= k){
                    return true;
                }
            }
            map.put(nums[i],i);
            
        }
        return false;
    }
}
------------------------------------------------------
220. Contains Duplicate III
Given an array of integers, find out whether there are two distinct indices i and j in the array 
such that the difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k.
Solution：
=======
 
 ----------------------------------------------------
 220.Contains Duplicate III
 Given an array of integers, find out whether there are two distinct indices i and j in the array 
 such that the difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k.

 Solution:
 这道题一眼看上去就知道要对一个滑动窗口为k的数组进行搜索，然后寻找与当前元素相差<t的元素。如果使用暴力搜索的话，时间复杂度为O(Nk),
 这个在k特别大的时候会TLE，所以必须对滑动窗口进行处理，理想情况下是组织成一棵树，而且最好是一个平衡二叉树。这样对元素的查找、删除和添加都是LOG(K)时间。
 如果用C实现，比较麻烦，所幸Java中有treeset这个类，可以生成一个平衡二叉树而无需考虑实现细节。
 代码如下，这里面注意两点：1、leetcode中没有SortedSet，需要自己import，2、在nums[i]+t+1时可能发生溢出，需要将其强制转换为long类型

 TreeSet:它可以给Set集合中的元素进行指定方式的排序。
        保证元素唯一性的方式：通过比较的结果是否为0.
        底层数据结构是：二叉树。
 
        排序的第一种方式：
            让元素自身具备比较性。只要让元素实现Comparable接口，覆盖compareTo方法即可。
            
            但是，如果元素自身不具备比较性，或者元素自身具备的比较性，不是所需要的。
            比如，学生的自然排序是按年龄排序，现在想要按照学生姓名排序。还可以不改动原有代码。
            这时怎么办呢？
        排序的第二种方式：自定比较器的方式。
            这时可以让集合自身具备比较性。
            可以定义一个类实现Comparator接口，覆盖compare方法。将该Comparator接口子类对象作为实际参数
            传递给TreeSet集合构造函数。
            该对象就是比较器。
 Answer:


>>>>>>> Stashed changes
