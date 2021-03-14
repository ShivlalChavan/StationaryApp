package com.app.stationaryapp.ui.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.app.stationaryapp.`interface`.RecyclerItemListener
import com.app.stationaryapp.databinding.RowLayoutForBookListBinding
import com.app.stationaryapp.model.Book

class BookViewHolder(private val itemBinding:RowLayoutForBookListBinding):RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(bookItem:Book,reyclerItemClickListener: RecyclerItemListener){

       // Glide.with(itemView.context).load(bookItem.image).into(itemBinding.bookCoverIv)
       // Log.e("In","BindViewHolder"+bookItem.title)
        itemBinding.bookTitleTv.text = bookItem.title
        itemBinding.bookCv.setOnClickListener { reyclerItemClickListener.onItemSelected(bookItem) }

    }
}