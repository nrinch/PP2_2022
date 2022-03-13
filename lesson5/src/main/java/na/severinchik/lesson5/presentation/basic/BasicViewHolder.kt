package na.severinchik.lesson5.presentation.basic

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BasicViewHolder<T : BasicUiEntity<T>>(val binding: ViewBinding) :
    RecyclerView.ViewHolder(binding.root) {

    abstract fun bind(item: T)
}