package dk.shantech.newsviewer.bindings

import android.content.ContentValues.TAG
import android.util.Log
import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import dk.shantech.newsviewer.data.model.Article
import dk.shantech.newsviewer.ui.main.MainRecyclerViewAdaptor

@BindingAdapter("adapter")
fun adaptorBinding(recyclerView: RecyclerView, adaptor: MainRecyclerViewAdaptor) {
    recyclerView.adapter = adaptor
}

@BindingAdapter("data")
fun dataBinding(recyclerView: RecyclerView, data: List<Article>?) {
    val mainRecyclerViewAdaptor = recyclerView.adapter as MainRecyclerViewAdaptor
    mainRecyclerViewAdaptor.submitList(data)
}