class Solution {
    public String countAndSay(int n) {
        String str="1";
        

        for(int i=0; i<n-1; i++){
            StringBuilder sb=new StringBuilder();
            int count=1;
            char prev= str.charAt(0);

            for(int j=1; j<str.length();j++){
                if(str.charAt(j)==prev){
                    count++;
                }else{
                    sb.append(count).append(prev);
                    prev=str.charAt(j);
                    count=1;
                }
            }
            sb.append(count).append(prev);
            str=sb.toString();
        }
            return str;
    }
}
