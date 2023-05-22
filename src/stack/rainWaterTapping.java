package stack;

public class rainWaterTapping {
    static int maxLeft = Integer.MIN_VALUE;
    static int maxRight = Integer.MIN_VALUE;
    static int maxL[];
    static int maxR[];
    static int rainWater[];
    static int totalWater = 0;

    public static void main(String[] args) {
        int arr[] = {3, 0, 0, 2, 0, 4};
        maxL = new int[arr.length];
        maxR = new int[arr.length];
        rainWater = new int[arr.length];
        rainWaterTrapping(arr);
    }

    public static void rainWaterTrapping(int[] arr) {
        maxLeft = arr[0];
        maxL[0] = arr[0];
        maxRight = arr[arr.length - 1];
        maxR[maxR.length - 1] = arr[arr.length - 1];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxLeft) {
                maxL[i] = arr[i];
            } else {
                maxL[i] = maxLeft;
            }
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > maxRight) {
                maxR[i] = arr[i];
            } else {
                maxR[i] = maxRight;
            }
        }
        System.out.println("Max left ----");
        for (Integer i : maxL) {
            System.out.println(i);
        }

        System.out.println("Max right ----");
        for (Integer i : maxR) {
            System.out.println(i);
        }

        for (int i = 0; i < rainWater.length; i++) {
            rainWater[i] = Math.min(maxL[i], maxR[i]) - arr[i];
        }
        System.out.println("Rain water ----");
        for (Integer i : rainWater) {
            System.out.println(i);
            totalWater = totalWater + i;
        }
        System.out.println("Total water is " + totalWater);

    }
}
