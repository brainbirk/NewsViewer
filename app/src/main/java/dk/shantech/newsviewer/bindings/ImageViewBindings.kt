package dk.shantech.newsviewer.bindings

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import dk.shantech.newsviewer.R

@BindingAdapter(value = ["asyncLoad"])
fun asyncLoadBinding(imgView: ImageView, url: String) {
    if (url.isEmpty()) {
        imgView.setImageDrawable(null)
        return
    }

    val options: RequestOptions = RequestOptions()
        .centerInside()
        .placeholder(R.drawable.image_placeholder) // TODO: 28/04/2021 Move hardcoded to a parameter and give a default image 
        .error(R.mipmap.ic_launcher_round)
    Glide.with(imgView.context).load(url).apply(options).into(imgView)
}