import java.util.List;

class User {
    String username;
    String password;
    String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}

public class SILab2 {

    public boolean function (User user, List<String> allUsers) {
        String specialCharacters="!#$%&'()*+,-./:;<=>?@[]^_`{|}"; //A
        if (user==null) {//B
            throw new RuntimeException("The user is not instantiated");//C
        }
        if (user.getUsername()==null || user.getPassword()==null)//D
            throw new RuntimeException("The user is missing some mandatory information");//E
        String password = user.getPassword();//F
        String passwordLower = password.toLowerCase();//G	
        if (passwordLower.contains(user.getUsername().toLowerCase())) { //H
            return false;//J
        }
        else if (passwordLower.length()<8)//K
            return false;//L
        else {//M
            boolean digit = false, upper = false, special = false;//N

            for (int i=0;i<password.length();i++) {//O
                if (Character.isDigit(password.charAt(i)))//P
                    digit = true;//R
                if (Character.isUpperCase(password.charAt(i)))//S
                    upper = true;//T
                if (specialCharacters.contains(String.valueOf(password.charAt(i))))//W
                    special = true;//W
            }
            if (!digit || !upper || !special)//X
                return false;//Y
        }
        return true;//Z
    } //END
}