package mytest.list;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class StockAdapter extends ArrayAdapter<MyStock> {
  private int mResource;
  private int mFieldId;
  private LayoutInflater mInflater;

  public StockAdapter(Context context, int resource, int textViewResourceId, ArrayList<MyStock> objects) {
    super(context, resource, textViewResourceId, objects);

    // initialize
    mResource = resource;
    mFieldId = textViewResourceId;
    mInflater = (LayoutInflater)context.getSystemService(
        Context.LAYOUT_INFLATER_SERVICE);
  }

  public View getView(int position, View convertView, ViewGroup parent) {
    View view;
    TextView text;

    if (convertView == null) {
      view = mInflater.inflate(mResource, parent, false);
    } else {
      view = convertView;
    }

    try {
      text = (TextView)view.findViewById(mFieldId);
    } catch (ClassCastException e) {
      Log.e("StockAdapter",
        "You must supply a resource ID for a TextView");
      throw new IllegalStateException(
        "StockAdapter requires the resource ID to be a TextView", e);
    }

    MyStock stock = this.getItem(position);
    text.setText(stock.getName());

    return view;
  }
}