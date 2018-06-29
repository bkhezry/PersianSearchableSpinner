package com.github.bkhezry.persiansearchablespinnerdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.github.bkhezry.searchablespinner.SearchableSpinner;
import com.github.bkhezry.searchablespinner.interfaces.IStatusListener;
import com.github.bkhezry.searchablespinner.interfaces.OnItemSelectedListener;

import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {

  private SearchableSpinner mSearchableSpinner;
  private SearchableSpinner mSearchableSpinner1;
  private SearchableSpinner mSearchableSpinner2;
  private SearchableSpinner mSearchableSpinner3;
  private SimpleListAdapter mSimpleListAdapter;
  private SimpleArrayListAdapter mSimpleArrayListAdapter;
  private final ArrayList<String> mStrings = new ArrayList<>();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    initListValues();
    mSimpleListAdapter = new SimpleListAdapter(this, mStrings, "DroidNaskh-Regular.ttf");
    mSimpleArrayListAdapter = new SimpleArrayListAdapter(this, mStrings, "DroidNaskh-Regular.ttf");

    mSearchableSpinner = findViewById(R.id.SearchableSpinner);
    mSearchableSpinner.setFontName("DroidNaskh-Regular.ttf");
    mSearchableSpinner.setAdapter(mSimpleArrayListAdapter);
    mSearchableSpinner.setOnItemSelectedListener(mOnItemSelectedListener);
    mSearchableSpinner.setStatusListener(new IStatusListener() {
      @Override
      public void spinnerIsOpening() {
        mSearchableSpinner1.hideEdit();
        mSearchableSpinner2.hideEdit();
      }

      @Override
      public void spinnerIsClosing() {

      }
    });

    mSearchableSpinner1 = findViewById(R.id.SearchableSpinner1);
    mSearchableSpinner1.setAdapter(mSimpleListAdapter);
    mSearchableSpinner1.setOnItemSelectedListener(mOnItemSelectedListener);
    mSearchableSpinner1.setStatusListener(new IStatusListener() {
      @Override
      public void spinnerIsOpening() {
        mSearchableSpinner.hideEdit();
        mSearchableSpinner2.hideEdit();
      }

      @Override
      public void spinnerIsClosing() {

      }
    });

    mSearchableSpinner2 = findViewById(R.id.SearchableSpinner2);
    mSearchableSpinner2.setAdapter(mSimpleListAdapter);
    mSearchableSpinner2.setOnItemSelectedListener(mOnItemSelectedListener);
    mSearchableSpinner2.setStatusListener(new IStatusListener() {
      @Override
      public void spinnerIsOpening() {
        mSearchableSpinner.hideEdit();
        mSearchableSpinner1.hideEdit();
      }

      @Override
      public void spinnerIsClosing() {

      }
    });

    mSearchableSpinner3 = findViewById(R.id.SearchableSpinner3);
    mSearchableSpinner3.setAdapter(mSimpleListAdapter);
    mSearchableSpinner3.setOnItemSelectedListener(mOnItemSelectedListener);
    mSearchableSpinner3.setStatusListener(new IStatusListener() {
      @Override
      public void spinnerIsOpening() {
        mSearchableSpinner.hideEdit();
        mSearchableSpinner3.hideEdit();
      }

      @Override
      public void spinnerIsClosing() {

      }
    });
  }

  @Override
  public boolean onTouchEvent(MotionEvent event) {
    if (!mSearchableSpinner.isInsideSearchEditText(event)) {
      mSearchableSpinner.hideEdit();
    }
    if (!mSearchableSpinner1.isInsideSearchEditText(event)) {
      mSearchableSpinner1.hideEdit();
    }
    if (!mSearchableSpinner2.isInsideSearchEditText(event)) {
      mSearchableSpinner2.hideEdit();
    }
    return super.onTouchEvent(event);
  }

  private OnItemSelectedListener mOnItemSelectedListener = new OnItemSelectedListener() {
    @Override
    public void onItemSelected(View view, int position, long id) {
      Toast.makeText(MainActivity.this, "Item on position " + position + " : " + mSimpleListAdapter.getItem(position) + " Selected", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected() {
      Toast.makeText(MainActivity.this, "Nothing Selected", Toast.LENGTH_SHORT).show();
    }
  };

  private void initListValues() {
    mStrings.add("پاتریک درآواکیانس");
    mStrings.add("جاوید ایزدفر");
    mStrings.add("امین خلیقی");
    mStrings.add("رضا محمدی");
    mStrings.add("الی باگی");
    mStrings.add("الهام عمیدی");
    mStrings.add("وجیهه اشکبار");
    mStrings.add("مسعود صادری");
    mStrings.add("مسعود فاطمی");
    mStrings.add("محسن براتی");
    mStrings.add("بارسین علی‌محمدی");
    mStrings.add("توحید ارسطو");
    mStrings.add("بابای بیتا");
    mStrings.add("امیر حبیب‌زاده");
    mStrings.add("حسین رونقی");
    mStrings.add("علی عبدالهی");
    mStrings.add("علی برهانی");
    mStrings.add("عباس اویسی");
    mStrings.add("نوید کاشانی");
    mStrings.add("ایلیا وکیلی");
    mStrings.add("حورا وکیلی");
    mStrings.add("احمد طحنی");
    mStrings.add("مهدی علیپور");
    mStrings.add("پیمان اسکندری");
    mStrings.add("بهروز خضری");
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
    if (id == R.id.action_reset) {
      mSearchableSpinner.setSelectedItem(0);
      mSearchableSpinner1.setSelectedItem(0);
      mSearchableSpinner2.setSelectedItem(0);
      return true;
    }

    return super.onOptionsItemSelected(item);
  }

  @Override
  protected void attachBaseContext(Context newBase) {
    super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
  }
}
