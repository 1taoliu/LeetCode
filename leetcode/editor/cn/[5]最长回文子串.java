//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 6495 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;
        String res = s.substring(0,1);
        for (int i= 0;i< s.length();i++){
            int left = i-1,right = i+1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                String temp = s.substring(left,right+1);
                if (temp.length() > res.length()){
                    res = temp;
                }
                left -- ;right ++;
            }
            if (i+1 < s.length() && s.charAt(i) == s.charAt( i+ 1)){

                String temp2 = s.substring(i,i+2);
                if (temp2.length() > res.length()){
                    res = temp2;
                }

                int left2 = i-1,right2 = i+2;

                while (left2 >= 0 && right2 < s.length() && s.charAt(left2) == s.charAt(right2)){
                    String temp = s.substring(left2,right2+1);
                    if (temp.length() > res.length()){
                        res = temp;
                    }
                    left2 -- ;right2 ++;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
