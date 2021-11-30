import com.google.gson.annotations.SerializedName


data class Category (

	@SerializedName("id") val id : Int,
	@SerializedName("category") val category : String
)