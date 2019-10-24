package com.solarapp.musicapp.bases

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.solarapp.musicapp.models.ModelBase

class AdapterBase<T : ModelBase>(
    private val inflater: LayoutInflater,
    private @LayoutRes val resLayout: Int
) : RecyclerView.Adapter<AdapterBase.ViewHolderBase>() {


    private var data: List<T>? = null
    var listener: ListItemListener? = null

    fun setData(data: List<T>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderBase {
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            inflater, resLayout, parent, false
        )
        return ViewHolderBase(binding)
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolderBase, position: Int) {
        val item = data?.get(position)

        //holder.binding.setVariable(BR.item, item)
        //holder.binding.setVariable(BR.listener, listener)
        holder.binding.executePendingBindings()
    }

    class ViewHolderBase : RecyclerView.ViewHolder {
        val binding: ViewDataBinding

        constructor(binding: ViewDataBinding) : super(binding.root) {
            this.binding = binding
        }
    }

    interface ListItemListener
}