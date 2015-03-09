package gasparv.proyectoconfig_villafane;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class StartScreen extends ActionBarActivity {
    protected SharedPreferences mSharedPreferences;
    protected StartScreen mMainActivity = this;
    protected String sname="";
    protected String sage="";
    protected String sgenre="";
    TextView name,age,genre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        name = (TextView) findViewById(R.id.textView4);
        age = (TextView) findViewById(R.id.textView5);
        genre = (TextView) findViewById(R.id.textView6);
        if(this.getIntent().getExtras()!=null) {
            Bundle newB=this.getIntent().getExtras();
            name.setText(newB.getString("nom_key"));
            age.setText(newB.getString("edad_key"));
            genre.setText(newB.getString("genero_key"));
        }
    }
    //@Override
    /*protected void onDestroy(){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mMainActivity.getApplicationContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString8(sname, name.getText().toString());
        editor.putString(sage, age.getText().toString());
        editor.putString(sgenre,genre.getText().toString());
        editor.commit();
    }*/
    public void onBackPressed(){
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_start_screen, menu);
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
            Intent intent=new Intent(this,SettingsActivity.class);
            startActivity(intent);
            return true;

        }

        return super.onOptionsItemSelected(item);
    }
}
