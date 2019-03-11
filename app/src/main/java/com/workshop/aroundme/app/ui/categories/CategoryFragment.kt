package com.workshop.aroundme.app.ui.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.workshop.aroundme.R
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.workshop.aroundme.app.Injector

import com.workshop.aroundme.data.model.CategoryEntity
import com.workshop.aroundme.data.model.ParentCategoryEntity

class CategoryFragment : Fragment () ,OnCategoryChildItemClickListener{

    private var adapter : CategoryAdapter? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val categoryRepository = Injector.provideCategoryRepository(requireContext())
        categoryRepository.getCategories (::onCategoriesReady)
    }


    private fun onCategoriesReady(list: List<ParentCategoryEntity>?) {
        activity?.runOnUiThread {
            println(list)
            val recyclerView = view?.findViewById<RecyclerView>(R.id.recyclerView)
            adapter = CategoryAdapter(list ?: listOf())
            recyclerView?.adapter = adapter

        }
    }
    override fun onCategoryChildItemCliced(categoryEntity: CategoryEntity) {
        fragmentManager?.beginTransaction()
            ?.replace(R.id.content_frame , CategoryChildDetailFragment.newInstance(categoryEntity.name))
            ?.addToBackStack(null)
            ?.commit()
    }

}