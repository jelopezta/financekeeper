package com.divdev.financekeeper.presentation.activities;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.divdev.financekeeper.FinanceKeeperApplication;
import com.divdev.financekeeper.R;
import com.divdev.financekeeper.core.persistence.PersistenceSystem;
import com.divdev.financekeeper.core.persistence.model.FinanceNode;
import com.divdev.financekeeper.core.utils.CoreUtilities;
import com.divdev.financekeeper.presentation.adapters.FinanceNodeMainListAdapter;
import com.divdev.financekeeper.presentation.adapters.OperationListAdapter;
import com.divdev.financekeeper.presentation.dialogs.OperationListFragment;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;

public class FinanceKeeperMainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finance_keeper_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DialogFragment newFragment = new OperationListFragment();
                newFragment.show(getFragmentManager(), "operations");
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle drawerListener = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(drawerListener);
        drawerListener.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Initialize recycler view
        RecyclerView recyclerViewList = (RecyclerView) findViewById(R.id.financenode_main_list);
        recyclerViewList.setLayoutManager(new LinearLayoutManager(this));

        final FinanceKeeperApplication application = (FinanceKeeperApplication) this.getApplication();
        final List<FinanceNode> financeNodeListCache = PersistenceSystem.getInstance().getFinanceNodeListCache();
        recyclerViewList.setAdapter(new FinanceNodeMainListAdapter(financeNodeListCache));

        BigDecimal totalBalance = CoreUtilities.getMainFinanceNodesTotal(financeNodeListCache);
        TextView financeNodeTotalBalance = (TextView) findViewById(R.id.main_list_totalBalance);
        final NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
        financeNodeTotalBalance.setText(currencyInstance.format(totalBalance));
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.add_finance_node_menu_item) {

        } else if (id == R.id.remove_finance_node_menu_item) {

        } else if (id == R.id.add_tag_menu_item) {

        } else if (id == R.id.settings_menu_item) {

        } else if (id == R.id.nav_view_reports) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
