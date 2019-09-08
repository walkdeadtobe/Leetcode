//https://leetcode-cn.com/problems/container-with-most-water/
class Solution {
    public int myAtoi(String str) {
        double d=0;
        int start=-1,end=-1;
        boolean positive=true;
        if(str==null||str.length()==0)
            return 0;
        for(int i=0;i<str.length();i++)
        {
            //两种类型字符,空格和非空格
            //对于空格,统一跳过
            //以正负号作为数字的 开头,可能出现正负号之后有字符然后是数字的情况(ps:从题目来看,忽略这一点)
            //if(str.charAt(i).equals(' ')||(start!=-1&&(int)(str.charAt(i))>=48&&(int)(str.charAt(i))<=48))
            //    continue;
            if(start==-1)
            {
                if((int)(str.charAt(i))==(int)('+')||(int)(str.charAt(i))==(int)('-')||((int)(str.charAt(i))>=48&&(int)(str.charAt(i))<=57))
                {
                    start=i;
                    if((int)(str.charAt(i))==(int)('-'))
                        positive=false;
                }
                else
                {
                    if((int)(str.charAt(i))==(int)(' '))
                        continue;
                    System.out.println(str+" "+i);
                    return 0;
                }
            }
            else
            {
                if((int)(str.charAt(i))>=48&&(int)(str.charAt(i))<=57)
                    continue;
                else
                    {
                        end=i-1;
                        break;
                    }
                
            }
            
        }
        if(start==-1)
            return 0;
        if(end==-1)
            end=str.length()-1;

        if((int)(str.charAt(start))==(int)('+')||(int)(str.charAt(start))==(int)('-'))
            start++;
        int pow=0;
        double add=0;
        System.out.println("start:"+start+"\nend:"+end);
        for(int i=end;i>=start;i--)
        {
            d+=((int)str.charAt(i)-48)*Math.pow(10,pow);
            //System.out.println(" "+(int)d);
            pow++;
        }
        if(!positive&&-d<-2147483648)
        {
            //System.out.println("Zero");
            return -2147483648;
        }
        if(positive&&d>2147483647)
        {
            //System.out.println("Zero");
            return 2147483647;
        }
        if(!positive)
            d=-d;

        System.out.println("d:"+(int)d);
        return (int)d;

        
    }
 public  static void main(String[] args) {
        Solution s=new Solution();
        s.myAtoi("42");
        s.myAtoi("   -42");
        s.myAtoi("4193 with words");
        s.myAtoi("words and 987");
        s.myAtoi("-91283472332");
         s.myAtoi(" ");
    }


}
