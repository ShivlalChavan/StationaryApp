package com.app.stationaryapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.stationaryapp.databinding.ActivityBookListLayoutBinding
import com.app.stationaryapp.model.Book
import com.app.stationaryapp.ui.BookListViewModel
import com.app.stationaryapp.ui.BookStateEvent
import com.app.stationaryapp.ui.activity.login.LoginActivity
import com.app.stationaryapp.ui.adapter.BookListAdapter
import com.app.stationaryapp.utils.DataState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import timber.log.Timber

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainActivity : BaseActivity() , BookListAdapter.RecyclerItemListener {

    private lateinit var binding:ActivityBookListLayoutBinding
    private  val booViewModel: BookListViewModel by viewModels()

    private  lateinit var bookListAdapter: BookListAdapter

    override fun initViewBinding() {
        binding = ActivityBookListLayoutBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       val layoutManager = LinearLayoutManager(this)
        binding.booksRv.layoutManager = layoutManager
        observeViewModel()
        booViewModel.setBookStateEvent(BookStateEvent.GetBooksEvent)


    }


    override fun observeViewModel() {

        booViewModel.dataState.observe(this, Observer { dataState->
            when(dataState){
                is DataState.Success<List<Book>> ->{
                   //showProgress(false)
                    //populateBookList(dataState.data)
                    dataState.data.let { pupolatelist(it) }
                }
                is DataState.Loading ->{
                    //displayLoading(true)
                }
                is DataState.Error ->{
                   /* displayLoading(false)
                    displayError(dataState.exception.message)*/
                }

            }
        })
    }

    private fun pupolatelist(bookList: List<Book>) {
        if (!bookList.isEmpty())
            bookListAdapter = BookListAdapter(this,booViewModel,bookList)
            binding.booksRv.adapter = bookListAdapter
    }



    override fun onItemSelected(item: Any) {
        Timber.e("Book ${item}")

        startActivity(Intent(this,LoginActivity::class.java))
    }


}