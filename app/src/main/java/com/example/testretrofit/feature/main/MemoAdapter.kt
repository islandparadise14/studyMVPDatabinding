package com.example.testretrofit.feature.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testretrofit.R
import com.example.testretrofit.data.reponse.MemoResponse
import kotlinx.android.synthetic.main.item_memo.view.*

class MemoAdapter(private var memoList: ArrayList<MemoResponse>, private val clicked: (Int) -> Unit, private val longClicked: (Int) -> Unit) : RecyclerView.Adapter<MemoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoViewHolder {
        val inflater = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView = inflater.inflate(R.layout.item_memo, parent, false)
        return MemoViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return memoList.size
    }

    override fun onBindViewHolder(holder: MemoViewHolder, position: Int) {
        holder.bind(memoList[position].id, memoList[position].title, memoList[position].content, clicked, longClicked)
    }

}

class MemoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bind(memoId: Int, title: String, content: String, clicked: (Int) -> Unit, longClicked: (Int) -> Unit) {
        itemView.itemTitle.text = title
        itemView.itemContent.text = content
        itemView.setOnClickListener {
            clicked(memoId)
        }
        itemView.setOnLongClickListener {
            longClicked(memoId)
            return@setOnLongClickListener true
        }
    }
}