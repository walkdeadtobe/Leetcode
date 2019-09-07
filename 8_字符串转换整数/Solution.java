class Solution {
    public int myAtoi(String str) {
        double d=0;
        int start=-1,end=-1;
        boolean positive=true;
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
                    return 0;
                }
            }
            else
            {
                if((int)(str.charAt(i))>=48&&(int)(str.charAt(i))<=57)
                    continue;
                else
                    {
                        end=i;
                        break;
                    }
                
            }
            
        }
        if(end==-1)
            end=str.length()-1;

        if((int)(str.charAt(start))==(int)('+')||(int)(str.charAt(start))==(int)('-'))
            start++;
        int pow=0;
        System.out.println("start:"+start+"\nend:"+end);
        for(int i=end;i>=start;i--)
        {
            d+=((int)str.charAt(i)-48)*Math.pow(10,pow);
            pow++;
        }
        if(!positive)
            d=-d;
        System.out.println(" "+d);
        return (int)d;

        
    }
 public  static void main(String[] args) {
        Solution s=new Solution();
        s.myAtoi("-222");
    }


}
