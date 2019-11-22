package interactivebook.conte.com.br.interactivebookapp.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import interactivebook.conte.com.br.interactivebookapp.R;
import interactivebook.conte.com.br.interactivebookapp.control.LobbyControl;

public class LobbyActivity extends Activity implements NavigationView.OnNavigationItemSelectedListener{

    private LobbyControl lobbyControl;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);

        this.lobbyControl = new LobbyControl(this);
        this.drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        navigationView = (NavigationView) findViewById(R.id.navView);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.nav_item_one: {
                lobbyControl.configActivityAction();
                break;
            }
            case R.id.nav_item_two: {
                this.finish();
                break;
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }
}
