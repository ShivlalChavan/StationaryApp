package com.app.stationaryapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.stationaryapp.`interface`.RecyclerItemListener
import com.app.stationaryapp.databinding.RowLayoutForBookListBinding
import com.app.stationaryapp.model.Book
import com.app.stationaryapp.ui.BookListViewModel
import com.app.stationaryapp.ui.viewholder.BookViewHolder

class BookListAdapter(private val bookListViewModel: BookListViewModel,private val bookList: List<Book>):
    RecyclerView.Adapter<BookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
       val mBinding = RowLayoutForBookListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BookViewHolder(mBinding)
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(bookList[position],OnItemClickListener)
    }

    private val OnItemClickListener:RecyclerItemListener= object :RecyclerItemListener{
        override fun onItemSelected(item: Any) {
            bookListViewModel.onBookDetail(item as Book)
        }



    }
}