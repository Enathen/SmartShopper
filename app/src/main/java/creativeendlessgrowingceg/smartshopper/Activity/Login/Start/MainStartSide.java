package creativeendlessgrowingceg.smartshopper.Activity.Login.Start;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import creativeendlessgrowingceg.smartshopper.R;

public class MainStartSide extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_start_side);

    }
}
