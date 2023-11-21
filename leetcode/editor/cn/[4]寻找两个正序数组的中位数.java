//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
//
// Related Topics 数组 二分查找 分治 👍 6527 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int allLength = nums1.length + nums2.length;
        boolean isOu = allLength % 2 == 0;
        int index = isOu ? (allLength / 2) -1 :  (allLength / 2);
        int i = 0,j = 0,count = 0;
        while (count < index){
            if (i < nums1.length && j< nums2.length){
                int x = nums1[i];
                int y = nums2[j];
                if (x <= y){
                    i++;
                }else {
                    j++;
                }
            }else if(i == nums1.length){
                j++;
            }else {
                i++;
            }
            count++;
        }
        int resIndex = 0;
        if (i == nums1.length){
            resIndex = nums2[j++];
        }else {
            if (j == nums2.length){
                resIndex = nums1[i++];
            }else {
                if (nums1[i] <= nums2[j]){
                    resIndex = nums1[i++];
                }else {
                    resIndex = nums2[j++];
                }
            }
        }
        if (isOu){
            int res1 = i < nums1.length ? nums1[i] : Integer.MAX_VALUE;
            int res2 = j < nums2.length ? nums2[j] : Integer.MAX_VALUE;
            int res = Math.min(res1,res2);
            return ((double) resIndex + (double) res) / 2;
        }else {

            return (double) resIndex;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
