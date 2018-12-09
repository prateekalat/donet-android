package io.codefundo.donet.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.codefundo.donet.R
import io.codefundo.donet.domain.Resource


class BeneficiaryAdapter : RecyclerView.Adapter<BeneficiaryAdapter.ViewHolder>() {

    private val items = mutableListOf<Beneficiary>()

    fun updateUsers(resource: Resource) {
        when (resource) {
            is Resource.Success<*> -> {
                // Check if the list is a List<Beneficiary>
                // Kotlin can't know Generic types at runtime so this is one way to check
                if (resource.data is List<*>) {
                    // Filtering all objects in the list that are not of type Beneficiary
                    val listOfBeneficiaries: List<Beneficiary> = resource.data.filterIsInstance<Beneficiary>()
                    if (listOfBeneficiaries.size == resource.data.size) {
                        items.clear()
                        items.addAll(listOfBeneficiaries)
                        notifyDataSetChanged()
                    }
                }
            }

            is Resource.Failure -> {
                //TODO Error handling
            }

            is Resource.Loading -> {
                // TODO Handle loading
            }
        }

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val beneficiary = items[position]
        holder.txtName.text = beneficiary.name
        holder.txtComment.text = beneficiary.balance.toString()
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