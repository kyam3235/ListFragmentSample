package jp.kyam.listfragmentsample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemAdapter extends ArrayAdapter<Item>{
    private static final int RESORURCE_ID = R.layout.list_item_layout;

    public ItemAdapter(Context context){
        super(context, 0);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View view;

        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(RESORURCE_ID, parent, false);
        }else{
            view = convertView;
        }

        Item item = getItem(position);

        TextView itemContents = (TextView)view.findViewById(R.id.tv_item);
        itemContents.setText(item.mItemContents);

        return view;
    }

    //設定されているItemContentsのArrayListを返す
    public ArrayList<Item> getItemList(){
        //今回はBundle#putParcelableArrayList()を使うが、
        //必要に応じてBundle#putSparseParcelableArray()を使ってもいい
        int size = getCount();
        ArrayList<Item>itemArrayList = new ArrayList<Item>(size);
        for(int index = 0; index < size; index++){
            itemArrayList.add(getItem(index));
        }
        return itemArrayList;
    }

    //Use when items reconstitute from Bundle etc.
    public void addAll(ArrayList<Item> parcelableArrayList){
        @SuppressWarnings("unchecked")
        ArrayList<Item> itemArrayList = (ArrayList<Item>)parcelableArrayList;
        super.addAll(itemArrayList);
    }

    public void add(String itemContents) {
        Item item = new Item(itemContents);
        super.add(item);
    }

    public void remove(int index){
        if(index < 0 || index >= getCount()){
            return;
        }
        remove(getItem(index));
    }
}
