package com.example.readingdemo.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.readingdemo.R;
import com.example.readingdemo.something.Book;

import java.util.List;

/**
 * Created by yuzhiqi on 2019/03/01
 *
 * @author 于治麒 yuzhiqi@bytedance.com
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.VH> {

    public List<Book> books;
    private OnItemClickListener mClickListener;

    public MyRecyclerViewAdapter( List<Book> books) {
        this.books = books;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(ViewGroup viewGroup,  int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_book_info,viewGroup,false);

        VH viewHolder = new VH(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final VH viewHolder,  final int position) {
        Book book = books.get(position);
        viewHolder.title.setText(book.getTitle());
        viewHolder.bookImage.setImageResource(book.getImageId());
        viewHolder.introduction.setText(book.getIntroduction());
        viewHolder.bookCategory1.setText(book.getCategory()[0]);
        viewHolder.bookCategory2.setText(book.getCategory()[1]);

    }


    @Override
    public int getItemCount() {
        return books.size();
    }


    class VH extends RecyclerView.ViewHolder implements OnClickListener{

         ImageView bookImage;
         TextView title;
         TextView introduction;
         TextView bookCategory1;
         TextView bookCategory2;

        public VH(@NonNull View itemView) {
            super(itemView);
            bookImage = itemView.findViewById(R.id.book_image_id);
            title = itemView.findViewById(R.id.book_title_id);
            introduction = itemView.findViewById(R.id.book_introduction_id);
            bookCategory2 = itemView.findViewById(R.id.book_category2_id);
            bookCategory1 = itemView.findViewById(R.id.book_category1_id);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(final View v) {
            mClickListener.onItemClick(v,getAdapterPosition());
        }
    }

    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.mClickListener = onItemClickListener;
    }


}
