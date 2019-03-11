package com.workshop.aroundme.app.ui.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.workshop.aroundme.R
import com.workshop.aroundme.app.Injector
import com.workshop.aroundme.app.ui.detail.DetailFragment
import com.workshop.aroundme.data.model.ParentCategoryEntity
import com.workshop.aroundme.data.model.PlaceEntity

class HomeFragment : Fragment(), OnHomePlaceItemClickListener {

    private var adapter: ModernHomeAdapter? = null

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

        val placeRepository = Injector.providePlaceRepository(requireContext())
        placeRepository.getFeaturedPlaces(::onFeaturedPlacesReady)
    }

    private fun onFeaturedPlacesReady(list: List<PlaceEntity>?) {
        activity?.runOnUiThread {

            val recyclerView = view?.findViewById<RecyclerView>(R.id.recyclerView)
//            val progressBar = view?.findViewById<ProgressBar>(R.id.loadingBar)
//            progressBar?.visibility = View.GONE

            adapter = ModernHomeAdapter(list ?: listOf(), this)
            recyclerView?.adapter = adapter

            val categoryRepository = Injector.provideCategoryRepository(requireContext())
            categoryRepository.getCategories(::onCategoriesReady)
        }
    }

    private fun onCategoriesReady(list: List<ParentCategoryEntity>?) {
        activity?.runOnUiThread {
            adapter?.parentCategories = list.orEmpty()
        }
    }

    override fun onPlaceItemCliced(placeEntity: PlaceEntity) {
        fragmentManager?.beginTransaction()
            ?.replace(R.id.content_frame, DetailFragment.newInstance(placeEntity.slug))
            ?.addToBackStack(null)
            ?.commit()
    }

    override fun onItemStarred(placeEntity: PlaceEntity) {
        val placeRepository = Injector.providePlaceRepository(requireContext())
        placeRepository.starPlace(placeEntity)
    }
}
