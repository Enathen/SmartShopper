package creativeendlessgrowingceg.smartshopper;

import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

/**
 * Created by Enathen on 2017-07-16.
 */

public class Design {
    public void Design() {

    }

    public void buttonToAnotherActivity(final View buttonView, final int buttonPressed,
                                        final int buttonClicked, final Context baseContext,
                                        final Intent intent) {
        final Button button = (Button) buttonView;
        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    button.setBackgroundResource(buttonPressed);
                    baseContext.startActivity(intent);
                }
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    button.setBackgroundResource(buttonClicked);
                }
                return false;
            }
        });
    }
    public void buttonToAnotherDialog(final View buttonView, final int buttonPressed,
                                        final int buttonClicked, final Context baseContext,
                                        final Intent intent) {
        final Button button = (Button) buttonView;
        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    button.setBackgroundResource(buttonPressed);
                    baseContext.startActivity(intent);
                }
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    button.setBackgroundResource(buttonClicked);
                }
                return false;
            }
        });
    }

}
