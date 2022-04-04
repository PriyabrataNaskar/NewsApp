package com.priyo.newsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.priyo.newsapp.databinding.FragmentNewsListBinding


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class NewsListFragment : Fragment() {

    private var _binding: FragmentNewsListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    // Member variables.
    private var mRecyclerView: RecyclerView? = null
    private var mNewsData: List<Article>? = null
    private var mAdapter: NewsAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentNewsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize the RecyclerView.
        mRecyclerView = binding.recyclerView

        // Set the Layout Manager.
        mRecyclerView?.layoutManager = GridLayoutManager(context,1)

        // Initialize the ArrayList that will contain the data.
        mNewsData = ArrayList()
        setAdapter()
//        binding.buttonFirst.setOnClickListener {
//            findNavController().navigate(R.id.action_NewsListFragment_to_NewsDetailsFragment)
//        }
    }

    private fun setAdapter(){
        val list: MutableList<Article> = mutableListOf<Article>()
        val article = Article(
            author = "Samantha Lock", content = null, description = "Ukraine president decries abuses of invading forces; lawyers investigating possible war crimes have found 410 bodies and have examined 140 so far", publishedAt = "2022-04-04T04:26:42Z", urlToImage = "\"https://i.guim.co.uk/img/media/53aeee7dc88a39801201e68c525960ecd5b22a90/0_126_4240_2545/master/4240.jpg?width=1200&height=630&quality=85&auto=format&fit=crop&overlay-align=bottom%2Cleft&overlay-width=100p&overlay-base64=L2ltZy9zdGF0aWMvb3ZlcmxheXMvdGctbGl2ZS5wbmc&enable=upscale&s=99b42668d4522721c084e0fe8827bd89", url =  "https://www.theguardian.com/world/live/2022/apr/04/russia-ukraine-war-latest-zelenskiy-calls-russian-forces-butchers-after-civilian-mass-graves-found-around-kyiv-live", title = "Russia-Ukraine war latest: Zelenskiy calls Russian forces ‘butchers’ after civilian mass graves found around Kyiv – live - The Guardian", source = Source(
            id = null, name = "The Guardian")
        )
        repeat(5) {
            list.add(article)
        }
        mNewsData = list
        mAdapter = mNewsData?.let { context?.let { it1 -> NewsAdapter(it, it1) } }
        mRecyclerView?.adapter = mAdapter
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}