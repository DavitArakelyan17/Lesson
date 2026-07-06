public class Homework2 {
    public static void main(String[] args){
        int i = 985;
        int miavor = i % 10;
        System.out.println("Miavor - " + miavor);
        int tasnavor = (i / 10) % 10;
        System.out.println("Tasnavor - " + tasnavor);
        int haryuravor = i / 100;
        System.out.println("Haryuravor - " + haryuravor);

        // 51
        if (miavor == tasnavor + haryuravor){
            System.out.println("*51*" + true);
        }else{
            System.out.println("*51*" + false);
        }

        //52
        if(miavor == tasnavor || tasnavor == haryuravor || miavor == haryuravor){
            System.out.println("*52*" + true);
        }else{
            System.out.println("*52*" + false);
        }

        //53
        int f = miavor + tasnavor + haryuravor;
        if (f / i > i){
            System.out.println("*53*" + true);
        }else{
            System.out.println("*53*" + f);
        }

        //54
        if(miavor > tasnavor || miavor > haryuravor){
            System.out.println("*54*" + miavor);

        } else if (tasnavor > haryuravor || tasnavor > miavor) {
            System.out.println("*54*" + tasnavor);

        }else{
            System.out.println("*54*" + haryuravor);
        }

        //55
        if(miavor < tasnavor || miavor < haryuravor){
            System.out.println("*55*" + miavor);

        } else if (tasnavor < haryuravor || tasnavor < miavor) {
            System.out.println("*55*" + tasnavor);

        }else{
            System.out.println("*55*" + haryuravor);
        }

        //56
        if(miavor > tasnavor){
            System.out.println("*56*" + f/i);
        }else{
            System.out.println("*56*" + i);
        }

        //57
        if(i > 300){
            System.out.println("*57*" + tasnavor / miavor);
        }else{
            System.out.println("*57*" + haryuravor / miavor);
        }

        //58
        if(tasnavor + haryuravor < 5){
            System.out.println("*58*" + "a");
        }else{
            System.out.println("*58*" + "b");
        }

        //59
        if (miavor < tasnavor && miavor < haryuravor && tasnavor < haryuravor) {
            System.out.println("*59*" +miavor + " " + tasnavor + " " + haryuravor);

        } else if (miavor < tasnavor && miavor < haryuravor && tasnavor > haryuravor) {
            System.out.println("*59*" + miavor + " " + haryuravor + " " + tasnavor);

        } else if (tasnavor < miavor && tasnavor < haryuravor && miavor < haryuravor) {
            System.out.println("*59*" + tasnavor + " " + miavor + " " + haryuravor);

        } else if (tasnavor < miavor && tasnavor < haryuravor && miavor > haryuravor) {
            System.out.println("*59*" + tasnavor + " " + haryuravor + " " + miavor);

        } else if (haryuravor < miavor && haryuravor < tasnavor && miavor < tasnavor) {
            System.out.println("*59*" + haryuravor + " " + miavor + " " + tasnavor);

        } else {
            System.out.println("*59*" + haryuravor + " " + tasnavor + " " + miavor);
        }

        //60
        if (miavor > tasnavor && miavor > haryuravor && tasnavor > haryuravor) {
            System.out.println("*60*" + miavor + " " + tasnavor + " " + haryuravor);

        } else if (miavor > tasnavor && miavor > haryuravor && tasnavor < haryuravor) {
            System.out.println("*60*" + miavor + " " + haryuravor + " " + tasnavor);

        } else if (tasnavor > miavor && tasnavor > haryuravor && miavor > haryuravor) {
            System.out.println("*60*" + tasnavor + " " + miavor + " " + haryuravor);

        } else if (tasnavor > miavor && tasnavor > haryuravor && miavor < haryuravor) {
            System.out.println("*60*" + tasnavor + " " + haryuravor + " " + miavor);

        } else if (haryuravor > miavor && haryuravor > tasnavor && miavor > tasnavor) {
            System.out.println("*60*" + haryuravor + " " + miavor + " " + tasnavor);

        } else {
            System.out.println("*60*" + haryuravor + " " + tasnavor + " " + miavor);
        }

        int x = 1758;
        int miavor1 = x % 10;
        System.out.println("Miavor1 - " + miavor1);
        int tasnavor1 = (x / 10) % 10;
        System.out.println("Tasnavor1 - " + tasnavor1);
        int haryuravor1 = (x / 100) % 10;
        System.out.println("Haryuravor1 - " + haryuravor1);
        int hazaravor = x / 1000;
        System.out.println("Hazaravor - " + hazaravor);

        //61
        if(miavor1 + tasnavor1 == haryuravor1 + hazaravor){
            System.out.println("*61*" + true);
        }else{
            System.out.println("*61*" + false);
        }

        //62
        if(x < 5000){
            System.out.println("*62*" + x / (miavor1 + tasnavor1));
        }else{
            System.out.println("*62*" + x / (haryuravor1 + hazaravor));
        }

        //63
        if(miavor1 == 1 || tasnavor1 == 1 || haryuravor1 == 1 || hazaravor ==1){
            System.out.println("*63*" + 1);
        }else{
            System.out.println("*63*" + 0);
        }

        //64
        if(miavor1 + tasnavor1 == 5){
            System.out.println("*64*" + "s");
        }else{
            System.out.println("*64*" + "d");
        }

        //65
        if(miavor1 * tasnavor1 == 12){
            System.out.println("*65*" + "y = 12");
        }else{
            System.out.println("*65*" + "y = 0");
        }

        //66
        if(x/1000 ==4 || x%10 == 4){
            System.out.println("*66*" + "YES");
        }else{
            System.out.println("*66*" + "NO");
        }

        //67
        int u = miavor1 + tasnavor1 + haryuravor1 + hazaravor;
        if(x == u * u){
            System.out.println("*67*" + "YES");
        }else{
            System.out.println("*67*" + "NO");
        }

        //68
        if(miavor1 > tasnavor1){
            System.out.println("*68*" + miavor1 * tasnavor1);
        }else{
            System.out.println("*68*" + 1);
        }

        //69
        if(u > 20){
            System.out.println("*69*" + 1);
        }else{
            System.out.println("*69*" + 0);
        }

        //70
        int p = miavor1 * tasnavor1 * haryuravor1 * hazaravor;
        if(p>200){
            System.out.println("*70*" + 0);
        }else{
            System.out.println("*70*" + 1);
        }

    }

}