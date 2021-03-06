# Pigeon

A MVVM architecture based News App in android, developed with Kotlin, Retrofit, Navigation Components, Shimmer for ProgressBar

<img src="https://github.com/PriyabrataNaskar/Pigeon/blob/master/app/src/main/res/raw/pigeon_splash_image.gif" alt="Pigeon Logo" width="300"/>

## In Pigeon you can find top news
 
![HOME PAGE](https://github.com/PriyabrataNaskar/NewsApp/blob/master/screenshots/Home%20Page%20(Horizontal).png)

![News Page](https://github.com/PriyabrataNaskar/NewsApp/blob/master/screenshots/News%20Detail%20Page%20(Horizontal).png)

![Error Page](https://github.com/PriyabrataNaskar/NewsApp/blob/master/screenshots/IMG_20220406_180150.jpg)

### See the video [here](https://youtu.be/TT4UXP6BIJc)

### In this News App - Pigeon You can : 

- Skim through Top Headlines in a RecyclerView
- Open Each News and Share that news with your friend
- See a nice animated dragon who is showing you the error

### You can view the design in [Figma Prototype](https://www.figma.com/proto/0hqmot7drKti1znfOZV4Q1/News-App?node-id=6%3A81&scaling=scale-down&page-id=0%3A1&starting-point-node-id=6%3A81)

All the news are fetched from the news api. If you're cloning this project in your own machine don't forget to modify the ```API KEY```. You will get a new API Key on the [NEWS API](https://newsapi.org) website

All the response you will get ion JSON format.

### Example response
```
{
  "status": "ok",
    "sources": [
                  {
                    "id": "australian-financial-review",
                    "name": "Australian Financial Review",
                    "description": "The Australian Financial Review reports the latest news from business, finance, investment and politics, updated in real time. It has a reputation for independent, award-winning journalism and is essential reading for the business and investor community.",
                     "url": "http://www.afr.com",
                     "category": "business",
                     "language": "en",
                     "country": "au"
                    },
                    {
                      "id": "bloomberg",
                      "name": "Bloomberg",
                      "description": "Bloomberg delivers business and markets news, data, analysis, and video to the world, featuring stories from Businessweek and Bloomberg News.",
                      "url": "http://www.bloomberg.com",
                      "category": "business",
                      "language": "en",
                      "country": "us"
                      },
                      {
                      "id": "business-insider",
                      "name": "Business Insider",
                      "description": "Business Insider is a fast-growing business site with deep financial, media, tech, and other industry verticals. Launched in 2007, the site is now the largest business news site on the web.",
                      "url": "http://www.businessinsider.com",
                      "category": "business",
                      "language": "en",
                      "country": "us"
                      }
                ]
}


```

### I'm using 

- Navigation Components for navigating between fragments
- Safe Args to pass data b/w fragments
- The entire application is in Kotlin.
- Using Single Activity Arch.
- MVVM Architecture
- [Glide](https://github.com/bumptech/glide) to load images over the internet
- [Shimmer](https://github.com/facebook/shimmer-android) Library by Facebook for loading effect
- [Retrofit](https://square.github.io/retrofit/) for network calls in background thread
- Lottie for playing animation on the error screen or when the Internet is Unavailable
- [GSON Library](https://github.com/google/gson) to parse the JSON
 
## Acknowledgements

Thanks to these projects and libraries:

## **Libraries**

- [Retrofit](https://square.github.io/retrofit/)
- [Glide](https://github.com/bumptech/glide)
- [GSON Library](https://github.com/google/gson)
- [MDC](https://material.io/develop/android/docs/getting-started)
- [Lottie](https://github.com/airbnb/lottie-android)
- [Shimmer](https://github.com/facebook/shimmer-android)
