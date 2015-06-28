package jp.kyam.listfragmentsample;

import android.app.Activity;
import android.os.Bundle;
import android.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import jp.kyam.listfragmentsample.dummy.DummyContent;

public class ItemFragment extends ListFragment {
    private ItemAdapter mAdapter;

    public ItemFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new ItemAdapter(getActivity());
        setListAdapter(mAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_item_list, container, false);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        if(mAdapter != null){
            mAdapter.remove(position);
        }
    }

    public void add(String itemContents){
        if(mAdapter != null){
            mAdapter.add(itemContents);
        }
    }
}
