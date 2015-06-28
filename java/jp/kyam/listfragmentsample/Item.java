package jp.kyam.listfragmentsample;

import android.os.Parcel;
import android.os.Parcelable;

public class Item implements Parcelable{
    public String mItemContents;

    public Item(String contents){
        mItemContents = contents;
    }

    public Item(Parcel in){
        mItemContents = in.readString();
    }

    @Override
    public int describeContents() {
        //FileDescriptor未使用時は0を返す
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mItemContents);
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel source) {
            return new Item(source);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };
}
