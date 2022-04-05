package com.priyo.newsapp.view.adapter

import android.content.Context
import android.content.Intent
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.priyo.newsapp.databinding.ItemNewsCardBinding
import com.priyo.newsapp.model.Article
import com.priyo.newsapp.view.NewsListFragmentDirections

/**
 * Created by Priyabrata Naskar on 04-04-2022.
 */
class NewsAdapter(private val mNewsData: List<Article>, mContext: Context) :
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    // Member variables.
    private val mContext: Context

    init {
        this.mContext = mContext
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemNewsCardBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get current news
        val currentNews: Article = mNewsData[position]

        // Populate the textViews with data.
        holder.bindTo(currentNews)
    }

    override fun getItemCount(): Int {
        return mNewsData.size
    }

    inner class ViewHolder(binding: ItemNewsCardBinding) : RecyclerView.ViewHolder(binding.root),
        View.OnClickListener {
        // Member Variables for the TextViews
        private val mNewsTitleText: TextView
        private val mNewsImage: ImageView
        private val mAuthorTitle: TextView
        private val mDescription: TextView
        private var shareButton: CheckBox

        init {
            // Initialize the views.
            mNewsTitleText = binding.newsTitle
            mNewsImage = binding.newsImage
            mAuthorTitle = binding.authorNameText
            mDescription = binding.descriptionText
            shareButton = binding.shareButton
            // Set the OnClickListener to the entire view.
            itemView.setOnClickListener(this)
            shareButton.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            if (view.id == itemView.id) {
                val news: Article = mNewsData[adapterPosition]

                val newsAuthorName: String? = news.author
                val newsTitle: String? = news.title
                val newsDescription: String? = news.description
                val newsImageResource: String? = news.urlToImage
                val newsPublishTime: String? = news.publishedAt
                val content: String? = news.content
                // Create an nav direction with a destination
                // Add the news details to the nav direction
                val action = NewsListFragmentDirections.actionNewsListFragmentToNewsDetailsFragment(
                    authorName = newsAuthorName,
                    newsTitle = newsTitle,
                    newsDescription = newsDescription,
                    newsImageResource = newsImageResource,
                    newsPublishTime = newsPublishTime,
                    content = content
                )
                view.findNavController().navigate(action)

            } else if (view.id == shareButton.id) {
                val shareIntent = Intent(Intent.ACTION_SEND)

                //Intent shareIntent = new Intent();
                shareIntent.type = "text/plain"
                shareIntent.putExtra(Intent.EXTRA_TEXT, mNewsData[adapterPosition].title)
                //shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                view.context
                    .startActivity(Intent.createChooser(shareIntent, "Share News With"))
            }
        }

        fun bindTo(currentNews: Article) {
            mNewsTitleText.text = currentNews.title
            mAuthorTitle.text = currentNews.author
            mDescription.text = currentNews.description
//                Html.fromHtml(currentNews.description, Html.FROM_HTML_MODE_LEGACY)
//                    .toString()

            // Load the images into the ImageView using the Glide library.
            Glide.with(mContext).load(currentNews.urlToImage).into(mNewsImage)
        }
    }
}