package test;
import java.util.*;

public class CardSort{
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < N; i++){
            pq.offer(sc.nextInt());
        }
        
        int result = 0;
        
        while(!pq.isEmpty()) {
            int first = pq.poll();
            if(pq.isEmpty()) {
               break;
            }
            int second = pq.poll();
            
            result += first + second;
            pq.offer(first + second);
        }
        System.out.println(result);
    }
    
    
}