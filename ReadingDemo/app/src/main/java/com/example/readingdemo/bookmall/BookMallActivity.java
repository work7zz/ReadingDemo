package com.example.readingdemo.bookmall;


import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import com.example.readingdemo.R;
import com.example.readingdemo.something.Book;
import com.example.readingdemo.adapter.MyBaseAdapter;
import com.example.readingdemo.pages.BookDetailActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BookMallActivity extends AppCompatActivity {

    private static int bookCount;
    private MyBaseAdapter mMyBaseAdapter;
    private List<Book> books;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_mall);
        ActionBar ac = getSupportActionBar();
        ac.setDisplayHomeAsUpEnabled(true);

        listView = (ListView)findViewById(R.id.book_list_view);
        mMyBaseAdapter = new MyBaseAdapter(createBookData());
        listView.setAdapter(mMyBaseAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(final AdapterView<?> parent, final View view, final int position, final long id) {
                String title = books.get(position).getTitle();
                String introduction = books.get(position).getIntroduction();
                String[] category = books.get(position).getCategory();
                String msg = "点击了第" + (position + 1) + "本小说。";
                Toast.makeText(BookMallActivity.this,msg,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(BookMallActivity.this, BookDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("ID",position + 1);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        findViewById(R.id.change_button).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                updateBookData();
                mMyBaseAdapter.notifyDataSetChanged();
            }
        });

    }


    //注意在開始时传给ListView的list指向不能被改变。须要从始至终指向同一个内存
    private void updateBookData() {
        bookCount = 100;
        Random random = new Random();
        String title = "清墨：许是路漫远";
        List<String> titles = new ArrayList<>();
        for(int i = 0;i < bookCount;i++){
            titles.add(title + (i+1));
        }
        Collections.shuffle(titles);

        String[] categories = {"玄幻","都市生活","都市异能","现代都市","东方玄幻","科幻","历史","军事","悬疑","游戏电竞"};

        for(int i = 0;i < bookCount;i++){
            books.get(i).setTitle(titles.get(i));
            String[] category = {categories[random.nextInt(10)],categories[random.nextInt(10)]};
            books.get(i).setCategory(category);
        }
    }

    private List<Book> createBookData(){
        bookCount = 100;
        int imagID = R.mipmap.ic_launcher;
        String title = "清墨：许是路漫远start";
        String introduction = "辰东长于气氛的营造，这里面，就有蒙太奇的功劳。比如：在《神墓》...";
        String[] category = {"玄幻","军事"};
        books = new ArrayList<>();
        for(int j = 0;j<bookCount;j++){
            Book book = new Book();
            book.setImageId(imagID);
            book.setTitle(title);
            book.setIntroduction(introduction);
            book.setCategory(category);
            books.add(book);
        }
        return books;
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
