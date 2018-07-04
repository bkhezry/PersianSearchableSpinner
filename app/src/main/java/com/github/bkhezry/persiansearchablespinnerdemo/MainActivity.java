package com.github.bkhezry.persiansearchablespinnerdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.github.bkhezry.persiansearchablespinnerdemo.adapter.PersonListAdapter;
import com.github.bkhezry.persiansearchablespinnerdemo.adapter.StringListAdapter;
import com.github.bkhezry.persiansearchablespinnerdemo.model.Person;
import com.github.bkhezry.searchablespinner.SearchableSpinner;
import com.github.bkhezry.searchablespinner.interfaces.IStatusListener;
import com.github.bkhezry.searchablespinner.interfaces.OnItemSelectedListener;

import java.util.ArrayList;
import java.util.Collections;

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
  private StringListAdapter mStringListAdapter;
  private ArrayList<String> mStrings = new ArrayList<>();
  private PersonListAdapter mPersonListAdapter;
  private ArrayList<Person> mPersons = new ArrayList<>();
  private boolean isSpinnerOpen = false;
  private String[] names = {
    "پاتریک درآواکیانس",
    "جاوید ایزدفر",
    "امین خلیقی",
    "رضا محمدی",
    "الی باگی",
    "الهام عمیدی",
    "وجیهه اشکبار",
    "مسعود صادری",
    "مسعود فاطمی",
    "محسن براتی",
    "بارسین علی‌محمدی",
    "توحید ارسطو",
    "بابای بیتا",
    "امیر حبیب‌زاده",
    "حسین رونقی",
    "علی عبدالهی",
    "علی برهانی",
    "عباس اویسی",
    "نوید کاشانی",
    "ایلیا وکیلی",
    "حورا وکیلی",
    "احمد طحانی",
    "مهدی علیپور",
    "پیمان اسکندری",
    "بهروز خضری"
  };
  private String[] emails = {
    "aardo@yahoo.ca",
    "mfburgo@icloud.com",
    "solomon@me.com",
    "aegreene@gmail.com",
    "horrocks@live.com",
    "naoya@msn.com",
    "smeier@msn.com",
    "jadavis@sbcglobal.net",
    "earmstro@mac.com",
    "mirod@hotmail.com",
    "marioph@me.com",
    "rohitm@sbcglobal.net",
    "cparis@msn.com",
    "eegsa@comcast.net",
    "pappp@att.net",
    "fatelk@mac.com",
    "mallanmba@msn.com",
    "samavati@att.net",
    "gtaylor@hotmail.com",
    "tamas@hotmail.com",
    "bsikdar@verizon.net",
    "lukka@me.com",
    "stinson@aol.com",
    "mcrawfor@optonline.net",
    "matloff@me.com"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    initStringListValues();
    mStringListAdapter = new StringListAdapter(this, mStrings, "DroidNaskh-Regular.ttf");

    searchableSpinner.setFontName("DroidNaskh-Regular.ttf");
    searchableSpinner.setAdapter(mStringListAdapter);
    searchableSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
      @Override
      public void onItemSelected(View view, int position, long id) {
        Toast.makeText(MainActivity.this, "Item on position " + position + " : " + mStringListAdapter.getItem(position) + " Selected", Toast.LENGTH_LONG).show();
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
      }

      @Override
      public void spinnerIsClosing() {
        isSpinnerOpen = false;
      }
    });
    initPersonListValues();
    mPersonListAdapter = new PersonListAdapter(this, mPersons, "DroidNaskh-Regular.ttf");
    searchableSpinner1.setAdapter(mPersonListAdapter);
    searchableSpinner1.setOnItemSelectedListener(new OnItemSelectedListener() {
      @Override
      public void onItemSelected(View view, int position, long id) {
        Toast.makeText(MainActivity.this, "Item on position " + position + " : " + mPersonListAdapter.getItem(position).toString() + " Selected", Toast.LENGTH_LONG).show();
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
    return super.onTouchEvent(event);
  }

  private void initStringListValues() {
    Collections.addAll(mStrings, names);
  }

  private void initPersonListValues() {
    for (int i = 0; i < emails.length; i++) {
      Person person = new Person();
      person.setId((long) i);
      person.setName(names[i]);
      person.setEmail(emails[i]);
      mPersons.add(person);
    }
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
      startActivity(new Intent(this, AboutActivity.class));
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
    } else {
      super.onBackPressed();
    }
  }
}
