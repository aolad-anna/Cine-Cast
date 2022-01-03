import com.google.gson.annotations.SerializedName


data class Day (

	@SerializedName("id") val id : Int,
	@SerializedName("movie_img") val movie_img : String,
	@SerializedName("movie_img_lands") val movie_img_lands : String,
	@SerializedName("movie_name") val movie_name : String,
	@SerializedName("playUrl") val playUrl : String,
	@SerializedName("release_date") val release_date : String,
	@SerializedName("release_year") val release_year : String,
	@SerializedName("review_star") val review_star : String,
	@SerializedName("duration") val duration : String,
	@SerializedName("age") val age : String,
	@SerializedName("story") val story : String,
	@SerializedName("director") val director : String,
	@SerializedName("writer") val writer : String,
	@SerializedName("star") val star : String,
	@SerializedName("category_1") val category_1 : String,
	@SerializedName("category_2") val category_2 : String,
	@SerializedName("category_3") val category_3 : String
)