public class Homework4 {
    public static void main (String[] args){
        //Task5
        int [] Task5  = {10, 6, 47, 8, 14, 28, 33, 0, 99};

        int count = 0;
        for (int i = 1; i < Task5.length ; i++) {
            if (Task5[i] % 2 == 0){
                count++;
            }


        }
        System.out.println(count);
        System.out.println("----------------");

       //Task 211 avg of positive values

        int sum = 0;
        int [] Task6  = {10, 6, 47, 8, 14, 28, 33, 0, 99};
        for (int i = 0; i < Task6.length; i++) {
            sum = sum + Task6[i];

        }
        int avg = sum / Task6.length;
        System.out.println(avg);
        System.out.println("----------------");


        //Task 214 avg of negative values

        int sum214 = 0;
        int [] Task7  = {-10, 6, -47, 8, -14, -28, 33, 0, -99};
        for (int i = 0; i < Task7.length; i++) {
            sum = sum214 + Task7[i];

        }
        int avg214 = sum / Task6.length;
        System.out.println(avg214);
        System.out.println("----------------");

        //Task 215 The sum of number with even index
        int sum215 = 0;
        int [] Task8  = {-10, 6, -47, 8, -14, -28, 33, 0, -99};
        int index = 0;
        for (int i = 0; i < Task8.length ; i++) {
           if( i % 2 ==0){
               sum215 += Task8[i];
           }

        }

        System.out.println(sum215);
        System.out.println("----------------");

        //Task 216

        int product216 = 1;
        int [] Task9  = {-10, 6, -47, 8, -14, -28, 33, 0, -99};
        for (int i = 0; i < Task9.length ; i++) {
            if( i % 2 ==0){
                product216 *= Task8[i];
            }

        }
        System.out.println(product216);
        System.out.println("----------------");

        //Task 219 a multiple for a given k number

        int count219 = 0;
        int [] Task10  = {-10, 6, -47, 8, -14, -28, 33, 1, -99};
        int k = 3;
        for (int i = 0; i < Task9.length; i++) {
            if( Task10[i] % k == 0) {
                count219++;
            }
        }
        System.out.println(count219);
        System.out.println("----------------");

        //Task 221

        int sum221 = 0;
        int [] Task11  = {-10, 6, -47, 8, -14, -28, 33, 1, -99};
        for (int i = 0; i < Task11.length; i++) {
            if (Task11[i] > -14 && Task11[i] < 33){
                sum221 += Task11[i];

            }

        }
        System.out.println(sum221);
        System.out.println("----------------");

        //Task 222

        int product222 = 1;
        int [] Task12  = {-10, 6, -47, 8, -14, -28, 33, 1, -99};
        for (int i = 0; i < Task12.length; i++) {
            if (Task12[i] > -14 && Task12[i] < 33){
                product222 *= Task12[i];

            }

        }
        System.out.println(product222);
        System.out.println("----------------");

        //Task 223

        int count223 = 0;
        int [] Task13  = {-10, 6, -47, 8, -14, -28, 33, 1, -99};
        for (int i = 0; i < Task12.length; i++) {
            if (Task13[i] > -14 && Task13[i] < 33){
                count223++;

            }

        }
        System.out.println(count223);
        System.out.println("----------------");

        //Task 227

        int f = 4;
        int count227 = 0;
        int sum227 = 0;
        int avg227 = 0;
        int [] Task14  = {-10, 6, -47, 8, -14, -28, 33, 1, -99};
        for (int i = 0; i < Task14.length; i++) {
            if(Task14[i] % f ==0){
                sum227 += Task14[i];
                count227++;
            }


        }
        System.out.println(sum227/count227);
        System.out.println("-------------");


        //Task 228


        int u = 4;
        int sum228 = 0;
        int [] Task15  = {-10, 6, -47, 8, -14, -28, 33, 1, -99};
        for (int i = 0; i < Task15.length; i++) {
            if(Task15[i] % f ==0){
                sum228 += Task15[i];

            }


        }
        System.out.println(sum228);
        System.out.println("-------------");

        //Task 229

        int product229 = 1;
        int [] Task16  = {-10, 6, -47, 8, -14, -28, 33, 1, -99};
        for (int i = 0; i < Task16.length; i++) {
            if(Task16[i] - i > 0){
                product229 += Task16[i];
            }

        }
        System.out.println(product229);
        System.out.println("--------------");

        //Task 231

        int sum231 = 0;
        int [] Task17  = {-10, 6, -47, 8, -14, -28, 33, 1, -99};
        for (int i = 0; i < Task17.length; i++) {
            if(Task17[i] % 2 == 0){
                sum231 += Task17[i] * Task17[i];

            }

        }
        System.out.println(sum231);
        System.out.println("-------------");

        //Task 232

        int count232 = 0;
        int [] Task18  = {-10, 6, -47, 8, -14, -28, 33, 1, -99};
        for (int i = 0; i < Task18.length; i++) {
            if(Task18[i] % 2 == 0){
                count232 ++;
            }

        }
        System.out.println(count232);
        System.out.println("-------------");

        //Task 233

        int product233 = 1;
        int sum233 = 0;
        int [] Task19  = {-10, 6, -47, 8, -14, -28, 33, 1, -99};
        for (int i = 0; i < Task19.length; i++) {
            if(Task19[i] % 2 == 0){
                sum233 ++;
                product233 *= Task19[i];
            }

        }
        System.out.println(sum233);
        System.out.println(product233);
        System.out.println("--------------");

        //Task 234

        int sum234 = 0;
        int avg234 = 0;
        int count234 = 0;
        int [] Task20  = {-10, 6, -47, 8, -14, -28, 33, 1, -99};
        for (int i = 0; i < Task20.length; i++) {
            if( Task20[i] % 2 != 0){
                sum234 += Task20[i];
                count234 ++;

            }

        }
        System.out.println(sum234 / count234);
        System.out.println("--------------");

        //Task 236

        int product236 = 1;
        int sum236 = 0;
        int [] Task21  = {-10, 6, -47, 8, -14, -28, 33, 1, -99};
        for (int i = 0; i < Task21.length; i++) {
            if(Task21[i] % 2 != 0){
                sum236 ++;
                product236 *= Task21[i];
            }

        }
        System.out.println(sum236);
        System.out.println(product236);
        System.out.println("--------------");

        //Task 237

        int count237 = 0;
        int [] Task22  = {-10, 6, -47, 8, -14, -28, 33, 1, -99, 0};
        for (int i = 0; i < Task22.length ; i++) {
            if(Task22[i] == 0) {
                count237 ++;
            }
        }
        System.out.println(count237);
        System.out.println("-------------");

        //Task 238

        int a = 3;
        int count238 = 0;
        int sum238 = 0;
        int [] Task23  = {-10, 6, -47, 8, -14, -28, 33, 1, -99, 0};
        for (int i = 0; i < Task23.length; i++) {
            if( Task23[i] % 3 == 0){
                count238++;
                sum238 += Task23[i];
            }

        }

        System.out.println(sum238 / count238);
        System.out.println("---------------");

        //Task 240

        int b = 7;
        int count240 = 0;
        int [] Task24  = {-10, 6, -47, 8, -14, -28, 33, 2, -99, 0};
        for (int i = 0; i < Task24.length; i++) {
            if( Task24[i] % b == 0){
                count240++;

            }

        }
        System.out.println(count240);
































    }
}
