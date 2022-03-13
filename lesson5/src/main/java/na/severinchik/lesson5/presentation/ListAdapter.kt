package na.severinchik.lesson5.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import na.severinchik.lesson5.databinding.ItemListBinding

class ListAdapter(private val list: List<String>, private val listener: OnClickListItemListener) :
    RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemListBinding.inflate(layoutInflater, parent, false)
        return ListViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    class ListViewHolder(
        private val binding: ItemListBinding,
        private val listener: OnClickListItemListener
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String) {
            binding.ilAvatar.text = item.first().toString()
            binding.ilName.text = item
            binding.ilAvatar.setOnClickListener {
                listener.onClick(item)
            }
        }
    }

    interface OnClickListItemListener {
        fun onClick(value: String)
    }
}