package by.softteco.nmisko.testforsoftteco.ui.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.softteco.nmisko.domain.model.Post
import by.softteco.nmisko.testforsoftteco.R
import by.softteco.nmisko.testforsoftteco.ui.activity.MainActivity
import by.softteco.nmisko.testforsoftteco.ui.adapter.MyItemRecyclerViewAdapter
import by.softteco.nmisko.testforsoftteco.ui.adapter.OnPostItemClickListener
import by.softteco.nmisko.testforsoftteco.ui.viewmodel.MainViewModel
import timber.log.Timber

/**
 * A fragment representing a list of Items.
 */
class PostItemFragment : Fragment(), OnPostItemClickListener {

    private var columnCount = 3
    private var position = 0

    private val mainViewModel: MainViewModel by activityViewModels()

    private lateinit var postList: ArrayList<Post>
    private lateinit var rv: RecyclerView

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as MainActivity).appComponent.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            position = it.getInt(ARG_TAB_POSITION)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_item_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv = view as RecyclerView

        postList = mainViewModel.getPosts()
        setupUI()

    }

    private fun setupUI() {
        val customGridLayoutManager = object : GridLayoutManager(context, columnCount) {
            override fun canScrollVertically(): Boolean {
                return false
            }
        }
        val rvAdapter = MyItemRecyclerViewAdapter(this)
        val filteredPostList = ArrayList<Post>()
        val listRest = postList.size % 6
        for (post in postList) {
            if (position == 0) {
                if (postList.indexOf(post) in position until position + 6) {
                    filteredPostList.add(post)
                }
            }else if(listRest != 0 && position == postList.lastIndex - listRest ){
                if (postList.indexOf(post) in position * 6 .. position * 6 + listRest) {
                    filteredPostList.add(post)
                }
            } else {
                if (postList.indexOf(post) in position * 6 until position * 6 + 6) {
                    filteredPostList.add(post)
                }
            }

        }
        with(rv) {
            layoutManager = customGridLayoutManager
            adapter = rvAdapter
        }
        rvAdapter.updateList(filteredPostList)
    }

    override fun onItemClick(postId: Int, userId: Int) {
        val bundle = Bundle()
        bundle.putInt("postId", postId)
        bundle.putInt("userId", userId)
        findNavController().navigate(R.id.action_menuFragment2_to_userDetailsFragment, bundle)
    }

    companion object {
        const val ARG_TAB_POSITION = "tab-position"

        @JvmStatic
        fun newInstance(tab_num: Int) =
            PostItemFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_TAB_POSITION, tab_num)
                }
            }
    }
}
