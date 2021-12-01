import com.google.gson.annotations.SerializedName

/*
Copyright (c) 2021 Kotlin Data Classes Generated from JSON powered by http://www.json2kotlin.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

For support, please feel free to contact me at https://www.linkedin.com/in/syedabsar */


data class Eras_s (

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