package com.workshop.aroundme.app.ui.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import android.view.View
import com.workshop.aroundme.R
import androidx.fragment.app.Fragment

class CategoryChildDetailFragment : Fragment() {

    private var categoryEntityName : String? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textView = view?.findViewById<TextView>(R.id.categoryChildDetailName)
        textView?.text = categoryEntityName

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_category_child_name, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        categoryEntityName = arguments?.getString(KEY_CATEGORY_ENTITY)
    }

    companion object {
        fun newInstance(categoryEntityName: String?): CategoryChildDetailFragment {
            return CategoryChildDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(KEY_CATEGORY_ENTITY, categoryEntityName)
                }
            }
        }

        private const val KEY_CATEGORY_ENTITY = "categoryEntityId"
    }
}