package com.example.listandadapters;

import java.util.ArrayList;

import com.example.listandadapters.NumbersAdapter.NumbersAdapterDelegate;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ListView;

public class NumberActivity extends Activity implements NumbersAdapterDelegate {

	private ListView mListView;
	private ArrayList<Integer> mNumbers;
	private NumbersAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list);
		LayoutInflater inflater=LayoutInflater.from(this);
		inflater.inflate(R.layout.num_item, null);
		mListView = (ListView) findViewById(R.id.listview);
		if (mNumbers == null) {

			mNumbers = new ArrayList<Integer>();
			for (int i = 0; i < 100; i++) {
				mNumbers.add(i);
			}
		}

		mAdapter = new NumbersAdapter(this, mNumbers);
		mListView.setAdapter(mAdapter);
	}
	@Override
	protected void onResume() {
		super.onResume();
		mAdapter.setDelegate(this);
	}
	@Override
	protected void onPause() {
		super.onPause();
		mAdapter.setDelegate(null);
	}

	@Override
	public void removeItem(Integer value) {
       mNumbers.remove(value);
       mAdapter.notifyDataSetChanged();
	}

}
