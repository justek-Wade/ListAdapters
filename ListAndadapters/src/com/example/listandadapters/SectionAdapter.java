package com.example.listandadapters;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class SectionAdapter extends ArrayAdapter<String> {

	private Activity activity;

	public SectionAdapter(Activity activity, String[] objects) {
		super(activity, R.layout.listitem, R.id.lable, objects);
		this.activity = activity;
		// TODO Auto-generated constructor stub
		// return null;

	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		if (view == null) {
			view = activity.getLayoutInflater().inflate(R.layout.listitem,
					parent, false);

		}
		TextView header = (TextView) view.findViewById(R.id.header);

		String label = getItem(position);
		if (position == 0 || getItem(position - 1).charAt(0) != label.charAt(0))
		{
			header.setVisibility(View.VISIBLE);
			header.setText(label.substring(0, 1));
		}
		return super.getView(position, view, parent);
	}

}
