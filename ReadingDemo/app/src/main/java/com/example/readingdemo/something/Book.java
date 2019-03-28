package com.example.readingdemo.something;

/**
 * Created by yuzhiqi on 2019/02/27
 *
 * @author 于治麒 yuzhiqi@bytedance.com
 */
public class Book {

    private int id;
    private int imageId;
    private String title;
    private String introduction;
    private String[] category;

    public Book(){

    }
    public Book(final int id, final int imageId, final String title, final String introduction,
            final String[] category) {
        this.id = id;
        this.imageId = imageId;
        this.title = title;
        this.introduction = introduction;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(final int imageId) {
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(final String introduction) {
        this.introduction = introduction;
    }

    public String[] getCategory() {
        return category;
    }

    public void setCategory(final String[] category) {
        this.category = category;
    }
}
