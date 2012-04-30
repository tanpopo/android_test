package mytest.list;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

//ref. https://www.support.softbankmobile.co.jp/partner_st/home_tech9/column4-3.cfm

public class ListArrayAdapter extends ArrayAdapter<ListItem> {
	private ArrayList<ListItem> listItem;

	public ListArrayAdapter(Context context, int textViewResourceId, ArrayList<ListItem> listItem) {
		super(context, textViewResourceId, listItem);
		this.listItem = listItem;

	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		ListItem item = listItem.get(position);
		Context context = getContext();
		LinearLayout linearLayout = new LinearLayout(context);
		view = linearLayout;
		TextView textView = new TextView(context);
		textView.setText(item.title);
		linearLayout.addView(textView);
		Button button = new Button(context);
		button.setText("GO");
		button.setTag(String.valueOf(position));
//		button.setOnClickListener(this);
		linearLayout.addView(button, 0);
		return view;
	}

}

