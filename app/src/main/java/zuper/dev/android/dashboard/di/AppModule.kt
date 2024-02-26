package zuper.dev.android.dashboard.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import zuper.dev.android.dashboard.data.DataRepository
import zuper.dev.android.dashboard.data.remote.ApiDataSource

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideDataRepository(apiDataSource: ApiDataSource): DataRepository {
        return DataRepository(apiDataSource)
    }

    @Provides
    fun provideApiDataSource(): ApiDataSource {
        return ApiDataSource()
    }
}