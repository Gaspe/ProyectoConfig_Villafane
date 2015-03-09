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

    TextView name,age,genre;
    protected StartScreen mMainActivity = this;
    protected SharedPreferences mSharedPreferences;
    protected String skey = "";
    protected String skey2="";
    protected String skey3="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        name = (TextView) findViewById(R.id.nombre2);
        age = (TextView) findViewById(R.id.edad2);
        genre = (TextView) findViewById(R.id.genero2);
        if(this.getIntent().getExtras()!=null) {
            Bundle newB=this.getIntent().getExtras();
            name.setText(newB.getString("nom_key"));
            age.setText(newB.getString("edad_key"));
            genre.setText(newB.getString("genero_key"));
        }
        else{
            mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            String text = mSharedPreferences.getString(skey, "");
            String text1 = mSharedPreferences.getString(skey2, "");
            String text2 = mSharedPreferences.getString(skey3, "");
            name.setText(text);
            age.setText(text1);
            genre.setText(text2);

        }
    }

    protected void onDestroy(){
        super.onDestroy();
        name = (TextView) findViewById(R.id.nombre2);
        age = (TextView) findViewById(R.id.edad2);
        genre = (TextView) findViewById(R.id.genero2);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mMainActivity.getApplicationContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(skey, name.getText().toString());
        editor.commit();
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
            finish();
            return true;

        }

        return super.onOptionsItemSelected(item);
    }
}
