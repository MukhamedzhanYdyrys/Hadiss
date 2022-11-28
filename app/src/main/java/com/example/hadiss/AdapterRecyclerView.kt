package com.example.hadiss

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hadiss.databinding.HadissItemBinding
import com.example.hadiss.model.Data
import com.example.hadiss.model.allHadeest

class AdapterRecyclerView: RecyclerView.Adapter<AdapterRecyclerView.RecViewHolder>() {

    var list = emptyList<Data>()

    class RecViewHolder(view: View): RecyclerView.ViewHolder(view){
        val binding = HadissItemBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.hadiss_item, parent, false)
        return RecViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecViewHolder, position: Int) {
        with(holder.binding){
            title.text = list.get(position).title
        }
    }

    override fun getItemCount(): Int = list.size

    fun setList(obj: allHadeest){
        val newList : ArrayList<Data> = ArrayList()
        for(item in obj.data){
            newList.add(item)
        }
        list = newList
        notifyDataSetChanged()
    }
}