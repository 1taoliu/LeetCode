//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
//
// Related Topics 字典树 字符串 👍 2788 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int index =  0;
        while (true){
            boolean isRight = true;
            char c = ' ';
            for (int i =0;i<strs.length;i++){
                if (index >= strs[i].length() ){
                    isRight = false;
                    break;
                }
                if (i==0){
                    c = strs[i].charAt(index);
                }
                if (strs[i].charAt(index) != c){
                    isRight = false;
                    break;
                }
            }
            if (isRight){
                sb.append(c);
                index++;
            }else {
                break;
            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
