package creativeendlessgrowingceg.smartshopper;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import creativeendlessgrowingceg.smartshopper.Account.Password;

/**
 * Created by Enathen on 2017-07-20.
 */

public class GenericTextWatcher {
    private String passwordString = "";

    /**
     * If new character getting entered check if password is good enough!
     *
     * @param passwordText
     * @param passwordCorrectDifficultyTextView
     * @param passwordDifficultyBarImageView
     */
    public void passwordCheck(EditText passwordText, TextView passwordCorrectDifficultyTextView,
                              ImageView passwordDifficultyBarImageView) {
        Password password = new Password(passwordText.getText().toString());
        passwordText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {
                passwordString = String.valueOf(s);
                if (!s.toString().equals("")) {
                if (s.length() < 8) {
                        passwordCorrectDifficultyTextView.setVisibility(View.VISIBLE);
                        passwordCorrectDifficultyTextView.setText((R.string.passwordDifficulty));
                        passwordDifficultyBarImageView.setVisibility(View.VISIBLE);
                        passwordDifficultyBarImageView.setImageResource(R.drawable.pass0);

                    } else {

                        passwordCorrectDifficultyTextView.setText((R.string.passwordDifficulty2));
                        passwordDifficultyBarImageView.setImageResource(R.drawable.pass1);
                        if (passwordString.matches(".*\\d+.*")) {

                            passwordCorrectDifficultyTextView.setText((R.string.passwordDifficulty3));
                            passwordDifficultyBarImageView.setImageResource(R.drawable.pass2);
                            for (int i = 0; i < passwordString.length(); i++) {
                                if (Character.isUpperCase(passwordString.charAt(i))) {
                                    passwordCorrectDifficultyTextView.setText((R.string.passwordDifficulty4));
                                    passwordDifficultyBarImageView.setImageResource(R.drawable.pass3);
                                    for (int j = 0; j < passwordString.length(); j++) {
                                        if (!Character.isAlphabetic(passwordString.charAt(j))) {
                                            if (!Character.isDigit(passwordString.charAt(j))) {
                                                passwordCorrectDifficultyTextView.setText("");
                                                passwordDifficultyBarImageView.setImageResource(R.drawable.passgold);
                                            }
                                        }
                                    }
                                }
                            }

                        }

                    }
                }
            }
        });
        /**
         * Checks if age is not bigger than 130 years old
         */
    }

    public void ageCheck(EditText age) {
        age.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().equals("")) {
                    if (Integer.parseInt(s.toString()) > 130) {
                        s.replace(0, s.length(), "130", 0, 3);
                    }
                    if (Integer.parseInt(s.toString()) < 1) {
                        s.replace(0, s.length(), "1", 0, 1);
                    }
                }


            }
        });
    }

}
