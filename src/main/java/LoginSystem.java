import java.io.*;
import java.util.Objects;

public class LoginSystem {

    /**
     *
     * @param username With the given file, check if the username exists or not.
     * @return return true it username exist, return false otherwise.
     * @throws IOException throws exception if error occurs during file reading.
     */
    public static boolean checkUsername(String username) throws IOException {
        String path = "users.csv";

        BufferedReader br =new BufferedReader(new FileReader(path));
        String line = br.readLine();

        while ((line = br.readLine()) != null){
            String[] data = line.split(",");
            if (Objects.equals(data[0], username)){
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param username New username
     * @param password Password that matches the new username
     * @param fullName fullName of this user with username
     * @param file  data file that stores all users.
     */
    public static void addData(String username, String password, String fullName, String file){
        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println(username + "," + password + "," + fullName);
            pw.flush();
            pw.close();
            System.out.println("success");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
        System.out.println(checkUsername("Ryan"));
        addData("HOLA", "mypassword", "HOLALA", "users.csv");
        System.out.println(checkUsername("HOLA"));
    }
}
