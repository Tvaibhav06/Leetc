class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder str=new StringBuilder();
        int cnt=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                if(cnt>0)str.append('(');
                cnt++;
            }
            else if(s.charAt(i)==')'){
                 cnt--;
                if(cnt>0)str.append(')');
               
            }
        }
        return str.toString();
    }
}