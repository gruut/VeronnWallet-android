package io.tethys.tethyswallet.data.grpc.message.response

import com.fasterxml.jackson.annotation.JsonProperty

data class MsgAccept(
    @JsonProperty("time") // __TIMESTAMP__
    override val time: String,
    @JsonProperty("merger") // __BASE58_256__
    override val merger: String,
    @JsonProperty("val") // __BOOLEAN__
    val result: Boolean
) : MsgBody