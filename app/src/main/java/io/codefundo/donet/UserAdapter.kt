package io.codefundo.donet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*


class UserAdapter(private var items: ArrayList<User>): RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = items[position]
        holder.txtName.text = user.name
        holder.txtComment.text = user.comment
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.user_list_row, parent, false)

        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(row: View) : RecyclerView.ViewHolder(row) {
        val txtName: TextView = row.findViewById(R.id.txtName)
        val txtComment: TextView = row.findViewById(R.id.txtComment)
    }
}