package io.tethys.tethyswallet.data.tethys.queries

import com.fasterxml.jackson.annotation.JsonProperty

class GetChain(
    override val type: QueryType = QueryType.CHAIN_GET,
    override val where: Request? = null
) : QueryData() {
    data class Result(
        @JsonProperty("chain_id") val chainId: String,
        @JsonProperty("created_time") val createdTime: String,
        @JsonProperty("creator_id") val creatorId: String,
        @JsonProperty("creator_pk") val creatorPk: String,
        @JsonProperty("allow_custom_contract") val allowCustomContract: String,
        @JsonProperty("allow_oracle") val allowOracle: String,
        @JsonProperty("allow_tag") val allowTag: String,
        @JsonProperty("allow_heavy_contract") val allowHeavyContract: String
    ) : QueryData.Result
}