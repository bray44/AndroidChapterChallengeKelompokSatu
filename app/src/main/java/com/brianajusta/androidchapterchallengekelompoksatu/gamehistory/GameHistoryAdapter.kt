package com.brianajusta.androidchapterchallengekelompoksatu.gamehistory

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.brianajusta.androidchapterchallengekelompoksatu.GameHistoryDataClass
import com.brianajusta.androidchapterchallengekelompoksatu.databinding.GameHistoryItemBinding

class GameHistoryAdapter(private val data: MutableList<GameHistoryDataClass> = mutableListOf())
    : RecyclerView.Adapter<GameHistoryAdapter.GameHistoryViewHolder>() {

    inner class GameHistoryViewHolder(val binding: GameHistoryItemBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameHistoryViewHolder {
        val binding = GameHistoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GameHistoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GameHistoryViewHolder, position: Int) {
       val item = data[position]
        holder.binding.tvHistoryPlayerOneName.text = item.playerOneName
        holder.binding.ivHistoryPlayerOneItem.setImageResource(item.playerOneItem)
        holder.binding.tvHistoryPlayerTwoName.text = item.playerTwoName
        holder.binding.ivHistoryPlayerTwoItem.setImageResource(item.playerTwoItem)
        holder.binding.tvGameResultHistoryItem.text = item.gameResult
    }

    override fun getItemCount(): Int {
        return data.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addAll(values: List<GameHistoryDataClass>) {
        data.addAll(values)
        notifyDataSetChanged()
    }


}