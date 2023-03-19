package com.example.fuze.network.paging

import androidx.paging.*
import com.example.fuze.network.api.MatchesApi
import com.example.fuze.network.model.MatchesResponse
import retrofit2.HttpException
import javax.inject.Inject

class MatchesRemoteMediator @Inject constructor(
    private val matchesApi: MatchesApi
): PagingSource<Int, MatchesResponse>() {

    override suspend fun load(params: PagingSource.LoadParams<Int>): PagingSource.LoadResult<Int, MatchesResponse> {
        return try {
            val currentPage = params.key ?: 1
            val response = matchesApi.getMatches(currentPage, 10)

            LoadResult.Page(
                data = response,
                prevKey = if (currentPage == 1) null else -1,
                nextKey = currentPage.plus(1)
            )

        } catch (e: Exception) {
            LoadResult.Error(e)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }

    }

    override fun getRefreshKey(state: PagingState<Int, MatchesResponse>): Int? {
        return null
    }
}