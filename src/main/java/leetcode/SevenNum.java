package leetcode;

/**
 * 七进制数
 */
public class SevenNum {

    public static String convertToBase7(int num) {
        if(num == 0) return num + "";
        boolean isR = num > 0 ? false : true;
        int value = Math.abs(num);
        StringBuilder sb = new StringBuilder();
        int temp = 0;
        while(value / 7 != 0){
            temp = value % 7;
            sb.append(temp);
            value = value / 7;
        }
        sb.append(value);
        String valueS = sb.reverse().toString();
        if(isR){
            return "-" + valueS;
        }else{
            return valueS;
        }
    }

    public static void main(String[] args) {

        System.out.println(convertToBase7(100));
    }
}
