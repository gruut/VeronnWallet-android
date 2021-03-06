package io.tethys.tethyswallet.data.grpc.message.request

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.ObjectMapper
import io.tethys.tethyswallet.data.grpc.message.TypeMac
import io.tethys.tethyswallet.data.grpc.message.TypeMsg
import io.tethys.tethyswallet.data.local.PreferenceHelper
import io.tethys.tethyswallet.ui.BaseApp
import io.tethys.tethyswallet.utils.TethysConfigs

data class MsgSsig constructor(
    @get:JsonProperty("block")
    val block: Block,
    @get:JsonProperty("signer")
    val signer: Signer
) : MsgPacker() {

    data class Block(
        @get:JsonProperty("id") // __BASE58_256__
        val id: String
    )

    data class Signer(
        @get:JsonProperty("id") // __BASE58_256__
        val id: String,
        @get:JsonProperty("sig") // __BASE64_SIG__
        val sig: String
    )

    @JsonIgnore
    override var sharedSecretKey: ByteArray? = null

    private val prefHelper: PreferenceHelper = BaseApp.prefHelper

    init {
        setHeader()
    }

    override fun setHeader() {
        this.header.msgType = TypeMsg.MSG_SSIG
        this.header.macType = TypeMac.HMAC
        this.header.worldId = prefHelper.worldId
        this.header.chainId = prefHelper.chainId
        this.header.sender = signer.id
        this.header.totalLength = TethysConfigs.HEADER_LENGTH + serialize().size
    }
}