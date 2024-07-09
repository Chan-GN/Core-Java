public class MultiDimensionalArray {
    public static void main(String[] args) {
    /*
        int[][] arr; // Declaration
        arr = new int[4][3]; // Creation, Rectangular Array
        // arr = new int[4][]; // Jagged Array (4 Rows, ?? Columns)
        // arr[0][0] = 0; // Assignment
    */
    /*
        int[][] arr_init = { // Initialization
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}
        };
    */

    /*
        int[][] arr;
        arr = new int[4][3];
        arr[0] = new int[]{1, 2, 3};
        arr[1] = new int[]{4, 5, 6};
        arr[2] = new int[]{7, 8, 9};
        arr[3] = new int[]{10, 11, 12};
    */

        int[][] arr_jagged; // Jagged Array
        arr_jagged = new int[4][3];
        arr_jagged[0] = new int[]{1, 2, 3, 4};
        arr_jagged[1] = new int[]{5, 6};
        arr_jagged[2] = new int[]{7};
        arr_jagged[3] = new int[]{8, 9, 10, 11, 12};

        // System.out.println(arr_jagged.length); // count of Rows
        // System.out.println(arr_jagged[0].length); // count of Column(0 Row)

        for (int i = 0; i < arr_jagged.length; i++) {
            for (int j = 0; j < arr_jagged[i].length; j++) {
                System.out.print(arr_jagged[i][j] + " ");
            }
            System.out.println();
        }
    }
}
