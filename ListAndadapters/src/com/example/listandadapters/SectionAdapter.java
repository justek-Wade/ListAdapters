package com.example.listandadapters;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class SectionAdapter extends ArrayAdapter<String> {

	private Activity activity;

	public SectionAdapter(Activity activity, String[] objects) {
		super(activity, 0);
		// TODO Auto-generated constructor stub
		// return null;

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		return super.getView(position, convertView, parent);
	}

}
