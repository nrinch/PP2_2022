package na.severinchik.lesson5.presentation.listadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import na.severinchik.lesson5.databinding.ItemListBinding
import na.severinchik.lesson5.presentation.basic.BasicAdapter

class UserAdapter : BasicAdapter<User, UserViewHolder>(UserDiffCallback()) {
    override fun getViewHolder(parent: ViewGroup): UserViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemListBinding = ItemListBinding.inflate(layoutInflater, parent, false)
        return UserViewHolder(binding)
    }
}