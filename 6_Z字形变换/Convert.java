//https://leetcode-cn.com/problems/zigzag-conversion/
import java.util.Arrays;
class Convert {
    public String convert(String s, int numRows) {
        //给每个字母标改变后的行数 i  列数 j
        //根据Z字型变化,确定行数列数的变化分为两种规律
        //从上到下,列数j不变,行数i++(i<=numRows);
        //从下往右上延伸,行数 i--(i>=0),列数 j++
        //初始i=0,j=0,从上到下延伸
        //列数j j/(numRows-1)*(numRows+numRows-2)
        int row=0,column=0;
        boolean oritent=true; //1 从上到下,0从下到右上
        StringBuilder str = new StringBuilder();
        class finger implements Comparable<finger> {
            char c;
            int priority=0;
            public finger(char c ,int priority) {
                this.c = c;
                this.priority = priority;
            }

            public int compareTo(finger a)
            {
                return a.priority-this.priority;
            }

        }
        if(s==null||s.length()==0||numRows<=1)//当numRows等于0或1,不动
            return s;
        finger []f=new finger[s.length()];
        f[0]=new finger(s.charAt(0),numRows*s.length()-column);
        System.out.println(s.charAt(0)+" "+row+" "+column+" "+((numRows-row)*s.length()-column));
        row++;
        for(int i=1;i<s.length();i++)
        {
            System.out.println(""+oritent);
            if(oritent)
            {
                f[i]=new finger(s.charAt(i),(numRows-row)*s.length()-column);
                System.out.println(""+s.charAt(i)+" "+row+" "+column+" "+((numRows-row)*s.length()-column));
                if(row<numRows-1)
                    row++;
                else{
                    oritent=!oritent;
                    row--;
                    column++;
                }
            }
            else{
                f[i]=new finger(s.charAt(i),(numRows-row)*s.length()-column);
                System.out.println(s.charAt(i)+" "+row+" "+column+" "+((numRows-row)*s.length()-column));
                if(row>0)
                {
                    row--;
                    column++;
                }
                else{
                    oritent=!oritent;
                    row++;
                }
            }
        
        }
        Arrays.sort(f);
        for (finger i : f)
            str.append(i.c);
        System.out.println(str.toString());
        return str.toString();
    }
    public  static void main(String[] args) {
        Convert c=new Convert();
        c.convert("PAYPALISHIRING",3);
    }

}
