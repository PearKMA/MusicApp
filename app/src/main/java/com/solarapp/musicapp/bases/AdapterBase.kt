package com.solarapp.musicapp.bases

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.solarapp.musicapp.BR
import com.solarapp.musicapp.models.ModelBase

open class AdapterBase<T : ModelBase>(
    private val inflater: LayoutInflater,
    private @LayoutRes val resLayout: Int
) : RecyclerView.Adapter<AdapterBase.ViewHolderBase>() {


    private var data: List<T>? = null
    var listener: ListItemListener? = null

    fun setData(data: List<T>) {
        this.data = data
        notifyDataSetChanged()
    }

    fun getData() = data

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
        initView()
        holder.binding.setVariable(BR.song, item)
        holder.binding.setVariable(BR.listener, listener)
        holder.binding.executePendingBindings()
    }

     fun initView() {

    }

    class ViewHolderBase(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)

    interface ListItemListener
}