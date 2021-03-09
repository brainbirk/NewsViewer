package dk.shantech.newsviewer.bindings

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter(value = ["asyncLoad"])
fun ImageView.asyncLoadBinding(imgView: ImageView, url: String) {
    Glide.with(imgView.context).load(url).into(imgView)
}