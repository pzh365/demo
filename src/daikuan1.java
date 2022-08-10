import java.text.NumberFormat;
import java.util.Scanner;

public class daikuan1 {

    /**   /**回车就会自动生成下一行代码的相关注释，点最左边的按钮可以让文档注释更容易辨别
     *
     * 以等额本息方式计算每月还款金额
     * @param p 贷款本金
     * @param mr 月利率
     * @param m 还款月份
     * @return 返回结果
     */
    static Double yuehaikuan(double p,double mr,int m){
        return p * mr * Math.pow(1+mr,m) / (Math.pow(1+mr,m)-1);
    }

//测试用1，请无视
//测试用2，请无视
//hot-fix test
    static void printDetails(double p, double mr, int m, double sum ){
        for(int i = 0; i < m; i++){
            double payInterest = p * mr;
            double payPrincipal = sum - payInterest;
            p -= payPrincipal;
            System.out.print("月份："+(i+1));
            //        让数字变成货币符号，可以在getCurrencyInstance(Locale.US)括号里面选择其他货币
            System.out.print("\t本月还款："+NumberFormat.getCurrencyInstance().format(sum));
            System.out.print("\t偿还本金："+NumberFormat.getCurrencyInstance().format(payPrincipal));
            System.out.print("\t偿还利息："+NumberFormat.getCurrencyInstance().format(payInterest));
            System.out.println("\t剩余本金："+NumberFormat.getCurrencyInstance().format(p));
        }
        System.out.println("总还款额："+ NumberFormat.getCurrencyInstance().format(sum * m));
    }
    static double inputAndCheckp(){
        Scanner sc = new Scanner(System.in);
        System.out.println("输入贷款本金：");
        double p = sc.nextDouble();
        if(p<=0){
            throw new IllegalArgumentException("贷款金额必须 > 0");
        }
        return p;
    }
    static double inputAndCheckmr(){
        Scanner sc = new Scanner(System.in);
        System.out.println("输入年利率：");
        double yr =  sc.nextDouble();
        if(yr < 1.0 || yr >36.0){
            throw new IllegalArgumentException("年利率必须是1 ~ 36");
        }
        return yr/ 12.0 / 100;
    }
    static int inputAndCheckm(){
        Scanner sc = new Scanner(System.in);
        System.out.println("输入还款月份：");
        int m =  sc.nextInt();
        if(m < 1 || m > 360){
            throw new IllegalArgumentException("贷款月数必须是1 ~ 360");
        }
        return m;
    }

    public static void main(String[] args) {
//      调用三个输入数据的方法
        double p = inputAndCheckp();
        double mr = inputAndCheckmr();
        int m = inputAndCheckm();
//      调用计算每月还款的方法
        double sum = daikuan1.yuehaikuan(p,mr,m);
//      调用打印m个的还款信息
        daikuan1.printDetails(p,mr,m,sum);
    }
}
