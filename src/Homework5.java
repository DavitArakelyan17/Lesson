public class Homework5 {
    public static void main (String[] args){
        //Task 241

        int[] numbers241 = {375, 68, 517, 96, 465, 16, 40, 54, 444};
        int n241 = 4;
        int sum241 = 0;

        for (int i = 0; i < numbers241.length; i++) {
            if(numbers241[i] % n241 == 0){

                sum241 +=numbers241[i];

            }
        }

        System.out.println("Task 241" + " " + sum241);

        //Task 242

        int [] numbers242 = {375, 68, 517, 96, 465, 16, 40, 54, 444};
        int n242 = 2;
        int product242 = 1;
        for (int i = 0; i < numbers242.length; i++) {
            if(numbers242[i] % n242 == 0){

                product242 *= numbers242[i];
            }

        }
        System.out.println("Task 242" + " " + product242);

        //Task 243

        int count243 = 0;
        int t = 3;
        int [] numbers243 = {375, 68, 517, 96, 465, 16, 40, 54, 444};
        for (int i = 0; i < numbers243.length; i++) {

            if(numbers243[i] % t == 0){
                count243 ++;
            }
        }

        System.out.println("Task 243" + " " + count243);

        //Task 244

        int product244 = 1;
        int n244 = 5;
        int [] numbers244 = {375, 68, 517, 96, 465, 16, 40, 54, 444, 17, 27,};
        for (int i = 0; i < numbers244.length; i++) {
            if(numbers244[i] % n244 == 2){
                product244 *=numbers244[i];
            }

        }
        System.out.println("Task 244" + " " + product244);

        //Task 245

        long sum245 = 0;
        int n245 = 3;
        int [] numbers245 = {375, 68, 517, 96, 465, 16, 40, 54, 444, 17, 27};
        for (int i = 0; i < numbers245.length; i++) {
            if((numbers245[i] + i) % n245 == 0 ){

                sum245 += (long) numbers245[i] * numbers245[i] ;

            }


        }
        System.out.println("Task 245" + " " + sum245);

        // Task 248

        int sum248 = 0;
        int n248 = 5;
        int [] numbers248 = {375, 68, 517, 96, 465, 16, 40, 54, 444, 17, 27};
        for (int i = 0; i < numbers248.length; i++) {
            int value248 = numbers248[i] + i;
            if ((value248 * value248) % n248 == 0) {
                sum248 +=  numbers248[i];

            }
        }

        System.out.println("Task248" + " " + sum248);

        // Task 249

        int [] numbers249 = {375, 68, 517, 96, 465, 16, 40, 54, 444, 17, 27};
        int count249 = 0;
        int n249 = 38;
        for (int i = 0; i < numbers249.length ; i++) {
            int value249 = numbers249[i] - i;
            if(value249 > n249){
                value249 = -value249;
                count249 ++;
            }

        }
        System.out.println("Task249" + " " + count249);

        // Task 250

        long product250 = 1;
        int n250 = 3;
        int [] numbers250 = {375, 68, 517, 96, 465, 16, 40, 54, 444, 17, 27};
        for (int i = 0; i < numbers250.length; i++) {
            int value250 = numbers250[i] * i;
            if(value250 % n250 == 2){
                product250 =  (numbers250[i] * numbers250[i]) * numbers250[i];

            }

        }
        System.out.println("Task250" + " " + product250);

        // Task 251

        int [] numbers251 = {375, 68, 517, 96, 465, 16, 40, 54, 444, 17, 27};
        int max251 = numbers251[0];
        for (int i = 0; i < numbers251.length; i++) {
            if(numbers251[i] > max251) {
                max251 = numbers251[i];
            }
        }
        System.out.println("Task251" +  " " + max251);

        // Task 252

        int [] numbers252 = {375, 68, 517, 96, 465, 16, 40, 54, 444, 17, 27};
        int min252 = numbers252[0];
        for (int i = 0; i < numbers252.length; i++) {
            if(numbers252[i] < min252){
                min252 = numbers252[i];
            }
        }
        System.out.println("Task252" + " " + min252);

        // Task 253

        int sum253 = 0;
        int [] numbers253 = {375, 68, 517, 96, 465, 16, 40, 54, 444, 17, 27};
        int min253 = numbers253[0];
        int max253 = numbers253[0];
        for (int i = 0; i < numbers253.length; i++) {
            if(numbers253[i] < min253 ){
                min253 = numbers253[i];
            }
            if(numbers253[i]  > max253){
                max253 = numbers253[i];
            }
            sum253 = max253 + min253;

        }
        System.out.println("Task253" + " " + sum253);

        // Task 254

        int product254 = 1;
        int [] numbers254 = {375, 68, 517, 96, 465, 16, 40, 54, 444, 17, 27};
        for (int i = 0; i < numbers254.length; i++) {
            int min254 = numbers254[0];
            int max254 = numbers254[0];
            if(numbers254[i] > max254){
                max254 = numbers254[i];

            }
            if(numbers254[i] < min254){
                min254 = numbers254[i];
            }
            product254 = max254 * min254;

        }
        System.out.println("Task254" + " " + product254);

        // Task 255

        int [] numbers255 = {375, 68, 517, 96, 465, 16, 40, 54, 444, 17, 27};
        int sum255 = 0;
        int max255 = numbers255[0];
        for (int i = 0; i < numbers255.length; i++) {
            if(numbers255[i] > max255 ){
                max255 = numbers255[i];

            }
            sum255 = max255 + i;
        }

        System.out.println("Task255" + " " + sum255);

        //Task 256

        int [] numbers256 = {375, 68, 517, 96, 465, 16, 40, 54, 444, 17, 27};
        int sum256 = 0;
        for (int i = 0; i < numbers256.length; i++) {
            int min256 = numbers256[0];
            if(numbers256[i] < min256){
                min256 = numbers256[i];
            }
            sum256 = min256 + i;
        }
        System.out.println("Task256" + " " + sum256);


        // Task257

        int [] numbers257 = {375, 68, 517, 96, 465, 16, 40, 54, 444, 17, 27};
        int max257 = numbers257[0];
        int index257 = 0;
        for (int i = 0; i < numbers257.length; i++) {
            if (numbers257[i] > max257) {
                max257 = numbers257[i];
                index257 = i;

            }

        }
        System.out.println("Task257" + " " + index257);

        // Task258

        int [] numbers258 = {375, 68, 517, 96, 465, 16, 40, 54, 444, 17, 27, 517};
        int max258 = numbers258[0];
        int index258 = 0;
        for (int i = 0; i < numbers258.length; i++) {
            if(numbers258[i] >= max258){
                max258 = numbers258[i];
                index258 = i;
            }
        }
        System.out.println("Task258" + " " + index258);

        //Task259
        int [] numbers259 = {375, 68, 517, 96, 465, 16, 40, 54, 444, 17, 27, 517};
        int min259 = numbers258[0];
        int index259 = 0;
        for (int i = 0; i < numbers259.length; i++) {
            if(numbers259[i] < min259){
                min259 = numbers259[i];
                index258 = i;
            }
        }
        System.out.println("Task259" + " " + index259);

        //Task 260

        int [] numbers260 = {375, 68, 517, 96, 465, 16, 40, 54, 444, 17, 27, 517};
        int min260 = numbers260[0];
        int index260 = 0;
        for (int i = 0; i < numbers260.length; i++) {
            if(numbers259[i] <= min259){
                min260 = numbers260[i];
                index260 = i;
            }
        }
        System.out.println("Task260" + " " + index260);

        //Task 261

        int[] numbers261 = {375, 68, 517, 96, 465, 16, 40, 54, 444, 17, 27, 517} ;

        int sum = 0;
        int product = 1;

        for (int i = 0; i < numbers261.length; i++) {
            sum += numbers261[i];
            product *= numbers261[i];
        }

        double average = (double) sum / numbers261.length;

        System.out.println("Task261" + " " +  "Average = " + average);
        System.out.println("Task261" + " " + "Product = " + product);

        //Task263

        int [] numbers263 = {375, -68, 517, -96, 465, -16, 40, -54, 444, -17, -27, 517};
        int count263 = 0;
        for (int i = 0; i < numbers263.length; i++) {
            if(numbers263[i] > 0){
                count263 ++;
            }

        }
        System.out.println("Task263" + " " + count263);

        //Task264

        int [] numbers264 = {375, -68, 517, -96, 465, -16, 40, -54, 444, -17, -27, 517};
        int count264 = 0;
        for (int i = 0; i < numbers264.length; i++) {
            if(numbers264[i] > 0){
                count264 ++;
            }

        }
        System.out.println("Task263" + " " + count264);

        //Task265
        int [] x1 = {375, -68, 517, -96, 465, -16, 40, -54, 444, -17, -27, 517};
        int sumx1 = 0;
        int [] y1 = {375, -38, 605, -12, 411, -37, 34, -98, 117, 85, -18, 325 };
        int producty1 = 1;
        double result265 = 0;
        for (int i = 0; i < x1.length; i++) {
            sumx1 += x1[i];

        }
        for (int i = 0; i < y1.length; i++) {
            producty1 *= y1[i];
        }
        result265 = (double) sumx1 / producty1;
        System.out.println("Task265" + " " + result265);

        //Task 266


        int [] x2 = {375, -68, 517, -96, 465, -16, 40, -54, 444, -17, -27, 517};
        int sumx2 = 0;
        int [] y2 = {375, -38, 605, -12, 411, -37, 34, -98, 117, 85, -18, 325 };
        int sumy2 = 0;
        int result266 = 0;

        for (int i = 0; i < x2.length; i++) {
            if(x2[i] % 2 != 0){
                sumx2 += x2[i];
            }

        }

        for (int i = 0; i < y2.length; i++) {
            if(y2[i] % 2 != 0){
                sumy2 += y2[i];
            }

        }
        result266 = sumx2 - sumy2;
        System.out.println("Task266" + " " + result266);

        //Task 267

        int [] x3 = {375, -68, 517, -96, 465, -16, 40, -54, 444, -17, -27, 517};
        int sumx3 = 0;
        int [] y3 = {375, -38, 605, -12, 411, -37, 34, -98, 117, 85, -18, 325 };
        int sumy3 = 0;
        int result267 = 0;
        for (int i = 0; i < x3.length; i++) {
            if(x3[i] % 7 == 0){
                sumx3 += x3[i];

            }

        }
        for (int i = 0; i <y3.length; i++) {
            if(y3[i] % 7 == 0){
                sumy3 += y3[i];
            }

        }
        result267 = sumx3 + sumy3;
        System.out.println("Task267" + " " + result267);

        //Task 268

        int [] x4 = {375, -68, 517, -96, 465, -16, 40, -54, 444, -17, -27, 517};
        int countx4 = 0;
        int [] y4 = {375, -38, 605, -12, 411, -37, 34, -98, 117, 85, -18, 325 };
        int county4 = 0;
        int k268 = 9;
        int result268 = 0;
        for (int i = 0; i < x4.length; i++) {
            if(x4[i] % k268 == 0){
                countx4++;
            }
        }

        for (int i = 0; i < y4.length; i++) {
            if(y4[i] % k268 == 0){
                county4++;
            }

        }

        result268 = countx4 + county4;
       System.out.println("Task268" + " " + result268);
        System.out.println("1st Array" + " " + countx4);
        System.out.println("2nd Array" + " " + county4);

        //Task269

        int [] x5 = {375, -68, 517, -96, 465, -16, 40, -54, 444, -17, -27, 517};
        int sumx5 = 0;
        int [] y5 = {375, -38, 605, -12, 411, -37, 34, -98, 117, 85, -18, 325 };
        int sumy5 = 0;
        int result269 = 0;
        for (int i = 0; i < x5.length; i++) {
            if (i % 2 == 0){
                sumx5 += x5[i];
            }
        }

        for (int i = 0; i < y5.length; i++) {
            if(i % 2 != 0){
                sumy5 += y5[i];
            }
        }

        result269 = sumx5 + sumy5;
       System.out.println("Task269" + " " + result269);
       System.out.println( "1st array" + " " + sumx5);
       System.out.println("2nd Array" + " " + sumy5);

       //Task270


        int [] x6 = {375, -68, 517, -96, 465, -16, 40, -54, 444, -17, -27, 517};
        int sumx6 = 0;
        int [] y6 = {375, -38, 605, -12, 411, -37, 34, -98, 117, 85, -18, 325 };
        int sumy6 = 0;
        int result270 = 0;


        for (int i = 0; i < x6.length; i++) {
            sumx6 = x6[i] * x6[i];

        }
        for (int i = 0; i < y6.length; i++) {
            sumy6 = y6[i] * y6[i];
        }
         result270 = sumx6 + sumy6;
        System.out.println("Task270" + " " + result270);

































    }
}
