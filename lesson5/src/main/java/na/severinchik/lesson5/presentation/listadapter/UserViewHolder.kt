package na.severinchik.lesson5.presentation.listadapter

import na.severinchik.lesson5.databinding.ItemListBinding
import na.severinchik.lesson5.presentation.basic.BasicViewHolder

class UserViewHolder(private val bindingImpl: ItemListBinding) :
    BasicViewHolder<User>(bindingImpl) {
    override fun bind(item: User) {
        bindingImpl.ilAvatar.text = "${item.name.first()}${item.surname.first()}"
        bindingImpl.ilName.text = "${item.name} ${item.surname}"
    }
}