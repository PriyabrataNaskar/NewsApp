package com.priyo.newsapp.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.priyo.newsapp.view.adapter.NewsAdapter
import com.priyo.newsapp.databinding.FragmentNewsListBinding
import com.priyo.newsapp.model.Article
import com.priyo.newsapp.model.Source
import com.priyo.newsapp.util.Resource
import com.priyo.newsapp.viewmodel.NewsViewModel


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class NewsListFragment : Fragment() {

    private var _binding: FragmentNewsListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    // Member variables
    private var mRecyclerView: RecyclerView? = null
    private var mAdapter: NewsAdapter? = null

    private lateinit var viewModel: NewsViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentNewsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as MainActivity).viewModel

        observeLiveData()
//        binding.buttonFirst.setOnClickListener {
//            findNavController().navigate(R.id.action_NewsListFragment_to_NewsDetailsFragment)
//        }
    }

    private fun observeLiveData(){
        viewModel.topNews.observe(viewLifecycleOwner, Observer {response->
            when(response){
                is Resource.Success ->{
                    hideProgressBar()
                    hideError()
                    response.data?.let {
                        mAdapter = NewsAdapter(response.data.articles, requireContext())
                        setRecyclerView(response.data.articles)
                    }
                }
                is Resource.Error ->{
                    hideProgressBar()
                    showError()
                    response.message?.let { message->
                        Log.e("NewsFragment", message)
                        showError()
                    }
                }
                is Resource.Loading ->{
                    showProgressBar()
                    hideError()
                }
            }

        })
    }

    private fun showError() {
    }

    private fun hideError() {
    }

    private fun showProgressBar() {
        binding.shimmerView.startShimmer()
    }

    private fun hideProgressBar() {
        binding.shimmerView.stopShimmer()
    }

    private fun setRecyclerView(list: List<Article>){
        // Initialize the RecyclerView.
        mRecyclerView = binding.recyclerView
        // Set the Layout Manager.
        mRecyclerView?.layoutManager = GridLayoutManager(context,1)

        mAdapter =  context?.let { it1 -> NewsAdapter(list, it1) }
        mRecyclerView?.adapter = mAdapter
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}