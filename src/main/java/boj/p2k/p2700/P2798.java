package boj.p2k.p2700;


public class P2798 {
    public static void main (int N, int M, int[] numbers) {
        

        int answer = search(numbers, N, M);
        System.out.println(answer);
    }
    
    static int search (final int[] numbers, final int N, final int M) {
        int result = 0;
        for (int i = 0; i < N - 2; i++){
            for (int j = i + 1; j < N - 1; j++){
                for (int k = j + 1; k < N; k++){
                    int temp = numbers[i] + numbers[j] + numbers[k];
                    
                    if (temp == M){
                        return temp;
                    }
					if(result < temp && temp < M) {
						result = temp;
					}
                }
            }
        }
        return result;
    }
}