package com.ahmad.aghazadeh.readerapp.screens.login

data class LoadingState(val status: Status) {

    companion object {
        val IDLE = LoadingState(Status.IDLE)
        val LOADING = LoadingState(Status.LOADING)
        val SUCCESS = LoadingState(Status.SUCCESS)
        val FAILED = LoadingState(Status.FAILED)
    }
    enum class Status {
        SUCCESS,
        FAILED,
        LOADING,
        IDLE
    }

}
