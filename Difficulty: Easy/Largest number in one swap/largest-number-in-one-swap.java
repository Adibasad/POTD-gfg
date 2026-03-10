class Solution {
    public String largestSwap(String s) {
        // code here
        char[] ch=s.toCharArray();
        char maxdigit='0';
        int maxind=0,l=-1,r=-1;
        for(int i=ch.length-1;i>=0;i--){
            if(ch[i]>maxdigit){
                maxdigit=ch[i];
                maxind=i;
            }
            else if(ch[i]<maxdigit){
                l=i;
                r=maxind;
            }
        }
        if(l==-1){
            return s;
        }
        char temp=ch[l];
        ch[l]=ch[r];
        ch[r]=temp;
        return new String(ch);
    }
}