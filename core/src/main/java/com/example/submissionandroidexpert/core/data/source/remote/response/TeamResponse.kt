package com.example.submissionandroidexpert.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class TeamResponse(

	@field:SerializedName("teams")
	val teams: List<TeamsItem>
)

data class TeamsItem(

	@field:SerializedName("intStadiumCapacity")
	val intStadiumCapacity: String,

	@field:SerializedName("strTeamShort")
	val strTeamShort: String,

	@field:SerializedName("idLeague3")
	val idLeague3: String,

	@field:SerializedName("idESPN")
	val idESPN: String,

	@field:SerializedName("idLeague2")
	val idLeague2: String,

	@field:SerializedName("idLeague5")
	val idLeague5: Any,

	@field:SerializedName("strSport")
	val strSport: String,

	@field:SerializedName("idLeague4")
	val idLeague4: String,

	@field:SerializedName("idLeague7")
	val idLeague7: Any,

	@field:SerializedName("strDescriptionCN")
	val strDescriptionCN: Any,

	@field:SerializedName("idLeague6")
	val idLeague6: Any,

	@field:SerializedName("intLoved")
	val intLoved: String,

	@field:SerializedName("idLeague")
	val idLeague: String,

	@field:SerializedName("strBadge")
	val strBadge: String,

	@field:SerializedName("strLocation")
	val strLocation: String,

	@field:SerializedName("strDescriptionSE")
	val strDescriptionSE: Any,

	@field:SerializedName("strDescriptionJP")
	val strDescriptionJP: String,

	@field:SerializedName("strFanart1")
	val strFanart1: String,

	@field:SerializedName("strDescriptionFR")
	val strDescriptionFR: String,

	@field:SerializedName("strFanart2")
	val strFanart2: String,

	@field:SerializedName("strFanart3")
	val strFanart3: String,

	@field:SerializedName("strFanart4")
	val strFanart4: String,

	@field:SerializedName("strDescriptionNL")
	val strDescriptionNL: Any,

	@field:SerializedName("strCountry")
	val strCountry: String,

	@field:SerializedName("strRSS")
	val strRSS: String,

	@field:SerializedName("strDescriptionRU")
	val strDescriptionRU: String,

	@field:SerializedName("strLogo")
	val strLogo: String,

	@field:SerializedName("strDescriptionNO")
	val strDescriptionNO: String,

	@field:SerializedName("strDescriptionES")
	val strDescriptionES: String,

	@field:SerializedName("intFormedYear")
	val intFormedYear: String,

	@field:SerializedName("strBanner")
	val strBanner: String,

	@field:SerializedName("strInstagram")
	val strInstagram: String,

	@field:SerializedName("strDescriptionIT")
	val strDescriptionIT: String,

	@field:SerializedName("idTeam")
	val idTeam: String,

	@field:SerializedName("strDescriptionEN")
	val strDescriptionEN: String,

	@field:SerializedName("strTeamAlternate")
	val strTeamAlternate: String,

	@field:SerializedName("strWebsite")
	val strWebsite: String,

	@field:SerializedName("strYoutube")
	val strYoutube: String,

	@field:SerializedName("strDescriptionIL")
	val strDescriptionIL: Any,

	@field:SerializedName("idAPIfootball")
	val idAPIfootball: String,

	@field:SerializedName("strLocked")
	val strLocked: String,

	@field:SerializedName("strColour3")
	val strColour3: String,

	@field:SerializedName("strEquipment")
	val strEquipment: String,

	@field:SerializedName("strTeam")
	val strTeam: String,

	@field:SerializedName("strTwitter")
	val strTwitter: String,

	@field:SerializedName("strDescriptionHU")
	val strDescriptionHU: Any,

	@field:SerializedName("strColour2")
	val strColour2: String,

	@field:SerializedName("strColour1")
	val strColour1: String,

	@field:SerializedName("strGender")
	val strGender: String,

	@field:SerializedName("strDivision")
	val strDivision: Any,

	@field:SerializedName("idVenue")
	val idVenue: String,

	@field:SerializedName("strStadium")
	val strStadium: String,

	@field:SerializedName("strFacebook")
	val strFacebook: String,

	@field:SerializedName("strLeague2")
	val strLeague2: String,

	@field:SerializedName("strLeague3")
	val strLeague3: String,

	@field:SerializedName("strLeague4")
	val strLeague4: String,

	@field:SerializedName("strLeague5")
	val strLeague5: String,

	@field:SerializedName("strDescriptionPT")
	val strDescriptionPT: String,

	@field:SerializedName("strLeague6")
	val strLeague6: String,

	@field:SerializedName("strDescriptionDE")
	val strDescriptionDE: String,

	@field:SerializedName("strLeague7")
	val strLeague7: String,

	@field:SerializedName("strLeague")
	val strLeague: String,

	@field:SerializedName("strKeywords")
	val strKeywords: String,

	@field:SerializedName("strDescriptionPL")
	val strDescriptionPL: Any
)
