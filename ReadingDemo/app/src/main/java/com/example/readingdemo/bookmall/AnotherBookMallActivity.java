package com.example.readingdemo.bookmall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.example.readingdemo.R;
import com.example.readingdemo.something.Book;
import com.example.readingdemo.adapter.MyRecyclerViewAdapter;
import com.example.readingdemo.adapter.MyRecyclerViewAdapter.OnItemClickListener;
import com.example.readingdemo.pages.BookDetailActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AnotherBookMallActivity extends AppCompatActivity {

    List<Book> books;
    public static final String MESSAGE = "com.example.readingdemo.bookmall.AnotherBookMallActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_mall_another);


        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.book_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL));
        MyRecyclerViewAdapter adaper = new MyRecyclerViewAdapter(CreateBookData());
        recyclerView.setAdapter(adaper);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adaper.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(final View view, final int position) {
                Book book = books.get(position);
                int bookId = book.getId();
                Intent intent = new Intent(AnotherBookMallActivity.this,BookDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("ID",bookId);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


    }

    public List<Book> CreateBookData() {
        int bookCount = 100;
        int imageID = R.mipmap.ic_launcher;
        String title = "titletitle";
        String introduction = "lllllllllll";
        String[] categories = {"玄幻","都市生活","都市异能","现代都市","东方玄幻","科幻","历史","军事","悬疑","游戏电竞"};
        Random random = new Random();
        books = new ArrayList<>();
        for(int j = 0;j<bookCount;j++){
            Book book = new Book();
            book.setId(j+1);
            book.setImageId(imageID);
            book.setTitle(title + (j + 1));
            book.setIntroduction(introduction);
            String[] category = {categories[random.nextInt(10)],categories[random.nextInt(10)]};
            book.setCategory(category);
            books.add(book);
        }
        return books;
    }

}
