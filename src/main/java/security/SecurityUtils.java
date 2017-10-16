package security;

import org.mindrot.jbcrypt.BCrypt;

public class SecurityUtils {

    // Define the BCrypt workload to use when generating password hashes. 10-31 is a valid value.
    private static int workload = 12;

    public static String hashPassword(String passwordPlain) {

        String salt = BCrypt.gensalt(workload);
        String passwordHash = BCrypt.hashpw(passwordPlain, salt);

        return passwordHash;
    }

    public static boolean checkPassword(String passwordPlain, String passwordHash) {
        boolean password_verified = false;

        if(passwordHash == null || !passwordHash.startsWith("$2a$"))
            throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");

        password_verified = BCrypt.checkpw(passwordPlain, passwordHash);

        return password_verified;
    }

}
