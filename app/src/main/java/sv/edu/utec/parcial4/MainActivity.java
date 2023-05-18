package sv.edu.utec.parcial4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import sv.edu.utec.parcial4.BD.BDHelper;

public class MainActivity extends AppCompatActivity {

    DrawerLayout dl;
    Toolbar tlB;
    NavigationView navV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tlB = findViewById(R.id.toolbar);
        dl = findViewById(R.id.drawerLayout);
        navV = findViewById(R.id.navigator);

        ActionBarDrawerToggle toggle =new ActionBarDrawerToggle(this,dl,tlB,R.string.open,R.string.close);
        dl.addDrawerListener(toggle);
        toggle.syncState();
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white,null));



        navV.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.add:
                        dl.closeDrawer(GravityCompat.START);
                        fragmentosDC(new FragmentAdd());
                        break;

                    case R.id.delete:
                        dl.closeDrawer(GravityCompat.START);
                        fragmentosDC(new FragmentDelete());
                        break;

                    case R.id.edit:
                        dl.closeDrawer(GravityCompat.START);
                        fragmentosDC(new FragmentEdit());
                        break;

                    case R.id.update:
                        dl.closeDrawer(GravityCompat.START);
                        fragmentosDC(new FragmentUpdate());
                        break;
                }


                return true;
            }
        });
    }

    private void fragmentosDC(Fragment fragment){
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frmLayoutContenedor,fragment);
        fragmentTransaction.commit();

    }
}