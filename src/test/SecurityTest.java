import com.lhb.sh.util.Security;

public class SecurityTest {
    public static void main(String[] args) {
        String realPassword = Security.encode("ss", "aa");
        System.out.println(realPassword);

    }
}
