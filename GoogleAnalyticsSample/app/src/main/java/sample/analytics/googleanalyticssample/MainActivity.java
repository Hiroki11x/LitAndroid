package sample.analytics.googleanalyticssample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import com.google.analytics.tracking.android.EasyTracker;

public class MainActivity extends ActionBarActivity implements OnClickListener{
    private TextView textView[] = new TextView[7];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int i =0;i<7;i++){
            String resId=String.format("%02d", i+1);
            textView[i]=(TextView)findViewById(getResources().getIdentifier("textView"+resId , "id" , getPackageName()));
            textView[i].setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        for(int i =0;i<7;i++){
            if(view==textView[i]){
                Toast.makeText(this, "TextView0"+(i+1)+"が押されました", Toast.LENGTH_LONG).show();

                // Get tracker.
                //Tracker t = ((AnalyticsSampleApp)this.getApplication()).getTracker(AnalyticsSampleApp.TrackerName.APP_TRACKER);

                // Set screen name.
                // Where path is a String representing the screen name.
                //t.setScreenName("path");

                // Send a screen view.
                //t.send(new HitBuilders.AppViewBuilder().build());
            }
        }
        return ;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onStart() {
        super.onStart();
        EasyTracker.getInstance(this).activityStart(this);
    }
    @Override
    public void onStop() {
        super.onStop();
        EasyTracker.getInstance(this).activityStop(this);
    }
}
