package com.kawal.mvvm.injection

import androidx.room.Room
import com.kawal.mvvm.data.database.AppDatabase
import com.kawal.mvvm.data.repository.PostRepository
import com.kawal.mvvm.data.repository.UserRepository
import com.kawal.mvvm.ui.user.UserDetailViewModel
import com.kawal.mvvm.ui.user.UserListViewModel
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.kawal.mvvm.BuildConfig
import com.kawal.mvvm.data.network.*
import com.kawal.mvvm.ui.front_menu.FrontMenuViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object Modules {
    private val networkModule = module {
        single {
            val retrofit: Retrofit = get()
            retrofit.create(UserApi::class.java)
        }
        single {
            val retrofit: Retrofit = get()
            retrofit.create(PostApi::class.java)
        }
        single {
            val retrofit: Retrofit = get()
            retrofit.create(DistrictApi::class.java)
        }
        single {
            val retrofit: Retrofit = get()
            retrofit.create(VillageApi::class.java)
        }
        single {
            val retrofit: Retrofit = get()
            retrofit.create(VoterApi::class.java)
        }
        single {
            Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
        }
    }

    private val databaseModule = module {
        single {
            val db: AppDatabase = get()
            db.userDao()
        }
        single {
            val db: AppDatabase = get()
            db.postDao()
        }
        single {
            Room.databaseBuilder(get(), AppDatabase::class.java, "posts")
                .fallbackToDestructiveMigration()
                .build()
        }
    }

    private val repositoryModule = module {
        single { UserRepository(get(), get()) }
        single { PostRepository(get(), get()) }
    }

    private val viewModelModule = module {
        viewModel { UserListViewModel(get()) }
        viewModel { UserDetailViewModel(get(), get()) }
        viewModel { FrontMenuViewModel() }
    }

    val all: List<Module> = listOf(
        databaseModule,
        viewModelModule,
        networkModule,
        repositoryModule
    )
}