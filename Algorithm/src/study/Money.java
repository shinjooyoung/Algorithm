package study;

public class Money {

	public static void main(String[] args) {
		int money = 1260;
		int[] moneys = {500,100,50,10};
		int count = 0;
		
	
		for(int i : moneys) {
			count += money / i;
			money -= (money / i) * i;
		}	
		
		System.out.println(count);
		
	}

}
