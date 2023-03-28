package com.shivamsanwaria.bookworld.fragment

import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.RelativeLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.shivamsanwaria.bookworld.R
import com.shivamsanwaria.bookworld.adapter.DashboardRecyclerAdapter
import com.shivamsanwaria.bookworld.adapter.FavouriteRecyclerAdapter
import com.shivamsanwaria.bookworld.database.BookDatabase
import com.shivamsanwaria.bookworld.database.BookEntities


class FavouritesFragment : Fragment() {

    lateinit var recyclerFavourite: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var recyclerAdapter: FavouriteRecyclerAdapter
    lateinit var progressLayout: RelativeLayout
    lateinit var progressBar : ProgressBar
    var dbBookList = listOf<BookEntities>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_favourites, container, false)

        recyclerFavourite = view.findViewById(R.id.recyclerFavourite)
        progressLayout = view.findViewById(R.id.progressLayout)
        progressBar = view.findViewById(R.id.progressBar)

        layoutManager = GridLayoutManager(activity as Context,2)
        dbBookList = RetriveFavourites(activity as Context).execute().get()
        if(activity!=null){
            progressLayout.visibility = View.GONE
            recyclerAdapter = FavouriteRecyclerAdapter(activity as Context,dbBookList)
            recyclerFavourite.adapter = recyclerAdapter
            recyclerFavourite.layoutManager = layoutManager
        }
        return  view
    }
    class RetriveFavourites(val context: Context):AsyncTask<Void,Void,List<BookEntities>>(){
        override fun doInBackground(vararg p0: Void?): List<BookEntities> {
            val db = Room.databaseBuilder(context,BookDatabase::class.java,"books-db").build()

            return db.bookDao().getAllBooks()
        }

    }
}