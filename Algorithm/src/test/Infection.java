package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Infection {

    public static class Virus{
        int x;
        int y;
       
        Virus(int x, int y){
          this.x = x;
          this.y = y;
         
        }
    }
   
    static int n,k,s,x,y;
    static int[][] map;
    static int[] nx = {1,-1,0,0};
    static int[] ny = {0,0,-1,1};
   
    static ArrayList<Queue<Virus>> infos = new ArrayList<Queue<Virus>>();
   
    public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
     
      //시험관 크기
      n = sc.nextInt();
     
      //바이러스 종류
      k = sc.nextInt();
     
      map = new int[n+1][n+1];
     
      //바이러스 종류별 위치 셋팅
      for(int i = 0; i <=k; i++){
        infos.add(new LinkedList<Virus>());
      }
     
      //전체 셋팅
      for(int i = 1; i <=n; i++){
        for(int j = 1; j <=n; j++){
           int num = sc.nextInt();
           map[i][j] = num;
           if(num > 0) {
          infos.get(num).offer(new Virus(i,j));          
           }
        }
      }      
     
      // 시간
      s = sc.nextInt();
      x = sc.nextInt();
      y = sc.nextInt();
     
      spreaVirus();
     
      System.out.println(map[x][y]);
    }
   
    private static void spreaVirus(){
      for(int i = 1; i <=s; i++){
        for(int a = 1; a <=k; a++){
        	Queue<Virus> virusQ = infos.get(a);
        	Queue<Virus> newVirus = new LinkedList<Virus>(); 
           
        	while(!virusQ.isEmpty()) {
        		Virus virus = virusQ.poll();
        		setVirus(virus.x, virus.y, a, newVirus);
        	}
        	
        	infos.set(a, newVirus);
        }
      }  
     
    }
   
    private static void setVirus(int vx, int vy, int cate, Queue<Virus> que){
      for(int i = 0; i < 4; i++){
        int vnx = vx + nx[i];
        int vny = vy + ny[i];
       
        if(vnx >0 && vny >0 && vnx <= n && vny <= n){
          if(map[vnx][vny] == 0){
            map[vnx][vny] = cate;
            que.offer(new Virus(vnx, vny));
          }
        }
       
      }
     
    }
}