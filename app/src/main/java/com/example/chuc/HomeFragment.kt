package com.example.chuc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {
    
    private lateinit var newsRecyclerView: RecyclerView
    private lateinit var newsAdapter: NewsAdapter
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupRecyclerView(view)
        loadNews()
    }
    
    private fun setupRecyclerView(view: View) {
        newsRecyclerView = view.findViewById(R.id.news_recycler_view)
        newsAdapter = NewsAdapter(getNewsList())
        
        newsRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = newsAdapter
        }
    }
    
    private fun loadNews() {
        // Здесь можно загрузить новости из API или базы данных
        val newsList = getNewsList()
        newsAdapter.updateNews(newsList)
    }
    
    private fun getNewsList(): List<News> {
        return listOf(
            News(
                id = 1,
                title = "Открытие нового учебного года",
                description = "1 сентября состоялось торжественное открытие нового учебного года. Студентов поздравили с началом учебы и пожелали успехов в освоении новых знаний.",
                imageUrl = "",
                date = "01.09.2025",
                isImportant = true
            ),
            News(
                id = 2,
                title = "Научная конференция студентов",
                description = "15 октября пройдет ежегодная научная конференция студентов. Приглашаем всех желающих принять участие и представить свои исследовательские работы.",
                imageUrl = "",
                date = "15.10.2025",
                isImportant = false
            ),
            News(
                id = 3,
                title = "Спортивные соревнования",
                description = "В университете проходят межфакультетские спортивные соревнования. Поддержите свою команду!",
                imageUrl = "",
                date = "20.09.2025",
                isImportant = false
            ),
            News(
                id = 4,
                title = "Стипендиальная программа",
                description = "Объявлен конкурс на получение повышенной стипендии. Подробности на сайте университета.",
                imageUrl = "",
                date = "18.09.2025",
                isImportant = true
            )
        )
    }
    
    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }
}
