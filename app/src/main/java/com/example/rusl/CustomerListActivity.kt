package com.example.rusl

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CustomersListActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var customerAdapter: CustomerAdapter

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customers_list)

        recyclerView = findViewById(R.id.recyclerViewCustomers)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val customerLists = mutableListOf(
            Customer(1, "Даня", "Бігановський", "0953555021")
        )

        customerAdapter = CustomerAdapter(customerLists)

        recyclerView.adapter = customerAdapter

        val buttonAddCustomers: Button = findViewById(R.id.buttonAddCustomers)
        buttonAddCustomers.setOnClickListener {
            val dialog = AddCustomer { dish ->
                customerAdapter.addItem(dish)
            }
            dialog.show(supportFragmentManager, "AddDishDialog")
        }
    }
}
