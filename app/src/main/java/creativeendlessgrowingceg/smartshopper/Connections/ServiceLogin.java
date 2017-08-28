package creativeendlessgrowingceg.smartshopper.Connections;

import android.os.AsyncTask;
import android.util.Log;

public class ServiceLogin extends AsyncTask<String, Void, String> {

    private String res;

    @Override
    protected String doInBackground(String... params) {
        res = null;
        ConnectionClass put = new ConnectionClass();
        put.setParam("firstname", params[0].toString());
        put.setParam("lastname", params[1].toString());
        put.setParam("email", params[2].toString());
        put.setParam("salt", params[3].toString());
        put.setParam("hash", params[4].toString());
        put.setParam("username", params[5].toString());
        put.setParam("age", params[6].toString());
        put.setParam("gender", params[7].toString());
        put.setParam("class", params[8].toString());

        try {
            res = put.postData("http://192.168.1.83/mysqltableAccountInsert.php");
            Log.v("res", res);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;

    }

    protected void onPostExecute(String res) {


    }
}