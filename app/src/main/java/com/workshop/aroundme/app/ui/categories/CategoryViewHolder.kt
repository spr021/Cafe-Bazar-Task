package com.workshop.aroundme.app.ui.categories

import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.workshop.aroundme.R
import com.workshop.aroundme.data.model.ParentCategoryEntity

class CategoryViewHolder(itemView :View):RecyclerView.ViewHolder(itemView) {
    val nameTextView = itemView.findViewById<TextView>(R.id.textView)!!
    fun bind(
        parentCategoryEntity: ParentCategoryEntity
    ){
        nameTextView.text = parentCategoryEntity.name

    }
}
