package by.softteco.nmisko.testforsoftteco.ui.adapter

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import by.softteco.nmisko.domain.model.Post
import by.softteco.nmisko.testforsoftteco.ui.fragment.PostItemFragment
import timber.log.Timber

class PostPagerAdapter(fragment : Fragment, private val postList: ArrayList<Post>) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return if (postList.size % 6 == 0) postList.size / 6
        else postList.size / 6 + 1
    }

    override fun createFragment(position: Int): Fragment = PostItemFragment.newInstance(position)
}