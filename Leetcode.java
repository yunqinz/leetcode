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
 
