package com.crypto.mainmenu.network.entity
import com.google.gson.annotations.SerializedName

data class TopTierData(
    @SerializedName("Message")
    val message: String,
    @SerializedName("Type")
    val type: Int,
    @SerializedName("MetaData")
    val metaData: MetaData,
    @SerializedName("SponsoredData")
    val sponsoredData: List<SponsoredData>,
    @SerializedName("Data")
    val `data`: List<Data>,
    @SerializedName("RateLimit")
    val rateLimit: RateLimit,
    @SerializedName("HasWarning")
    val hasWarning: Boolean
)

data class MetaData(
    @SerializedName("Count")
    val count: Int
)

data class SponsoredData(
    @SerializedName("CoinInfo")
    val coinInfo: CoinInfo
)

data class Data(
    @SerializedName("CoinInfo")
    val coinInfo: CoinInfo,
    @SerializedName("RAW")
    val rAW: RAW,
    @SerializedName("DISPLAY")
    val dISPLAY: DISPLAY?
)

class RateLimit(
)

data class CoinInfo(
    @SerializedName("Id")
    val id: String,
    @SerializedName("Name")
    val name: String,
    @SerializedName("FullName")
    val fullName: String
)

data class Rating(
    @SerializedName("Weiss")
    val weiss: Weiss
)

data class Weiss(
    @SerializedName("Rating")
    val rating: String,
    @SerializedName("TechnologyAdoptionRating")
    val technologyAdoptionRating: String,
    @SerializedName("MarketPerformanceRating")
    val marketPerformanceRating: String
)

data class RAW(
    @SerializedName("USD")
    val uSD: USD
)

data class DISPLAY(
    @SerializedName("USD")
    val uSD: USDX?
)

data class RatingX(
    @SerializedName("Weiss")
    val weiss: WeissX
)

data class WeissX(
    @SerializedName("Rating")
    val rating: String,
    @SerializedName("TechnologyAdoptionRating")
    val technologyAdoptionRating: String,
    @SerializedName("MarketPerformanceRating")
    val marketPerformanceRating: String
)

data class USD(
    @SerializedName("MARKET")
    val mARKET: String,
    @SerializedName("PRICE")
    val pRICE: Double,
    @SerializedName("LASTUPDATE")
    val lASTUPDATE: Long,
    @SerializedName("LASTVOLUME")
    val lASTVOLUME: Double,
    @SerializedName("LASTVOLUMETO")
    val lASTVOLUMETO: Float,
    @SerializedName("CHANGEDAY")
    val cHANGEDAY: Float,
    @SerializedName("CHANGEPCTDAY")
    val cHANGEPCTDAY: Float,
    @SerializedName("CHANGEHOUR")
    val cHANGEHOUR: Float,
    @SerializedName("IMAGEURL")
    val iMAGEURL: String
)

data class USDX(
    @SerializedName("MARKET")
    val mARKET: String,
    @SerializedName("PRICE")
    val pRICE: String,
    @SerializedName("LASTUPDATE")
    val lASTUPDATE: String,
    @SerializedName("LASTVOLUME")
    val lASTVOLUME: String,
    @SerializedName("LASTVOLUMETO")
    val lASTVOLUMETO: String,
     @SerializedName("CHANGEDAY")
    val cHANGEDAY: String,
    @SerializedName("CHANGEPCTDAY")
    val cHANGEPCTDAY: String,
    @SerializedName("CHANGEHOUR")
    val cHANGEHOUR: String
)