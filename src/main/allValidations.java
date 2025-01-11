import java.io.*;
public class allValidations {
    public static boolean isValidEmail(String email) {
        return email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
    }
    public static boolean isValidPassword(String password) {
        return password.length() >= 6;
    }
    public static boolean isValidName(String name) {
        return name.matches("[a-zA-Z ]+");
    }
    public static boolean isValidAge(String age) {
        return age.matches("\\d+");
    }
    public static boolean isValidContactNumber(String contactNumber) {
        return contactNumber.matches("\\d+");
    }
    public static boolean isEmailRegistered(String email, File file) {
        try {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder jsonData = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            jsonData.append(line.trim());
        }
        reader.close();
        String data = jsonData.toString().trim();
        if (data.startsWith("[") && data.endsWith("]")) {
            data = data.substring(1, data.length() - 1);
            String[] userObjects = data.split("},\\s*\\{");

            for (String userObject : userObjects) {
                if (!userObject.startsWith("{")) {
                    userObject = "{" + userObject;
                }
                if (!userObject.endsWith("}")) {
                    userObject = userObject + "}";
                }

                //! Check for the email key and value
                if (userObject.contains("\"email\"")) {
                    String[] parts = userObject.split("\"email\"\\s*:\\s*\"");
                    if (parts.length > 1) {
                        String extractedEmail = parts[1].split("\"")[0];
                        if (extractedEmail.equals(email)) {
                            return true; //! Email is already registered
                        }
                    }
                }
            }
        }
    } catch (IOException ex) {
        ex.printStackTrace();
    }
    return false; //! Email not found
    }

    public static boolean isUserRegistered(String email, String password, File file) {
        try {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder jsonData = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            jsonData.append(line.trim());
        }
        reader.close();
        String data = jsonData.toString().trim();
        if (data.startsWith("[") && data.endsWith("]")) {
            data = data.substring(1, data.length() - 1);
            String[] userObjects = data.split("},\\s*\\{");

            for (String userObject : userObjects) {
                if (!userObject.startsWith("{")) {
                    userObject = "{" + userObject;
                }
                if (!userObject.endsWith("}")) {
                    userObject = userObject + "}";
                }

                //! Check for the email key and value
                if (userObject.contains("\"email\"")) {
                    String[] parts = userObject.split("\"email\"\\s*:\\s*\"");
                    if (parts.length > 1) {
                        String extractedEmail = parts[1].split("\"")[0];
                        if (extractedEmail.equals(email)) {
                            //! Check for the password key and value
                            if (userObject.contains("\"password\"")) {
                                String[] parts2 = userObject.split("\"password\"\\s*:\\s*\"");
                                if (parts2.length > 1) {
                                    String extractedPassword = parts2[1].split("\"")[0];
                                    if (extractedPassword.equals(password)) {
                                        return true; //! Email and password match
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    } catch (IOException ex) {
        ex.printStackTrace();
    }
    return false; //! Email and password do not match
    }
}