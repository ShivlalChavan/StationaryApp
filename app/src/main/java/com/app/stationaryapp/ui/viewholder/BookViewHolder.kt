package com.app.stationaryapp.ui.viewholder

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.app.stationaryapp.R
import com.app.stationaryapp.databinding.RowLayoutForBookListBinding
import com.app.stationaryapp.model.Book
import com.app.stationaryapp.ui.adapter.BookListAdapter
import com.app.stationaryapp.utils.Utils
import com.bumptech.glide.Glide

class BookViewHolder(private val itemBinding:RowLayoutForBookListBinding):RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(bookItem:Book, reyclerItemClickListener: BookListAdapter.RecyclerItemListener){
       Glide
           .with(itemView.context)
           .load(Utils.IMAGE_BASEURL
                   +bookItem.image)
           .placeholder(R.drawable.placeholder)
           .error(R.drawable.placeholder)
           .into(itemBinding.bookCoverIv)
       // Log.e("In","BindViewHolder"+bookItem.title)
        itemBinding.bookTitleTv.text = bookItem.title
        itemBinding.bookDescriptionTv.text = bookItem.description


        itemBinding.contentLl.setOnClickListener{
            Log.e("Position ","click"+adapterPosition)
            reyclerItemClickListener.onItemSelected(bookItem!!)
        }

    }




}