package com.sdk.starwars.domain.interactor.usecase

import com.sdk.starwars.domain.interactor.base.UseCase
import com.sdk.starwars.domain.model.PeopleDto
import com.sdk.starwars.domain.model.Result
import com.sdk.starwars.domain.repository.PeopleRepository
import javax.inject.Inject

internal class GetPeopleUseCase @Inject constructor(
    private val repo: PeopleRepository
) : UseCase<Result<PeopleDto>, GetPeopleUseCase.Params>() {

    override suspend fun execute(params: Params?): Result<PeopleDto> {
        params!!
        return repo.getPeople(peopleId = params.peopleId)
    }

    data class Params(
        val peopleId: Int
    )
}