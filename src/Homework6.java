import java.sql.SQLOutput;

public class Homework6 {
    public static void main (String[] args){

        //Task 281

        int [] numbers281 = { 25, -5, 67, -82, 0,  44, -99, 235, -17, 0};
        int count281 = 0;
        for (int i = 0; i < numbers281.length; i++) {
            if(numbers281[i] > 0){
                count281++;
            }

        }
        int [] positive_numbers = new int[count281];

        for (int i = 0, j = 0; i < numbers281.length; i++) {
            if(numbers281[i] > 0){
                positive_numbers[j] = numbers281[i];
                j++;
            }
        }

        for (int i = 0; i < positive_numbers.length; i++) {
            System.out.print(positive_numbers[i] + "  ");

        }
        System.out.println();


        System.out.println("-------------------");
        // Task 282
        int [] numbers282 = { 25, -5, 67, -82, 0,  44, -99, 235, -17, 0};
        int count282 = 0;
        for (int i = 0; i < numbers282.length; i++) {
            if(numbers282[i] != 0){
                count282++;
            }
        }

        int [] new_numbers282 = new int[count282];

        for (int i = 0, j = 0; i < numbers282.length ; i++) {
            if(numbers282[i] != 0){
                new_numbers282[j] = numbers282[i];
                j++;
            }
        }

        for (int i = 0; i < new_numbers282.length; i++) {
            System.out.print(new_numbers282[i] + "  ");
        }
        System.out.println();
        System.out.println("-----------------");

        // Task 283

        int [] numbers283 = { 25, -5, 67, -82, 0,  44, -99, 235, -17, 0};
        int count283 = 0;
        for (int i = 0; i < numbers283.length; i++) {
            if(numbers283[i] % 2 != 0){
                count283 ++;
            }
        }

        int [] odd_numbers283 = new int[count283];
        for (int i = 0, j = 0; i < numbers283.length; i++) {
            if(numbers283[i] % 2 != 0){
                odd_numbers283[j] = numbers283[i];
                j++;
            }
        }

        for (int i = 0; i < odd_numbers283.length; i++) {
            System.out.print(odd_numbers283[i] + "   ");
        }

        System.out.println();
        System.out.println("----------------");

        // Task 284
        int [] numbers284 = { 25, -5, 67, -82, 0,  44, -99, 235, -17, 0};
        int count284 = 0;
        for (int i = 0; i < numbers284.length; i++) {
            if(i >= 0 && i <= 6){
                count284++;
            }
        }
        int [] interval_numbers284 = new int[count284];
        for (int i = 0, j = 0; i <numbers284.length ; i++) {
            if(i >= 0 && i <= 6){
                interval_numbers284[j] = numbers284[i];
                j++;
            }
        }
        for (int i = 0; i < interval_numbers284.length; i++) {
            System.out.print(interval_numbers284[i] + "   ");

        }

        System.out.println();
        System.out.println("-----------------");

        //Task 285
        int [] numbers285 = { 25, -5, 67, -82, 0,  44, -99, 235, -17, 0};
        int count285 = 0;
        int k = 5;
        for (int i = 0; i < numbers285.length; i++) {
            if(numbers285[i] % k == 0 ){
                count285 ++;
            }
        }

        int [] numbers285_k = new int[count285];
        for (int i = 0 , j = 0; i < numbers285.length; i++) {
            if(numbers285[i] % k == 0){
                numbers285_k[j] = numbers285[i];
                j++;
            }
        }
        for (int i = 0; i < numbers285_k.length; i++) {
            System.out.print(numbers285_k[i] + "   ");
        }
        System.out.println();
        System.out.println("-----------------");

        //Task 286
        int [] numbers286 = { 25, -5, 67, -82, 0,  44, -99, 235, -17, 0};
        int count286 = 0;

        for (int i = 0; i < numbers286.length; i++) {
            if(numbers286[i] % 2 == 0){
                count286++;
            }
        }
        int [] even_numbers286 = new int[count286];

        for (int i = 0, j =0; i < numbers286.length ; i++) {
            if(numbers286[i] % 2 == 0){
                even_numbers286[j] = numbers286[i];
                j++;
            }
        }

        for (int i = 0; i < even_numbers286.length; i++) {
            System.out.print(even_numbers286[i] +  "   ");
        }
        System.out.println();
        System.out.println("------------------");

        // Task 287
       int [] numbers287 =  { 25, -5, 2, -82, 0,  5, -99, 235, -17, 9};
       int count287 = 0;
        for (int i = 0; i < numbers287.length; i++) {
            if(numbers287[i] != i){
                count287++;
            }
        }
        int [] new_numbers287 = new int[count287];

        for (int i = 0, j = 0; i < numbers287.length ; i++) {
            if(numbers287[i] != i){
                new_numbers287[j] = numbers287[i];
                j++;
            }
        }
        for (int i = 0; i < new_numbers287.length; i++) {
            System.out.print(new_numbers287[i] + "  ");
        }
        System.out.println();
        System.out.println("-------------------");

        //Task 288

        int [] numbers288 =  { 25, -5, 2, -82, 0,  5, -99, 235, -17, 9};
        int count288 = 0;
        for (int i = 0; i < numbers288.length; i++) {
            if(i % 2 !=0){
                count288++;
            }
        }
        int [] odd_index_numbers288 = new int[count288];
        for (int i = 0, j = 0; i < numbers288.length ; i++) {
            if(i % 2 != 0){
                odd_index_numbers288[j] = numbers288[i];
                j++;
            }
        }
        for (int i = 0; i < odd_index_numbers288.length; i++) {
            System.out.print(odd_index_numbers288[i] + "   ");
        }
        System.out.println();
        System.out.println("-------------------");

        //Task 289

        int [] numbers289 =  { 25, -5, 2, -82, 16,  5, -99, 235, -17, 9};
        int count289 = 0;

        for (int i = 0; i < numbers289.length; i++) {
            int k289 = numbers289[i] * numbers289[i] ;
            if(numbers289[0] <= k289 &&  k289<= numbers289[7] ){
                count289++;
            }
        }
        int [] new_numbers289 = new int[count289];
        for (int i = 0, j = 0; i < numbers289.length; i++) {
            int k289 = numbers289[i] * numbers289[i] ;
            if(numbers289[0] <= k289 &&  k289<= numbers289[7]){
                new_numbers289[j] = numbers289[i];
                j++;
            }
        }
        for (int i = 0; i < new_numbers289.length; i++) {
            System.out.print(new_numbers289[i] + "  ");
        }

        System.out.println();
        System.out.println("---------------");


        int [] numbers290 =  { 25, -5, 2, -82, 0,  5, -99, 235, -17, 9};
        int count290 = 0;
        for (int i = 0; i < numbers290.length; i++) {
            if(i % 6 == 1){
                count290++;
            }
        }
        int [] new_numbers290 = new int[count290];
        for (int i = 0, j = 0; i < numbers290.length ; i++) {
            if(i % 6 == 1){
                new_numbers290[j] = numbers290[i];
                j++;
            }
        }
        for (int i = 0; i < new_numbers290.length; i++) {
            System.out.print(new_numbers290[i] + "   ");
        }
        System.out.println();
        System.out.println("-------------------");


        // Matrix
        // 2D Array

        // Primary Diagonal

        int [][] array = {{1,5,6,5},{5,2,6,9},{6,5,6,8},{1,5,6,3}};
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("  ");
            }
            System.out.println(array[i][i]);
        }
        System.out.println();
        System.out.println("------------------");


        //Lower - Right Triangle

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i + j >= array.length - 1) {
                    System.out.print(array[i][j] + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("------------------");

        // Upper - Right Triangle

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (j >= i) {
                    System.out.print(array[i][j] + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("------------------");

        // Lower - Left Triangle

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i >= j) {
                    System.out.print(array[i][j] + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("------------------");

        // Above The Main Diagonal
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (j > i) {
                    System.out.print(array[i][j] + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("------------------");

        // Below The Main Diagonal
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i > j) {
                    System.out.print(array[i][j] + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("------------------");

        // Above The Secondary Diagonal
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i + j < array.length - 1) {
                    System.out.print(array[i][j] + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("------------------");

        // Below The Secondary Diagonal
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i + j > array.length - 1) {
                    System.out.print(array[i][j] + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("------------------");




    }
}