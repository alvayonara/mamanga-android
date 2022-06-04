package com.alvayonara.mamanga.feature.ui.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.alvayonara.mamanga.common.base.BaseFragment
import com.alvayonara.mamanga.core.data.domain.model.manga.Genre
import com.alvayonara.mamanga.core.data.domain.model.manga.Result
import com.alvayonara.mamanga.core.data.domain.model.top.Top
import com.alvayonara.mamanga.core.ui.dashboard.DashboardController
import com.alvayonara.mamanga.feature.databinding.FragmentDashboardBinding

class DashboardFragment : BaseFragment<FragmentDashboardBinding>() {

    private val dashboardController: DashboardController by lazy {
        DashboardController(
            requireActivity()
        )
    }

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDashboardBinding
        get() = FragmentDashboardBinding::inflate

    override fun setup() {
        setupRecyclerView()
        setupView()
    }

    override fun inject() {
    }

    override fun setupRecyclerView() {
        binding.rvDashboard.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            setController(dashboardController)
        }
    }

    override fun setupView() {
        dashboardController.setTop(Top("Alva Yonara Puramandya", "", "Good Night"))

        val newReleaseList = mutableListOf(
            Result(
                genres = listOf(
                    Genre(
                        id = 1,
                        name = "Action"
                    )
                ),
                id = "1",
                image = "https://media.kitsu.io/manga/poster_images/38886/medium.jpg",
                name = "Deaimon",
                synopsis = "Nagomu Irino returns to his Kyoto home for the first time in ten years when his father is hospitalized. Nagomu is eager to take over Ryokushou, the family's Japanese sweet shop, but he's instead asked to be a father figure to Itsuka Yukihira, the girl everyone calls the successor. (Source: Manga Translation Battle)",
                updated_chapter = "10"
            ),
            Result(
                genres = listOf(
                    Genre(
                        id = 1,
                        name = "Action"
                    )
                ),
                id = "1",
                image = "https://media.kitsu.io/manga/poster_images/38886/medium.jpg",
                name = "Deaimon",
                synopsis = "Nagomu Irino returns to his Kyoto home for the first time in ten years when his father is hospitalized. Nagomu is eager to take over Ryokushou, the family's Japanese sweet shop, but he's instead asked to be a father figure to Itsuka Yukihira, the girl everyone calls the successor. (Source: Manga Translation Battle)",
                updated_chapter = "10"
            ),
            Result(
                genres = listOf(
                    Genre(
                        id = 1,
                        name = "Action"
                    )
                ),
                id = "1",
                image = "https://media.kitsu.io/manga/poster_images/38886/medium.jpg",
                name = "Deaimon",
                synopsis = "Nagomu Irino returns to his Kyoto home for the first time in ten years when his father is hospitalized. Nagomu is eager to take over Ryokushou, the family's Japanese sweet shop, but he's instead asked to be a father figure to Itsuka Yukihira, the girl everyone calls the successor. (Source: Manga Translation Battle)",
                updated_chapter = "10"
            ),
            Result(
                genres = listOf(
                    Genre(
                        id = 1,
                        name = "Action"
                    )
                ),
                id = "1",
                image = "https://media.kitsu.io/manga/poster_images/38886/medium.jpg",
                name = "Deaimon",
                synopsis = "Nagomu Irino returns to his Kyoto home for the first time in ten years when his father is hospitalized. Nagomu is eager to take over Ryokushou, the family's Japanese sweet shop, but he's instead asked to be a father figure to Itsuka Yukihira, the girl everyone calls the successor. (Source: Manga Translation Battle)",
                updated_chapter = "10"
            ),
            Result(
                genres = listOf(
                    Genre(
                        id = 1,
                        name = "Action"
                    )
                ),
                id = "1",
                image = "https://media.kitsu.io/manga/poster_images/38886/medium.jpg",
                name = "Deaimon",
                synopsis = "Nagomu Irino returns to his Kyoto home for the first time in ten years when his father is hospitalized. Nagomu is eager to take over Ryokushou, the family's Japanese sweet shop, but he's instead asked to be a father figure to Itsuka Yukihira, the girl everyone calls the successor. (Source: Manga Translation Battle)",
                updated_chapter = "10"
            ),
            Result(
                genres = listOf(
                    Genre(
                        id = 1,
                        name = "Action"
                    )
                ),
                id = "1",
                image = "https://media.kitsu.io/manga/poster_images/38886/medium.jpg",
                name = "Deaimon",
                synopsis = "Nagomu Irino returns to his Kyoto home for the first time in ten years when his father is hospitalized. Nagomu is eager to take over Ryokushou, the family's Japanese sweet shop, but he's instead asked to be a father figure to Itsuka Yukihira, the girl everyone calls the successor. (Source: Manga Translation Battle)",
                updated_chapter = "10"
            )
        )
        dashboardController.setNewRelease(newReleaseList)
        dashboardController.setContinueRead(newReleaseList)
        dashboardController.setUpdate(newReleaseList)
        dashboardController.setMostPopular(newReleaseList)
        dashboardController.setReleaseSoon(newReleaseList)
    }

//    override fun getViewModel(): BaseViewModel {
//        TODO("Not yet implemented")
//    }
}