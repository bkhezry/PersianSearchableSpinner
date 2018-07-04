package com.github.bkhezry.persiansearchablespinnerdemo.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.bkhezry.persiansearchablespinnerdemo.R;
import com.github.bkhezry.persiansearchablespinnerdemo.model.Person;
import com.github.bkhezry.persiansearchablespinnerdemo.util.AppUtils;
import com.github.bkhezry.searchablespinner.interfaces.ISpinnerSelectedView;

import java.util.ArrayList;

public class PersonListAdapter extends BaseAdapter implements Filterable, ISpinnerSelectedView {

  private Typeface mTypeface;
  private Context mContext;
  private ArrayList<Person> mBackupPersons;
  private ArrayList<Person> mPersons;
  private PersonFilter mPersonFilter = new PersonFilter();

  public PersonListAdapter(Context context, ArrayList<Person> persons, String fontName) {
    mContext = context;
    mPersons = persons;
    mBackupPersons = persons;
    if (fontName != null) {
      mTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/" + fontName);
    }
  }

  @Override
  public int getCount() {
    return mPersons == null ? 0 : mPersons.size();
  }

  @Override
  public Person getItem(int position) {
    if (mPersons != null) {
      return mPersons.get(position);
    } else {
      return null;
    }
  }

  @Override
  public long getItemId(int position) {
    if (mPersons != null) {
      return mPersons.get(position).hashCode();
    } else {
      return -1;
    }
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    View view = View.inflate(mContext, R.layout.view_list_item, null);
    ImageView letters = view.findViewById(R.id.letter_image_view);
    TextView displayName = view.findViewById(R.id.display_name_text_view);
    letters.setImageDrawable(AppUtils.getTextDrawable(mContext, mPersons.get(position).getName(), mTypeface));
    displayName.setText(mPersons.get(position).getName());
    return view;
  }

  @Override
  public View getSelectedView(int position) {
    View view = View.inflate(mContext, R.layout.view_list_item, null);
    ImageView letters = view.findViewById(R.id.letter_image_view);
    TextView displayName = view.findViewById(R.id.display_name_text_view);
    letters.setImageDrawable(AppUtils.getTextDrawable(mContext, mPersons.get(position).getName(), mTypeface));
    displayName.setText(mPersons.get(position).getName());
    return view;
  }

  @Override
  public Filter getFilter() {
    return mPersonFilter;
  }

  public class PersonFilter extends Filter {

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
      final FilterResults filterResults = new FilterResults();
      if (TextUtils.isEmpty(constraint)) {
        filterResults.count = mBackupPersons.size();
        filterResults.values = mBackupPersons;
        return filterResults;
      }
      final ArrayList<Person> filterPersons = new ArrayList<>();
      for (Person person : mBackupPersons) {
        if (person.getName().toLowerCase().contains(constraint)) {
          filterPersons.add(person);
        }
      }
      filterResults.count = filterPersons.size();
      filterResults.values = filterPersons;
      return filterResults;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
      mPersons = (ArrayList<Person>) results.values;
      notifyDataSetChanged();
    }
  }
}
