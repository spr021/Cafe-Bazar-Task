package com.workshop.aroundme.app.ui.categories

import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.workshop.aroundme.R
import android.view.View
import com.workshop.aroundme.app.ui.home.OnHomePlaceItemClickListener
import com.workshop.aroundme.data.model.CategoryEntity
import kotlinx.android.synthetic.main.item_category_child.view.*

class CategoryChildViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val childNameTextView = itemView.findViewById<TextView>(R.id.childTextView)
    val childNameImageView = itemView.findViewById<ImageView>(R.id.childImageView)
    fun bind(categoryEntity: CategoryEntity){

        Picasso.get().load(categoryEntity.icon).into(childNameImageView)

        childNameTextView.text = categoryEntity.name
        println(categoryEntity.name)
    }
}