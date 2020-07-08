package beans.prj.newsapp.data.model

import java.util.*

class News {
    var status: String? = null
    var code: String? = null
    var message: String? = null
    var articles: ArrayList<Article>? = null
    var totalResults = 0
}