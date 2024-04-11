package ArrayQuestions;

import java.util.ArrayList;

public class LinearSearch {
    public static void main(String[] args) {
         int[] arr = {1,2,3,4,4,5,6,7,8,9};
        System.out.println(linearsearch(arr,0,12));
        System.out.println(findIndex(arr,0,6));
        System.out.println(findlastIndex(arr,arr.length-1,6));
        findallIndex(arr,0,4);
        System.out.println(list);
        System.out.println(findallIndex2(arr,0,4,new ArrayList<Integer>()));
        System.out.println(findallIndex3(arr,0,4));
    }
    static boolean linearsearch(int[]arr,int index,int target)
    {
        if(index == arr.length)
        {
            return false;
        }
        else
        {
            return arr[index]==target || linearsearch(arr,++index,target);
        }
    }
    static int findIndex(int[]arr,int index,int target)
    {
        if(index == arr.length)
        {
            return -1;
        }
        if(arr[index]==target)
        {
            return index;
        }
        else
        {
           return findIndex(arr,++index,target);
        }

    }
    static int findlastIndex(int[]arr,int index,int target)
    {
        if(index == arr.length)
        {
            return -1;
        }
        if(arr[index]==target)
        {
            return index;
        }
        else
        {
            return findlastIndex(arr,--index,target);
        }
    }
    static ArrayList<Integer> list = new ArrayList<>();
    static void findallIndex(int[]arr,int index,int target)
    {
        if(index == arr.length)
        {
            return;
        }
        if(arr[index]==target)
        {
           list.add(index);
        }
            findallIndex(arr,++index,target);
    }
    static ArrayList<Integer> findallIndex2(int[]arr,int index,int target,ArrayList<Integer>list)
    {
        if(index == arr.length)
        {
            return list;
        }
        if(arr[index]==target)
        {
            list.add(index);
        }
        return findallIndex2(arr,++index,target,list);
    }
    static ArrayList<Integer> findallIndex3(int[]arr,int index,int target)
    {
        ArrayList<Integer> list = new ArrayList<>();
        if(index == arr.length)
        {
            return list;
        }
        if(arr[index]==target)
        {
            list.add(index);
        }
        ArrayList<Integer> ansfromBelowCalls = findallIndex3(arr,++index,target);

        list.addAll(ansfromBelowCalls);

        return list;
    }

}
