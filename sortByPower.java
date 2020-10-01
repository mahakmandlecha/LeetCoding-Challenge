import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class numPower {
    private int num;
    private int power;

    private int getPower(int n, int current) {
        if (n == 1) return current;
        if (n % 2 == 0) return getPower(n/2, current + 1);
        else return getPower(3*n + 1, current + 1);
    }

    public numPower() {
        this.num = -1;
        this.power = -1;
    }

    public numPower(int n) {
        this.set(n);
    }

    public void set(int n) {
        this.num = n;
        this.power = getPower(n, 0);
    }

    public int getNum() {
        return this.num;
    }

    public int getPower() {
        return this.power;
    }

    public static void sortNumPowers(List<numPower> v) {
        for (int i = 0; i < v.size(); ++i) {
            int idx = i;
            for (int j = i; j < v.size(); ++j)
                if (v.get(j).getPower() < v.get(idx).getPower()) idx = j;
            
            if (idx != i)
                Collections.swap(v, i, idx);
        }
    }
}

public class sortByPower {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int lo = reader.nextInt(),
            high = reader.nextInt(),
            k = reader.nextInt();
        List<numPower> vals = new ArrayList<numPower>();

        for (int i = lo; i <= high; ++i)
            vals.add(new numPower(i));

        numPower.sortNumPowers(vals);
        System.out.println(vals.get(k - 1).getNum());

        reader.close();
    }
}
