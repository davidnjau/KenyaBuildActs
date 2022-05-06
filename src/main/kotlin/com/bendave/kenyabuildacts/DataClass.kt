package com.bendave.kenyabuildacts

import com.fasterxml.jackson.annotation.JsonProperty

data class Results(val code: Int, val details: Any)

data class ResponseMessage(val details: Any)

data class DbActs(
    @JsonProperty("actName")
    val actName: String)

data class DbActDetails(
    @JsonProperty("actId")
    val actId: String ,
    @JsonProperty("name")
    val name: String ,
    @JsonProperty("desc")
    val desc: String?

    )