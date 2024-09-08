import java.io.*;

public class Main {
    public static void main(String[] args) {

        String[] names = {"John", "Carl", "Jerry"};
        try {
            BufferedWriter wr = new BufferedWriter(new FileWriter("output.txt"));
            wr.write("Writing to a file");
            wr.append("\nNice try buddy.");

            for(String s : names) {
                wr.write("\n" + s);
            }
            wr.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader("output.txt"));
            String line;
            while((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}