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

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {

  @BindView(R.id.toolbar)
  Toolbar toolbar;
  @BindView(R.id.searchable_spinner)
  SearchableSpinner searchableSpinner;
  @BindView(R.id.searchable_spinner1)
  SearchableSpinner searchableSpinner1;
  @BindView(R.id.searchable_spinner2)
  SearchableSpinner searchableSpinner2;
  @BindView(R.id.searchable_spinner3)
  SearchableSpinner searchableSpinner3;
  private SimpleListAdapter mSimpleListAdapter;
  private SimpleArrayListAdapter mSimpleArrayListAdapter;
  private final ArrayList<String> mStrings = new ArrayList<>();
  private boolean isSpinnerOpen = false;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    initListValues();
    mSimpleListAdapter = new SimpleListAdapter(this, mStrings, "DroidNaskh-Regular.ttf");
    mSimpleArrayListAdapter = new SimpleArrayListAdapter(this, mStrings, "DroidNaskh-Regular.ttf");

    searchableSpinner.setFontName("DroidNaskh-Regular.ttf");
    searchableSpinner.setAdapter(mSimpleArrayListAdapter);
    searchableSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
      @Override
      public void onItemSelected(View view, int position, long id) {
        Toast.makeText(MainActivity.this, "Item on position " + position + " : " + mSimpleArrayListAdapter.getItem(position) + " Selected", Toast.LENGTH_SHORT).show();
      }

      @Override
      public void onNothingSelected() {

      }
    });
    searchableSpinner.setStatusListener(new IStatusListener() {
      @Override
      public void spinnerIsOpening() {
        isSpinnerOpen = true;
        searchableSpinner1.hideEdit();
        searchableSpinner2.hideEdit();
        searchableSpinner3.hideEdit();
      }

      @Override
      public void spinnerIsClosing() {
        isSpinnerOpen = false;
      }
    });

    searchableSpinner1.setAdapter(mSimpleListAdapter);
    searchableSpinner1.setOnItemSelectedListener(new OnItemSelectedListener() {
      @Override
      public void onItemSelected(View view, int position, long id) {
        Toast.makeText(MainActivity.this, "Item on position " + position + " : " + mSimpleListAdapter.getItem(position) + " Selected", Toast.LENGTH_SHORT).show();
      }

      @Override
      public void onNothingSelected() {

      }
    });
    searchableSpinner1.setStatusListener(new IStatusListener() {
      @Override
      public void spinnerIsOpening() {
        isSpinnerOpen = true;
        searchableSpinner.hideEdit();
        searchableSpinner2.hideEdit();
        searchableSpinner3.hideEdit();
      }

      @Override
      public void spinnerIsClosing() {
        isSpinnerOpen = false;
      }
    });

    searchableSpinner2.setAdapter(mSimpleListAdapter);
    searchableSpinner2.setOnItemSelectedListener(new OnItemSelectedListener() {
      @Override
      public void onItemSelected(View view, int position, long id) {
        Toast.makeText(MainActivity.this, "Item on position " + position + " : " + mSimpleListAdapter.getItem(position) + " Selected", Toast.LENGTH_SHORT).show();
      }

      @Override
      public void onNothingSelected() {

      }
    });
    searchableSpinner2.setStatusListener(new IStatusListener() {
      @Override
      public void spinnerIsOpening() {
        isSpinnerOpen = true;
        searchableSpinner.hideEdit();
        searchableSpinner1.hideEdit();
        searchableSpinner3.hideEdit();
      }

      @Override
      public void spinnerIsClosing() {
        isSpinnerOpen = false;
      }
    });

    searchableSpinner3.setAdapter(mSimpleListAdapter);
    searchableSpinner3.setOnItemSelectedListener(new OnItemSelectedListener() {
      @Override
      public void onItemSelected(View view, int position, long id) {
        Toast.makeText(MainActivity.this, "Item on position " + position + " : " + mSimpleListAdapter.getItem(position) + " Selected", Toast.LENGTH_SHORT).show();
      }

      @Override
      public void onNothingSelected() {

      }
    });
    searchableSpinner3.setStatusListener(new IStatusListener() {
      @Override
      public void spinnerIsOpening() {
        isSpinnerOpen = true;
        searchableSpinner.hideEdit();
        searchableSpinner1.hideEdit();
        searchableSpinner2.hideEdit();
      }

      @Override
      public void spinnerIsClosing() {
        isSpinnerOpen = false;
      }
    });
  }

  @Override
  public boolean onTouchEvent(MotionEvent event) {
    if (!searchableSpinner.isInsideSearchEditText(event)) {
      searchableSpinner.hideEdit();
    }
    if (!searchableSpinner1.isInsideSearchEditText(event)) {
      searchableSpinner1.hideEdit();
    }
    if (!searchableSpinner2.isInsideSearchEditText(event)) {
      searchableSpinner2.hideEdit();
    }
    if (!searchableSpinner3.isInsideSearchEditText(event)) {
      searchableSpinner3.hideEdit();
    }
    return super.onTouchEvent(event);
  }

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
    mStrings.add("احمد طحانی");
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
    if (id == R.id.action_about) {

      return true;
    }

    return super.onOptionsItemSelected(item);
  }

  @Override
  protected void attachBaseContext(Context newBase) {
    super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
  }

  @Override
  public void onBackPressed() {
    if (isSpinnerOpen) {
      searchableSpinner.hideEdit();
      searchableSpinner1.hideEdit();
      searchableSpinner2.hideEdit();
      searchableSpinner3.hideEdit();
    } else {
      super.onBackPressed();
    }
  }
}
