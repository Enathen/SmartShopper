package creativeendlessgrowingceg.smartshopper.Activity.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import creativeendlessgrowingceg.smartshopper.Account.Account;
import creativeendlessgrowingceg.smartshopper.Activity.Login.Start.MainStartSide;
import creativeendlessgrowingceg.smartshopper.Design;
import creativeendlessgrowingceg.smartshopper.R;

public class LoginScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login_screen);
        Design design = new Design();
        final Account account = new Account();
        final Button button = (Button) findViewById(R.id.loginButton);
        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    button.setBackgroundResource(R.drawable.bluebutton);
                    if (true) {
                        startActivity(new Intent(LoginScreen.this, MainStartSide.class));
                    }
                }
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    button.setBackgroundResource(R.drawable.bluebuttonclicked);

                }


                return false;
            }
        });


        design.buttonToAnotherActivity(findViewById(R.id.forgotPasswordButton),
                R.drawable.bluebutton, R.drawable.bluebuttonclicked, getBaseContext(),
                new Intent(this, ForgotPasswordScreen.class));

        design.buttonToAnotherActivity(findViewById(R.id.createAccount),
                R.drawable.greybutton, R.drawable.greybuttonclicked, getBaseContext(),
                new Intent(this, CreateAccountScreen.class));

        design.buttonToAnotherActivity(findViewById(R.id.menuButton),
                R.drawable.cogwheel, R.drawable.cogwheel, getBaseContext(),
                new Intent(this, MenuScreen.class));
    }

}
