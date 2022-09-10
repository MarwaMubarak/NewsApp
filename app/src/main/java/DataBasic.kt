package com.example.newsapp
import androidx.room.*

@Entity
data class Articlee(
    @PrimaryKey(autoGenerate = true) val title: String = "",
    val url: String?,
    val image: String?,
    val description:String?
)

@Dao
interface ArticleDao {
    @Query("SELECT * FROM Articlee")
    fun getArticles(): List<Articlee?>

    @Insert
    fun insert(article: NewsModel)
}

@Database(entities = [Articlee::class], version = 1)
abstract class DataBasic : RoomDatabase() {
    abstract fun getArticleDao(): ArticleDao
}