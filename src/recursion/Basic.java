package recursion;


//1.while the function is not finished executing , it will remain in stack mem
// 2.while the function is finished executing , it is removed from stack.
// and the flow of program returns to where it was called
// 3. Base condition has to placed, to stop the recursive calls
//(Every function call will take some memory from stack)
//4. without Base condition, recursive calls happens resulting in stack overflow error


//why recursion ?
//breaks down problems to smaller chunks , solving easily
//convert iterative problems to recursive problems and vice versa
// takes space memory, no constant memory


public class Basic {

    static void printNumbers(int n) {

        if (n == 5) {
            System.out.println(n);
            return;
        }
        System.out.println(n);
        printNumbers(n + 1);

    }

    static void printNumbersReverse(int n) {
        System.out.println(n);
        if (n == 1) {
            return;
        }
        printNumbersReverse(n - 1);


    }

    static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    static int binarySearch(int[] arr, int target, int start, int end) {

        if (start > end) {
            return -1;
        }
        int m = start + (end - start) / 2;

        if (arr[m] == target) {
            return m;
        }

        if (target < arr[m]) {
            return binarySearch(arr, target, start, m - 1);
        }

        return binarySearch(arr, target, m + 1, end);

    }

    static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    static int sum(int n) {
        if (n <= 0) {
            return 0;
        }
        return n + sum(n - 1);
    }

    static int sumOfDigits(int n) {
        if (n < 10) {
            return n;
        }

        return (n % 10) + sumOfDigits(n / 10);
    }

    static int productOfDigits(int n) {
        if (n < 10) {
            return n;
        }

        return (n % 10) * productOfDigits(n / 10);
    }


    static int reverseDigit(int n) {
        if (n < 10) {
            return n;
        }
        int digits = (int) Math.log10(n);

        return (n % 10) * (int) Math.pow(10, digits) + reverseDigit(n / 10);
    }
    static int countZeroes(int n) {
        if(n==0) {
            return 0;
        }
        return (((n%10)==0) ? 1 : 0) + countZeroes(n/10);
    }


    public static void main(String[] args) {
//        System.out.println("====== print Number ==========");
//        printNumbers(1);
//        System.out.println("====== finbonacci ==========");
//        System.out.println(fibonacci(3));
//        System.out.println("====== Binary Search ==========");
//        int[] arr = {1, 2, 3, 4, 5, 66, 77, 432};
//        int target = 3;
//        System.out.println(binarySearch(arr, target, 0, arr.length - 1));
//        System.out.println(binarySearch(arr, 1, 0, arr.length - 1));
//        System.out.println(binarySearch(arr, 432, 0, arr.length - 1));
//        System.out.println(binarySearch(arr, 32, 0, arr.length - 1));
//        System.out.println("====== print Numbers Reverse ==========");
//        printNumbersReverse(5);
//        System.out.println("====== print Factorial ==========");
//        System.out.println(factorial(5));
//        System.out.println("====== print sum ==========");
//        System.out.println(sum(5));
//        System.out.println("====== print sum of digits ==========");
//        System.out.println(sumOfDigits(5431));
//        System.out.println("====== print product of digits ==========");
//        System.out.println(productOfDigits(5431));
        System.out.println("====== print reverse of digits ==========");
        System.out.println(reverseDigit(5431));
        System.out.println("====== print count zeroes of digits ==========");
        System.out.println(countZeroes(5400031));
    }
}
