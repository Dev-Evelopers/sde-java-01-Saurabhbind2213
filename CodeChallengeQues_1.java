public class CodeChallengeQues_1 {
    public static int subString(String s){
        //find  distinct characters 
        boolean[] cha= new boolean[26];
        int dis =0;
        for(char c : s.toCharArray()){
            if(!cha[c-'a']){
                cha[c-'a']=true;
                dis++;
            }
        }
        //sliding window
        int[] freq = new int[26];
        int left = 0;
         int count = 0;
         int minlen = s.length();
        for(int right =0; right<s.length(); right++){
            char r = s.charAt(right);
            freq[r-'a']++;
            if(freq[r-'a']==1){
                count++;   // new distinct character found
            }
            // try to shrink the window from left if all distinct characters are found
            while(count==dis){
                minlen = Math.min(minlen, right-left+1);
                //shrink from left
                char l = s.charAt(left);
                freq[l-'a']--;
                if(freq[l-'a']==0){
                    count--;
                }
                left++;
            }
        }
        return minlen;

    }
    public static void main(String[] args) {
        String s1 = "dabbcabcd";
        System.out.println(subString(s1));
        String s2 = "asdfkjeghfalawefhaef";
        System.out.println(subString(s2));
    }
    
}
