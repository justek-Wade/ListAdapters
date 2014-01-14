package com.example.listandadapters;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class SectionAdapter extends ArrayAdapter<String> {

	static class ViewHolder {
		public TextView header;
		public TextView lableTextView;

	}

	private Activity activity;

	public SectionAdapter(Activity activity, String[] objects) {
		super(activity, R.layout.listitem, R.id.lable, objects);
		this.activity = activity;
		// TODO Auto-generated constructor stub
		// return null;

	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {

		// traditional type to getView
		// if (view == null) {
		// view = activity.getLayoutInflater().inflate(R.layout.listitem,
		// parent, false);
		//
		// }
		// TextView header = (TextView) view.findViewById(R.id.header);
		//
		// String label = getItem(position);
		// if (position == 0 || getItem(position - 1).charAt(0) !=
		// label.charAt(0))
		// {
		// header.setVisibility(View.VISIBLE);
		// header.setText(label.substring(0, 1));
		// }
		// Log.v("getView", "traditional type to getView");
		// return super.getView(position, view, parent);
		
		//========================================================================
		//recycle type to getView
		ViewHolder viewHolder;
		if (view == null) {

			view = activity.getLayoutInflater().inflate(R.layout.listitem,
					parent, false);
			viewHolder = new ViewHolder();
			viewHolder.header = (TextView) view.findViewById(R.id.header);
			viewHolder.lableTextView = (TextView) view.findViewById(R.id.lable);
			view.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) view.getTag();
			viewHolder.header.setVisibility(View.GONE);
		}
		String label = getItem(position);
		if (position == 0 || getItem(position - 1).charAt(0) != label.charAt(0)) {
			viewHolder.header.setVisibility(View.VISIBLE);
			viewHolder.header.setText(label.substring(0, 1));
		}
		viewHolder.lableTextView.setText(label);
		Log.v("getView", "recycle type to getView");
		return view;
	}

}
