package com.workshop.aroundme.app.ui.categories

import android.view.LayoutInflater
import android.view.ViewGroup
import com.workshop.aroundme.R
import androidx.recyclerview.widget.RecyclerView
import com.workshop.aroundme.app.ui.home.OnHomePlaceItemClickListener
import com.workshop.aroundme.data.model.CategoryEntity

class CategoryChildAdapter (
    private val childs : List<CategoryEntity>) :
    RecyclerView.Adapter<CategoryChildViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryChildViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category_child, parent, false)
        return CategoryChildViewHolder(view)
    }

    override fun getItemCount(): Int = childs.size

    override fun onBindViewHolder(holder: CategoryChildViewHolder, position: Int) {

        holder.bind(childs[position])
    }

}
