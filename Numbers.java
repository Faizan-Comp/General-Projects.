package primary;

public class Numbers {
    private Float[] arr;
    private int size;
    private int numOfValues;

    public Numbers() {
        this.arr = new Float[5];
        this.size = 5;
        this.numOfValues = 0;
    }

    public Numbers(int size) {
        this.size = size;
        this.arr = new Float[size];
        this.numOfValues = 0;
    }


    public void addValue(float value) {
        if (numOfValues < size) {
            arr[numOfValues] = value;
            numOfValues++;
        }
        else {
            System.err.println("Array is full");
        }
    }

    public float calcAverage() {
        if(numOfValues == 0) {
            return 0.0f;
        }
        float total = 0;
        for(int i = 0; i < numOfValues; i++) {
            total += arr[i];
        }
        return total/numOfValues;
    }

    public String findMinMax() {
        if(numOfValues == 0) {
            return "Minimum value is: 0.0, Maximum value is: 0.0, Max mod min is: 0.0";
        }
        float min = arr[0];
        float max = arr[0];
        float mod;

            for(int i = 1; i < numOfValues; i++) {
            if(arr[i] < min) {
                min = arr[i];
            }
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        mod = max % min;

        String str = "Minimum value is: " + String.valueOf(min) + ", Maximum value is: " + String.valueOf(max) + ", Max mod min is: " + String.valueOf(mod);

        return str;
    }

    public int getFactorialMin() {
        if(numOfValues == 0) {
            return 0;
        }
        float min = arr[0];
        int total = 1;
        for(int i = 1; i < numOfValues; i++) {
            if(arr[i] < min) {
                min = arr[i];
            }
        }
        int m1 = Math.round(min);
        for(int i = m1; i > 1; i--) {
            total *= i;
        }
        return total;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < numOfValues; i++) {
            str += arr[i] + " ";
        }
        return str;
    }

}
