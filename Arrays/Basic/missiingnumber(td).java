class missiingnumber {
  // hypothetical scenario for the worst case is that the internal loop runs for
  // like N times which wont happen most of the time
  public static int missingNumber(int[] nums) {

    boolean flag = false;
    for (int i = 0; i <= nums.length; i++) {
      flag = false;
      for (int j = 0; j < nums.length; j++) {
        if (i == nums[j]) {
          flag = true;
          break;
        }
      }
      if (flag == false) {
        return i;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    System.out.println(missingNumber(new int[] { 3, 0, 1 }));
  }
}
