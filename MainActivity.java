package com.example.daniel.koerelogbogapp;

import android.app.FragmentManager;
import android.app.LoaderManager;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SimpleCursorAdapter;


public class MainActivity extends ActionBarActivity implements NavigationDrawerFragment.NavigationDrawerCallbacks, LoaderManager.LoaderCallbacks<Cursor> {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;
    private ViewEntriesFragment viewEntriesFragment;
    private MyCursorLoader myCursorLoader;
    private SimpleCursorAdapter simpleCursorAdapter;
    private static DatabaseHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_with_ndrawer);
        myCursorLoader = new MyCursorLoader(MyApp.mAppContext, DatabaseHandler.CONTENT_URI_ENTRIES, null, null, null, null);
        handler = new DatabaseHandler(MyApp.mAppContext);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        viewEntriesFragment = new ViewEntriesFragment();

        //Indsaetter fragmentet i den primaere fragment container
        getFragmentManager().beginTransaction().replace(R.id.mainFragmentContainer, viewEntriesFragment);

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(R.id.navigation_drawer,(DrawerLayout) findViewById(R.id.drawer_layout));

        simpleCursorAdapter = new MyCursorAdapter(this, R.layout.list_item, null, DatabaseHandler.TABLE_COLUMNS, new int[]{R.id.dateDriven, R.id.description,R.id.distanceDriven, R.id.driversName, R.id.carsLicensePlate}, 0);
        viewEntriesFragment.setListAdapter(simpleCursorAdapter);
        getLoaderManager().initLoader(0, null, this);

    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getFragmentManager();
        if(position == 1){
            fragmentManager.beginTransaction().replace(R.id.mainFragmentContainer, viewEntriesFragment).commit();
        } else if (position == 2){
            CreateEntryFragment c = new CreateEntryFragment();
            c.setActivity(this);
            fragmentManager.beginTransaction().replace(R.id.mainFragmentContainer, c).commit();
        } else if (position == 3){
            //TODO make this go to detailView
//            Fragment fragment =
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        myCursorLoader = new MyCursorLoader(MyApp.mAppContext, DatabaseHandler.CONTENT_URI_ENTRIES, null, null, null, null);
        getLoaderManager().restartLoader(0, null, MainActivity.this);
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);
                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                break;
            case 3:
                mTitle = getString(R.string.title_section3);
                break;
        }
    }

    public void setFragmentToViewEntries(){
        getFragmentManager().beginTransaction().replace(R.id.mainFragmentContainer, viewEntriesFragment);
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main_activity_with_ndrawer, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
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
    public Loader onCreateLoader(int id, Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> cursorLoader, Cursor cursor) {
        simpleCursorAdapter.swapCursor(cursor);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> cursorLoader) {
        simpleCursorAdapter.swapCursor(null);
    }

    private static class MyCursorLoader extends CursorLoader {


        public MyCursorLoader(Context context) {
            super(context);
        }

        public MyCursorLoader(Context context, Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
            super(context, uri, projection, selection, selectionArgs, sortOrder);
        }

        @Override
        public Cursor loadInBackground() {

            String groupBy = null;
            String having = null;

            SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();


            String tables = DatabaseHandler.TABLE_NAME;
            queryBuilder.setTables(tables);

            return queryBuilder.query(handler.db, getProjection(), getSelection(), getSelectionArgs(), groupBy, having,
                    getSortOrder());

        }


    }

}
