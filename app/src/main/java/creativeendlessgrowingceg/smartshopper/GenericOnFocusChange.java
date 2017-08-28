package creativeendlessgrowingceg.smartshopper;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import creativeendlessgrowingceg.smartshopper.Account.Email;

/**
 * Created by Enathen on 2017-07-25.
 */

public class GenericOnFocusChange {
    private boolean working = false;

    public boolean email(EditText emailTextField, ImageView emailImageView, TextView emailTextView) {

        emailTextField.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                Email email = new Email(emailTextField.getText().toString());

                if (!hasFocus) {
                    if (email.emailCorrectFormat(emailTextView)) {
                        emailImageView.setVisibility(View.VISIBLE);
                        emailImageView.setImageResource(R.drawable.approvebutton);
                        working = true;
                    } else {
                        emailImageView.setVisibility(View.VISIBLE);
                        emailImageView.setImageResource(R.drawable.dissaprovebutton);
                        working = false;

                    }
                }
            }
        });
        return working;
    }

    public boolean username(EditText usernameTextField, ImageView usernameImageView, TextView usernameTextView) {
        return working;
    }
}
