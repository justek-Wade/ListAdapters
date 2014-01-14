package com.example.listandadapters;

import android.os.Bundle;
import android.R.integer;
import android.R.string;
import android.app.Activity;
import android.app.ListActivity;
import android.view.Menu;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ListActivity {

	public int topVisiblePosition;
	private TextView topHeader;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        topHeader=(TextView) findViewById(R.id.header);
//        ListView mListView=(ListView) findViewById(R.id.list_view);
        setListAdapter(new SectionAdapter(this, Countries.COUNTRIES));
//        mListView.setEmptyView(findViewById(R.id.empty_view));
        getListView().setOnScrollListener(new AbsListView.OnScrollListener() {
			
			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {
				// TODO Auto-generated method stub
				if (firstVisibleItem!=topVisiblePosition) {
					topVisiblePosition=firstVisibleItem;
					setTopHeader(firstVisibleItem);
				}
			}
		});
        setTopHeader(0);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    private void setTopHeader(int pos)
    {
    	final String text= Countries.COUNTRIES[pos].substring(0,1);
    	topHeader.setText(text);
    }
}
