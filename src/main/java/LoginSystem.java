import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class LoginSystem {

    public static boolean login(String input) throws IOException {
        String path = "D:\\Study (University of Toronto)\\Second year 1\\CSC207\\course-project-happy207\\src\\main\\users.csv";

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

    public static void main(String[] args) throws IOException {
        System.out.println(login("UserName"));
    }
}
