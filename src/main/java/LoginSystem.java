import java.io.*;
import java.util.Objects;

public class LoginSystem {

    public static boolean login(String input) throws IOException {
        String path = "users.csv";

        BufferedReader br =new BufferedReader(new FileReader(path));
        String line = br.readLine();

        while ((line = br.readLine()) != null){
            String[] data = line.split(",");
            if (Objects.equals(data[0], input)){
                return true;
            }
        }
        return false;
    }

    public static void addData(String username, String password, String fullname, String file){
        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println(username + "," + password + "," + fullname);
            pw.flush();
            pw.close();

            System.out.println("success");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
        System.out.println(login("Ryan"));
        addData("HOLA", "mypassword", "HOLALA", "users.csv");
        System.out.println(login("HOLA"));
    }
}
