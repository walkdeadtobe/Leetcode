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
            if(str.charAt(i).equals(' ')||(start!=-1&&(int)(str.charAt(i))>=48&&(int)(str.charAt(i))<=48))
                continue;
            if(start==-1)
            {
                if(str.charAt(i).equals('+')||str.charAt(i).equals('-')||((int)(str.charAt(i))>=48&&(int)(str.charAt(i))<=48)))
                {
                    start=i;
                    if(str.charAt(i).equals('-'))
                        positive=flase;
                }
                else
                {
                    
                }
            }
            else
            {
                
            }
            
        }
        
    }
 public  static void main(String[] args) {
        Solution s=new Solution();
        s.myAtoi("-222");
    }


}
