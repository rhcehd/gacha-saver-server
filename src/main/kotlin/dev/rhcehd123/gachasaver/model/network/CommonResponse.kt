package dev.rhcehd123.gachasaver.model.network

data class CommonResponse(
    val data: Any,
    val msg: String,
) {
    data class Builder(
        private var data: Any = "",
        private var msg: String = "",
    ) {
        fun build() = CommonResponse(data, msg)
        fun data(data: Any) = apply { this.data = data }
        fun msg(msg: String) =  apply { this.msg = msg }
    }
}