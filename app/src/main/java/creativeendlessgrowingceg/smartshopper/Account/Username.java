package creativeendlessgrowingceg.smartshopper.Account;

import android.widget.TextView;

import java.sql.SQLException;

import creativeendlessgrowingceg.smartshopper.R;

/**
 * Username Account class To check if username is correct.
 * Created by Enathen on 2017-05-31.
 */
public class Username {

    private String username;

    public Username(String username) {
        this.username = username;
    }

    /**
     * Convert the username to correct format capital letter front rest not capital
     *
     * @return
     */
    public String userNameCorrect() {
        String string = username;
        String backupString;
        backupString = string.substring(0, 1).toUpperCase();
        string = backupString + string.substring(1).toLowerCase();
        return string;

    }


    /**
     * Check if username already exist in database
     *
     * @return true if there already exist a user false if no user exist.
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public boolean checkIfUsernameExistInDatabase() {


        return false;
    }

    /**
     * Check if username is appropriate
     * @param username
     * @return
     */
    public boolean checkUsername(TextView username) {
        username.setText(R.string.usernameCreate);
        if (checkIfUsernameExistInDatabase()) {
            username.setText(R.string.errorUsernameExist);
            return false;
        }
        if (this.username.length() < 6) {
            username.setText(R.string.errorUsernameShort);
            return false;
        }
        if (this.username.length() > 50) {
            username.setText(R.string.errorUsernameLong);
            return false;
        }
        return true;
    }
}
