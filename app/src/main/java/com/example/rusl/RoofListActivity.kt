package com.example.rusl

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RoofListActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var apartamentsAdapter: RoofAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_roof_list)

        recyclerView = findViewById(R.id.recyclerViewApartaments)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val apartamentsLists = mutableListOf(
            Roof(1, "Черепиця", "200", "1000$", "photo_url_1", "Міцна"),

        )

        apartamentsAdapter = RoofAdapter(apartamentsLists)

        recyclerView.adapter = apartamentsAdapter

        val buttonAddRestaurant: Button = findViewById(R.id.buttonAddApartaments)
        buttonAddRestaurant.setOnClickListener {
            val dialog = AddRoof { restaurant ->
                apartamentsAdapter.addItem(restaurant)
            }
            dialog.show(supportFragmentManager, "AddRestaurantDialog")
        }
    }
}
