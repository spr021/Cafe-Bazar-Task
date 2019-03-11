package com.workshop.aroundme.app.ui.categories

import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.workshop.aroundme.R
import com.workshop.aroundme.data.model.ParentCategoryEntity

class CategoryAdapter(
    private val items: List<ParentCategoryEntity>
) :
    RecyclerView.Adapter<CategoryViewHolder>() {
    var view : View? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.item_category_fragment, parent, false)
        view = item
        return CategoryViewHolder(item)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {

       holder.bind(items[position])
        val recyclerView = view?.findViewById<RecyclerView>(R.id.secondRecyclerView)
        recyclerView?.layoutManager = LinearLayoutManager(view?.context)
        recyclerView?.adapter =CategoryChildAdapter(items[position].children ?: listOf())
    }


}