package com.example.practiceapplication.MainFeature.Alerts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.practiceapplication.R
import kotlinx.android.synthetic.main.alert_view_holder.view.*

class AlertAdaptor(val alerts: ArrayList<Alert> = arrayListOf()): RecyclerView.Adapter<AlertAdaptor.AlertHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlertHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.alert_view_holder, parent, false)
        return AlertHolder(v)
    }

    override fun getItemCount(): Int = alerts.size


    override fun onBindViewHolder(holder: AlertHolder, position: Int) {
        val a = alerts[position]
        holder.description.text = a.description
    }

    inner class AlertHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val description: TextView = itemView.description
        val bt1: Button = itemView.btn1
        val bt2: Button = itemView.btn2

    }
}