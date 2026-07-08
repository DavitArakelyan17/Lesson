public class Homework3 {
    public static void main (String[] args){
        System.out.println("InClass----------");
        int rows = 5;
        int elements = 1;
        for(int i = 1; i<=rows; i++){
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
        System.out.println("---------------");
        System.out.println("Homework----------");
        for (int i = 1; i <=rows; i++) {
            for (int j = 0; j < rows - i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();

        }
        System.out.println("---------------");

        //task1 - Create an array and it with 2 number
        System.out.println("Task1----------");
        int [] task1 = new int[]{2, 2, 2};

        System.out.println(task1[0]);
        System.out.println("---------------");

        //task2 - create an array and fill it with numbers from 1 to 1000
        System.out.println("Task2----------");
        int [] task2 = new int[1000];
        for(int i = 0; i < task2.length; ++i){
            task2[i] = i + 1;
        }
        for (int i = 0; i < task2.length; i++){
            System.out.println(task2[i]);
        }
        System.out.println("---------------");

        //task3 - create an array and fill it with odd numbers from -20;20
        System.out.println("Task3----------");
        int [] task3 = new int[20];
        int index = 0;
        for (int i = -19; i < 20;  i+=2) {
            task3[index++] = i;

        }
        for (int i = 0; i < task3.length ; i++) {
            System.out.println(task3[i]);

        }
        System.out.println("---------------");

        //task4 -  Create an array and fill it with the elements that can be divided by 5
        System.out.println("Task4----------");
        int [] task4 = new int [75];
        int index4 = 0;
        for (int i = 0; i <=75 ; i+=5) {
            task4[index4++] = i;
            System.out.println(i);

        }
        System.out.println("---------------");

        //task5 - Create an array and fill in the elements that are between 24.12 and 467.23
        System.out.println("Task5----------");
        float [] task5 = new float[468];
        int index5 = 0;
        for (int i = 0; i < 468; i++) {
            task5[index5++] = i;

            if(i > 24.12 && i < 467.23){
                System.out.println(i);
            }

        }
        System.out.println("---------------");

        //Task7 - Product Table
        System.out.println("Task7----------");

        int n = 3;
        int [] task7 = new int[11];
        int index7 = 0;
        for (int i = 0; i < 11 ; i++) {
            task7[index7++] = i;

            System.out.println( "3"+ " " + "*"  + " " + i + " " + "=" + " "  + n * i );

        }








    }
}
