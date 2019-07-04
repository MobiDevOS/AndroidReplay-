// BookManager.aidl
package com.zhujohnle.androidreplay;

// Declare any non-default types here with import statements
import com.zhujohnle.androidreplay.ipc.Book;
interface IBookManager {
    List<Book> getBookList(); // 返回书籍列表
    void addBook(in Book book); // 添加书籍
}
