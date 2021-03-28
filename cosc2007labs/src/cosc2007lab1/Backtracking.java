package cosc2007lab1;

public class Backtracking {
	public static void main(String[] args) {
        int[] arr1 = {4, 7, 3};
        int[] arr2 = new int[arr1.length];
        System.out.println(partitionable(arr1,arr2));
    }

    public static boolean partitionable( int[] a1, int[] a2) {

        return partitionable( a1,  a2, 0);

    }

    //this method falls into stck overflow coz it set itemIndex to 0 each time when it goes to helper method
    public static boolean partitionable( int[] a1, int[] a2, int itemIndex) {
        int sum1 = 0;
        int sum2 = 0;
        for(int i = 0; i < a1.length; i++) {
            sum1 += a1[i];
            sum2 += a2[i];
        }
        if (sum1 == sum2) return true;
        if (sum1 < sum2) return false;

        for(int i = itemIndex; i < a1.length; i++) {
            a2[i] = a1[i];
            a1[i] = 0;
            if (partitionable( a1, a2, i+1) == true)  return true;// if this returns "true" -> we are done
            a1[i] = a2[i];// this returns back one step and works only if we were not successful with previous step
            a2[i] = 0;

        }
        return false;

    }
}
