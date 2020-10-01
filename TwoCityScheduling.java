import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter value of n");
		int n = sc.nextInt();
		int[][] arr = new int[n][2];
		System.out.println("Enter aCosti and bCosti");
		int answer = 0;
		for(int i = 0;i<n;i++){
		    arr[i][0] = sc.nextInt();
		    arr[i][1] = sc.nextInt();
		    answer+= Math.min(arr[i][0],arr[i][1]);
		}
		System.out.println("The total minimum cost is "+ answer);
	}
}