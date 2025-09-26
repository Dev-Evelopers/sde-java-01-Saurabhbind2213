public class CodeChallengeQues_2 {
    public static long folds(long x, long y){
        long moves =0;
        while (x>2*y){
            x=(x+1)/2;  //fold in half
            moves++;

        }
        if(x>y)moves++;
        return moves;


    }
    public static long minMoves(long h, long w, long h1, long w1){
        return folds(h,h1) + folds(w,w1);


    }
    public static void main(String[] args) {
        long h = 8;
        long w = 4;
        long h1= 6;
        long w1 =1;
        System.out.println(minMoves(h, w, h1, w1));
        long h2 =2;
        long w2 =3;
        long h12 = 2;
        long w12 = 2;
        System.out.println(minMoves(h2, w2, h12, w12));
    }

    
}

//Time complexity : O(log(max(h,w))) ~ O(1)
