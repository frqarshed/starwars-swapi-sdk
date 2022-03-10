package com.sdk.starwars.domain.interactor.usecase

import com.sdk.starwars.domain.interactor.base.UseCase
import com.sdk.starwars.domain.model.AllPeopleDto
import com.sdk.starwars.domain.model.Result
import com.sdk.starwars.domain.repository.PeopleRepository
import javax.inject.Inject

internal class SearchPeopleUseCase @Inject constructor(
    private val repo: PeopleRepository
) : UseCase<Result<AllPeopleDto>, SearchPeopleUseCase.Params>() {

    override suspend fun execute(params: Params?): Result<AllPeopleDto> {
        params!!
        return repo.searchPeople(name = params.name)
    }

    data class Params(
        val name: String
    )
}