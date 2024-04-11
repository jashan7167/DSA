import java.util.Arrays;

//done using dutch flag algorithm
class sortcolors {

  public void sortColors(int[] nums) {
    int l = 0;
    int h = nums.length;
    int mid = 0;
    int temp;
    while (mid < h) {
      switch (nums[mid]) {
        case 0:
          temp = nums[mid];
          nums[mid] = nums[l];
          nums[l] = temp;
          l++;
          mid++;
          break;
        case 1:
          mid++;
          break;
        case 2:
          temp = nums[mid];
          nums[mid] = nums[h];
          nums[h] = temp;
          h--;
          break;
      }
    }

  }

  public static void main(String[] args) {
    sortcolors o = new sortcolors();
    int[] arr = { 2, 0, 2, 1, 0 };
    o.sortColors(arr);
    System.out.println(Arrays.toString(arr));
  }
}
