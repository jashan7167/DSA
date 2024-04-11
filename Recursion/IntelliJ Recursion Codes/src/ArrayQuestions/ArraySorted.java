package ArrayQuestions;

public class ArraySorted {

    public static void main(String[] args) {
        int[] arr = {1,2,3,5,8,16};
        System.out.println(arraysort(arr,0));
    }

    static boolean arraysort(int []arr,int index)
    {
        if(index==arr.length-1)
        {
            return true;
        }
        else
        {
            return arr[index]<arr[index+1] && arraysort(arr,++index);
        }
    }

}
