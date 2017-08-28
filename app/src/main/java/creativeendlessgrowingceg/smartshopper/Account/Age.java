package creativeendlessgrowingceg.smartshopper.Account;

import android.widget.TextView;

import creativeendlessgrowingceg.smartshopper.R;

/**
 * Created by Enathen on 2017-08-10.
 */

public class Age {
    private int age;

    public Age(int age) {
        this.age = age;
    }

    public boolean checkAge(TextView Age) {
        Age.setText(R.string.ageCreate);
        if (age < 13) {
            Age.setText(R.string.errorAge);
            return false;
        }
        return true;
    }
}
