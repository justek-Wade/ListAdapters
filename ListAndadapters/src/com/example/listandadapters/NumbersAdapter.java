package com.example.listandadapters;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class NumbersAdapter extends ArrayAdapter<Integer> {

	public static interface NumbersAdapterDelegate {
		void removeItem(Integer value);
	}

	private LayoutInflater mInflator;
	private NumbersAdapterDelegate mDelegate;

	public NumbersAdapter(Context context, List<Integer> objects) {
		super(context, 0, objects);
		mInflator = LayoutInflater.from(context);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		if (null == convertView) {
			convertView = mInflator.inflate(R.layout.num_item, parent, false);
		}
		final Integer value=getItem(position);
		TextView textView=(TextView) convertView.findViewById(R.id.numText);
		textView.setText(value.toString());
		
		View button=convertView.findViewById(R.id.btn);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (null!=mDelegate) {
					mDelegate.removeItem(value);
				}
			}
		});
		
		return convertView;
	}
	public void setDelegate(NumbersAdapterDelegate delegate)
	{
		mDelegate=delegate;
	}

}
