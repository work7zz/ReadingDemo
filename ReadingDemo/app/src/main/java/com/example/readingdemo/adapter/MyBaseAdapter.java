package com.example.readingdemo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.readingdemo.R;
import com.example.readingdemo.something.Book;
import java.util.List;

/**
 * Created by yuzhiqi on 2019/02/27
 *
 * @author 于治麒 yuzhiqi@bytedance.com
 */


public class MyBaseAdapter extends BaseAdapter{

    private List<Book> books;

    public MyBaseAdapter() {
    }

    public MyBaseAdapter(final List<Book> books) {
        this.books = books;
    }

    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Object getItem(final int position) {
        return books.get(position);
    }

    @Override
    public long getItemId(final int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater mLayoutInflater = LayoutInflater.from(parent.getContext());
        ViewHolder myHolder;
        if(convertView==null){
            convertView = mLayoutInflater.inflate(R.layout.item_book_info,parent,false);
            myHolder = new ViewHolder();
            myHolder.imageView = convertView.findViewById(R.id.book_image_id);
            myHolder.titleTextView = convertView.findViewById(R.id.book_title_id);
            myHolder.introductionTextView = convertView.findViewById(R.id.book_introduction_id);
            myHolder.category1TextView = convertView.findViewById(R.id.book_category1_id);
            myHolder.category2TextView = convertView.findViewById(R.id.book_category2_id);
            convertView.setTag(myHolder);
        }else{
            myHolder = (ViewHolder)convertView.getTag();
        }
        Book book = books.get(position);
        myHolder.imageView.setImageResource(book.getImageId());
        myHolder.titleTextView.setText(book.getTitle());
        myHolder.introductionTextView.setText(book.getIntroduction());
        myHolder.category1TextView.setText(book.getCategory()[0]);
        myHolder.category2TextView.setText(book.getCategory()[1]);
        return convertView;
    }

    static class ViewHolder{
        ImageView imageView;
        TextView titleTextView;
        TextView introductionTextView;
        TextView category1TextView;
        TextView category2TextView;
    }

}
