package com.priyo.newsapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.priyo.newsapp.R
import com.priyo.newsapp.databinding.FragmentNewsDetailsBinding
import com.priyo.newsapp.model.data.Article

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class NewsDetailsFragment : Fragment() {
    companion object {
        const val AUTHOR_NAME = "newsAuthorName"
        const val NEWS_TITLE = "newsTitle"
        const val NEWS_DESCRIPTION = "newsDescription"
        const val NEWS_IMAGE_RESOURCE = "newsImageResource"
        const val NEWS_PUBLISH_TIME = "newsPublishTime"
        const val CONTENT = "content"
    }

    private var _binding: FragmentNewsDetailsBinding? = null
    private var article: Article? = null

    private var newsAuthorName: String? = null
    private var newsTitle: String? = null
    private var newsDescription: String? = null
    private var newsImageResource: String? = null
    private var newsPublishTime: String? = null
    private var content: String? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            newsAuthorName = it.getString(AUTHOR_NAME)
            newsTitle = it.getString(NEWS_TITLE)
            newsDescription = it.getString(NEWS_DESCRIPTION)
            newsImageResource = it.getString(NEWS_IMAGE_RESOURCE)
            newsPublishTime = it.getString(NEWS_PUBLISH_TIME)
            content = it.getString(CONTENT)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentNewsDetailsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.titleText.text = newsTitle
        binding.contentDescription.text = newsDescription
        binding.newsArticleText.text = content
        binding.newsMetaData.text = "$newsAuthorName $newsPublishTime"
        Glide.with(this).load(newsImageResource).centerCrop().placeholder(R.drawable.ic_placeholder_image).centerCrop().into(binding.newsImageDetail)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}