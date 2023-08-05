package slidingWindow;

public class Main {
    static int largestRectangleArea(int[] heights) {

        int i=0,start=0;
        int max=heights[0],min=heights[0];
        while(i < heights.length) {
            min = Math.min(min,heights[i]);
            int c = min*((i-start)+1);
            max = Math.max(max,c);

            if(heights[i] >= max) {
                start = i;
                max = heights[i];
                min = heights[i];
            }

            i++;


        }
        System.out.println(min);
        System.out.println(min*((i-start)+1));
        return max;


    }

    public static void main(String[] args) {
        int[] h = {1,2,3,4,5};

        int i = largestRectangleArea(h);
        System.out.println(i);
    }
}
