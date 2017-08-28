package creativeendlessgrowingceg.smartshopper.Activity.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import creativeendlessgrowingceg.smartshopper.Account.Account;
import creativeendlessgrowingceg.smartshopper.Design.GenericOnFocusChange;
import creativeendlessgrowingceg.smartshopper.Design.GenericTextWatcher;
import creativeendlessgrowingceg.smartshopper.R;

public class CreateAccountScreen extends AppCompatActivity {
    private boolean working = true;
    private Account account = new Account();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        setTitle("Register");

        ((EditText)findViewById(R.id.ageTextField)).setText("13");
        findViewById(R.id.passwordDifficultyBarImageView).setVisibility(View.INVISIBLE);
        findViewById(R.id.passwordCorrectDifficultyTextView).setVisibility(View.INVISIBLE);
        findViewById(R.id.usernameImageView).setVisibility(View.INVISIBLE);


        EditText emailTextField = (EditText) findViewById(R.id.emailTextField);

        ImageView emailImageView = (ImageView) findViewById(R.id.emailimageView);
        emailImageView.setVisibility(View.INVISIBLE);


        TextView emailTextView = (TextView) findViewById(R.id.emailTextView);

        //So email check if correct
        GenericOnFocusChange genericOnFocusChange = new GenericOnFocusChange();
        genericOnFocusChange.email(emailTextField, emailImageView, emailTextView);
        GenericTextWatcher genericTextWatcher = new GenericTextWatcher();
        genericTextWatcher.passwordCheck((EditText) findViewById(R.id.passwordTextField),
                (TextView) findViewById(R.id.passwordCorrectDifficultyTextView),
                (ImageView) findViewById(R.id.passwordDifficultyBarImageView));
        genericTextWatcher.ageCheck((EditText) findViewById(R.id.ageTextField));

        //Spinners
        Spinner classificationSpinner = (Spinner) findViewById(R.id.classificationSpinner);
        Spinner genderSpinner = (Spinner) findViewById(R.id.genderSpinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                R.array.classificationSpinnerItems, R.layout.spinner_dropdown);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown);
        classificationSpinner.setAdapter(adapter);
        adapter = ArrayAdapter.createFromResource(this,
                R.array.genderSpinnerItems, R.layout.spinner_dropdown);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown);
        genderSpinner.setAdapter(adapter);


        final Button button = (Button) findViewById(R.id.createAccountButton);
        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    button.setBackgroundResource(R.drawable.bluebutton);
                    account.setEmail(emailTextField.getText().toString());
                    if(((EditText) findViewById(R.id.ageTextField)).getText().toString().length() > 0){
                        account.setAge(Integer.valueOf(((EditText) findViewById(R.id.ageTextField)).getText().toString()));
                    }
                    account.setClassification(((Spinner) findViewById(R.id.classificationSpinner)).getSelectedItem().toString());
                    account.setGender(((Spinner) findViewById(R.id.genderSpinner)).getSelectedItem().toString());
                    account.setFirstName(((EditText) findViewById(R.id.firstNameTextField)).getText().toString());
                    account.setLastName(((EditText) findViewById(R.id.lastNameTextField)).getText().toString());
                    account.setPassword(((EditText) findViewById(R.id.passwordTextField)).getText().toString());
                    account.setUsername(((EditText) findViewById(R.id.usernameTextField)).getText().toString());

                    boolean open = account.checkAge((TextView) findViewById(R.id.ageTextView));
                    if(!open){
                        working = false;

                    }
                    open = account.checkEmail((TextView) findViewById(R.id.emailTextView));
                    if(!open){
                        working = false;
                    }
                    open = account.checkFirstName((TextView) findViewById(R.id.firstNameTextview));
                    if(!open){
                        working = false;

                    }
                    open = account.checkLastName((TextView) findViewById(R.id.lastNameTextView));
                    if(!open){
                        working = false;

                    }
                    open = account.checkPassword((TextView) findViewById(R.id.passwordTextView));
                    if(!open){
                        working = false;
                    }
                    open = account.checkUsername((TextView) findViewById(R.id.usernameTextView));
                    if(!open){
                        working = false;
                    }

                    CheckBox checkBox = ((CheckBox) findViewById(R.id.olderCheckBox));
                    if (!checkBox.isChecked()) {
                        working = false;
                    }

                    if (working) {
                        account.createAccount();
                        startActivity(new Intent(CreateAccountScreen.this, LoginScreen.class));

                    }
                }

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    button.setBackgroundResource(R.drawable.bluebuttonclicked);
            }
                return false;
            }
        });

    }
}
