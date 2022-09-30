package by.softteco.nmisko.data.repository

import android.util.Log
import by.softteco.nmisko.data.remote.ResultWrapper
import retrofit2.Response
import java.io.IOException

open class BaseRepository {

    suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>, errorMessage: String): T? {

        val result : ResultWrapper<T> = safeApiResult(call,errorMessage)
        var data : T? = null

        when(result) {
            is ResultWrapper.Success ->
                data = result.data
            is ResultWrapper.Error -> {
                Log.d("1.DataRepository", "$errorMessage & Exception - ${result.exception}")
            }
        }

        return data

    }

    private suspend fun <T: Any> safeApiResult(call: suspend ()-> Response<T>, errorMessage: String) : ResultWrapper<T>{
        val response = call.invoke()
        if(response.isSuccessful) return ResultWrapper.Success(response.body()!!)

        return ResultWrapper.Error(IOException("Error Occurred during getting safe Api result, Custom ERROR - $errorMessage"))
    }
}